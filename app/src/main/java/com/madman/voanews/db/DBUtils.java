package com.madman.voanews.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by madman on 4/15/16.
 */
public class DBUtils {
    private static final String TAG = "DBUtils";

    public static void addVoa(Context context, VOANews v) {
        DBHelper helper = DBHelper.getInstance(context);
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select * from " + DBHelper.TABLE_VOA + " where "+ VOANewsColumns._ID + " =\'"
                        + v.getId() + "\'", null);
        if(cursor.getCount()>0){
            helper.close();
            return;
        }
        ContentValues c = new ContentValues();
        c.put(VOANewsColumns._ID, v.getId());
        c.put(VOANewsColumns.TYPE, v.getType());
        c.put(VOANewsColumns.GUID, v.getGuid());
        c.put(VOANewsColumns.TITLE, v.getTitle());
        c.put(VOANewsColumns.PUB_DATE, v.getPubDate());
        c.put(VOANewsColumns.DESCRIPTION, v.getDescription());
        c.put(VOANewsColumns.CATEGORY, v.getCategory());
        c.put(VOANewsColumns.CONTENT, v.getContent());
        c.put(VOANewsColumns.LINK, v.getLink());
        if (v.getImage() != null && v.getImage().length() > 0) {
            c.put(VOANewsColumns.IMAGE, v.getImage());
        } else {
            c.putNull(VOANewsColumns.IMAGE);
        }
        if (v.getAudio() != null && v.getAudio().length() > 0) {
            c.put(VOANewsColumns.AUDIO, v.getAudio());
        } else {
            c.putNull(VOANewsColumns.AUDIO);
        }
        Log.i(TAG, "inserting:[" + v.getTitle() + "]");
        long i = helper.getWritableDatabase().insert(DBHelper.TABLE_VOA, null, c);
        Log.e("NAMND", " i = " + i);
        helper.close();
    }

    public static void deleteVoa(Context context, VOANews v) {
        DBHelper helper = DBHelper.getInstance(context);
        helper.getWritableDatabase().delete(DBHelper.TABLE_VOA,
                "title=" + v.getTitle(), null);
        helper.close();
    }

    public static ArrayList<VOANews> getVoas(Context context) {
        DBHelper helper = DBHelper.getInstance(context);
        Cursor c = helper.getWritableDatabase().rawQuery(
                "select * from " + DBHelper.TABLE_VOA + " order by "+ VOANewsColumns.PUB_DATE + " desc", null);
        ArrayList<VOANews> voas = new ArrayList<VOANews>();
        while (c.moveToNext()) {
            String id = c.getString(c.getColumnIndex(VOANewsColumns._ID));
            String type = c.getString(c.getColumnIndex(VOANewsColumns.TYPE));
            String guid = c.getString(c.getColumnIndex(VOANewsColumns.GUID));
            String title = c.getString(c.getColumnIndex(VOANewsColumns.TITLE));
            String pubdate = c.getString(c.getColumnIndex(VOANewsColumns.PUB_DATE));
            String desc = c.getString(c.getColumnIndex(VOANewsColumns.DESCRIPTION));
            String category = c.getString(c.getColumnIndex(VOANewsColumns.CATEGORY));
            String content = c.getString(c.getColumnIndex(VOANewsColumns.CONTENT));
            String url = c.getString(c.getColumnIndex(VOANewsColumns.AUDIO));
            String link = c.getString(c.getColumnIndex(VOANewsColumns.LINK));
            String image = c.getString(c.getColumnIndex(VOANewsColumns.IMAGE));
            VOANews v = new VOANews(id,guid,title, desc, category, pubdate, content, image, link, url, type);
            voas.add(v);
        }
        helper.close();
        return voas;
    }

    public static void clearDataBefore() {

    }
}
