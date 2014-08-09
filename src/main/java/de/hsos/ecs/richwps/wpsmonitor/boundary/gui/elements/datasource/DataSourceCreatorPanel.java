/*
 * Copyright 2014 Florian Vogelpohl <floriantobias@gmail.com>.
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
package de.hsos.ecs.richwps.wpsmonitor.boundary.gui.elements.datasource;

import de.hsos.ecs.richwps.wpsmonitor.boundary.gui.datasource.DataSource;
import de.hsos.ecs.richwps.wpsmonitor.boundary.gui.datasource.DataSourceCreator;
import de.hsos.ecs.richwps.wpsmonitor.boundary.gui.datasource.DataSourceException;
import de.hsos.ecs.richwps.wpsmonitor.boundary.gui.utils.MessageDialogs;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * Panel which representate a DataSourceCreator instance. Through this panel new
 * DataSource instances can be created.
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class DataSourceCreatorPanel extends JPanel {

    private final DataSourceDialog parent;
    private final DataSourceCreator driver;

    /**
     * Creates new form DataSourceCreatorPanel
     *
     * @param parent Reference to the parent frame
     * @param driver Driver instance which should cares of
     */
    public DataSourceCreatorPanel(final DataSourceDialog parent, final DataSourceCreator driver) {
        this.parent = parent;
        this.driver = driver;

        initComponents();
        init();
    }

    private void init() {
        drivername.setText(driver.getCreatorName());
        expectedType.setText(driver.getExpectedResourceType());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        drivername = new JLabel();
        addSourceButton = new JButton();
        resourceField = new JTextField();
        expectedType = new JLabel();

        setMaximumSize(new Dimension(32767, 163));

        jPanel1.setBorder(BorderFactory.createTitledBorder("Driver"));

        drivername.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        drivername.setIcon(new ImageIcon(getClass().getResource("/icons/database-connect.png"))); // NOI18N
        drivername.setText("jLabel2");

        addSourceButton.setIcon(new ImageIcon(getClass().getResource("/icons/database-add.png"))); // NOI18N
        addSourceButton.setText("Create new Data Source");
        addSourceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addSourceButtonActionPerformed(evt);
            }
        });

        resourceField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addSourceButtonActionPerformed(evt);
            }
        });

        expectedType.setText("jLabel1");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(addSourceButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(drivername)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(expectedType)
                        .addGap(18, 18, 18)
                        .addComponent(resourceField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drivername)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(expectedType)
                    .addComponent(resourceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSourceButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addSourceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addSourceButtonActionPerformed
        String resource = resourceField.getText();

        try {
            DataSource dataSource = driver.create(resource);
            parent.addDataSource(dataSource);

            resourceField.setText("");
        } catch (DataSourceException ex) {
            MessageDialogs.showError(this, "Error", ex.toString());
        }
    }//GEN-LAST:event_addSourceButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addSourceButton;
    private JLabel drivername;
    private JLabel expectedType;
    private JTextField resourceField;
    // End of variables declaration//GEN-END:variables
}
