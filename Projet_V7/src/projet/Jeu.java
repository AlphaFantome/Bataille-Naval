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
public class Jeu implements Serializable{
    
    public Bateaux[] tabBateauJoueur = new Bateaux[10];
    public Bateaux[] tabBateauAI = new Bateaux[10];
    public String[][] plateauJoueur = new String[15][15];  
    public String [][] plateauAttaque = new String[15][15];
   

     public Jeu()
    {
        
    }
    
    public Jeu(Bateaux[] tabBateauJoueur, Bateaux[] tabBateauAI, String[][] plateauJoueur, String [][] plateauAttaque)
    {
        this.tabBateauAI=tabBateauAI;
        this.tabBateauJoueur=tabBateauAI;
        this.plateauJoueur=plateauJoueur;
        this.plateauAttaque=plateauAttaque;   
    }
    Couleur color = new Couleur();
    
    public void initialisationgrilleJoueur()
    {
        
        for ( int i = 0; i < 15; i++ )
        {
            for ( int j = 0; j < 15; j++ )
            {
                plateauJoueur[i][j]="  ";
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
    
    public void initialisationgrilleAttaque()
    {
        
        for ( int i = 0; i < 15; i++ )
        {
            for ( int j = 0; j < 15; j++ )
            {
                plateauAttaque[i][j]= "  ";
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
    
   /* public void plateauEvolutifJoueur(char ligne, int colonne)
    {
        int lignes;
        if(ligne==)
        {
            
        }
        if(" ".equals(plateauJoueur[ligne][colonne]))
        {
            plateauJoueur[ligne][colonne]="XXX";
        }
        else if(!" ".equals(plateauJoueur[ligne][colonne]))
        {
            plateauJoueur[ligne][colonne]="TTT";
        }
        
    }
    
    public void plateauEvolutifAttaque(char ligne, int colonne)
    {
        if(" ".equals(plateauAttaque[ligne][colonne]))
        {
            plateauAttaque[ligne][colonne]="XXX";
        }
        else if(!" ".equals(plateauAttaque[ligne][colonne]))
        {
            plateauAttaque[ligne][colonne]="TTT";
        }
        
    }*/
    
    
    
    public void affichageJoueurGrille()
    {
        int ascii=65;
            System.out.println("       VOTRE GRILLE                         \n ");
           System.out.print(" |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15| ");
         for(int i=0;i<15;i++)
         {
             System.out.println("\n-----------------------------------------------");
             System.out.print((char)ascii);
             ascii++;
             for(int j = 0; j<15;j++)
             {
                 System.out.print( "|"+plateauJoueur[i][j]);
             }    
             System.out.print("|");
         }
         System.out.println("\n-----------------------------------------------");
    }
    
    public void affichageAttaqueGrille()
    {
           int ascii=65;
            System.out.println("       GRILLE ENNEMIE                         \n ");
           System.out.print(" |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15| ");
         for(int i=0;i<15;i++)
         {
             System.out.println("\n-----------------------------------------------");
             System.out.print((char)ascii);
             ascii++;
             for(int j = 0; j<15;j++)
             {
                 System.out.print("|");
                 //if(("  ".equals(plateauAttaque[i][j]))||("XX".equals(plateauAttaque[i][j]))||("TT".equals(plateauAttaque[i][j])))
                 //{
                     System.out.print(plateauAttaque[i][j]);
                // }
                // else{
                    // System.out.print("  ");
                 //}
             }    
             System.out.print("|");
         }
         System.out.println("\n-----------------------------------------------");
    }
    
    public void menu()
    {
        int choix=0;
        int victoire = 0;
        while((choix!=4)||(victoire!=1)||(victoire!=2))
        {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenu dans la bataille naval");
        System.out.println("\n");
        System.out.println("veuillez faire un choix :");
        System.out.println("1. Jouer une partie");
        System.out.println("2. Charger une partie");
        System.out.println("3. Aide");
        System.out.println("4. Quitter");
        choix=scanner.nextInt();
        while(choix<0 || choix>4)
        {
            System.out.println("Erreur sur le choix, veuillez refaire un choix : ");
            choix=scanner.nextInt();
        }
        
        switch(choix)
        {
            case 1 :
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                affichageJoueurGrille();
                affichageAttaqueGrille();
                choixAction();
                victoire=Victoire();
                
                break;
            case 2 :
                 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                //chargé partie
                 Deserialisation charge = new Deserialisation();
                
                 charge.DeserialisationGame();
                break;
            case 3 :
                command("cls");
                System.out.println("Voici les régles du jeu :");
                System.out.println("Vous allez jouer à la bataille navale mobile contre un ordinateur. Vous possederez chaqu'un une flotte de 10 bateaux contenant :");
                System.out.println("1 cuirassé, 2 croiseurs, 3 destroyeurs et 4 sous-marins");
                System.out.println("Chaque type de bateau aura une spécificité. Pour le cuirrasé,ses tires sont des carrés de 3x3. Les destroyers peuvent envoyer 1 fusées éclaiantes chacun découvrant ainsi un carré de 4 cases pendant plusieurs secondes");
                System.out.println("Et enfin les sous-marins, seul un sous-marin va pouvoir couler un sous-marin");
                System.out.println("Passons aux actions à chaque tour de jeu :");
                System.out.println("Vous avez le choix entre Déplacer un bateau d'une case dans l'orientation du bateau");
                System.out.println("Utiliser la capacité du destroyer");
                System.out.println("Choisir un bateau puis tirer");
                System.out.println("Et enfin sauvegarder et quitter");
                System.out.println("La condition de victoire est de détruire tous les sous-marin adverses ou de détruire tous les bateaux adverse");
                System.out.println("\nBonne chance et bon jeu");
                System.out.println("Appuier sur !!!!!!!! pour quitter l'aide");// Choisir une touche pour sortir de l'aide ? 
                break;
            case 4 :
                System.exit(0);
                break;
        }
        }
        if(victoire==1)
        {
            System.out.println("Bravo Vous avez gagné");
        }
        if(victoire==2)
        {
            System.out.println("Dommage, l'AI a gagné, vous ferez mieux la prochaine fois");
        }
    }
    
     /// fonction selectionner 
    public int Selectionner()
    {
        int i=0;
        Scanner scanner = new Scanner(System.in);
        String nom;
        System.out.println("Quelle est le nom du bateau que vous voulez utilisez ?");
        nom=scanner.next();
        while(!"CU".equals(nom) && !"C1".equals(nom) && !"C2".equals(nom) && !"D1".equals(nom) && !"D2".equals(nom) && !"D3".equals(nom) && !"S1".equals(nom)&& !"S2".equals(nom)&& !"S3".equals(nom)&& !"S4".equals(nom))
        {
            System.out.println("Erreur sur le nom du bateau, veuillez refaire votre selection : ");
            nom=scanner.next();
        }
        
        while(!tabBateauJoueur[i].nom.equals(nom))
        {
            i++;
        }
        if(tabBateauJoueur[i].vie==0)
        {
            System.out.println("Ce bateau est mort vous ne pouvez pas utiliser ce bateau");
            Selectionner();
        }
        return i;    
    }
    
    public void choixAction()
    {
        int choix=0; 
        int victoire=0;
        boolean test;
        int numeroJoueur=1;
        while((choix!=4)||(victoire!=1)||(victoire!=2))
        {
        int numeroBateau;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        numeroBateau=Selectionner();
        System.out.println("1. Déplacer le bateau");
        System.out.println("2. Tirer");
        System.out.println("3. Sauvegarder");
        System.out.println("4. Quitter");
        choix=scanner.nextInt();
        while(choix<0 || choix>4)
        {
            System.out.println("Erreur sur le choix, veuillez refaire un choix : ");
            choix=scanner.nextInt();
        }
       
            switch(choix)
        {
            case 1 :
                
                  test=tabBateauJoueur[numeroBateau].deplacer(plateauJoueur, 1);
                  if(test==false)
                  {
                      System.out.println("Déplacement impossible");
                      choixAction();
                  }
                  System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                  affichageJoueurGrille();
                  affichageAttaqueGrille();
                  
                   victoire=Victoire();
                   menuActionAI();
                   victoire=Victoire();
                break;
                
            case 2 :
                tabBateauJoueur[numeroBateau].tirer(plateauAttaque, tabBateauAI, 1);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                affichageJoueurGrille();
                affichageAttaqueGrille();
                
                victoire=Victoire();
                menuActionAI();
                victoire=Victoire();
                 
                break; 
            case 3 :
                Serialisation sauvegarde = new Serialisation();
                sauvegarde.SerialisationGame(tabBateauJoueur, tabBateauAI, plateauJoueur, plateauAttaque);
                System.exit(0);
                
                break;
                
            case 4 :
                System.out.println("Merci d'avoir joué");
                System.exit(0);
                break;
            }
            
        }
        
    }
    
    public void menuActionAI()
    {
        int numeroBateau = (int)(Math.random()*10);
        while(tabBateauAI[numeroBateau].vie==0)
        {
           numeroBateau = (int)(Math.random()*10);
        }
        int choix = (int)(Math.random()*(2)+1);
        boolean test;
         switch(choix)
        {
            case 1 :
                
                  test=tabBateauJoueur[numeroBateau].deplacer(plateauAttaque, 2);
                  if(test==false)
                  {
                      menuActionAI();
                  }
                  System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                  System.out.println("AI deplace");
                  affichageJoueurGrille();
                  affichageAttaqueGrille();
                  
                break;
                
            case 2 :
       
                tabBateauJoueur[numeroBateau].tirer(plateauJoueur, tabBateauJoueur, 2);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("AI tire");
                affichageJoueurGrille();
                affichageAttaqueGrille();                
                break; 
    }
    }
       
    
    public int Victoire()
    {
        if((tabBateauJoueur[0].vie==0)&&(tabBateauJoueur[1].vie==0)&&(tabBateauJoueur[2].vie==0)&&(tabBateauJoueur[3].vie==0)&&(tabBateauJoueur[4].vie==0)&&(tabBateauJoueur[5].vie==0)&&(tabBateauJoueur[6].vie==0)&&(tabBateauJoueur[7].vie==0)&&(tabBateauJoueur[8].vie==0)&&(tabBateauJoueur[9].vie==0))
        {
            return 2;
        }
        if((tabBateauAI[0].vie==0)&&(tabBateauAI[1].vie==0)&&(tabBateauAI[2].vie==0)&&(tabBateauAI[3].vie==0)&&(tabBateauAI[4].vie==0)&&(tabBateauAI[5].vie==0)&&(tabBateauAI[6].vie==0)&&(tabBateauAI[7].vie==0)&&(tabBateauAI[8].vie==0)&&(tabBateauAI[9].vie==0))
        {
            return 1;
        }
        if((tabBateauJoueur[5].vie==0)&&(tabBateauJoueur[6].vie==0)&&(tabBateauJoueur[7].vie==0)&&(tabBateauJoueur[8].vie==0)&&(tabBateauJoueur[9].vie==0))
        {
            return 2;
        }
        if((tabBateauAI[5].vie==0)&&(tabBateauAI[6].vie==0)&&(tabBateauAI[7].vie==0)&&(tabBateauAI[8].vie==0)&&(tabBateauAI[9].vie==0))
        {
            return 1;
        }
        else{
            return 0;
        }
        
    }
    
}
