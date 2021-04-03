/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author amaur
 */
public class Serialisation {
    public Serialisation()
    {
        
    }    
    public void SerialisationGame(Bateaux[] tabBateauJoueur , Bateaux[] tabBateauAI, String[][] plateauJoueur, String [][] plateauAttaque ){
       

        try{
            
            FileOutputStream fos = new FileOutputStream("sauvegarde.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);

            os.writeObject(tabBateauJoueur);
            os.writeObject(tabBateauAI);
            os.writeObject(plateauJoueur);
            os.writeObject(plateauAttaque);
            
            
                        
            os.close();
    
          
         
           }catch(IOException e){
            e.printStackTrace();
           }        
         }
    
}
