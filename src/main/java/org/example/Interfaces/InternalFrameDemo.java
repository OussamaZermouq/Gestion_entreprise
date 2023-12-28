package org.example.Interfaces;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;

/*
 * InternalFrameDemo.java requires:
 *   InternalFrameDemo.java
 */
public class InternalFrameDemo extends JFrame{
    private final JDesktopPane desktopPane;

    public InternalFrameDemo() {
        setTitle("JInternalFrame Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create a menu item to open the internal frame
        JMenuItem openItem = new JMenuItem("Open Internal Frame");
        fileMenu.add(openItem);

        // Add action listener to the menu item
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInternalFrame();
            }
        });

        // Create a desktop pane to manage internal frames
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);
    }

    private void createInternalFrame() {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(300, 1000);
        internalFrame.setLocation(50, 50);

        // Add some content to the internal frame
        JLabel label = new JLabel("This is an internal frame");
        internalFrame.add(label);

        // Make the internal frame visible
        internalFrame.setVisible(true);

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InternalFrameDemo mainFrame = new InternalFrameDemo();
                mainFrame.setVisible(true);
            }
        });
    }
}