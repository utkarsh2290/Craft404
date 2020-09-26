package com.mstc.craft404.fragments.Resources;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
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
import com.mstc.craft404.adapters.resources.ResourcesFaqAdapter;
import com.mstc.craft404.model.FaqsModel;

import java.util.ArrayList;
import java.util.List;

public class resourcesfaqs extends Fragment {
    RecyclerView resday2RecyclerView;
    ProgressBar resday2Progressbar;
    List<FaqsModel> resfaqObjectList=new ArrayList<>();
    DatabaseReference databaseReference_faq;
    private TextView tv_internet_check;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resfaqs,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resday2Progressbar=view.findViewById(R.id.progressbarfaq);
        resday2RecyclerView = view.findViewById(R.id.faqRecyclerView);
        tv_internet_check=view.findViewById(R.id.tv_internetcheck);
        checkConnection();
        resday2RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
    }

    private void initializeData() {
        databaseReference_faq = FirebaseDatabase.getInstance().getReference().child("Faqs");
        databaseReference_faq.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                resfaqObjectList.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    String qued= String.valueOf(Html.fromHtml(snapshot1.child("quest").getValue().toString()));
                    Log.i("Question",qued);
                    String answ = String.valueOf(Html.fromHtml(snapshot1.child("answ").getValue().toString()));
                    Log.i("Answer",answ);
                    resfaqObjectList.add(new FaqsModel(qued,answ));
                }
                ResourcesFaqAdapter adapter=new ResourcesFaqAdapter(getContext(),resfaqObjectList);
                resday2RecyclerView.setAdapter(adapter);
                Log.i("Answer","Passed");
                resday2Progressbar.setVisibility(View.INVISIBLE);
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
            resday2Progressbar.setVisibility(View.INVISIBLE);
        }
    }

}
