/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Anggota;

import View.Anggota.Daftar_Anggota;
import View.Anggota.Detail_Anggota;
import View.Anggota.Tambah_Anggota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Database.Database;

public class HandlerAnggota implements ActionListener {

    private AplikasiAnggota model;
    private Daftar_Anggota view1;
    private Detail_Anggota view2;
    private Tambah_Anggota view3;
    
    public HandlerAnggota() {
        model = new AplikasiAnggota();
        view1 = new Daftar_Anggota();
        view2 = new Detail_Anggota();
        view3 = new Tambah_Anggota();
        view1.setVisible(true);
        view2.setVisible(true);
        view3.setVisible(true);
        
        view2.addActionListener(this);
        view3.addActionListener(this);
        view2.setDetilAnggota(model.viewAnggota());
        view3.setDaftarAnggota(model.viewAnggota());
        view1.setDaftarAnggota(model.viewAnggota());
     
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try {
            if (source.equals(view3.getBtnTambahAnggota())) {
                String id_anggota = view3.getIdanggota();
                String nama = view3.getNama();
                String no_ktp = view3.getNoktp();
                String pekerjaan = view3.getPekerjaan();
                String no_hp = view3.getNohp();
                model.addAnggota(id_anggota, nama, no_ktp, pekerjaan, no_hp);
                view3.reset();
            } else if (source.equals(view2.getBtnCariAnggota())) {
                String id_anggota = view2.getIdCari();
                Anggota a = model.getAnggota(id_anggota);
                view2.reset();
                if (a == null) {
                    throw new IllegalArgumentException("peserta tidak ditemukan");
                }
                view2.setDetilAnggota(a.toString());
            } else {
                System.out.println("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view1, "terjadi kesalahan input");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view1, e.getMessage());
            
        }
        view1.setDaftarAnggota(model.viewAnggota());
    }
}
