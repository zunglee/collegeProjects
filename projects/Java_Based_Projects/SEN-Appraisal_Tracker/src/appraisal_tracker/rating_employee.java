/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appraisal_tracker;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kbiiita
 */
public class rating_employee extends javax.swing.JFrame {
public String useri;
    /**
     * Creates new form rating_employee
     */
    public rating_employee() throws SQLException {
       
        initComponents();
         jLabel1.setText("MANAGER , "+global.number);
          database db=new database();
          Statement stmt = (Statement) db.con.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT username from accounts where priviledge='employee'");
          while(rs.next())
            {
             combo.addItem(rs.getString("username"));
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        USERNAME1 = new javax.swing.JLabel();
        USERNAME2 = new javax.swing.JLabel();
        USERNAME3 = new javax.swing.JLabel();
        USERNAME4 = new javax.swing.JLabel();
        USERNAME5 = new javax.swing.JLabel();
        USERNAME6 = new javax.swing.JLabel();
        USERNAME7 = new javax.swing.JLabel();
        USERNAME8 = new javax.swing.JLabel();
        USERNAME9 = new javax.swing.JLabel();
        USERNAME10 = new javax.swing.JLabel();
        USERNAME11 = new javax.swing.JLabel();
        USERNAME12 = new javax.swing.JLabel();
        USERNAME13 = new javax.swing.JLabel();
        USERNAME14 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        USERNAME15 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        text2 = new javax.swing.JTextField();
        text3 = new javax.swing.JTextField();
        text4 = new javax.swing.JTextField();
        text5 = new javax.swing.JTextField();
        text6 = new javax.swing.JTextField();
        text7 = new javax.swing.JTextField();
        text8 = new javax.swing.JTextField();
        text9 = new javax.swing.JTextField();
        text10 = new javax.swing.JTextField();
        text11 = new javax.swing.JTextField();
        text12 = new javax.swing.JTextField();
        text13 = new javax.swing.JTextField();
        text14 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        back1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        USERNAME1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME1.setText("Skills");

        USERNAME2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME2.setText("Quality of work output");
        USERNAME2.setToolTipText("");

        USERNAME3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME3.setText("Reliability");

        USERNAME4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME4.setText("Consistency");

        USERNAME5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME5.setText("Work under pressure");

        USERNAME6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME6.setText("Receptivity to guidance");

        USERNAME7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME7.setText("On time tasks’ completion");

        USERNAME8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME8.setText("Initiative");

        USERNAME9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME9.setText("Adaptability");

        USERNAME10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME10.setText("Organization’s image");

        USERNAME11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME11.setText("Cooperation");

        USERNAME12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME12.setText("Attitude");

        USERNAME13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME13.setText("SELECT EMPLOYEE");

        USERNAME14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME14.setText("Communication ");

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select An Employee" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        USERNAME15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        USERNAME15.setText("DEPARTMENT");

        text2.setText("0");

        text3.setText("0");

        text4.setText("0");

        text5.setText("0");

        text6.setText("0");

        text7.setText("0");

        text8.setText("0");

        text9.setText("0");

        text10.setText("0");

        text11.setText("0");

        text12.setText("0");

        text13.setText("0");

        text14.setText("0");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("(OUT of 100)");

        jButton1.setText("RATE THIS EMPLOYEE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        back1.setText("BACK");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        jButton7.setText("LOGOUT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(USERNAME13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(USERNAME15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(USERNAME3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME2)
                                    .addComponent(USERNAME14, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(USERNAME10, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(USERNAME6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(USERNAME5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(USERNAME7, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(USERNAME12, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(text14)
                                    .addComponent(text13, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text2)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME15)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME1)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(USERNAME2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(USERNAME4)
                        .addGap(18, 18, 18)
                        .addComponent(USERNAME3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(text5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME8)
                    .addComponent(text6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME7)
                    .addComponent(text7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME5)
                    .addComponent(text8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME6)
                    .addComponent(text9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME9)
                    .addComponent(text10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME12)
                    .addComponent(text11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME10)
                    .addComponent(text12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME11)
                    .addComponent(text13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME14)
                    .addComponent(text14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
         useri=(String) combo.getSelectedItem();
        if(!"Select An Employee".equals(useri))
        {
            database db=new database();
          Statement stmt = null;
            try {
                stmt = (Statement) db.con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(rating_employee.class.getName()).log(Level.SEVERE, null, ex);
            }
          ResultSet rs;
            try {
                rs = stmt.executeQuery("SELECT department from profile where username='"+useri+"'");
                while(rs.next())
            {
            text1.setText(rs.getString("department"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(rating_employee.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        else
           text1.setText(""); 
    }//GEN-LAST:event_comboActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        // TODO add your handling code here:
        
            rating_employee.this.setVisible(false);
            logged_in n = new logged_in(global.number);
            n.show();
        
    }//GEN-LAST:event_back1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        rating_employee.this.setVisible(false);
        login ln = new login();
        ln.show();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String QueryString = null, QueryString2 = null;
        String arry[] = new String[20];
        arry[0] = (text2.getText());
        arry[1] = (text3.getText());
        arry[2] = (text4.getText());
        arry[3] = (text5.getText());
        arry[4] = (text6.getText());
        arry[5] = (text7.getText());
        arry[6] = (text8.getText());
        arry[7] = (text9.getText());
        arry[8] = (text10.getText());
        arry[9] = (text11.getText());
        arry[10] = (text12.getText());
        arry[11] = (text13.getText());
        arry[12] = (text14.getText());
        arry[13] = text1.getText();
        int pk = Integer.parseInt(arry[0]);
        JFrame parent = new JFrame();
        double p = 0;
        database db = new database();
        Statement stmt = null;
        try {
            stmt = (Statement) db.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(update_profile.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (("financial".equals(arry[13])) || (arry[13] == null ? "financial".toUpperCase() == null : arry[13].equals("financial".toUpperCase()))) {
            p = (Float.parseFloat(arry[0]) * 8.69) + (Float.parseFloat(arry[1]) * 22.23) + (Float.parseFloat(arry[2]) * 8.00) + (Float.parseFloat(arry[3]) * 8.00) + (Float.parseFloat(arry[4]) * 8.00) + (Float.parseFloat(arry[5]) * 5.08) + (Float.parseFloat(arry[6]) * 7.19) + (Float.parseFloat(arry[7]) * 6.12) + (Float.parseFloat(arry[8]) * 4.05) + (Float.parseFloat(arry[9]) * 5.12) + (Float.parseFloat(arry[10]) * 4.05) + (Float.parseFloat(arry[11]) * 6.25) + (Float.parseFloat(arry[12]) * 7.21);
            QueryString = "UPDATE rating2 SET skills='" + (Float.parseFloat(arry[0]) * 8.69 * 0.01) + "',quality='" + (Float.parseFloat(arry[1]) * 22.23 * 0.01) + "',leader='" + (Float.parseFloat(arry[0]) * 0 * 0.01) + "',consistency='" + (Float.parseFloat(arry[2]) * 8.00 * 0.01) + "',reliability='" + (Float.parseFloat(arry[3]) * 8.00 * 0.01) + "',initiative='" + (Float.parseFloat(arry[4]) * 8.00 * 0.01) + "',ontime='" + (Float.parseFloat(arry[5]) * 5.08 * 0.01) + "',workunder='" + (Float.parseFloat(arry[6]) * 7.19 * 0.01) + "',guidance='" + (Float.parseFloat(arry[7]) * 6.12 * 0.01) + "',adaptability='" + (Float.parseFloat(arry[8]) * 4.05 * 0.01) + "',attitude='" + (Float.parseFloat(arry[9]) * 5.12 * 0.01) + "',image='" + (Float.parseFloat(arry[10]) * 4.05 * 0.01) + "',cooperation='" + (Float.parseFloat(arry[11]) * 6.25 * 0.01) + "',communication='" + (Float.parseFloat(arry[12]) * 7.21 * 0.01) + "' where username='" + useri + "'";
            //QueryString2  = "INSERT INTO rating(username,department,skills,quality,leader,consistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+useri+"','"+arry[13]+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
            QueryString2 = "UPDATE rating SET skills='" + (8.69) + "',quality='" + (22.23) + "',leader='" + (0) + "',consistency='" + (8.00) + "',reliability='" + (8.00) + "',initiative='" + (8.00) + "',ontime='" + (5.08) + "',workunder='" + (7.19) + "',guidance='" + (6.12) + "',adaptability='" + (4.05) + "',attitude='" + (5.12) + "',image='" + (4.05) + "',cooperation='" + (6.25) + "',communication='" + (7.21) + "' where username='" + useri + "'";
        } else if (("customer".equals(arry[13])) || (arry[13] == null ? "customer".toUpperCase() == null : arry[13].equals("customer".toUpperCase()))) {
            p = (Float.parseFloat(arry[0]) * 7.38) + (Float.parseFloat(arry[1]) * 16.00) + (Float.parseFloat(arry[2]) * 7.83) + (Float.parseFloat(arry[3]) * 7.83) + (Float.parseFloat(arry[4]) * 7.83) + (Float.parseFloat(arry[5]) * 6.06) + (Float.parseFloat(arry[6]) * 7.11) + (Float.parseFloat(arry[7]) * 5.04) + (Float.parseFloat(arry[8]) * 4.02) + (Float.parseFloat(arry[9]) * 11.90) + (Float.parseFloat(arry[10]) * 5.76) + (Float.parseFloat(arry[11]) * 7.17) + (Float.parseFloat(arry[12]) * 6.08);
            //QueryString  = "INSERT INTO rating2(username,department,skills,quality,leader,consistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+useri+"','"+arry[13]+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
            //QueryString2  = "INSERT INTO rating(username,department,skills,quality,leader,consistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+useri+"','"+arry[13]+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
            QueryString = "UPDATE rating2 SET skills='" + (Float.parseFloat(arry[0]) * 7.38 * 0.01) + "',quality='" + (Float.parseFloat(arry[1]) * 16.00 * 0.01) + "',leader='" + (Float.parseFloat(arry[0]) * 0.00) + "',consistency='" + (Float.parseFloat(arry[2]) * 7.83 * 0.01) + "',reliability='" + (Float.parseFloat(arry[3]) * 7.83 * 0.01) + "',initiative='" + (Float.parseFloat(arry[4]) * 7.83 * 0.01) + "',ontime='" + (Float.parseFloat(arry[5]) * (0.0606)) + "',workunder='" + (Float.parseFloat(arry[6]) * 7.11 * 0.01) + "',guidance='" + (Float.parseFloat(arry[7]) * 5.04 * 0.01) + "',adaptability='" + (Float.parseFloat(arry[8]) * 0.01 * 4.02) + "',attitude='" + (Float.parseFloat(arry[9]) * 0.01 * 11.90) + "',image='" + (Float.parseFloat(arry[10]) * 0.01 * 5.76) + "',cooperation='" + (Float.parseFloat(arry[11]) * 7.17 * 0.01) + "',communication='" + (Float.parseFloat(arry[12]) * 6.08 * 0.01) + "' where username='" + useri + "'";
            //QueryString2  = "UPDATE rating2 SET skills='"+(Float.parseFloat(arry[0])*8.69)+"',quality='"+(Float.parseFloat(arry[0])*8.69)+"',leader='"+(Float.parseFloat(arry[0])*8.69)+"',consistency='"+(Float.parseFloat(arry[0])*8.69)+"',reliability='"+(Float.parseFloat(arry[0])*8.69)+"',initiative='"+(Float.parseFloat(arry[0])*8.69)+"',ontime='"+(Float.parseFloat(arry[0])*8.69)+"',workunder='"+(Float.parseFloat(arry[0])*8.69)+"',guidance='"+(Float.parseFloat(arry[0])*8.69)+"',adaptability='"+(Float.parseFloat(arry[0])*8.69)+"',attitude='"+(Float.parseFloat(arry[0])*8.69)+"',image='"+(Float.parseFloat(arry[0])*8.69)+"',cooperation='"+(Float.parseFloat(arry[0])*8.69)+"',communication='"+(Float.parseFloat(arry[0])*8.69)+"' where username='"+useri+"'";
            QueryString2 = "UPDATE rating SET skills='" + (7.38) + "',quality='" + (16.00) + "',leader='" + (0) + "',consistency='" + (7.83) + "',reliability='" + (7.83) + "',initiative='" + (7.83) + "',ontime='" + (6.06) + "',workunder='" + (7.11) + "',guidance='" + (5.04) + "',adaptability='" + (4.02) + "',attitude='" + (11.90) + "',image='" + (5.76) + "',cooperation='" + (7.17) + "',communication='" + (6.08) + "' where username='" + useri + "'";
        } else if (("technical".equals(arry[13])) || (arry[13] == null ? "technical".toUpperCase() == null : arry[13].equals("technical".toUpperCase()))) {
            p = (Float.parseFloat(arry[0]) * 12.66) + (Float.parseFloat(arry[1]) * 27.20) + (Float.parseFloat(arry[2]) * 7.89) + (Float.parseFloat(arry[3]) * 7.89) + (Float.parseFloat(arry[4]) * 7.89) + (Float.parseFloat(arry[5]) * 6.08) + (Float.parseFloat(arry[6]) * 7.14) + (Float.parseFloat(arry[7]) * 5.04) + (Float.parseFloat(arry[8]) * 4.02) + (Float.parseFloat(arry[9]) * 0.00) + (Float.parseFloat(arry[10]) * 0.00) + (Float.parseFloat(arry[11]) * 4.12) + (Float.parseFloat(arry[12]) * 10.08);
            //QueryString  = "INSERT INTO rating2(username,department,skills,quality,leader,consistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+useri+"','"+arry[13]+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
//QueryString2  = "INSERT INTO rating(username,department,skills,quality,leader,consistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+useri+"','"+arry[13]+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
            QueryString = "UPDATE rating2 SET skills='" + (Float.parseFloat(arry[0]) * 12.66 * 0.01) + "',quality='" + (Float.parseFloat(arry[1]) * 27.20 * 0.01) + "',leader='" + (Float.parseFloat(arry[0]) * 0.00) + "',consistency='" + (Float.parseFloat(arry[2]) * (0.0789)) + "',reliability='" + (Float.parseFloat(arry[3]) * (0.0789)) + "',initiative='" + (Float.parseFloat(arry[4]) * (0.0789)) + "',ontime='" + (Float.parseFloat(arry[5]) * 0.01 * 6.08) + "',workunder='" + (Float.parseFloat(arry[6]) * 0.01 * 7.14) + "',guidance='" + (Float.parseFloat(arry[7]) * 0.01 * 5.04) + "',adaptability='" + (Float.parseFloat(arry[8]) * 4.02 * 0.01) + "',attitude='" + (Float.parseFloat(arry[9]) * 0.00) + "',image='" + (Float.parseFloat(arry[10]) * 0.00) + "',cooperation='" + (Float.parseFloat(arry[11]) * 4.12 * 0.01) + "',communication='" + (Float.parseFloat(arry[12]) * 10.08 * 0.01) + "' where username='" + useri + "'";
            QueryString2 = "UPDATE rating SET skills='" + (12.66) + "',quality='" + (27.20) + "',leader='" + (0) + "',consistency='" + (7.89) + "',reliability='" + (7.89) + "',initiative='" + (7.89) + "',ontime='" + (6.08) + "',workunder='" + (7.14) + "',guidance='" + (5.04) + "',adaptability='" + (4.02) + "',attitude='" + (0) + "',image='" + (0) + "',cooperation='" + (4.12) + "',communication='" + (10.08) + "' where username='" + useri + "'";
            System.out.println("hello" + Float.parseFloat(arry[4]));
        }

        JOptionPane.showMessageDialog(parent, "Rating of an Employee out of 100 is   " + p / 100.00);
        try {
            int updateQuery = stmt.executeUpdate(QueryString);
            if (updateQuery != 0) {
                System.out.println(" row is inserted in accounts table.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(new_employee.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            int updateQuery = stmt.executeUpdate(QueryString2);
            if (updateQuery != 0) {
                System.out.println(" row is inserted in accounts table.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(new_employee.class.getName()).log(Level.SEVERE, null, ex);
        }

        //String QueryString  = "INSERT INTO rating(username,department,skills,quality,leader,cosistency,reliability,initiative,ontime,workunder,guidance,adaptability,attitude,image,cooperation,communication) VALUES ('"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"','"+(Float.parseFloat(arry[0])*8.69)+"')";
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel USERNAME1;
    private javax.swing.JLabel USERNAME10;
    private javax.swing.JLabel USERNAME11;
    private javax.swing.JLabel USERNAME12;
    private javax.swing.JLabel USERNAME13;
    private javax.swing.JLabel USERNAME14;
    private javax.swing.JLabel USERNAME15;
    private javax.swing.JLabel USERNAME2;
    private javax.swing.JLabel USERNAME3;
    private javax.swing.JLabel USERNAME4;
    private javax.swing.JLabel USERNAME5;
    private javax.swing.JLabel USERNAME6;
    private javax.swing.JLabel USERNAME7;
    private javax.swing.JLabel USERNAME8;
    private javax.swing.JLabel USERNAME9;
    private javax.swing.JButton back1;
    private javax.swing.JComboBox combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text10;
    private javax.swing.JTextField text11;
    private javax.swing.JTextField text12;
    private javax.swing.JTextField text13;
    private javax.swing.JTextField text14;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    private javax.swing.JTextField text5;
    private javax.swing.JTextField text6;
    private javax.swing.JTextField text7;
    private javax.swing.JTextField text8;
    private javax.swing.JTextField text9;
    // End of variables declaration//GEN-END:variables
}
