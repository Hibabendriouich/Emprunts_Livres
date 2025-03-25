/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connexion.Connexion;
import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import java.text.DecimalFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class GraphiqueEmprunts extends JInternalFrame {
    private DefaultPieDataset dataset;
    private JFreeChart pieChart;

    public GraphiqueEmprunts() {
        super("Taux d'Emprunt par Catégorie", true, true, true, true);
        setSize(700, 500);
        setLayout(new BorderLayout());

        dataset = getDataset();
        pieChart = ChartFactory.createPieChart("Taux d'Emprunt par Catégorie", dataset, true, true, false);
        customizeChart(pieChart);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(600, 400));

        add(chartPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private DefaultPieDataset getDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        try (Connection connexion = Connexion.getInstance().getCn();
             PreparedStatement stmt = connexion.prepareStatement("SELECT l.categorie, COUNT(*) as total FROM emprunt e JOIN livre l ON e.idLivre = l.id GROUP BY l.categorie");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String categorie = rs.getString("categorie");
                int total = rs.getInt("total");
                dataset.setValue(categorie, total);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des données : " + e.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

        // Couleurs des sections
        Color[] colors = {
            new Color(255, 182, 193),  // Rose pastel
            new Color(176, 224, 230),  // Bleu pastel
            new Color(255, 255, 204),  // Jaune clair
            new Color(144, 238, 144),  // Vert clair
            new Color(255, 224, 178)   // Orange pastel
        };

        int i = 0;
        for (Object key : dataset.getKeys()) {
             plot.setSectionPaint((Comparable<?>) key, colors[i % colors.length]);
            i++;
        }

        plot.setLabelFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})",
                new DecimalFormat("0"),
                new DecimalFormat("0%")
        ));

        chart.getLegend().setBackgroundPaint(new Color(220, 220, 220));
        chart.getLegend().setItemFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graphique des Emprunts");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            GraphiqueEmprunts graphique = new GraphiqueEmprunts();
            frame.add(graphique, BorderLayout.CENTER);

            frame.setVisible(true);
        });
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
