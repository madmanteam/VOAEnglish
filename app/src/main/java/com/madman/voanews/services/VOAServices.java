package com.madman.voanews.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.madman.voanews.utils.JsonUtils;

import java.net.URL;
import java.util.HashMap;

/**
 * Created by madman on 4/15/16.
 */
public class VOAServices extends IntentService {

    public static final String VOA_NEWS = "news";
    public static final String VOA_LEARNING = "learning";

    public static final String ACTION_PARSING_DATA = "action_parsing_data";
    private static final String TAG = "VOAServices";

    public VOAServices(String name) {
        super(name);
    }

    public VOAServices(){
        this("VoaReaderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String type = intent.getExtras().getString("voa_type_key", VOA_NEWS);
        JsonUtils.parseDataFromUrl(this, type);
        Log.i(TAG, "sending the refresh singal");
        sendBroadcast(new Intent(ACTION_PARSING_DATA));
    }
}
