/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import model.*;

public class KontakService {
    public ArrayList<Kontak> daftar = new ArrayList<>();
    private int nextId = 1;

    public void tambahKontak(String nama, String nomorHp, int jenis) {
        Kontak k;
        if (jenis == 1) {
            k = new KontakPribadi(nextId++, nama, nomorHp);
        } else {
            k = new KontakBisnis(nextId++, nama, nomorHp);
        }
        daftar.add(k);
        System.out.println("_____________________________________");
        System.out.println("Berhasil menambahkan '" + nama + "'");
    }

    public void tambahKontak(String nama, String nomorHp) {
        Kontak k = new KontakPribadi(nextId++, nama, nomorHp);
        daftar.add(k);
        System.out.println("_____________________________________");
        System.out.println("Berhasil menambahkan '" + nama + "' sebagai kontak default (Pribadi)");
    }

    public void listKontak() {
        System.out.println("\n=====================================");
        System.out.println("             List Kontak");
        System.out.println("=====================================");
        if (daftar.isEmpty()) {
            System.out.println("[!] Belum ada kontak");
        } else {
            for (Kontak k : daftar) {
                System.out.println(k.tampilkanInfo());
            }
        }
    }

    public void editKontak(int id, String namaBaru, String nomorBaru) {
        for (Kontak k : daftar) {
            if (k.getId() == id) {
                k.setNama(namaBaru);
                k.setNomorHp(nomorBaru);
                System.out.println("_____________________________________");
                System.out.println("Berhasil memperbarui kontak");
                return;
            }
        }
        System.out.println("_____________________________________");
        System.out.println("[!] Nomor kontak tidak valid.");
    }

    public void hapusKontak(int id) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getId() == id) {
                System.out.println("_____________________________________");
                System.out.println("'" + daftar.get(i).getNama() + "' berhasil dihapus.");
                daftar.remove(i);
                return;
            }
        }
        System.out.println("_____________________________________");
        System.out.println("[!] Nomor kontak tidak valid.");
    }

    public void cariKontak(String keyword) {
        System.out.println("\n=====================================");
        System.out.println("         Hasil Pencarian");
        System.out.println("=====================================");

        boolean ketemu = false;
        for (Kontak k : daftar) {
            if (k instanceof CariKontak && ((CariKontak) k).cocok(keyword)) {
                System.out.println(k.tampilkanInfo());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("[!] Tidak ada kontak yang cocok.");
        }
    }
}