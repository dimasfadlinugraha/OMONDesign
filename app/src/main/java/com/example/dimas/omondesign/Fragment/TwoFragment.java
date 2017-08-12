package com.example.dimas.omondesign.Fragment;

/**
 * Created by Dimas on 26/07/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.dimas.omondesign.R;
import com.example.dimas.omondesign.Slave;
import com.example.dimas.omondesign.SlaveAdapter;
import com.example.dimas.omondesign.MainActivity;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.example.dimas.omondesign.Data;

public class TwoFragment extends Fragment {

    private Data data;
    private RecyclerView recyclerView;
    public SlaveAdapter adapter;
    private List<Slave> slaveList;
    public TwoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        String x = ((MainActivity)getActivity()).x;
        slaveList = new ArrayList<>();
        data = new Data(getActivity());
        slaveList = data.baseData();
        adapter = new SlaveAdapter(getActivity(), slaveList);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        ((MainActivity)getActivity()).client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                slaveList=data.newData(new String (message.getPayload()));
                adapter.swapData(slaveList);

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });

        return v;
    }
}
