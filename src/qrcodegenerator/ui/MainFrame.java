/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import qrcodegenerator.entity.User;
import qrcodegenerator.utils.IconProgram;

/**
 *
 * @author Rizaldi Habibie
 */
public class MainFrame extends javax.swing.JFrame {
private ShowUserPage showUser ;
private AddUser addUser;
private AreaPage areaPage;
private GeneratePage generatePage;
private ShowQRCodeData showQRCodeData;
private User user;
private IconProgram iconProgram;
private AreaView areaView;
    /**
     * Creates new form MainFrame
     */
    public MainFrame(User user) {
       initComponents();
       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       SwingUtilities.updateComponentTreeUI(this);
       iconProgram = new IconProgram();
       iconProgram.setIcon(this, null);
       this.user = user;
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       Dimension frameSize = getSize();
       setLocation(
       (screenSize.width - frameSize.width) / 2,
       (screenSize.height - frameSize.height) / 2);
//        
    }

    public AreaView getAreaView() {
        return areaView;
    }

    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }

    public ShowUserPage getShowUser() {
        return showUser;
    }

    public void setShowUser(ShowUserPage showUser) {
        this.showUser = showUser;
    }

    public AddUser getAddUser() {
        return addUser;
    }

    public void setAddUser(AddUser addUser) {
        this.addUser = addUser;
    }

    public AreaPage getAreaPage() {
        return areaPage;
    }

    public void setAreaPage(AreaPage areaPage) {
        this.areaPage = areaPage;
    }

    public GeneratePage getGeneratePage() {
        return generatePage;
    }

    public void setGeneratePage(GeneratePage generatePage) {
        this.generatePage = generatePage;
    }

    public ShowQRCodeData getShowQRCodeData() {
        return showQRCodeData;
    }

    public void setShowQRCodeData(ShowQRCodeData showQRCodeData) {
        this.showQRCodeData = showQRCodeData;
    }

    public JButton getAreaButton() {
        return areaButton;
    }

    public void setAreaButton(JButton areaButton) {
        this.areaButton = areaButton;
    }

    public JDesktopPane getDesktopPane1() {
        return desktopPane1;
    }

    public void setDesktopPane1(JDesktopPane desktopPane1) {
        this.desktopPane1 = desktopPane1;
    }

    public JDesktopPane getDesktopPane2() {
        return desktopPane2;
    }

    public void setDesktopPane2(JDesktopPane desktopPane2) {
        this.desktopPane2 = desktopPane2;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(JButton generateButton) {
        this.generateButton = generateButton;
    }

    public JButton getShowQRCodeButton() {
        return showQRCodeButton;
    }

    public void setShowQRCodeButton(JButton showQRCodeButton) {
        this.showQRCodeButton = showQRCodeButton;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getAreaItem() {
        return areaItem;
    }

    public void setAreaItem(JMenuItem areaItem) {
        this.areaItem = areaItem;
    }

    public JMenuItem getGenerateItem() {
        return generateItem;
    }

    public void setGenerateItem(JMenuItem generateItem) {
        this.generateItem = generateItem;
    }

    public JMenuItem getShowItem() {
        return showItem;
    }

    public void setShowItem(JMenuItem showItem) {
        this.showItem = showItem;
    }

    public JMenuItem getUserItem() {
        return userItem;
    }

    public void setUserItem(JMenuItem userItem) {
        this.userItem = userItem;
    }

   

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        areaButton = new javax.swing.JButton();
        showQRCodeButton = new javax.swing.JButton();
        desktopPane1 = new javax.swing.JDesktopPane();
        desktopPane2 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenuBar = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        areaItem = new javax.swing.JMenuItem();
        generateItem = new javax.swing.JMenuItem();
        showItem = new javax.swing.JMenuItem();
        userItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QR CODE GENERATOR - PNP");
        setMinimumSize(new java.awt.Dimension(916, 480));
        setPreferredSize(new java.awt.Dimension(916, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(166, 390));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(150, 75));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/images/logo pnp small.PNG"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 52, 17, 67);
        jPanel6.add(jLabel1, gridBagConstraints);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Side Bar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel7.setLayout(new java.awt.GridBagLayout());

        generateButton.setBackground(new java.awt.Color(102, 102, 102));
        generateButton.setText("Generate QRCode");
        generateButton.setMaximumSize(new java.awt.Dimension(150, 23));
        generateButton.setMinimumSize(new java.awt.Dimension(150, 23));
        generateButton.setPreferredSize(new java.awt.Dimension(150, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 8, 0, 8);
        jPanel7.add(generateButton, gridBagConstraints);

        areaButton.setBackground(new java.awt.Color(102, 102, 102));
        areaButton.setText("Area");
        areaButton.setMaximumSize(new java.awt.Dimension(150, 23));
        areaButton.setMinimumSize(new java.awt.Dimension(150, 23));
        areaButton.setPreferredSize(new java.awt.Dimension(150, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 314, 8);
        jPanel7.add(areaButton, gridBagConstraints);

        showQRCodeButton.setBackground(new java.awt.Color(102, 102, 102));
        showQRCodeButton.setText("Lihat Data QRCode");
        showQRCodeButton.setMaximumSize(new java.awt.Dimension(150, 23));
        showQRCodeButton.setMinimumSize(new java.awt.Dimension(150, 23));
        showQRCodeButton.setPreferredSize(new java.awt.Dimension(150, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 8);
        jPanel7.add(showQRCodeButton, gridBagConstraints);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        desktopPane1.setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().add(desktopPane1, java.awt.BorderLayout.CENTER);

        desktopPane2.setPreferredSize(new java.awt.Dimension(325, 300));
        getContentPane().add(desktopPane2, java.awt.BorderLayout.EAST);

        FileMenuBar.setText("File");
        FileMenuBar.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Keluar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        FileMenuBar.add(jMenuItem1);

        jMenuBar1.add(FileMenuBar);

        jMenu2.setText("Menu");

        areaItem.setText("AREA");
        jMenu2.add(areaItem);

        generateItem.setText("GENERATE QRCODE");
        jMenu2.add(generateItem);

        showItem.setText("LIHAT DATA QRCODE");
        jMenu2.add(showItem);

        userItem.setText("MANAGE USER");
        userItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userItemActionPerformed(evt);
            }
        });
        jMenu2.add(userItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userItemActionPerformed
        if(showQRCodeData != null){
          this.getContentPane().remove(showQRCodeData);
          this.getContentPane().add(desktopPane1, java.awt.BorderLayout.CENTER);
          this.getContentPane().add(desktopPane2, java.awt.BorderLayout.EAST);
          this.getContentPane().repaint();
          this.pack();  
        }
        showUserPage();
    }//GEN-LAST:event_userItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    public void showUserPage(){
        showUser = new ShowUserPage();
        addUser = new AddUser(showUser);
        showUser.setAddUser(addUser);
        desktopPane1.removeAll();
        desktopPane1.add(addUser);
        addUser.setBounds(0,0, 410, 335);
        addUser.setSize(desktopPane1.getSize());
        addUser.setVisible(true);
        
        desktopPane2.removeAll();
        desktopPane2.add(showUser);
        showUser.setBounds(0,0, 410, 335);
        showUser.setSize(desktopPane2.getSize());
        showUser.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FileMenuBar;
    private javax.swing.JButton areaButton;
    private javax.swing.JMenuItem areaItem;
    private javax.swing.JDesktopPane desktopPane1;
    private javax.swing.JDesktopPane desktopPane2;
    private javax.swing.JButton generateButton;
    private javax.swing.JMenuItem generateItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem showItem;
    private javax.swing.JButton showQRCodeButton;
    private javax.swing.JMenuItem userItem;
    // End of variables declaration//GEN-END:variables
}
