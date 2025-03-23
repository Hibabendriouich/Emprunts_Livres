/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Livre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.LivreService;

public class RechercheLivreAuteurForm extends javax.swing.JInternalFrame {

    private LivreService ls;
    private DefaultTableModel model;

    /**
     * Creates new form RechercheLivreAuteur
     */
    public RechercheLivreAuteurForm() {
        MDIApplication app = MDIApplication.getInstance();
        initComponents();
        ls = new LivreService();

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Titre", "Auteur", "Catégorie"
                }
        );

        tableRecherche.setModel(model);
        load();

    }

    private void load() {
        List<Livre> livres = ls.findAll();

        model.setRowCount(0);
        for (Livre livre : livres) {
            model.addRow(new Object[]{
                livre.getTitre(),
                livre.getAuteur(),
                livre.getCategorie().name()
            });
        }

        if (livres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun livre trouvé.", "Information", JOptionPane.INFORMATION_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        txtRechercherAuteur = new javax.swing.JLabel();
        txtAuteurRechercher = new javax.swing.JTextField();
        btnRechercherLivre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRecherche = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel1.setBackground(new java.awt.Color(242, 245, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche des livres par auteurs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRechercherAuteur.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtRechercherAuteur.setForeground(new java.awt.Color(250, 239, 223));
        txtRechercherAuteur.setText("Auteur: ");
        jPanel1.add(txtRechercherAuteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 143, -1));
        jPanel1.add(txtAuteurRechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, 30));

        btnRechercherLivre.setBackground(new java.awt.Color(0, 153, 255));
        btnRechercherLivre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRechercherLivre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chercher-50 (1) (1).png"))); // NOI18N
        btnRechercherLivre.setText("Rechercher");
        btnRechercherLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherLivreActionPerformed(evt);
            }
        });
        jPanel1.add(btnRechercherLivre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 37, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/auteur.PNG"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(242, 245, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des livres résultants de la recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        tableRecherche.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableRecherche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre", "Auteur", "Catégorie"
            }
        ));
        jScrollPane1.setViewportView(tableRecherche);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRechercherLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherLivreActionPerformed
        String auteurRecherche = txtAuteurRechercher.getText().trim();

        if (auteurRecherche.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nom d'auteur.", "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Livre> livresTrouves = ls.rechercherLivreParAuteur(auteurRecherche);

        model.setRowCount(0);

        for (Livre livre : livresTrouves) {
            model.addRow(new Object[]{
                livre.getTitre(),
                livre.getAuteur(),
                livre.getCategorie().name()
            });
        }

        if (livresTrouves.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun livre trouvé pour cet auteur.", "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRechercherLivreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRechercherLivre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRecherche;
    private javax.swing.JTextField txtAuteurRechercher;
    private javax.swing.JLabel txtRechercherAuteur;
    // End of variables declaration//GEN-END:variables
}
