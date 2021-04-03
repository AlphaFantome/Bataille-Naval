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
public class Destroyer extends Bateaux {
    
    /// attributs du destroyer 
    public boolean premierTir;

    /// constructeur du Destroyer
    public Destroyer( String[][] plateau, String nomBateau ){
        
        nom = nomBateau;
        taille = 3;
        vie = 3;
        special = false;
        premierTir = true;
        puissanceTir = 1;
        
        /// determination du sens du bateau  
        double aleatoire; 
        aleatoire = Math.random()*(2);        

        if ( aleatoire == 0 )
            sens = 'H';
        else 
            sens = 'V';
        
        /// blindage du sens du bateau 
        
        /// les variables x et y nous servent a determiner aleatoirement la position du bateau
        int x;
        int y;         

        /// les booleans nous permettront de tester les differentes conditions a respecter 
        /// on peut ensuite sortir de la boucle quand tous les booleans sont true 
        boolean bool_limite;
        boolean bool_libre;
        do 
        {    
        bool_limite = true;
        bool_libre = true;
            /// on attribue aleatoirement les valeurs de la coordonnee initiale
            x = (int) ( Math.random() * ( 14 - 0 ) + 1 );            
            y = (int) ( Math.random() * ( 14 - 0 ) + 1 );

            /// probleme de depassement de la grille
            /// pour le sens horizontal 
            if( sens == 'V')
            {
                
                /// on vérifie que la taille ne depasse pas du plateau 
                if ( ( x + 3 ) > 14 )
                {
                    bool_limite = false;
                }
            } 
            
            /// pour le sens horizontal 
            else if ( sens == 'H' )
            {
                 
                 /// on verifie que la taille ne depasse pas du plateau 
                 if ( ( y + 3 ) > 14 )
                 {
                     bool_limite = false;
                 }
            }            
            /// fin du probleme de depassement de la grille 
            
            
            /// probleme de savoir si la grille est deja remplie
            /// pour le sens horizontal 
            if(bool_limite==true)
            {
              if ( sens == 'H' )
            {
                for ( int i = y; i < y + taille; i++ )
                {
                    if ( !"  ".equals(plateau[x][i]) )
                    {
                        i = y + taille;
                        bool_libre = false;
                    }
                    
                }
             } 
            
            /// pour le sens vertical 
             if (sens == 'V')
             {
                 for ( int i = x; i < x + taille; i++ )
                 {
                     if ( !"  ".equals(plateau[i][y]))
                     {
                         i = x + taille;
                         bool_libre = false;
                     }
                 }
             }
            }
            
        }while ( (bool_limite == false) || (bool_libre == false) );
        /// fin de la verification que la grille soit remplie 
        
        /// si on arrive ici toutes les condtitions pour pouvoir placer le bateau son respectées 
        
        /// on instancie les coordonnees de la premiere case du tableau 
        if ( sens == 'V' )
        {
            for ( int i = x; i < x + 3; i++ )
                plateau[i][y] = nom;

        }
        
        if ( sens == 'H' )
        {
            for ( int i = y; i < y + taille; i++ )
                plateau[x][i] = nom;

        }
    }
    
 @Override
    public void tirer( String[][] plateauAttaque, Bateaux[] tabBateaux, int numeroJoueur ){
        if(premierTir){
                    
        /// on demande à lutilsateur de choisir lacase ou il veut tirer
        int posX = 0;
        int posY = 0;
        
       if(numeroJoueur==1)
        {
        Scanner px = new Scanner(System.in);
        Scanner py = new Scanner(System.in);
        char ligne;
        /// boucle pour s'assurer que les coordonnees sont dans la grille $
        do 
        {

            /// demande a l utilisateur de saisir la case ou il veut tirer 
            System.out.println("Pour Tirer");
            System.out.println( " Selectionner la ligne de la 1ere case du bateau que vous voulez selectionner ");
                ligne = px.next().charAt(0);
            

            posX = ligne - 'A';

            System.out.println("Choisiez la colonne ou vous voulez tirer :");

            posY = py.nextInt();
            posY--;
            /// affichage du message d errreur si jamais les coordonnes ne sont pas dans la grille 
            if ( posX < 0 || posX > 15 || posY < 0 || posY > 15 )
            
            System.out.println(" Saisissez des coordonnees dans la grille ");
        }while( posX < 0 || posX > 15 || posY < 0 || posY > 15 );
        }
        
        if(numeroJoueur==2)
        {
            posX=(int)(Math.random()*(14-0)+1);
            posY=(int)(Math.random()*(14-0)+1);
            int ligne;
            ligne=posX +'A';
            int colonne = posY+1;
            System.out.print(" en ligne :"+(char)ligne+" en colonne : "+colonne);
        }
        
        if(numeroJoueur==1)
        {
        int ascii=65;
        System.out.println("\n");
        System.out.println("              GRILLE ENNEMIE REVELEE                     \n ");
        System.out.print(" |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15| ");
        
        /// dans la boucle on affiche rien sauf si on est dans le carre de la fusee eclairante  
        for(int i=0;i<15;i++)
        {
             System.out.println("\n-----------------------------------------------");
             System.out.print((char)ascii);
             ascii++;
             for(int j = 0; j<15;j++)
             {
                 if ( ( i >= posX && i <= ( posX + 3 ) ) && ( j >= posY && j <= ( posY + 3 ) ) )
                    System.out.print( "|"+plateauAttaque[i][j]);
                 else 
                    System.out.print( "|  ");
             }    
             System.out.print("|");
        }
         System.out.println("\n-----------------------------------------------");
            
            premierTir = false;
            
            
        }
        }
        else
            super.tirer(plateauAttaque, tabBateaux, numeroJoueur );
        }
    }
  

