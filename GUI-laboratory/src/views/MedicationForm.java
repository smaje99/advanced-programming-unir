package views;

import controllers.PharmacyController;
import models.enums.Branch;
import models.enums.Distributor;
import models.enums.Type;
import utils.Constrains;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicationForm extends JPanel implements ActionListener {
    private JTextField medicationNameTextField;
    private JComboBox<Type> medicationTypeComboBox;
    private JTextField medicationAmountTextField;
    private JRadioButton medicationCofarmaDistributorRadioButton;
    private JRadioButton medicationEmpsepharDistributorRadioButton;
    private JRadioButton medicationCemefarDistributorRadioButton;
    private ButtonGroup medicationDistributorButtonGroup;
    private JCheckBox medicationPrimaryBranchCheckBox;
    private JCheckBox medicationSecondaryBranchCheckBox;
    private JLabel medicationNameErrorLabel;
    private JLabel medicationTypeErrorLabel;
    private JLabel medicationAmountErrorLabel;
    private JLabel medicationDistributorErrorLabel;
    private JLabel medicationBranchErrorLabel;
    private JButton cleanButton;
    private JButton submitButton;

    public MedicationForm() {
        super(new GridBagLayout());

        initComponents();
    }

    public void initComponents() {
        JLabel titleLabel = new JLabel("Nuevo Pedido");
        var fontTitleLabel = titleLabel.getFont();
        fontTitleLabel = fontTitleLabel.deriveFont(fontTitleLabel.getSize() + 10f);
        titleLabel.setFont(fontTitleLabel);

        Constrains.addCompX(
                new Constrains.View(titleLabel, this),
                new Rectangle(0, 0, 3, 1),
                1,
                new Insets(50, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );

        JSeparator titleSeparator = new JSeparator();

        Constrains.addCompX(
                new Constrains.View(titleSeparator, this),
                new Rectangle(0, 1, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL)
        );

        JLabel  medicationNameLabel = new JLabel("Nombre del medicamento");
        medicationNameTextField = new JTextField();
        medicationNameErrorLabel = new JLabel();
        medicationNameErrorLabel.setForeground(Color.RED);

        var dimension = medicationNameTextField.getSize();
        dimension.width = 500;
        medicationNameTextField.setSize(dimension);

        Constrains.addComp(
                new Constrains.View(medicationNameLabel, this),
                new Rectangle(0, 2, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new Constrains.View(medicationNameTextField, this),
                new Rectangle(0, 3, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new Constrains.View(medicationNameErrorLabel, this),
                new Rectangle(0, 4, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.BOTH)
        );

        JLabel medicationTypeLabel = new JLabel("Tipo del medicamento");
        medicationTypeComboBox = new JComboBox<>();
        medicationTypeErrorLabel = new JLabel();
        medicationTypeErrorLabel.setForeground(Color.RED);

        for (Type type : Type.values()) {
            medicationTypeComboBox.addItem(type);
        }
        medicationTypeComboBox.setSelectedIndex(-1);

        Constrains.addComp(
                new Constrains.View(medicationTypeLabel, this),
                new Rectangle(0, 5, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new Constrains.View(medicationTypeComboBox, this),
                new Rectangle(0, 6, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new Constrains.View(medicationTypeErrorLabel, this),
                new Rectangle(0, 7, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.BOTH)
        );

        JLabel medicationAmountLabel = new JLabel("Cantidad del medicamento");
        medicationAmountTextField = new JTextField();
        medicationAmountErrorLabel = new JLabel();
        medicationAmountErrorLabel.setForeground(Color.RED);

        Constrains.addComp(
                new Constrains.View(medicationAmountLabel, this),
                new Rectangle(0, 8, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new Constrains.View(medicationAmountTextField, this),
                new Rectangle(0, 9, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new Constrains.View(medicationAmountErrorLabel, this),
                new Rectangle(0, 10, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.BOTH)
        );

        JLabel medicationDistributorLabel = new JLabel("Distribuidor farmacéutico");
        medicationCofarmaDistributorRadioButton = new JRadioButton(Distributor.COFARMA.getDistributor());
        medicationEmpsepharDistributorRadioButton = new JRadioButton(Distributor.EMPSEPHAR.getDistributor());
        medicationCemefarDistributorRadioButton = new JRadioButton(Distributor.CEMEFAR.getDistributor());
        medicationDistributorErrorLabel = new JLabel();
        medicationDistributorErrorLabel.setForeground(Color.RED);

        medicationDistributorButtonGroup = new ButtonGroup();
        medicationDistributorButtonGroup.add(medicationCofarmaDistributorRadioButton);
        medicationDistributorButtonGroup.add(medicationEmpsepharDistributorRadioButton);
        medicationDistributorButtonGroup.add(medicationCemefarDistributorRadioButton);

        JPanel medicationDistributorRadioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        medicationDistributorRadioButtonPanel.add(medicationCofarmaDistributorRadioButton);
        medicationDistributorRadioButtonPanel.add(medicationEmpsepharDistributorRadioButton);
        medicationDistributorRadioButtonPanel.add(medicationCemefarDistributorRadioButton);

        Constrains.addComp(
                new Constrains.View(medicationDistributorLabel, this),
                new Rectangle(0, 11, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new Constrains.View(medicationDistributorRadioButtonPanel, this),
                new Rectangle(0, 12, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new Constrains.View(medicationDistributorErrorLabel, this),
                new Rectangle(0, 13, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.BOTH)
        );

        JLabel medicationBranchLabel = new JLabel("Sucursal farmacéutica");
        medicationPrimaryBranchCheckBox = new JCheckBox(Branch.PRIMARY.getBranch());
        medicationSecondaryBranchCheckBox = new JCheckBox(Branch.SECONDARY.getBranch());
        medicationBranchErrorLabel = new JLabel();
        medicationBranchErrorLabel.setForeground(Color.RED);

        JPanel medicationBranchCheckBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        medicationBranchCheckBoxPanel.add(medicationPrimaryBranchCheckBox);
        medicationBranchCheckBoxPanel.add(medicationSecondaryBranchCheckBox);

        Constrains.addComp(
                new Constrains.View(medicationBranchLabel, this),
                new Rectangle(0, 14, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new Constrains.View(medicationBranchCheckBoxPanel, this),
                new Rectangle(0, 15, 3, 1),
                1,
                new Insets(5, 30, 5, 30),
                new Point(GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new Constrains.View(medicationBranchErrorLabel, this),
                new Rectangle(0, 16, 3, 1),
                new Constrains.Weight(1, 1),
                new Insets(10, 30, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.BOTH)
        );


        cleanButton = new JButton("Borrar");
        submitButton = new JButton("Confirmar");

        cleanButton.addActionListener(this);
        submitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.add(cleanButton);
        buttonPanel.add(submitButton);

        Constrains.addCompX(
                new Constrains.View(buttonPanel, this),
                new Rectangle(0, 17, 3, 1),
                1,
                new Insets(20, 30, 50, 30),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL)
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cleanButton) {
            cleanInputComponents();
        }

        if (e.getSource() == submitButton) {
            submit();
        }
    }

    private void cleanInputComponents() {
        medicationNameTextField.setText("");
        medicationTypeComboBox.setSelectedIndex(-1);
        medicationAmountTextField.setText("");
        medicationDistributorButtonGroup.clearSelection();
        medicationPrimaryBranchCheckBox.setSelected(false);
        medicationSecondaryBranchCheckBox.setSelected(false);

        medicationNameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        medicationTypeComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        medicationAmountTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        medicationNameErrorLabel.setText("");
        medicationTypeErrorLabel.setText("");
        medicationAmountErrorLabel.setText("");
        medicationDistributorErrorLabel.setText("");
        medicationBranchErrorLabel.setText("");

        repaint();
    }

    private void submit() {
        PharmacyController pharmacyController = new PharmacyController();

        boolean isCreated = pharmacyController.createMedication(
                medicationNameTextField,
                medicationTypeComboBox,
                medicationAmountTextField,
                medicationCofarmaDistributorRadioButton,
                medicationEmpsepharDistributorRadioButton,
                medicationCemefarDistributorRadioButton,
                medicationPrimaryBranchCheckBox,
                medicationSecondaryBranchCheckBox,
                medicationNameErrorLabel,
                medicationTypeErrorLabel,
                medicationAmountErrorLabel,
                medicationDistributorErrorLabel,
                medicationBranchErrorLabel
        );


        if (isCreated) {
            repaint();

            var distributor = pharmacyController.getMedication().getDistributor().getDistributor();
            var ticketTitle = "Pedido al distribuidor " + distributor;
            Desktop.getTicket(ticketTitle, pharmacyController);

            cleanInputComponents();
        }
    }
}
