/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import beans.Livre;
import beans.Etudiant;
import beans.Emprunt;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lewey
 */
public class EmpruntService implements IDao<Emprunt> {
    private Connexion connexion;

    public EmpruntService(Connexion connexion) {
        this.connexion = connexion;
    }
    

    @Override
    public boolean create(Emprunt o) {
        String req = "INSERT INTO Emprunt (date_emprunt, date_retour, livre, etudiant) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDate_emprunt().getTime()));
            ps.setDate(2, new java.sql.Date(o.getDate_retour().getTime()));   
            ps.setInt(3, o.getLivre().getId());   
            ps.setInt(4, o.getEtudiant().getId()); 
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Emprunt o) {
        String req = "DELETE FROM Emprunt WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());  
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Emprunt o) {
        String req = "UPDATE Emprunt SET date_emprunt = ?, date_retour = ?, livre = ?, etudiant = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDate_emprunt().getTime()));  
            ps.setDate(2, new java.sql.Date(o.getDate_retour().getTime()));   
            ps.setInt(3, o.getLivre().getId());    
            ps.setInt(4, o.getEtudiant().getId()); 
            ps.setInt(5, o.getId()); 
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Emprunt findById(int id) {
        String req = "SELECT * FROM Emprunt WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Livre livre = new LivreService().findById(rs.getInt("livre")); 
                Etudiant etudiant = new EtudiantService().findById(rs.getInt("etudiant")); 
                return new Emprunt(rs.getInt("id"), rs.getDate("date_emprunt"), rs.getDate("date_retour"), livre, etudiant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Emprunt> findAll() {
        List<Emprunt> emprunts = new ArrayList<>();
        String req = "SELECT * FROM Emprunt";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre livre = new LivreService().findById(rs.getInt("livre"));
                Etudiant etudiant = new EtudiantService().findById(rs.getInt("etudiant"));
                emprunts.add(new Emprunt(rs.getInt("id"), rs.getDate("date_emprunt"), rs.getDate("date_retour"), livre, etudiant));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emprunts;
    }
}