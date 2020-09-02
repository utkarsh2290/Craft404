package com.mstc.craft404.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView timelineDay1;
    private ImageView timelineDay2;
    private TabHost dayTabHost;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    //Initializing preferred in onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dayTabHost = view.findViewById(R.id.tabHost);
        timelineDay1=view.findViewById(R.id.imageViewTimeline1);
        timelineDay2=view.findViewById(R.id.imageViewTimeline2);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        tabHostSetup();
        loadingTimeline();

    }


    private void tabHostSetup(){
        dayTabHost.setup();


        //tab1
        TabHost.TabSpec spec=dayTabHost.newTabSpec("Day One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Day One");
        dayTabHost.addTab(spec);

        //tab2
        spec = dayTabHost.newTabSpec("Day Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Day Two");
        dayTabHost.addTab(spec);
    }

    private void loadingTimeline()
    {
        final DatabaseReference timeline=databaseReference.child("Timeline");

        timeline.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String day1 = snapshot.child("0").getValue(String.class);
                Log.i("Value fetched", day1);
                Glide.with(getContext()).load(day1).into(timelineDay1);

                String day2 = snapshot.child("1").getValue(String.class);
                Log.i("Value fetched", day2);
                Glide.with(getContext()).load(day2).into(timelineDay2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}