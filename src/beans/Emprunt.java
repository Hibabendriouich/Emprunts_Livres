/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.Date;

/**
 *
 * @author Lewey
 */
public class Emprunt {
    private int id;
    private Date date_emprunt;
    private Date date_retour;
    private int id_livre;
    private int id_etudiant;

    public Emprunt(int id, Date date_emprunt, Date date_retour, int id_livre, int id_etudiant) {
        this.id = id;
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
        this.id_livre = id_livre;
        this.id_etudiant = id_etudiant;
    }

    public Emprunt(Date date_emprunt, Date date_retour, int id_livre, int id_etudiant) {
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
        this.id_livre = id_livre;
        this.id_etudiant = id_etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "id=" + id + ", date_emprunt=" + date_emprunt + ", date_retour=" + date_retour + ", id_livre=" + id_livre + ", id_etudiant=" + id_etudiant + '}';
    }
    
    
    
}
