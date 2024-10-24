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
public class playerHealth {
    public double lifePosX;
    public double lifePosY;
    public int lifeAmount;

    public playerHealth() 
    {
        this.lifePosX = 300;
        this.lifePosY = 20;
        this.lifeAmount = 1;
    }

    //Getters
    public double getLifePosX() 
    {
        return lifePosX;
    }

    public double getLifePosY() 
    {
        return lifePosY;
    }

    public int getLifeAmount() 
    {
        return lifeAmount;
    }

    //Setters
    public void setLifePosX(double lifePosX) 
    {
        this.lifePosX = lifePosX;
    }

    public void setLifePosY(double lifePosY) 
    {
        this.lifePosY = lifePosY;
    }

    public void setLifeAmount(int lifeAmount) 
    {
        this.lifeAmount = lifeAmount;
    }
    
    
    
}
