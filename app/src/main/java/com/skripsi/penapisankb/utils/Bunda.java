package com.skripsi.penapisankb.utils;

public class Bunda {
    String noRM;
    String namaBunda;
    String umurBunda;
    String alamatBunda;
    String namaSuami;

    public Bunda(String noRM, String namaBunda, String umurBunda, String alamatBunda, String namaSuami) {
        this.noRM = noRM;
        this.namaBunda = namaBunda;
        this.umurBunda = umurBunda;
        this.alamatBunda = alamatBunda;
        this.namaSuami = namaSuami;
    }

    public String getNoRM() {
        return noRM;
    }

    public String getNamaBunda() {
        return namaBunda;
    }

    public String getUmurBunda() {
        return umurBunda;
    }

    public String getAlamatBunda() {
        return alamatBunda;
    }

    public String getNamaSuami() {
        return namaSuami;
    }
}
