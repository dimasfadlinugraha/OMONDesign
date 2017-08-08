package com.example.dimas.omondesign.Fragment;

/**
 * Created by Dimas on 26/07/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dimas.omondesign.R;

public class ThreeFragment extends Fragment {
    public ThreeFragment(){

    }
    @Override
    public void  onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstancestate) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }
}
