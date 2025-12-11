package com.malik.e_menu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqliteDb extends SQLiteOpenHelper {
    public sqliteDb(Context context){
        super(context,"mydb",null,15);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS customer(item_code INT(4)UNIQUE PRIMARY KEY,name VARCHAR, price FLOAT,type VARCHAR,category VARCHAR NOT NULL ,cuisine VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists customer");
        sqLiteDatabase.close();
        onCreate(sqLiteDatabase);
    }
}
