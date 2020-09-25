package com.mstc.craft404.fragments.Submissions;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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

public class submissionsLeaderboard extends Fragment {
    TextView leaderfirst,leadersecond,leaderthird;
    TextView first,second,third;
    ImageView imgleaderfirst,imgleadersecond,imgleaderthird;
    ProgressBar progressBarleaderboard;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private TextView tv_internet_check,tv_empty_leaderboard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        return inflater.inflate(R.layout.fragment_leaderboard,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBarleaderboard=view.findViewById(R.id.progressbarleaderboard);
        first=view.findViewById(R.id.tv_leaderboard_1);
        second=view.findViewById(R.id.tv_leaderboard_2);
        third=view.findViewById(R.id.tv_leaderboard_3);
        leaderfirst=view.findViewById(R.id.tv_name_1);
        leadersecond=view.findViewById(R.id.tv_name_2);
        leaderthird=view.findViewById(R.id.tv_name_3);
        imgleaderfirst=view.findViewById(R.id.imageview_leader_1);
        imgleadersecond=view.findViewById(R.id.imageview_leader_2);
        imgleaderthird=view.findViewById(R.id.imageview_leader_3);
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        tv_empty_leaderboard=view.findViewById(R.id.tv_empty_leaderboard);
        checkConnection();
        initializeData();
    }

    private void initializeData() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Leaderboard");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBarleaderboard.setVisibility(View.VISIBLE);

                leaderfirst.setText(snapshot.child("first").getValue(String.class));
                leadersecond.setText(snapshot.child("second").getValue(String.class));
                leaderthird.setText(snapshot.child("third").getValue(String.class));

                Glide.with(getActivity()).load(snapshot.child("firstimg").getValue().toString()).into(imgleaderfirst);
                Glide.with(getActivity()).load(snapshot.child("secondimg").getValue().toString()).into(imgleadersecond);
                Glide.with(getActivity()).load(snapshot.child("thirdimg").getValue().toString()).into(imgleaderthird);

                if(leaderfirst.getText().toString().matches("")){
                    tv_empty_leaderboard.setVisibility(View.VISIBLE);
                    progressBarleaderboard.setVisibility(View.INVISIBLE);
                    tv_internet_check.setVisibility(View.INVISIBLE);
                }
                else{
                    progressBarleaderboard.setVisibility(View.INVISIBLE);
                    tv_internet_check.setVisibility(View.INVISIBLE);
                    first.setVisibility(View.VISIBLE);
                    second.setVisibility(View.VISIBLE);
                    third.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if (activeNetwork == null) {
            tv_internet_check.setVisibility(View.VISIBLE);
            progressBarleaderboard.setVisibility(View.INVISIBLE);


        }
    }
}
