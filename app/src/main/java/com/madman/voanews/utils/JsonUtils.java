package com.madman.voanews.utils;

import android.content.Context;
import android.util.Log;

import com.madman.voanews.db.DBUtils;
import com.madman.voanews.db.VOANews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by madman on 4/15/16.
 */
public class JsonUtils {

    private static final HashMap<String, String> URL_SOURCES = new HashMap<>();
    private static final String URL_LEARNING = "https://voareader-lidemin.rhcloud.com/voa?start=0&count=50&type=learning";
    private static final String URL_NEWS = "https://voareader-lidemin.rhcloud.com/voa?start=0&count=50&type=news";
    static {
        URL_SOURCES.put("news", URL_NEWS);
        URL_SOURCES.put("learning", URL_LEARNING);
    }

    private static final String TAG = "JsonUtils";

    public static void parseJsonToDb(Context context, JSONObject json, String type) {
        try {
            JSONArray voas = json.getJSONArray("voas");
            for (int i = 0; i < voas.length(); i++) {
                JSONObject voa = (JSONObject) voas.get(i);
                String title = voa.getString("title");
                String desc = voa.getString("description");
                JSONObject idObject = (JSONObject) voa.get("_id");
                String vid = idObject.getString("$oid");
                String guid = voa.getString("guid");
                JSONObject pubdateObject = (JSONObject) voa.get("pubDate");
                String pubdate = pubdateObject.getString("$date");
                String content = voa.getString("content");
                String category = voa.getString("category");
                String link = voa.getString("link");
                String image = null;
                if (voa.has("image")) {
                    image = voa.getString("image");
                }
                String audiourl = null;
                if (voa.has("audio")) {
                    audiourl = voa.getString("audio");
                }
                VOANews v = new VOANews(vid, guid,title, desc, category, pubdate, content, image,link,
                        audiourl,type);
                DBUtils.addVoa(context, v);
                Log.e("NAMND", v.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // "https://voareader-lidemin.rhcloud.com/voa?start=0&count=50&type=learning"
    public static void parseDataFromUrl(Context context, String type) {
        JSONObject json = new JSONParser().getJSONFromUrl(URL_SOURCES.get(type));
        if (json != null) {
            parseJsonToDb(context, json, type);
        }else{
            Log.e(TAG,"get json is null");
        }
    }
}
