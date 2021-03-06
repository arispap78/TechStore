
package VIEW;

import CONTROLLER.StatisticCon;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StatisticsShowView extends javax.swing.JFrame {
    

    /**
     * Creates new form StatisticsView
     */
    public StatisticsShowView() {
        initComponents();
        //display on the center of the screen
        this.setLocationRelativeTo(null);
        //list of employees
        ArrayList<String> items=new ArrayList<String>();
        items = statistika.listaEmployeeStatistics();
        //if there is no employee
        if(items.isEmpty())
            JOptionPane.showMessageDialog(null,"No list of models have found!Please try again! ");
        //the first element of the list
        items.add(0, "EMPLOYEES...");
        //the list of employees for the combo box
        for(String a:items)
            jComboBoxModelEmployee.addItem(a);        
    }
    
    //variables for the dates
    private String yearFrom;
    private String dayFrom;
    private String monthFrom;
    private String dateFrom;
    private String yearUntil;
    private String dayUntil;
    private String monthUntil;
    private String dateUntil;
    //convert the string date to a Date object for the search in the database
    private Date datef;
    private Date dateu;
    //instance of the CONTROLLER for its methods
    StatisticCon statistika=new StatisticCon();
    //the list with the statistics
    ArrayList <Object[]> listaS=new ArrayList <Object[]>();
    //variables for combo box
    private String jboxmodelEmployee=null;
    boolean empty=false;
    //the attributes of the employee
    private String onoma=null;
    private String epitheto=null;
    private String id=null;
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextYearUntil = new javax.swing.JTextField();
        jTextMonthFrom = new javax.swing.JTextField();
        jTextDayFrom = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStatisticShow = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButtonSearchOrder = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextYearFrom = new javax.swing.JTextField();
        jTextMonthUntil = new javax.swing.JTextField();
        jTextDayUntil = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxModelEmployee = new javax.swing.JComboBox<>();
        jCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STATISTICS");

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setText("from*:");

        jTextYearUntil.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextYearUntil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextYearUntilKeyTyped(evt);
            }
        });

        jTextMonthFrom.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextMonthFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMonthFromKeyTyped(evt);
            }
        });

        jTextDayFrom.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextDayFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDayFromKeyTyped(evt);
            }
        });

        jTableStatisticShow.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jTableStatisticShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "TOTAL ITEMS", "AVERAGE PRICE", "MAXIMUM PRICE", "TOTAL PRICE"
            }
        ));
        jTableStatisticShow.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTableStatisticShow);
        jTableStatisticShow.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel7.setText("Employee:");

        jButtonSearchOrder.setBackground(new java.awt.Color(51, 51, 255));
        jButtonSearchOrder.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jButtonSearchOrder.setText("SEARCH");
        jButtonSearchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchOrderActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel6.setText("until*:");

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel8.setText("Year");

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel9.setText("Day");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel10.setText("Month");

        jTextYearFrom.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextYearFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextYearFromKeyTyped(evt);
            }
        });

        jTextMonthUntil.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextMonthUntil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMonthUntilKeyTyped(evt);
            }
        });

        jTextDayUntil.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jTextDayUntil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDayUntilKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("and then choose the employee");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Please insert the dates for the statistics:");

        jComboBoxModelEmployee.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jComboBoxModelEmployee.setToolTipText("");
        jComboBoxModelEmployee.setAutoscrolls(true);
        jComboBoxModelEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModelEmployeeActionPerformed(evt);
            }
        });

        jCheckBox.setBackground(new java.awt.Color(204, 255, 153));
        jCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("**Please check the box if you want the sales from a particular employee ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("*for only one day fill in the same date twice");

        jButtonReset.setBackground(new java.awt.Color(255, 255, 51));
        jButtonReset.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextDayUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextMonthUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jTextMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextYearUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxModelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(561, 561, 561))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(236, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(22, 22, 22)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextDayUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMonthUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextYearUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxModelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(539, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextYearUntilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextYearUntilKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextYearUntilKeyTyped

    private void jTextMonthFromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMonthFromKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextMonthFromKeyTyped

    private void jTextDayFromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDayFromKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextDayFromKeyTyped

    private void jButtonSearchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchOrderActionPerformed
        //inputs of the user
        dayFrom=jTextDayFrom.getText();
        monthFrom=jTextMonthFrom.getText();
        yearFrom=jTextYearFrom.getText();
        //save the date of the next day for the results of the end of the previous day
        dayUntil=String.valueOf(Integer.parseInt(jTextDayUntil.getText())+1);
        monthUntil=jTextMonthUntil.getText();
        yearUntil=jTextYearUntil.getText();
        //check the year
        if((yearFrom.length()!=4)&&(yearUntil.length()!=4))
            JOptionPane.showMessageDialog(this, "please insert four digits for the year");
        //check the day
        else if((Integer.parseInt(dayFrom)>31)&&(Integer.parseInt(dayUntil)>31))
            JOptionPane.showMessageDialog(this, "there is not such a day in a month.Please try again!");
        //check the month
        else if((Integer.parseInt(monthFrom)>12)&&(Integer.parseInt(monthUntil)>12))
            JOptionPane.showMessageDialog(this, "there is not such a month in a year.Please try again!");
        else
        {
            //save the date as a string
            dateFrom=yearFrom+"-"+monthFrom+"-"+dayFrom;
            try 
            {
                datef=new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
            } 
            catch (ParseException ex) {
                Logger.getLogger(StatisticsShowView.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateUntil=yearUntil+"-"+monthUntil+"-"+dayUntil;
            try 
            {
                dateu=new SimpleDateFormat("yyyy-MM-dd").parse(dateUntil);
            } 
            catch (ParseException ex) {
                Logger.getLogger(StatisticsShowView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //if there is no chosen employee 
        if(!empty)
        {
            //the list of the statistics
            listaS=statistika.statisticControl(datef, dateu);
            //display the list on the jTable
            DefaultTableModel lista=(DefaultTableModel)jTableStatisticShow.getModel();
            for(Object[] a:listaS)
            {
                lista.addRow(a);
            }
        }
        else
        {
            //the list of the statistics
            listaS=statistika.statisticControlEmp(datef, dateu,Integer.parseInt(id));
            //display the list on the jTable
            DefaultTableModel lista=(DefaultTableModel)jTableStatisticShow.getModel();
            for(Object[] a:listaS)
            {
                lista.addRow(a);
            }
        }
   
    }//GEN-LAST:event_jButtonSearchOrderActionPerformed

    private void jTextYearFromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextYearFromKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextYearFromKeyTyped

    private void jTextMonthUntilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMonthUntilKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextMonthUntilKeyTyped

    private void jTextDayUntilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDayUntilKeyTyped
        //check if the input of the user is a digit
        char typeKey=evt.getKeyChar();
        if(!((Character.isDigit(typeKey)||(typeKey=='\b'))))
        {
            JOptionPane.showMessageDialog(this, "please insert a digit");
            evt.consume();
        }
    }//GEN-LAST:event_jTextDayUntilKeyTyped
    //the choice of the employee
    private void jComboBoxModelEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModelEmployeeActionPerformed
        if(empty)
        {
            //the choice of the check box with the employees
            jboxmodelEmployee=jComboBoxModelEmployee.getSelectedItem().toString();
            //if there is no choice
            if(jboxmodelEmployee=="EMPLOYEES...")
            {
                JOptionPane.showMessageDialog(null,"Please choose an employee");
                jboxmodelEmployee=null;
            }
            else
            {
            //separate the string in three parts, the name the surname and the id of the employee
            String[] s=jboxmodelEmployee.split(" ");
            onoma=s[0];
            epitheto=s[1];
            id=s[2];
            }
        }
    }//GEN-LAST:event_jComboBoxModelEmployeeActionPerformed
    //make the check box active
    private void jCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActionPerformed
               empty=true;
    }//GEN-LAST:event_jCheckBoxActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        //reset all the fields
        jTextDayFrom.setText(null);
        jTextMonthFrom.setText(null);
        jTextYearFrom.setText(null);
        jTextDayUntil.setText(null);
        jTextMonthUntil.setText(null);
        jTextYearUntil.setText(null);
        jCheckBox.setSelected(false);
        onoma=null;
        epitheto=null;
        id=null;
        empty=false;
        //remove the products of the sale list
        jTableStatisticShow.setModel(new DefaultTableModel(null,new String[]{"CUSTOMER","BRAND","MODEL","PRICE"}) );
        //delete the list of the previous choice
        if(listaS.size()>0)
            listaS.clear();
    }//GEN-LAST:event_jButtonResetActionPerformed

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
            java.util.logging.Logger.getLogger(StatisticsShowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticsShowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticsShowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticsShowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticsShowView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSearchOrder;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JComboBox<String> jComboBoxModelEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableStatisticShow;
    private javax.swing.JTextField jTextDayFrom;
    private javax.swing.JTextField jTextDayUntil;
    private javax.swing.JTextField jTextMonthFrom;
    private javax.swing.JTextField jTextMonthUntil;
    private javax.swing.JTextField jTextYearFrom;
    private javax.swing.JTextField jTextYearUntil;
    // End of variables declaration//GEN-END:variables
}
