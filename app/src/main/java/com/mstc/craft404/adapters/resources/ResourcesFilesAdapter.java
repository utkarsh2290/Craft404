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
        holder.button_resfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle(resourcesObjects_list.get(position).getRestitle())
                        .setMessage("Would you like to open the resource link ?")
                        .setPositiveButton("Open", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String link=resourcesObjects_list.get(position).getReslink();
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData((Uri.parse(link)));
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .show();
            }
        });
        holder.button_resfiles_nested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle(resourcesObjects_list.get(position).getRestitle())
                        .setMessage("Would you like to open the resource link ?")
                        .setPositiveButton("Open", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String link=resourcesObjects_list.get(position).getReslink();
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData((Uri.parse(link)));
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .show();
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
        RelativeLayout button_resfiles;
        Button button_resfiles_nested;
        public resourcesDay1view(@NonNull View itemView) {
            super(itemView);
            resfiletitle=itemView.findViewById(R.id.resfilestitle);
            resfiledesc=itemView.findViewById(R.id.resfilesdesc);
            resfiledate=itemView.findViewById(R.id.resfilesdate);
            resfileimage=itemView.findViewById(R.id.resday1image);
            button_resfiles=itemView.findViewById(R.id.resfiles_button);
            button_resfiles_nested=itemView.findViewById(R.id.resfiles_buttton_nested);
        }
    }
}
