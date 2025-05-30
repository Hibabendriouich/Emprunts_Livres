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
        jLabel1 = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(242, 245, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtre Emprunts par Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(dateDebutPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 158, 28));

        txtDateDebut.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtDateDebut.setForeground(new java.awt.Color(247, 241, 222));
        txtDateDebut.setText("Date Début:");
        jPanel1.add(txtDateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtDateFin.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtDateFin.setForeground(new java.awt.Color(247, 241, 222));
        txtDateFin.setText("Date Fin:");
        jPanel1.add(txtDateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel1.add(dateFinPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 158, 28));

        btnFiltrerParDate.setBackground(new java.awt.Color(0, 153, 255));
        btnFiltrerParDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFiltrerParDate.setText("Filtrer");
        btnFiltrerParDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrerParDateActionPerformed(evt);
            }
        });
        jPanel1.add(btnFiltrerParDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dateemp.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 490, 210));

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
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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
    private javax.swing.JLabel jLabel1;
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
