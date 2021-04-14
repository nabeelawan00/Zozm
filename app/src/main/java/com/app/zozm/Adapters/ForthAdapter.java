package com.app.zozm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zozm.R;

import java.util.ArrayList;

public class ForthAdapter extends RecyclerView.Adapter<ForthAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<String> forthArrayList;

    public ForthAdapter(Context mContext, ArrayList<String> forthArrayList) {
        this.mContext = mContext;
        this.forthArrayList = forthArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_item_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(forthArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return forthArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.tv);
        }
    }
}
