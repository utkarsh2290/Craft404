package com.mstc.craft404.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mstc.craft404.R;
import com.mstc.craft404.model.SponsorsModel;

import java.util.List;

public class sponsorsAdapter extends RecyclerView.Adapter<sponsorsAdapter.myViewHolder> {

    private List<SponsorsModel> mDataSponsor;
    private Context mContext;

    public sponsorsAdapter(List<SponsorsModel> mDataSponsor, Context mContext) {
        this.mDataSponsor = mDataSponsor;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sponsor, parent, false);
        return new sponsorsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Glide.with(mContext).load(mDataSponsor.get(position).getSponsorPicLink()).into(holder.sponsorImage);

    }

    @Override
    public int getItemCount() {
        return mDataSponsor.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private ImageView sponsorImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            sponsorImage=itemView.findViewById(R.id.sponsor_image);
        }
    }

}
