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
//Class for the player bullet
public class playerBullet {
    
    //Fields
    public double playerBulletPosX;
    public double playerBulletPosY;
    public double playerBulletSpeedY;
    public boolean Alive;
    
    //Constructor
    public playerBullet() 
    {
        this.playerBulletPosY = 700;
        this.playerBulletSpeedY = 1;
        this.Alive = false;
    }

    //Getter
    public double getPlayerBulletPosX() 
    {
        return playerBulletPosX;
    }

    public double getPlayerBulletPosY() 
    {
        return playerBulletPosY;
    }

    public double getPlayerBulletSpeedY() 
    {       
        return playerBulletSpeedY;
    }

    public boolean isAlive() 
    {
        return Alive;
    }
    
    

    public void setPlayerBulletPosX(double playerBulletPosX) 
    {
        this.playerBulletPosX = playerBulletPosX;
    }

    public void setPlayerBulletPosY(double playerBulletPosY) 
    {
        this.playerBulletPosY = playerBulletPosY;
    }

    public void setPlayerBulletSpeedY(double playerBulletSpeedY) 
    {
        this.playerBulletSpeedY = playerBulletSpeedY;
    }

    public void setAlive(boolean Alive) 
    {
        this.Alive = Alive;
    }
    
    public void update()
    { 
            playerBulletPosY = playerBulletPosY - playerBulletSpeedY;  

    }
    
}
