package com.app.zozm;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;


import com.app.zozm.Utils.ShareMemory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Nabeel on 3/22/2018.
 */

public class ZOZMApplication extends Application {

    private ShareMemory shareMemory;

    @Override
    public void onCreate() {
        super.onCreate();
        ShareMemory.init(this);
        shareMemory = ShareMemory.getmInstance();

        printHashKey();
    }

    public void printHashKey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.nabeel.athan", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("SHA: ", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
