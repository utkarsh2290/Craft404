package com.mstc.craft404.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        List<speakersModel> speakersList=new ArrayList<>();
        speakersList.add(new speakersModel(R.drawable.ic_launcher_background,"Utkarsh Shrivastav","Best one you can have", "https://www.figma.com/file/inUdqk2OMakEYh7d2ZkHQQ/Gravitas---Craft-404-App?node-id=0%3A1"));
        speakersList.add(new speakersModel(R.drawable.ic_launcher_background,"Utkarsh Shrivastav","Best one you can have", "https://www.figma.com/file/inUdqk2OMakEYh7d2ZkHQQ/Gravitas---Craft-404-App?node-id=0%3A1"));
        speakersList.add(new speakersModel(R.drawable.ic_launcher_background,"Utkarsh Shrivastav","Best one you can have", "https://www.figma.com/file/inUdqk2OMakEYh7d2ZkHQQ/Gravitas---Craft-404-App?node-id=0%3A1"));

        speakersAdapter speakersAdapter= new speakersAdapter(speakersList,getContext());
        recyclerViewSpeakers.setAdapter(speakersAdapter);

        //GRID LAYOUT FOR SPONSORS
        GridLayoutManager layoutManagerSponsors=new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL,false);
        recyclerViewSponsors.setLayoutManager(layoutManagerSponsors);

        List<sponsorsModel> sponsorsList=new ArrayList<>();
        sponsorsList.add(new sponsorsModel(R.drawable.ic_launcher_background,"Swiggy"));
        sponsorsList.add(new sponsorsModel(R.drawable.ic_launcher_background,"Swiggy"));
        sponsorsList.add(new sponsorsModel(R.drawable.ic_launcher_background,"Swiggy"));
        sponsorsList.add(new sponsorsModel(R.drawable.ic_launcher_background,"Swiggy"));

        sponsorsAdapter sponsorsAdapter=new sponsorsAdapter(sponsorsList,getContext());
        recyclerViewSponsors.setAdapter(sponsorsAdapter);

    }
}