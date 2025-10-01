/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public abstract class Kontak {
    private int id;
    private String nama;
    private String nomorHp;

    public Kontak(int id, String nama, String nomorHp) {
        this.id = id;
        this.nama = nama;
        this.nomorHp = nomorHp;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNomorHp() { return nomorHp; }
    public void setNomorHp(String nomorHp) { this.nomorHp = nomorHp; }

    // Abstraksi → setiap subclass wajib override
    public abstract String tampilkanInfo();
}