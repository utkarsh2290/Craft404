package com.mstc.craft404.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TimelineAdapter extends FragmentStatePagerAdapter {

    private  final List<Fragment> timelinedays=new ArrayList<>();
    private final  List<String> timelinetitles=new ArrayList<>();
    public TimelineAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return timelinedays.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return timelinetitles.get(position);
    }

    @Override
    public int getCount() {
        return timelinedays.size();
    }

    public void addfragment(Fragment fragment,String title){
        timelinedays.add(fragment);
        timelinetitles.add(title);
    }
}