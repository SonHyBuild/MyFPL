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
import com.example.myfpl.fragment.LichHocFragment;

public class LichHocAdapter extends RecyclerView.Adapter<LichHocAdapter.ViewHolder> {

    private Context context;

    public LichHocAdapter( Context context) {

        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMaMH,txtLocationLH,txtCaLH,txtDate_timeLH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaMH= itemView.findViewById(R.id.txtMaMH);
            txtLocationLH = itemView.findViewById(R.id.txtLocationLH);
            txtCaLH = itemView.findViewById(R.id.txtCaLH);
            txtDate_timeLH = itemView.findViewById(R.id.txtDate_timeLH);
        }
    }
}
