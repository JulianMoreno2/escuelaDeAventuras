package com.example.gonzalo.escueladeaventuras.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rain on 22/04/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "exercise.sqlite";
    private static final int DATABASE_SCHEME_VERSION = 3;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE_PLAYER);
        db.execSQL(DataBaseManager.CREATE_TABLE_EXERCISES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DataBaseManager.TABLE_PLAYER);
        onCreate(db);
    }
}
