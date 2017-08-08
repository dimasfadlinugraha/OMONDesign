package com.example.dimas.omondesign.Fragment;

/**
 * Created by Dimas on 26/07/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.dimas.omondesign.MainActivity;
import com.example.dimas.omondesign.R;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class OneFragment extends Fragment {

    int pStatus = 0;
    private Handler handler = new Handler();
    TextView tv;

    public OneFragment(){

    }

    @Override
    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstancestate){
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        final MainActivity mainActivity= new MainActivity();
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circularhum);
        final ProgressBar mProgress = (ProgressBar) v.findViewById(R.id.circularProgressbarHum);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        tv = (TextView) v.findViewById(R.id.tvHum);
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus = 30;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            tv.setText(mainActivity.x);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return v;
    }




}
