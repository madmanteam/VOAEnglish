package com.madman.voanews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by madman on 4/15/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="voa";
    public static final int DB_VERSION = 1;

    public static final String TABLE_VOA="voa_news";

    private static final String CREATE_TBL_VOA = "CREATE TABLE "+ TABLE_VOA + "("+
            VOANewsColumns._ID + " VARCHAR PRIMARY KEY NOT NULL, " +
            VOANewsColumns.TYPE + " VARCHAR NOT NULL, " +
            VOANewsColumns.GUID + " VARCHAR, " +
            VOANewsColumns.TITLE + " VARCHAR NOT NULL, " +
            VOANewsColumns.DESCRIPTION + " VARCHAR, "+
            VOANewsColumns.CATEGORY + " VARCHAR, "+
            VOANewsColumns.PUB_DATE + " VARCHAR NOT NULL, "+
            VOANewsColumns.CONTENT +" VARCHAR, "+
            VOANewsColumns.IMAGE + " VARCHAR, "+
            VOANewsColumns.LINK + " VARCHAR, " +
            VOANewsColumns.AUDIO + " VARCHAR, "+
            VOANewsColumns.AUDIO_LOCAL + " VARCHAR )";

    public static DBHelper getInstance(Context context){
        return new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_VOA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOA);
            // Create tables again
            onCreate(db);
        }
    }
}
