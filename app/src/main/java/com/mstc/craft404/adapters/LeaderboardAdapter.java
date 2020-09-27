package com.mstc.craft404.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mstc.craft404.R;
import com.mstc.craft404.model.LeaderboardModel;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardView>{

    Context context;
    List<LeaderboardModel> leaderboardModelList;

    public LeaderboardAdapter(Context context, List<LeaderboardModel> leaderboardModelList) {
        this.context = context;
        this.leaderboardModelList = leaderboardModelList;
    }

    @NonNull
    @Override
    public LeaderboardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeaderboardView(LayoutInflater.from(context).inflate(R.layout.item_leaderboard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardView holder, int position) {
        holder.leadertitle.setText(leaderboardModelList.get(position).getLeaderTitle());
        holder.leadername.setText(leaderboardModelList.get(position).getLeaderName());
        Glide.with(context).load(leaderboardModelList.get(position).getLeaderImage()).into(holder.leaderimage);

    }

    @Override
    public int getItemCount() {
        return leaderboardModelList.size();
    }

    public static  class LeaderboardView extends RecyclerView.ViewHolder{

        TextView leadertitle,leadername;
        ImageView leaderimage;
        public LeaderboardView(@NonNull View itemView) {
            super(itemView);
            leaderimage=itemView.findViewById(R.id.imageview_leader_1);
            leadertitle=itemView.findViewById(R.id.tv_leaderboard_1);
            leadername=itemView.findViewById(R.id.tv_name_1);
        }
    }
}
