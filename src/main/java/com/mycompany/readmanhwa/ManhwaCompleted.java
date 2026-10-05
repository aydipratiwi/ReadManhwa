package com.mycompany.readmanhwa;

import java.time.Year;

public class ManhwaCompleted extends Manhwa {

    private int tahunTamat = 0;

    public ManhwaCompleted(String judul, String penerbit, int tahunTerbit, double rating,
                           int chapter, String sinopsis, String genre, int tahunTamat) {
        super(judul, penerbit, tahunTerbit, rating, chapter, "Completed", sinopsis, genre);
        this.tahunTamat = tahunTerbit;
        setTahunTamat(tahunTamat);
    }

    public int getTahunTamat() {
        return this.tahunTamat;
    }

    public void setTahunTamat(int tahunTamat) {
        if (tahunTamat >= getTahunTerbit() && tahunTamat <= Year.now().getValue()) {
            this.tahunTamat = tahunTamat;
        } else {
            System.out.println("Tahun tamat tidak valid!");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("%-15s: %d%n", "Tahun Tamat", tahunTamat);
    }

    @Override
    public void caraBaca() {
        System.out.printf("%-15s: %s%n", "Cara Baca",
                "Aman dibaca maraton dari chapter 1 sampai tamat.");
    }
}
