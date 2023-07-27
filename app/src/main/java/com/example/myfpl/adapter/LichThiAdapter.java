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

public class LichThiAdapter extends RecyclerView.Adapter<LichThiAdapter.ViewHolder>{

    private Context context;

    public LichThiAdapter( Context context) {
        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMaMH,txtLocationLT,txtCaLT,txtDate_timeLT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaMH= itemView.findViewById(R.id.txtMaMH);
            txtLocationLT = itemView.findViewById(R.id.txtLocationLT);
            txtCaLT = itemView.findViewById(R.id.txtCaLT);
            txtDate_timeLT = itemView.findViewById(R.id.txtDate_timeLT);
        }
    }

}
