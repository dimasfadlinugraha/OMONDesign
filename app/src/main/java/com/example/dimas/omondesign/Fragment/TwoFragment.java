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
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.dimas.omondesign.R;
import com.example.dimas.omondesign.Slave;
import com.example.dimas.omondesign.SlaveAdapter;
import com.example.dimas.omondesign.MainActivity;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static android.R.id.message;

public class TwoFragment extends Fragment {


    private RecyclerView recyclerView;
    private SlaveAdapter adapter;
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

        //String data=mainActivity.x;
        slaveList = new ArrayList<>();
        adapter = new SlaveAdapter(getActivity(), slaveList);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        recylerData();
        //Glide.with(this).load(R.drawable.slavelogo).into((ImageView) v.findViewById(R.id.imageView3));
        return v;
    }

    private void recylerData() {

        Slave a;

        a = new Slave("Slave System 1", 20, 20, 40);
        slaveList.add(a);

        a = new Slave("Slave System 2", 20, 25, 30);
        slaveList.add(a);

        a = new Slave("Slave System 3", 20, 15, 20);
        slaveList.add(a);

        a = new Slave("Slave System 4", 20, 30, 34);
        slaveList.add(a);
 /*
        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        albumList.add(a);

 */
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
}
