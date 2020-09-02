package com.mstc.craft404.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mstc.craft404.R;
import com.mstc.craft404.model.designModel;



import java.util.List;

public class designAdapter extends RecyclerView.Adapter<designAdapter.myViewHolder> {
    private List<designModel> mDataDesign;
    private Context mContext;

    public designAdapter(List<designModel> mDataDesign, Context mContext) {
        this.mDataDesign = mDataDesign;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new designAdapter.myViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.designTitle.setText(mDataDesign.get(position).getResDesignTitle());
        holder.designDesc.setText(mDataDesign.get(position).getResDesignDesc());
        holder.designLink.setText(mDataDesign.get(position).getResDesignLink());
    }

    @Override
    public int getItemCount() {
        return mDataDesign.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private TextView designTitle, designDesc, designLink;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            designTitle=itemView.findViewById(R.id.designTitle);
            designDesc=itemView.findViewById(R.id.designDesc);
            designLink=itemView.findViewById(R.id.designLink);

        }
    }
}
