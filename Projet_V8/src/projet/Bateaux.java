/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.*;
import java.io.*;

/**
 *
 * @author admin
 */
public abstract class Bateaux implements Serializable {

    public int taille;
    public int vie;
    public String nom;
    public char sens;
    public boolean special;
    public int puissanceTir;

    Couleur color = new Couleur();

    public boolean deplacer(String[][] plateauJoueur, int numeroJoueur) {
        int choix = 0;
        Scanner move = new Scanner(System.in);
        boolean deplacement = true;
        int x = -1;
        int y = -1;
        if(vie==taille)
        {
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
            if (sens == 'H') {
                if (numeroJoueur == 1) {
                    System.out.println("Choissisez un déplacement");
                    System.out.println("1-Gauche");
                    System.out.println("2-Droite");

                    choix = move.nextInt();
                }

                if (numeroJoueur == 2) {
                    choix = (int) (Math.random() * (2) + 1);
                    if(choix==1)
                    {
                        System.out.print(" vers la Gauche\n");
                    }
                    if(choix==2)
                    {
                        System.out.print(" vers la Droite\n");
                    }
                }
                /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
                if (choix == 1 && (y - 1) >= 0) {
                    if ("  ".equals(plateauJoueur[x][y - 1])) {
                        /// on décale chaque case du bateau vers la gauche 
                        for (int i = y; i < y + taille; i++) {
                            plateauJoueur[x][i - 1] = nom;

                            /// nous permet de remettre "  " pour le nom de la derniere case 
                            if (i == (y + taille - 2)) {
                                plateauJoueur[x][i + 1] = "  ";
                            }
                        }
                    } else {
                        deplacement = false;
                    }
                } else if (choix == 2 && (y + taille + 1) <= 14) {
                    if ("  ".equals(plateauJoueur[x][y + taille + 1])) {
                        for (int i = y + taille - 1; i > y; i--) {
                            plateauJoueur[x][i + 1] = nom;

                            /// nous permet de remettre "  " pour le nom de la derniere case 
                            if (i == (y + 1)) {
                                plateauJoueur[x][i - 1] = "  ";
                            }
                        }
                    } else {
                        deplacement = false;
                    }
                } else if (choix != 1 && choix != 2) {
                    System.out.println(" Choix =  " + choix);
                    System.out.println(" Veuillez choisir l une des 2 options ");
                } else {
                    System.out.println(" Le deplacement n a pas ete efectue car un bateau bloque ou le bateau sortirait de la grille ");
                    System.out.println(" Vous allez retournez a la selection de bateaux ");
                    deplacement = false;
                }

                if (deplacement == false) {
                    choix = 1;
                }

            }

            if (sens == 'V') {
                if (numeroJoueur == 1) {
                    System.out.println("Choissisez un déplacement");
                    System.out.println("1-Haut");
                    System.out.println("2-Bas");

                    choix = move.nextInt();
                }
                if (numeroJoueur == 2) {
                    choix = (int) (Math.random() * (2) + 1);
                     if(choix==1)
                    {
                        System.out.print(" vers la Haut\n");
                    }
                    if(choix==2)
                    {
                        System.out.print(" vers la Bas\n");
                    }
                }

                /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
                if (choix == 1 && (x - 1) >= 0) {
                    if ("  ".equals(plateauJoueur[x - 1][y])) {
                        for (int i = x; i < x + taille; i++) {
                            plateauJoueur[i - 1][y] = nom;

                            /// nous permet de remettre "  " pour le nom de la derniere case 
                            if (i == (x + taille - 2)) {
                                plateauJoueur[i + 1][y] = "  ";
                            }
                        }
                    } else {
                        deplacement = false;
                    }
                } else if (choix == 2 && (x + taille+1) <= 14) {
                    if ("  ".equals(plateauJoueur[x + taille + 1][y])) {
                        for (int i = x + taille - 1; i > x; i--) {
                            plateauJoueur[i + 1][y] = nom;

                            /// nous permet de remettre "  " pour le nom de la derniere case 
                            if (i == (x + 1)) {
                                plateauJoueur[i - 1][y] = "  ";
                            }
                        }
                    } else {
                        deplacement = false;
                    }
                } else if (choix != 1 && choix != 2) {
                    System.out.println(" Veuillez choisir l une des 2 options ");
                } else {
                    deplacement = false;
                }

                if (deplacement == false) {
                    choix = 1;
                }

            }

        } while (choix != 1 && choix != 2);
        }
        else
        {
            deplacement=false;
            System.out.println("Un bateau touché ne peut pas être déplacé");
        }

        return deplacement;
    }

    public void tirer(String[][] plateauAttaque, Bateaux[] tabBateaux, int numeroJoueur) {

        int posX = -1;
        int posY = -1;
        int valeur1 = 0;
        int valeur2 = 0;
        if (numeroJoueur == 1) {
            Scanner px = new Scanner(System.in);
            Scanner py = new Scanner(System.in);
            char ligne;
            /// boucle pour s'assurer que les coordonnees sont dans la grille $
            do {

                /// demande a l utilisateur de saisir la case ou il veut tirer 
                System.out.println("Pour Tirer");
                System.out.println(" Selectionner la ligne ou vous voulez tirer ");
                try {
                   ligne = px.next().charAt(0);
                   posX = ligne - 'A';
            }catch (InputMismatchException e)
            {
                Object poubelle = px.next();
                System.out.println("Erreur sur la ligne");
            }
            
                System.out.println("Choisiez la colonne ou vous voulez tirer :");
                
                try {
                    
                    posY = py.nextInt();
                    posY--;
            }catch (InputMismatchException e)
            {
                Object poubelle = py.next();
                System.out.println("Erreur sur la colonne ");
                
            }

               
                /// affichage du message d errreur si jamais les coordonnes ne sont pas dans la grille 
                if (posX < 0 || posX > 15 || posY < 0 || posY > 15) {
                    System.out.println(" Saisissez des coordonnees dans la grille ");
                }
            } while (posX < 0 || posX > 15 || posY < 0 || posY > 15);
        }

        if (numeroJoueur == 2) {
            posX = (int) (Math.random() * (14 - 0) + 1);
            posY = (int) (Math.random() * (14 - 0) + 1);
           int ligne;
            ligne=posX +'A';
            int colonne = posY+1;
            System.out.print(" en ligne :"+(char)ligne+" en colonne : "+colonne);
        }

        valeur1 = posX + puissanceTir;
        valeur2 = posY + puissanceTir;

        if (valeur1 > 15) {
            valeur1 = 15;
        }

        if (valeur2 > 15) {
            valeur2 = 15;
        }

        /// parcours de toutes les cases du tableaux ou l ont tire  
        for (int i = posX; i < valeur1; i++) {
            for (int j = posY; j < valeur2; j++) {
                /// si il y a un bateau
                if (!"  ".equals(plateauAttaque[i][j])) {
                    /// in parcours le tableau de bateaux 
                    for (int n = 0; n < 10; n++) {
                        /// on recupere le bateau a partir du nom
                        if (plateauAttaque[i][j].equals(tabBateaux[n].nom)) {
                            /// si le bateau n est pas un sous marin on touche 
                            if (tabBateaux[n].special == false || (special == true && tabBateaux[n].special == true)) {
                                tabBateaux[n].vie--;
                                plateauAttaque[i][j] = color.getColorR()+ "TT" +color.getColorBl();
                                if(tabBateaux[n].vie==0)
                                {
                                    System.out.println("Un bateau ennemie a été coulé");
                                }
                                    
                                        
                            }
                        }

                    }
                } else {
                    plateauAttaque[i][j] =color.getColorG() + "XX" +color.getColorBl();
                            
                }
            }
        }
    }
}
