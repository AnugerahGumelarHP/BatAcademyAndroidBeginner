package com.example.pariwisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edtNama, edtEmail, edtPassword;
    Button btnDaftar;
    TextView punyaAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edtNama);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(nama.equals("") && email.equals("") && password.equals("")){
                    Toast.makeText(Register.this,"Data belum lengkap atau salah",Toast.LENGTH_SHORT).show();
                } else{
                    Intent success = new Intent(Register.this, MainActivity.class);
                    success.putExtra("NamaUser", nama);
                    success.putExtra("Email", email);
                    success.putExtra("Password", password);
                    startActivity(success);
                    finish();
                }
            }
        });

        punyaAkun = findViewById(R.id.txtPunyaAkunn);
        punyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent punyaAkun = new Intent(Register.this, Login.class);
                startActivity(punyaAkun);
            }
        });
    }
}