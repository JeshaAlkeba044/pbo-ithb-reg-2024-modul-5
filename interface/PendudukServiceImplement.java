import model.Penduduk;

public class PendudukServiceImplement implements PendudukService {
    @Override
    public boolean insertData(Penduduk penduduk) {
        // nyimpan data ke database cuman nampilin pesan sukses
        return penduduk != null && isValid(penduduk);
    }

    @Override
    public boolean isValid(Penduduk penduduk) {
        return penduduk.getNik() != null && !penduduk.getNik().isEmpty() &&
               penduduk.getNama() != null && !penduduk.getNama().isEmpty() &&
               penduduk.getAlamat() != null && !penduduk.getAlamat().isEmpty();
    }
}

