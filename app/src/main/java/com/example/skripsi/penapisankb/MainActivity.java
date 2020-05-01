package com.example.skripsi.penapisankb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup radio1, radio2, radio3, radio4, radio5, radio6, radio7;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    String selectedRB1, selectedRB2, selectedRB3, selectedRB4, selectedRB5, selectedRB6, selectedRB7;
    private Button btnLanjut, btnProses;
    private LinearLayout linearPrior, linearDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kehamilan");
        initComponent();
    }


    private void initComponent(){
        radio1 = findViewById(R.id.rg_p01);
        radio2 = findViewById(R.id.rg_p02);
        radio3 = findViewById(R.id.rg_p03);
        radio4 = findViewById(R.id.rg_p04);
        radio5 = findViewById(R.id.rg_p05);
        radio6 = findViewById(R.id.rg_p06);
        radio7 = findViewById(R.id.rg_p07);

        btnLanjut = findViewById(R.id.btn_lanjut);
        btnProses = findViewById(R.id.btn_proses);

        linearPrior = findViewById(R.id.linear_prior);
        linearDecision = findViewById(R.id.linear_decision);

        btnLanjut.setOnClickListener(this);
        btnProses.setOnClickListener(this);
    }

    private void process(){
        int selectedRG1 = radio1.getCheckedRadioButtonId();
        int selectedRG2 = radio2.getCheckedRadioButtonId();
        int selectedRG3 = radio3.getCheckedRadioButtonId();
        int selectedRG4 = radio4.getCheckedRadioButtonId();
        int selectedRG5 = radio5.getCheckedRadioButtonId();
        int selectedRG6 = radio6.getCheckedRadioButtonId();



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
    }

    private void processDecision(){
        int selectedRG7 = radio7.getCheckedRadioButtonId();


        if (selectedRG7 != -1){
            rb7 = findViewById(selectedRG7);
            selectedRB7 = rb7.getText().toString();
        }

        switch (selectedRB7){
            case "Suntik Kombinasi":
                startActivity(new Intent(this, SuntikKomActivity.class));
                break;
            case "Pil Kombinasi":
                startActivity(new Intent(this, PilKomActivity.class));
                break;
            case "Pil Progestin":
                startActivity(new Intent(this, PilProActivity.class));
                break;
            case "Suntik Progestin":
                startActivity(new Intent(this, SuntikProActivity.class));
                break;
            case "Implan":
                startActivity(new Intent(this, ImplanActivity.class));
                break;
            case "AKDR Cu":
                startActivity(new Intent(this, AKDRCuActivity.class));
                break;
            case "AKDR Pro":
                startActivity(new Intent(this, AKDRProActivity.class));
                break;
            case "Tubektomi":
                startActivity(new Intent(this, TubektomiActivity.class));
                break;
            case "Vasektomi":
                startActivity(new Intent(this, VasektomiActivity.class));
                break;
        }
    }

    private void processTwo(){
        process();
        if (selectedRB1.equals("Ya") && selectedRB2.equals("Ya") && selectedRB3.equals("Ya") && selectedRB4.equals("Ya") && selectedRB5.equals("Ya") && selectedRB6.equals("Ya")){
            linearDecision.setVisibility(View.VISIBLE);
            linearPrior.setVisibility(View.GONE);
            btnLanjut.setVisibility(View.GONE);
            btnProses.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(this, "Kemungkinan Pasien Hamil dan Kembali Melakukan Pengecekan Ketika Haid", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lanjut:
                processTwo();
                break;

            case R.id.btn_proses:
                processDecision();
                break;
        }
    }
}
