package com.mstc.craft404.fragments.Submissions;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.LeaderboardAdapter;
import com.mstc.craft404.model.LeaderboardModel;

import java.util.ArrayList;
import java.util.List;

public class submissionsLeaderboard extends Fragment {
    RecyclerView leaderboardRecylerview;
    ProgressBar progressBarleaderboard;
    List<LeaderboardModel> leaderboardModelList= new ArrayList<>();
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
        leaderboardRecylerview=view.findViewById(R.id.leaderboardRecyclerView);
        leaderboardRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        tv_empty_leaderboard=view.findViewById(R.id.tv_empty_leaderboard);
        checkConnection();
        initializeData();
    }

    private void initializeData() {
        leaderboardModelList=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Leaderboard");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                leaderboardModelList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String title = dataSnapshot.child("title").getValue().toString();
                    String name = dataSnapshot.child("name").getValue().toString();
                    String imglink = dataSnapshot.child("link").getValue().toString();
                    if(name.matches("")){
                        leaderboardRecylerview.setVisibility(View.INVISIBLE);
                        tv_empty_leaderboard.setVisibility(View.VISIBLE);
                        progressBarleaderboard.setVisibility(View.INVISIBLE);
                        tv_internet_check.setVisibility(View.INVISIBLE);
                        Log.i("Data fetched", "FALSE");
                        break;
                    }
                    else{
                        progressBarleaderboard.setVisibility(View.INVISIBLE);
                        tv_internet_check.setVisibility(View.INVISIBLE);
                        leaderboardRecylerview.setVisibility(View.VISIBLE);
                        tv_empty_leaderboard.setVisibility(View.INVISIBLE);
                        Log.i("Data fetched", "TRUE");
                    }
                    leaderboardModelList.add(new LeaderboardModel(title,name,imglink));
                    LeaderboardAdapter leaderboardAdapter=new LeaderboardAdapter(getContext(),leaderboardModelList);
                    leaderboardRecylerview.setAdapter(leaderboardAdapter);
                    Log.i("Data fetched", dataSnapshot.toString());
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
