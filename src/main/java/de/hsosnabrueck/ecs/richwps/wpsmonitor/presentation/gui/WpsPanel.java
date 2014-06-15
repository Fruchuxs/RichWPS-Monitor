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
package de.hsosnabrueck.ecs.richwps.wpsmonitor.presentation.gui;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.utils.Param;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author FloH
 */
public class WpsPanel extends javax.swing.JPanel {

    private URI wpsUri;
    private String wpsName;
    private JPanel parentRef;
    private JFrame mainFrame;
    private JDialog wpsProcessDialog;

    WpsPanel(JFrame mainFrame, final String wpsName, final URI wpsUri, JPanel parent) {
        this.wpsName = Param.notNull(wpsName, "wpsName");
        this.wpsUri = Param.notNull(wpsUri, "wpsUri");
        this.parentRef = Param.notNull(parent, "parent");
        this.mainFrame = Param.notNull(mainFrame, "mainFrame");

        initComponents();

        this.wpsProcessDialog = new WpsProcessDialog(mainFrame, true);

        this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
        wpsNameLabel.setText(this.wpsName);
        wpsUriLabel.setText(this.wpsUri.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wpsNameLabel = new javax.swing.JLabel();
        wpsUriLabel = new javax.swing.JLabel();
        editWpsButton = new javax.swing.JButton();
        deleteWpsButton = new javax.swing.JButton();
        addProcessToWpsButton = new javax.swing.JButton();
        WpsHeadlineSeperator = new javax.swing.JSeparator();

        wpsNameLabel.setText("<Wps Name>");

        wpsUriLabel.setText("<URI>");

        editWpsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        editWpsButton.setText("Edit Wps");
        editWpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWpsButtonActionPerformed(evt);
            }
        });

        deleteWpsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        deleteWpsButton.setText("Delete WPS");
        deleteWpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteWpsButtonActionPerformed(evt);
            }
        });

        addProcessToWpsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addProcessToWpsButton.setText("Add Process");
        addProcessToWpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProcessToWpsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(WpsHeadlineSeperator, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wpsNameLabel)
                            .addComponent(wpsUriLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editWpsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteWpsButton))
                            .addComponent(addProcessToWpsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wpsNameLabel)
                    .addComponent(deleteWpsButton)
                    .addComponent(editWpsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wpsUriLabel)
                    .addComponent(addProcessToWpsButton))
                .addGap(18, 18, 18)
                .addComponent(WpsHeadlineSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteWpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteWpsButtonActionPerformed
        int option = JOptionPane.showConfirmDialog(parentRef,
                "Are you sure you want to permanently delete this WPS out of the Monitor?",
                "Delete WPS",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            parentRef.remove(this);
            parentRef.revalidate();
            parentRef.repaint(); // repaint required, otherwise the last element will not disappear
        }
    }//GEN-LAST:event_deleteWpsButtonActionPerformed

    private void addProcessToWpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessToWpsButtonActionPerformed
        wpsProcessDialog.setVisible(true);
    }//GEN-LAST:event_addProcessToWpsButtonActionPerformed

    private void editWpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWpsButtonActionPerformed
        new WpsEditDialog(mainFrame, this, true).setVisible(true);
    }//GEN-LAST:event_editWpsButtonActionPerformed

    public URI getWpsUri() {
        return wpsUri;
    }

    public void setWpsUri(URI wpsUri) {
        if (!this.wpsUri.equals(Param.notNull(wpsUri, "wpsUri"))) {
            this.wpsUri = wpsUri;
            this.wpsUriLabel.setText(wpsUri.toString());
        }
    }

    public void setWpsUri(String wpsUri) throws Exception {
        try {
            URL urlCheck = new URL(Param.notNull(wpsUri, "wpsUri"));
            URI uri = new URI(urlCheck.toString());

            this.setWpsUri(uri);
        } catch (MalformedURLException ex) {
            throw new Exception("The entered URÖ is not valid!");
        } catch (URISyntaxException ex) {
            throw new Exception("The entered URI is not valid!");
        }
    }

    public String getWpsName() {
        return wpsName;
    }

    public void setWpsName(String wpsName) throws Exception {
        if(!Param.notNull(wpsName, "wpsName").equals(this.wpsName)) {
        String tmpName = wpsName.trim();

        if (!tmpName.equals("")) {
            this.wpsName = tmpName;
            this.wpsNameLabel.setText(wpsName);
        } else {
            throw new Exception("WPS name should not be empty!");
        }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.wpsUri != null ? this.wpsUri.hashCode() : 0);
        hash = 97 * hash + (this.wpsName != null ? this.wpsName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WpsPanel other = (WpsPanel) obj;
        if (this.wpsUri != other.wpsUri && (this.wpsUri == null || !this.wpsUri.equals(other.wpsUri))) {
            return false;
        }
        if ((this.wpsName == null) ? (other.wpsName != null) : !this.wpsName.equals(other.wpsName)) {
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator WpsHeadlineSeperator;
    private javax.swing.JButton addProcessToWpsButton;
    private javax.swing.JButton deleteWpsButton;
    private javax.swing.JButton editWpsButton;
    private javax.swing.JLabel wpsNameLabel;
    private javax.swing.JLabel wpsUriLabel;
    // End of variables declaration//GEN-END:variables
}