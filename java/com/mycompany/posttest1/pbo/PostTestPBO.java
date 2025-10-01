/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest1.pbo;

/**
 *
 * @author LENOVO
 */

import java.util.Scanner;
import service.KontakService;

public class PostTestPBO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        KontakService service = new KontakService();
        int pilihan = 0;

        System.out.println("===========  Kontak Saya  ===========");

        while (pilihan != 6) {
            System.out.println("\n-------------------------------------");
            System.out.println("                Menu                 ");
            System.out.println("-------------------------------------");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. List Kontak");
            System.out.println("3. Edit Kontak");
            System.out.println("4. Hapus Kontak");
            System.out.println("5. Cari Kontak");
            System.out.println("6. Keluar");
            System.out.println("_____________________________________");
            System.out.print("Masukkan pilihan [1-6]: ");

            if (!input.hasNextInt()) {
                System.out.println("[!] Pilihan harus angka!");
                input.nextLine();
                continue;
            }
            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                System.out.println("\n=====================================");
                System.out.println("            Kontak Baru");
                System.out.println("=====================================");
                System.out.print("Nama      : ");
                String nama = input.nextLine().trim();
                System.out.print("Nomor HP  : ");
                String nomor = input.nextLine().trim();

                if (!nama.isEmpty() && nomor.matches("\\d+")) {
                    System.out.println("Pilih jenis kontak:");
                    System.out.println("1. Kontak Pribadi");
                    System.out.println("2. Kontak Bisnis");
                    System.out.print("Jenis: ");
                    if (!input.hasNextInt()) {
                        System.out.println("[!] Pilihan harus angka!");
                        input.nextLine();
                        continue;
                    }
                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis != 1 && jenis != 2) {
                        System.out.println("[!] Jenis kontak tidak valid.");
                        continue;
                    }

                    service.tambahKontak(nama, nomor, jenis);
                } else {
                    System.out.println("_____________________________________");
                    System.out.println("[!] Nama tidak boleh kosong &");
                    System.out.println("Nomor HP harus angka");
                }
            }
            else if (pilihan == 2) { // list kontak
                service.listKontak();
            }
            else if (pilihan == 3) { // edit kontak
                System.out.println("\n=====================================");
                System.out.println("            Edit Kontak");
                System.out.println("=====================================");
                System.out.print("ID kontak yang mau diubah: ");
                if (!input.hasNextInt()) {
                    System.out.println("_____________________________________");
                    System.out.println("[!] ID harus angka.");
                    input.nextLine();
                    continue;
                }
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Nama baru   : ");
                String nama = input.nextLine().trim();
                System.out.print("Nomor baru  : ");
                String hp = input.nextLine().trim();

                if (!nama.isEmpty() && hp.matches("\\d+")) {
                    service.editKontak(id, nama, hp);
                } else {
                    System.out.println("_____________________________________");
                    System.out.println("[!] Nama tidak boleh kosong & Nomor HP harus angka.");
                }
            }
            else if (pilihan == 4) { // hapus kontak
                System.out.println("\n=====================================");
                System.out.println("            Hapus Kontak");
                System.out.println("=====================================");
                System.out.print("ID kontak yang mau dihapus: ");
                if (!input.hasNextInt()) {
                    System.out.println("_____________________________________");
                    System.out.println("[!] ID harus angka.");
                    input.nextLine();
                    continue;
                }
                int id = input.nextInt();
                input.nextLine();
                service.hapusKontak(id);
            }
            else if (pilihan == 5) { // cari kontak
                System.out.println("\n=====================================");
                System.out.println("            Cari Kontak");
                System.out.println("=====================================");
                System.out.print("Masukkan kata kunci: ");
                String keyword = input.nextLine().trim();
                service.cariKontak(keyword);
            }
                
            else if (pilihan == 6) {
                System.out.println("=====================================");
                System.out.println("   Program selesai. Terima kasih!");
                System.out.println("=====================================");
                break;
            }
           
            else {
                System.out.println("[!] Pilihan tidak valid, coba lagi.");
            }
        }

        input.close();
    }
}
