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
import com.mstc.craft404.model.speakersModel;

import java.util.List;

public class speakersAdapter extends RecyclerView.Adapter<speakersAdapter.myViewHolder> {
    private List<speakersModel> mDataSpeaker;
    private Context mContext;

    public speakersAdapter(List<speakersModel> mData_speaker, Context mContext) {
        this.mDataSpeaker = mData_speaker;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaker, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        Glide.with(mContext).load(mDataSpeaker.get(position).getSpeakerPicLink()).into(holder.speakerImage);
        holder.speakerName.setText(mDataSpeaker.get(position).getSpeakerName());
        holder.speakerDesc.setText(mDataSpeaker.get(position).getSpeakerDescription());
        holder.speakerLink.setText(mDataSpeaker.get(position).getSpeakerLink());
        holder.speakerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = mDataSpeaker.get(position).getSpeakerLink();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSpeaker.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private ImageView speakerImage;
        private TextView speakerName,speakerDesc,speakerLink;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            speakerImage=itemView.findViewById(R.id.speakerImage);
            speakerName=itemView.findViewById(R.id.speakerName);
            speakerDesc=itemView.findViewById(R.id.speakerDescription);
            speakerLink=itemView.findViewById(R.id.speakerLink);
        }
    }
}
