package com.mstc.craft404.ui.Resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mstc.craft404.MainActivity;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.resources.ResourcesAdapter;
import com.mstc.craft404.ui.timeline.timelineday1;
import com.mstc.craft404.ui.timeline.timelineday2;

public class ResourcesFragment extends Fragment {

    TabLayout resources_tablayout;
    ViewPager resourcesViewpager;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        MainActivity.appBarTitle.setText("Resources");
        View root = inflater.inflate(R.layout.fragment_resources, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resourcesViewpager=view.findViewById(R.id.viewPagerres);
        resources_tablayout=view.findViewById(R.id.tabLayoutres);
        resources_tablayout.setupWithViewPager(resourcesViewpager);

        ResourcesAdapter adapter= new ResourcesAdapter(getChildFragmentManager());
        adapter.addfragment(new resourcesday1(),"Files" );
        adapter.addfragment(new resourcesday2(),"FAQs");
        resourcesViewpager.setAdapter(adapter);

    }
}