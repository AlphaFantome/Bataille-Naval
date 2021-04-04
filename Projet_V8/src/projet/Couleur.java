/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.Serializable;
/**
 *
 * @author amaur
 */
public class Couleur implements Serializable{
    
        public final String ColorRed = "\u001B[31m";
        public final String ColorGreen = "\u001B[32m";
        public final String ColorYellow = "\u001B[33m";
        public final String ColorBlue = "\u001B[34m";
        public final String ColorPurple = "\u001B[35m";
        public final String ColorCyan = "\u001B[36m";
        public final String ColorBlack = "\u001B[30m";

    /**
     * 
     * @return 
     */
    public String getColorR()
    {
        return this.ColorRed;
    }
    /**
     * 
     * @return 
     */
    public String getColorG()
    {
        return this.ColorGreen;
    }
    /**
     * 
     * @return 
     */
    public String getColorY()
    {
        return this.ColorYellow;
    }
    /**
     * 
     * @return 
     */
    public String getColorB()
    {
        return this.ColorBlue;
    }
    /**
     * 
     * @return 
     */
    public String getColorP()
    {
        return this.ColorPurple;
    }
    /**
     * 
     * @return 
     */
    public String getColorC()
    {
        return this.ColorCyan;
    }
    /**
     * 
     * @return 
     */
    public String getColorBl()
    {
        return this.ColorBlack;
    }
    
}
