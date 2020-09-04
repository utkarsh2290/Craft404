package com.mstc.craft404.ui.AboutUs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mstc.craft404.MainActivity;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.AboutAdapter;
import com.mstc.craft404.adapters.TimelineAdapter;
import com.mstc.craft404.ui.timeline.timelineday1;
import com.mstc.craft404.ui.timeline.timelineday2;

public class AboutUsFragment extends Fragment {

    TabLayout aboutus_tablayout;
    ViewPager aboutusViewpager;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainActivity.appBarTitle.setText("About Us");
        View view= inflater.inflate(R.layout.fragment_aboutus, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        aboutusViewpager=view.findViewById(R.id.viewPager2);
        aboutus_tablayout=view.findViewById(R.id.tabLayout2);
        aboutus_tablayout.setupWithViewPager(aboutusViewpager);

        AboutAdapter adapter= new AboutAdapter(getChildFragmentManager());
        adapter.addfragment(new fragmentChapter(),"Chapter");
        adapter.addfragment(new fragmentChapter(),"Speakers");
        adapter.addfragment(new fragmentSponsor(),"Sponsors");
        aboutusViewpager.setAdapter(adapter);
    }

}