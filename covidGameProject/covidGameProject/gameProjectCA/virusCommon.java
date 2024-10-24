/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

/**
 *
 * @author James Mitchell
 * 
 */

//Class for the Common Enemy type
public class virusCommon {
    
    //Fields for Common enemy type
    public double virusCommonPosY;
    public double virusCommonPosX;
    public double speedCommonX;
    public boolean alive;


    //Constructor
    

    public virusCommon(double virusCommonPosY, double virusCommonPosX, double speedCommonX, boolean alive) 
    {
        this.virusCommonPosY = virusCommonPosY;
        this.virusCommonPosX = virusCommonPosX;
        this.speedCommonX = speedCommonX;
        this.alive = alive;
        
    }

    public virusCommon() {
    }

    //Getters
    public double getVirusCommonPosY() 
    {
        return virusCommonPosY;
    }

    public  double getVirusCommonPosX() 
    {
        return virusCommonPosX;
    }

    public  double getSpeedCommonX() 
    {
        return speedCommonX;
    }

    public boolean isAlive() 
    {
        return alive;
    }
    
    
    

    //Setters
    public void setVirusCommonPosY(double virusCommonPosY) 
    {
        this.virusCommonPosY = virusCommonPosY;
    }

    public void setVirusCommonPosX(double virusCommonPosX) 
    {
        this.virusCommonPosX = virusCommonPosX;
    }

    public void setSpeedCommonX(double speedCommonX)
    {
        this.speedCommonX = speedCommonX;
    }

    public void setAlive(boolean alive) 
    {
        this.alive = alive;
    }

    
    public void update()
    {       
            virusCommonPosX=virusCommonPosX+speedCommonX;  
            if(virusCommonPosX>=920 || virusCommonPosX<=0)
            {
               speedCommonX=-speedCommonX;
            }      
   }
    
    
}
