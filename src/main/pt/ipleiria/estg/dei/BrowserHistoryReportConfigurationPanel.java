/*
 * Autopsy Forensic Browser
 *
 * Copyright 2012-2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.pt.ipleiria.estg.dei;

/**
 * The panel shown for all TableReportModules when configuring report modules.
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
public class BrowserHistoryReportConfigurationPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowserHistoryReportConfigurationPanel
     */
    public BrowserHistoryReportConfigurationPanel() {
        initComponents();
    }

    public boolean isMostVisitedSitesEnabled() {
        return mostVisitedSites.isSelected();
    }
    public boolean isBlokedSitesEnabled() {
        return blokedSites.isSelected();
    }
    public boolean isWordsSearchEnabled() {
        return wordsSearch.isSelected();
    }
    public boolean isDomainDailyVisitsEnabled() {
        return domainDailyVisits.isSelected();
    }

    public String getGraphType() {
        return buttonGroup2.getSelection().toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        histogram = new javax.swing.JRadioButton();
        barGraf = new javax.swing.JRadioButton();
        pieChart = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mostVisitedSites = new javax.swing.JCheckBox();
        blokedSites = new javax.swing.JCheckBox();
        wordsSearch = new javax.swing.JCheckBox();
        domainDailyVisits = new javax.swing.JCheckBox();

        setFont(getFont().deriveFont(getFont().getStyle() & ~java.awt.Font.BOLD, 11));

        jLabel2.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.jLabel2.text")); // NOI18N

        buttonGroup2.add(histogram);
        histogram.setSelected(true);
        histogram.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.histogram.text")); // NOI18N

        buttonGroup2.add(barGraf);
        barGraf.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.barGraf.text")); // NOI18N

        buttonGroup2.add(pieChart);
        pieChart.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.pieChart.text")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.jLabel1.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.jLabel3.text")); // NOI18N

        mostVisitedSites.setSelected(true);
        mostVisitedSites.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.mostVisitedSites.text")); // NOI18N

        blokedSites.setSelected(true);
        blokedSites.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.blokedSites.text")); // NOI18N
        blokedSites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blokedSitesActionPerformed(evt);
            }
        });

        wordsSearch.setSelected(true);
        wordsSearch.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.wordsSearch.text")); // NOI18N

        domainDailyVisits.setSelected(true);
        domainDailyVisits.setText(org.openide.util.NbBundle.getMessage(BrowserHistoryReportConfigurationPanel.class, "BrowserHistoryReportConfigurationPanel.domainDailyVisits.text")); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel3))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(histogram)
                            .addComponent(barGraf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pieChart, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(66, 66, 66)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostVisitedSites)
                            .addComponent(blokedSites)
                            .addComponent(wordsSearch)
                            .addComponent(domainDailyVisits))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(mostVisitedSites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blokedSites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wordsSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(domainDailyVisits))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(histogram)
                        .addGap(18, 18, 18)
                        .addComponent(barGraf)
                        .addGap(18, 18, 18)
                        .addComponent(pieChart)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void blokedSitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blokedSitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blokedSitesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton barGraf;
    private javax.swing.JCheckBox blokedSites;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox domainDailyVisits;
    private javax.swing.JRadioButton histogram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox mostVisitedSites;
    private java.awt.Panel panel1;
    private javax.swing.JRadioButton pieChart;
    private javax.swing.JCheckBox wordsSearch;
    // End of variables declaration//GEN-END:variables
}
