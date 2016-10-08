package mpsoftware.ltd.smsforlife.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;

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
        return rowAdded;
    }

    public boolean delete(String FullSMS) {
        this.open();
        mDatabase.delete(WishlistContract.WishlistTableColumns.TABLE_NAME, WishlistContract.WishlistTableColumns.FULLSMS + " = " + FullSMS, null);
        return true;
    }

    public ArrayList<String> getAllWishlistData() {

        this.open();
        ArrayList<String> contactList = new ArrayList<>();

        String[] projection = {
                WishlistContract.WishlistTableColumns.FULLSMS
        };
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, null, null, null, null, null);

        while (cursor.moveToNext()) {

            contactList.add(cursor.getString(0));
        }
        Collections.reverse(contactList);
        return contactList;
    }

    public int isFavourite(int dealId) {

        this.open();
        int a = -1;
        String[] projection = {
                WishlistContract.WishlistTableColumns.FULLSMS};
        String[] whereValues = {
                String.valueOf(dealId)};
        Cursor cursor = mDatabase.query(WishlistContract.WishlistTableColumns.TABLE_NAME, projection, WishlistContract.WishlistTableColumns.FULLSMS + " = ?", whereValues, null, null, null);

        if (cursor == null) {
            return 0;
        } else {

            while (cursor.moveToNext()) {
                a = cursor.getInt(0);
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
    }


}
