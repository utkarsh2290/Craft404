package com.mstc.craft404.adapters.resources;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
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
    public void onBindViewHolder(@NonNull Faqview holder, final int position) {
        holder.faqQuest.setText(faqModelList.get(position).getFaqQuestion());
        holder.faqAnsw.setText(faqModelList.get(position).getFaqAnswer());
        final boolean isExpanded = position==mExpandedPosition;
        holder.faqAnsw.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
            previousExpandedPosition = position;

        holder.button_faq_nested.setOnClickListener(new View.OnClickListener() {
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
        RelativeLayout button_faq;
        Button button_faq_nested;
        public Faqview(@NonNull View itemView) {
            super(itemView);
            faqQuest=itemView.findViewById(R.id.faqtitle);
            faqAnsw=itemView.findViewById(R.id.faqanswer);
            //button_faq=itemView.findViewById(R.id.faq_button);
            button_faq_nested=itemView.findViewById(R.id.faq_button_nested);
            faqAnsw.setVisibility(View.INVISIBLE);
            final View parent = (View) button_faq_nested.getParent();
            parent.post( new Runnable() {
                // Post in the parent's message queue to make sure the parent
                // lays out its children before we call getHitRect()
                public void run() {
                    final Rect r = new Rect();
                    button_faq_nested.getHitRect(r);
                    r.top -= 6;
                    r.bottom += 6;
                    parent.setTouchDelegate( new TouchDelegate( r , button_faq_nested));
                }
            });
        }
    }
}
