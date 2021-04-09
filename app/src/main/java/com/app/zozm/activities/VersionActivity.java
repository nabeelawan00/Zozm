package com.app.zozm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozm.R;

public class VersionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);
        ImageView backArrow = findViewById(R.id.imageView15);

        setSupportActionBar(toolbar);
        mTitle.setText("عن التطبيق");
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        getSupportActionBar().setElevation(0);
//        final Drawable upArrow = getResources().getDrawable(R.drawable.back_arrow);
//        upArrow.setColorFilter(getResources().getColor(R.color.colorDarkGray), PorterDuff.Mode.SRC_ATOP);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(upArrow);


    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        onBackPressed();
//        return super.onOptionsItemSelected(item);
//    }
}