/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Anggota;

/**
 *
 * @author Fadhlan
 */
public class Anggota {
    private String id_anggota;
    private String nama;
    private String no_ktp;
    private String pekerjaan;
    private String no_hp;

    public Anggota(String id_anggota, String nama, String no_ktp, String pekerjaan, String no_hp) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.pekerjaan = pekerjaan;
        this.no_hp = no_hp;
    }

    public String getIdanggota() {
        return id_anggota;
    }

    public String getNama() {
        return nama;
    }
    
    public String getNoktp() {
        return no_ktp;
    }
    
    public String getPekerjaan() {
        return pekerjaan;
    }
    
    public String getNohp() {
        return no_hp;
    }

    @Override
    public String toString() {
        return "ID\t: " + id_anggota + "\n"
                + "Nama\t:" + nama + "\n"
                + "No KTP\t:" + no_ktp + "\n"
                + "Pekerjaan\t:" + pekerjaan + "\n"
                + "No HP\t:" + no_hp + "\n";
    }
}




