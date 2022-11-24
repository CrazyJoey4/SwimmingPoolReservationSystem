package com.example.swimmingpool_rs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String pooly_db = "poolydb";
    private static final int DB_VERSION = 1;

    // below variable is for table names.
    private static final String users_tb = "users";
    private static final String ann_tb = "announcement";
    private static final String price_tb = "price";

    // below variables are for users columns.
    private static final String User_ID = "User_ID";
    private static final String Username = "Username";
    private static final String User_fullname = "User_fullname";
    private static final String User_type = "User_type";
    private static final String User_email = "User_email";
    private static final String User_pwd = "User_pwd";
    private static final String User_dob = "User_dob";
    private static final String User_gender = "User_gender";
    private static final String User_contact = "User_contact";

    // below variable is for our announcement columns.
    private static final String Ann_ID = "AnnouncementId";
    private static final String Ann_title = "Title";
    private static final String Ann_content = "Content";
    private static final String Ann_date = "Date";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, pooly_db, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line are creating an sqlite query and setting column names along with their data types.
        String query = "CREATE TABLE " + users_tb + " ("
                + User_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Username + " TEXT, "
                + User_fullname + " TEXT,"
                + User_type + " TEXT,"
                + User_email + " TEXT,"
                + User_pwd + " TEXT,"
                + User_dob + " TEXT,"
                + User_gender + " TEXT)";

        // calling a exec sql method to execute above sql query
        db.execSQL(query);

        String announcement_query = "CREATE TABLE " + ann_tb + " ("
                + Ann_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Ann_title + " TEXT,"
                + Ann_content + " TEXT,"
                + Ann_date + " DateTime DEFAULT (datetime('now','localtime')));";

        db.execSQL(announcement_query);

        String price_query = "CREATE TABLE price(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "detail TEXT," +
                "amount DOUBLE," +
                "type TEXT," +
                "limitpax INT);";

        db.execSQL(price_query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String username, String fullname, String email, String pwd, String usertype) {

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
        values.put(User_type, usertype);

        // after adding all values we are passing content values to our table.
        db.insert(users_tb, null, values);

        // at last we are closing our database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + users_tb);
        db.execSQL("DROP TABLE IF EXISTS announcement");
        onCreate(db);
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from users where Username = ?", new String[]{username});
        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyUser(String username, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from users where Username = ? and User_pwd = ?", new String[]{username, pwd});
        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressLint("Range")
    public Profile getUserDetails(String username) {
        String sql = "SELECT * FROM users WHERE Username = '" + username + "';";

        Cursor c = null;
        Profile entry = null;

        try {
            SQLiteDatabase db = getReadableDatabase();
            c = db.rawQuery(sql, null);
            c.moveToFirst();

            if (c.getCount() > 0) {
                entry = new Profile();
                entry.setUser_ID(c.getInt(c.getColumnIndex(Username)));
                entry.setUser_fullname(c.getString(c.getColumnIndex(User_fullname)));
                entry.setUser_dob(c.getString(c.getColumnIndex(User_dob)));
                entry.setUser_gender(c.getString(c.getColumnIndex(User_gender)));
                entry.setUser_email(c.getString(c.getColumnIndex(User_email)));
                entry.setUser_contact(c.getString(c.getColumnIndex(User_contact)));
                entry.setUser_pwd(c.getString(c.getColumnIndex(User_pwd)));
            }

        } catch (Exception e) {
            Log.d("Query Exception:", e.getMessage());
        } finally {
            //c.close();
            return entry;
        }
    }

    public boolean checkAdmin(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from users where Username = ? and User_type = 'Admin'", new String[]{username});
        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addAnnouncement(String title, String content) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Ann_title, title);
        values.put(Ann_content, content);

        db.insert(ann_tb, null, values);
        db.close();
    }

    @SuppressLint("Range")
    public Announcement getAnnouncement(int id, int position) {
        String sql = "SELECT * FROM announcement WHERE AnnouncementId=" + id +
                "ORDER BY AnnouncementId DESC LIMIT " + position + ",1;";

        Cursor c = null;
        Announcement entry = null;

        try {
            SQLiteDatabase db = getReadableDatabase();
            c = db.rawQuery(sql, null);
            c.moveToFirst();

            if (c.getCount() > 0) {
                entry = new Announcement();
                entry.setAnnouncementId(c.getInt(c.getColumnIndex("AnnouncementId")));
                entry.setContent(c.getString(c.getColumnIndex("Content")));
                entry.setTitle(c.getString(c.getColumnIndex("Title")));
                entry.setDatetime(c.getString(c.getColumnIndex("Date")));
            }

        } catch (Exception e) {
            Log.d("Query Exception:", e.getMessage());
        } finally {
            //c.close();
            return entry;
        }
    }

    public void updateAnnouncement(int id, String title, String content, String date) {
        ContentValues values = new ContentValues();
        values.put("Title", title);
        values.put("Content", content);
        values.put("Date", date);

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.update("announcement", values, "_id=?", new String[]{Integer.toString(id)});
            db.close();
        } catch (Exception e) {
            Log.d("Query Exception:", e.getMessage());
        }
    }

    public void deleteAnnouncement(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("announcement", "AnnouncementId=?", new String[]{Integer.toString(id)});
        db.close();
    }

    public void addPrice(String detail, double amount, String type, int limitpax) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("detail", detail);
        values.put("amount", amount);
        values.put("type", type);
        values.put("limitpax", limitpax);
        db.insert("price", null, values);
        db.close();
    }

    public Price getPrice(int id, int position) {
        String sql = "SELECT * FROM price WHERE _id=" + id +
                "ORDER BY AnnouncementId DESC LIMIT " + position + ",1;";

        Cursor c = null;
        Price entry = null;

        try {
            SQLiteDatabase db = getReadableDatabase();
            c = db.rawQuery(sql, null);
            c.moveToFirst();

            if (c.getCount() > 0) {
                entry = new Price();
                entry.set_id(c.getInt(c.getColumnIndexOrThrow("_id")));
                entry.setDetail(c.getString(c.getColumnIndexOrThrow("detail")));
                entry.setAmount(c.getDouble(c.getColumnIndexOrThrow("amount")));
                entry.setType(c.getString(c.getColumnIndexOrThrow("type")));
                entry.setLimitpax(c.getInt(c.getColumnIndexOrThrow("limitpax")));
            }

        } catch (Exception e) {
            Log.d("Query Exception:", e.getMessage());
        } finally {
            c.close();
            return entry;
        }
    }

    public void deletePrice(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("price", "_id=?", new String[]{Integer.toString(id)});
        db.close();
    }

    public void updatePrice(int id, String detail, double amount, String type, int limitpax) {
        ContentValues values = new ContentValues();
        values.put("detail", detail);
        values.put("amount", amount);
        values.put("type", type);
        values.put("limitpax", limitpax);

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.update("price", values, "_id=?", new String[]{Integer.toString(id)});
            db.close();
        } catch (Exception e) {
            Log.d("Query Exception:", e.getMessage());
        }
    }
}
