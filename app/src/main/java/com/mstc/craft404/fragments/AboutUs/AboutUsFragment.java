package com.mstc.craft404.fragments.AboutUs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mstc.craft404.activities.MainActivity;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.AboutAdapter;
import com.mstc.craft404.fragments.timeline.TimelineFragment;

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
        adapter.addfragment(new aboutusChapter(),"Chapter");
        adapter.addfragment(new aboutusSpeakers(),"Speakers");
        adapter.addfragment(new aboutusSponsor(),"Sponsors");
        aboutusViewpager.setAdapter(adapter);
        aboutusViewpager.setPageTransformer(true, new TimelineFragment.DepthPageTransformer());
    }
    
    public static class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

}
