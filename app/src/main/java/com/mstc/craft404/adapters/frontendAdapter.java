package com.mstc.craft404.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mstc.craft404.R;
import com.mstc.craft404.model.frontendModel;

import java.util.List;

public class frontendAdapter extends RecyclerView.Adapter<frontendAdapter.myViewHolder> {
    private List<frontendModel> mDataFrontEnd;
    private Context mContext;

    public frontendAdapter(List<frontendModel> mDataFrontEnd, Context mContext) {
        this.mDataFrontEnd = mDataFrontEnd;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frontend, parent, false);
        return new frontendAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.frontendTitle.setText(mDataFrontEnd.get(position).getResFrontEndTitle());
        holder.frontendDesc.setText(mDataFrontEnd.get(position).getResFrontEndDesc());
        holder.frontendLink.setText(mDataFrontEnd.get(position).getResFrontEndLink());
    }

    @Override
    public int getItemCount() {
        return mDataFrontEnd.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private TextView frontendTitle, frontendDesc, frontendLink;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            frontendTitle=itemView.findViewById(R.id.frontendTitle);
            frontendDesc=itemView.findViewById(R.id.frontendDesc);
            frontendLink=itemView.findViewById(R.id.frontendLink);
        }
    }
}
