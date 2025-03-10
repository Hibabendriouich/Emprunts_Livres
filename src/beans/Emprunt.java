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
    private Date date_emprunt;
    private Date date_retour;
    private Livre livre;
    private Etudiant etudiant;

    public Emprunt(Date date_emprunt, Date date_retour, Livre livre, Etudiant etudiant) {
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
        this.livre = livre;
        this.etudiant = etudiant;
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

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "date_emprunt=" + date_emprunt + ", date_retour=" + date_retour + ", livre=" + livre + ", etudiant=" + etudiant + '}';
    }

    
    
}
