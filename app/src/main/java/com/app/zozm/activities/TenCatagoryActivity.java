package com.app.zozm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozm.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TenCatagoryActivity extends AppCompatActivity {

    ArrayList<String> firstArray;
    ArrayList<String> secondArray;
    ArrayList<String> thirdArray;
    ArrayList<String> forthArray;
    TextView textView11;

    boolean one = true, two = true, three = true, four = true, five = true, six = true, seavon = true, eight = true, nine = true, ten = true, eleven = true, tewelve = true, tera = true, choda = true, panda = true, solla = true, satara = true, athara = true, unni = true, twanty = true;

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
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.tv_solla)
    TextView tvSolla;
    @BindView(R.id.tv_pandra)
    TextView tvPandra;
    @BindView(R.id.tv_choda)
    TextView tvChoda;
    @BindView(R.id.tv_tera)
    TextView tvTera;
    @BindView(R.id.tv_satara)
    TextView tvSatara;
    @BindView(R.id.tv_athara)
    TextView tvAthara;
    @BindView(R.id.tv_unni)
    TextView tvUnni;
    @BindView(R.id.tv_twanty)
    TextView tvTwanty;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView15)
    ImageView imageView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_catagory);

        firstArray = new ArrayList<>();
        secondArray = new ArrayList<>();
        thirdArray = new ArrayList<>();
        forthArray = new ArrayList<>();

        textView11 = findViewById(R.id.textView11);
        textView11.setText("اختر الخدمة التي تريد");

        ButterKnife.bind(this);
    }


    @OnClick({R.id.toolbar, R.id.textView11, R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.tv_four, R.id.tv_five, R.id.tv_six, R.id.tv_seven, R.id.tv_eight, R.id.tv_nine, R.id.tv_ten, R.id.tv_eleven, R.id.tv_tewelve, R.id.button2, R.id.tv_solla, R.id.tv_pandra, R.id.tv_choda, R.id.tv_tera, R.id.tv_satara, R.id.tv_athara, R.id.tv_unni, R.id.tv_twanty})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                if (one) {
                    tvOne.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    one = false;
                    firstArray.add(tvOne.getText().toString());
                } else {

                    tvOne.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    firstArray.remove(tvOne.getText().toString());
                    one = true;

                }
                break;
            case R.id.tv_two:
                if (two) {
                    tvTwo.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    two = false;
                    firstArray.add(tvTwo.getText().toString());
                } else {

                    tvTwo.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    two = true;
                    firstArray.remove(tvTwo.getText().toString());

                }
                break;
            case R.id.tv_three:
                if (three) {
                    tvThree.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    three = false;
                    firstArray.add(tvThree.getText().toString());
                } else {

                    tvThree.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    three = true;
                    firstArray.remove(tvThree.getText().toString());

                }
                break;
            case R.id.tv_four:

                if (four) {
                    tvFour.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    four = false;
                    firstArray.add(tvFour.getText().toString());
                } else {

                    tvFour.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    four = true;
                    firstArray.remove(tvFour.getText().toString());

                }

                break;
            case R.id.tv_five:

                if (five) {
                    tvFive.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    five = false;
                    secondArray.add(tvFive.getText().toString());
                } else {

                    tvFive.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    five = true;
                    secondArray.remove(tvFive.getText().toString());

                }


                break;
            case R.id.tv_six:

                if (six) {
                    tvSix.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    six = false;
                    secondArray.add(tvSix.getText().toString());
                } else {

                    tvSix.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    six = true;
                    secondArray.remove(tvSix.getText().toString());

                }

                break;
            case R.id.tv_seven:

                if (seavon) {
                    tvSeven.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    seavon = false;
                    secondArray.add(tvSeven.getText().toString());
                } else {

                    tvSeven.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    seavon = true;
                    secondArray.remove(tvSeven.getText().toString());

                }

                break;
            case R.id.tv_eight:

                if (eight) {
                    tvEight.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    eight = false;
                    secondArray.add(tvEight.getText().toString());
                } else {

                    tvEight.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    eight = true;
                    secondArray.remove(tvEight.getText().toString());

                }


                break;
            case R.id.tv_nine:

                if (nine) {
                    tvNine.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    nine = false;
                    secondArray.add(tvNine.getText().toString());
                } else {

                    tvNine.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    nine = true;
                    secondArray.remove(tvNine.getText().toString());

                }

                break;
            case R.id.tv_ten:

                if (ten) {
                    tvTen.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    ten = false;
                    secondArray.add(tvTen.getText().toString());
                } else {

                    tvTen.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    ten = true;
                    secondArray.remove(tvTen.getText().toString());

                }

                break;
            case R.id.tv_eleven:

                if (eleven) {
                    tvEleven.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    eleven = false;
                    secondArray.add(tvEleven.getText().toString());
                } else {

                    tvEleven.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    eleven = true;
                    secondArray.remove(tvEleven.getText().toString());

                }
                break;
            case R.id.tv_tewelve:

                if (tewelve) {
                    tvTewelve.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    tewelve = false;
                    secondArray.add(tvTewelve.getText().toString());
                } else {

                    tvTewelve.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    tewelve = true;
                    secondArray.remove(tvTewelve.getText().toString());

                }
                break;
            case R.id.tv_solla:

                if (solla) {
                    tvSolla.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    solla = false;
                    thirdArray.add(tvSolla.getText().toString());
                } else {

                    tvSolla.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    solla = true;
                    thirdArray.remove(tvSolla.getText().toString());

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
            case R.id.tv_choda:

                if (choda) {
                    tvChoda.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    choda = false;
                    thirdArray.add(tvChoda.getText().toString());
                } else {

                    tvChoda.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    choda = true;
                    thirdArray.remove(tvChoda.getText().toString());
                }

                break;
            case R.id.tv_tera:

                if (tera) {
                    tvTera.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    tera = false;
                    thirdArray.add(tvTera.getText().toString());
                } else {

                    tvTera.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    tera = true;
                    thirdArray.remove(tvTera.getText().toString());

                }
                break;
            case R.id.tv_satara:
                if (satara) {
                    tvSatara.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    satara = false;
                    forthArray.add(tvSatara.getText().toString());
                } else {

                    tvSatara.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    satara = true;
                    forthArray.remove(tvSatara.getText().toString());

                }
                break;
            case R.id.tv_athara:
                if (athara) {
                    tvAthara.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    athara = false;
                    forthArray.add(tvAthara.getText().toString());
                } else {

                    tvAthara.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    athara = true;
                    forthArray.remove(tvAthara.getText().toString());

                }
                break;
            case R.id.tv_unni:
                if (unni) {
                    tvUnni.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    unni = false;
                    forthArray.add(tvUnni.getText().toString());
                } else {

                    tvUnni.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    unni = true;
                    forthArray.remove(tvUnni.getText().toString());

                }
                break;
            case R.id.tv_twanty:
                if (twanty) {
                    tvTwanty.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                            PorterDuff.Mode.SRC_ATOP);
                    twanty = false;
                } else {

                    tvTwanty.getBackground().setColorFilter(getResources().getColor(R.color.colorGray),
                            PorterDuff.Mode.SRC_ATOP);
                    twanty = true;

                }
                break;
            case R.id.button2:

                Intent intent = new Intent(this, CartActivity.class);

                intent.putExtra("firstArray", firstArray);
                intent.putExtra("secondArray", secondArray);
                intent.putExtra("thirdArray", thirdArray);
                intent.putExtra("forthArray", forthArray);

                startActivity(intent);

                break;
        }
    }

    @OnClick(R.id.imageView15)
    public void onClick() {
        onBackPressed();
    }
}