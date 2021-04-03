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
public class Coord {
    
    public int x;
    public int y;
    public boolean plein;
    public String valeur;
    public boolean touche;
    
    public Coord()
    {
        plein=false;
        valeur=" ";
        touche=false;
        x=0;
        y=0;
    }
        
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
}
