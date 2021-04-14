package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozm.R;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText name, phone;
    TextView tvOne, tvTwo, tvThree, tvFour;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        backArrow = findViewById(R.id.imageView15);
        setSupportActionBar(toolbar);
        mTitle.setText("أكمل الطلب");
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        initilisationViews();

    }

    private void initilisationViews() {

        tvOne = findViewById(R.id.tv_one);
        tvTwo = findViewById(R.id.tv_two);
        tvThree = findViewById(R.id.tv_three);
        tvFour = findViewById(R.id.tv_four);

        button = findViewById(R.id.btn_order);
        name = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.ed_phone);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_order:

                if (!name.getText().toString().isEmpty()) {
                    if (!phone.getText().toString().isEmpty()) {

                        // send order mail

                    } else {
                        Toast.makeText(this, "Enter Phone number", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}