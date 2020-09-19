package com.skripsi.penapisankb;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skripsi.penapisankb.R;

public class TubektomiActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup radioGroup1,  radioGroup2,  radioGroup3,  radioGroup4,  radioGroup5,  radioGroup6,  radioGroup7,  radioGroup8,  radioGroup9,  radioGroup10,  radioGroup11,  radioGroup12, radioGroup13, radioGroup14, radioGroup15, radioGroup16, radioGroup17;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11, rb12, rb13, rb14, rb15, rb16, rb17;
    String selectedRB1, selectedRB2, selectedRB3, selectedRB4, selectedRB5, selectedRB6, selectedRB7, selectedRB8, selectedRB9, selectedRB10, selectedRB11, selectedRB12, selectedRB13, selectedRB14, selectedRB15, selectedRB16, selectedRB17;
    private Button btnLanjut, btnProses;
    private LinearLayout linearPrior, linearDecision;
    private String kelompok, alkon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubektomi); getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tubektomi");

        Intent intents = getIntent();
        kelompok = intents.getStringExtra("kelompok");
        alkon = intents.getStringExtra("alkon");

        initComponent();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void validasiSatu(){
        int selectedRG1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRG2 = radioGroup2.getCheckedRadioButtonId();
        int selectedRG3 = radioGroup3.getCheckedRadioButtonId();
        int selectedRG4 = radioGroup4.getCheckedRadioButtonId();
        int selectedRG5 = radioGroup5.getCheckedRadioButtonId();
        int selectedRG6 = radioGroup6.getCheckedRadioButtonId();
        int selectedRG7 = radioGroup7.getCheckedRadioButtonId();
        int selectedRG8 = radioGroup8.getCheckedRadioButtonId();
        int selectedRG9 = radioGroup9.getCheckedRadioButtonId();
        int selectedRG10 = radioGroup10.getCheckedRadioButtonId();
        int selectedRG11 = radioGroup11.getCheckedRadioButtonId();
        int selectedRG12 = radioGroup12.getCheckedRadioButtonId();
        if (selectedRG1 == -1 || selectedRG2 == -1 || selectedRG3 == -1 || selectedRG4 == -1 || selectedRG5 == -1 || selectedRG6 == -1 ||
                selectedRG7 == -1 || selectedRG8 == -1 || selectedRG9 == -1 || selectedRG10 == -1 || selectedRG11 == -1 || selectedRG12 == -1){
            Toast.makeText(TubektomiActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
        }else{
            linearDecision.setVisibility(View.VISIBLE);
            linearPrior.setVisibility(View.GONE);
            btnLanjut.setVisibility(View.GONE);
            btnProses.setVisibility(View.VISIBLE);
        }
    }
    private void validasiDua(){

        int selectedRG13 = radioGroup13.getCheckedRadioButtonId();
        int selectedRG14 = radioGroup14.getCheckedRadioButtonId();
        int selectedRG15 = radioGroup15.getCheckedRadioButtonId();
        int selectedRG16 = radioGroup16.getCheckedRadioButtonId();
        int selectedRG17 = radioGroup17.getCheckedRadioButtonId();

        if (selectedRG13 == -1 || selectedRG14 == -1 || selectedRG15 == -1 || selectedRG16 == -1 || selectedRG17 == -1){
            Toast.makeText(TubektomiActivity.this, "Pilihan masih ada yang kosong", Toast.LENGTH_LONG).show();
        }else{
            process();
        }
    }
    private void initComponent(){
        radioGroup1 = findViewById(R.id.rg_tubektomi1);
        radioGroup2 = findViewById(R.id.rg_tubektomi2);
        radioGroup3 = findViewById(R.id.rg_tubektomi3);
        radioGroup4 = findViewById(R.id.rg_tubektomi4);
        radioGroup5 = findViewById(R.id.rg_tubektomi5);
        radioGroup6 = findViewById(R.id.rg_tubektomi6);
        radioGroup7 = findViewById(R.id.rg_tubektomi7);
        radioGroup8 = findViewById(R.id.rg_tubektomi8);
        radioGroup9 = findViewById(R.id.rg_tubektomi9);
        radioGroup10 = findViewById(R.id.rg_tubektomi10);
        radioGroup11 = findViewById(R.id.rg_tubektomi11);
        radioGroup12 = findViewById(R.id.rg_tubektomi12);


        radioGroup13 = findViewById(R.id.rg_bp01);
        radioGroup14 = findViewById(R.id.rg_bp02);
        radioGroup15 = findViewById(R.id.rg_bp03);
        radioGroup16 = findViewById(R.id.rg_bp04);
        radioGroup17 = findViewById(R.id.rg_bp05);

        btnLanjut = findViewById(R.id.btn_lanjut);
        btnProses = findViewById(R.id.btn_proses);

        linearPrior = findViewById(R.id.linear_prior);
        linearDecision = findViewById(R.id.linear_decision);

        btnLanjut.setOnClickListener(this);
        btnProses.setOnClickListener(this);
    }

    private void process(){
        int selectedRG1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRG2 = radioGroup2.getCheckedRadioButtonId();
        int selectedRG3 = radioGroup3.getCheckedRadioButtonId();
        int selectedRG4 = radioGroup4.getCheckedRadioButtonId();
        int selectedRG5 = radioGroup5.getCheckedRadioButtonId();
        int selectedRG6 = radioGroup6.getCheckedRadioButtonId();
        int selectedRG7 = radioGroup7.getCheckedRadioButtonId();
        int selectedRG8 = radioGroup8.getCheckedRadioButtonId();
        int selectedRG9 = radioGroup9.getCheckedRadioButtonId();
        int selectedRG10 = radioGroup10.getCheckedRadioButtonId();
        int selectedRG11 = radioGroup11.getCheckedRadioButtonId();
        int selectedRG12 = radioGroup12.getCheckedRadioButtonId();
        int selectedRG13 = radioGroup13.getCheckedRadioButtonId();
        int selectedRG14 = radioGroup14.getCheckedRadioButtonId();
        int selectedRG15 = radioGroup15.getCheckedRadioButtonId();
        int selectedRG16 = radioGroup16.getCheckedRadioButtonId();
        int selectedRG17 = radioGroup17.getCheckedRadioButtonId();


        if (selectedRG1 !=-1){
            rb1 = findViewById(selectedRG1);
            selectedRB1 = rb1.getText().toString();

        }
        if(selectedRG2 != -1){
            rb2 = findViewById(selectedRG2);
            selectedRB2 = rb2.getText().toString();

        }
        if(selectedRG3 != -1){
            rb3 = findViewById(selectedRG3);
            selectedRB3 = rb3.getText().toString();

        }
        if(selectedRG4 != -1){
            rb4 = findViewById(selectedRG4);
            selectedRB4 = rb4.getText().toString();

        }
        if(selectedRG5 != -1){
            rb5 = findViewById(selectedRG5);
            selectedRB5 = rb5.getText().toString();

        }
        if(selectedRG6 != -1){
            rb6 = findViewById(selectedRG6);
            selectedRB6 = rb6.getText().toString();

        }
        if (selectedRG7 !=-1){
            rb7 = findViewById(selectedRG7);
            selectedRB7 = rb7.getText().toString();

        }
        if(selectedRG8 != -1){
            rb8 = findViewById(selectedRG8);
            selectedRB8 = rb8.getText().toString();

        }
        if(selectedRG9 != -1){
            rb9 = findViewById(selectedRG9);
            selectedRB9 = rb9.getText().toString();

        }
        if(selectedRG10 != -1){
            rb10 = findViewById(selectedRG10);
            selectedRB10 = rb10.getText().toString();

        }
        if(selectedRG11 != -1){
            rb11 = findViewById(selectedRG11);
            selectedRB11 = rb11.getText().toString();

        }
        if(selectedRG12 != -1){
            rb12 = findViewById(selectedRG12);
            selectedRB12 = rb12.getText().toString();

        }
        if(selectedRG13 != -1){
            rb13 = findViewById(selectedRG13);
            selectedRB13 = rb13.getText().toString();

        }
        if(selectedRG14 != -1){
            rb14 = findViewById(selectedRG12);
            selectedRB14 = rb14.getText().toString();

        }
        if(selectedRG15 != -1){
            rb15 = findViewById(selectedRG12);
            selectedRB15 = rb15.getText().toString();

        }
        if(selectedRG16 != -1){
            rb16 = findViewById(selectedRG16);
            selectedRB16 = rb16.getText().toString();

        }
        if(selectedRG17 != -1){
            rb17 = findViewById(selectedRG17);
            selectedRB17 = rb17.getText().toString();

        }

        if (selectedRB1.equals("Tidak") && selectedRB2.equals("Tidak") && selectedRB3.equals("Tidak") && selectedRB4.equals("Tidak") && selectedRB5.equals("Tidak") && selectedRB6.equals("Tidak")
                && selectedRB7.equals("Tidak") && selectedRB8.equals("Tidak") && selectedRB9.equals("Tidak") && selectedRB10.equals("Tidak") && selectedRB11.equals("Tidak") && selectedRB12.equals("Tidak")
                && selectedRB13.equals("Tidak") && selectedRB14.equals("Tidak") && selectedRB15.equals("Tidak") && selectedRB16.equals("Tidak") && selectedRB17.equals("Tidak")){
            Intent myIntent = new Intent(TubektomiActivity.this, ResultActivity.class);
            myIntent.putExtra("result", "tubektomi");
            myIntent.putExtra("kelompok", kelompok);
            myIntent.putExtra("alkon", alkon);
            startActivity(myIntent);
            finish();
            //Toast.makeText(this, "Tubektomi", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Tidak dapat menggunakan Tubektomi", Toast.LENGTH_LONG).show();
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
