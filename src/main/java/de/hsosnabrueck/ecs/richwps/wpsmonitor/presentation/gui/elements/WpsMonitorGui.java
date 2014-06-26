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

import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.entity.WpsEntity;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.monitor.control.Monitor;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui.MessageDialogs;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.utils.Param;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class WpsMonitorGui extends javax.swing.JFrame {

    private final Monitor monitor;

    /**
     * Creates new form WpsMonitorControl
     *
     * @param monitor
     */
    public WpsMonitorGui(final Monitor monitor) {
        this.monitor = Param.notNull(monitor, "monitor");
        
        initComponents();
        init();
        
        setLocationRelativeTo(null);
    }

    private void init() {
        List<WpsEntity> wpsList = monitor.getMonitorControl()
                .getWpsList();
        
        for(WpsEntity wps : wpsList) {
            createAndAddWpsPanel(wps);
        }
    }

    private Boolean isCreateFieldsNotEmpty() {
        return !(wpsToAddField.getText().trim().equalsIgnoreCase("")
                || wpsToAddUriField.getText().trim().equalsIgnoreCase(""));
    }

    public JTextField getWpsToAddField() {
        return wpsToAddField;
    }

    public void setWpsToAddField(JTextField wpsToAddField) {
        this.wpsToAddField = wpsToAddField;
    }

    public JTextField getWpsToAddUriField() {
        return wpsToAddUriField;
    }

    public void setWpsToAddUriField(JTextField wpsToAddUriField) {
        this.wpsToAddUriField = wpsToAddUriField;
    }

    public Monitor getMonitorReference() {
        return monitor;
    }

    private void resetAddWpsFields() {
        getWpsToAddField()
                .setText("");
        getWpsToAddUriField()
                .setText("");

        getWpsToAddField()
                .requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel wpsIdentifierDecoText = new javax.swing.JLabel();
        wpsToAddField = new javax.swing.JTextField();
        javax.swing.JLabel wpsUrlDecoText = new javax.swing.JLabel();
        wpsToAddUriField = new javax.swing.JTextField();
        addWpsButton = new javax.swing.JButton();
        javax.swing.JPanel decoPanelWpsScroll = new javax.swing.JPanel();
        wpsScrollPane = new javax.swing.JScrollPane();
        wpsAddPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        settings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WPS-Monitor Control Interface");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("wpsGui"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Register a WPS Server in the Monitor"));

        wpsIdentifierDecoText.setText("WPS Identifier");

        wpsToAddField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wpsToAddFieldActionPerformed(evt);
            }
        });

        wpsUrlDecoText.setText("WPS URL");

        wpsToAddUriField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wpsToAddUriFieldActionPerformed(evt);
            }
        });

        addWpsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addWpsButton.setText("Add WPS");
        addWpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWpsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wpsIdentifierDecoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wpsToAddField, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(wpsUrlDecoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wpsToAddUriField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addWpsButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wpsIdentifierDecoText)
                    .addComponent(wpsToAddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wpsUrlDecoText)
                    .addComponent(wpsToAddUriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addWpsButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        decoPanelWpsScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Registred WPS Server"));

        wpsScrollPane.setBorder(null);
        wpsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        wpsScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        wpsAddPanel.setBackground(new java.awt.Color(255, 255, 255));
        wpsAddPanel.setLayout(new javax.swing.BoxLayout(wpsAddPanel, javax.swing.BoxLayout.PAGE_AXIS));
        wpsScrollPane.setViewportView(wpsAddPanel);

        javax.swing.GroupLayout decoPanelWpsScrollLayout = new javax.swing.GroupLayout(decoPanelWpsScroll);
        decoPanelWpsScroll.setLayout(decoPanelWpsScrollLayout);
        decoPanelWpsScrollLayout.setHorizontalGroup(
            decoPanelWpsScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoPanelWpsScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wpsScrollPane)
                .addContainerGap())
        );
        decoPanelWpsScrollLayout.setVerticalGroup(
            decoPanelWpsScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoPanelWpsScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wpsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        settings.setText("Settings");
        jToolBar2.add(settings);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decoPanelWpsScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(decoPanelWpsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void addWpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWpsButtonActionPerformed
        if (isCreateFieldsNotEmpty()) {
            try {
                WpsEntity wps = new WpsEntity(getWpsToAddField().getText(),
                        getWpsToAddUriField().getText()
                );

                Boolean isWpsCreated = monitor
                        .getMonitorControl()
                        .createWps(wps.getIdentifier(), wps.getUri());

                if (isWpsCreated) {
                    resetAddWpsFields();
                    createAndAddWpsPanel(wps);
                } else {
                    MessageDialogs.showError(this,
                            "Error",
                            "Can't register Wps. Maybe the Wps is already registred."
                    );
                }
            } catch (MalformedURLException ex) {
                showUriConvertError();
            } catch (URISyntaxException ex) {
                showUriConvertError();
            }
        } else {
            MessageDialogs.showError(this,
                    "Error",
                    "One of the fields is empty!"
            );
        }
    }//GEN-LAST:event_addWpsButtonActionPerformed

    private void createAndAddWpsPanel(WpsEntity wps) {
        WpsPanel panel = createWpsPanel(wps);
        addWpsPanel(panel);
    }
    
    private WpsPanel createWpsPanel(WpsEntity wps) {
        return new WpsPanel(this, wpsAddPanel, wps);
    }

    private void addWpsPanel(WpsPanel panel) {
        wpsAddPanel.add(panel, BorderLayout.PAGE_START);
        wpsAddPanel.revalidate();
    }

    private void showUriConvertError() {
        MessageDialogs.showError(this,
                "Error",
                "The entered URI is not valid!"
        );
    }

    public void reInit() {
        init();
    }

    private void wpsToAddFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wpsToAddFieldActionPerformed
        addWpsButtonActionPerformed(evt);
    }//GEN-LAST:event_wpsToAddFieldActionPerformed

    private void wpsToAddUriFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wpsToAddUriFieldActionPerformed
        addWpsButtonActionPerformed(evt);
    }//GEN-LAST:event_wpsToAddUriFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWpsButton;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton settings;
    private javax.swing.JPanel wpsAddPanel;
    private javax.swing.JScrollPane wpsScrollPane;
    private javax.swing.JTextField wpsToAddField;
    private javax.swing.JTextField wpsToAddUriField;
    // End of variables declaration//GEN-END:variables
}
