package org.example.Interfaces;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.awt.*;

/*
 * InternalFrameDemo.java requires:
 *   InternalFrameDemo.java
 */
public class InternalFrameDemo extends JFrame{
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setLayout(null);
        jf.setSize(1280, 720);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JInternalFrame jInternalFrame=new JInternalFrame();
        jInternalFrame.setLocation(100, 100);
        jInternalFrame.setSize(500, 300);
        jInternalFrame.setTitle("Internal frame");
        jInternalFrame.setVisible(true);
        jInternalFrame.setClosable(true);
        jInternalFrame.setResizable(true);
        jf.add(jInternalFrame);
        jf.repaint();
    }
}