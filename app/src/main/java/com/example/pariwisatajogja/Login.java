package com.example.pariwisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edtNama, edtPassword;
    TextView lupaPassword, daftarDisini;
    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNama = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPassword);
        lupaPassword = findViewById(R.id.txtLupaPassword);
        masuk = findViewById(R.id.btnMasuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();
                if(pass.equals("admin")){
                    Intent main = new Intent(Login.this, MainActivity.class);
                    main.putExtra("NamaUser", nama);
                    startActivity(main);
                    finish();
                } else {
                    Toast.makeText(Login.this,"Masukkan email dan password anda", Toast.LENGTH_SHORT).show();
                }

            }
        });
        daftarDisini = findViewById(R.id.txtBuatAkun);
        daftarDisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buatAkun = new Intent(Login.this, Register.class);
                startActivity(buatAkun);
            }
        });
        lupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"Soon",Toast.LENGTH_SHORT).show();
            }
        });
    }
}