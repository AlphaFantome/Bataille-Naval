/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.*;

/**
 *
 * @author admin
 */
public class SousMarin extends Bateaux {

/// constructeur du Sous-marin 
    /**
     * 
     * @param plateau
     * @param nomBateau 
     */
    public SousMarin(String[][] plateau, String nomBateau) {

        nom = nomBateau;
        taille = 1;
        vie = 1;
        special = true;
        puissanceTir = 1;

        /// determination du sens du bateau  
        double aleatoire;
        aleatoire = Math.random() * (2);

        if (aleatoire == 0) {
            sens = 'H';
        } else {
            sens = 'V';
        }

        /// blindage du sens du bateau 
        /// les variables x et y nous servent a determiner aleatoirement la position du bateau
        int x;
        int y;

        /// les booleans nous permettront de tester les differentes conditions a respecter 
        /// on peut ensuite sortir de la boucle quand tous les booleans sont true 
        boolean bool_limite;
        boolean bool_libre;
        do {
            bool_limite = true;
            bool_libre = true;
            /// on attribue aleatoirement les valeurs de la coordonnee initiale
            x = (int) (Math.random() * (14 - 0) + 1);
            y = (int) (Math.random() * (14 - 0) + 1);

            /// probleme de depassement de la grille
            /// pour le sens horizontal 
            if (sens == 'V') {

                /// on vérifie que la taille ne depasse pas du plateau 
                if ((x) > 14) {
                    bool_limite = false;
                }
            } /// pour le sens horizontal 
            else if (sens == 'H') {

                /// on verifie que la taille ne depasse pas du plateau 
                if ((y) > 14) {
                    bool_limite = false;
                }
            }
            /// fin du probleme de depassement de la grille 

            /// probleme de savoir si la grille est deja remplie
            /// pour le sens horizontal 
            if (bool_limite == true) {
                if (sens == 'H') {

                    if (!"  ".equals(plateau[x][y])) {
                        bool_libre = false;
                    }

                }

                /// pour le sens vertical 
                if (sens == 'V') {

                    if (!"  ".equals(plateau[x][y])) {

                        bool_libre = false;
                    }

                }
            }

        } while ((bool_limite == false) || (bool_libre == false));
        /// fin de la verification que la grille soit remplie 

        /// si on arrive ici toutes les condtitions pour pouvoir placer le bateau son respectées 
        /// on instancie les coordonnees de la premiere case du tableau 
        plateau[x][y] = nom;
    }
/**
 * 
 * @param plateauJoueur
 * @param numeroJoueur
 * @return 
 */
    @Override
    public boolean deplacer(String[][] plateauJoueur, int numeroJoueur) {
        int choix = 0;
        Scanner move = new Scanner(System.in);
        boolean deplacement = true;
        int x = -1;
        int y = -1;

        /// on recupere les coordonnees de la premiere case du bateau selectionne
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (plateauJoueur[i][j].equals(nom)) {
                    x = i;
                    y = j;
                    i = 15;
                    j = 15;
                }
            }
        }

        do {
            //1 le joueur joue, 2 l'AI joue
            if (numeroJoueur == 1) {
                System.out.println("Choissisez un déplacement");
                System.out.println("1-Gauche");
                System.out.println("2-Droite");
                System.out.println("3-Haut");
                System.out.println("4-Bas");

                choix = move.nextInt();
            }
            if (numeroJoueur == 2) {
                choix = (int) (Math.random() * (2) + 1);
                if (choix == 1) {
                    System.out.print(" vers la Gauche\n");
                }
                if (choix == 2) {
                    System.out.print(" vers la Droite\n");
                }
                if (choix == 3) {
                    System.out.print(" vers la Haut\n");
                }
                if (choix == 4) {
                    System.out.print(" vers la Bas\n");
                }
            }

            /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
            if (choix == 1 && (y - 1) >= 0) {
                if ("  ".equals(plateauJoueur[x][y - 1])) {
                    /// on décale chaque case du bateau vers la gauche                            
                    plateauJoueur[x][y - 1] = nom;

                    /// nous permet de remettre "  " pour le nom de la derniere case 
                    plateauJoueur[x][y] = "  ";

                }
                else 
                deplacement = false;
            } else if (choix == 2 && (y + 1) <= 14) {
                if ("  ".equals(plateauJoueur[x][y + 1])) {

                    plateauJoueur[x][y + 1] = nom;

                    /// nous permet de remettre "  " pour le nom de la derniere case 
                    plateauJoueur[x][y] = "  ";
                }

                else 
                  deplacement = false;
            } /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
            else if (choix == 3 && (x - 1) >= 0) {
                if ("  ".equals(plateauJoueur[x - 1][y])) {

                    plateauJoueur[x - 1][y] = nom;

                    /// nous permet de remettre "  " pour le nom de la derniere case 
                    plateauJoueur[x][y] = "  ";
                }
                else 
                deplacement = false;
            } else if (choix == 4 && (x + 1) <= 14) {
                if ("  ".equals(plateauJoueur[x + 1][y])) {
                    plateauJoueur[x + 1][y] = nom;

                    /// nous permet de remettre "  " pour le nom de la derniere case 
                    plateauJoueur[x][y] = "  ";
                }
            } else if (choix != 1 && choix != 2 && choix != 3 && choix != 4) {
                System.out.println(" Choix =  " + choix);
                System.out.println(" Veuillez choisir l une des 4 options ");
            } else {
                System.out.println(" Le deplacement n a pas ete effectue car un bateau bloque ou le bateau sortirait de la grille ");
                System.out.println(" Vous allez retournez a la selection de bateaux ");
                deplacement = false;
            }

            if (deplacement == false) {
                choix = 1;
            }

        } while (choix != 1 && choix != 2 && choix != 3 && choix != 4);

        return deplacement;
    }

}
