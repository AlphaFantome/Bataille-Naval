/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author 33614
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Jeu jeu = new Jeu();
        jeu.initialisationgrilleJoueur();
        jeu.plateauEvolutifJoueur();
        jeu.initialisationgrilleAttaque();
        jeu.tableauEvolutifAttaque();
        
        jeu.affichageJoueurGrille();
        System.out.println("");
        jeu.affichageAttaqueGrille();
    }
    
}
