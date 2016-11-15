package com.example.surya.sqliteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by surya on 12/11/16.
 */
public class SQlitePersonDB extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;
    private Context context;

//    public SQLiteOpenHelper(Context context){
//        this.context=context;
//    }

    public SQlitePersonDB(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION2);

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable="CREATE TABLE "
                + Constants.STUDENT_TABLE +"( "
                + Constants.STUDENT_ID + " INTEGER PRIMARY KEY, "
                +  Constants.STUDENT_NAME +" TEXT, "
                + Constants.STUDENT_CITY + " TEXT)";

        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Constants.STUDENT_TABLE);
        onCreate(sqLiteDatabase);
    }
}
