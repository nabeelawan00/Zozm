package com.app.zozm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozm.R;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText name, phone;
    TextView tvOne, tvTwo, tvThree, tvFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);

        setSupportActionBar(toolbar);
        mTitle.setText("أكمل الطلب");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getSupportActionBar().setElevation(0);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorDarkGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        initilisationViews();
        
    }

    private void initilisationViews() {

        tvOne = findViewById(R.id.tv_one);
        tvTwo = findViewById(R.id.tv_two);
        tvThree = findViewById(R.id.tv_three);
        tvFour = findViewById(R.id.tv_four);

        button = findViewById(R.id.button);
        name = findViewById(R.id.ed_name);
        phone = findViewById(R.id.ed_phone);

        button.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:

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