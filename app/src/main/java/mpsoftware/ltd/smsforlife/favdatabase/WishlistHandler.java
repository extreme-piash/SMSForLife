package mpsoftware.ltd.smsforlife.favdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import mpsoftware.ltd.smsforlife.favdatabase.WishlistContract;

/**
 * Created by piash on 8/10/16.
 */
public class WishlistHandler {


    private static final String TAG = "WishlistHandler";
    private WishlistContract mWishlistContract;
    private SQLiteDatabase mDatabase;

    public WishlistHandler(final Context context) {

        mWishlistContract = new WishlistContract(context);
    }

    public void open() {
        mDatabase = mWishlistContract.getWritableDatabase();
    }

    public void close() {
        mWishlistContract.close();
    }

    public long insertWishlistBangla(String fullSMS) {
        this.open();
        long rowAdded = 1L;


        ContentValues cv = new ContentValues();
        cv.put(WishlistContract.WishlistTableColumns.BANGLASMS, fullSMS);
        rowAdded += mDatabase.insert(WishlistContract.WishlistTableColumns.TABLE_NAME, null, cv);
        this.close();

        return rowAdded;
    }

    public long insertWishlistEnglish(String fullSMS) {
        this.open();
        long rowAdded = 1L;

        ContentValues cv = new ContentValues();
        cv.put(WishlistContract.WishlistTableColumns.ENGLISHSMS, fullSMS);
        rowAdded += mDatabase.insert(WishlistContract.WishlistTableColumns.TABLE_NAME, null, cv);
        this.close();

        return rowAdded;
    }

    public void deleteWishlistBangla(String FullSMS) {
        this.open();
        mDatabase.execSQL("DELETE FROM " + WishlistContract.WishlistTableColumns.TABLE_NAME+ " WHERE "+WishlistContract.WishlistTableColumns.BANGLASMS+"='"+FullSMS+"'");
        //return mDatabase.delete(WishlistContract.WishlistTableColumns.TABLE_NAME, WishlistContract.WishlistTableColumns.FULLSMS + "=" + FullSMS, null) > 0;
        this.close();
    }

    public void deleteWishlistEnglish(String FullSMS) {
        this.open();
        mDatabase.execSQL("DELETE FROM " + WishlistContract.WishlistTableColumns.TABLE_NAME+ " WHERE "+WishlistContract.WishlistTableColumns.ENGLISHSMS+"='"+FullSMS+"'");
        //return mDatabase.delete(WishlistContract.WishlistTableColumns.TABLE_NAME, WishlistContract.WishlistTableColumns.FULLSMS + "=" + FullSMS, null) > 0;
        this.close();
    }

    public ArrayList<String> getAllWishlistBangla() {

        this.open();
        ArrayList<String> contactList = new ArrayList<>();

        Cursor cursor = mDatabase.rawQuery("SELECT "+WishlistContract.WishlistTableColumns.BANGLASMS+" FROM "+WishlistContract.WishlistTableColumns.TABLE_NAME+" WHERE "+WishlistContract.WishlistTableColumns.BANGLASMS+" IS NOT NULL", null);//mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            contactList.add(cursor.getString(0));
        }
        this.close();
        return contactList;
    }
    public ArrayList<String> getAllWishlistEnglish() {

        this.open();
        ArrayList<String> contactList = new ArrayList<>();

        Cursor cursor =  mDatabase.rawQuery("SELECT "+WishlistContract.WishlistTableColumns.ENGLISHSMS+" FROM "+WishlistContract.WishlistTableColumns.TABLE_NAME+" WHERE "+WishlistContract.WishlistTableColumns.ENGLISHSMS+" IS NOT NULL", null);//mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            contactList.add(cursor.getString(0));
        }
        this.close();
        return contactList;
    }

    public int isFavouriteBangla(String fullSMS) {

        this.open();
        int a = -1;
        String[] projection = {
                WishlistContract.WishlistTableColumns.BANGLASMS};
        String[] whereValues = {
                String.valueOf(fullSMS)};
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, WishlistContract.WishlistTableColumns.BANGLASMS + " = ?", whereValues, null, null, null);

        if (cursor == null) {
            return 0;
        } else {

            while (cursor.moveToNext()) {
                if (!cursor.getString(0).isEmpty()){
                    a = 1;
                }
            }
            return a;
        }


    }

    public int isFavouriteEnglish(String fullSMS) {

        this.open();
        int a = -1;
        String[] projection = {
                WishlistContract.WishlistTableColumns.ENGLISHSMS};
        String[] whereValues = {
                String.valueOf(fullSMS)};
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, WishlistContract.WishlistTableColumns.ENGLISHSMS + " = ?", whereValues, null, null, null);

        if (cursor == null) {
            return 0;
        } else {

            while (cursor.moveToNext()) {
                if (!cursor.getString(0).isEmpty()){
                    a = 1;
                }
            }
            return a;
        }


    }


    public int getAllWishlistDataSize() {
        ArrayList<String> contactList = new ArrayList<>();
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            contactList.add(cursor.getString(0));
        }
        return contactList.size();
    }

    public void databaseClear() {

        this.open();
        mDatabase.delete(WishlistContract.WishlistTableColumns.TABLE_NAME, null, null);
        this.close();
    }


}
