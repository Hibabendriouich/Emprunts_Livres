/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.ECategorie;
import beans.Livre;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreService implements IDao<Livre> {

    private Connexion connexion;

    public LivreService() {
        connexion = Connexion.getInstance();
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("Erreur de connexion à la base de données !");
        } else {
            System.out.println("Connexion réussie !");
        }
    }

    public List<Livre> rechercherLivreParAuteur(String auteur) {
        List<Livre> livres = new ArrayList<>();

        if (auteur == null || auteur.isEmpty()) {
            System.out.println("Auteur invalide.");
            return livres;
        }

        String req = "SELECT * FROM livre WHERE auteur = ?";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, auteur);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    livres.add(new Livre(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            ECategorie.valueOf(rs.getString("categorie")),
                            rs.getBoolean("disponible")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
            ex.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Catégorie inconnue détectée dans la base de données.");
            e.printStackTrace();
        }

        return livres;
    }

    @Override
    public boolean create(Livre o) {
        String req = "insert into Livre (id, titre, auteur, categorie, disponible) values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAuteur());
            ps.setString(3, o.getCategorie().name());
            ps.setBoolean(4, o.isDisponible());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Livre o) {
        String req = "delete from Livre where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Livre o) {
        String req = "update Livre set titre = ?, auteur = ?, categorie = ?, disponible = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAuteur());
            ps.setString(3, o.getCategorie().name());
            ps.setBoolean(4, o.isDisponible());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Livre findById(int id) {
        String req = "select * from Livre where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), ECategorie.valueOf(rs.getString("categorie")), rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Livre> findAll() {
        List<Livre> livres = new ArrayList<>();
        String req = "select * from Livre";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                livres.add(new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), ECategorie.valueOf(rs.getString("categorie")), rs.getBoolean("disponible")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return livres;
    }
}
