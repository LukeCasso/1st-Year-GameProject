/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

/**
 *
 * @author James Mitchell
 */

//Class for the Elite enemy type
public class virusElite {
    
    //Fields for Elite enemy type
    public double virusElitePosY;
    public double virusElitePosX;
    public double speedEliteX;
    public boolean alive;
    
    //Constructor

    public virusElite(double virusElitePosY, double virusElitePosX, double speedEliteX, boolean alive) 
    {
        this.virusElitePosY = virusElitePosY;
        this.virusElitePosX = virusElitePosX;
        this.speedEliteX = speedEliteX;
        this.alive = alive;
    }
    

    public virusElite() 
    {
        
    }
    
    //Getters
    public  double getVirusElitePosY() 
    {
        return virusElitePosY;
    }

    public double getVirusElitePosX() 
    {
        return virusElitePosX;
    }

    public  double getSpeedEliteX() 
    {
        return speedEliteX;
    }

    public boolean isAlive() 
    {
        return alive;
    }

    
    
    
    //Setters
    public void setVirusElitePosY(double virusElitePosY) 
    {
        this.virusElitePosY = virusElitePosY;
    }

    public void setVirusElitePosX(double virusElitePosX) 
    {
        this.virusElitePosX = virusElitePosX;
    }

    public void setSpeedEliteX(double speedEliteX) 
    {
        this.speedEliteX = speedEliteX;
    }

    public void setAlive(boolean alive) 
    {
        this.alive = alive;
    }
    
    
    public void update()
    { 
       
 
             virusElitePosX = virusElitePosX + speedEliteX;

            if(virusElitePosX>=920 || virusElitePosX<=0)
            {
               speedEliteX=-speedEliteX;
            }
    
   }
    
}
