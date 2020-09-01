package com.mstc.craft404.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mstc.craft404.R;
import com.mstc.craft404.model.sponsorsModel;

import java.util.List;

public class sponsorsAdapter extends RecyclerView.Adapter<sponsorsAdapter.myViewHolder> {

    private List<sponsorsModel>mDataSponsors;
    private Context mContext;

    public sponsorsAdapter(List<sponsorsModel> mDataSponsors, Context mContext) {
        this.mDataSponsors = mDataSponsors;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sponsor, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.sponsorsImage.setImageResource(mDataSponsors.get(position).getSponsorsImage());
        holder.sponsorsName.setText(mDataSponsors.get(position).getSponsorsName());
    }

    @Override
    public int getItemCount() {
        return mDataSponsors.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView sponsorsImage;
        private TextView sponsorsName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sponsorsImage=itemView.findViewById(R.id.sponsorImage);
            sponsorsName=itemView.findViewById(R.id.sponsorName);
        }
    }
}
