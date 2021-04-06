package com.app.zozm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.zozm.Adapters.PaperItemAdapter;
import com.app.zozm.R;

public class PaperItemActivity extends AppCompatActivity {

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    PaperItemAdapter paperItemAdapter;
    String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getSupportActionBar().setElevation(0);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorDarkGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        Intent intent = getIntent();

        check = intent.getStringExtra("check");

        initilisationView();

    }

    private void initilisationView() {

        recyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (check.equals("FirstCatagory")) {
            final String firstCatagoryItems[] = {
                    "10بوك",
                    "20بوك",
                    "50بوك",
                    "100بوك",
                    "ملصقات وإعلانات",
                    "ورق مراسلات",
                    "شهادات ودروع",
                    "بروشور أو مطوم"
            };

            setItemAdatper(firstCatagoryItems);

        } else if (check.equals("SecondCatagory")) {

            final String items[] = {
                    "سند قبض",
                    "سند لأمر",
                    "عقد إيجار",
                    "عقد بيع",
                    "عقد شراء",
                    "عرض سمر",
                    "عقد عمل",
                    "عقد مقاولات",
                    "مسير رواتب",
                    "دفتر يومية",
                    "محضر",
                    "كمبيالة",
                    "10 بوك",
                    "25 بوك",
                    "50 بوك",
                    "100 بوك"
            };

            setItemAdatper(items);

        } else if (check.equals("thirdCatagory")) {

            final String items[] = {
                    "10 كرتون",
                    "20 كرتون",
                    "40 كرتون",
                    "50 كرتون",
                    "أصل وصورة",
                    "أصل وصورتان",
                    "أصل و 3 صور",
                    "أصل و 4 صور",
                    "لون واحد",
                    "الونان",
                    "3 ألوان",
                    "4 ألوان"
            };

            setItemAdatper(items);

        } else if (check.equals("forthCatagory")) {

            final String items[] = {
                    "10كرت شخصي",
                    "كرت زواج",
                    "دعوة خاصة",
                    "بطاقة تعريفموظف",
                    "500",
                    "1000",
                    "2000",
                    "3000",
                    "وجه",
                    "وجهين"
            };

            setItemAdatper(items);

        } else if (check.equals("fithCatagory")) {

            final String items[] = {
                    "طباعة بنر",
                    "طباعة فلكس",
                    "طباعة رول آب",
                    "طباعة ستاند",
                    "طباعة وايت فلم",
                    "طباعة ملصق بلاستيك",
                    "طباعة ملصق ورق",
                    "طباعة ملصق شفاف",
                    "م 1X1",
                    "م 1X1",
                    "م 1X1",
                    " 60 x 60سم",
                    "2 X 2 م",
                    "3 X 2 م",
                    "30X30سم",
                    " 50 X 50سم"
            };

            setItemAdatper(items);

        } else if (check.equals("sixthCatagory")) {

            final String items[] = {
                    "10 بوك ورق مراسلات   رسمي",
                    "20 بوك ورق مراسلات رسمي",
                    "50 بوك ورق مراسلات رسمي",
                    "100 بوك ورق مراسلاترسمي",
                    "ظرف مقاس صغير",
                    "ظرف مقاس وسط",
                    "ظرف مقاس كبير",
                    "ظرف كبير A3",
                    "مذكرة مقاس صغير",
                    "مذكرة مقاس وسط",
                    "مذكرة مقاس كبير",
                    "folder",
                    "1000",
                    "2000",
                    "5000",
                    "10000"
            };

            setItemAdatper(items);

        } else if (check.equals("sevenCatagory")) {

        } else {

        }

    }

    private void setItemAdatper(String[] items) {
        paperItemAdapter = new PaperItemAdapter(this, items);
        recyclerView.setAdapter(paperItemAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}