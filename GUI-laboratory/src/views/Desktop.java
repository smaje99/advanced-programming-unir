package views;

import javax.swing.JFrame;
import java.awt.Container;

public final class Desktop extends JFrame {
    private Desktop(String title, Container contentPane) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static JFrame getMedicationForm() {
        return new Desktop("Nuevo pedido - Farmacia", new MedicationForm());
    }
}
