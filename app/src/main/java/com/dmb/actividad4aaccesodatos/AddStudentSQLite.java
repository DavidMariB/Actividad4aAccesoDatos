package com.dmb.actividad4aaccesodatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentSQLite extends AppCompatActivity {

    private EditText id,name,age,cycle,course,averageGrade;
    private String studentID,studentName,studentAge,studentCycle,studentCourse,studentAverageGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_sqlite);

        id = findViewById(R.id.etID);
        name = findViewById(R.id.etName);
        age = findViewById(R.id.etAge);
        cycle = findViewById(R.id.etCycle);
        course = findViewById(R.id.etCourse);
        averageGrade = findViewById(R.id.etGrade);
    }

    public void addStudent(View v){
        AdminSQLite admin = new AdminSQLite(this,"admin",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        studentID = id.getText().toString();
        studentName = name.getText().toString();
        studentAge = age.getText().toString();
        studentCycle = cycle.getText().toString();
        studentCourse = course.getText().toString();
        studentAverageGrade = averageGrade.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("studentID",studentID);
        cv.put("studentName",studentName);
        cv.put("studentAge",studentAge);
        cv.put("studentCycle",studentCycle);
        cv.put("studentCourse",studentCourse);
        cv.put("studentAverageGrade",studentAverageGrade);
        db.insert("students",null,cv);
        db.close();
        id.setText("");
        name.setText("");
        age.setText("");
        cycle.setText("");
        course.setText("");
        averageGrade.setText("");
        Toast.makeText(this,"Estudiante añadido",Toast.LENGTH_SHORT).show();

        this.finish();
    }
}
