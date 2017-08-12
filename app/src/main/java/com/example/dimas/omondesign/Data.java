package com.example.dimas.omondesign;

import android.content.Context;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimas on 8/12/2017.
 */

public class Data {
    private List<Slave> slaveList;
    private Context mContext;

    public Data(){

    }
    public Data(Context context){
        this.mContext=context;
    }
    public List<Slave> baseData() {
        slaveList = new ArrayList<>();

        Slave a;

        a = new Slave("Slave System 5", 20, 20, 40);
        slaveList.add(a);

        a = new Slave("Slave System 2", 20, 25, 30);
        slaveList.add(a);

        a = new Slave("Slave System 3", 20, 15, 20);
        slaveList.add(a);

        a = new Slave("Slave System 4", 20, 30, 34);
        slaveList.add(a);

        return slaveList;
    }
    public List<Slave> newData(String data){

        int [] sys1 = decode(0,6,data);
        int [] sys2 = decode(6,12,data);
        int [] sys3 = decode(12,18,data);
        int [] sys4 = decode(18,24,data);


        slaveList = new ArrayList<>();

        Slave a;

        a = new Slave("Slave System 1", sys1[0], sys1[1], sys1[2]);
        slaveList.add(a);

        a = new Slave("Slave System 2", sys2[0], sys2[1], sys2[2]);
        slaveList.add(a);

        a = new Slave("Slave System 3", sys3[0], sys3[1], sys3[2]);
        slaveList.add(a);

        a = new Slave("Slave System 4", sys4[0], sys4[1], sys4[2]);
        slaveList.add(a);

        return slaveList;
    }

    public int[] decode(int x, int y, String data){

        String strDecode=decodeStringSub(x,y,data);
        int decoded=StringToInt(strDecode);
        int hum=decoded%100;
        decoded=decoded/100;
        int soilMoist=decoded%100;
        decoded=decoded/100;
        int temp=decoded;
        Toast.makeText(mContext, strDecode, Toast.LENGTH_LONG).show();
        int [] comData= new int[]{
                temp,
                soilMoist,
                hum
        };
        return comData;
    }
    public String decodeStringSub(int x, int y,String data){
        return data.substring(x, y);
    }
    public int StringToInt(String data){
        return Integer.parseInt(data);
    }
}
