/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author amaur
 */
public class Deserialisation {
    
    public int victoire;
    /**
     * 
     */
     public Deserialisation()
    {
        
    }
    /**
     * 
     */
    public void DeserialisationGame(){

    Bateaux[] tabBateauJoueur = new Bateaux[10];
    Bateaux[] tabBateauAI = new Bateaux[10];
    String[][] plateauJoueur = new String[15][15];  
    String [][] plateauAttaque = new String[15][15];
    
    try{

        FileInputStream fis = new FileInputStream("sauvegarde.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
         
        tabBateauJoueur = (Bateaux[])ois.readObject();
        tabBateauAI = (Bateaux[])ois.readObject();
         plateauJoueur = (String[][])ois.readObject();  
         plateauAttaque = (String[][])ois.readObject();    
         
         
         Jeu jeu = new Jeu(tabBateauJoueur,tabBateauAI, plateauJoueur, plateauAttaque);
         
         jeu.affichageJoueurGrille();
         jeu.affichageAttaqueGrille();
         jeu.choixAction();
         victoire=jeu.victoire;
         
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 
     * @return 
     */
    public int getVictoire()
    {
        return this.victoire;
    }
}
