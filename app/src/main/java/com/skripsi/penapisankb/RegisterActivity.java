package com.skripsi.penapisankb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skripsi.penapisankb.R;
import com.skripsi.penapisankb.utils.Bidan;
import com.skripsi.penapisankb.utils.BidanSP;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtNmBidan, edtAlmBidan, edtWilKerja;
    private Button btnRegister;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponent();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtNmBidan.getText().toString().equals("")){
                    edtNmBidan.requestFocus();
                    edtNmBidan.setError("Nama Bidan Kosong");
                }
                else if (edtAlmBidan.getText().toString().equals("")){
                    edtAlmBidan.requestFocus();
                    edtAlmBidan.setError("Alamat Bidan Kosong");
                }
                else if (edtWilKerja.getText().toString().equals("")){
                    edtWilKerja.requestFocus();
                    edtWilKerja.setError("Wilayah Kerja Bidan Kosong");
                }else{
                    Bidan bidan = new Bidan(
                            "1",
                            edtNmBidan.getText().toString(),
                            edtAlmBidan.getText().toString(),
                            edtWilKerja.getText().toString()
                    );
                    BidanSP.bidanRegister(getBaseContext(),bidan);
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }

            }


        });
    }

    private void initComponent(){
        edtNmBidan = findViewById(R.id.tv_nama_bidan);
        edtAlmBidan = findViewById(R.id.tv_alamat_lengkap);
        btnRegister = findViewById(R.id.btn_register);

        edtWilKerja = findViewById(R.id.spinner_wil_kerja_puskesmas);
    }
}