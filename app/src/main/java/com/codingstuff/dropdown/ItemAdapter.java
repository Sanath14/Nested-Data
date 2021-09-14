package com.codingstuff.dropdown;

import android.media.Image;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<DataModel> itemList;
    List<String> list = new ArrayList<>();
    public ItemAdapter(List<DataModel> itemList){
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item , parent , false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        DataModel model = itemList.get(position);
        holder.itemTv.setText(model.getItemText());
        boolean isExpandable = model.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if (isExpandable){
            holder.mArrowImage.setImageResource(R.drawable.arrow_up);
        }else{
            holder.mArrowImage.setImageResource(R.drawable.arrow_down);
        }

        NestedItemAdapter adapter = new NestedItemAdapter(list);
        holder.nestedRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedRecyclerView.setHasFixedSize(true);
        holder.nestedRecyclerView.setAdapter(adapter);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.setExpandable(!model.isExpandable());

                list = model.getNestedList();
                notifyItemChanged(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView itemTv;
        RecyclerView nestedRecyclerView;
        RelativeLayout expandableLayout;
        LinearLayout linearLayout;
        ImageView mArrowImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.itemTv);
            nestedRecyclerView = itemView.findViewById(R.id.child_rv);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            mArrowImage = itemView.findViewById(R.id.arro_imageview);

        }


    }
}
