/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.Scanner;

/**
 *
 * @author 33614
 */
public class Croiseur extends Bateaux{
    
     
    
    
        /// constructeur du Croiseur 
    public Croiseur( int[][] grille ){
        
        taille=5;
        nom = "Croiseur";
        corps = new Coord[5];
        /// determination du sens du bateau  
        double aleatoire; 
        aleatoire = Math.random();
        
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
        boolean bool_limite = true;
        boolean bool_libre = true;
        do 
        {    
            /// on attribue aleatoirement les valeurs de la coordonnee initiale
            x = (int) ( Math.random() * ( 15 - 0 ) + 1 );            
            y = (int) ( Math.random() * ( 15 - 0 ) + 1 );

            /// probleme de depassement de la grille
            /// pour le sens horizontal 
            if( sens == 'H' )
            {
                
                /// on vérifie que la taille ne depasse pas du plateau 
                if ( ( x + 5 ) > 14 )
                {
                    bool_limite = false;
                }
            } 
            
            /// pour le sens horizontal 
            else if ( sens == 'V' )
            {
                 
                 /// on verifie que la taille ne depasse pas du plateau 
                 if ( ( y + 5 ) > 14 )
                 {
                     bool_limite = false;
                 }
            }            
            /// fin du probleme de depassement de la grille 
            
            
            /// probleme de savoir si la grille est deja remplie
            /// pour le sens horizontal 
            if ( sens == 'H' )
            {
                for ( int i = y; i < y + 5; i++ )
                {
                    if ( grille[x][y].plein == true )
                    {
                        i = y + 1;
                        bool_libre = false;
                    }
                    
                }
             } 
            
            /// pour le sens vertical 
             if ( sens == 'V' )
             {
                 for ( int i = x; i < x + 5; i++ )
                 {
                     if ( grille[x][y].plein == true )
                     {
                         i = x + 1;
                         bool_libre = false;
                     }
                 }
             }
            
        }while ( bool_limite == false || bool_libre == false );
        /// fin de la verification que la grille soit remplie 
                
        /// on peut maintenant donner les coordonnees au tableau 
        if ( sens == 'H' )
        {
            for ( int i = x; i < x + 5; i++ )
            {
                corps[i].x=x;
                grille[x][y].plein = true; 
                corps[i].y=y;
                x++;
            }
        }
        
        if ( sens == 'V' )
        {
            for ( int i = y; i < y + 5; i++ )
            {
                corps[i].x=x;
                grille[x][y].plein = true; 
                 corps[i].y=y;
                y++;
            }
        }
    }
    
    public void tirer(Croiseur test2) {
        
        int i;
        int j;
        int posX;
        int posY;
        
        Scanner px = new Scanner(System.in);
        Scanner py = new Scanner(System.in);
        
        System.out.println("Pour Tirer");
        System.out.println("Choisiez une position x:");
        posX = px.nextInt();
        while(posX<0 || posX>15)
        {
            System.out.println("Error valeur de X non valide, veuillez re-rentrer la valeur : ");
            posX = px.nextInt();
        }
        
        System.out.println("Choisiez une position y:");
        posY = py.nextInt();
        while(posY<0 || posY>15)
        {
            System.out.println("Error valeur de Y non valide, veuillez re-rentrer la valeur : ");
            posY = py.nextInt();
        }
        
        
        for(i=0; i<posX; i++)
        {
            for(j=0; j<posY; j++)
            {
                if((test2.corps[i].x == posX) && (test2.corps[j].y== posY) || (test2.corps[i].x== posX+1) && (test2.corps[j].y== posY) ||(test2.corps[i].x == posX) && (test2.corps[j].y == posY+1)||(test2.corps[i].x == posX+1) && (test2.corps[j].y == posY+1))
                {
                     
                     System.out.println("Vous avez toucher un ennemi");
                }
                
                else
                {
                    System.out.println("Vous n'avez rien toucher");
                }
                   
                
            }
        } 
    
}
    
}
