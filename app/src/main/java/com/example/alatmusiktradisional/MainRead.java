package com.example.alatmusiktradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead  extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<AlatMusikTradisional> ListAlatMusikTradisionals = new ArrayList<AlatMusikTradisional>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListAlatMusikTradisionals );
        mListView = (ListView) findViewById(R.id.list_alatmusiktradisional);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListAlatMusikTradisionals.clear();

        List<AlatMusikTradisional> contacts = db.ReadAlatMusikTradisional();
        for (AlatMusikTradisional cn : contacts) {
            AlatMusikTradisional judulModel = new AlatMusikTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_daerah(cn.get_daerah());
            judulModel.set_kategori(cn.get_kategori());
            ListAlatMusikTradisionals.add(judulModel);
            if ((ListAlatMusikTradisionals.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        AlatMusikTradisional obj_itemDetails = (AlatMusikTradisional) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sdaerah = obj_itemDetails.get_daerah();
        String Skategori = obj_itemDetails.get_kategori();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Idaerah", Sdaerah);
        goUpdel.putExtra("Ikategori", Skategori);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListAlatMusikTradisionals.clear();
        mListView.setAdapter(adapter_off);
        List<AlatMusikTradisional> contacts = db.ReadAlatMusikTradisional();
        for (AlatMusikTradisional cn : contacts) {
            AlatMusikTradisional judulModel = new AlatMusikTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_daerah(cn.get_daerah());
            judulModel.set_kategori(cn.get_kategori());
            ListAlatMusikTradisionals.add(judulModel);
            if ((ListAlatMusikTradisionals.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
