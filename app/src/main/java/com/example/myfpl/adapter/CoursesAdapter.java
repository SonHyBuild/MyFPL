package com.example.myfpl.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.activity.CoursesFragment;
import com.example.myfpl.activity.FormActivity;
import com.example.myfpl.activity.FormFragment;
import com.example.myfpl.model.Course;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Course> list;

    public CoursesAdapter( Context context,ArrayList<Course> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_course,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCourse.setText(list.get(position).getTenKhoa());
        holder.txtTime.setText(list.get(position).getThoiGian());
        holder.txtObject.setText(list.get(position).getDoiTuong());
        holder.txtMoTa.setText(list.get(position).getMoTa());
        holder.regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FormActivity.class);
                i.putExtra("id",list.get(holder.getAdapterPosition()).getIdKhoa());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCourse,txtTime,txtObject,txtMoTa,regis;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourse= itemView.findViewById(R.id.txtCourse);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtObject = itemView.findViewById(R.id.txtObject);
            txtMoTa = itemView.findViewById(R.id.txtMoTa);
            regis=itemView.findViewById(R.id.registerCourse);
        }
    }
}
