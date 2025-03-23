/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connexion.Connexion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class GraphiqueEmprunts extends javax.swing.JInternalFrame {

    /**
     * Creates new form GraphiqueEmprunt
     */
    public GraphiqueEmprunts() {
        setTitle("Taux d'Emprunt par Catégorie");
        setSize(900, 800);
        setLocation(50, 50);

        JFreeChart chart = ChartFactory.createPieChart(
                "Taux d'Emprunt par Catégorie",
                getDataset(),
                true,
                true,
                false
        );
        customizeChart(chart);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        setResizable(true);
        setMaximizable(true);
        setClosable(true);
    }

    private DefaultPieDataset getDataset() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    Connection connexion = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        connexion = Connexion.getInstance().getCn();
        
        if (connexion == null || connexion.isClosed()) {
            System.out.println("Erreur : Connexion fermée !");
            return dataset; // Retourne un dataset vide pour éviter l'erreur
        }

        String sql = "SELECT categorie, COUNT(*) as total FROM livre GROUP BY categorie";
        stmt = connexion.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String categorie = rs.getString("categorie");
            int total = rs.getInt("total");
            dataset.setValue(categorie, total);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            // Ne pas fermer la connexion ici si elle doit être réutilisée
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return dataset;
}


    private void customizeChart(JFreeChart chart) {
        TextTitle title = new TextTitle("Taux d'Emprunt par Catégorie de Livres");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        title.setPaint(Color.BLUE);
        chart.setTitle(title);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(240, 240, 240));
        plot.setSectionPaint(0, new Color(255, 182, 193));
        plot.setSectionPaint(1, new Color(176, 224, 230));
        plot.setSectionPaint(2, new Color(255, 255, 204));
        plot.setSectionPaint(3, new Color(144, 238, 144)); // Pastel Green
        plot.setSectionPaint(4, new Color(255, 224, 178));
        plot.setLabelFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", 
                new java.text.DecimalFormat("0"), 
                new java.text.DecimalFormat("0%") 
        ));
        chart.getLegend().setBackgroundPaint(new Color(220, 220, 220));
        chart.getLegend().setItemFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(700, 800));

        jPanel1.setBackground(new java.awt.Color(215, 225, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
