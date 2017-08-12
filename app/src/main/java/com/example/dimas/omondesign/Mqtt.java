package com.example.dimas.omondesign;

import android.content.Context;

import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by dimas on 8/11/2017.
 */


public class Mqtt {
    private Context mContext;
    public MqttAndroidClient client;
    public boolean data;

    public Mqtt(Context mContext){
        this.mContext = mContext;
    }

    public MqttAndroidClient connect(){
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(mContext, "tcp://broker.hivemq.com", clientId);
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {

                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(mContext, "Connected!!", Toast.LENGTH_LONG).show();
                    subscribe();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(mContext, "Failed!!", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return client;
    }
    public void subscribe(){
        try{
            client.subscribe("SmartFarmProject/data", 0);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
}
