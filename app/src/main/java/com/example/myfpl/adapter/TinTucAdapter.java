package com.example.myfpl.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.myfpl.Fragment.TinTucFragment;
import com.example.myfpl.R;
import com.example.myfpl.model.TinTuc;

import java.util.ArrayList;
import java.util.HashMap;

public class TinTucAdapter extends BaseAdapter {
    Context c;
    ArrayList<TinTuc> ds= new ArrayList<TinTuc>();
    TinTucFragment tinTucFragment;

    public TinTucAdapter(Context c, ArrayList<TinTuc> ds, TinTucFragment tinTucFragment) {
        this.c = c;
        this.ds = ds;
        this.tinTucFragment = tinTucFragment;
    }




    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inf=((Activity)c).getLayoutInflater();
        view=inf.inflate(R.layout.item_tin_tuc,null);
        TextView txtTitle=view.findViewById(R.id.txtTitle);
        TextView txtDate=view.findViewById(R.id.txtDate);
        ImageView img=view.findViewById(R.id.img);

        TinTuc tt= ds.get(i);
        txtTitle.setText(tt.idNews+"");
        txtDate.setText(tt.date);


        return view;
    }
}
