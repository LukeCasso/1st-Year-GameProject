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
public class cursor {
    public double cursorPosX;
    public double cursorPosY;
    public double cursorSpeedY;

    public cursor() 
    {
        this.cursorPosX = 350;
        this.cursorPosY = 480;
        this.cursorSpeedY = 110;
    }

    //Getter
    public double getCursorPosX() 
    {
        return cursorPosX;
    }

    public double getCursorPosY() 
    {
        return cursorPosY;
    }

    public double getCursorSpeedY() 
    {
        return cursorSpeedY;
    }

    //Setter
    public void setCursorPosX(double cursorPosX) 
    {
        this.cursorPosX = cursorPosX;
    }

    public void setCursorPosY(double cursorPosY) 
    {
        this.cursorPosY = cursorPosY;
    }

    public void setCursorSpeedY(double cursorSpeedY) 
    {
        this.cursorSpeedY = cursorSpeedY;
    }
    
      
}
