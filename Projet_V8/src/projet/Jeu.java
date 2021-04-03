/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import static java.lang.Compiler.command;
import java.util.*;
import java.io.*;

/**
 *
 * @author 33614
 */
public class Jeu implements Serializable {

    public Bateaux[] tabBateauJoueur = new Bateaux[10];
    public Bateaux[] tabBateauAI = new Bateaux[10];
    public String[][] plateauJoueur = new String[15][15];
    public String[][] plateauAttaque = new String[15][15];
    public int victoire;

    public Jeu() {

    }

    public Jeu(Bateaux[] tabBateauJoueur, Bateaux[] tabBateauAI, String[][] plateauJoueur, String[][] plateauAttaque) {
        this.tabBateauAI = tabBateauAI;
        this.tabBateauJoueur = tabBateauJoueur;
        this.plateauJoueur = plateauJoueur;
        this.plateauAttaque = plateauAttaque;
    }
    Couleur color = new Couleur();

    public void initialisationgrilleJoueur() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                plateauJoueur[i][j] = "  ";
            }

        }

        tabBateauJoueur[0] = new Cuirassé(plateauJoueur, "CU");
        tabBateauJoueur[1] = new Croiseur(plateauJoueur, "C1");
        tabBateauJoueur[2] = new Croiseur(plateauJoueur, "C2");
        tabBateauJoueur[3] = new Destroyer(plateauJoueur, "D1");
        tabBateauJoueur[4] = new Destroyer(plateauJoueur, "D2");
        tabBateauJoueur[5] = new Destroyer(plateauJoueur, "D3");
        tabBateauJoueur[6] = new SousMarin(plateauJoueur, "S1");
        tabBateauJoueur[7] = new SousMarin(plateauJoueur, "S2");
        tabBateauJoueur[8] = new SousMarin(plateauJoueur, "S3");
        tabBateauJoueur[9] = new SousMarin(plateauJoueur, "S4");

    }

    public void initialisationgrilleAttaque() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                plateauAttaque[i][j] = "  ";
            }
        }

        tabBateauAI[0] = new Cuirassé(plateauAttaque, "CU");
        tabBateauAI[1] = new Croiseur(plateauAttaque, "C1");
        tabBateauAI[2] = new Croiseur(plateauAttaque, "C2");
        tabBateauAI[3] = new Destroyer(plateauAttaque, "D1");
        tabBateauAI[4] = new Destroyer(plateauAttaque, "D2");
        tabBateauAI[5] = new Destroyer(plateauAttaque, "D3");
        tabBateauAI[6] = new SousMarin(plateauAttaque, "S1");
        tabBateauAI[7] = new SousMarin(plateauAttaque, "S2");
        tabBateauAI[8] = new SousMarin(plateauAttaque, "S3");
        tabBateauAI[9] = new SousMarin(plateauAttaque, "S4");

    }

    public void affichageJoueurGrille() {
        int ascii = 65;
        System.out.println("");
        System.out.println("             VOTRE GRILLE                         \n ");
        System.out.print(" |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15| ");
        for (int i = 0; i < 15; i++) {
            System.out.println("\n-----------------------------------------------");
            System.out.print((char) ascii);
            ascii++;
            for (int j = 0; j < 15; j++) {
                System.out.print("|" + plateauJoueur[i][j]);
            }
            System.out.print("|");
        }
        System.out.println("\n-----------------------------------------------");
    }

    public void affichageAttaqueGrille() {
        int ascii = 65;
        System.out.println("");
        System.out.println("             GRILLE ENNEMIE                         \n ");
        System.out.print(" |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15| ");
        for (int i = 0; i < 15; i++) {
            System.out.println("\n-----------------------------------------------");
            System.out.print((char) ascii);
            ascii++;
            for (int j = 0; j < 15; j++) {
                System.out.print("|");
                 if ("  ".equals(plateauAttaque[i][j]) || "\u001B[32mXX\u001B[30m".equals(plateauAttaque[i][j]) || "\u001B[31mTT\u001B[30m".equals(plateauAttaque[i][j]))
                {
                    System.out.print(plateauAttaque[i][j]);
                } else {
                  System.out.print("  ");
                }
            }
            System.out.print("|");
        }
        System.out.println("\n-----------------------------------------------");
    }

    public void menu() {
        int choix = -1;
        while ((choix != 4) && (victoire != 1) && (victoire != 2)) {
            choix = -1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenu dans la bataille navale");
            System.out.println("\n");
            System.out.println("veuillez faire un choix :");
            System.out.println("1. Jouer une partie");
            System.out.println("2. Charger une partie");
            System.out.println("3. Aide");
            System.out.println("4. Quitter"); 
            while (choix < 0 || choix > 4) {
            try {
             choix = scanner.nextInt();
            }catch (InputMismatchException e)
            {
                Object poubelle = scanner.next();
                System.out.println("Erreur sur le choix, veuillez refaire un choix : ");
            }
            }

            switch (choix) {
                case 1:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    affichageJoueurGrille();
                    affichageAttaqueGrille();
                    choixAction();
                    

                    break;
                case 2:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    //chargé partie
                    Deserialisation charge = new Deserialisation();
                    charge.DeserialisationGame();
                    victoire=charge.getVictoire();
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("");             
                    System.out.println(color.getColorR()+"BATAILLE NAVALE\n"+color.getColorBl());
                    System.out.println(color.getColorG()+"Vous allez jouer à une bataille navale contre une IA.Voici les règles:\n"+color.getColorBl());
                    System.out.println(color.getColorY()+"CARATERISTIQUES DU JEU:\n"+color.getColorBl());
                    System.out.println("Le joueur et l’ordinateur disposent chacun de deux grilles de 15*15 cases.");
                    System.out.println(color.getColorP()+"CARATERISTIQUES DES NAVIRES:\n"+color.getColorBl());
                    System.out.println("Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins.");
                    System.out.println("Chaque type de navire a une taille et une puissance de tir différente :\n ");
                    System.out.println(color.getColorC()+"Curiassé :"+color.getColorBl()+" il a une taille de 7 cases et une puissance de tir de 9 cases");
                    System.out.println(color.getColorC()+"Croiseur :"+color.getColorBl()+" il a une taille de 5 cases et une puissance de tir de 4 cases");
                    System.out.println(color.getColorC()+"Destroyer :"+color.getColorBl()+" il a une taille de 3 cases et une puissance de tir de 1 case");
                    System.out.println(color.getColorC()+"Sous-marin :"+color.getColorBl()+" il a une taille de 1 cases et une puissance de tir de 1 case\n");
                    System.out.println(color.getColorP()+"LE PLATEAU DE JEU\n"+color.getColorBl());
                    System.out.println("En début de jeu les navires sont positionnés aléatoirement et bien répartis dans les grilles.");
                    System.out.println("C’est le joueur humain qui commence la partie. ");
                    System.out.println("Les navires peuvent être positionnés verticalement ou horizontalement sur la grille.");
                    System.out.println("Mais attention, deux navires ne peuvent occuper la même case\n");
                    System.out.println(color.getColorP()+"LES TIRS\n"+color.getColorBl());
                    System.out.println("Chaque joueur joue à tour de rôle.");
                    System.out.println("A chaque tour de jeu, les joueurs sélectionnent un navire et décident de tirer, de se déplacer, de sauvegarder ou de quitter le jeu.");
                    System.out.println("\nPour tirer, le joueur sélectionne les coordonnées d'une case.");
                    System.out.println("Le premier tir d'un destroyer est une fusée éclairante.");
                    System.out.println("Les sous-marins ne peuvent être coulés que par d’autres sous-marins.\n ");
                    System.out.println(color.getColorP()+"LES DEPLACEMENTS\n"+color.getColorBl());
                    System.out.println("Un navire se déplace d'une seule case sauf lorsqu'il est touché ou s'il rencontre un obstacle.");
                    System.out.println("Il se déplace horizontalement ou verticalement.");
                    System.out.println("Le premier qui a coulé toute la flotte de son adversaire a gagné la partie !\n");
                    System.out.println(color.getColorG()+"Amusez-vous bien ! \n\n"+color.getColorBl());
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
        if (victoire == 1) {
            System.out.println("Bravo Vous avez gagné");
        }
        if (victoire == 2) {
            System.out.println("Dommage, l'AI a gagné, vous ferez mieux la prochaine fois");
        }
    }

    /// fonction selectionner 
    public int Selectionner() {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        String nom;
        System.out.println("Quelle est le nom du bateau que vous voulez utilisez ?");
        System.out.println("CU pour cuirassé");
        System.out.println("C1 pour croiseur 1");
        System.out.println("C2 pour croiseur 2");
        System.out.println("D1 pour destroyer 1");
        System.out.println("D2 pour destroyer 2");
        System.out.println("D3 pour destroyer 3");
        System.out.println("S1 pour sous-marin 1");
        System.out.println("S2 pour sous-marin 2");
        System.out.println("S3 pour sous-marin 3");
        System.out.println("S4 pour sous-marin 4");
        
        nom = scanner.next();
        while (!"CU".equals(nom) && !"C1".equals(nom) && !"C2".equals(nom) && !"D1".equals(nom) && !"D2".equals(nom) && !"D3".equals(nom) && !"S1".equals(nom) && !"S2".equals(nom) && !"S3".equals(nom) && !"S4".equals(nom)) {
            System.out.println("Erreur sur le nom du bateau, veuillez refaire votre selection : ");
            nom = scanner.next();
        }

        while (!tabBateauJoueur[i].nom.equals(nom)) {
            i++;
        }
        if (tabBateauJoueur[i].vie == 0) {
            System.out.println("Ce bateau est mort vous ne pouvez pas utiliser ce bateau");
            Selectionner();
        }
        return i;
    }

    public void choixAction() {
        int choix = -1;
        boolean test;
        while ((choix != 4) && (victoire != 1) && (victoire != 2)) {
            choix = -1;
            int numeroBateau;
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n");
            numeroBateau = Selectionner();
            System.out.println("1. Déplacer le bateau");
            System.out.println("2. Tirer");
            System.out.println("3. Sauvegarder");
            System.out.println("4. Quitter");
            
            while (choix < 0 || choix > 4) {
            try {
             choix = scanner.nextInt();
            }catch (InputMismatchException e)
            {
                Object poubelle = scanner.next();
                System.out.println("Erreur sur le choix, veuillez refaire un choix : ");
            }
            }
            

            switch (choix) {
                case 1:

                    test = tabBateauJoueur[numeroBateau].deplacer(plateauJoueur, 1);
                    if (test == false) {
                        System.out.println("Déplacement impossible");
                        break;
                    }
                    Victoire();
                    menuActionAI();
                    Victoire();
                    affichageJoueurGrille();
                    affichageAttaqueGrille();
                    break;

                case 2:
                     tabBateauJoueur[numeroBateau].tirer(plateauAttaque, tabBateauAI, 1);
                     Victoire();
                    menuActionAI();
                     Victoire();
                     affichageJoueurGrille();
                     affichageAttaqueGrille();

                    break;
                case 3:
                    Serialisation sauvegarde = new Serialisation();
                    sauvegarde.SerialisationGame(tabBateauJoueur, tabBateauAI, plateauJoueur, plateauAttaque);
                    System.exit(0);

                    break;

                case 4:
                    System.out.println("Merci d'avoir joué");
                    System.exit(0);
                    break;
            }

        }
    }

    public void menuActionAI() {
        int numeroBateau = (int) (Math.random() * 10);
        while (tabBateauAI[numeroBateau].vie == 0 && victoire!=1) {
            numeroBateau = (int) (Math.random() * 10);
        }
        if(victoire!=1)
        {
        int choix = (int) (Math.random() * (2) + 1);
        boolean test;
        switch (choix) {
            case 1:
                System.out.println("\n\n");
                System.out.print("AI deplace le bateau : "+tabBateauAI[numeroBateau].nom);
                test = tabBateauAI[numeroBateau].deplacer(plateauAttaque, 2);
                if (test == false) {
                    menuActionAI();
                }
                

                break;

            case 2:
                System.out.println("\n\n");
                System.out.println("AI tire avec le bateau : "+tabBateauAI[numeroBateau].nom);
                tabBateauAI[numeroBateau].tirer(plateauJoueur, tabBateauJoueur, 2);               
                break;
        }
        }
        
    }

    public void Victoire() {
        if ((tabBateauJoueur[0].vie == 0) && (tabBateauJoueur[1].vie == 0) && (tabBateauJoueur[2].vie == 0) && (tabBateauJoueur[3].vie == 0) && (tabBateauJoueur[4].vie == 0) && (tabBateauJoueur[5].vie == 0) && (tabBateauJoueur[6].vie == 0) && (tabBateauJoueur[7].vie == 0) && (tabBateauJoueur[8].vie == 0) && (tabBateauJoueur[9].vie == 0)) {
            victoire = 2;
 
        }
        if ((tabBateauAI[0].vie == 0) && (tabBateauAI[1].vie == 0) && (tabBateauAI[2].vie == 0) && (tabBateauAI[3].vie == 0) && (tabBateauAI[4].vie == 0) && (tabBateauAI[5].vie == 0) && (tabBateauAI[6].vie == 0) && (tabBateauAI[7].vie == 0) && (tabBateauAI[8].vie == 0) && (tabBateauAI[9].vie == 0)) {
            victoire = 1;
            
        }
        if ((tabBateauJoueur[6].vie == 0) && (tabBateauJoueur[7].vie == 0) && (tabBateauJoueur[8].vie == 0) && (tabBateauJoueur[9].vie == 0)) {
            victoire = 2;
            
        }
        if ((tabBateauAI[6].vie == 0) && (tabBateauAI[7].vie == 0) && (tabBateauAI[8].vie == 0) && (tabBateauAI[9].vie == 0)) {
            victoire = 1;
           
             
        } 
    }

}
