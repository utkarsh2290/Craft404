package com.mstc.craft404.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AboutAdapter extends FragmentStatePagerAdapter {
    private  final List<Fragment> aboutusfrags=new ArrayList<>();
    private final  List<String> aboutustitles=new ArrayList<>();
    public AboutAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return aboutusfrags.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return aboutustitles.get(position);
    }

    @Override
    public int getCount() {
        return aboutusfrags.size();
    }
    public void addfragment(Fragment fragment,String title){
        aboutusfrags.add(fragment);
        aboutustitles.add(title);
    }
}