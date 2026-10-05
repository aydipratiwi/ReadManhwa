package com.mycompany.readmanhwa;

import java.time.Year;

public class Manhwa {

    private String judul = "-";
    private String penerbit = "-";
    private int tahunTerbit = 0;
    private double rating = 0;
    private int chapter = 0;
    private String status = "-";
    private String sinopsis = "-";
    private String genre = "-";

    private static int totalManhwa = 0;

    public Manhwa(String judul, String penerbit, int tahunTerbit, double rating,
                  int chapter, String status, String sinopsis, String genre) {
        setJudul(judul);
        setPenerbit(penerbit);
        setTahunTerbit(tahunTerbit);
        setRating(rating);
        setChapter(chapter);
        setStatus(status);
        setSinopsis(sinopsis);
        setGenre(genre);

        totalManhwa++;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getPenerbit() {
        return this.penerbit;
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public double getRating() {
        return this.rating;
    }

    public int getChapter() {
        return this.chapter;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSinopsis() {
        return this.sinopsis;
    }

    public String getGenre() {
        return this.genre;
    }

    public static int getTotalManhwa() {
        return totalManhwa;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul.trim();
        } else {
            System.out.println("Judul tidak boleh kosong!");
        }
    }

    public void setPenerbit(String penerbit) {
        if (penerbit != null && !penerbit.trim().isEmpty()) {
            this.penerbit = penerbit.trim();
        } else {
            System.out.println("Penerbit tidak boleh kosong!");
        }
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit >= 1900 && tahunTerbit <= Year.now().getValue()) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println("Tahun terbit tidak valid!");
        }
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            System.out.println("Rating harus berada di antara 0 sampai 10!");
        }
    }

    public void setChapter(int chapter) {
        if (chapter >= 1) {
            this.chapter = chapter;
        } else {
            System.out.println("Chapter minimal 1!");
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status.trim();
        } else {
            System.out.println("Status tidak boleh kosong!");
        }
    }

    public void setSinopsis(String sinopsis) {
        if (sinopsis != null && !sinopsis.trim().isEmpty()) {
            this.sinopsis = sinopsis.trim();
        } else {
            System.out.println("Sinopsis tidak boleh kosong!");
        }
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre.trim();
        } else {
            System.out.println("Genre tidak boleh kosong!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("%-15s: %s%n", "Judul", judul);
        System.out.printf("%-15s: %s%n", "Penerbit", penerbit);
        System.out.printf("%-15s: %d%n", "Tahun Terbit", tahunTerbit);
        System.out.printf("%-15s: %.1f%n", "Rating", rating);
        System.out.printf("%-15s: %d%n", "Chapter", chapter);
        System.out.printf("%-15s: %s%n", "Status", status);
        System.out.printf("%-15s: %s%n", "Genre", genre);
        System.out.printf("%-15s: %s%n", "Sinopsis", sinopsis);
    }

    public void caraBaca() {
        System.out.printf("%-15s: %s%n", "Cara Baca", "Baca manhwa ini melalui aplikasi resmi penerbit.");
    }
}
