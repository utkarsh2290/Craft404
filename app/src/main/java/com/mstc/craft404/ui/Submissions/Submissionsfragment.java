package com.mstc.craft404.ui.Submissions;

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
import com.mstc.craft404.adapters.TimelineAdapter;
import com.mstc.craft404.ui.timeline.timelineday1;
import com.mstc.craft404.ui.timeline.timelineday2;

public class Submissionsfragment extends Fragment {

    TabLayout submissions_tablayout;
    ViewPager submissionsViewpager;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.appBarTitle.setText("Submissions");
        View root = inflater.inflate(R.layout.fragment_submissions, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        submissionsViewpager=view.findViewById(R.id.viewPagersubs);
        submissions_tablayout=view.findViewById(R.id.tabLayoutsubs);
        submissions_tablayout.setupWithViewPager(submissionsViewpager);

        TimelineAdapter adapter= new TimelineAdapter(getChildFragmentManager());
        adapter.addfragment(new submissionsGuidelines(),"Guidelines" );
        adapter.addfragment(new submissionsLeaderboard(),"Leaderboard");
        submissionsViewpager.setAdapter(adapter);
    }
}
