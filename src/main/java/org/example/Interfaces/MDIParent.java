package org.example.Interfaces;

import com.itextpdf.commons.actions.data.ProductData;
import com.sun.jdi.connect.spi.Connection;
import org.example.Model.DB_connection;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MDIParent extends javax.swing.JFrame {

    public static DB_connection db_connection = new DB_connection();
    public MDIParent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new JMenuItem();
        jMenuItem7 = new JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        JLabel jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );

        jMenu1.setText("Gerer");
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Produit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem1ActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem3ActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jMenu1.add(jMenuItem1);
        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Client");
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem2ActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jMenu1.add(jMenuItem2);
        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Stock");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Depot");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Livraison");
        jMenu1.add(jMenuItem5);

        jMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jMenuItem5ActionPerformed(e);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Commande");
        jMenu1.add(jMenuItem6);
        jMenuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jMenuItem6ActionPerformed(e);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jMenuBar1.add(jMenu1);
        jMenu2.setText("Account");
        jMenu2.add(jMenuItem7);
        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);
        jMenuItem7.setText("Detail");

        jMenuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jMenuItem7ActionPerformed(e);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1)
        );

        jLabel1.setBackground(Color.getColor("yellow"));
        jLabel1.setSize(getSize());
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\oussa\\Documents\\Dev\\Java\\Gestion_entreprise_project\\src\\main\\java\\org\\example\\Interfaces\\Images\\BG.png")); // NOI18N

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //own functions
    }// </editor-fold>

    private void jMenuItem3ActionPerformed(ActionEvent evt) throws SQLException {
        Stock_interface stockInterface = new Stock_interface();
        stockInterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);
            }
        });
        stockInterface.setVisible(true);
        jDesktopPane1.add(stockInterface);

        lock_unlock_menu(true);
    }

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
        // TODO add your handling code here:

    }

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        Product_interface productInterface = new Product_interface();
        productInterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);
            }
        });
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension frameSize = productInterface.getSize();

        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;

        productInterface.setLocation(x, y);
        productInterface.setVisible(true);
        jDesktopPane1.add(productInterface);
        productInterface.toFront();

        lock_unlock_menu(true);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:

        Client_interface clientInterface = new Client_interface();
        clientInterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);

            }
        });
        clientInterface.setVisible(true);
        jDesktopPane1.add(clientInterface);
        clientInterface.toFront();


        lock_unlock_menu(true);

    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        Livraison_interface livraisonInterface = new Livraison_interface();
        livraisonInterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);
            }
        });

        livraisonInterface.setVisible(true);
        jDesktopPane1.add(livraisonInterface);
        livraisonInterface.toFront();

        lock_unlock_menu(true);
    }
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        Commande_Interface commandeInterface = new Commande_Interface();
        commandeInterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);

            }
        });
        commandeInterface.setVisible(true);
        jDesktopPane1.add(commandeInterface);
        commandeInterface.toFront();

        lock_unlock_menu(true);
    }
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        UserInterface userinterface = new UserInterface();
        userinterface.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                lock_unlock_menu(false);
            }
        });
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension frameSize = userinterface.getSize();

        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;

        userinterface.setLocation(x, y);
        userinterface.setVisible(true);
        jDesktopPane1.add(userinterface);
        userinterface.toFront();


        lock_unlock_menu(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIParent().setVisible(true);

            }
        });
    }

    public static void lock_unlock_menu(boolean wo){
        jMenuItem1.setEnabled(!wo);
        jMenuItem2.setEnabled(!wo);
        jMenuItem3.setEnabled(!wo);
        jMenuItem4.setEnabled(!wo);
        jMenuItem5.setEnabled(!wo);
        jMenuItem6.setEnabled(!wo);
    }

    // Variables declaration - do not modify
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem1;
    private static javax.swing.JMenuItem jMenuItem2;
    private static javax.swing.JMenuItem jMenuItem3;
    private static javax.swing.JMenuItem jMenuItem4;
    private static javax.swing.JMenuItem jMenuItem5;
    private static javax.swing.JMenuItem jMenuItem6;
    private static javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration
}


