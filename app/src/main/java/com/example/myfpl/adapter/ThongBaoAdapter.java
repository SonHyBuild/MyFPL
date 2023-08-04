package com.example.myfpl.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.myfpl.Fragment.ThongBaoFragment;
import com.example.myfpl.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.activity.DetailThongBaoActivity;
import com.example.myfpl.activity.DetailThongBaoFragment;
import com.example.myfpl.activity.LoginActivity;
import com.example.myfpl.model.TinTuc;
//import com.example.myfpl.model.TinTuc;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TinTuc> list;

    public ThongBaoAdapter(Context context, ArrayList<TinTuc> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_thongbao,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_title.setText(list.get(position).getTitle());
//        holder.tv_content.setText(list.get(position).getContent());
        holder.tv_date.setText(list.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("idNews",list.get(holder.getAdapterPosition()).getIdNews());
                Intent intent= new Intent(context, DetailThongBaoActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_content,tv_date;
        ImageView imghinh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
//            tv_content=itemView.findViewById(R.id.tv_content);
            tv_date=itemView.findViewById(R.id.tv_date);
            imghinh=itemView.findViewById(R.id.imghinh);

        }
    }

}
