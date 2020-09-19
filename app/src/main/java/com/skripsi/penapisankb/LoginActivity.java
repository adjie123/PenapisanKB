package com.skripsi.penapisankb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skripsi.penapisankb.R;
import com.skripsi.penapisankb.utils.Bidan;
import com.skripsi.penapisankb.utils.BidanSP;
import com.skripsi.penapisankb.utils.Bunda;
import com.skripsi.penapisankb.utils.BundaSP;

public class LoginActivity extends AppCompatActivity {
    private TextView tvNamaBidan;
    private EditText edtNama, edtUmur, edtAlamat, edtNamaSuami, edtNoRM;
    private Button btnProses;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();
        String namaBidan = BidanSP.getBidan(getBaseContext()).getNama();
        if (namaBidan == null){
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }else{
            tvNamaBidan.setText(namaBidan);
        }
    }
    private void initComponent(){
        tvNamaBidan = findViewById(R.id.tv_nama);
        edtNama = findViewById(R.id.edt_nama);
        edtUmur = findViewById(R.id.edt_umur);
        edtAlamat = findViewById(R.id.edt_alamat);
        edtNoRM = findViewById(R.id.edt_norm);
        edtNamaSuami = findViewById(R.id.edt_nama_suami);
        btnProses = findViewById(R.id.btn_proses);
        radioGroup = findViewById(R.id.radiogroup);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();


                if (selectedId == -1)
                {
                    radioGroup.requestFocus();
                    Toast.makeText(LoginActivity.this, "Anda belum memilih kelompok nifas", Toast.LENGTH_LONG).show();
                }else{
                    if (edtNoRM.getText().toString().equals("")){
                        edtNoRM.requestFocus();
                        edtNoRM.setError("No RM Kosong");
                    }
                    else if (edtNama.getText().toString().equals("")){
                        edtNama.requestFocus();
                        edtNama.setError("Nama Bunda Kosong");
                    }
                    else if (edtUmur.getText().toString().equals("")){
                        edtUmur.requestFocus();
                        edtUmur.setError("Umur Bunda Kosong");
                    }
                    else if (edtAlamat.getText().toString().equals("")){
                        edtAlamat.requestFocus();
                        edtAlamat.setError("Alamat Bunda Kosong");
                    }
                    else if (edtNamaSuami.getText().toString().equals("")){
                        edtNamaSuami.requestFocus();
                        edtNamaSuami.setError("Nama Suamu Kosong");
                    }
                    else{
                        Bunda bunda = new Bunda(
                                edtNoRM.getText().toString(),
                                edtNama.getText().toString(),
                                edtUmur.getText().toString(),
                                edtAlamat.getText().toString(),
                                edtNamaSuami.getText().toString()
                        );
                        BundaSP.bundaRegister(getBaseContext(),bunda);
                        // find the radiobutton by returned id
                        radioButton = findViewById(selectedId);
                        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                        myIntent.putExtra("kelompok", radioButton.getText()); //Optional parameters
                        startActivity(myIntent);
                        finish();
                    }

                }

            }
        });
    }
}