package com.example.pariwisatajogja;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtNama, txtPekerjaan;
    RelativeLayout parangtritis, sadranan, mangunan;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.txtName);
        txtPekerjaan = findViewById(R.id.txtPekerjaan);
        editProfile = findViewById(R.id.btnEdit);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertProfile();
            }
        });

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String nama = bundle.getString("NamaUser");
        String pekerjaan = bundle.getString("Pekerjaan");

        txtNama.setText(nama);
        txtPekerjaan.setText(pekerjaan);

        parangtritis = findViewById(R.id.parangtritis);
        parangtritis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(MainActivity.this, Destinasi.class);
                startActivity(detail);
            }
        });
        sadranan = findViewById(R.id.sadranan);
        mangunan = findViewById(R.id.mangunan);
    }

    private void alertProfile() {
        //custom dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Data Profile");
        //set layout of dialog
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //add edittext
        final EditText edtGantiNama = new EditText(this);
        edtGantiNama.setHint("Nama");
        linearLayout.addView(edtGantiNama);
        //add edittext
        final EditText edtGantiPekerjaan = new EditText(this);
        edtGantiPekerjaan.setHint("Pekerjaan");
        linearLayout.addView(edtGantiPekerjaan);

        builder.setView(linearLayout);

        //add buttons in dialog to update
        builder.setPositiveButton("Ubah data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //input text from edit text
                String gantiNama = edtGantiNama.getText().toString().trim();
                String gantiPekerjaan = edtGantiPekerjaan.getText().toString().trim();
                //validate if user has entered something or not
                if (TextUtils.isEmpty(gantiNama) && TextUtils.isEmpty(gantiPekerjaan)){
                    Toast.makeText(MainActivity.this,
                            "Informasi yang anda masukan salah atau tidak lengkap", Toast.LENGTH_SHORT).show();
                } else{
                    Intent gantiBiodata = new Intent(MainActivity.this, MainActivity.class);
                    gantiBiodata.putExtra("NamaUser", gantiNama);
                    gantiBiodata.putExtra("Pekerjaan", gantiPekerjaan);
                    startActivity(gantiBiodata);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //create and show dialog
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.keluar_app:
                Intent keluar = new Intent(MainActivity.this, Welcome.class);
                startActivity(keluar);
                finish();
                return true;
            case R.id.help:
                help();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void help() {
        Intent bantuan = new Intent(Intent.ACTION_SEND);
        String[] to ={"admin@battistradadeveloper.com", "batsensei@batdev.com"};
        bantuan.putExtra(Intent.EXTRA_EMAIL, to);
        bantuan.putExtra(Intent.EXTRA_SUBJECT, "Need help batsensei");
        bantuan.putExtra(Intent.EXTRA_TEXT, "Saya butuh bantuan untuk kelas android beginner");
        bantuan.setType("message/rfc822");
        startActivity(bantuan);
    }
}