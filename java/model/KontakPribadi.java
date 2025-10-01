/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class KontakPribadi extends Kontak implements CariKontak {

    public KontakPribadi(int id, String nama, String nomorHp) {
        super(id, nama, nomorHp);
    }

    @Override
    public String tampilkanInfo() {
        return getId() + ". " + getNama() + " | " + getNomorHp() + " | [Pribadi]";
    }

    @Override
    public boolean cocok(String keyword) {
        return getNama().toLowerCase().contains(keyword.toLowerCase()) ||
               getNomorHp().contains(keyword);
    }
}

