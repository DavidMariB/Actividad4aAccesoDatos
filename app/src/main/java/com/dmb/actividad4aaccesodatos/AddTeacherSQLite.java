package com.dmb.actividad4aaccesodatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddTeacherSQLite extends AppCompatActivity {

    private EditText id,name,age,cycle,course,office;
    private String teacherID,teacherName,teacherAge,teacherCycle,teacherCourse,teacherOffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher_sqlite);

        id = findViewById(R.id.etID);
        name = findViewById(R.id.etName);
        age = findViewById(R.id.etAge);
        cycle = findViewById(R.id.etCycle);
        course = findViewById(R.id.etCourse);
        office = findViewById(R.id.etOffice);
    }

    public void addTeacher(View v){
        AdminSQLite admin = new AdminSQLite(this,"admin",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        teacherID = id.getText().toString();
        teacherName = name.getText().toString();
        teacherAge = age.getText().toString();
        teacherCycle = cycle.getText().toString();
        teacherCourse = course.getText().toString();
        teacherOffice = office.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("teacherID",teacherID);
        cv.put("teacherName",teacherName);
        cv.put("teacherAge",teacherAge);
        cv.put("teacherCycle",teacherCycle);
        cv.put("teacherCourse",teacherCourse);
        cv.put("teacherOffice",teacherOffice);
        db.insert("teacher",null,cv);
        db.close();
        id.setText("");
        name.setText("");
        age.setText("");
        cycle.setText("");
        course.setText("");
        office.setText("");
        Toast.makeText(this,"Profesor añadido",Toast.LENGTH_SHORT).show();
    }
}
