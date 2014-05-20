/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Event;
import cz.muni.fi.pv168.calendar.backend.EventManager;
import cz.muni.fi.pv168.calendar.backend.EventManagerImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Jan Smerda, Jiri Stary
 */
public class CreateEditEvent extends javax.swing.JDialog {

    private static final Logger logger =
            LoggerFactory.getLogger(CreateEditEvent.class);
    
    private static Event event;

    /**
     * Creates new form CreateEditEvent
     */
    public CreateEditEvent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (event != null) {
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

        jTextFieldNewEventName = new javax.swing.JTextField();
        jTextFieldNewEventNote = new javax.swing.JTextField();
        jButtonNewEventCommit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerNewEventStartDay = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSpinnerNewEventStartMonth = new javax.swing.JSpinner();
        jSpinnerNewEventStartYear = new javax.swing.JSpinner();
        jSpinnerNewEventStartHour = new javax.swing.JSpinner();
        jSpinnerNewEventStartMinute = new javax.swing.JSpinner();
        jSpinnerNewEventEndDay = new javax.swing.JSpinner();
        jSpinnerNewEventEndMonth = new javax.swing.JSpinner();
        jSpinnerNewEventEndYear = new javax.swing.JSpinner();
        jSpinnerNewEventEndHour = new javax.swing.JSpinner();
        jSpinnerNewEventEndMinute = new javax.swing.JSpinner();
        jButtonNewEventCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNewEventName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNewEventNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNewEventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, -1));
        getContentPane().add(jTextFieldNewEventNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 360, -1));

        jButtonNewEventCommit.setText(Strings.getString("create"));
        jButtonNewEventCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewEventCommitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewEventCommit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 128, -1));

        jLabel1.setText(Strings.getString("name_event"));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setText(Strings.getString("start_date"));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText(Strings.getString("end_date"));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setText(Strings.getString("note"));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jSpinnerNewEventStartDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        getContentPane().add(jSpinnerNewEventStartDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 50, -1));

        jLabel5.setText(Strings.getString("day"));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel6.setText(Strings.getString("month"));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel7.setText(Strings.getString("year"));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel8.setText(Strings.getString("hour"));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel9.setText(Strings.getString("minute"));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jSpinnerNewEventStartMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        getContentPane().add(jSpinnerNewEventStartMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 50, -1));

        jSpinnerNewEventStartYear.setModel(new javax.swing.SpinnerNumberModel(2014, 1970, 2100, 1));
        getContentPane().add(jSpinnerNewEventStartYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 80, -1));

        jSpinnerNewEventStartHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        getContentPane().add(jSpinnerNewEventStartHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 50, -1));

        jSpinnerNewEventStartMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        getContentPane().add(jSpinnerNewEventStartMinute, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 50, -1));

        jSpinnerNewEventEndDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        getContentPane().add(jSpinnerNewEventEndDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 50, -1));

        jSpinnerNewEventEndMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        getContentPane().add(jSpinnerNewEventEndMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 50, -1));

        jSpinnerNewEventEndYear.setModel(new javax.swing.SpinnerNumberModel(2014, 1970, 2100, 1));
        getContentPane().add(jSpinnerNewEventEndYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 80, -1));

        jSpinnerNewEventEndHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        getContentPane().add(jSpinnerNewEventEndHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, -1));

        jSpinnerNewEventEndMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        getContentPane().add(jSpinnerNewEventEndMinute, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 50, -1));

        jButtonNewEventCancel.setText(Strings.getString("cancel"));
        jButtonNewEventCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewEventCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewEventCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNewEventNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNewEventNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNewEventNameActionPerformed

    private void jButtonNewEventCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewEventCommitActionPerformed
        if (jTextFieldNewEventName.getText().equals("")) {
            String msg = Strings.getString("please_fill_in_name");
            logger.error(msg);
            JOptionPane.showMessageDialog(null, msg);
            return;
        }
        
        Calendar calStart = new GregorianCalendar((int) jSpinnerNewEventStartYear.getValue(),
                (int) jSpinnerNewEventStartMonth.getValue() - 1,
                (int) jSpinnerNewEventStartDay.getValue(),
                (int) jSpinnerNewEventStartHour.getValue(),
                (int) jSpinnerNewEventStartMinute.getValue());
        Date startDate = calStart.getTime();
        
        Calendar calEnd = new GregorianCalendar((int) jSpinnerNewEventEndYear.getValue(),
                (int) jSpinnerNewEventEndMonth.getValue() - 1,
                (int) jSpinnerNewEventEndDay.getValue(),
                (int) jSpinnerNewEventEndHour.getValue(),
                (int) jSpinnerNewEventEndMinute.getValue());
        Date endDate = calEnd.getTime();
        
        if (event == null) {
            Event newEvent = new Event();
            newEvent.setName(jTextFieldNewEventName.getText());
            newEvent.setStartDate(startDate);
            newEvent.setEndDate(endDate);
            newEvent.setNote(jTextFieldNewEventNote.getText());
            EventsMainWindow.getEventManager().createEvent(newEvent);
        } else {
            event.setName(jTextFieldNewEventName.getText());
            event.setStartDate(startDate);
            event.setEndDate(endDate);
            event.setNote(jTextFieldNewEventNote.getText());
            EventsMainWindow.getEventManager().updateEvent(event);
        }
        
         this.dispose();


    }//GEN-LAST:event_jButtonNewEventCommitActionPerformed

    private void setUp() {
        jTextFieldNewEventName.setText(event.getName());
        jTextFieldNewEventNote.setText(event.getNote());
        
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(event.getStartDate());
        jSpinnerNewEventStartYear.setValue(startCalendar.get(Calendar.YEAR));
        jSpinnerNewEventStartMonth.setValue(startCalendar.get(Calendar.MONTH) + 1);
        jSpinnerNewEventStartDay.setValue(startCalendar.get(Calendar.DAY_OF_MONTH));
        jSpinnerNewEventStartHour.setValue(startCalendar.get(Calendar.HOUR_OF_DAY));
        jSpinnerNewEventStartMinute.setValue(startCalendar.get(Calendar.MINUTE));
        
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(event.getEndDate());
        jSpinnerNewEventEndYear.setValue(endCalendar.get(Calendar.YEAR));
        jSpinnerNewEventEndMonth.setValue(endCalendar.get(Calendar.MONTH) + 1);
        jSpinnerNewEventEndDay.setValue(endCalendar.get(Calendar.DAY_OF_MONTH));
        jSpinnerNewEventEndHour.setValue(endCalendar.get(Calendar.HOUR_OF_DAY));
        jSpinnerNewEventEndMinute.setValue(endCalendar.get(Calendar.MINUTE));
    }
    
    private void jButtonNewEventCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewEventCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonNewEventCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void start(Event event) {
        CreateEditEvent.event = event;
        
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
            java.util.logging.Logger.getLogger(CreateEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateEditEvent dialog = new CreateEditEvent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewEventCancel;
    private javax.swing.JButton jButtonNewEventCommit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinnerNewEventEndDay;
    private javax.swing.JSpinner jSpinnerNewEventEndHour;
    private javax.swing.JSpinner jSpinnerNewEventEndMinute;
    private javax.swing.JSpinner jSpinnerNewEventEndMonth;
    private javax.swing.JSpinner jSpinnerNewEventEndYear;
    private javax.swing.JSpinner jSpinnerNewEventStartDay;
    private javax.swing.JSpinner jSpinnerNewEventStartHour;
    private javax.swing.JSpinner jSpinnerNewEventStartMinute;
    private javax.swing.JSpinner jSpinnerNewEventStartMonth;
    private javax.swing.JSpinner jSpinnerNewEventStartYear;
    private javax.swing.JTextField jTextFieldNewEventName;
    private javax.swing.JTextField jTextFieldNewEventNote;
    // End of variables declaration//GEN-END:variables
}
