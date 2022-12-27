package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_USER = "table_user";
    private static final String COL_ID = "cin";
    private static final String COL_First_Name = "Firstname";
    private static final String COL_Last_Name = "Lastname";
    private static final String COL_UserName = "username";
    private static final String COL_Password = "pwd";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ("
            + COL_ID + " TEXT PRIMARY KEY, " + COL_First_Name
            + " TEXT, " + COL_Last_Name
            + " TEXT, " + COL_UserName + " TEXT NOT NULL, "
            + COL_Password + " TEXT NOT NULL);";


    public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE " + TABLE_USER + ";");

        onCreate(db);
    }

}
