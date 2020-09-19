package com.skripsi.penapisankb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skripsi.penapisankb.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup radio1, radio2, radio3, radio7;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    String selectedRB1, selectedRB2, selectedRB3, selectedRB4, selectedRB5, selectedRB6, selectedRB7;
    private Button btnLanjut, btnProses;
    private LinearLayout linearPrior, linearDecision;
    private TextView tvP01, tvP02, tvP03;
    private LinearLayout linearP03;
    String value;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kehamilan");

        Intent intents = getIntent();
        value = intents.getStringExtra("kelompok");

        initComponent();
    }


    private void initComponent(){
        radio1 = findViewById(R.id.rg_p01);
        radio2 = findViewById(R.id.rg_p02);
        radio3 = findViewById(R.id.rg_p03);
        radio7 = findViewById(R.id.rg_p07);
        linearP03 = findViewById(R.id.linear_p03);
        tvP01 = findViewById(R.id.tv_p01);
        tvP02 = findViewById(R.id.tv_p02);
        tvP03 = findViewById(R.id.tv_p03);

        btnLanjut = findViewById(R.id.btn_lanjut);
        btnProses = findViewById(R.id.btn_proses);

        linearPrior = findViewById(R.id.linear_prior);
        linearDecision = findViewById(R.id.linear_decision);

        btnLanjut.setOnClickListener(this);
        btnProses.setOnClickListener(this);
        loadData();
    }
    private void loadData(){

        switch (value){
            case "Nifas":
                tvP01.setText(getString(R.string.p02));
                tvP02.setText(getString(R.string.p08));
                linearP03.setVisibility(View.GONE);
                break;
            case "Akseptor KB Baru":
                tvP01.setText(getString(R.string.p02));
                tvP02.setText(getString(R.string.p04));
                linearP03.setVisibility(View.GONE);
                break;
            case "Akseptor KB Lama":
                tvP01.setText(getString(R.string.p02));
                tvP02.setText(getString(R.string.p04));
                tvP03.setText(getString(R.string.p09));
                break;

        }
    }
    private void validasiSatu(){

        int selectedRG1 = radio1.getCheckedRadioButtonId();
        int selectedRG2 = radio2.getCheckedRadioButtonId();
        int selectedRG3 = radio3.getCheckedRadioButtonId();
        switch (value){

            case "Nifas":
               if (selectedRG1 == -1 || selectedRG2 == -1){
                 Toast.makeText(MainActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
               }else{
                   processTwo();
               }
                break;
            case "Akseptor KB Baru":
                if (selectedRG1 == -1 || selectedRG2 == -1){
                    Toast.makeText(MainActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
                }else{
                    processTwo();
                }
                break;
            case "Akseptor KB Lama":

                if (selectedRG1 == -1 || selectedRG2 == -1 || selectedRG3 == -1){
                    Toast.makeText(MainActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
                }else{
                    processTwo();
                }
                break;

        }
    }
    private void validasiDua(){

        int selectedRG7 = radio7.getCheckedRadioButtonId();
        if (selectedRG7 == -1){
            Toast.makeText(MainActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
        }else{
            processDecision();
        }
    }

    private void processDecision(){
        int selectedRG7 = radio7.getCheckedRadioButtonId();


        if (selectedRG7 != -1){
            rb7 = findViewById(selectedRG7);
            selectedRB7 = rb7.getText().toString();
        }

        switch (selectedRB7){
            case "Suntik Kombinasi":
                intent = new Intent(this, SuntikKomActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "Pil Kombinasi":
                intent = new Intent(this, PilKomActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "Pil Progestin":
                intent = new Intent(this, PilProActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                break;
            case "Suntik Progestin":
                intent = new Intent(this, SuntikProActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "Implan":
                intent = new Intent(this, ImplanActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "AKDR Cu":
                intent = new Intent(this, AKDRCuActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "AKDR Pro":
                intent = new Intent(this, AKDRProActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
            case "Tubektomi":
                intent = new Intent(this, TubektomiActivity.class);
                intent.putExtra("kelompok", value);
                intent.putExtra("alkon", selectedRB7);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void processTwo(){
        int selectedRG1 = radio1.getCheckedRadioButtonId();
        int selectedRG2 = radio2.getCheckedRadioButtonId();
        int selectedRG3 = radio3.getCheckedRadioButtonId();

        rb1 = findViewById(selectedRG1);
        rb2 = findViewById(selectedRG2);
        rb3 = findViewById(selectedRG3);


        switch (value){
            case "Nifas":
                if (rb1.getText().equals("Ya") && rb2.getText().equals("Ya")){
                    linearDecision.setVisibility(View.VISIBLE);
                    linearPrior.setVisibility(View.GONE);
                    btnLanjut.setVisibility(View.GONE);
                    btnProses.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(this, "Kemungkinan Pasien Hamil dan Kembali Melakukan Pengecekan Ketika Haid", Toast.LENGTH_LONG).show();
                }
                break;
            case "Akseptor KB Baru":
                if (rb1.getText().equals("Ya") && rb2.getText().equals("Ya")){
                    linearDecision.setVisibility(View.VISIBLE);
                    linearPrior.setVisibility(View.GONE);
                    btnLanjut.setVisibility(View.GONE);
                    btnProses.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(this, "Kemungkinan Pasien Hamil dan Kembali Melakukan Pengecekan Ketika Haid", Toast.LENGTH_LONG).show();
                }
                break;
            case "Akseptor KB Lama":
                if (rb1.getText().equals("Ya") && rb2.getText().equals("Ya") && rb3.getText().equals("Ya")){
                    linearDecision.setVisibility(View.VISIBLE);
                    linearPrior.setVisibility(View.GONE);
                    btnLanjut.setVisibility(View.GONE);
                    btnProses.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(this, "Kemungkinan Pasien Hamil dan Kembali Melakukan Pengecekan Ketika Haid", Toast.LENGTH_LONG).show();
                }
                break;

        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lanjut:
                validasiSatu();
                break;

            case R.id.btn_proses:
                validasiDua();
                break;
        }
    }
}
