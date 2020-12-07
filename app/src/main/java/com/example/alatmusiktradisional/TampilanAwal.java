package com.example.alatmusiktradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TampilanAwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_awal);
    }

    public void btn_crud(View view) {
        Intent a = new Intent(TampilanAwal.this, MainActivity.class);
        startActivity(a);
    }
}
