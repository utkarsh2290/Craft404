package com.mstc.craft404.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.mstc.craft404.R;
import com.mstc.craft404.model.ResourcesObject;

import java.util.List;

public class GuildelinesAdapter extends RecyclerView.Adapter<GuildelinesAdapter.GuidelinesView> {

    Context context;
    List<String> guidelines_list;

    public GuildelinesAdapter(Context context, List<String> guidelines_list) {
        this.context = context;
        this.guidelines_list = guidelines_list;
    }

    @NonNull
    @Override
    public GuidelinesView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GuidelinesView guidelinesView=new GuidelinesView(LayoutInflater.from(context).inflate(R.layout.items_guidelines,parent,false));
        return guidelinesView;
    }

    @Override
    public void onBindViewHolder(@NonNull GuidelinesView holder, int position) {
        holder.guidelines_tv.setText(guidelines_list.get(position));
    }

    @Override
    public int getItemCount() {
        return guidelines_list.size();
    }

    public static class GuidelinesView extends RecyclerView.ViewHolder{
        TextView guidelines_tv;
        public GuidelinesView(@NonNull View itemView) {
            super(itemView);
            guidelines_tv=itemView.findViewById(R.id.tvguidelines);
        }
    }
}
