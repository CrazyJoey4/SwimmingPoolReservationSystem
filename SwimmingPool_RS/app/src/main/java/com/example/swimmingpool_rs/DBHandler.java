package com.example.swimmingpool_rs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String pooly_db = "poolydb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our id column.
    private static final String User_ID = "User_ID";

    // below variable is for our table name.
    private static final String users_tb = "users";

    // below variable is for our userid column.
    private static final String Username = "Username";

    // below variable is for our user full name column
    private static final String User_fullname = "User_fullname";

    // below variable id for our user's type column.
    private static final String User_type = "User_type";

    // below variable for our user email column.
    private static final String User_email = "User_email";

    // below variable is for our password column.
    private static final String User_pwd = "User_pwd";

    // below variable is for our password column.
    private static final String User_dob = "User_dob";

    // below variable is for our password column.
    private static final String User_gender = "User_gender";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, pooly_db, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + users_tb + " ("
                + User_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Username + " TEXT, "
                + User_fullname + " TEXT,"
                + User_type + " TEXT,"
                + User_email + " TEXT,"
                + User_pwd + " TEXT,"
                + User_dob + " TEXT,"
                + User_gender + " TEXT)";

        // at last we are calling a exec sql method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String username, String fullname, String email, String pwd) {

        // on below line we are creating a variable for our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values along with its key and value pair.
        values.put(Username, username);
        values.put(User_fullname, fullname);
        values.put(User_email, email);
        values.put(User_pwd, pwd);

        // after adding all values we are passing content values to our table.
        db.insert(users_tb, null, values);

        // at last we are closing our database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + users_tb);
        onCreate(db);
    }
}
