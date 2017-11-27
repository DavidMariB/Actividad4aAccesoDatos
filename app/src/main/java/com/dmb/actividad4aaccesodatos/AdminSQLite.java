package com.dmb.actividad4aaccesodatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by david on 19/11/2017.
 */

public class AdminSQLite extends SQLiteOpenHelper{

    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("Alucinas pepinillos con la creaçao de la base do dada");
        db.execSQL("create table students(studentID int primary key,studentName text,studentAge int," +
                "studentCycle text,studentCourse int,studentAverageGrade int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
