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
    private Date dateEmprunt;
    private Date dateRetour;
    private Livre livre;
    private Etudiant etudiant;

    public Emprunt(Date dateEmprunt, Date dateRetour, Livre livre, Etudiant etudiant) {
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.livre = livre;
        this.etudiant = etudiant;
    }

    public Date getDate_emprunt() {
        return dateEmprunt;
    }

    public void setDate_emprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDate_retour() {
        return dateRetour;
    }

    public void setDate_retour(Date dateRetour) {
        this.dateRetour = dateRetour;
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
        return "Emprunt{" + "dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + ", livre=" + livre + ", etudiant=" + etudiant + '}';
    }

    
    
}
