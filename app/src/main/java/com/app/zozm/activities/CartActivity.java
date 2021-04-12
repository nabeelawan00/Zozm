package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.zozm.R;

public class CartActivity extends AppCompatActivity {

    RecyclerView first_recyclerview, second_recyclerview, third_recycler, forth_recycler;
    LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        first_recyclerview = findViewById(R.id.first_recyclerview);
        second_recyclerview = findViewById(R.id.second_recyclerview);
        third_recycler = findViewById(R.id.third_recycler);
        forth_recycler = findViewById(R.id.forth_recycler);
        mLinearLayoutManager = new LinearLayoutManager(this);
        first_recyclerview.setLayoutManager(mLinearLayoutManager);
        second_recyclerview.setLayoutManager(mLinearLayoutManager);
        third_recycler.setLayoutManager(mLinearLayoutManager);
        forth_recycler.setLayoutManager(mLinearLayoutManager);




    }
}