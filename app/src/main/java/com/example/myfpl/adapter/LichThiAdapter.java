package com.example.myfpl.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.model.LichHoc;
import com.example.myfpl.model.LichThi;

import java.util.ArrayList;

public class LichThiAdapter extends RecyclerView.Adapter<LichThiAdapter.ViewHolder>{

    private Context context;
    private ArrayList<LichThi> list;

    public LichThiAdapter( Context context, ArrayList<LichThi> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lich_thi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameMH.setText(list.get(position).getNameMH());
        holder.txtTearcherMH.setText("Giảng viên: " + list.get(position).getTearcherMH());
        holder.txtLocationLT.setText(list.get(position).getLocationLT());
        holder.txtCaLT.setText(list.get(position).getCaLT());
        holder.txtDate_timeLT.setText(list.get(position).getDate_timeLT());
        holder.txtLopLT.setText("Lớp: MD17307");
        holder.layoutShow.setVisibility(View.GONE);
        holder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isvisible = holder.layoutShow.getVisibility();
                if(isvisible==View.VISIBLE){
                    holder.layoutShow.setVisibility(View.GONE);
                }
                else {
                    holder.layoutShow.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameMH,txtTearcherMH,txtLocationLT,txtCaLT,txtDate_timeLT, txtLopLT;
        LinearLayout btnShow, layoutShow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameMH= itemView.findViewById(R.id.txtNameMH);
            txtTearcherMH= itemView.findViewById(R.id.txtTearcherMH);
            txtLocationLT = itemView.findViewById(R.id.txtLocationLT);
            txtCaLT = itemView.findViewById(R.id.txtCaLT);
            txtDate_timeLT = itemView.findViewById(R.id.txtDate_timeLT);
            txtLopLT = itemView.findViewById(R.id.txtLopLT);
            btnShow = itemView.findViewById(R.id.btnShow);
            layoutShow = itemView.findViewById(R.id.layoutShow);
        }
    }

}
