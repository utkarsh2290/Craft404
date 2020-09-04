package com.mstc.craft404.ui.AboutUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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
import com.mstc.craft404.adapters.sponsorsAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragmentSponsor extends Fragment {
    private RecyclerView recyclerViewSponsors;
    private DatabaseReference databaseReference_sponsor;
    private ProgressBar sponsor_progress;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sponsors,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sponsor_progress=view.findViewById(R.id.sponsor_progressbar);
        recyclerViewSponsors =view.findViewById(R.id.recyclerview_sponsor);
        recyclerViewSponsors.setLayoutManager(new LinearLayoutManager(getContext()));
        final List<String> sponsorsList=new ArrayList<>();
        databaseReference_sponsor= FirebaseDatabase.getInstance().getReference().child("Sponsor");
        databaseReference_sponsor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sponsorsList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String image=dataSnapshot.child("picpath").getValue().toString();
                    sponsorsList.add(image);
                }
                sponsorsAdapter sponsorsAdapter=new sponsorsAdapter(sponsorsList,getContext());
                recyclerViewSponsors.setAdapter(sponsorsAdapter);
                sponsor_progress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
