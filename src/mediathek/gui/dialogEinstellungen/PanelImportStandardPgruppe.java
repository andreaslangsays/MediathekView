/*    
 *    MediathekView
 *    Copyright (C) 2012   W. Xaver
 *    W.Xaver[at]googlemail.com
 *    http://zdfmediathk.sourceforge.net/
 *    
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mediathek.gui.dialogEinstellungen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mediathek.Konstanten;
import mediathek.Log;
import mediathek.daten.DDaten;
import mediathek.gui.PanelVorlage;
import mediathek.gui.beobachter.BeobWeb;
import mediathek.tool.GuiFunktionen;
import mediathek.tool.GuiFunktionenProgramme;

public class PanelImportStandardPgruppe extends PanelVorlage {

    public PanelImportStandardPgruppe(DDaten d) {
        super(d);
        initComponents();
        init();
    }

    private void init() {
        jButtonUrl.addActionListener(new BeobWeb(Konstanten.ADRESSE_VLC));
        jTextFieldVlcGefunden.setText(GuiFunktionenProgramme.getPfadVlc());
        if (jTextFieldVlcGefunden.getText().equals("")) {
            jRadioButtonVlcManuell.setSelected(true);
        } else {
            jRadioButtonVlcAuto.setSelected(true);
        }
        jButtonPfad.addActionListener(new BeobPfad(jTextFieldAuswaehlen));
        jButtonZielpfad.addActionListener(new BeobPfad(jTextFieldZielpfad));
        jTextFieldZielpfad.setText(GuiFunktionen.getHomePath());
        jButtonErneut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldVlcGefunden.setText(GuiFunktionenProgramme.getPfadVlc());
            }
        });
        jButtonUebernehmen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                uebernehmen();
            }
        });
    }

    private void uebernehmen() {
        if (pruefen()) {
            GuiFunktionenProgramme.addStandardprogramme(ddaten,
                    jRadioButtonVlcAuto.isSelected() ? jTextFieldVlcGefunden.getText() : jTextFieldAuswaehlen.getText(),
                    jTextFieldZielpfad.getText());
        }
    }

    private boolean pruefen() {
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanelGefunden = new javax.swing.JPanel();
        jTextFieldVlcGefunden = new javax.swing.JTextField();
        jButtonErneut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldAuswaehlen = new javax.swing.JTextField();
        jButtonPfad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonUrl = new javax.swing.JButton();
        jRadioButtonVlcAuto = new javax.swing.JRadioButton();
        jRadioButtonVlcManuell = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldZielpfad = new javax.swing.JTextField();
        jButtonZielpfad = new javax.swing.JButton();
        jButtonUebernehmen = new javax.swing.JButton();

        jPanelGefunden.setBorder(javax.swing.BorderFactory.createTitledBorder("Der VLC-Player wurde gefunden"));

        jTextFieldVlcGefunden.setEditable(false);

        jButtonErneut.setText("erneut suchen");

        javax.swing.GroupLayout jPanelGefundenLayout = new javax.swing.GroupLayout(jPanelGefunden);
        jPanelGefunden.setLayout(jPanelGefundenLayout);
        jPanelGefundenLayout.setHorizontalGroup(
            jPanelGefundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGefundenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGefundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVlcGefunden)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGefundenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonErneut)))
                .addContainerGap())
        );
        jPanelGefundenLayout.setVerticalGroup(
            jPanelGefundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGefundenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldVlcGefunden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonErneut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGefundenLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonErneut, jTextFieldVlcGefunden});

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pfad zum VLC-Player auswählen"));

        jButtonPfad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediathek/res/fileopen_16.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldAuswaehlen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPfad)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPfad)
                    .addComponent(jTextFieldAuswaehlen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonPfad, jTextFieldAuswaehlen});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("VLC von der Website laden und installieren:");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 255));
        jTextField1.setText("http://www.videolan.org/");
        jTextField1.setBorder(null);

        jButtonUrl.setText("im Browser öffnen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButtonUrl))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUrl))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonUrl, jTextField1});

        buttonGroup1.add(jRadioButtonVlcAuto);

        buttonGroup1.add(jRadioButtonVlcManuell);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonVlcAuto)
                            .addComponent(jRadioButtonVlcManuell))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelGefunden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGefunden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonVlcAuto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonVlcManuell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("VLC-Player", jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Zielpfad in dem die Filme gespeichert werden"));

        jButtonZielpfad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediathek/res/fileopen_16.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldZielpfad, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonZielpfad)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonZielpfad)
                    .addComponent(jTextFieldZielpfad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonZielpfad, jTextFieldZielpfad});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Zielpfad", jPanel4);

        jButtonUebernehmen.setText("Einstellungen übernehmen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUebernehmen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUebernehmen)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonErneut;
    private javax.swing.JButton jButtonPfad;
    private javax.swing.JButton jButtonUebernehmen;
    private javax.swing.JButton jButtonUrl;
    private javax.swing.JButton jButtonZielpfad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelGefunden;
    private javax.swing.JRadioButton jRadioButtonVlcAuto;
    private javax.swing.JRadioButton jRadioButtonVlcManuell;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAuswaehlen;
    private javax.swing.JTextField jTextFieldVlcGefunden;
    private javax.swing.JTextField jTextFieldZielpfad;
    // End of variables declaration//GEN-END:variables

    private class BeobPfadDoc implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent arg0) {
            eingabe();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
            eingabe();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
            eingabe();
        }

        private void eingabe() {
//            jButtonImportDatei.setEnabled(!jTextFieldAuswaehlen.getText().equals(""));
//            if (jTextFieldAuswaehlen.getText().equals("")) {
//                jTextFieldAuswaehlen.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.background"));
//            } else {
//                if (IoXmlLesen.importPgruppe(jTextFieldAuswaehlen.getText(), false) != null) {
//                    jTextFieldAuswaehlen.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.background"));
//                } else {
//                    jTextFieldAuswaehlen.setBackground(new Color(255, 200, 200));
//                }
//            }
        }
    }

    private class BeobPfad implements ActionListener {

        private JTextField textField;

        public BeobPfad(JTextField ttextField) {
            textField = ttextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal;
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setFileHidingEnabled(false);
            if (textField.getText().equals("")) {
                chooser.setCurrentDirectory(new File(GuiFunktionen.getHomePath()));
            } else {
                chooser.setCurrentDirectory(new File(textField.getText()));
            }
            returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    textField.setText(chooser.getSelectedFile().getAbsolutePath());
                } catch (Exception ex) {
                    Log.fehlerMeldung("PanelImportStandardProgramme.BeobPfad", ex);
                }
            }
        }
    }
}