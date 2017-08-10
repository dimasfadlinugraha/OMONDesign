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
    TextView tv;
    private Handler handler = new Handler();

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
        Drawable drawable = res.getDrawable(R.drawable.circularhum);
        final ProgressBar mProgress = (ProgressBar) v.findViewById(R.id.circularProgressbarHum);
        mProgress.setProgress(0);
        mProgress.setSecondaryProgress(100);
        mProgress.setMax(100);
        mProgress.setProgressDrawable(drawable);

        tv = (TextView) v.findViewById(R.id.tvHum);

        // TODO Data Soil,Temp,Hum sama Air Press hasil average dari Slave System yang ada di TwoFragment

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (pStatus < 100) {
                    pStatus = 30;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");

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
