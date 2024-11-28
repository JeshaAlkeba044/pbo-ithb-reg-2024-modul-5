package controller;

import model.Penduduk;

public class PendudukController {
    public boolean validatePenduduk(Penduduk penduduk) {
        // Validasi data wajib
        if (penduduk.getNik() == null || penduduk.getNik().isEmpty()) return false;
        if (penduduk.getNama() == null || penduduk.getNama().isEmpty()) return false;
        if (penduduk.getTempatLahir() == null || penduduk.getTempatLahir().isEmpty()) return false;
        if (penduduk.getTanggalLahir() == null || penduduk.getTanggalLahir().isEmpty()) return false;
        if (penduduk.getAlamat() == null || penduduk.getAlamat().isEmpty()) return false;
        if (penduduk.getRt_Rw() == null || penduduk.getRt_Rw().isEmpty()) return false;
        if (penduduk.getKel_Desa() == null || penduduk.getKel_Desa().isEmpty()) return false;
        if (penduduk.getKecamatan() == null || penduduk.getKecamatan().isEmpty()) return false;
        if (penduduk.getBerlakuHingga() == null || penduduk.getBerlakuHingga().isEmpty()) return false;
        if (penduduk.getKotaPembuatan() == null || penduduk.getKotaPembuatan().isEmpty()) return false;

        // Validasi data khusus
        if (penduduk.getJenisKelamin() == null) return false;
        if (penduduk.getGolonganDarah() == null) return false;
        if (penduduk.getAgama() == null) return false;
        if (penduduk.getStatusPerkawinan() == null) return false;
        if (penduduk.getPekerjaan() == null || penduduk.getPekerjaan().isEmpty()) return false;

        // Validasi tambahan jika WNA
        if (penduduk.getKewarganegaraan() != null && penduduk.getKewarganegaraan().contains("WNA")) {
            if (!penduduk.getKewarganegaraan().contains("(")) return false;
        }

        return true;
    }
}

