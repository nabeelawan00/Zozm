package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozm.Adapters.FirstAdapter;
import com.app.zozm.Adapters.ForthAdapter;
import com.app.zozm.Adapters.SecondAdapter;
import com.app.zozm.Adapters.ThirdAdapter;
import com.app.zozm.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    FirstAdapter firstAdapter;
    SecondAdapter secondAdapter;
    ThirdAdapter thirdAdapter;
    ForthAdapter forthAdapter;
    ImageView imageView15;
    Button buttonNext;

    RecyclerView first_recyclerview, second_recyclerview, third_recycler, forth_recycler;
    LinearLayoutManager firstLinearLayoutManager, secondLinearLayoutManager, thirdLinearLayoutManager, forthLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);

        setSupportActionBar(toolbar);
        mTitle.setText("أكمل الطلب");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        imageView15 = findViewById(R.id.imageView15);
        buttonNext = findViewById(R.id.button2);

        first_recyclerview = findViewById(R.id.first_recyclerview);
        second_recyclerview = findViewById(R.id.second_recyclerview);
        third_recycler = findViewById(R.id.third_recycler);
        forth_recycler = findViewById(R.id.forth_recycler);

        firstLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        secondLinearLayoutManager = new GridLayoutManager(this, 4);
        thirdLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        forthLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        first_recyclerview.setLayoutManager(firstLinearLayoutManager);
        second_recyclerview.setLayoutManager(secondLinearLayoutManager);
        third_recycler.setLayoutManager(thirdLinearLayoutManager);
        forth_recycler.setLayoutManager(forthLinearLayoutManager);

        ArrayList<String> firstArray = (ArrayList<String>) getIntent().getSerializableExtra("firstArray");
        ArrayList<String> secondArray = (ArrayList<String>) getIntent().getSerializableExtra("secondArray");
        ArrayList<String> thirdArray = (ArrayList<String>) getIntent().getSerializableExtra("thirdArray");
        ArrayList<String> forthArray = (ArrayList<String>) getIntent().getSerializableExtra("forthArray");

        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, OrderActivity.class);


                intent.putExtra("firstArray", firstArray);
                intent.putExtra("secondArray", secondArray);
                intent.putExtra("thirdArray", thirdArray);
                intent.putExtra("forthArray", forthArray);


                startActivity(intent);
            }
        });

        if (firstArray.size() != 0) {
            setFirstAdapter(firstArray);
        } else {
            first_recyclerview.setVisibility(View.GONE);
        }


        if (secondArray.size() != 0) {
            setSecondAdapter(secondArray);
        } else {
            second_recyclerview.setVisibility(View.GONE);
        }


        if (thirdArray.size() != 0) {
            setThirdAdapter(thirdArray);
        } else {
            third_recycler.setVisibility(View.GONE);
        }


        if (forthArray.size() != 0) {
            setForthAdapter(forthArray);
        } else {
            forth_recycler.setVisibility(View.GONE);
        }

    }

    private void setForthAdapter(ArrayList<String> forthArray) {

        forthAdapter = new ForthAdapter(this, forthArray);
        forth_recycler.setAdapter(forthAdapter);

    }

    private void setThirdAdapter(ArrayList<String> thirdArray) {

        thirdAdapter = new ThirdAdapter(this, thirdArray);
        third_recycler.setAdapter(thirdAdapter);

    }

    private void setSecondAdapter(ArrayList<String> secondArray) {

        secondAdapter = new SecondAdapter(this, secondArray);
        second_recyclerview.setAdapter(secondAdapter);

    }

    private void setFirstAdapter(ArrayList<String> firstArray) {

        firstAdapter = new FirstAdapter(this, firstArray);
        first_recyclerview.setAdapter(firstAdapter);

    }
}