package com.mstc.craft404.fragments.AboutUs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.speakersAdapter;
import com.mstc.craft404.model.SpeakersModel;


import java.util.ArrayList;
import java.util.List;

public class aboutusSpeakers extends Fragment {
    private RecyclerView recyclerViewSpeakers;
    private DatabaseReference databaseReference_speakers;
    private ProgressBar speakers_progress;
    private TextView tv_internet_check;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speakers,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        checkConnection();
        setupSpeakers();

    }

    private void setupSpeakers() {

        final List<SpeakersModel> speakersList=new ArrayList<>();
        databaseReference_speakers= FirebaseDatabase.getInstance().getReference().child("Speaker");
        databaseReference_speakers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                speakers_progress.setVisibility(View.VISIBLE);
                speakersList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String name=dataSnapshot.child("name").getValue().toString();
                    String image=dataSnapshot.child("picpath").getValue().toString();
                    String content=dataSnapshot.child("content").getValue().toString();
                    Log.i("Speaker Details",image);
                    speakersList.add(new SpeakersModel(name,image,content));
                }
                speakersAdapter speakersAdapter=new speakersAdapter(speakersList,getContext());
                recyclerViewSpeakers.setAdapter(speakersAdapter);
                speakers_progress.setVisibility(View.INVISIBLE);
                tv_internet_check.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                tv_internet_check.setVisibility(View.VISIBLE);
                Log.i("Unable to load Speakers",error.getMessage());
            }
        });
    }

    private void findViewById(View view)
    {
        speakers_progress=view.findViewById(R.id.speaker_progressbar);
        recyclerViewSpeakers =view.findViewById(R.id.recyclerview_speaker);
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        recyclerViewSpeakers.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if (activeNetwork == null) {
            tv_internet_check.setVisibility(View.VISIBLE);
            speakers_progress.setVisibility(View.INVISIBLE);
        }
    }
}
