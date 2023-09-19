package controllers;

import models.Medication;
import models.enums.Branch;
import models.enums.Distributor;
import models.enums.Type;
import models.objects.*;

import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.*;
import java.text.ParseException;

public final class PharmacyController {
    private Medication medication;

    public boolean createMedication(
            JTextField medicationNameTextField,
            JComboBox<Type> medicationTypeComboBox,
            JTextField medicationAmountTextField,
            JRadioButton medicationCofarmaDistributorRadioButton,
            JRadioButton medicationEmpsepharDistributorRadioButton,
            JRadioButton medicationCemefarDistributorRadioButton,
            JCheckBox medicationPrimaryBranchCheckBox,
            JCheckBox medicationSecondaryBranchCheckBox,
            JLabel medicationNameErrorLabel,
            JLabel medicationTypeErrorLabel,
            JLabel medicationAmountErrorLabel,
            JLabel medicationDistributorErrorLabel,
            JLabel medicationBranchErrorLabel
    ) {
        String name = null;
        Type type = null;
        int amount = 0;
        Distributor distributor = null;
        Branch[] branches = null;
        boolean error = false;

        try {
            name = medicationNameTextField.getText();

            MedicationName.ensureNameIsDefined(name);
            MedicationName.ensureNameIsAlphaNumeric(name);
        } catch (IllegalArgumentException e) {
            error = true;
            medicationNameErrorLabel.setText(e.getMessage());
            medicationNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        try {
            type = medicationTypeComboBox.getItemAt(medicationTypeComboBox.getSelectedIndex());

            MedicationType.ensureMedicationTypeIsDefined(type);
        } catch (IllegalArgumentException e) {
            error = true;
            medicationTypeErrorLabel.setText(e.getMessage());
            medicationTypeComboBox.setBorder(BorderFactory.createLineBorder(Color.RED));
        }


        try {
            amount = Integer.parseInt(medicationAmountTextField.getText());

            MedicationAmount.ensureAmountIsDefined(amount);
            MedicationAmount.ensureAmountIsGreaterThanZero(amount);
        } catch (NumberFormatException  e) {
            error = true;
            medicationAmountErrorLabel.setText("La cantidad debe ser un número entero");
            medicationAmountTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
        } catch (IllegalArgumentException e) {
            error = true;
            medicationAmountErrorLabel.setText(e.getMessage());
            medicationAmountTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        try {
            if (medicationCofarmaDistributorRadioButton.isSelected()) {
                distributor = Distributor.COFARMA;
            } else if (medicationEmpsepharDistributorRadioButton.isSelected()) {
                distributor = Distributor.EMPSEPHAR;
            } else if (medicationCemefarDistributorRadioButton.isSelected()) {
                distributor = Distributor.CEMEFAR;
            }

            MedicationDistributor.ensureDistributorIsDefined(distributor);
        } catch (IllegalArgumentException e) {
            error = true;
            medicationDistributorErrorLabel.setText(e.getMessage());
        }

        try {
            if (medicationPrimaryBranchCheckBox.isSelected() && medicationSecondaryBranchCheckBox.isSelected()) {
                branches = new Branch[]{Branch.PRIMARY, Branch.SECONDARY};
            } else if (medicationPrimaryBranchCheckBox.isSelected()) {
                branches = new Branch[]{Branch.PRIMARY};
            } else if (medicationSecondaryBranchCheckBox.isSelected()) {
                branches = new Branch[]{Branch.SECONDARY};
            }

            MedicationBranch.ensureBranchIsDefined(branches);
        } catch (IllegalArgumentException e) {
            error = true;
            medicationBranchErrorLabel.setText(e.getMessage());
        }

        if (!error) {
            medication = new Medication(name, type, amount, distributor, branches);
        }

        return !error;
    }
}
