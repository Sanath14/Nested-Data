package com.codingstuff.dropdown;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NestedItemAdapter extends RecyclerView.Adapter<NestedItemAdapter.NestedItemViewHolder> {

    private List<String> mList;

    public NestedItemAdapter(List<String> mList){
        this.mList = mList;
    }

    @NonNull
    @Override
    public NestedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item , parent , false);
        return new NestedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedItemViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NestedItemViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public NestedItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.nestedItemTv);

        }
    }
}
