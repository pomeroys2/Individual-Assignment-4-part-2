package com.example.sarahpomeroy.synonymfinder;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by sarahpomeroy on 3/28/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pairs.db";
    private static final String TABLE_NAME = "pairs";
    private static final String COLUMN_WORDONE = "wordOne";
    private static final String COLUMN_WORDTWO = "wordTwo";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table pairs (id integer primary key not null , " +
            "wordOne text not null , wordTwo text not null)";

    public DatabaseHelper(Context context) {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertPair(Pair p) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_WORDONE , p.getWordOne());
        values.put(COLUMN_WORDTWO , p.getWordTwo());

        db.insert(TABLE_NAME , null, values);
        db.close();
    }

    public String searchSynonym(String word) {
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "Word not found";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(1);

                if(a.equals(word)) {
                    b = cursor.getString(2);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }
}
