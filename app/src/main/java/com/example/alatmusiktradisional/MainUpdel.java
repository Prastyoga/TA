package com.example.alatmusiktradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sdaerah , Skategori;
    private EditText Enama, Edaerah , Ekategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sdaerah = i.getStringExtra("Idaerah");
        Skategori = i.getStringExtra("Ikategori");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Edaerah = (EditText) findViewById(R.id.updel_daerah);
        Ekategori = (EditText) findViewById(R.id.updel_kategori);

        Enama.setText(Snama);
        Edaerah.setText(Sdaerah);
        Ekategori.setText(Skategori);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sdaerah = String.valueOf(Edaerah.getText());
                Skategori = String.valueOf(Ekategori.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama produk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdaerah.equals("")){
                    Edaerah.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi daerah",
                            Toast.LENGTH_SHORT).show();
                } else if (Skategori.equals("")){
                    Ekategori.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kategori ",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdateAlatmusikTradisional(new AlatMusikTradisional(Sid, Snama, Sdaerah, Skategori));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAlatMusikTradisional(new AlatMusikTradisional(Sid, Snama, Skategori, Skategori));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}