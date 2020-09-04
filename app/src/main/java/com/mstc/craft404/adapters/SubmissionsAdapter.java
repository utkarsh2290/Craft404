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

public class SubmissionsAdapter extends FragmentStatePagerAdapter {
    private  final List<Fragment> submissionfragments=new ArrayList<>();
    private final  List<String> submissiontitles=new ArrayList<>();
    public SubmissionsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return submissionfragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return submissiontitles.get(position);
    }

    @Override
    public int getCount() {
        return submissionfragments.size();
    }

    public void addfragment(Fragment fragment,String title){
        submissionfragments.add(fragment);
        submissiontitles.add(title);
    }

}