package com.mstc.craft404.fragments.Submissions;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
import com.mstc.craft404.adapters.GuildelinesAdapter;

import java.util.ArrayList;
import java.util.List;

public class submissionsGuidelines extends Fragment {

    RecyclerView guidelinesRecyclerView;
    List<String> guidelines;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    DatabaseReference databaseReferencesubs;
    ProgressBar progressBarguidelines;
    Button submission;
    public String link;
    private TextView tv_internet_check;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        databaseReferencesubs=firebaseDatabase.getReference();
        return inflater.inflate(R.layout.fragment_guidelines,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBarguidelines=view.findViewById(R.id.progressbarguidelines);
        guidelinesRecyclerView = view.findViewById(R.id.guidelinesRecyclerView);
        submission=view.findViewById(R.id.button_submission);
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        checkConnection();

        guidelinesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
        linkcheck();

    }

    private void linkcheck() {
        databaseReferencesubs= FirebaseDatabase.getInstance().getReference().child("Submission");
        databaseReferencesubs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                link=snapshot.child("link").getValue(String.class);
                submission.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(link.matches("")){
                            Toast.makeText(getContext(),"Link will open soon! Stay tuned.",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData((Uri.parse(link)));
                            startActivity(intent);
                        }
                    }
                });
                Log.i("Value fetched", link);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void initializeData() {
        guidelines=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Guidelines");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBarguidelines.setVisibility(View.VISIBLE);
                guidelines.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String content = dataSnapshot.child("content").getValue().toString();
                    guidelines.add(content);
                }
                GuildelinesAdapter adapter=new GuildelinesAdapter(getContext(),guidelines);
                guidelinesRecyclerView.setAdapter(adapter);
                progressBarguidelines.setVisibility(View.INVISIBLE);
                submission.setVisibility(View.VISIBLE);
                tv_internet_check.setVisibility(View.INVISIBLE);
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
            progressBarguidelines.setVisibility(View.INVISIBLE);
        }
    }
}
