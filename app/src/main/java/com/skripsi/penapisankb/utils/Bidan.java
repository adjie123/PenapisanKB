package com.skripsi.penapisankb.utils;

public class Bidan {
    private String id;
    private String nama;
    private String alamat;
    private String wil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }


    public String getAlamat() {
        return alamat;
    }

    public String getWil() {
        return wil;
    }

    public Bidan(String id, String nama, String alamat, String wil) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.wil = wil;
    }
}
