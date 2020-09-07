package com.mstc.craft404.adapters.resources;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mstc.craft404.R;
import com.mstc.craft404.model.ResourcesModel;

import java.util.List;

public class ResourcesFilesAdapter extends RecyclerView.Adapter<ResourcesFilesAdapter.resourcesDay1view> {

    Context context;
    List<ResourcesModel> resourcesObjects_list;



    public ResourcesFilesAdapter(Context context, List<ResourcesModel> resourcesObjects_list) {
        this.context = context;
        this.resourcesObjects_list = resourcesObjects_list;
    }

    @NonNull
    @Override
    public resourcesDay1view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        resourcesDay1view rholder=new resourcesDay1view(LayoutInflater.from(context).inflate(R.layout.item_resourcesfiles,parent,false));
        return rholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final resourcesDay1view holder, final int position) {
        holder.resfiletitle.setText(resourcesObjects_list.get(position).getRestitle());
        holder.resfiledesc.setText(resourcesObjects_list.get(position).getResdesc());
        holder.resfiledate.setText(resourcesObjects_list.get(position).getResdate());
        Glide.with(context).load(resourcesObjects_list.get(position).getResimglink()).into(holder.resfileimage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=resourcesObjects_list.get(position).getReslink();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resourcesObjects_list.size();
    }

    public static class resourcesDay1view extends RecyclerView.ViewHolder{

        private TextView resfiletitle,resfiledate,resfiledesc;
        private ImageView resfileimage;
        Button button_resfiles_nested;
        public resourcesDay1view(@NonNull View itemView) {
            super(itemView);
            resfiletitle=itemView.findViewById(R.id.resfilestitle);
            resfiledesc=itemView.findViewById(R.id.resfilesdesc);
            resfiledate=itemView.findViewById(R.id.resfilesdate);
            resfileimage=itemView.findViewById(R.id.resday1image);
        }
    }
}
