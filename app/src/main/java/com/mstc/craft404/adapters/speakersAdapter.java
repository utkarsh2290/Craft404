package com.mstc.craft404.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mstc.craft404.R;
import com.mstc.craft404.model.SpeakersModel;

import java.util.List;

public class speakersAdapter extends RecyclerView.Adapter<speakersAdapter.myViewHolder> {
    private List<SpeakersModel> mDataSpeaker;
    private Context mContext;

    public speakersAdapter(List<SpeakersModel> mData_speaker, Context mContext) {
        this.mDataSpeaker = mData_speaker;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaker, parent, false);
        return new speakersAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        Glide.with(mContext).load(mDataSpeaker.get(position).getSpeakerPicLink()).into(holder.speakerImage);
        holder.speakerName.setText(mDataSpeaker.get(position).getSpeakerName());
        holder.speakerContent.setText(mDataSpeaker.get(position).getSpeakerContent());
        holder.speakerDesignation.setText(mDataSpeaker.get(position).getSpeakerDesignation());
    }

    @Override
    public int getItemCount() {
        return mDataSpeaker.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private ImageView speakerImage;
        private TextView speakerName;
        private TextView speakerContent;
        private TextView speakerDesignation;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            speakerImage=itemView.findViewById(R.id.speaker_image);
            speakerName=itemView.findViewById(R.id.speaker_name);
            speakerContent=itemView.findViewById(R.id.speaker_content);
            speakerDesignation=itemView.findViewById(R.id.speaker_designation);

        }
    }
}
