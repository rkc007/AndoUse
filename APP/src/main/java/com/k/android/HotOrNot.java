package com.k.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by DINANATH CHAUHAN on 27-06-2015.
 */
public class HotOrNot {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOTNESS = "persons_hotness";

    private static final String DATABASE_NAME = "HotOrNotdb";
    private static final String DATABASE_TABLE = "peopletable";
    private static final int DATABASE_VERSION = 1;
    private DBHelper myhelper;
    private final Context mycontext;
    private SQLiteDatabase mydb;

    public long CreateEntry(String name, String hotness) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_HOTNESS,hotness);
        return mydb.insert(DATABASE_TABLE,null,cv);
    }

    public String getData() {

        String[] colms = new String[]{ KEY_ROWID,KEY_NAME,KEY_HOTNESS};
        Cursor c = mydb.query(DATABASE_TABLE,colms,null,null,null,null,null);
        String result=" ";

        int irow =  c.getColumnIndex(KEY_ROWID);
        int iname =  c.getColumnIndex(KEY_NAME);
        int ihot =  c.getColumnIndex(KEY_HOTNESS);

        for (c.moveToFirst(); !c.isAfterLast() ; c.moveToNext()){

            result = result+c.getString(irow) +"    "+ c.getString(iname)+"    "+c.getString(ihot)+"\n";

        }

        return result;
    }


    private static class DBHelper extends SQLiteOpenHelper{


        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE" + DATABASE_TABLE + " (" +
            KEY_ROWID + "TEXT PRIMARY KEY , "+
                            KEY_NAME+ " TEXT NOT NULL , " +
                            KEY_HOTNESS + " TEXT NOT NULL); "
            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + "DATABASE_TABLE");
            onCreate(db);

        }
    }

    public HotOrNot(Context c){
        mycontext = c;
    }
    public HotOrNot open() throws SQLException{
        myhelper = new DBHelper(mycontext);
        mydb = myhelper.getWritableDatabase();
        return this;

    }

    public void close(){
        myhelper.close();
    }
}
