package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "User.db";


    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";


        db.execSQL(SQL_CREATE_USER_TABLE);


        db.execSQL("insert into " + TABLE_NAME + " values(1234,'Damon Salvatore', 'abc@gmail.com','7580','1895641238', 24000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4321,'Stefan Salvatore', 'abc1@gmail.com','2258','8995621238', 4980)");
        db.execSQL("insert into " + TABLE_NAME + " values(0895,'Klaus Mikelson', 'abc2@gmail.com','8816','7295645896', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1259,'Bonny Benette', 'abc3@gmail.com','7352','9999840038', 8090)");
        db.execSQL("insert into " + TABLE_NAME + " values(6410,'Caroline', 'abc4@gmail.com','3609','9455648962', 7590)");
        db.execSQL("insert into " + TABLE_NAME + " values(8479,'Jeremy', 'abc5@gmail.com','9885','8855649038', 6200)");
        db.execSQL("insert into " + TABLE_NAME + " values(3458,'Ellija Mikelson', 'abc6@gmail.com','1107','8895640905', 4980)");
        db.execSQL("insert into " + TABLE_NAME + " values(7869,'Tyler', 'abc7@gmail.com','4622','9985871539', 3600)");
        db.execSQL("insert into " + TABLE_NAME + " values(4782,'Ellina', 'abc8@gmail.com','6082','9309567238', 1070)");
        db.execSQL("insert into " + TABLE_NAME + " values(1365,'Hayley Marshal', 'abc9@gmail.com','5459','8278591201', 99100)");
        db.execSQL("insert into " + TABLE_NAME + " values(7564,'Kole Mikelson', 'abc10@gmail.com','2756','9015641900', 98009)");
        db.execSQL("insert into " + TABLE_NAME + " values(3871,'Matt Donaven', 'abc11@gmail.com','1293','9995671999', 19500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2122,'Katherin', 'abc12@gmail.com','4566','9125441001', 5806)");
        db.execSQL("insert into " + TABLE_NAME + " values(9672,'Enzo', 'abc13@gmail.com','2230','6254642875', 38900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7529,'Silas', 'abc14@gmail.com','6092','6893361266', 101098)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}