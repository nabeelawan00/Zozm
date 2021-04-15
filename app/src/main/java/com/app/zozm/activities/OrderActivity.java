package com.app.zozm.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozm.R;
import com.app.zozm.Utils.AppURL;
import com.app.zozm.interfaces.ResponseErrorInterface;
import com.app.zozm.interfaces.ResponseInterface;
import com.app.zozm.webservices.ParameterService;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.internal.Utils;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener, ResponseErrorInterface, ResponseInterface {

    Button button;
    EditText name, phone;
    TextView tvOne, tvTwo, tvThree, tvFour;
    ImageView backArrow;
    String orderDetail = "";
    String desiredString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.textView11);

        backArrow = findViewById(R.id.imageView15);
        setSupportActionBar(toolbar);
        mTitle.setText("أكمل الطلب");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ArrayList<String> firstArray = (ArrayList<String>) getIntent().getSerializableExtra("firstArray");
        ArrayList<String> secondArray = (ArrayList<String>) getIntent().getSerializableExtra("secondArray");
        ArrayList<String> thirdArray = (ArrayList<String>) getIntent().getSerializableExtra("thirdArray");
        ArrayList<String> forthArray = (ArrayList<String>) getIntent().getSerializableExtra("forthArray");

        if (firstArray.size() != 0) {
            for (int i = 0; i < firstArray.size(); i++) {
                orderDetail = orderDetail + " , " + firstArray.get(i);
            }
        }

        if (secondArray.size() != 0) {
            for (int i = 0; i < secondArray.size(); i++) {
                orderDetail = orderDetail + " , " + secondArray.get(i);
            }
        }

        if (thirdArray.size() != 0) {
            for (int i = 0; i < thirdArray.size(); i++) {
                orderDetail = orderDetail + " , " + thirdArray.get(i);
            }
        }

        if (forthArray.size() != 0) {
            for (int i = 0; i < forthArray.size(); i++) {
                orderDetail = orderDetail + " , " + forthArray.get(i);
            }
        }

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

                if (!phone.getText().toString().isEmpty()) {
                    CharSequence foo = phone.getText();
                    String bar = foo.toString();
                    desiredString = bar.substring(0, 3);
                } else {

                    new iOSDialogBuilder(this)
                            .setTitle(this.getString(R.string.title))
                            .setSubtitle("Enter Phone number")
                            .setBoldPositiveLabel(true)
                            .setCancelable(false)
                            .setPositiveListener(this.getString(R.string.ok1), new iOSDialogClickListener() {
                                @Override
                                public void onClick(iOSDialog dialog) {
                                    dialog.dismiss();

                                }
                            })
                            .build().show();

                }

                if (!name.getText().toString().isEmpty()) {
                    if (!phone.getText().toString().isEmpty() && phone.getText().length() < 10 && desiredString.equals("051")) {

                        // send order mail
                        Map<String, String> params = new HashMap<>();
                        params.put("name", name.getText().toString());
                        params.put("phone", phone.getText().toString());
                        params.put("subject", "Print Order");
                        params.put("message", orderDetail);

                        ParameterService parameterService = new ParameterService(this, this, this);
                        parameterService.getData(params, AppURL.url);

                    } else {

                        new iOSDialogBuilder(this)
                                .setTitle(this.getString(R.string.title))
                                .setSubtitle("Enter Phone number")
                                .setBoldPositiveLabel(true)
                                .setCancelable(false)
                                .setPositiveListener(this.getString(R.string.ok1), new iOSDialogClickListener() {
                                    @Override
                                    public void onClick(iOSDialog dialog) {
                                        dialog.dismiss();

                                    }
                                })
                                .build().show();
                    }

                } else {

                    new iOSDialogBuilder(this)
                            .setTitle(this.getString(R.string.title))
                            .setSubtitle("Enter your name")
                            .setBoldPositiveLabel(true)
                            .setCancelable(false)
                            .setPositiveListener(this.getString(R.string.ok1), new iOSDialogClickListener() {
                                @Override
                                public void onClick(iOSDialog dialog) {
                                    dialog.dismiss();

                                }
                            })
                            .build().show();
                }

                break;
        }
    }

    @Override
    public void getError() {

    }

    @Override
    public void getResponse(Object o) {

        JSONObject object = (JSONObject) o;

        try {
            boolean status = object.getBoolean("status");
            if (status) {
                String message = object.getString("Message");
                new iOSDialogBuilder(this)
                        .setTitle(this.getString(R.string.title))
                        .setSubtitle(message)
                        .setBoldPositiveLabel(true)
                        .setCancelable(false)
                        .setPositiveListener(this.getString(R.string.ok1), new iOSDialogClickListener() {
                            @Override
                            public void onClick(iOSDialog dialog) {
                                dialog.dismiss();

                            }
                        })
                        .build().show();

            } else {

                new iOSDialogBuilder(this)
                        .setTitle(this.getString(R.string.title))
                        .setSubtitle(this.getString(R.string.subtitlenet))
                        .setBoldPositiveLabel(true)
                        .setCancelable(false)
                        .setPositiveListener(this.getString(R.string.ok1), new iOSDialogClickListener() {
                            @Override
                            public void onClick(iOSDialog dialog) {
                                dialog.dismiss();

                            }
                        })
                        .build().show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}