package com.rplbo;

public class Waktu {
    private int detik;
    private int menit;
    private int jam;

    public Waktu(int jam, int menit, int detik) {

    }

    public Waktu(int jam) {

    }

    //copy constructor
    public Waktu(Waktu waktu) {

    }

    public int selisih(int jam, int menit, int detik) {

        return 0;
    }

    public int selisih(Waktu waktu) {

        return 0;
    }

    public void tampilWaktu() {

    }

    public void tambahDetik(int add) {

    }

    public void tambahMenit(int add) {
        tambahDetik(add * 60);
    }

    public void tambahJam(int add) {

    }

}
