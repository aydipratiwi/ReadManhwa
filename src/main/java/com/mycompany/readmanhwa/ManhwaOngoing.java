package com.mycompany.readmanhwa;

public class ManhwaOngoing extends Manhwa {

    private String jadwalUpdate = "-";

    public ManhwaOngoing(String judul, String penerbit, int tahunTerbit, double rating,
                         int chapter, String sinopsis, String genre, String jadwalUpdate) {

        super(judul, penerbit, tahunTerbit, rating, chapter, "Ongoing", sinopsis, genre);
        setJadwalUpdate(jadwalUpdate);
    }

    public String getJadwalUpdate() {
        return this.jadwalUpdate;
    }

    public void setJadwalUpdate(String jadwalUpdate) {
        if (jadwalUpdate != null && !jadwalUpdate.trim().isEmpty()) {
            this.jadwalUpdate = jadwalUpdate.trim();
        } else {
            System.out.println("Jadwal update tidak boleh kosong!");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("%-15s: %s%n", "Jadwal Update", jadwalUpdate);
    }

    @Override
    public void caraBaca() {
        System.out.printf("%-15s: %s%n", "Cara Baca",
                "Ikuti update chapter terbaru secara rutin (" + jadwalUpdate + ").");
    }
}
