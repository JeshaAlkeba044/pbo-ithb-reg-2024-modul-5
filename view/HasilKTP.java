package view;

import javax.swing.*;
import java.awt.*;

public class HasilKTP extends JFrame {
    public HasilKTP(Penduduk penduduk) {
        setTitle("Hasil KTP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Header
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
        JLabel lblTitle1 = new JLabel("Provinsi DKI Jakarta");
        JLabel lblTitle2 = new JLabel("Kabupaten Jakarta Barat");
        lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
        panelHeader.add(lblTitle1);
        panelHeader.add(lblTitle2);
        add(panelHeader, BorderLayout.NORTH);

        // Body
        JPanel panelBody = new JPanel();
        panelBody.setLayout(new GridLayout(15, 2));
        
        panelBody.add(new JLabel("NIK:"));
        panelBody.add(new JLabel(penduduk.getNik()));

        panelBody.add(new JLabel("Nama:"));
        panelBody.add(new JLabel(penduduk.getNama()));

        panelBody.add(new JLabel("Tempat/Tanggal Lahir:"));
        panelBody.add(new JLabel(penduduk.getTempatLahir() + " / " + penduduk.getTanggalLahir()));

        panelBody.add(new JLabel("Jenis Kelamin:"));
        panelBody.add(new JLabel(penduduk.getJenisKelamin().toString()));

        panelBody.add(new JLabel("Golongan Darah:"));
        panelBody.add(new JLabel(penduduk.getGolonganDarah().toString()));

        panelBody.add(new JLabel("Alamat:"));
        panelBody.add(new JLabel(penduduk.getAlamat()));

        panelBody.add(new JLabel("RT/RW:"));
        panelBody.add(new JLabel(penduduk.getRt_Rw()));

        panelBody.add(new JLabel("Kel/Desa:"));
        panelBody.add(new JLabel(penduduk.getKel_Desa()));

        panelBody.add(new JLabel("Kecamatan:"));
        panelBody.add(new JLabel(penduduk.getKecamatan()));

        panelBody.add(new JLabel("Agama:"));
        panelBody.add(new JLabel(penduduk.getAgama().toString()));

        panelBody.add(new JLabel("Status Perkawinan:"));
        panelBody.add(new JLabel(penduduk.getStatusPerkawinan().toString()));

        panelBody.add(new JLabel("Pekerjaan:"));
        panelBody.add(new JLabel(penduduk.getPekerjaan()));

        panelBody.add(new JLabel("Kewarganegaraan:"));
        panelBody.add(new JLabel(penduduk.getKewarganegaraan()));

        panelBody.add(new JLabel("Berlaku Hingga:"));
        panelBody.add(new JLabel(penduduk.getBerlakuHingga()));

        panelBody.add(new JLabel("Kota Pembuatan:"));
        panelBody.add(new JLabel(penduduk.getKotaPembuatan()));

        panelBody.add(new JLabel("Tanggal Pembuatan:"));
        panelBody.add(new JLabel(penduduk.getTanggalPembuatan()));

        add(panelBody, BorderLayout.CENTER);

        //Footer
        JPanel panelFooter = new JPanel();
        JLabel lblFooter = new JLabel("Republik Harapan Bangsa");
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
        panelFooter.add(lblFooter);
        add(panelFooter, BorderLayout.SOUTH);

        pack();
        setSize(400, 600);
        setVisible(true);
    }
}
