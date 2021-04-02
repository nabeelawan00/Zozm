package com.app.zozm.webservices;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.zozm.R;
import com.app.zozm.Utils.UtilsProgressbar;
import com.app.zozm.interfaces.ResponseInterface;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;
import com.kaopiz.kprogresshud.KProgressHUD;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class POSTService {

    Context mContext;
    ResponseInterface responseInterface;
    RequestQueue mRequestQueue;
    KProgressHUD kProgressHUD;
    int requestMethod;

    public POSTService(Context mContext, ResponseInterface responseInterface) {
        this.mContext = mContext;
        this.responseInterface = responseInterface;
        this.mRequestQueue = Volley.newRequestQueue(mContext);
        kProgressHUD = UtilsProgressbar.showProgressDialog(mContext);
    }

    public void getData(String url, int method) {
//        kProgressHUD.show();

        if (method == Request.Method.GET) {
            this.requestMethod = method;
        } else {
            this.requestMethod = method;
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(requestMethod, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                kProgressHUD.dismiss();
                responseInterface.getResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
//                kProgressHUD.dismiss();
                new iOSDialogBuilder(mContext)
                        .setTitle(mContext.getString(R.string.title))
                        .setSubtitle(mContext.getString(R.string.subtitlenet))
                        .setBoldPositiveLabel(true)
                        .setCancelable(false)
                        .setPositiveListener(mContext.getString(R.string.ok1), new iOSDialogClickListener() {
                            @Override
                            public void onClick(iOSDialog dialog) {
                                dialog.dismiss();

                            }
                        })
                        .build().show();
            }
        });

        mRequestQueue.add(jsonObjectRequest);
    }
}
