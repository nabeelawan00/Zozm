package com.app.zozm.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zozm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondCatagoryItemsActivity2 extends AppCompatActivity {

    boolean one = true, two = true, three = true, four = true, five = true, six = true, seavon = true, eight = true, nine = true, ten = true, eleven = true, tewelve = true, tera = true, choda = true, panda = true, solla = true;

    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.tv_four)
    TextView tvFour;
    @BindView(R.id.tv_five)
    TextView tvFive;
    @BindView(R.id.tv_six)
    TextView tvSix;
    @BindView(R.id.tv_seven)
    TextView tvSeven;
    @BindView(R.id.tv_eight)
    TextView tvEight;
    @BindView(R.id.tv_nine)
    TextView tvNine;
    @BindView(R.id.tv_ten)
    TextView tvTen;
    @BindView(R.id.tv_eleven)
    TextView tvEleven;
    @BindView(R.id.tv_tewelve)
    TextView tvTewelve;
    @BindView(R.id.tv_tera)
    TextView tvTera;
    @BindView(R.id.tv_choda)
    TextView tvChoda;
    @BindView(R.id.tv_pandra)
    TextView tvPandra;
    @BindView(R.id.tv_solla)
    TextView tvSolla;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.imageView15)
    ImageView imageView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_catagory_items2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.tv_four, R.id.tv_five, R.id.tv_six, R.id.tv_seven, R.id.tv_eight, R.id.tv_nine, R.id.tv_ten, R.id.tv_eleven, R.id.tv_tewelve, R.id.tv_tera, R.id.tv_choda, R.id.tv_pandra, R.id.tv_solla, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:

                if (one) {
                    tvOne.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    one = false;
                } else {

                    tvOne.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    one = true;

                }

                break;
            case R.id.tv_two:

                if (two) {
                    tvTwo.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    two = false;
                } else {

                    tvTwo.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    two = true;

                }

                break;
            case R.id.tv_three:


                if (three) {
                    tvThree.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    three = false;
                } else {

                    tvThree.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    three = true;

                }

                break;
            case R.id.tv_four:
                if (four) {
                    tvFour.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    four = false;
                } else {

                    tvFour.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    four = true;

                }
                break;
            case R.id.tv_five:

                if (five) {
                    tvFive.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    five = false;
                } else {

                    tvFive.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    five = true;

                }

                break;
            case R.id.tv_six:

                if (six) {
                    tvSix.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    six = false;
                } else {

                    tvSix.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    six = true;

                }


                break;
            case R.id.tv_seven:

                if (seavon) {
                    tvSeven.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    seavon = false;
                } else {

                    tvSeven.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    seavon = true;

                }


                break;
            case R.id.tv_eight:


                if (eight) {
                    tvEight.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    eight = false;
                } else {

                    tvEight.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    eight = true;

                }

                break;
            case R.id.tv_nine:

                if (nine) {
                    tvNine.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    nine = false;
                } else {

                    tvNine.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    nine = true;

                }


                break;


            case R.id.tv_ten:

                if (ten) {
                    tvTen.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    ten = false;
                } else {

                    tvTen.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    ten = true;

                }

                break;
            case R.id.tv_eleven:

                if (eleven) {
                    tvEleven.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    eleven = false;
                } else {

                    tvEleven.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    eleven = true;

                }

                break;
            case R.id.tv_tewelve:


                if (tewelve) {
                    tvTewelve.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    tewelve = false;
                } else {

                    tvTewelve.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    tewelve = true;

                }

                break;
            case R.id.tv_tera:


                if (tera) {
                    tvTera.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    tera = false;
                } else {

                    tvTera.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    tera = true;

                }

                break;
            case R.id.tv_choda:


                if (choda) {
                    tvChoda.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    choda = false;
                } else {

                    tvChoda.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    choda = true;

                }

                break;
            case R.id.tv_pandra:

                if (panda) {
                    tvPandra.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    panda = false;
                } else {

                    tvPandra.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    panda = true;

                }

                break;
            case R.id.tv_solla:


                if (solla) {
                    tvSolla.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    solla = false;
                } else {

                    tvSolla.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    solla = true;

                }

                break;
            case R.id.button2:

                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);

                break;
        }
    }

    @OnClick(R.id.imageView15)
    public void onClick() {
        onBackPressed();
    }
}