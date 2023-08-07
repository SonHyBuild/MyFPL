package com.example.myfpl.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myfpl.R;
import com.google.android.material.tabs.TabLayout;

public class TabFragment2 extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* gan layout va anh xa */
        View x = inflater.inflate(R.layout.fragment_tab, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        /* Set adapter cho viewpager */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        /* can cai nay chu khong se bi loi */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }


    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {

            super(fm);
        }
        @Override public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0 : return new CoursesFragment();
                case 1 : return new CLBFragment();
                case 2: return new AllFragment();
            }
            return null;
        }
        @Override public int getCount()
        {
            return int_items;
        }
        @Override public CharSequence getPageTitle(int position)
        {
            switch (position) {
                case 0 : return "Xưởng";
                case 1 : return "CLB";
                case 2 : return "All";


            } return null;
        }
    }
}
