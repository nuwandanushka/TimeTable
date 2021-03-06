/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import SmartNurse.UserPrivilege.User;
import javax.swing.JOptionPane;

/**
 *

import SmartNurse.User;
 * @author nuwan_rates
 */
public class LoginInterface extends javax.swing.JFrame {

    /**
     * Creates new form LoginInterface
     */
    public LoginInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginSubmit = new javax.swing.JButton();
        loginCancle = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        uname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LClose = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(982, 332));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginSubmit.setText("Submit");
        loginSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(loginSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        loginCancle.setText("Cancle");
        loginCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginCancleActionPerformed(evt);
            }
        });
        getContentPane().add(loginCancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 210, -1));
        getContentPane().add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 210, -1));

        jLabel4.setText("User Name :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel5.setText("Password :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        LClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\nuwan_rates\\Dropbox\\Smart Nurse Project\\images\\Login\\close button.png")); // NOI18N
        LClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LCloseMouseClicked(evt);
            }
        });
        getContentPane().add(LClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 50, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\nuwan_rates\\Dropbox\\Smart Nurse Project\\images\\Login\\Login.jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 330));

        setSize(new java.awt.Dimension(982, 332));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_LCloseMouseClicked

    private void loginSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginSubmitActionPerformed
        if(!uname.getText().equals("") && !password.getText().equals("")){
            User user=new User();
            user.validation(uname.getText(), password.getText());
            
        }
        else{
            
            JOptionPane.showMessageDialog(null, "You have to fill both field", "Error" + "", JOptionPane.ERROR_MESSAGE);
            
        
        }
        
    }//GEN-LAST:event_loginSubmitActionPerformed

    private void loginCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginCancleActionPerformed
       uname.setText("");
       password.setText("");
    }//GEN-LAST:event_loginCancleActionPerformed

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
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LClose;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginCancle;
    private javax.swing.JButton loginSubmit;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
