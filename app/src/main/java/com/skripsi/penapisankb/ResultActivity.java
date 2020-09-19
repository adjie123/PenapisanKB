package com.skripsi.penapisankb;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.skripsi.penapisankb.R;
import com.skripsi.penapisankb.utils.BidanSP;
import com.skripsi.penapisankb.utils.Bunda;
import com.skripsi.penapisankb.utils.BundaSP;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ResultActivity extends AppCompatActivity {
    private ImageView imgResult;
    private TextView tvBunda, tvResult;
    private Button btnCreatePDF, btnLiatPDF;
    Bitmap bmp, scaledbmp;
    private String kelompok, alkon, value;

    private static final int PERMISSION_REQUEST_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (hasRealRemovableSdCard(this)){

            if (!checkPermission()) {
                Toast.makeText(this, "Otorisasi Perizinan Aktif", Toast.LENGTH_LONG).show();
            } else {
                if (checkPermission()) {
                    requestPermissionAndContinue();
                } else {
                    Toast.makeText(this, "Otorisasi Perizinan Tidak Aktif", Toast.LENGTH_LONG).show();
                }
            }
        }

        initComponent();
        String namaBundda = BundaSP.getBunda(getBaseContext()).getNamaBunda();
        tvBunda.setText("Selamat Bunda "+namaBundda);

        Intent intent = getIntent();
        value = intent.getStringExtra("result");
        kelompok = intent.getStringExtra("kelompok");
        alkon = intent.getStringExtra("alkon");


        if (value.equals("implan")){
            imgResult.setImageResource(R.drawable.implan);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan KB Implan");
        }else if (value.equals("akdrcu")){
            imgResult.setImageResource(R.drawable.iud);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan AKDR Cu");
        }else if (value.equals("akdrpro")){
            imgResult.setImageResource(R.drawable.iud);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan AKDR Pro");
        }else if (value.equals("pilkom")){
            imgResult.setImageResource(R.drawable.pil_kombinasi);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan Pil Kombinasi");
        }else if (value.equals("pilpro")){
            imgResult.setImageResource(R.drawable.pil_progestin);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan Pil Progestin");
        }else if (value.equals("suntikkom")){
            imgResult.setImageResource(R.drawable.suntik_satu_bulan);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan Suntik Kombinasi");
        }else if (value.equals("suntikpro")){
            imgResult.setImageResource(R.drawable.suntik_tiga_bulan);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan Suntik Progestin");
        }else if (value.equals("tubektomi")){
            imgResult.setImageResource(R.drawable.tubektomi);
            tvResult.setText("Bunda "+namaBundda + " dapat menggunakan Tubektomi");
        }

    }
    public static boolean hasRealRemovableSdCard(Context context) {
        return ContextCompat.getExternalFilesDirs(context, null).length >= 2;
    }
    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ;
    }

    private void requestPermissionAndContinue() {
        if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE)
                    && ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setCancelable(true);
                alertBuilder.setTitle("Izin Akses");
                alertBuilder.setMessage("Izinkan aplikasi mengakses sd card anda");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(ResultActivity.this, new String[]{WRITE_EXTERNAL_STORAGE
                                , READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
                Log.e("", "permission denied, show dialog");
            } else {
                ActivityCompat.requestPermissions(ResultActivity.this, new String[]{WRITE_EXTERNAL_STORAGE,
                        READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
            }
        }else if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE)
                    && ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setCancelable(true);
                alertBuilder.setTitle("Izin Akses");
                alertBuilder.setMessage("Izinkan aplikasi mengakses sd card anda");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(ResultActivity.this, new String[]{WRITE_EXTERNAL_STORAGE
                                , READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
                Log.e("", "permission denied, show dialog");
            } else {
                ActivityCompat.requestPermissions(ResultActivity.this, new String[]{WRITE_EXTERNAL_STORAGE,
                        READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
            }
        } else {
            Toast.makeText(this,"Permission accessed", Toast.LENGTH_LONG).show();
        }
    }
    private void initComponent(){
        imgResult = findViewById(R.id.img_result);
        tvBunda = findViewById(R.id.tv_nama_bunda);
        tvResult = findViewById(R.id.tv_result);

        btnCreatePDF = findViewById(R.id.btn_create_pdf);
        btnLiatPDF = findViewById(R.id.btn_view_pdf);

        btnCreatePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    generatePDF();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnLiatPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF();
            }
        });


        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 80, 80, false);
    }

    private void generatePDF() throws FileNotFoundException {
        PdfDocument pdfDocument = new PdfDocument();
        Paint myPaint = new Paint();

        PdfDocument.PageInfo pageInfo =  new PdfDocument.PageInfo.Builder(300, 700,1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        canvas.drawBitmap(scaledbmp, 215 ,5 , myPaint);

        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setTextSize(12.0f);
            canvas.drawText("Data Bidan", pageInfo.getPageWidth()/2, 15, myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(8.0f);
        myPaint.setColor(Color.BLACK);

        int startXPosition = 10;
        int startYPosition = 40;
        String[] information = new String[]{"Nama Bidan", "Alamat Bidan"," Wilayah Kerja"};
        for (int i=0; i<information.length; i++){
            canvas.drawText(information[i],startXPosition, startYPosition, myPaint);
            canvas.drawLine(startXPosition, startYPosition+3, 180, startYPosition+3, myPaint);
            startYPosition+=20;
        }

        canvas.drawLine(85,30,85,90,myPaint);



        String namaBidan = BidanSP.getBidan(getBaseContext()).getNama();
        String almBidan = BidanSP.getBidan(getBaseContext()).getAlamat();
        String wilKerja = BidanSP.getBidan(getBaseContext()).getWil();
        String[] getInfo = new String[]{namaBidan, almBidan, wilKerja};

        myPaint.setColor(Color.rgb(122,119,19));
        myPaint.setTextSize(8.0f);
        int startYYPosition = 40;
        for (int i=0; i<getInfo.length; i++){
            canvas.drawText(getInfo[i],90, startYYPosition, myPaint);
            startYYPosition+=20;
        }



        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setTextSize(12.0f);
        myPaint.setColor(Color.BLACK);
        canvas.drawText("Data Pasien", pageInfo.getPageWidth()/2, 120, myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(8.0f);
        myPaint.setColor(Color.BLACK);

        int startPXPosition = 10;
        int startPYPosition = 130;
        String[] pasien = new String[]{"Nama Pasien", "Umur Pasien","Nama Suami", "Alamat Lengkap"};
        for (int i=0; i<pasien.length; i++){
            canvas.drawText(pasien[i],startPXPosition, startPYPosition, myPaint);
            canvas.drawLine(startPXPosition, startPYPosition+3, 180, startPYPosition+3, myPaint);
            startPYPosition+=20;
        }

        canvas.drawLine(85,120,85,200,myPaint);



        String nama = BundaSP.getBunda(getBaseContext()).getNamaBunda();
        String umur = BundaSP.getBunda(getBaseContext()).getUmurBunda();
        String suami = BundaSP.getBunda(getBaseContext()).getNamaSuami();
        String alm = BundaSP.getBunda(getBaseContext()).getAlamatBunda();
        String[] getPasien = new String[]{nama, umur, suami, alm};

        myPaint.setColor(Color.rgb(122,119,19));
        myPaint.setTextSize(8.0f);
        int startPYYPosition = 130;
        for (int i=0; i<getPasien.length; i++){
            canvas.drawText(getPasien[i],90, startPYYPosition, myPaint);
            startPYYPosition+=20;
        }


        myPaint.setTextSize(25.0f);
        myPaint.setColor(Color.BLACK);
        canvas.drawText(BundaSP.getBunda(getBaseContext()).getNoRM(), 215 ,150 , myPaint);

        String[] obj = new String[]{
                "Kelompok Penapisan",
                "Jenis Alat Kontrasepsi",
                "Rekomendasi Alat Kontrasepsi"

        };


        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setTextSize(12.0f);
        myPaint.setColor(Color.BLACK);
        canvas.drawText("Hasil Penapisan Sistem Kontrasepsi", pageInfo.getPageWidth()/2, 250, myPaint);

        myPaint.setTextSize(10.0f);
        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setColor(Color.BLACK);
        int endXXXPosition = pageInfo.getPageWidth()-10;
        int startYYYPosition = 290;
        for (int i=0; i<obj.length; i++){
            canvas.drawText(obj[i],10, startYYYPosition, myPaint);
            canvas.drawLine(10, startYYYPosition+3, endXXXPosition, startYYYPosition+3, myPaint);
            startYYYPosition+=20;
        }

        String[] result = new String[]{
                kelompok,
                alkon,
                value
        };

        myPaint.setTextSize(12.0f);
        int startYYYYPosition = 290;
        for (int i=0; i<result.length; i++){
            canvas.drawText(result[i],220, startYYYYPosition, myPaint);
            startYYYYPosition+=20;
        }

        myPaint.setTextAlign(Paint.Align.RIGHT);
        myPaint.setTextSize(12.0f);
        canvas.drawText("PETUGAS", 240, 600, myPaint);

        pdfDocument.finishPage(page);

        String namaBunda = BundaSP.getBunda(getBaseContext()).getNamaBunda();
        if (hasRealRemovableSdCard(this)){
            File file = new File("/sdcard/Hasil Penapisan ("+namaBunda+") .pdf");

            try{
                pdfDocument.writeTo(new FileOutputStream(file));
                Toast.makeText(this,"Berhasil generate PDF Ext", Toast.LENGTH_LONG).show();
            }catch (IOException e){
                e.printStackTrace();
                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
            }
        }else{
            try{
                File file = new File("/data/data/"+getPackageName()+"/files/Hasil Penapisan ("+namaBunda+").pdf");
                pdfDocument.writeTo(new FileOutputStream(file));
                Log.d("Dir", String.valueOf(file));
                Toast.makeText(this,"Berhasil generate PDF In " + file, Toast.LENGTH_LONG).show();
            }catch (IOException e){
                e.printStackTrace();
                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
            }
        }

        pdfDocument.close();
    }
    private void openPDF(){
        String namaBunda = BundaSP.getBunda(getBaseContext()).getNamaBunda();

        if (hasRealRemovableSdCard(this)){
            File file = new File("/sdcard/Hasil Penapisan ("+namaBunda+").pdf");
            if (file.exists())
            {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
                intent.setDataAndType(uri, "application/pdf");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                try {
                    startActivity(intent);
                }
                catch(ActivityNotFoundException e) {
                    Toast.makeText(ResultActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            File file = new File( "/data/user/0/com.skripsi.penapisankb/files/Hasil Penapisan ("+namaBunda+").pdf");
            Intent intent=new Intent(Intent.ACTION_VIEW);
            Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() +".provider" , file);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            startActivity(intent);

        }

    }
}