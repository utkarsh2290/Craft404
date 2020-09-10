package com.mstc.craft404.adapters.resources;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.util.Util;
import com.mstc.craft404.R;
import com.mstc.craft404.model.FaqsModel;

import java.util.ArrayList;
import java.util.List;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ResourcesFaqAdapter extends RecyclerView.Adapter<ResourcesFaqAdapter.Faqview>{

    Context context;
    List<FaqsModel> faqModelList=new ArrayList<>();
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;
    private void animateExpand(Button b) {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        b.setAnimation(rotate);
        b.startAnimation(rotate);
    }

    private void animateCollapse(Button b) {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        b.setAnimation(rotate);
        b.startAnimation(rotate);
    }

    public ResourcesFaqAdapter(Context context, List<FaqsModel> faqModelList) {
        this.context = context;
        this.faqModelList = faqModelList;
    }

    @NonNull
    @Override
    public Faqview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Faqview(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resourcesfaqs,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final Faqview holder, final int position) {
        holder.faqQuest.setText(faqModelList.get(position).getFaqQuestion());
        holder.faqAnsw.setText(faqModelList.get(position).getFaqAnswer());
        final boolean isExpanded =position==mExpandedPosition;
        holder.faqAnsw.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);

        if (isExpanded)
        {
            //previousExpandedPosition = position;
            animateExpand(holder.button_down);
        }
        else {
            animateCollapse(holder.button_down);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                //notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
        holder.button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                //notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return faqModelList.size();
    }





    public static class Faqview extends RecyclerView.ViewHolder {

        TextView faqQuest,faqAnsw;
        Button button_down;

        public Faqview(@NonNull View itemView) {
            super(itemView);
            faqQuest=itemView.findViewById(R.id.faqtitle);
            faqAnsw=itemView.findViewById(R.id.faqanswer);
            button_down=itemView.findViewById(R.id.faq_button_nested);
            faqAnsw.setVisibility(View.INVISIBLE);
        }







    }
}
