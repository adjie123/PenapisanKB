package com.skripsi.penapisankb.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class BundaSP {
    static final String SHARED_BUNDA = "SHARED_BUNDA";
    static final String KEY_NORM = "NO_RM";
    static final String KEY_NAMA_BUNDA = "NAMA_BUNDA";
    static final String KEY_UMUR_BUNDA = "UMUR_BUNDA";
    static final String KEY_ALAMAT_BUNDA = "ALAMAT_BUNDA";
    static final String KEY_NAMA_SUAMI = "NAMA_SUAMI";


    public static void bundaRegister(Context context, Bunda bunda){

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_BUNDA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NORM, bunda.getNoRM());
        editor.putString(KEY_NAMA_BUNDA, bunda.getNamaBunda());
        editor.putString(KEY_UMUR_BUNDA, bunda.getUmurBunda());
        editor.putString(KEY_ALAMAT_BUNDA, bunda.getAlamatBunda());
        editor.putString(KEY_NAMA_SUAMI, bunda.getNamaSuami());
        editor.apply();
    }
    public static Bunda getBunda(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_BUNDA, Context.MODE_PRIVATE);
        return new Bunda(
                sharedPreferences.getString(KEY_NORM, null),
                sharedPreferences.getString(KEY_NAMA_BUNDA, null),
                sharedPreferences.getString(KEY_UMUR_BUNDA, null),
                sharedPreferences.getString(KEY_ALAMAT_BUNDA, null),
                sharedPreferences.getString(KEY_NAMA_SUAMI, null)
        );

    }
}
