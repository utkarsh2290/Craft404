package com.mstc.craft404.ui.Resources;

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
import com.mstc.craft404.adapters.resources.ResourcesDaysAdapter;
import com.mstc.craft404.model.ResourcesObject;

import java.util.ArrayList;
import java.util.List;

public class resourcesday2 extends Fragment {
    RecyclerView resday2RecyclerView;
    ProgressBar resday2Progressbar;
    List<ResourcesObject> resourcesObjectList=new ArrayList<>();
    DatabaseReference databaseReference_resday2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resday2,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resday2Progressbar=view.findViewById(R.id.progressbarresday2);
        resday2RecyclerView = view.findViewById(R.id.resday2RecyclerView);
        resday2RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
    }

    private void initializeData() {
        resourcesObjectList = new ArrayList<>();
        databaseReference_resday2 = FirebaseDatabase.getInstance().getReference().child("Resources").child("Day2");
        databaseReference_resday2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                resourcesObjectList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String title = dataSnapshot.child("title").getValue().toString();
                    String date = dataSnapshot.child("date").getValue().toString();
                    String desc = dataSnapshot.child("desc").getValue().toString();
                    String imglink = dataSnapshot.child("link").getValue().toString();
                    String link = dataSnapshot.child("reslink").getValue().toString();
                    resourcesObjectList.add(new ResourcesObject(title, desc, date, imglink, link));
                }
                ResourcesDaysAdapter adapter = new ResourcesDaysAdapter(getContext(), resourcesObjectList);
                resday2RecyclerView.setAdapter(adapter);
                resday2Progressbar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
