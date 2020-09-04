package com.mstc.craft404.ui.timeline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mstc.craft404.MainActivity;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.TimelineAdapter;

public class TimelineFragment extends Fragment {

  TabLayout timeline_tablayout;
  ViewPager timelineViewpager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.appBarTitle.setText("Timeline");
        View root = inflater.inflate(R.layout.fragment_timeline, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timelineViewpager=view.findViewById(R.id.viewPager2);
        timeline_tablayout=view.findViewById(R.id.tabLayout2);
        timeline_tablayout.setupWithViewPager(timelineViewpager);

        TimelineAdapter adapter= new TimelineAdapter(getChildFragmentManager());
        adapter.addfragment(new timelineday1(),"Day 1" );
        adapter.addfragment(new timelineday2(),"Day 2");
        timelineViewpager.setAdapter(adapter);

    }
}