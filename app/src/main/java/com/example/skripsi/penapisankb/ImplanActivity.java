package com.example.skripsi.penapisankb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ImplanActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup radioGroup1,  radioGroup2,  radioGroup3,  radioGroup4,  radioGroup5,  radioGroup6,  radioGroup7,  radioGroup8,  radioGroup9,  radioGroup10;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10;
    private CheckBox check1, check2, check3;

    String selectedRB1, selectedRB2, selectedRB3, selectedRB4, selectedRB5, selectedRB6, selectedRB7, selectedRB8, selectedRB9, selectedRB10;
    private Button btnLanjut, btnProses;
    private LinearLayout linearPrior, linearDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Implan");

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

    private void initComponent(){
        radioGroup1 = findViewById(R.id.rg_implan1);
        radioGroup2 = findViewById(R.id.rg_implan2);
        radioGroup3 = findViewById(R.id.rg_implan3);
        radioGroup4 = findViewById(R.id.rg_implan4);
        radioGroup5 = findViewById(R.id.rg_implan5);
        radioGroup6 = findViewById(R.id.rg_implan6);
        radioGroup7 = findViewById(R.id.rg_implan7);
        radioGroup8 = findViewById(R.id.rg_implan8);
        radioGroup9 = findViewById(R.id.rg_implan9);
        radioGroup10 = findViewById(R.id.rg_implan10);

        check1 = findViewById(R.id.check_bp01);
        check2 = findViewById(R.id.check_bp02);
        check3 = findViewById(R.id.check_bp03);

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

        if (selectedRB1.equals("Tidak") && selectedRB2.equals("Tidak") && selectedRB3.equals("Tidak") && selectedRB4.equals("Tidak") && selectedRB5.equals("Tidak") && selectedRB6.equals("Tidak")
                && selectedRB7.equals("Tidak") && selectedRB8.equals("Tidak") && selectedRB9.equals("Tidak") && selectedRB10.equals("Tidak")
                && check1.isChecked() && check2.isChecked() && check3.isChecked()){
            Toast.makeText(this, "Implan", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Tidak dapat menggunakan Implan", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lanjut:
                linearDecision.setVisibility(View.VISIBLE);
                linearPrior.setVisibility(View.GONE);
                btnLanjut.setVisibility(View.GONE);
                btnProses.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_proses:
                process();
                break;
        }
    }
}
