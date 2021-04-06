package com.app.zozm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zozm.R;

public class PaperItemAdapter extends RecyclerView.Adapter<PaperItemAdapter.MyViewHolder> {

    Context mContext;
    String[] itemname;

    public PaperItemAdapter(Context mContext, String[] items) {
        this.mContext = mContext;
        this.itemname = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_item_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(itemname[position]);

    }

    @Override
    public int getItemCount() {
        return itemname.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.tv);
        }
    }
}
