/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connexion.Connexion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class GraphiqueEmprunts extends JFrame {

    public GraphiqueEmprunts() {
        setTitle("Taux d'Emprunt par Catégorie");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JFreeChart chart = ChartFactory.createPieChart(
                "Taux d'Emprunt par Catégorie",
                getDataset(),
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultPieDataset getDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        try (Connection connexion = Connexion.getInstance().getCn()) {
            String sql = "SELECT categorie, COUNT(*) as total FROM livre GROUP BY categorie";
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String categorie = rs.getString("categorie");
                int total = rs.getInt("total");
                dataset.setValue(categorie, total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphiqueEmprunts frame = new GraphiqueEmprunts();
            frame.setVisible(true);
        });
    }
}
