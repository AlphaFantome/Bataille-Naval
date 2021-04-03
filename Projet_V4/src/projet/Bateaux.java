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
public abstract class Bateaux {
    
    
    public int taille;
    public int vie;
    public String nom;
    public char sens;
    public boolean special;
    public int puissanceTir; 
    
        public boolean deplacer( String[][] plateauJoueur )
         {
            int choix = 0;        
            Scanner move = new Scanner(System.in);
            boolean deplacement = true;
            int x = -1;
            int y = -1;
             
            /// on recupere les coordonnees de la premiere case du bateau selectionne
            for ( int i = 0; i < 15; i++ )
            {
                for ( int j = 0; j < 15; j++ )
                {
                    if ( plateauJoueur[i][j].equals(nom) )
                    {
                        x = i;
                        y = j;
                        i = 15;
                        j = 15;
                     }
                }
            }
            
            do 
            {
                if ( sens == 'H')
                {
                    System.out.println("Choissisez un déplacement");
                    System.out.println("1-Gauche");
                    System.out.println("2-Droite");
                    
                    choix = move.nextInt();
                    
                    /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
                    if ( choix == 1 && x > 0 && "  ".equals(plateauJoueur[x-1][y]) )
                    {
                        for ( int i = x; i < x + taille; i++ )
                        {
                            plateauJoueur[i-1][y] = nom;
                        }
                    }
                    
                    else if ( choix == 2 && x > 0 && "  ".equals(plateauJoueur[x+taille+1][y]) )
                    {
                        for ( int i = x + taille ; i > x ; i-- )
                        {
                            plateauJoueur[i+1][y] = nom;
                        } 
                    }
                    
                    else if ( choix != 1 || choix != 2)
                        System.out.println( " Veuillez choisir l une des 2 options ");
                    else
                    {
                        System.out.println(" Le deplacement n a pas ete efectue car un bateau bloque ou le bateau sortirait de la grille ");
                        System.out.println(" Vous allez retournez a la selection de bateaux ");
                        deplacement = false;
                    }
                    
                    if ( deplacement == false )
                        choix = 1;
                    
                }
                
                if ( sens == 'V')
                {
                    System.out.println("Choissisez un déplacement");
                    System.out.println("1-Haut");
                    System.out.println("2-Bas");
                    
                    choix = move.nextInt();
                    
                    /// on verifie que la grille ne soit pas remplie et que le deplacement ne sorte pas le bateau de la grille 
                    if ( choix == 1 && x > 0 && "  ".equals(plateauJoueur[x][y-1]) )
                    {
                        for ( int i = y; i < y + taille; i++ )
                        {
                            plateauJoueur[x][i-1] = nom;
                        }
                    }
                    
                    else if ( choix == 2 && x > 0 && "  ".equals(plateauJoueur[x][y+taille+1]) )
                    {
                        for ( int i = y + taille ; i > y ; i-- )
                        {
                            plateauJoueur[x][i+1] = nom;
                        } 
                    }
                    
                    else if ( choix != 1 || choix != 2)
                        System.out.println( " Veuillez choisir l une des 2 options ");
                    else
                    {
                        System.out.println(" Le deplacement n a pas ete efectue car un bateau bloque ou le bateau sortirait de la grille ");
                        System.out.println(" Vous allez retournez a la selection de bateaux ");
                        deplacement = false;
                    }
                    
                    if ( deplacement == false )
                        choix = 1;
                    
                }
                
            }while( choix != 1 || choix != 2 );
        
        return deplacement; 
        }
               
         
    public void tirer( String[][] plateauAttaque, Bateaux[] tabBateaux ) {
        
        int posX = 0;
        int posY = 0;
        
        Scanner px = new Scanner(System.in);
        Scanner py = new Scanner(System.in);
        
        /// boucle pour s'assurer que les coordonnees sont dans la grille $
        do 
        {
        /// demande a l utilisateur de saisir la case ou il veut tirer 
        System.out.println("Pour Tirer");
        System.out.println("Choisiez une position x:");
        
        posX = px.nextInt();
        
        System.out.println("Choisiez une position y:");
        
        posY = py.nextInt();
        
        /// affichage du message d errreur si jamais les coordonnes ne sont pas dans la grille 
        if ( posX < 0 || posX > 15 || posY < 0 || posY > 15 )
            
            System.out.println(" Saisissez des coordonnees dans la grille ");
        }while( posX < 0 || posX > 15 || posY < 0 || posY > 15 );
        
        
        /// parcours de toutes les cases du tableaux ou l ont tire  
        for ( int i = posX; i < posX + puissanceTir; i++ )
        {
            for ( int j = posY; j < posY + puissanceTir; j++ )
            {
                /// si il y a un bateau
                if ( !"  ".equals(plateauAttaque[i][j]) )
                {
                    /// in parcours le tableau de bateaux 
                    for ( int n = 0; n < 10; n++ )
                    {
                        /// on recupere le bateau a partir du nom
                        if ( plateauAttaque[i][j].equals(tabBateaux[n].nom) )
                        {
                            /// si le bateau n est pas un sous marin on touche 
                            if ( tabBateaux[n].special == false || ( special == true && tabBateaux[n].special == true ) )
                            {
                                tabBateaux[n].vie--;
                                plateauAttaque[i][j] = "TT";
                            }
                            
                            /// si jamais on tire sur un sous marin sans etre un sous marin on touche rien 
                            else 
                                plateauAttaque[i][j] = "XX";
                        }
                        
                    }
                }
                else 
                   plateauAttaque[i][j] = "XX";
            }
        }
        
        
       
    }
}