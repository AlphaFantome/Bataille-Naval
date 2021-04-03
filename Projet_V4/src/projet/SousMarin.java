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
    public SousMarin( String[][] plateau, String nomBateau ){
        
        nom = nomBateau;
        taille = 1;
        vie = 1;
        special = true;
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
                if ( ( x ) > 14 )
                {
                    bool_limite = false;
                }
            } 
            
            /// pour le sens horizontal 
            else if ( sens == 'H' )
            {
                 
                 /// on verifie que la taille ne depasse pas du plateau 
                 if ( ( y ) > 14 )
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
                
                    if ( !"  ".equals(plateau[x][y]) )
                    {
                        bool_libre = false;
                    }
                    
                
             } 
            
            /// pour le sens vertical 
             if (sens == 'V')
             {
                 
                     if ( !"  ".equals(plateau[x][y]))
                     {
                        
                         bool_libre = false;
                     }
                 
             }
            }
             
        }while ( (bool_limite == false) || (bool_libre == false) );
        /// fin de la verification que la grille soit remplie 
        
        /// si on arrive ici toutes les condtitions pour pouvoir placer le bateau son respectées 
        
        /// on instancie les coordonnees de la premiere case du tableau 
        plateau[x][y]=nom;
    }
    
  /*  public void tirer(SousMarin test2) {
        
        int i;
        int j;
        int posX;
        int posY;
        
        Scanner px = new Scanner(System.in);
        Scanner py = new Scanner(System.in);
        
        System.out.println("Pour Tirer");
        System.out.println("Choisiez une position x:");
        
        posX = px.nextInt();
        
        System.out.println("Choisiez une position y:");
        
        posY = py.nextInt();
        
        for(i=0; i<posX; i++)
        {
            for(j=0; j<posY; j++)
            {
                if((test2.corps[i].x== posX) && (test2.corps[j].y== posY)) 
                {
                     
                     System.out.println("Vous avez toucher un ennemi");
                }
                
                else
                {
                    System.out.println("Vous n'avez rien toucher");
                }
                   
                
            }
        }*/
    
    
    
}
    
