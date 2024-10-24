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

//Class for the Player
public class player {
    
    //Fields for the Player
    public double playerPosX;
    public double playerPosY;
    public double playerSpeedX =50;
    public double playerSpeedY =20;

    //Constructor
    public player() 
    {
        this.playerPosX = 450;
        this.playerPosY = 900;

    }

    //Getter
    public double getPlayerPosX() 
    {
        return playerPosX;
    }

    public double getPlayerPosY() 
    {
        return playerPosY;
    }

    public double getPlayerSpeedX() 
    {
        return playerSpeedX;
    }

    public double getPlayerSpeedY() 
    {
        return playerSpeedY;
    }
    
    
    //Setter

    public void setPlayerPosX(double playerPosX) 
    {
        this.playerPosX = playerPosX;
    }

    public void setPlayerPosY(double playerPosY) 
    {
        this.playerPosY = playerPosY;
    }
    
    public void setPlayerSpeedX(double playerSpeedX) 
    {
        this.playerSpeedX = playerSpeedX;
    }

    public void setPlayerSpeedY(double playerSpeedY) 
    {
        this.playerSpeedY = playerSpeedY;
    }
    
    public void playerMovement()
    {
        
    }
    
}
