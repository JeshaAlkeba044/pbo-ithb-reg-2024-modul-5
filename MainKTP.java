import view.FormInputPenduduk;
import view.HasilKTP;
import javax.swing.SwingUtilities;

public class MainKTP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormInputPenduduk());
    }
    
}

