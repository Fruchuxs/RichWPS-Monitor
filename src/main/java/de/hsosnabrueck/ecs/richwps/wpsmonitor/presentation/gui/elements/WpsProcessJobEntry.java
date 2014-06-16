/*
 * Copyright 2014 FloH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.elements;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.monitor.control.TriggerConfig;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.MessageDialogs;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.structures.IntervalComboBoxItem;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.structures.WpsProcess;
import java.awt.Dimension;
import java.util.Date;
import java.util.EnumMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import org.quartz.DateBuilder;
import org.quartz.TriggerKey;

/**
 *
 * @author FloH
 */
public class WpsProcessJobEntry extends javax.swing.JPanel {
    private WpsMonitorControl mainFrame;
    private WpsProcess wpsProcess;
    private TriggerKey triggerKey;
    
    
    /**
     * Creates new form JobEntry
     */
    public WpsProcessJobEntry(WpsMonitorControl mainFrame, WpsProcess wpsProcess) {
        initComponents(); 
        this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
        
        initComboBox();
        
        this.mainFrame = mainFrame;
        this.wpsProcess = wpsProcess;
    }
    
    public final void initComboBox() {
        IntervalComboBoxItem[] items = new IntervalComboBoxItem[] { 
            new IntervalComboBoxItem("Millisecond", DateBuilder.IntervalUnit.MILLISECOND),
            new IntervalComboBoxItem("Second", DateBuilder.IntervalUnit.SECOND),
            new IntervalComboBoxItem("Minute", DateBuilder.IntervalUnit.MINUTE),
            new IntervalComboBoxItem("Hour", DateBuilder.IntervalUnit.HOUR),
            new IntervalComboBoxItem("Day", DateBuilder.IntervalUnit.DAY),
            new IntervalComboBoxItem("Week", DateBuilder.IntervalUnit.WEEK),
            new IntervalComboBoxItem("Month", DateBuilder.IntervalUnit.MONTH),
            new IntervalComboBoxItem("Year", DateBuilder.IntervalUnit.YEAR)
        };
        
        intervalTypeCombooBox.setModel(new DefaultComboBoxModel(items));
    }
    
    public Boolean isFieldsValid() {
        return !isEmpty(intervalField) && 
                startDate.getDate() != null && 
                endDate.getDate() != null &&
                startDate.getDate().before(endDate.getDate());
    }
    
    public void checkSaveButtonState() {
        if(isFieldsValid()) {
            saveJob.setEnabled(true);
        }
    }
    
    public Boolean isEmpty(JTextField validate) {
        return validate == null || validate.getText().trim().equals("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        intervalTypeCombooBox = new javax.swing.JComboBox();
        intervalField = new javax.swing.JTextField();
        saveJob = new javax.swing.JButton();

        startDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldFocusLost(evt);
            }
        });
        startDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt);
            }
        });

        endDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldFocusLost(evt);
            }
        });
        endDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt);
            }
        });

        intervalTypeCombooBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Milliseconds", "Second", "Minute", "Hour", "Day", "Week", "Month", "Year" }));

        intervalField.setText("jTextField1");
        intervalField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldFocusLost(evt);
            }
        });
        intervalField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt);
            }
        });

        saveJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveJob.setText("Save");
        saveJob.setEnabled(false);
        saveJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(intervalField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(intervalTypeCombooBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveJob)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(intervalTypeCombooBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(intervalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveJob))
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusGained
        checkSaveButtonState();
    }//GEN-LAST:event_fieldFocusGained

    private void fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusLost
        checkSaveButtonState();
    }//GEN-LAST:event_fieldFocusLost

    private void fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKeyReleased
        checkSaveButtonState();
    }//GEN-LAST:event_fieldKeyReleased

    private void saveJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJobActionPerformed
        if(isFieldsValid()) {
            IntervalComboBoxItem selectedItem = (IntervalComboBoxItem)intervalTypeCombooBox.getSelectedItem();
            String intervalValue = intervalField.getText();
            
            try {
                Integer interval = Integer.parseInt(intervalValue);
                
                TriggerConfig tConfig = new TriggerConfig(startDate.getDate(), endDate.getDate(), interval, selectedItem.getFormatKey());
                TriggerKey newTrigger = mainFrame.getMonitorRef()
                        .getMonitorControl()
                        .createTrigger(wpsProcess.getWps().getIdentifier(), wpsProcess.getIdentifier(), tConfig);
                
                if(newTrigger == null) {
                    MessageDialogs.showError(mainFrame, "Error", "Job was not created. Is Scheduler started? See the logs.");
                } else {
                    this.triggerKey = newTrigger;
                }
            } catch(NumberFormatException ex) {
                MessageDialogs.showError(mainFrame, "Invalid Number Format", "\"" + intervalValue + "\" is not a valid Number format.");
            }
        }
    }//GEN-LAST:event_saveJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JTextField intervalField;
    private javax.swing.JComboBox intervalTypeCombooBox;
    private javax.swing.JButton saveJob;
    private com.toedter.calendar.JDateChooser startDate;
    // End of variables declaration//GEN-END:variables
}
