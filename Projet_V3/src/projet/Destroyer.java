/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
//import java.util.*;
/**
 *
 * @author admin
 */
public class Destroyer extends Bateaux {
    

    /// constructeur du Destroyer
    public Destroyer( String[][] plateau, String nomBateau ){
        
        nom = nomBateau;
        taille = 3;
        vie = 3;
        special = false;
        
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
            x = (int) ( Math.random() * ( 15 - 0 ) + 1 );            
            y = (int) ( Math.random() * ( 15 - 0 ) + 1 );

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
    
  /*  public void tirer(Destroyer test2) {
        
        int i;
        int j;
        int posX;
        int posY;
        int missile=1;
        
        Scanner px = new Scanner(System.in);
        Scanner py = new Scanner(System.in);
        
        System.out.println("Pour Tirer");
        System.out.println("Choisiez une position x:");
        
        posX = px.nextInt();
        
        System.out.println("Choisiez une position y:");
        
        posY = py.nextInt();
        
        if(missile==1)
        {
            for(i=0; i<posX; i++)
            {
            for(j=0; j<posY; j++)
            {
                if((test2.corps[i].x == posX) && (test2.corps[j].y== posY) || (test2.corps[i].x== posX+1) && (test2.corps[j].y== posY) ||(test2.corps[i].x == posX) && (test2.corps[j].y == posY+1)||(test2.corps[i].x == posX+1) && (test2.corps[j].y == posY+1)||(test2.corps[i].x == posX+2) && (test2.corps[j].y== posY) || (test2.corps[i].x== posX+3) && (test2.corps[j].y== posY) ||(test2.corps[i].x == posX) && (test2.corps[j].y == posY+2)||(test2.corps[i].x == posX) && (test2.corps[j].y == posY+3)||(test2.corps[i].x == posX+2) && (test2.corps[j].y== posY+2) || (test2.corps[i].x== posX+3) && (test2.corps[j].y== posY+2) ||(test2.corps[i].x == posX+2) && (test2.corps[j].y == posY+3)||(test2.corps[i].x == posX+3) && (test2.corps[j].y == posY+3))
                {
                     
                     System.out.println("position dévoiller");
                }                  
            }         
          }
        }
        
        
        else
        {
        
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
        } 
        }*/
}
    
