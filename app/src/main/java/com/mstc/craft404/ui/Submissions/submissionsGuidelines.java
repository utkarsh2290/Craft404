package com.mstc.craft404.ui.Submissions;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.mstc.craft404.adapters.GuildelinesAdapter;
import com.mstc.craft404.adapters.resources.ResourcesDaysAdapter;
import com.mstc.craft404.model.ResourcesObject;

import java.util.ArrayList;
import java.util.List;

public class submissionsGuidelines extends Fragment {

    RecyclerView guidelinesRecyclerView;
    List<String> guidelines;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        return inflater.inflate(R.layout.fragment_guidelines,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        guidelinesRecyclerView = view.findViewById(R.id.guidelinesRecyclerView);
        guidelinesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
    }
    private void initializeData() {
        guidelines=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Guidelines");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                guidelines.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String content = dataSnapshot.child("content").getValue().toString();
                    guidelines.add(content);
                }
                GuildelinesAdapter adapter=new GuildelinesAdapter(getContext(),guidelines);
                guidelinesRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
