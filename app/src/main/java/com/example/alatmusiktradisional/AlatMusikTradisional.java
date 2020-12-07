package com.example.alatmusiktradisional;

public class AlatMusikTradisional {
    private String _id, _nama, _daerah, _kategori;
    public AlatMusikTradisional (String id, String nama, String daerah, String  kategori)
    {
        this._id = id;
        this._nama = nama;
        this._daerah = daerah;
        this._kategori = kategori;
    }
    public AlatMusikTradisional() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_daerah() {
        return _daerah;
    }
    public void set_daerah(String _daerah) {
        this._daerah = _daerah;
    }
    public String get_kategori() {
        return _kategori;
    }
    public void set_kategori(String _kategori) {
        this._kategori = _kategori;
    }

}

