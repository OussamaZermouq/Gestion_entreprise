package org.example.Interfaces;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TESTINTERFACE {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Multi-Selection JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Create an array of items for the JList
        String[] items = {"Option A", "Option B", "Option C", "Option D", "Option E"};

        // Create a JList with multiple selection support
        JList<String> multiSelectionList = new JList<>(items);
        multiSelectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add a ListSelectionListener to handle selection events
        multiSelectionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Handle the selection change
                Object[] selectedValues = multiSelectionList.getSelectedValues();
                System.out.println(selectedValues[0]);
            }
        });

        // Set a layout for the panel
        panel.setLayout(new BorderLayout());

        // Add the JList to the panel
        panel.add(new JScrollPane(multiSelectionList), BorderLayout.CENTER);

        frame.add(panel);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
