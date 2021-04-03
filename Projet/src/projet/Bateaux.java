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
    public String nom;
    public char sens;
    Coord[] corps;
    
         public void deplacer(Object test)
         {
             int choix;        
             Scanner move = new Scanner(System.in);
        
            System.out.println("Choissisez un déplacement");
            System.out.println("1-Droite");
            System.out.println("2-Gauche");
            System.out.println("3-Haut");
            System.out.println("4-Bas");
            choix = move.nextInt();
        
        
            while(choix<0 || choix>4)
            {
            
            if(choix==1)
            {
                for(int i=0; i<taille; i++)
                {
                    corps[i].x++;
                }
                System.out.println("Vous avez décidez de faire un déplacement vers la droite");
            }
                
                
            if(choix==2)
            {
                for(int i=0; i<taille; i++)
                {
                    corps[i].x--;
                }
                System.out.println("Vous avez décidez de faire un déplacement vers la gauche");
            }
                
            if(choix==3)
            {
                for(int i=0; i<taille; i++)
                {
                    corps[i].y++;
                }
                System.out.println("Vous avez décidez de faire un déplacement vers le bas");
            }
                
            if(choix==4)
            {
                for(int i=0; i<taille; i++)
                {
                    corps[i].y--;
                }
                System.out.println("Vous avez décidez de faire un déplacement vers la haut");
            }
         }
        
         }
         

}
