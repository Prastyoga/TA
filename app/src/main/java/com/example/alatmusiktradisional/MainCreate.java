package com.example.alatmusiktradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Edaerah, Ekategori;
    private String Snama, Sdaerah, Skategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Edaerah = (EditText) findViewById(R.id.create_daerah);
        Ekategori = (EditText) findViewById(R.id.create_kategori);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Sdaerah = String.valueOf(Edaerah.getText());
                Skategori = String.valueOf(Ekategori.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama alat musik",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdaerah.equals("")){
                    Edaerah.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi daerah alat musik",
                            Toast.LENGTH_SHORT).show();
                } else if (Skategori.equals("")){
                    Ekategori.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kategori", Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Edaerah.setText("");
                    Ekategori.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateCafe(new AlatMusikTradisional(null, Snama,Sdaerah, Skategori));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
