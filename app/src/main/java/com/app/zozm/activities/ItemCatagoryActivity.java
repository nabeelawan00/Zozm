package com.app.zozm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.zozm.Adapters.ItemCatagoryAdapter;
import com.app.zozm.R;

public class ItemCatagoryActivity extends AppCompatActivity {

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    ItemCatagoryAdapter itemCatagoryAdapter;
    private final String itemnames[] = {
            "سندات وعقود",
            "فواتير",
            "فواتير كمبيوتر",
            "بطاقات و كروت",
            "ملصقات وإعلانات",
            "ورق مراسلات",
            "شهادات ودروع",
            "بروشور أو مطوم"
    };

    int flags[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seavon, R.drawable.eight};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_catagory);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);

        setSupportActionBar(toolbar);
        mTitle.setText("اختر الخدمة التي تريد");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getSupportActionBar().setElevation(0);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorDarkGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        initilisationView();
    }

    private void initilisationView() {

        recyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new GridLayoutManager(ItemCatagoryActivity.this, getSpanCount());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setItemAdatper();

    }

    private void setItemAdatper() {
        itemCatagoryAdapter = new ItemCatagoryAdapter(this, flags,itemnames);
        recyclerView.setAdapter(itemCatagoryAdapter);
    }

    private int getSpanCount() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int wirth = metrics.widthPixels;

        Float dimention = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 150, metrics
        );
        return (int) (wirth / dimention);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}