package com.app.zozm.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zozm.R;
import com.app.zozm.activities.EightCatagoryItemsActivity;
import com.app.zozm.activities.FifthCatagoryItemsActivity;
import com.app.zozm.activities.FirstCatagoryItemsActivity;
import com.app.zozm.activities.ForthCatagoryItemsActivity;
import com.app.zozm.activities.PaperItemActivity;
import com.app.zozm.activities.SecondCatagoryItemsActivity2;
import com.app.zozm.activities.SeventhCatagoryItemsActivity;
import com.app.zozm.activities.SixthCatagoryItemsActivity;
import com.app.zozm.activities.ThirdCatagoryItemsActivity;

public class ItemCatagoryAdapter extends RecyclerView.Adapter<ItemCatagoryAdapter.MyViewHolder> {

    Context mContext;
    int[] iconsArray;
    String[] itemname;


    public ItemCatagoryAdapter(Context mContext, int[] flags, String[] itemnames) {
        this.mContext = mContext;
        this.iconsArray = flags;
        this.itemname = itemnames;
    }

    @NonNull
    @Override
    public ItemCatagoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ItemCatagoryAdapter.MyViewHolder holder, final int position) {

        holder.image.setImageResource(iconsArray[position]);
        holder.textView.setText(itemname[position]);
        if (position == 0) {

            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1A3327")));

        } else if (position == 1) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#816B89")));
        } else if (position == 2) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#468397")));
        } else if (position == 3) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2C7E4E")));
        } else if (position == 4) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#333333")));
        } else if (position == 5) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#832C4B")));
        } else if (position == 6) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#482525")));
        } else if (position == 7) {
            holder.view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#696A2B")));
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:

                        Intent intent1 = new Intent(mContext, FirstCatagoryItemsActivity.class);
                        mContext.startActivity(intent1);

                        break;
                    case 1:
                        Intent intent2 = new Intent(mContext, SecondCatagoryItemsActivity2.class);
                        mContext.startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(mContext, ThirdCatagoryItemsActivity.class);

                        mContext.startActivity(intent3);
                        break;
                    case 3:

                        Intent intent4 = new Intent(mContext, ForthCatagoryItemsActivity.class);

                        mContext.startActivity(intent4);
                        break;
                    case 4:

                        Intent intent5 = new Intent(mContext, FifthCatagoryItemsActivity.class);
                        mContext.startActivity(intent5);
                        break;
                    case 5:

                        Intent intent6 = new Intent(mContext, SixthCatagoryItemsActivity.class);
                        mContext.startActivity(intent6);
                        break;
                    case 6:

                        Intent intent7 = new Intent(mContext, SeventhCatagoryItemsActivity.class);
                        mContext.startActivity(intent7);
                        break;
                    case 7:

                        Intent intent8 = new Intent(mContext, EightCatagoryItemsActivity.class);
                        mContext.startActivity(intent8);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return iconsArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textView;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView.findViewById(R.id.view6);
            this.image = itemView.findViewById(R.id.imageView10);
            this.textView = itemView.findViewById(R.id.tv);
        }
    }
}
