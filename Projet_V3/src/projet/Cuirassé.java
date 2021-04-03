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
public class Cuirassé extends Bateaux {
    
    /// constructeur du cuirasse 
    public Cuirassé( String[][] plateau, String nomBateau  ){
        
        nom = nomBateau;
        taille = 7;
        vie = 7;
        special = false;
        
        /// determination du sens du bateau  
       int aleatoire; 
        aleatoire = (int) (Math.random()*(2)); 
        
        if ( aleatoire == 0 )
            sens = 'H';
        else 
            sens = 'V';
        
        /// blindage du sens du bateau 
        
        /// les variables x et y nous servent a determiner aleatoirement la position du bateau
        int x=-1;
        int y=-1;         

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
                if ( ( x + 7 ) > 14 )
                {
                    bool_limite = false;
                }
            } 
            
            /// pour le sens horizontal 
            else if ( sens == 'H' )
            {
                 
                 /// on verifie que la taille ne depasse pas du plateau 
                 if ( ( y + 7 ) > 14 )
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
        
        /// on attribut au plateau le nom du bateau sur chaque case qu il occupe  
        if ( sens == 'V' )
        {
            for ( int i = x; i < x + 7; i++ )
                plateau[i][y] = nom;
        }
        
        if ( sens == 'H' )
        {
            for ( int i = y; i < y + taille; i++ )
                plateau[x][i] = nom;
        }
    }

   /* public void tirer(Cuirassé test2) {
        
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

    }*/
    
    
    
}
