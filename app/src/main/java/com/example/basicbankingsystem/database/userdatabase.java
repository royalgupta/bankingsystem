package com.example.basicbankingsystem.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class userdatabase extends SQLiteOpenHelper {
    private  static final String dbname="dbcontact";



    public userdatabase(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tbl_contact (id integer primary Key autoincrement,name text,contact text,email text,account text) ";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS tbl_contact";
        db.execSQL(qry);
        onCreate(db);
    }
    public String addrecord(String name,String contact,String email,String account)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        cv.put("account",account);
        float res=db.insert("tbl_contact",null,cv);
        if(res==-1)
            return "failure";
        else
            return "success";


    }
    public Cursor fetch()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }
    public void delete()
    { SQLiteDatabase db=this.getWritableDatabase();
        String qry="DROP TABLE IF EXISTS tbl_contact";
        db.execSQL(qry);
        onCreate(db);
    }
}
