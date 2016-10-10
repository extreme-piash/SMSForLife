package mpsoftware.ltd.smsforlife.favdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public long insertWishlist(String fullSMS) {
        this.open();
        long rowAdded = 1L;

        ContentValues cv = new ContentValues();
        cv.put(WishlistContract.WishlistTableColumns.FULLSMS, fullSMS);
        rowAdded += mDatabase.insert(WishlistContract.WishlistTableColumns.TABLE_NAME, null, cv);
        this.close();

        return rowAdded;
    }

    public void delete(String FullSMS) {
        this.open();
        mDatabase.execSQL("DELETE FROM " + WishlistContract.WishlistTableColumns.TABLE_NAME+ " WHERE "+WishlistContract.WishlistTableColumns.FULLSMS+"='"+FullSMS+"'");
        //return mDatabase.delete(WishlistContract.WishlistTableColumns.TABLE_NAME, WishlistContract.WishlistTableColumns.FULLSMS + "=" + FullSMS, null) > 0;
        this.close();
    }

    public ArrayList<String> getAllWishlistData() {

        this.open();
        ArrayList<String> contactList = new ArrayList<>();

        String[] projection = {
                WishlistContract.WishlistTableColumns.FULLSMS};
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            contactList.add(cursor.getString(0));
        }
        this.close();
        return contactList;
    }

    public int isFavourite(String fullSMS) {

        this.open();
        int a = -1;
        String[] projection = {
                WishlistContract.WishlistTableColumns.FULLSMS};
        String[] whereValues = {
                String.valueOf(fullSMS)};
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, WishlistContract.WishlistTableColumns.FULLSMS + " = ?", whereValues, null, null, null);

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
