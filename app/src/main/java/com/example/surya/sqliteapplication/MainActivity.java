package com.example.surya.sqliteapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private ArrayList<Student> arrayStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student student=new Student("Rishabh","Mumbai");
        databaseHandler=new DatabaseHandler(this);
        databaseHandler.createStudent(student);

         arrayStudent=databaseHandler.getAllContacts();

        for(Student s: arrayStudent){

            Toast.makeText(this,"ID: "+s.getId() +" "+s.getName()+" "+s.getCity(),Toast.LENGTH_SHORT).show();

        }
    }
}
