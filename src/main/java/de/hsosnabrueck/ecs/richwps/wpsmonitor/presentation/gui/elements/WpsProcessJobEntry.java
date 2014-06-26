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

import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.entity.WpsProcessEntity;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.monitor.scheduler.TriggerConfig;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.MessageDialogs;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.structures.IntervalComboBoxItem;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.quartz.DateBuilder;
import org.quartz.TriggerKey;

/**
 *
 * @author FloH
 */
public class WpsProcessJobEntry extends javax.swing.JPanel {

    private WpsMonitorGui mainFrame;
    private WpsProcessEntity wpsProcess;
    private TriggerKey triggerKey;
    private JPanel parent;

    public WpsProcessJobEntry(WpsMonitorGui mainFrame, JPanel parent, WpsProcessEntity wpsProcess) {
        this(mainFrame, parent, wpsProcess, null);
    }

    public WpsProcessJobEntry(WpsMonitorGui mainFrame, JPanel parent, WpsProcessEntity wpsProcess, TriggerConfig triggerConfig) {
        initComponents();

        this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
        this.mainFrame = mainFrame;
        this.wpsProcess = wpsProcess;
        this.parent = parent;

        init(triggerConfig);
    }

    private void init(TriggerConfig triggerConfig) {
        initComboBox();

        if (triggerConfig != null) {
            this.startDate.setDate(triggerConfig.getStart());
            this.endDate.setDate(triggerConfig.getEnd());
            this.intervalTypeCombooBox.setSelectedItem(new IntervalComboBoxItem(triggerConfig.getIntervalType()));
            this.intervalTypeCombooBox.getModel().setSelectedItem(new IntervalComboBoxItem(triggerConfig.getIntervalType()));
            this.intervalField.setText(triggerConfig.getInterval().toString());

            this.triggerKey = triggerConfig.getTriggerKey();
        }
    }

    public void reInit(TriggerConfig config) {
        init(config);
    }

    private void initComboBox() {
        IntervalComboBoxItem[] items = new IntervalComboBoxItem[]{
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.SECOND),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.MINUTE),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.HOUR),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.DAY),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.WEEK),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.MONTH),
            new IntervalComboBoxItem(DateBuilder.IntervalUnit.YEAR)
        };

        intervalTypeCombooBox.setModel(new DefaultComboBoxModel(items));
    }

    public Boolean isFieldsValid() {
        return !isEmpty(intervalField)
                && startDate.getDate() != null
                && endDate.getDate() != null
                && startDate.getDate().before(endDate.getDate());
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
        deleteJob = new javax.swing.JButton();

        intervalTypeCombooBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Milliseconds", "Second", "Minute", "Hour", "Day", "Week", "Month", "Year" }));

        saveJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveJob.setText("Save");
        saveJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJobActionPerformed(evt);
            }
        });

        deleteJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        deleteJob.setText("Delete");
        deleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJobActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(intervalField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(intervalTypeCombooBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(saveJob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteJob)
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
                        .addComponent(saveJob)
                        .addComponent(deleteJob))
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJobActionPerformed
        if (isFieldsValid()) {
            IntervalComboBoxItem selectedItem = (IntervalComboBoxItem) intervalTypeCombooBox.getSelectedItem();
            String intervalValue = intervalField.getText();

            try {
                Integer interval = Integer.parseInt(intervalValue);

                TriggerConfig tConfig = new TriggerConfig(startDate.getDate(),
                        endDate.getDate(),
                        interval,
                        selectedItem.getFormatKey(),
                        triggerKey
                );

                TriggerKey newTrigger = mainFrame.getMonitorReference()
                        .getMonitorControl()
                        .saveTrigger(wpsProcess.getWps().getIdentifier(), wpsProcess.getIdentifier(), tConfig);

                if (newTrigger == null) {
                    MessageDialogs.showError(mainFrame,
                            "Error",
                            "Job was not created. Is Scheduler started? See the logs."
                    );
                } else {
                    this.triggerKey = newTrigger;
                }
            } catch (NumberFormatException ex) {
                MessageDialogs.showError(mainFrame,
                        "Invalid Number Format",
                        "\"" + intervalValue + "\" is not a valid Number format."
                );
            }
        }
    }//GEN-LAST:event_saveJobActionPerformed

    private void deleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJobActionPerformed
        if (triggerKey != null) { //if triggerkey null, then this job was not saved
            mainFrame.getMonitorReference()
                    .getMonitorControl()
                    .deleteTrigger(triggerKey);
        }

        parent.remove(this);

        parent.revalidate();
        parent.repaint(); // repaint required, otherwise the last element will not disappear
    }//GEN-LAST:event_deleteJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteJob;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JTextField intervalField;
    private javax.swing.JComboBox intervalTypeCombooBox;
    private javax.swing.JButton saveJob;
    private com.toedter.calendar.JDateChooser startDate;
    // End of variables declaration//GEN-END:variables
}
