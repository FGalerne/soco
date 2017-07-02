package com.flo.soco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florian on 27/06/17.
 */

public class BusinessManager {

    DatabaseHelper data;
    SQLiteDatabase db;

    // Database Information
    private static final String DATABASE_NAME = "information";
    private static final int DATABASE_VERSION = 1;

    //Tables Name
    private static final String TABLE_BUSINESS = "business";

    // User Table Columns
    private static final String KEY_USER_ID = "id";
    private static final String KEY_USER_COMPANY = "company";
    private static final String KEY_USER_ADDRESS = "address";
    private static final String KEY_USER_POSTALCODE = "postalCode";
    private static final String KEY_USER_TOWN = "town";

    public BusinessManager(Context ctx) {
        data = new DatabaseHelper(ctx, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void open() {
        db = data.getWritableDatabase();

    }

    public void close() {
        db.close();

    }

    public long addBusiness (Business b){

        ContentValues values = new ContentValues();

        values.put(KEY_USER_COMPANY, b.getCompany());
        values.put(KEY_USER_ADDRESS, b.getAddress());
        values.put(KEY_USER_POSTALCODE, b.getPostalCode());
        values.put(KEY_USER_TOWN, b.getTown());


        return db.insert(TABLE_BUSINESS, null, values);


    }

    // Permet de voir un seul id
    public Business getBusiness (int id){
        Cursor cursor = db.query(TABLE_BUSINESS, new String[] {KEY_USER_ID,KEY_USER_COMPANY, KEY_USER_ADDRESS, KEY_USER_POSTALCODE, KEY_USER_TOWN}, KEY_USER_ID + "=?", new String[] { String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        Business business = new Business(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return business;

    }

    //permet de voir l'ensemble des lignes
    public List<Business> getAllBusiness(){

        List<Business> businesses = new ArrayList<Business>();

        String selectQuery = "SELECT * FROM " + TABLE_BUSINESS;
        open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Business business = new Business();
                business.setId(Integer.parseInt(cursor.getString(0)));
                business.setCompany(cursor.getString(1));
                business.setAddress(cursor.getString(2));
                business.setPostalCode(cursor.getString(3));
                business.setTown(cursor.getString(4));

                businesses.add(business);
            } while (cursor.moveToNext());
        }

        return businesses;
    }



}

