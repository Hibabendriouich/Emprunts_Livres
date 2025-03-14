**Gestion des Emprunts de Livres**
Ce projet consiste à développer une application destinée aux bibliothèques ou institutions académiques afin de simplifier la gestion des prêts et retours de livres. L’objectif est de faciliter le suivi des emprunts et d’offrir une vision claire des tendances d’utilisation des livres.

Fonctionnalités Principales
1. Gestion des Livres
Ajout et suppression de livres.
2. Enregistrement des Emprunts.
3. Filtrage des Emprunts.
4. Recherche de Livres.
5. Visualisation des Données(graphique Pie Chart pour analyser le taux d’emprunt par catégorie de livre)

**Base de Données:**
Tables :
1. Livre:
**CREATE TABLE livre** (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(50) NOT NULL,
    auteur VARCHAR(50) NOT NULL,
    categorie ENUM('roman', 'nouvelle', 'autobiographie', 'policier', 'romance') NOT NULL,
    disponible TINYINT NOT NULL
);

2. Étudiant
**CREATE TABLE etudiant** (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

3. Emprunt
**CREATE TABLE emprunt** (
    idEtudiant INT NOT NULL,
    idLivre INT NOT NULL,
    dateEmprunt DATE NOT NULL,
    dateRetour DATE NOT NULL,
    PRIMARY KEY (idEtudiant, idLivre),
    FOREIGN KEY (idEtudiant) REFERENCES etudiant(id) ON DELETE CASCADE,
    FOREIGN KEY (idLivre) REFERENCES livre(id) ON DELETE CASCADE
);

**Technologies Utilisées:**
-NetBeans (Java) : Pour le développement de l’application.
-MySQL : Pour la gestion de la base de données.
-SWING : Pour l'interface graphique et rendre l’application facile à utiliser.

