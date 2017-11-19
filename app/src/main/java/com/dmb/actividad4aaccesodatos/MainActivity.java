package com.dmb.actividad4aaccesodatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView name,age,cycle,course,gradeOffice;
    private EditText id;
    private String searchID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.etID);
        name = findViewById(R.id.tvName);
        age = findViewById(R.id.tvAge);
        cycle = findViewById(R.id.tvCycle);
        course = findViewById(R.id.tvCourse);
        gradeOffice = findViewById(R.id.tvGradeOrOffice);
    }

    public void addStudentSQLite(View v){
        Intent intent = new Intent(this,AddStudentSQLite.class);
        startActivity(intent);
    }

    public void addTeacherSQLite(View v){
        Intent intent = new Intent(this,AddTeacherSQLite.class);
        startActivity(intent);
    }

    public void searchStudentByID(View v){
        AdminSQLite admin = new AdminSQLite(this,"admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        searchID = id.getText().toString();
        Cursor fila = db.rawQuery(
                "select * from student where studentID=" + searchID, null);
        if (fila.moveToFirst()) {
            name.setText("Nombre: "+fila.getString(1));
            age.setText("Edad: "+fila.getString(2));
            cycle.setText("Ciclo: "+fila.getString(3));
            course.setText("Curso: "+fila.getString(4));
            gradeOffice.setText("Nota Media: "+fila.getString(5));
        } else
            Toast.makeText(this, "No existe un estudiante con dicho ID",
                    Toast.LENGTH_SHORT).show();
        db.close();

    }
}
