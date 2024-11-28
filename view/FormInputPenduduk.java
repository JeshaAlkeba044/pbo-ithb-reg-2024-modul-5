package view;

import javax.swing.*;
import controller.PendudukController;
import classes.model.Penduduk;
import view.HasilKTP;
import model.enums.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FormInputPenduduk extends JFrame {
    private JTextField utxtNik, txtNama, txtTempatLahir, txtAlamat, txtRt_Rw, txtKel_Desa, txtKecamatan, txtKewarganegaraan, txtBerlakuHingga, txtKotaPembuatan;
    private JComboBox<Agama> cbAgama;
    private JComboBox<StatusPerkawinan> cbStatusPerkawinan;
    private JRadioButton rbPria, rbWanita, rbA, rbB, rbO, rbAB, rbWni, rbWna;
    private JCheckBox cbKaryawanSwasta, cbPns, cbWiraswasta, cbAkademisi, cbPengangguran;
    private JFileChooser fileChooserFoto, fileChooserTandaTangan;
    private JButton btnInsert;
    private ButtonGroup bgJenisKelamin, bgGolonganDarah, bgKewarganegaraan;
    private JSpinner spTanggalLahir, spTanggalPembuatan;

    public FormInputPenduduk() {
        setTitle("Form Input Data Penduduk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(22, 2));

        // NIK
        add(new JLabel("NIK:"));
        txtNik = new JTextField();
        add(txtNik);

        // Nama
        add(new JLabel("Nama:"));
        txtNama = new JTextField();
        add(txtNama);

        // Tempat Lahir
        add(new JLabel("Tempat Lahir:"));
        txtTempatLahir = new JTextField();
        add(txtTempatLahir);

        // Tanggal Lahir
        add(new JLabel("Tanggal Lahir:"));
        spTanggalLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor deTanggalLahir = new JSpinner.DateEditor(spTanggalLahir, "yyyy-MM-dd");
        spTanggalLahir.setEditor(deTanggalLahir);
        add(spTanggalLahir);

        // Jenis Kelamin
        add(new JLabel("Jenis Kelamin:"));
        JPanel panelJenisKelamin = new JPanel(new FlowLayout());
        rbPria = new bJRadioButton("Pria");
        rbWanita = new JRadioButton("Wanita");
        bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbPria);
        bgJenisKelamin.add(rbWanita);
        panelJenisKelamin.add(rbPria);
        panelJenisKelamin.add(rbWanita);
        add(panelJenisKelamin);

        // Golongan Darah
        add(new JLabel("Golongan Darah:"));
        JPanel panelGolDarah = new JPanel(new FlowLayout());
        rbA = new JRadioButton("A");
        rbB = new JRadioButton("B");
        rbO = new JRadioButton("O");
        rbAB = new JRadioButton("AB");
        bgGolonganDarah = new ButtonGroup();
        bgGolonganDarah.add(rbA);
        bgGolonganDarah.add(rbB);
        bgGolonganDarah.add(rbO);
        bgGolonganDarah.add(rbAB);
        panelGolDarah.add(rbA);
        panelGolDarah.add(rbB);
        panelGolDarah.add(rbO);
        panelGolDarah.add(rbAB);
        add(panelGolDarah);

        // Alamat
        add(new JLabel("Alamat:"));
        txtAlamat = new JTextField();
        add(txtAlamat);

        // RT_RW
        add(new JLabel("RT/RW:"));
        txtRt_Rw = new JTextField();
        add(txtRt_Rw);

        // Kel_Desa
        add(new JLabel("Kel/Desa:"));
        txtKel_Desa = new JTextField();
        add(txtKel_Desa);

        // Kecamatan
        add(new JLabel("Kecamatan:"));
        txtKecamatan = new JTextField();
        add(txtKecamatan);

        // Agama
        add(new JLabel("Agama:"));
        cbAgama = new JComboBox<>(Agama.values());
        add(cbAgama);

        // Status Perkawinan
        add(new JLabel("Status Perkawinan:"));
        cbStatusPerkawinan = new JComboBox<>(StatusPerkawinan.values());
        add(cbStatusPerkawinan);

        // Pekerjaan
        add(new JLabel("Pekerjaan:"));
        JPanel panelPekerjaan = new JPanel(new FlowLayout());
        cbKaryawanSwasta = new JCheckBox("Karyawan Swasta");
        cbPns = new JCheckBox("PNS");
        cbWiraswasta = new JCheckBox("Wiraswasta");
        cbAkademisi = new JCheckBox("Akademisi");
        cbPengangguran = new JCheckBox("Pengangguran");
        panelPekerjaan.add(cbKaryawanSwasta);
        panelPekerjaan.add(cbPns);
        panelPekerjaan.add(cbWiraswasta);
        panelPekerjaan.add(cbAkademisi);
        panelPekerjaan.add(cbPengangguran);
        add(panelPekerjaan);

        //checkbox pengangguran
        cbPengangguran.addItemListener(e -> {
            boolean disabled = cbPengangguran.isSelected();
            cbKaryawanSwasta.setEnabled(!disabled);
            cbPns.setEnabled(!disabled);
            cbWiraswasta.setEnabled(!disabled);
            cbAkademisi.setEnabled(!disabled);
        });

        // Kewarganegaraan
        add(new JLabel("Kewarganegaraan:"));
        JPanel panelKewarganegaraan = new JPanel(new FlowLayout());
        rbWni = new JRadioButton("WNI");
        rbWna = new JRadioButton("WNA");
        bgKewarganegaraan = new ButtonGroup();
        bgKewarganegaraan.add(rbWni);
        bgKewarganegaraan.add(rbWna);
        panelKewarganegaraan.add(rbWni);
        panelKewarganegaraan.add(rbWna);
        add(panelKewarganegaraan);

        txtWnaNegara = new JTextField();
        txtWnaNegara.setEnabled(false);
        rbWna.addItemListener(e -> txtWnaNegara.setEnabled(rbWna.isSelected()));
        add(new JLabel("Jika WNA, sebutkan negara:"));
        add(txtWnaNegara);

        // Foto
        add(new JLabel("Foto:"));
        fileChooserFoto = new JFileChooser();
        JButton btnChooseFoto = new JButton("Pilih Foto");
        btnChooseFoto.addActionListener(e -> {
            int returnValue = fileChooserFoto.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Foto dipilih: " + fileChooserFoto.getSelectedFile().getPath());
            }
        });
        add(btnChooseFoto);

        // Tanda Tangan
        add(new JLabel("Tanda Tangan:"));
        fileChooserTandaTangan = new JFileChooser();
        JButton btnChooseTandaTangan = new JButton("Pilih Tanda Tangan");
        btnChooseTandaTangan.addActionListener(e -> {
            int returnValue = fileChooserTandaTangan.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Tanda Tangan dipilih: " + fileChooserTandaTangan.getSelectedFile().getPath());
            }
        });
        add(btnChooseTandaTangan);

        // Berlaku Hingga
        add(new JLabel("Berlaku Hingga:"));
        txtBerlakuHingga = new JTextField();
        add(txtBerlakuHingga);

        // Kota Pembuatan
        add(new JLabel("Kota Pembuatan:"));
        txtKotaPembuatan = new JTextField();
        add(txtKotaPembuatan);

        // Tanggal Pembuatan
        add(new JLabel("Tanggal Pembuatan:"));
        spTanggalPembuatan = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor deTanggalPembuatan = new JSpinner.DateEditor(spTanggalPembuatan, "yyyy-MM-dd");
        spTanggalPembuatan.setEditor(deTanggalPembuatan);
        add(spTanggalPembuatan);

        // button Insert Data
        btnInsert = new JButton("Insert Data");
        btnInsert.addActionListener(e -> {
            try {
                Penduduk penduduk = new Penduduk(
                    txtNik.getText(),
                    txtNama.getText(),
                    txtTempatLahir.getText(),
                    rbPria.isSelected() ? JenisKelamin.PRIA : JenisKelamin.WANITA,
                    rbA.isSelected() ? GolonganDarah.A : rbB.isSelected() ? GolonganDarah.B :
                    rbO.isSelected() ? GolonganDarah.O : GolonganDarah.AB,
                    txtAlamat.getText(),
                    txtRt_Rw.getText(),
                    txtKel_Desa.getText(),
                    txtKecamatan.getText(),
                    (Agama) cbAgama.getSelectedItem(),
                    (StatusPerkawinan) cbStatusPerkawinan.getSelectedItem(),
                    cbKaryawanSwasta.isSelected() ? "Karyawan Swasta" :
                    cbPns.isSelected() ? "PNS" :
                    cbWiraswasta.isSelected() ? "Wiraswasta" :
                    cbAkademisi.isSelected() ? "Akademisi" : "Pengangguran",
                    rbWni.isSelected() ? "WNI" : "WNA",
                    txtBerlakuHingga.getText(),
                    txtKotaPembuatan.getText(),
                    fileChooserFoto.getSelectedFile() != null ? fileChooserFoto.getSelectedFile().getPath() : "",
                    fileChooserTandaTangan.getSelectedFile() != null ? fileChooserTandaTangan.getSelectedFile().getPath() : "",
                    (java.util.Date) spTanggalLahir.getValue(),
                    (java.util.Date) spTanggalPembuatan.getValue()
                );

                PendudukController controller = new PendudukController();
                if (controller.validatePenduduk(penduduk)) {
                    JOptionPane.showMessageDialog(this, "Data valid dan berhasil disimpan!");
                    new HasilKTP(penduduk).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak valid, silakan periksa kembali!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
            }
        });
        add(btnInsert);

        pack();
        setSize(800, 800);
        setVisible(true);
    
    }

    private void handleInsertAction() {
        if (fileChooserFoto.getSelectedFile() == null || fileChooserTandaTangan.getSelectedFile() == null) {
            JOptionPane.showMessageDialog(this, "Mohon pilih file Foto dan Tanda Tangan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isValidData()) {
            Penduduk penduduk = collectData();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            new HasilKTP(penduduk).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Eror", "lengkapi semua data!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidData() {
        if (txtNik.getText().isEmpty() || txtNama.getText().isEmpty() || txtTempatLahir.getText().isEmpty() ||
            txtAlamat.getText().isEmpty() || txtRt_Rw.getText().isEmpty() || txtKel_Desa.getText().isEmpty() ||
            txtKecamatan.getText().isEmpty() || txtBerlakuHingga.getText().isEmpty() || txtKotaPembuatan.getText().isEmpty()) {
            return false;
        }
    
        //jenis kelamin
        if (!rbPria.isSelected() && !rbWanita.isSelected()) {
            return false;
        }
    
        //golongan darah
        if (!rbA.isSelected() && !rbB.isSelected() && !rbO.isSelected() && !rbAB.isSelected()) {
            return false;
        }
    
        //kewarganegaraan
        if (!rbWni.isSelected() && !rbWna.isSelected()) {
            return false;
        }
    
        if (rbWna.isSelected() && txtWnaNegara.getText().isEmpty()) {
            return false;
        }
    
        return true;
    }
    
    private Penduduk collectData() {
    Penduduk penduduk = new Penduduk();
    penduduk.setNik(txtNik.getText());
    penduduk.setNama(txtNama.getText());
    penduduk.setTempatLahir(txtTempatLahir.getText());
    penduduk.setTanggalLahir(spTanggalLahir.getValue().toString());
    penduduk.setJenisKelamin(rbPria.isSelected() ? JenisKelamin.PRIA : JenisKelamin.WANITA);
    penduduk.setGolonganDarah(
        rbA.isSelected() ? GolonganDarah.A :
        rbB.isSelected() ? GolonganDarah.B :
        rbO.isSelected() ? GolonganDarah.O : GolonganDarah.AB
    );
    penduduk.setAlamat(txtAlamat.getText());
    penduduk.setRt_Rw(txtRt_Rw.getText());
    penduduk.setKel_Desa(txtKel_Desa.getText());
    penduduk.setKecamatan(txtKecamatan.getText());
    penduduk.setAgama((Agama) cbAgama.getSelectedItem());
    penduduk.setStatusPerkawinan((StatusPerkawinan) cbStatusPerkawinan.getSelectedItem());

    //pekerjaan
    ArrayList<String> pekerjaan = new ArrayList<>();
    if (cbKaryawanSwasta.isSelected()) pekerjaan.add("Karyawan Swasta");
    if (cbPns.isSelected()) pekerjaan.add("PNS");
    if (cbWiraswasta.isSelected()) pekerjaan.add("Wiraswasta");
    if (cbAkademisi.isSelected()) pekerjaan.add("Akademisi");
    if (cbPengangguran.isSelected()) pekerjaan.add("Pengangguran");
    penduduk.setPekerjaan(String.join(", ", pekerjaan));

    //Kewarganegaraan
    if (rbWni.isSelected()) {
        penduduk.setKewarganegaraan("WNI");
    } else if (rbWna.isSelected()) {
        penduduk.setKewarganegaraan("WNA (" + txtWnaNegara.getText() + ")");
    }

    penduduk.setBerlakuHingga(txtBerlakuHingga.getText());
    penduduk.setKotaPembuatan(txtKotaPembuatan.getText());
    penduduk.setTanggalPembuatan(spTanggalPembuatan.getValue().toString());

    // Simpan foto dan tanda tangan
    penduduk.setFoto(fileChooserFoto.getSelectedFile() != null ? fileChooserFoto.getSelectedFile().getPath() : "");
    penduduk.setTandaTangan(fileChooserTandaTangan.getSelectedFile() != null ? fileChooserTandaTangan.getSelectedFile().getPath() : "");

    return penduduk;
}
}
