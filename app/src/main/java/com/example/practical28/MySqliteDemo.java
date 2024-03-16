package com.example.practical28;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MySqliteDemo extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LoginPage";
    public static final int  DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "LoginInfo";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";


    public MySqliteDemo(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"( id INTEGER PRIMARY KEY AUTOINCREMENT ,"+USER_NAME+" TEXT,"+PASSWORD+" TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion,int newVersion){

    }

    public boolean insert(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(USER_NAME,username);
        con.put(PASSWORD,password);
        long val =  db.insert(TABLE_NAME,null,con);
        if(val>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean read(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        try {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + USER_NAME + "=?" + username + " AND " + PASSWORD + "=?" + password + ";";
            Cursor cur = db.rawQuery(query, null);
            if(cur.getCount()>0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }

    }
}
