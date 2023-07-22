package com.example.myfpl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.myfpl.Fragment.ThongBaoFragment;
import com.example.myfpl.R;
import com.example.myfpl.model.TinTuc;
//import com.example.myfpl.model.TinTuc;

import java.util.List;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.TinTucViewHolder> {
    private static final String TAG = "SongAdapter";
    private List<TinTuc> tintuc;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public ThongBaoAdapter( Context context, List<TinTuc> tintuc) {

        this.context = context;
        this.tintuc = tintuc;
          mLayoutInflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public TinTucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_thongbao, parent, false);
        return new TinTucViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull TinTucViewHolder holder, int position) {
        TinTuc tt = tintuc.get(position);

        //bind data to viewholder
//        holder.tvCode.setText(tt.getIdNews());
        holder.tvTitle.setText(tt.getContent());
        holder.tvLyric.setText(tt.getTitle());
        holder.tvArtist.setText(tt.getDate());

    }

    @Override
    public int getItemCount() {
        return tintuc.size();
    }
    class TinTucViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCode;
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;

        public TinTucViewHolder(View itemView) {
            super(itemView);
//            tvCode = (TextView) itemView.findViewById(R.id.tv_code);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
        }
    }
}
