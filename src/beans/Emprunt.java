/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.Date;

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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
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
        return " - Date Emprunt: " + dateEmprunt + "\n"+ " - Date Retour: " + dateRetour+ "\n" + " - Livre: " + livre.getTitre()+ "\n" + " - Etudiant=" + etudiant.getNom() + etudiant.getPrenom();
    }

    
    
}
