package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.app.zozm.Adapters.FirstAdapter;
import com.app.zozm.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    FirstAdapter firstAdapter;
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
        mLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        first_recyclerview.setLayoutManager(mLinearLayoutManager);
        second_recyclerview.setLayoutManager(mLinearLayoutManager);
        third_recycler.setLayoutManager(mLinearLayoutManager);
        forth_recycler.setLayoutManager(mLinearLayoutManager);

        ArrayList<String> firstArray = (ArrayList<String>) getIntent().getSerializableExtra("firstArray");
        ArrayList<String> secondArray = (ArrayList<String>) getIntent().getSerializableExtra("secondArray");
        ArrayList<String> thirdArray = (ArrayList<String>) getIntent().getSerializableExtra("thirdArray");
        ArrayList<String> forthArray = (ArrayList<String>) getIntent().getSerializableExtra("forthArray");

        if (firstArray.size() != 0) {
            setFirstAdapter(firstArray);
        } else {
            first_recyclerview.setVisibility(View.GONE);
        }

    }

    private void setFirstAdapter(ArrayList<String> firstArray) {

        firstAdapter = new FirstAdapter(this, firstArray);
        first_recyclerview.setAdapter(firstAdapter);

    }
}