package com.example.myfpl.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myfpl.R;
import com.example.myfpl.adapter.TinTucAdapter;
import com.example.myfpl.model.TinTuc;

import java.util.ArrayList;
import java.util.HashMap;


public class TinTucFragment extends Fragment {
    ListView lv;
    ArrayList<TinTuc> ds= new ArrayList<TinTuc>();
    TinTucAdapter tinTucAdapter;
    ArrayList<HashMap<String,Object>> ds2= new  ArrayList<HashMap<String,Object>>();




    public TinTucFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String,Object> h1 = new HashMap<String,Object>();
        h1.put("idNews","1");
        h1.put("title","18");
        h1.put("hinh",R.drawable.img);
        ds2.add(h1);
        HashMap<String,Object> h2 = new HashMap<String,Object>();
        h2.put("idNews","1");
        h2.put("title","18");
        h2.put("hinh",R.drawable.img);
        ds2.add(h2);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tin_tuc,container,false);
        lv=view.findViewById(R.id.lv);

        SimpleAdapter adapter1= new SimpleAdapter(getActivity(),ds2,R.layout.item_tin_tuc, new String[]{"title","idNews","hinh"},
                new int[]{R.id.txtTitle,R.id.txtDate,R.id.img});
        lv.setAdapter(adapter1);
        return view;
    }
}