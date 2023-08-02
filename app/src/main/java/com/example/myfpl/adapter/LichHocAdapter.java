package com.example.myfpl.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.model.LichHoc;

import java.util.ArrayList;

public class LichHocAdapter extends RecyclerView.Adapter<LichHocAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LichHoc> list;

    public LichHocAdapter( Context context, ArrayList<LichHoc> list) {

        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lich_hoc,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameMH.setText(list.get(position).getNameMH());
        holder.txtTearcherMH.setText("Giảng viên: " + list.get(position).getTearcherMH());
        holder.txtLocationLH.setText(list.get(position).getLocationLH());
        holder.txtCaLH.setText(list.get(position).getCaLH());
        holder.txtDate_timeLH.setText(list.get(position).getDate_timeLH());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameMH,txtTearcherMH,txtLocationLH,txtCaLH,txtDate_timeLH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameMH = itemView.findViewById(R.id.txtNameMH);
            txtTearcherMH = itemView.findViewById(R.id.txtTearcherMH);
            txtLocationLH = itemView.findViewById(R.id.txtLocationLH);
            txtCaLH = itemView.findViewById(R.id.txtCaLH);
            txtDate_timeLH = itemView.findViewById(R.id.txtDate_timeLH);
        }
    }
}
