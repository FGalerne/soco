package com.flo.soco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by florian on 26/06/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Tables Name
    private static final String TABLE_BUSINESS = "business";

    // User Table Columns
    private static final String KEY_USER_ID = "id";
    private static final String KEY_USER_COMPANY = "company";
    private static final String KEY_USER_ADDRESS = "address";
    private static final String KEY_USER_POSTALCODE = "postalCode";
    private static final String KEY_USER_TOWN = "town";

    private static final String USER_CREATE_ENTRIES = "CREATE TABLE " + TABLE_BUSINESS + " (" + KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_USER_COMPANY + " TEXT, " + KEY_USER_ADDRESS + " TEXT, " + KEY_USER_POSTALCODE + " TEXT," + KEY_USER_TOWN + " TEXT )";

    private static final String USER_DELETE_ENTRIES = "DROP TABLE IF EXITS " + TABLE_BUSINESS;

    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion){
            db.execSQL(USER_DELETE_ENTRIES);
            onCreate(db);
        }

    }


}
