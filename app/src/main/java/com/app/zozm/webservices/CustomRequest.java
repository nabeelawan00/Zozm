package com.app.zozm.webservices;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CustomRequest extends Request {

    protected static final String TYPE_UTF8_CHARSET = "charset=UTF-8";

    private Response.Listener listener;
    private Map<String, String> params;

    public CustomRequest(int method, String url, Map<String, String> params, Response.Listener<JSONObject> responceListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = responceListener;
        this.params = params;
    }

    @Override
    protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {

        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "UTF-8"));
            return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(Object response) {
        listener.onResponse(response);
    }
}


