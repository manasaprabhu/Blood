package com.example.blood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHpr extends SQLiteOpenHelper {
    String tblname="blooddata";
    String colname="Name";
    String colmob="Mobile";
    String colloc="Location";
    String coldob="DOB";
    String colbldgrp="Blodgrp";

    String res="";

    SQLiteDatabase sq;
    String qry="create table "+tblname+"("
            +colname+" text,"
            +colmob+" text,"
            +colloc+" text,"
            +coldob+" text,"
            +colbldgrp+" text)";
    public DbHpr( Context context) {
        super(context, "blodhjhdb.db", null,1);
        sq=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void savedata(String stname, String stmob, String stloc, String stdob, String stbloodgr) {

        ContentValues v= new ContentValues();
        v.put(colname,stname);
        v.put(colmob,stmob);
        v.put(colloc,stloc);
        v.put(coldob,stdob);
        v.put(colbldgrp,stbloodgr);
        Log.d("jhfh", "savedata: "+stname+"\n"+stmob+"\n"+stdob+"\n"+stbloodgr+"\n"+stloc);
        sq.insert(tblname,null,v);
    }

    public String getdata(String stdldgrp) {
        Cursor c;
        c = sq.query(tblname, null, colbldgrp + "=?", new String[]{stdldgrp}, null, null, null);
        c.moveToFirst();
        if (c.getCount() < 1) {
            return "no data";
        }
        do{
         res+="\n"+ c.getString(c.getColumnIndex(colname)) + "\n" +
                c.getString(c.getColumnIndex(colmob)) + "\n" +
                c.getString(c.getColumnIndex(colloc)) + "\n" +
                c.getString(c.getColumnIndex(coldob));
    }
        while (c.moveToNext());
        return res;

    }
}
