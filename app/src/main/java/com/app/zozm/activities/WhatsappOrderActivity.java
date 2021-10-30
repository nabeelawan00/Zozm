package com.app.zozm.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozm.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class WhatsappOrderActivity extends AppCompatActivity implements View.OnClickListener {

    View button;
    ImageView backArrow;
    String orderDetail = "";
    String desiredString;
    Boolean check;

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Unregister self right away
            context.unregisterReceiver(receiver);

            ComponentName component = intent.getParcelableExtra(Intent.EXTRA_CHOSEN_COMPONENT);

//            if (component != null) {
//                if (!mMainActivity.mPrefs.isFirstRun() && component.getPackageName().equalsIgnoreCase("com.whatsapp.w4b")) {
//                    mMainActivity.mPrefs.setFirstRun();
//                }
//            }
            // Component will hold the package info of the app the user chose
//            ComponentName component = intent.getParcelableExtra<ComponentName>(Intent.EXTRA_CHOSEN_COMPONENT);
            // Do something with component
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp_order);

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

        check = getIntent().getBooleanExtra("intentCheck", true);

        if (check) {

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

        } else {

            orderDetail = "أشياء اخرى";

        }

        initilisationViews();

    }

    private void initilisationViews() {

        button = findViewById(R.id.btn_order);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_order:


                String orderText = orderDetail;

                String whatsappNumber = "966505449345";

                if (checkAppInstalledOrNot("com.whatsapp") |
                        checkAppInstalledOrNot("com.whatsapp.w4b")) {

                    Intent normal = new Intent();
                    normal.setAction(Intent.ACTION_SEND);
                    normal.putExtra("jid", PhoneNumberUtils.stripSeparators(whatsappNumber) + "@s.whatsapp.net");//phone number without "+" prefix
                    normal.putExtra(Intent.EXTRA_TEXT, orderText);
                    normal.setType("text/plain");
                    normal.setPackage("com.whatsapp");

                    Intent business = new Intent();
                    business.setAction(Intent.ACTION_SEND);
                    business.setPackage("com.whatsapp.w4b");
//                    if (!this.mPrefs.isFirstRun()) {
//                        business.setComponent(new ComponentName("com.whatsapp.w4b", "com.whatsapp.Conversation"));
//                    }
                    business.putExtra("jid", PhoneNumberUtils.stripSeparators(whatsappNumber) + "@s.whatsapp.net");//phone number without "+" prefix
                    business.putExtra(Intent.EXTRA_TEXT, orderText);
                    business.setType("text/plain");

                    final String shareAction = "com.yourdomain.share.SHARE_ACTION";
                    Intent i = new Intent(shareAction);
                    i.putExtra("test", "test");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

//                    startActivity(Intent.createChooser(normal, ""));

                    Intent chooserIntent = Intent.createChooser(normal, "");
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                        chooserIntent = Intent.createChooser(normal, "",pendingIntent.getIntentSender());
                    }
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{business});

                    startActivityForResult(chooserIntent, 100);
//                    someActivityResultLauncher.launch(chooserIntent);

                    this.registerReceiver(receiver, new IntentFilter(shareAction));

                } else {
                    Toast.makeText(this, getString(R.string.whats_app_error), Toast.LENGTH_SHORT).show();
                }

//                showBottomSheetDialog();

                break;
        }
    }

    private boolean checkAppInstalledOrNot(String uri) {
        PackageManager pm = getApplicationContext().getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);

        ImageView whatsapp = bottomSheetDialog.findViewById(R.id.imageView19);
        ImageView whatsappBusiness = bottomSheetDialog.findViewById(R.id.imageView18);


        bottomSheetDialog.show();

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String smsNumber = "966505449345";
//
                Log.d("fsdfasdf", "onClick: " + orderDetail);

                try {
                    String text = "This is a test";// Replace with your message.

                    String toNumber = "xxxxxxxxxx"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
                    //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


                    PackageManager pm = WhatsappOrderActivity.this.getPackageManager();

                    pm.getPackageInfo("com.whatsapp.w4b", PackageManager.GET_ACTIVITIES);
//                    pm.getPackageInfo("com.whatsapp.w4b", PackageManager.GET_ACTIVITIES);

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + orderDetail));
                    startActivity(i);


//                    Intent whatsAppIntent = new Intent(Intent.ACTION_VIEW);
//                    whatsAppIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + orderDetail));
//                    startActivity(whatsAppIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                bottomSheetDialog.dismiss();
            }
        });

        whatsappBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




//                String smsNumber = "966505449345";
////
//                Log.d("fsdfasdf", "onClick: " + orderDetail);
//
//                try {
//                    String text = "This is a test";// Replace with your message.
//
//                    String toNumber = "xxxxxxxxxx"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
//                    //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
//
//
//                    PackageManager pm = WhatsappOrderActivity.this.getPackageManager();
//
////                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
//                    pm.getPackageInfo("com.whatsapp.w4b", PackageManager.GET_ACTIVITIES);
//
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + orderDetail));
//                    startActivity(i);
//
////                    Intent whatsAppIntent = new Intent(Intent.ACTION_VIEW);
////                    whatsAppIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + orderDetail));
////                    startActivity(whatsAppIntent);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


                bottomSheetDialog.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}