package com.mstc.craft404.adapters.resources;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mstc.craft404.R;
import com.mstc.craft404.model.ResourcesObject;

import java.util.List;

public class ResourcesDaysAdapter extends RecyclerView.Adapter<ResourcesDaysAdapter.resourcesDay1view> {

    Context context;
    List<ResourcesObject> resourcesObjects_list;



    public ResourcesDaysAdapter(Context context, List<ResourcesObject> resourcesObjects_list) {
        this.context = context;
        this.resourcesObjects_list = resourcesObjects_list;
    }

    @NonNull
    @Override
    public resourcesDay1view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        resourcesDay1view rholder=new resourcesDay1view(LayoutInflater.from(context).inflate(R.layout.item_resourcesday1,parent,false));
        return rholder;
    }

    @Override
    public void onBindViewHolder(@NonNull resourcesDay1view holder, int position) {
        holder.resday1title.setText(resourcesObjects_list.get(position).getRestitle());
        holder.resday1desc.setText(resourcesObjects_list.get(position).getResdesc());
        holder.resday1date.setText(resourcesObjects_list.get(position).getResdate());
        Glide.with(context).load(resourcesObjects_list.get(position).getResimglink()).into(holder.resday1image);
    }

    @Override
    public int getItemCount() {
        return resourcesObjects_list.size();
    }

    public static class resourcesDay1view extends RecyclerView.ViewHolder{

        private TextView resday1title,resday1date,resday1desc;
        private ImageView resday1image;
        public resourcesDay1view(@NonNull View itemView) {
            super(itemView);
            resday1title=itemView.findViewById(R.id.resday1title);
            resday1desc=itemView.findViewById(R.id.resday1desc);
            resday1date=itemView.findViewById(R.id.resday1date);
            resday1image=itemView.findViewById(R.id.resday1image);
        }
    }
}
