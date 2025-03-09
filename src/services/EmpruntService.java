/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
        String req="insert into Emprunt (id, date_emprunt, date_retour, id_livre, id_etudiant) values (null,?,?,?,?)";
        try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);

        ps.setDate(1, new java.sql.Date(o.getDate_emprunt().getTime()));
        ps.setDate(2, new java.sql.Date(o.getDate_retour().getTime()));   
        ps.setInt(3, o.getId_livre());                               
        ps.setInt(4, o.getId_etudiant());                            

        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return false;
}

    @Override
public boolean delete(Emprunt o) {
    String req = "delete from Emprunt where id_livre = ? and id_etudiant = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, o.getId_livre());  
        ps.setInt(2, o.getId_etudiant()); 
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return false;
}


    @Override
public boolean update(Emprunt o) {
    String req = "update Emprunt set date_emprunt = ?, date_retour = ?, id_livre = ?, id_etudiant = ? where id = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setDate(1, new java.sql.Date(o.getDate_emprunt().getTime()));  
        ps.setDate(2, new java.sql.Date(o.getDate_retour().getTime()));   
        ps.setInt(3, o.getId_livre());                                   
        ps.setInt(4, o.getId_etudiant());                                
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
    String req = "select * from Emprunt where id = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, id); 
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Emprunt( rs.getInt("id"), rs.getDate("date_emprunt"), rs.getDate("date_retour"), rs.getInt("id_livre"), rs.getInt("id_etudiant") );
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
}

    @Override
public List<Emprunt> findAll() {
    List<Emprunt> emprunts = new ArrayList<>();
    String req = "select * from Emprunt";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            emprunts.add(new Emprunt( rs.getInt("id"), rs.getDate("date_emprunt"), rs.getDate("date_retour"), rs.getInt("id_livre"), rs.getInt("id_etudiant")));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return emprunts;
}}


   
