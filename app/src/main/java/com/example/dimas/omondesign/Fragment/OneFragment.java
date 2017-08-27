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
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.example.dimas.omondesign.R;


public class OneFragment extends Fragment {

    TextView textView;

    public OneFragment(){

    }

    @Override
    public void  onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstancestate){
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        Resources res = getResources();
        final Drawable drawable1 = res.getDrawable(R.drawable.circularhum);
        final Drawable drawable2 = res.getDrawable(R.drawable.circularairpress);
        final ProgressBar mProgressHum = (ProgressBar) v.findViewById(R.id.circularProgressbarHum);
        final ProgressBar mProgressAirPress = (ProgressBar) v.findViewById(R.id.circularProgressbarAirPress);
        mProgressHum .setProgress(60);
        mProgressHum .setSecondaryProgress(100);
        mProgressHum .setMax(100);
        mProgressHum .setProgressDrawable(drawable1);
        textView = (TextView) v.findViewById(R.id.tvHum);

        // TODO Data Soil,Temp,Hum sama Air Press hasil average dari Slave System yang ada di TwoFragment
        return v;
    }
}
