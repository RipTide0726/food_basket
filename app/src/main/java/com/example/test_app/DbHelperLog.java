package com.example.test_app;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperLog extends SQLiteOpenHelper {

    public DbHelperLog(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    public void onCreate(SQLiteDatabase DB){
        DB.execSQL(("create Table UserLogin(UserID TEXT, Password Integer)"));
    }

    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists UserLogin");
    }

    public Boolean insertUserData(String UserID, Integer Password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserID", UserID);
        contentValues.put("Password", Password);
        long result = DB.insert("UserLogin" ,null, contentValues);
        if(result==1){
            return false;
        }else{
            return true;
        }
    }


}
