package com.app.zozm.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nabeel on 3/22/2018.
 */

public class ShareMemory {

    public static String sharename = "ZOZM";

    SharedPreferences prefs;

    public static Context mContext;
    public static ShareMemory mInstance;

    public boolean isThisSessionFromLink;

    public ShareMemory(Context ctx) {

        prefs = ctx.getSharedPreferences(sharename, Context.MODE_PRIVATE);
        isThisSessionFromLink = false;
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static ShareMemory getmInstance() {
        if (mInstance != null) {
            return mInstance;
        } else {
            mInstance = new ShareMemory(mContext.getApplicationContext());
        }
        return mInstance;
    }

    public void setFCMToken(String name) {
        prefs.edit().putString("firebaseToken", name).commit();
    }

    public String getFCMToken() {
        return prefs.getString("firebaseToken", null);
    }


}
