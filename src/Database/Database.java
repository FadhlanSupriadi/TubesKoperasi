/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Anggota.Anggota;
import Model.Anggota.AplikasiAnggota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    private String server = "jdbc:mysql://localhost:3306/mysql";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat koneksi");
        }
    }

    public void saveAnggota(Anggota a) {
        try {
            String query = "insert into peserta(id_anggota, nama, no_ktp, pekerjaan, no_hp) values"
                    + "('" + a.getIdanggota() + "', "
                    + "'" + a.getNama() + ", "
                    + "'" + a.getNoktp() + ", "
                    + "'" + a.getPekerjaan() + ", "
                    + "'" + a.getNohp() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save anggota");
        }
    }

    public ArrayList<Anggota> loadAnggota() {
        try {
            ArrayList<Anggota> daftarAnggota = new ArrayList<>();
            String query = "select * from peserta";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Anggota a = new Anggota(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                daftarAnggota.add(a);
            }
            return daftarAnggota;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load peserta");
        }
    }
}
