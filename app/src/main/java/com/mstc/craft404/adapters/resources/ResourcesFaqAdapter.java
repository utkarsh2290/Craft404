package com.mstc.craft404.adapters.resources;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mstc.craft404.R;
import com.mstc.craft404.model.FaqsModel;

import java.util.ArrayList;
import java.util.List;

public class ResourcesFaqAdapter extends RecyclerView.Adapter<ResourcesFaqAdapter.Faqview>{

    Context context;
    List<FaqsModel> faqModelList=new ArrayList<>();
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

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
        final boolean isExpanded = position==mExpandedPosition;
        holder.faqAnsw.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.button_up.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.button_down.setVisibility(!isExpanded?View.VISIBLE:View.GONE);

        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
        {
            previousExpandedPosition = position;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
        holder.button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
        holder.button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return faqModelList.size();
    }

    public static class Faqview extends RecyclerView.ViewHolder{

        TextView faqQuest,faqAnsw;
        Button button_down,button_up;
        public Faqview(@NonNull View itemView) {
            super(itemView);
            faqQuest=itemView.findViewById(R.id.faqtitle);
            faqAnsw=itemView.findViewById(R.id.faqanswer);
            button_down=itemView.findViewById(R.id.faq_button_nested);
            button_up=itemView.findViewById(R.id.faq_buttonup);
            button_up.setVisibility(View.INVISIBLE);
            faqAnsw.setVisibility(View.INVISIBLE);
        }
    }
}
