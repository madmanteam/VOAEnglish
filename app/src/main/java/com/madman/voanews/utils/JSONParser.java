package com.madman.voanews.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by madman on 4/15/16.
 */
public class JSONParser {
    private static final String TAG = "JSONParser";
    static InputStream is = null;
    static JSONObject json = null;
    static String jsonString = "";

    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {
        Log.i(TAG,"parsing url:["+url+"]");
        try {
            URL downloadUrl = new URL(url);
            is = downloadUrl.openStream();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            sb.append("{\"voas\":");
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            sb.append("}");
            is.close();
            jsonString = sb.toString();
            Log.d(TAG, "json:[" + jsonString + "]");
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            json = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        // return JSON String
        return json;
    }
}
