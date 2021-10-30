package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.zozm.R;

public class AshyaAkhriActivity extends AppCompatActivity {

    Button button;
    ImageView imageView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashya_akhri);

        button = findViewById(R.id.button2);
        imageView15 = findViewById(R.id.imageView15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), WhatsappOrderActivity.class);
                intent.putExtra("intentCheck", false);

                startActivity(intent);
            }
        });

        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

}