package com.example.surya.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by surya on 12/11/16.
 */
public class DatabaseHandler {

    SQLiteOpenHelper sqLiteOpenHelper;

    private Context context;

    public DatabaseHandler(Context context){
        sqLiteOpenHelper=new SQlitePersonDB(context);

    }

    public void createStudent(Student student){
        SQLiteDatabase sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Constants.STUDENT_NAME,student.getName());
        contentValues.put(Constants.STUDENT_CITY,student.getCity());
        sqLiteDatabase.insert(Constants.STUDENT_TABLE,null,contentValues);

        sqLiteDatabase.close();
    }

    public ArrayList<Student> getAllContacts(){
        ArrayList<Student> array=new ArrayList<Student>();
        Student student=new Student();
        SQLiteDatabase sqLiteDatabase=sqLiteOpenHelper.getReadableDatabase();
        String query="SELECT "
                        + Constants.STUDENT_ID + ", "
                        + Constants.STUDENT_NAME + ", "
                        + Constants.STUDENT_CITY +" FROM "
                        + Constants.STUDENT_TABLE;

        Cursor cursor=sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setCity(cursor.getString(2));
                array.add(student);
            }while (cursor.moveToNext());

        }
        sqLiteDatabase.close();
        return array;
    }
}
