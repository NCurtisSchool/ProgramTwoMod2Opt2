/*
Name: Nathan Curtis
Date: 10/20/2024
Class: Computer Programming II 24FD-CSC372-1
Teacher: Luis Gonzalez
Assignment Name: GUI age calculator
GitHub: https://github.com/NCurtisSchool/ProgramTwoMod2Opt2.git
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class ageCalc {
    public static void main(String[] args) {
        // Set up frame
        JFrame frame = new JFrame("Age Calculator");
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program on window close
        frame.setLayout(null); // Allows manual layout
        frame.setVisible(true);

        // Set up Upper Panel
        JPanel panelResults = new JPanel(); // Top pannel. Shows results
        panelResults.setBounds(0, 0, 750, 375); // Manual placment into frame
        frame.add(panelResults);

        // Set up Lower Panel
        JPanel panelInputs = new JPanel(); // Lower pannel. Input user age.
        panelInputs.setBounds(0, 376, 750, 375); // Manual placment into frame
        frame.add(panelInputs);

        // Lower panel label
        JLabel birthLabel = new JLabel("Year born (yyyy-MM-dd): ");
        birthLabel.setBounds(150, 188, 150,25); // xywidthheight
        panelInputs.add(birthLabel);

        // Lower panel input field for text
        JTextField birthText = new JTextField();
        birthText.setBounds(400, 188, 100, 25);
        panelInputs.add(birthText);

        // Upper panel text field for output
        JTextField outputText = new JTextField();
        outputText.setBounds(400, 188, 300, 25); // DO
        panelResults.add(outputText);

        // Upper panel button for calc
        JButton submitButton = new JButton("Calculate Age");
        submitButton.setBounds(150, 188, 150,25); // DO
        panelResults.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usersDate = birthText.getText();
                LocalDate today = LocalDate.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate usersDatePars = LocalDate.parse(usersDate, formatter);

                Period period = Period.between(usersDatePars, today);

                String outputString = "You were born " + period.getYears() + " years, " + period.getMonths() + " months, and " + period.getDays() + " days ago.";

                outputText.setText(outputString);
            }
        });
    }
}