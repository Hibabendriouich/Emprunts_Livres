/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class Livre {

    private int id;
    private String titre;
    private String auteur;
    private ECategorie categorie;
    private Boolean disponible;

    public Livre(int id, String titre, String auteur, ECategorie categorie, Boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }

    public Livre(String titre, String auteur, ECategorie categorie, Boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public ECategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ECategorie categorie) {
        this.categorie = categorie;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        if (getDisponible()) {
            return id + ": " + titre + " De " + auteur + " " + categorie + "  Disponible";

        } else {
            return id + ": " + titre + " De " + auteur + " " + categorie + "  N'est pas disponible";
        }
    }

}
