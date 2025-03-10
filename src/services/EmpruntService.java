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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lewey
 */
public class EmpruntService implements IDao<Emprunt> {
    private Connexion connexion;
    private EtudiantService e;
    private LivreService l;

    public EmpruntService() {
        connexion= Connexion.getInstance();
        e =new EtudiantService();
        l = new LivreService();
    }

    
    
    @Override
public boolean create(Emprunt o) {
    String req = "INSERT INTO Emprunt (id_livre, id_etudiant, date_emprunt, date_retour) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, o.getLivre().getId()); 
        ps.setInt(2, o.getEtudiant().getId()); 
        ps.setDate(3, new java.sql.Date(o.getDate_emprunt().getTime())); 
        ps.setDate(4, new java.sql.Date(o.getDate_retour().getTime())); 
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return false;
}

    @Override
    public boolean delete(Emprunt o) {
        String req = "delete from Emprunt WHERE id_livre = ? and id_etudiant=?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1,o.getLivre().getId());  
            ps.setInt(2,o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Emprunt o) {
        String req = "update Emprunt set date_emprunt = ?, date_retour = ?, WHERE id_livre = ? and id_etudiant";
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
    public Emprunt findById(int id) {
        return null; //on ne peut pas appliquer cette méthode vu qu'on a pas d'id dans la classe d'association
    }

    @Override
    public List<Emprunt> findAll() {
        List<Emprunt> inscriptions = new ArrayList<>();
        String req = "select * from Emprunt";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre livre = l.findById(rs.getInt("id_livre"));
                Etudiant etudiant = e.findById(rs.getInt("id_etudiant"));
                Date dateEmprunt = rs.getDate("date_emprunt");
                Date dateRetour = rs.getDate("date_retour");

            inscriptions.add(new Emprunt(dateEmprunt, dateRetour, livre, etudiant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }
}
