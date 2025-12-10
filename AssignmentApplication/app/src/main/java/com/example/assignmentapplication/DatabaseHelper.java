package com.example.assignmentapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LMS.db";
    private static final int DATABASE_VERSION = 4; // Increased to force recreate DB

    private static DatabaseHelper instance;

    private static final String CREATE_TABLE_STUDENTS =
            "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "surname TEXT NOT NULL, " +
                    "dob TEXT NOT NULL);";  // No email field

    private static final String CREATE_TABLE_INSTRUCTORS =
            "CREATE TABLE IF NOT EXISTS instructors (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "title TEXT, " +
                    "first_name TEXT NOT NULL, " +
                    "last_name TEXT NOT NULL);";

    private static final String CREATE_TABLE_MODULES =
            "CREATE TABLE IF NOT EXISTS modules (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "module_name TEXT NOT NULL, " +
                    "module_code TEXT NOT NULL, " +
                    "duration TEXT);";

    private static final String CREATE_TABLE_TASKS =
            "CREATE TABLE IF NOT EXISTS tasks (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "task_name TEXT NOT NULL, " +
                    "due_date TEXT, " +
                    "module_name TEXT, " +
                    "completed INTEGER DEFAULT 0);";

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_INSTRUCTORS);
        db.execSQL(CREATE_TABLE_MODULES);
        db.execSQL(CREATE_TABLE_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students");
        db.execSQL("DROP TABLE IF EXISTS instructors");
        db.execSQL("DROP TABLE IF EXISTS modules");
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }
}