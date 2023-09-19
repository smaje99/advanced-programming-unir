package views;

import controllers.PharmacyController;
import utils.Constrains;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticket extends JPanel implements ActionListener {
    private PharmacyController controller;
    private JButton cancelButton;
    private JButton sendButton;
    private JFrame frame;

    public Ticket(PharmacyController controller, JFrame frame) {
        super(new BorderLayout());
        this.controller = controller;
        this.frame = frame;

        initComponents();
    }

    private void initComponents() {
        cancelButton = new JButton("Cancelar");
        sendButton = new JButton("Enviar");

        cancelButton.addActionListener(this);
        sendButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2,  10, 0));
        buttonPanel.add(cancelButton);
        buttonPanel.add(sendButton);

        this.add(ticketPanel(), BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel ticketPanel() {
        JPanel ticketPanel = new JPanel(new GridBagLayout());
        ticketPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Farmacia");
        var fontTitleLabel = titleLabel.getFont();
        titleLabel.setFont(fontTitleLabel.deriveFont(fontTitleLabel.getSize() + 8f));
        titleLabel.setForeground(Color.BLACK);

        Constrains.addCompX(
                new Constrains.View(titleLabel, ticketPanel),
                new Rectangle(0, 0, 1, 1),
                1,
                new Insets(50, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        JSeparator titleSeparator = new JSeparator();

        Constrains.addCompX(
                new Constrains.View(titleSeparator, ticketPanel),
                new Rectangle(0, 1, 1, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        var distributor = controller.getMedication().getDistributor().getDistributor();
        var distributorMessage = "Pedido al distribuidor: " + distributor;
        JLabel distributorLabel = new JLabel(distributorMessage);

        Constrains.addCompX(
                new Constrains.View(distributorLabel, ticketPanel),
                new Rectangle(0, 2, 1, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        JSeparator titleSeparator2 = new JSeparator();

        Constrains.addCompX(
                new Constrains.View(titleSeparator2, ticketPanel),
                new Rectangle(0, 3, 1, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        var amount = controller.getMedication().getAmount();
        var type = controller.getMedication().getType().getType();
        var name = controller.getMedication().getName();
        var orderMessage = amount + " unidades del " + type + " " + name;
        JLabel orderLabel = new JLabel(orderMessage);

        Constrains.addCompX(
                new Constrains.View(orderLabel, ticketPanel),
                new Rectangle(0, 4, 1, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        var branches = controller.getMedication().getBranches();
        var locationMessage = "Para la farmacia situada en ";

        if (branches.length == 1) {
            locationMessage += branches[0].getAddress();
        } else if (branches.length == 2) {
            locationMessage += branches[0].getAddress() + " y para la situada en " + branches[1].getAddress();
        }

        JLabel locationLabel = new JLabel(locationMessage);

        Constrains.addCompX(
                new Constrains.View(locationLabel, ticketPanel),
                new Rectangle(0, 5, 1, 1),
                0.2,
                new Insets(5, 30, 50, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        return ticketPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            frame.dispose();
        }
        if (e.getSource() == sendButton) {
            controller.sendOrder();
            frame.dispose();
        }
    }
}
