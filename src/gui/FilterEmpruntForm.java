/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Emprunt;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.EmpruntService;

public class FilterEmpruntForm extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    private EmpruntService emps;

    /**
     * Creates new form FilterEmpruntForm
     */
    public FilterEmpruntForm() {
        MDIApplication app = MDIApplication.getInstance();
        initComponents();
        JDateChooser dateDebutPicker = new JDateChooser();
        dateDebutPicker.setDateFormatString("yyyy-MM-dd");
        JDateChooser dateFinPicker = new JDateChooser();
        dateFinPicker.setDateFormatString("yyyy-MM-dd");
        model = (DefaultTableModel) listEmprunt.getModel();
    }

    private void loadEmpruntsParDate(Date dateDebut, Date dateFin) {
        List<Emprunt> emprunts = new EmpruntService().findByBetweenDate(dateDebut, dateFin);
        model.setRowCount(0);

        for (Emprunt emprunt : emprunts) {
            model.addRow(new Object[]{
                emprunt.getLivre().getTitre(),
                emprunt.getEtudiant().getNom(),
                emprunt.getEtudiant().getPrenom(),
                emprunt.getDateEmprunt(),
                emprunt.getDateRetour()
            });
        }

        if (emprunts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun emprunt trouvé dans cette période.", "Information", JOptionPane.INFORMATION_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dateDebutPicker = new com.toedter.calendar.JDateChooser();
        txtDateDebut = new javax.swing.JLabel();
        txtDateFin = new javax.swing.JLabel();
        dateFinPicker = new com.toedter.calendar.JDateChooser();
        btnFiltrerParDate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEmprunt = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel1.setBackground(new java.awt.Color(242, 245, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtre Emprunts par Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        txtDateDebut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDateDebut.setText("Date Début:");

        txtDateFin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDateFin.setText("Date Fin:");

        btnFiltrerParDate.setBackground(new java.awt.Color(0, 153, 255));
        btnFiltrerParDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFiltrerParDate.setText("Filtrer");
        btnFiltrerParDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrerParDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateDebut)
                    .addComponent(txtDateFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateDebutPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(dateFinPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(btnFiltrerParDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtDateDebut)
                        .addGap(29, 29, 29)
                        .addComponent(txtDateFin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(dateDebutPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateFinPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFiltrerParDate)
                .addGap(38, 38, 38))
        );

        jPanel2.setBackground(new java.awt.Color(242, 245, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des emprunts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        listEmprunt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listEmprunt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre du livre", "Nom Etudiant", "Prénom Etudiant", "Date de l'Emprunt", "Date de Retour"
            }
        ));
        jScrollPane2.setViewportView(listEmprunt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrerParDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrerParDateActionPerformed
        Date dateDebut = dateDebutPicker.getDate();
        Date dateFin = dateFinPicker.getDate();
        if (dateDebut == null || dateFin == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner des dates valides.", "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (dateDebut.after(dateFin)) {
            JOptionPane.showMessageDialog(this, "La date de début doit être avant la date de fin.", "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }
        loadEmpruntsParDate(dateDebut, dateFin);
    }//GEN-LAST:event_btnFiltrerParDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrerParDate;
    private com.toedter.calendar.JDateChooser dateDebutPicker;
    private com.toedter.calendar.JDateChooser dateFinPicker;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable listEmprunt;
    private javax.swing.JLabel txtDateDebut;
    private javax.swing.JLabel txtDateFin;
    // End of variables declaration//GEN-END:variables
}
