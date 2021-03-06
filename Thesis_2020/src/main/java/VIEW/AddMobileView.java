
package VIEW;

import CONTROLLER.AddProductCon;
import CONTROLLER.ShowProductCon;
import MODEL.Mobile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AddMobileView extends javax.swing.JFrame {

    /**
     * Creates new form AddMobbileView1
     */
    public AddMobileView() {
        initComponents();
        //display on the center of the screen
        this.setLocationRelativeTo(null);
        //list of the models of the mobile
        List<String> items=new ArrayList<String>();
        //get the list of the models from the database
        items = mobile.getListaMob("Mobile");
        if(items.isEmpty())
            //message that the list is empty
            JOptionPane.showMessageDialog(null,"No list of models have found!Please try again! ");
        //the first element of the list
        items.add(0, "MODELS...");
        //copy the list to the combo box
        for(String a:items)
            jComboBoxModelMobile.addItem(a);
    }
    
    //instances of Controllers for the call of their methods
    AddProductCon updateItem=new AddProductCon();
    ShowProductCon mobile=new ShowProductCon();
    //the choice of the ComboBox
    private String jboxmodelChoice=null;
    private String jboxmodel=null;
    private String marka=null;
    //the model and the brand of the product
    private String modelT=null;
    private String brandT=null;
    //initialization of the variable for the control of the ComboBox
    private boolean empty=false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonAddItem = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jTextModel = new javax.swing.JTextField();
        jTextBrand = new javax.swing.JTextField();
        jTextScreen = new javax.swing.JTextField();
        jTextRam = new javax.swing.JTextField();
        jTextCpu = new javax.swing.JTextField();
        jTextMemory = new javax.swing.JTextField();
        jTextBattery = new javax.swing.JTextField();
        jTextOs = new javax.swing.JTextField();
        jTextYear = new javax.swing.JTextField();
        jTextPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextQuantity = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxModelMobile = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD MOBILE ITEM");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel1.setText("CPU*:");

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel2.setText("Ram*:");

        jLabel5.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel5.setText("Year*:");

        jLabel6.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel6.setText("Screen*:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel7.setText("OS*:");

        jLabel9.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel9.setText("BATTERY*:");

        jLabel10.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel10.setText("Memory*:");

        jLabel11.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel11.setText("Price*:");

        jLabel12.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel12.setText("Brand*:");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("MOBILE");

        jButtonAddItem.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAddItem.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButtonAddItem.setText("ADD");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(255, 255, 51));
        jButtonReset.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jTextModel.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jTextBrand.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jTextScreen.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextScreen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextScreenKeyTyped(evt);
            }
        });

        jTextRam.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextRam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRamKeyTyped(evt);
            }
        });

        jTextCpu.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jTextMemory.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextMemory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMemoryKeyTyped(evt);
            }
        });

        jTextBattery.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextBattery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBatteryKeyTyped(evt);
            }
        });

        jTextOs.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N

        jTextYear.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextYearKeyTyped(evt);
            }
        });

        jTextPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPriceKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel4.setText("* required fields for add item ");

        jLabel14.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel14.setText("Quantity**:");

        jTextQuantity.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQuantityKeyTyped(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 0, 51));
        jButtonDelete.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel15.setText("** required fields for add and delete item  ");

        jComboBoxModelMobile.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jComboBoxModelMobile.setToolTipText("");
        jComboBoxModelMobile.setAutoscrolls(true);
        jComboBoxModelMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModelMobileActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel16.setText("Brand & model**:");

        jLabel17.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel17.setText("Or write model*:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextModel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxModelMobile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextRam))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCpu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMemory))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextBattery))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextOs))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextYear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextQuantity)
                            .addComponent(jTextPrice)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModelMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextModel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBattery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonAddItem))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPriceKeyTyped
        //check if the input of the user is a digit or (.) for the decimals
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='.')||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit or decimal point(.)");
            evt.consume();
        }
    }//GEN-LAST:event_jTextPriceKeyTyped

    private void jTextYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextYearKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextYearKeyTyped

    private void jTextScreenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextScreenKeyTyped
        //check if the input of the user is a digit or (.) for the decimals
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='.')||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit or decimal point(.)");
            evt.consume();
        }
    }//GEN-LAST:event_jTextScreenKeyTyped

    private void jTextRamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRamKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextRamKeyTyped

    private void jTextMemoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMemoryKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextMemoryKeyTyped

    private void jTextBatteryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBatteryKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextBatteryKeyTyped

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        //reset all the fields
        jTextModel.setText(null);
        jTextBrand.setText(null);
        jTextScreen.setText(null);
        jTextRam.setText(null);
        jTextCpu.setText(null);
        jTextBattery.setText(null);
        jTextOs.setText(null);
        jTextYear.setText(null);
        jTextPrice.setText(null);
        jTextMemory.setText(null);
        jTextQuantity.setText(null);
        empty=false;
        modelT=null;
        marka=null;
    }//GEN-LAST:event_jButtonResetActionPerformed
//add a model
    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        //if the model is already in the database(some fields are null)
        if(jTextModel.getText().isEmpty())
        {
            empty=true;
            //get the choice of the combo box
            jComboBoxModelMobileActionPerformed(evt);
            //the model and the brand
            modelT=jboxmodel;
            brandT=marka;
            //the quantity from the input
            String quantityT=jTextQuantity.getText();
            //if the field quantity is null
            if(jTextQuantity.getText().isEmpty())
                JOptionPane.showMessageDialog(null,"please fill the quantity");
            else
            {
                //find the model from the database
                Mobile mob=(Mobile) mobile.getChoosenModelTel(modelT, "Mobile");
                //inform the user the quantity of the model and ask if he/she wants to continue
                int reply = JOptionPane.showConfirmDialog(this,"The item(s) of this model are "+mob.getQuantity()
                        +"\n"+"Do you want to continue?","Confirmation",  JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) 
                {
                    //update the quantity of the model in the database
                    if(updateItem.updateAddMobileCon(modelT,quantityT))
                    {
                        JOptionPane.showMessageDialog(null,"The item has been added in the database");
                    }
                    else 
                        JOptionPane.showMessageDialog(null,"The item has not been added in the database. Please try again!");
                }
                else 
                {
                    JOptionPane.showMessageDialog(this, "Please try again!");
                }
                
            }
        } 
        //if it is a new entry in the database
        else
        {
            //save all the inputs of the user
            modelT=jTextModel.getText();
            brandT=jTextBrand.getText();
            String screenT=jTextScreen.getText();
            String memoryT=jTextMemory.getText();
            String ramT=jTextRam.getText();
            String batteryT=jTextBattery.getText();
            String yearT=jTextYear.getText();
            String priceT=jTextPrice.getText();
            String osT=jTextOs.getText();
            String cpuT=jTextCpu.getText();
            String quantityT=jTextQuantity.getText();
            //check if all the fields are filled
            boolean emptyError = updateItem.nullMessageMob(modelT, brandT, memoryT, priceT, screenT, batteryT, ramT, yearT, osT, cpuT,quantityT);
            if(emptyError)
                JOptionPane.showMessageDialog(null,"please fill in all the required fields");
            else
            {
                //update the database with the new model 
                if(updateItem.addMobileCon(modelT, brandT, memoryT, priceT, screenT, batteryT, ramT, yearT, osT, cpuT,quantityT))
                {
                    JOptionPane.showMessageDialog(null,"The item has been added in the database");
                }
                else
                    JOptionPane.showMessageDialog(null,"The item has not been added in the database. Please try again!");
            }
        }
        //reset the fields
        jButtonResetActionPerformed(evt);
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jTextQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQuantityKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextQuantityKeyTyped
    //delete a model
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        empty=true;
        //get the choice of the combo box
        jComboBoxModelMobileActionPerformed(evt);
        //get the model and the quantity inputs
        modelT=jboxmodel;
        String quantityT=jTextQuantity.getText();
        //find the model from the database
        Mobile mob=(Mobile) mobile.getChoosenModelTel(modelT, "Mobile");
        //inform the user the quantity of the model and ask if he/she wants to continue
        int reply = JOptionPane.showConfirmDialog(this,"The item(s) of this model are "+mob.getQuantity()
                +"\n"+"Do you want to continue?","Confirmation",  JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) 
        {
            //update the quantity of the model in the database
            if(updateItem.updateMobileCon(modelT, quantityT))
            {
                JOptionPane.showMessageDialog(this, "the database has been updated");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "the model has not been found or there are not so many item(s) of it.Please try again!");
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Please try again!");
        }
        //reset the fields
        jButtonResetActionPerformed(evt);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxModelMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModelMobileActionPerformed
        if(empty)
        {
            //the choice of the user from the combo box
            jboxmodelChoice=jComboBoxModelMobile.getSelectedItem().toString();
            //if the user haven t choose a model
            if(jboxmodelChoice=="MODELS...")
            {
                //display a message to choose a model
                JOptionPane.showMessageDialog(null,"Please choose a model");
                jboxmodelChoice=null;
                //reset the fields
                jButtonResetActionPerformed(evt);
            }
            else
            {
                //separate the string,first is the brand second is the model
                String[] s=jboxmodelChoice.split(":");
                marka=s[0];
                jboxmodel=s[1];
            }
        }
    }//GEN-LAST:event_jComboBoxModelMobileActionPerformed

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
            java.util.logging.Logger.getLogger(AddMobileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMobileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMobileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMobileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMobileView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox<String> jComboBoxModelMobile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBattery;
    private javax.swing.JTextField jTextBrand;
    private javax.swing.JTextField jTextCpu;
    private javax.swing.JTextField jTextMemory;
    private javax.swing.JTextField jTextModel;
    private javax.swing.JTextField jTextOs;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextQuantity;
    private javax.swing.JTextField jTextRam;
    private javax.swing.JTextField jTextScreen;
    private javax.swing.JTextField jTextYear;
    // End of variables declaration//GEN-END:variables
}
