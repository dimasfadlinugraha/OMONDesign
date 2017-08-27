package com.example.dimas.omondesign;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import com.example.dimas.omondesign.Fragment.OneFragment;
import com.example.dimas.omondesign.Fragment.TwoFragment;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class MainActivity extends AppCompatActivity {

    public MqttAndroidClient client;
    public Mqtt mqttAdapter;
    public String x="heho";
    public boolean newData=false;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.tvAirPress);

        mqttAdapter = new Mqtt (getApplicationContext());
        client = mqttAdapter.connect();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(),"Home");
        adapter.addFragment(new TwoFragment(),"Advanced");
        viewPager.setAdapter(adapter);

    }

    public void spraySoil(View v) {
        String topic = "SmartFarmProject/perintah";
        String message = "1";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void soakSoil(View v) {
        String topic = "SmartFarmProject/perintah";
        String message = "2";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment>mFragmentList=new ArrayList<>();
        private final List<String>mFragmentTitleList=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position){
            return mFragmentList.get(position);
        }
        @Override
        public int getCount(){
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }
    public void swapHomeData(int [] newData){
        Resources res = getResources();
        final Drawable drawable1 = res.getDrawable(R.drawable.circularhum);
        final Drawable drawable2 = res.getDrawable(R.drawable.circularairpress);
        final ProgressBar mProgressHum = (ProgressBar)findViewById(R.id.circularProgressbarHum);
        final ProgressBar mProgressAirPress = (ProgressBar)findViewById(R.id.circularProgressbarAirPress);
        mProgressHum .setProgress(newData[2]);
        mProgressHum .setMax(100);
        mProgressHum .setProgressDrawable(drawable1);
        mProgressAirPress .setProgress(newData[3]);
        mProgressAirPress .setMax(100);
        mProgressAirPress .setProgressDrawable(drawable2);
        TextView textView = (TextView)findViewById(R.id.tvSoil);
        textView.setText(Integer.toString(newData[0]));
        textView = (TextView)findViewById(R.id.tvTemp);

        textView.setText(Integer.toString(newData[1])+" C");
        textView = (TextView)findViewById(R.id.tvHum);
        textView.setText(Integer.toString(newData[2]));
        textView = (TextView)findViewById(R.id.tvAirPress);
        textView.setText(Integer.toString(newData[3])+" Pa");
    }
}
