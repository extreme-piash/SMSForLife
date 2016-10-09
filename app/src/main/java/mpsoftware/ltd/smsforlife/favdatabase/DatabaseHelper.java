package mpsoftware.ltd.smsforlife.favdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by piash on 10/6/16.
 */

public abstract class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "smsforlife.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}