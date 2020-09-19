package com.skripsi.penapisankb.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class BidanSP {
    static final String SHARED_BIDAN = "SHARED_BIDAN";
    static final String KEY_ID_BIIDAN = "ID_BIDAN";
    static final String KEY_NAMA_BIIDAN = "NAMA_BIDAN";
    static final String KEY_ALAMAT_BIDAN = "ALAMAT_BIDAN";
    static final String KEY_WIL_KERJA = "WIL_KERJA";


    public static void bidanRegister(Context context,Bidan bidan){

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_BIDAN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID_BIIDAN, "1");
        editor.putString(KEY_NAMA_BIIDAN, bidan.getNama());
        editor.putString(KEY_ALAMAT_BIDAN, bidan.getAlamat());
        editor.putString(KEY_WIL_KERJA, bidan.getWil());
        editor.apply();
    }
    public static Bidan getBidan(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_BIDAN, Context.MODE_PRIVATE);
        return new Bidan(
                "1",
        sharedPreferences.getString(KEY_NAMA_BIIDAN, null),
        sharedPreferences.getString(KEY_ALAMAT_BIDAN, null),
        sharedPreferences.getString(KEY_WIL_KERJA, null)
        );

    }
}
