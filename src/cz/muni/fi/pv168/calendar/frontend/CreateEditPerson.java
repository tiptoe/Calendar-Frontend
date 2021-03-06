/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Person;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jan Smerda, Jiri Stary
 */
public class CreateEditPerson extends javax.swing.JDialog {

    
    private static final Logger logger =
            LoggerFactory.getLogger(CreateEditPerson.class);
    
    private static Person person;
    /**
     * Creates new form CreateEditPerson
     */
    public CreateEditPerson(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (person != null) {
            setUp();
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

        jTextFieldNewPersonName = new javax.swing.JTextField();
        jTextFieldNewPersonEmail = new javax.swing.JTextField();
        jTextFieldNewPersonNote = new javax.swing.JTextField();
        jButtonNewPersonCommit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Strings.getString("person"));

        jButtonNewPersonCommit.setText(Strings.getString("create"));
        jButtonNewPersonCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPersonCommitActionPerformed(evt);
            }
        });

        jLabel1.setText(Strings.getString("name_person"));

        jLabel2.setText(Strings.getString("email"));

        jLabel3.setText(Strings.getString("note"));

        jButton1.setText(Strings.getString("cancel"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 265, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNewPersonEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNewPersonName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(35, 35, 35)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonNewPersonCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNewPersonNote)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNewPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNewPersonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNewPersonNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewPersonCommit)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewPersonCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPersonCommitActionPerformed
        if (jTextFieldNewPersonName.getText().equals("")) {
            String msg = Strings.getString("please_fill_in_name");
            logger.error(msg);
            JOptionPane.showMessageDialog(null, msg);
            return;
        }
        if (jTextFieldNewPersonEmail.getText().equals("")) {
            String msg = Strings.getString("please_fill_in_email_address");
            logger.error(msg);
            JOptionPane.showMessageDialog(null, msg);
            return;
        }
        
        if (person == null) {
            Person newPerson = new Person();
            newPerson.setName(jTextFieldNewPersonName.getText());
            newPerson.setEmail(jTextFieldNewPersonEmail.getText());
            newPerson.setNote(jTextFieldNewPersonNote.getText());
            EventsMainWindow.getPersonManager().createPerson(newPerson);
        } else {
            person.setName(jTextFieldNewPersonName.getText());
            person.setEmail(jTextFieldNewPersonEmail.getText());
            person.setNote(jTextFieldNewPersonNote.getText());
            EventsMainWindow.getPersonManager().updatePerson(person);
        }
        this.dispose();
        
    }//GEN-LAST:event_jButtonNewPersonCommitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setUp() {
        jTextFieldNewPersonName.setText(person.getName());
        jTextFieldNewPersonEmail.setText(person.getEmail());
        jTextFieldNewPersonNote.setText(person.getNote());
    }
    /**
     * @param args the command line arguments
     */
    public static void start(Person person) {
        CreateEditPerson.person = person;
        
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
            java.util.logging.Logger.getLogger(CreateEditPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEditPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEditPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEditPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateEditPerson dialog = new CreateEditPerson(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNewPersonCommit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldNewPersonEmail;
    private javax.swing.JTextField jTextFieldNewPersonName;
    private javax.swing.JTextField jTextFieldNewPersonNote;
    // End of variables declaration//GEN-END:variables
}
