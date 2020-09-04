package com.mstc.craft404.ui.Submissions;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.mstc.craft404.adapters.GuildelinesAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class submissionsLeaderboard extends Fragment {
    TextView leaderfirst,leadersecond,leaderthird;
    ImageView imgleaderfirst,imgleadersecond,imgleaderthird;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

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
        leaderfirst=view.findViewById(R.id.tv_name_1);
        leadersecond=view.findViewById(R.id.tv_name_2);
        leaderthird=view.findViewById(R.id.tv_name_3);
        imgleaderfirst=view.findViewById(R.id.imageview_leader_1);
        imgleadersecond=view.findViewById(R.id.imageview_leader_2);
        imgleaderthird=view.findViewById(R.id.imageview_leader_3);
        initializeData();
    }

    private void initializeData() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Leaderboard");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                leaderfirst.setText(snapshot.child("first").getValue(String.class));
                leadersecond.setText(snapshot.child("second").getValue(String.class));
                leaderthird.setText(snapshot.child("third").getValue(String.class));

                Glide.with(getContext()).load(snapshot.child("firstimg").getValue().toString()).into(imgleaderfirst);
                Glide.with(getContext()).load(snapshot.child("secondimg").getValue().toString()).into(imgleadersecond);
                Glide.with(getContext()).load(snapshot.child("thirdimg").getValue().toString()).into(imgleaderthird);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
