package views;

import controllers.PharmacyController;

import javax.swing.JFrame;

public final class Desktop {

    public static JFrame getMedicationForm() {
        JFrame frame = new JFrame("Nuevo pedido - Farmacia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MedicationForm());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }

    public static JFrame getTicket(String name, PharmacyController controller) {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new Ticket(controller, frame));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }
}
