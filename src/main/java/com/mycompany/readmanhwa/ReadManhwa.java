package com.mycompany.readmanhwa;

import java.time.Year;
import java.util.Scanner;

public class ReadManhwa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manhwa[] daftarManhwa = new Manhwa[20];
        int jumlahManhwa = 0;
        boolean isRunning = true;

        daftarManhwa[jumlahManhwa++] = new ManhwaOngoing(
                "Omniscient Reader's Viewpoint", "Naver Webtoon", 2020, 9.5, 200,
                "Kim Dokja adalah satu-satunya pembaca yang menamatkan sebuah novel web. "
                + "Suatu hari dunia nyata berubah menjadi isi novel itu, dan ia memakai pengetahuannya untuk bertahan hidup.",
                "Action, Adventure, Fantasy", "Mingguan");

        daftarManhwa[jumlahManhwa++] = new ManhwaOngoing(
                "I'm Not That Kind of Talent", "Naver Webtoon", 2022, 7.4, 150,
                "Deon Hart bertubuh lemah dan mudah batuk darah saat stres. "
                + "Namun orang-orang salah paham dan mengira ia adalah sosok kuat yang menakutkan.",
                "Action, Fantasy", "Mingguan");

        daftarManhwa[jumlahManhwa++] = new ManhwaOngoing(
                "Trash of the Count's Family", "KakaoPage", 2020, 7.8, 200,
                "Seseorang bereinkarnasi menjadi Cale Henituse, anak bangsawan yang dikenal sebagai berandalan. "
                + "Ia ingin hidup santai, tetapi justru terseret ke masalah besar.",
                "Fantasy, Isekai, Reinkarnasi", "Mingguan");

        daftarManhwa[jumlahManhwa++] = new ManhwaOngoing(
                "The S-Classes That I Raised", "Naver Webtoon", 2021, 7.4, 180,
                "Han Yujin hanyalah hunter peringkat F. Ia kembali ke masa lalu dengan ingatan utuh "
                + "dan bertekad memperbaiki hubungan dengan adiknya serta membimbing para hunter peringkat S.",
                "Action, Adventure, Fantasy, Time Travel", "Mingguan");

        daftarManhwa[jumlahManhwa++] = new ManhwaCompleted(
                "Solo Leveling", "KakaoPage", 2018, 9.0, 200,
                "Sung Jinwoo adalah hunter terlemah yang mendapatkan sebuah sistem rahasia. "
                + "Dengan sistem itu, ia terus berlatih hingga menjadi hunter terkuat.",
                "Action, Adventure, Fantasy", 2021);

        System.out.println("=========================================");
        System.out.println("     SELAMAT DATANG DI READMANHWA     ");
        System.out.println("=========================================");

        while (isRunning) {
            System.out.println("\n========== MENU READMANHWA ==========");
            System.out.println("1. Tambah Manhwa");
            System.out.println("2. Lihat Daftar Manhwa");
            System.out.println("3. Cari Manhwa");
            System.out.println("4. Keluar");
            System.out.println("=====================================");
            int pilihan = bacaPilihan(scanner);

            switch (pilihan) {
                case 1:
                    if (jumlahManhwa < daftarManhwa.length) {
                        System.out.println("\n--- TAMBAH MANHWA BARU ---");
                        System.out.println("Pilih jenis manhwa:");
                        System.out.println("1. Manhwa Ongoing (masih berlanjut)");
                        System.out.println("2. Manhwa Completed (sudah tamat)");
                        int jenis = bacaAngka(scanner, "Jenis (1/2)", 1, 2);

                        System.out.println();
                        String judul = bacaTeks(scanner, "Judul");
                        String penerbit = bacaTeks(scanner, "Penerbit");
                        int tahunTerbit = bacaAngka(scanner, "Tahun terbit", 1900, Year.now().getValue());
                        double rating = bacaDesimal(scanner, "Rating (0-10)", 0, 10);
                        int chapter = bacaAngka(scanner, "Chapter", 1, 10000);

                        String status = (jenis == 1) ? "Ongoing" : "Completed";
                        System.out.printf("%-15s: %s (otomatis)%n", "Status", status);

                        String sinopsis = bacaTeks(scanner, "Sinopsis");
                        String genre = bacaTeks(scanner, "Genre lengkap");

                        if (jenis == 1) {
                            String jadwalUpdate = bacaTeks(scanner, "Jadwal update");
                            daftarManhwa[jumlahManhwa] = new ManhwaOngoing(judul, penerbit, tahunTerbit,
                                    rating, chapter, sinopsis, genre, jadwalUpdate);
                        } else {
                            int tahunTamat = bacaAngka(scanner, "Tahun tamat", tahunTerbit, Year.now().getValue());
                            daftarManhwa[jumlahManhwa] = new ManhwaCompleted(judul, penerbit, tahunTerbit,
                                    rating, chapter, sinopsis, genre, tahunTamat);
                        }
                        jumlahManhwa++;
                        System.out.println("\nManhwa berhasil ditambahkan!");
                    } else {
                        System.out.println("Daftar manhwa sudah penuh!");
                    }
                    break;

                case 2:
                    if (jumlahManhwa == 0) {
                        System.out.println("Belum ada manhwa yang terdaftar.");
                    } else {
                        System.out.println("\n========== DAFTAR MANHWA ==========");
                        System.out.printf("Total manhwa terdaftar: %d%n", Manhwa.getTotalManhwa());
                        for (int i = 0; i < jumlahManhwa; i++) {
                            System.out.printf("%n[%d] -------------------------------------%n", (i + 1));
                            daftarManhwa[i].tampilkanInfo();
                            daftarManhwa[i].caraBaca();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- CARI MANHWA ---");
                    System.out.println("1. Cari berdasarkan judul");
                    System.out.println("2. Cari berdasarkan tahun terbit");
                    int jenisCari = bacaAngka(scanner, "Pilih (1/2)", 1, 2);

                    if (jenisCari == 1) {
                        String kataKunci = bacaTeks(scanner, "Masukkan judul");
                        cariManhwa(daftarManhwa, jumlahManhwa, kataKunci);
                    } else {
                        int tahunCari = bacaAngka(scanner, "Masukkan tahun", 1900, Year.now().getValue());
                        cariManhwa(daftarManhwa, jumlahManhwa, tahunCari); 
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan ReadManhwa. Selamat membaca!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan pilih angka 1 sampai 4.");
                    break;
            }
        }
        scanner.close();
    }

    public static void cariManhwa(Manhwa[] daftar, int jumlah, String kataKunci) {
        System.out.println("\nHasil pencarian judul \"" + kataKunci + "\":");
        int ditemukan = 0;
        for (int i = 0; i < jumlah; i++) {
            if (cocokJudul(daftar[i].getJudul(), kataKunci)) {
                ditemukan++;
                System.out.printf("%n[%d] -------------------------------------%n", ditemukan);
                daftar[i].tampilkanInfo();
                daftar[i].caraBaca();
            }
        }
        if (ditemukan == 0) {
            System.out.println("Manhwa tidak ditemukan.");
        }
    }

    public static void cariManhwa(Manhwa[] daftar, int jumlah, int tahunTerbit) {
        System.out.println("\nHasil pencarian manhwa terbitan tahun " + tahunTerbit + ":");
        int ditemukan = 0;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getTahunTerbit() == tahunTerbit) {
                ditemukan++;
                System.out.printf("%n[%d] -------------------------------------%n", ditemukan);
                daftar[i].tampilkanInfo();
                daftar[i].caraBaca();
            }
        }
        if (ditemukan == 0) {
            System.out.println("Manhwa tidak ditemukan.");
        }
    }

    private static String normalisasi(String teks) {
        String bersih = teks.toLowerCase();
        bersih = bersih.replace("'", "").replace("’", ""); 
        bersih = bersih.replaceAll("[^a-z0-9]+", " "); 
        return bersih.trim();
    }

    private static boolean cocokJudul(String judul, String kataKunci) {
        String judulBersih = normalisasi(judul);
        String kunciBersih = normalisasi(kataKunci);

        if (kunciBersih.isEmpty()) {
            return false;
        }

        String[] daftarKata = kunciBersih.split("\\s+");
        for (int i = 0; i < daftarKata.length; i++) {
            if (!judulBersih.contains(daftarKata[i])) {
                return false;
            }
        }
        return true;
    }

    private static int bacaPilihan(Scanner scanner) {
        System.out.print("Pilih menu (1-4): ");
        String masukan = scanner.nextLine().trim();
        try {
            return Integer.parseInt(masukan);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String bacaTeks(Scanner scanner, String label) {
        String masukan = "";
        while (masukan.isEmpty()) {
            System.out.printf("%-15s: ", label);
            masukan = scanner.nextLine().trim();
            if (masukan.isEmpty()) {
                System.out.println("  Data tidak boleh kosong, silakan ulangi.");
            }
        }
        return masukan;
    }

    private static int bacaAngka(Scanner scanner, String label, int min, int max) {
        while (true) {
            System.out.printf("%-15s: ", label);
            String masukan = scanner.nextLine().trim();
            try {
                int angka = Integer.parseInt(masukan);
                if (angka >= min && angka <= max) {
                    return angka;
                }
                System.out.println("  Masukkan angka " + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  Input harus berupa angka bulat.");
            }
        }
    }

    private static double bacaDesimal(Scanner scanner, String label, double min, double max) {
        while (true) {
            System.out.printf("%-15s: ", label);
            String masukan = scanner.nextLine().trim().replace(',', '.');
            try {
                double angka = Double.parseDouble(masukan);
                if (angka >= min && angka <= max) {
                    return angka;
                }
                System.out.println("  Masukkan angka " + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  Input harus berupa angka.");
            }
        }
    }
}
