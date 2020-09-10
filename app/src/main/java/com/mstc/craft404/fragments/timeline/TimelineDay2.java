package com.mstc.craft404.fragments.timeline;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;

public class TimelineDay2 extends Fragment {

    private ImageView timelineDay2;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ProgressBar day2Progressbar;
    private TextView tv_internet_check;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        return inflater.inflate(R.layout.item_timelineday2,container,false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timelineDay2=view.findViewById(R.id.imageview_day2);
        day2Progressbar=view.findViewById(R.id.progressbarday2);
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        checkConnection();
        DatabaseReference timeline=databaseReference.child("Timeline");

        timeline.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                day2Progressbar.setVisibility(View.VISIBLE);
                String day1 = snapshot.child("1").getValue(String.class);
                Log.i("Value fetched", day1);
                Glide.with(getActivity()).load(day1).into(timelineDay2);
                day2Progressbar.setVisibility(View.INVISIBLE);
                tv_internet_check.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork= manager.getActiveNetworkInfo();

        if(activeNetwork==null){
            tv_internet_check.setVisibility(View.VISIBLE);
            day2Progressbar.setVisibility(View.INVISIBLE);
        }
    }
}
