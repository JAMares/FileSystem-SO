/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package so.filesystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aozhen
 */
public class FileSystemApp extends javax.swing.JFrame {
    public FileSystem fs;

    /**
     * Creates new form FileSystemApp
     */
    public FileSystemApp() {
        initComponents();
    }
    
    public void test(){
        this.fs = new FileSystem();
        try {
            this.fs.createVD(10, 10);
        } catch (IOException ex) {
            Logger.getLogger(FileSystemApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refreshView(){
        ArrayList<Directory> dirs = this.fs.getCurrent().getDirectories();
        ArrayList<Files> fils = this.fs.getCurrent().getFiles();
        DefaultListModel listModel = (DefaultListModel) this.jList1.getModel();
        listModel.removeAllElements();
        for(Directory dir : dirs){
            listModel.addElement(dir.getName());
        }
        for(Files fil : fils){
            listModel.addElement(fil.getName()+fil.getExtent());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dirInputDialog = new javax.swing.JDialog();
        dirTextInput = new javax.swing.JTextField();
        dirInputButtonOk = new javax.swing.JButton();
        dirInputButtonCancel = new javax.swing.JButton();
        fileInputDialog = new javax.swing.JDialog();
        fileNameInput = new javax.swing.JTextField();
        fileButtonOk = new javax.swing.JButton();
        fileButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileContentInput = new javax.swing.JTextField();
        fileExtensionInput = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();

        dirInputDialog.setTitle("Input directory name:");
        dirInputDialog.setAlwaysOnTop(true);
        dirInputDialog.setBounds(new java.awt.Rectangle(10, 10, 400, 300));

        dirInputButtonOk.setText("OK");
        dirInputButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirInputButtonOkActionPerformed(evt);
            }
        });

        dirInputButtonCancel.setText("Cancel");
        dirInputButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirInputButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dirInputDialogLayout = new javax.swing.GroupLayout(dirInputDialog.getContentPane());
        dirInputDialog.getContentPane().setLayout(dirInputDialogLayout);
        dirInputDialogLayout.setHorizontalGroup(
            dirInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dirInputDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(dirInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(dirInputDialogLayout.createSequentialGroup()
                        .addComponent(dirInputButtonOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dirInputButtonCancel))
                    .addComponent(dirTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        dirInputDialogLayout.setVerticalGroup(
            dirInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dirInputDialogLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(dirTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dirInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dirInputButtonOk)
                    .addComponent(dirInputButtonCancel))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        fileInputDialog.setTitle("Input directory name:");
        fileInputDialog.setAlwaysOnTop(true);
        fileInputDialog.setBounds(new java.awt.Rectangle(10, 10, 400, 300));

        fileButtonOk.setText("OK");
        fileButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonOkActionPerformed(evt);
            }
        });

        fileButtonCancel.setText("Cancel");
        fileButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Content");

        fileContentInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileContentInputActionPerformed(evt);
            }
        });

        fileExtensionInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".txt", ".docx", ".doc", ".bin" }));

        jLabel3.setText("Extension");

        javax.swing.GroupLayout fileInputDialogLayout = new javax.swing.GroupLayout(fileInputDialog.getContentPane());
        fileInputDialog.getContentPane().setLayout(fileInputDialogLayout);
        fileInputDialogLayout.setHorizontalGroup(
            fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileInputDialogLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fileInputDialogLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileInputDialogLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(fileButtonCancel)))
                    .addGroup(fileInputDialogLayout.createSequentialGroup()
                        .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileButtonOk)
                            .addComponent(fileContentInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileExtensionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        fileInputDialogLayout.setVerticalGroup(
            fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileInputDialogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileContentInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileExtensionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(fileInputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileButtonOk)
                    .addComponent(fileButtonCancel))
                .addGap(66, 66, 66))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(jTree1);

        jButton1.setText("Open");

        jButton2.setText("Delete");

        jTextField1.setEditable(false);
        jTextField1.setText("pathTextField");
        jTextField1.setAlignmentX(0.0F);
        jTextField1.setAlignmentY(0.0F);

        jButton3.setText("New File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.DefaultListModel()
        );
        jScrollPane1.setViewportView(jList1);

        jButton4.setText("New Dir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dirTextInput.setText("");
        this.dirInputDialog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dirInputButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirInputButtonOkActionPerformed
        // TODO add your handling code here:
        this.fs.createDirectory(this.dirTextInput.getText());
        this.refreshView();
        this.dirInputDialog.setVisible(false);
        
        
    }//GEN-LAST:event_dirInputButtonOkActionPerformed

    private void dirInputButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirInputButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dirTextInput.setText("");
        this.dirInputDialog.setVisible(false);
    }//GEN-LAST:event_dirInputButtonCancelActionPerformed

    private void fileButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonOkActionPerformed
        // TODO add your handling code here:
        this.fs.createFile(this.fileNameInput.getText(), this.fileExtensionInput.getSelectedItem().toString(), this.fileContentInput.getText());
        this.fileInputDialog.setVisible(false);
        this.refreshView();
    }//GEN-LAST:event_fileButtonOkActionPerformed

    private void fileButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileButtonCancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.fileNameInput.setText("");
        this.fileContentInput.setText("");
        this.fileInputDialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fileContentInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileContentInputActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fileContentInputActionPerformed

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
            java.util.logging.Logger.getLogger(FileSystemApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileSystemApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileSystemApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileSystemApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileSystemApp fsa = new FileSystemApp();
                fsa.test();
                fsa.refreshView();
                fsa.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dirInputButtonCancel;
    private javax.swing.JButton dirInputButtonOk;
    private javax.swing.JDialog dirInputDialog;
    private javax.swing.JTextField dirTextInput;
    private javax.swing.JButton fileButtonCancel;
    private javax.swing.JButton fileButtonOk;
    private javax.swing.JTextField fileContentInput;
    private javax.swing.JComboBox<String> fileExtensionInput;
    private javax.swing.JDialog fileInputDialog;
    private javax.swing.JTextField fileNameInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
