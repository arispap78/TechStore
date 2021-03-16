
package VIEW;

public class UpdateStockView extends javax.swing.JFrame {

    /**
     * Creates new form AddItem
     */
    public UpdateStockView() {
        initComponents();
        //display on the center of the screen
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAddTelevision = new javax.swing.JButton();
        jButtonAddLaptop = new javax.swing.JButton();
        jButtonAddCamera = new javax.swing.JButton();
        jButtonAddMobile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UPDATE STOCK");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jButtonAddTelevision.setBackground(new java.awt.Color(0, 204, 204));
        jButtonAddTelevision.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jButtonAddTelevision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-tv-48.png"))); // NOI18N
        jButtonAddTelevision.setText("TELEVISION");
        jButtonAddTelevision.setToolTipText("");
        jButtonAddTelevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTelevisionActionPerformed(evt);
            }
        });

        jButtonAddLaptop.setBackground(new java.awt.Color(0, 204, 204));
        jButtonAddLaptop.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jButtonAddLaptop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-laptop-48.png"))); // NOI18N
        jButtonAddLaptop.setText("LAPTOP");
        jButtonAddLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLaptopActionPerformed(evt);
            }
        });

        jButtonAddCamera.setBackground(new java.awt.Color(0, 204, 204));
        jButtonAddCamera.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jButtonAddCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-camera-48.png"))); // NOI18N
        jButtonAddCamera.setText("CAMERA");
        jButtonAddCamera.setToolTipText("");
        jButtonAddCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCameraActionPerformed(evt);
            }
        });

        jButtonAddMobile.setBackground(new java.awt.Color(0, 204, 204));
        jButtonAddMobile.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jButtonAddMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-mobile-48.png"))); // NOI18N
        jButtonAddMobile.setText("MOBILE");
        jButtonAddMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMobileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddTelevision, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonAddTelevision, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonAddLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonAddCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonAddMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //display the windows of the user's choice 
    private void jButtonAddTelevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTelevisionActionPerformed
        new AddTelevisionView().setVisible(true);
    }//GEN-LAST:event_jButtonAddTelevisionActionPerformed

    private void jButtonAddLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLaptopActionPerformed
        new AddLaptopView().setVisible(true);
    }//GEN-LAST:event_jButtonAddLaptopActionPerformed

    private void jButtonAddCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCameraActionPerformed
        new AddCameraView().setVisible(true);
    }//GEN-LAST:event_jButtonAddCameraActionPerformed

    private void jButtonAddMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMobileActionPerformed
        new AddMobileView().setVisible(true);
    }//GEN-LAST:event_jButtonAddMobileActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStockView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCamera;
    private javax.swing.JButton jButtonAddLaptop;
    private javax.swing.JButton jButtonAddMobile;
    private javax.swing.JButton jButtonAddTelevision;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
