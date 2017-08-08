package com.example.dimas.omondesign;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Dimas on 03/08/2017.
 */

public class SlaveAdapter extends RecyclerView.Adapter<SlaveAdapter.MyViewHolder>{
    private Context mContext;
    private List<Slave> slaveList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, temp, soilMoist, humidity;
        public ImageView slave, slaveTemp, slaveSoil, slaveHum;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titleSlave);
            temp = (TextView) view.findViewById(R.id.slaveTextTemp);
            soilMoist = (TextView) view.findViewById(R.id.slaveTextSoil);
            humidity = (TextView) view.findViewById(R.id.slaveTextHum);
            slave = (ImageView) view.findViewById(R.id.twoSlaveLogo);
            slaveTemp = (ImageView) view.findViewById(R.id.twoSlaveTemp);
            slaveSoil = (ImageView) view.findViewById(R.id.twoSlaveSoil);
            slaveHum = (ImageView) view.findViewById(R.id.twoSlaveHum);

        }
    }
    public SlaveAdapter(Context mContext, List<Slave> slaveList) {
        this.mContext = mContext;
        this.slaveList = slaveList;
    }
    public SlaveAdapter(List<Slave> slaveList) {

        this.slaveList = slaveList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.advslave, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Slave slave = slaveList.get(position);
        holder.title.setText(slave.getName());
        holder.temp.setText(slave.getTemp() + "C");
        holder.soilMoist.setText(slave.getSoilMoist() + "%");
        holder.humidity.setText(slave.getHumidity() + "%");;
        Glide.with(mContext).load(R.drawable.slavelogo).into(holder.slave);
        Glide.with(mContext).load(R.drawable.temp).into(holder.slaveTemp);
        Glide.with(mContext).load(R.drawable.soil).into(holder.slaveSoil);
        Glide.with(mContext).load(R.drawable.humidity).into(holder.slaveHum);

    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_slave, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
    @Override
    public int getItemCount() {
        return slaveList.size();
    }
}
