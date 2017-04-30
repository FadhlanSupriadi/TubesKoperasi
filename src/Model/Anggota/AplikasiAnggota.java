/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Anggota;

import java.util.ArrayList;
import Database.Database;

/**
 *
 * @author Fadhlan
 */
public class AplikasiAnggota {
    ArrayList<Anggota> daftarAnggota;
    Database db;

    public AplikasiAnggota() {
        db = new Database();
        db.connect();
        daftarAnggota = db.loadAnggota();
    }

    public void addAnggota(String id_anggota, String nama, String no_ktp, String pekerjaan, String no_hp) {
        if (getAnggota(id_anggota) != null) {
            throw new IllegalArgumentException("username telah dipakai");
        }
        Anggota a = new Anggota(id_anggota, nama, no_ktp, pekerjaan, no_hp);
        daftarAnggota.add(a);
        db.saveAnggota(a);
    }

    public Anggota getAnggota(String id_anggota) {
        for (Anggota a : daftarAnggota) {
            if (a.getIdanggota().equals(id_anggota)) {
                return a;
            }
        }
        return null;
    }

    public String viewAnggota() {
        String s = "asdasda";
        for (Anggota a : daftarAnggota) {
            s += a.getIdanggota() + "\n";
        }
        return s;
    }
}
