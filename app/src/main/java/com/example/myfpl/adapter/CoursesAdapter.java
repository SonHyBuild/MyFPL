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
import com.example.myfpl.model.Course;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    private Context context;

    public CoursesAdapter( Context context) {

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

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCourse,txtTime,txtObject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourse= itemView.findViewById(R.id.txtCourse);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtObject = itemView.findViewById(R.id.txtObject);
        }
    }
}
