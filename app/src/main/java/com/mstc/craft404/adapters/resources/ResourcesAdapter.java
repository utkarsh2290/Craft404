package com.mstc.craft404.adapters.resources;

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

public class ResourcesAdapter extends FragmentStatePagerAdapter {

    private  final List<Fragment> resourcesdays=new ArrayList<>();
    private final  List<String> resourcestitles=new ArrayList<>();
    public ResourcesAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return resourcesdays.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return resourcestitles.get(position);
    }

    @Override
    public int getCount() {
        return resourcesdays.size();
    }

    public void addfragment(Fragment fragment,String title){
        resourcesdays.add(fragment);
        resourcestitles.add(title);
    }
}