/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.ECategorie;
import beans.Emprunt;
import beans.Etudiant;
import beans.Livre;
import java.util.Date;
import java.util.List;
import services.EmpruntService;
import services.EtudiantService;
import services.LivreService;

public class Test {

    public static void main(String[] args) {
        EtudiantService es = new EtudiantService();
        LivreService ls = new LivreService();
        EmpruntService emps = new EmpruntService();

        if (ls.findById(1) == null) {
            ls.create(new Livre("Not Without My Daughter", "Betty Mahmoudi", ECategorie.roman, true));
        }
        if (ls.findById(1) == null) {
            ls.create(new Livre("Le dernier jour d'un condamné", "Victor Hugo", ECategorie.roman, false));
        }
        if (ls.findById(1) == null) {
            ls.create(new Livre("La boîte à merveilles", "Ahmed Sefrioui", ECategorie.autobiographie, true));
        }

        es.create(new Etudiant("Bend", "Hiba", "b.hiba@gmail.com"));
        es.create(new Etudiant("Enns", "Fati", "e.fati@gmail.com"));
        es.create(new Etudiant("Abbadi", "Mery", "a.mery@gmail.com"));

        Livre livre = ls.findById(1);

        if (livre != null && livre.getDisponible()) {
            System.out.println("Livre trouvé: " + livre.getTitre() + " " + livre.getAuteur() + " " + livre.getCategorie());
        } else {
            System.out.println("Livre non trouvé ou emprunté!");
        }

        livre.setTitre("Not Without My Daughter");
        ls.update(livre);
        System.out.println("Titre mis à jour: " + ls.findById(1).getTitre());

        List<Livre> livres = ls.findAll();
        for (Livre l : livres) {
            System.out.println("- Titre: " + l.getTitre() + "\n" + "- Auteur: " + l.getAuteur() + "\n" + "- Catégorie: " + l.getCategorie());
        }

        Date dateEmprunt = new Date();
        Date dateRetour = new Date(dateEmprunt.getTime() + (7L * 24 * 60 * 60 * 1000)); // Il faut rendre le livre dans 7 jours

        emps.create(new Emprunt(dateEmprunt, dateRetour, ls.findById(1), es.findById(1)));
        emps.create(new Emprunt(dateEmprunt, dateRetour, ls.findById(2), es.findById(2)));

        List<Emprunt> emprunts = emps.findAll();
        for (Emprunt em : emprunts) {
            System.out.println("- Emprunts: " + em.getEtudiant().getNom() + "\n" + em.getEtudiant().getPrenom() + "\n" + em.getLivre().getTitre() + "\n" + em.getDateEmprunt() + " " + em.getDateRetour());
        }
        Emprunt empruntSuppr = emps.findAll().get(0);
        emps.delete(empruntSuppr);
        System.out.println("Emprunt supprimé: \n" + " -" + empruntSuppr.getEtudiant().getNom() + "\n -" + empruntSuppr.getLivre().getTitre());

        System.out.println("Liste des emprunts mise à jour: ");
        for (Emprunt emp : emps.findAll()) {
            System.out.println("Emprunt: " + emp.getEtudiant().getNom() + " -> " + emp.getLivre().getTitre());
        }

        Etudiant etudiant = es.findById(1);
        if (etudiant != null) {
            System.out.println("Étudiant existant: " + etudiant.getNom());
            etudiant.setNom("Bendriouich");
            es.update(etudiant);
            System.out.println("Nom mis à jour avec succès! -> " + es.findById(1).getNom());
        }

        List<Etudiant> etudiants = es.findAll();
        for (Etudiant e : etudiants) {
            System.out.println("- Nom: " + e.getNom() + "\n" + "- Prénom: " + e.getPrenom() + "\n" + "- Email: " + e.getEmail() + "\n");
        }

        livres = ls.rechercherLivreParAuteur("Victor Hugo");
        if (!livres.isEmpty()) {
            Livre rech = livres.get(0);
            System.out.println(rech.getTitre());
        } else {
            System.out.println("Aucun livre trouvé pour cet auteur.");
        }

        List<Emprunt> empruntsFiltrés = emps.findByBetweenDate(dateEmprunt, dateRetour);
        if (empruntsFiltrés.isEmpty()) {
            System.out.println("Aucun emprunt trouvé dans cette période.");
        } else {
            System.out.println("Liste des emprunts entre " + dateEmprunt + " et " + dateRetour + " :");
            for (Emprunt em : empruntsFiltrés) {
                System.out.println("- Étudiant: " + em.getEtudiant().getNom() + " " + em.getEtudiant().getPrenom());
                System.out.println("  Livre: " + em.getLivre().getTitre() + " De " + em.getLivre().getAuteur());
                System.out.println("  Date d'emprunt: " + em.getDateEmprunt() + " | Date de retour: " + em.getDateRetour());
            }
        }

    }
}
