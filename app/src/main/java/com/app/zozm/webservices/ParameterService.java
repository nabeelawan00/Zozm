package com.app.zozm.webservices;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.app.zozm.R;
import com.app.zozm.Utils.ShareMemory;
import com.app.zozm.Utils.UtilsProgressbar;
import com.app.zozm.interfaces.ResponseErrorInterface;
import com.app.zozm.interfaces.ResponseInterface;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ParameterService {

    RequestQueue requestQueue;
    Context mContext;
    ResponseInterface responceInterface;
    ResponseErrorInterface responseErrorInterface;
    KProgressHUD kProgressHUD;


    public ParameterService(Context mContext, ResponseInterface favouriteInterface, ResponseErrorInterface responseErrorInterface) {
        this.mContext = mContext;
        this.responceInterface = favouriteInterface;
        this.responseErrorInterface = responseErrorInterface;
        this.requestQueue = Volley.newRequestQueue(mContext);
        kProgressHUD = UtilsProgressbar.showProgressDialog(mContext);

    }

    public void getData(Map<String, String> params, final String url) {

//        kProgressHUD.show();

        final CustomRequest jsonObjectRequest = new CustomRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

//                kProgressHUD.dismiss();
                responceInterface.getResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                kProgressHUD.dismiss();
                Log.d("dfads", "onErrorResponse: " + error.getMessage());
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

                responseErrorInterface.getError();

            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(6000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(jsonObjectRequest);
    }
}
