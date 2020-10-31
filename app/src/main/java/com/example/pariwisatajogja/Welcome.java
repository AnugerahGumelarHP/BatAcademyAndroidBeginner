package com.example.pariwisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    Button btnMasuk;
    TextView txtBuatAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnMasuk = findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuk = new Intent(Welcome.this, Login.class);
                startActivity(masuk);
            }
        });
        txtBuatAkun = findViewById(R.id.txtNewAccount);
        txtBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buatakun = new Intent(Welcome.this, Register.class);
                startActivity(buatakun);
            }
        });
    }
}