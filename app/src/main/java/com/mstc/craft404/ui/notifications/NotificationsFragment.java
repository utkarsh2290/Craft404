package com.mstc.craft404.ui.notifications;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mstc.craft404.R;
import com.mstc.craft404.adapters.designAdapter;
import com.mstc.craft404.adapters.frontendAdapter;
import com.mstc.craft404.model.designModel;
import com.mstc.craft404.model.frontendModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView recyclerViewFrontend, recyclerViewDesign;
    private RecyclerView.LayoutManager layoutManagerFrontEnd,layoutManagerDesign;
    private DatabaseReference databaseReference_frontend,databaseReference_design;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewFrontend=view.findViewById(R.id.recyclerview_frontend);
        recyclerViewDesign =view.findViewById(R.id.recyclerview_design);

        recyclerViewFrontend.setHasFixedSize(true);
        recyclerViewDesign.setHasFixedSize(true);

        //Linear Layout manager for Speakers
        layoutManagerFrontEnd=new LinearLayoutManager(getContext());
        recyclerViewFrontend.setLayoutManager(layoutManagerFrontEnd);

        final List<frontendModel> resFrontEndList=new ArrayList<>();
        databaseReference_frontend= FirebaseDatabase.getInstance().getReference().child("FrontEnd");
        databaseReference_frontend.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                resFrontEndList.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String title=dataSnapshot.child("title").getValue().toString();
                    String desc=dataSnapshot.child("desc").getValue().toString();
                    String link=dataSnapshot.child("link").getValue().toString();
                    resFrontEndList.add(new frontendModel(title,desc,link));

                }
                frontendAdapter frontendAdapter= new frontendAdapter(resFrontEndList,getContext());
                recyclerViewFrontend.setAdapter(frontendAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("Frontend not fetched",error.getMessage());
            }
        });


        // LAYOUT FOR DESIGN
        layoutManagerDesign=new LinearLayoutManager(getContext());
        recyclerViewDesign.setLayoutManager(layoutManagerDesign);

        final List<designModel> resDesignList=new ArrayList<>();
        databaseReference_design=FirebaseDatabase.getInstance().getReference().child("Design");
        databaseReference_design.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                resDesignList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    String title=dataSnapshot.child("title").getValue().toString();
                    String desc=dataSnapshot.child("desc").getValue().toString();
                    String link=dataSnapshot.child("link").getValue().toString();
                    resDesignList.add(new designModel(title,desc,link));

                }
                designAdapter designAdapter= new designAdapter(resDesignList,getContext());
                recyclerViewDesign.setAdapter(designAdapter);
                Log.i("Design displayed","Success");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("Design not fetched",error.getMessage());
            }
        });


    }
}
