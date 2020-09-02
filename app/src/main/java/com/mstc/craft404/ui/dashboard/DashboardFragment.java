package com.mstc.craft404.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.speakersAdapter;
import com.mstc.craft404.adapters.sponsorsAdapter;
import com.mstc.craft404.model.speakersModel;
import com.mstc.craft404.model.sponsorsModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerViewSpeakers, recyclerViewSponsors;
    private RecyclerView.LayoutManager layoutManagerSpeakers;
    private DatabaseReference databaseReference_speakers,databaseReference_sponsor;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewSpeakers=view.findViewById(R.id.recyclerview_speaker);
        recyclerViewSponsors =view.findViewById(R.id.recyclerview_sponsor);

        recyclerViewSponsors.setHasFixedSize(true);
        recyclerViewSpeakers.setHasFixedSize(true);

        //Linear Layout manager for Speakers
        layoutManagerSpeakers=new LinearLayoutManager(getContext());
        recyclerViewSpeakers.setLayoutManager(layoutManagerSpeakers);

        final List<speakersModel> speakersList=new ArrayList<>();
        databaseReference_speakers= FirebaseDatabase.getInstance().getReference().child("Speaker");
        databaseReference_speakers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                speakersList.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String title=dataSnapshot.child("name").getValue().toString();
                    String desc=dataSnapshot.child("desc").getValue().toString();
                    String link=dataSnapshot.child("link").getValue().toString();
                    String image_url=dataSnapshot.child("picpath").getValue().toString();
                    speakersList.add(new speakersModel(title,desc,link,image_url));

                }
                speakersAdapter speakersAdapter= new speakersAdapter(speakersList,getContext());
                recyclerViewSpeakers.setAdapter(speakersAdapter);
                Toast.makeText(getContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //GRID LAYOUT FOR SPONSORS
        GridLayoutManager layoutManagerSponsors=new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL,false);
        recyclerViewSponsors.setLayoutManager(layoutManagerSponsors);

        final List<sponsorsModel> sponsorsList=new ArrayList<>();
        databaseReference_sponsor=FirebaseDatabase.getInstance().getReference().child("Sponsor");
        databaseReference_sponsor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sponsorsList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String image=dataSnapshot.child("picpath").getValue().toString();
                    Log.i("Tis is image",image);
                    sponsorsList.add(new sponsorsModel(image));
                }
                sponsorsAdapter sponsorsAdapter=new sponsorsAdapter(sponsorsList,getContext());
                recyclerViewSponsors.setAdapter(sponsorsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}