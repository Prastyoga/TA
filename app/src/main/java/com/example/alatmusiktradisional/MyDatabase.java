package com.example.alatmusiktradisional;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_alatmusiktradisional";
    private static final String tb_alatmusiktradisional = "tb_alatmusiktradisional";
    private static final String tb_alat_id = "id";
    private static final String tb_alat_nama = "nama";
    private static final String tb_alat_daerah = "daerah";
    private static final String tb_alat_kategori = "kategori";

    private static final String CREATE_TABLE_CAFE = "CREATE TABLE " +
            tb_alatmusiktradisional + "("
            + tb_alat_id + " INTEGER PRIMARY KEY ,"
            + tb_alat_nama + " TEXT,"
            + tb_alat_daerah + " TEXT, "
            + tb_alat_kategori + " TEXT" + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CAFE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateCafe (AlatMusikTradisional mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_alat_id, mdNotif.get_id());
        values.put(tb_alat_nama, mdNotif.get_nama());
        values.put(tb_alat_daerah, mdNotif.get_daerah());
        values.put(tb_alat_kategori, mdNotif.get_kategori());
        db.insert(tb_alatmusiktradisional, null, values);
        db.close();
    }
    public List<AlatMusikTradisional> ReadAlatMusikTradisional() {
        List<AlatMusikTradisional> judulModelList = new ArrayList<AlatMusikTradisional>();
        String selectQuery = "SELECT * FROM " + tb_alatmusiktradisional;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AlatMusikTradisional mdKontak = new AlatMusikTradisional();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_daerah(cursor.getString(2));
                mdKontak.set_kategori(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateAlatmusikTradisional (AlatMusikTradisional mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_alat_nama, mdNotif.get_nama());
        values.put(tb_alat_daerah, mdNotif.get_daerah());
        values.put(tb_alat_kategori, mdNotif.get_kategori());
        return db.update(tb_alatmusiktradisional, values, tb_alat_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteAlatMusikTradisional (AlatMusikTradisional mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_alatmusiktradisional, tb_alat_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
