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
public class enemyBullet {
    
    public double enemyBulletPosX;
    public double enemyBulletPosY;
    public double enemyBulletSpeedY;
    public boolean Alive;

    public enemyBullet(double enemyBulletPosX, double enemyBulletPosY, double enemyBulletSpeedY, boolean Alive) 
    {
        this.enemyBulletPosX = enemyBulletPosX;
        this.enemyBulletPosY = enemyBulletPosY;
        this.enemyBulletSpeedY = enemyBulletSpeedY;
        this.Alive = Alive;
    }
    public enemyBullet()
    {
        
    }

    //Getters
    public double getEnemyBulletPosX() 
    {
        return enemyBulletPosX;
    }

    public double getEnemyBulletPosY() 
    {
        return enemyBulletPosY;
    }

    public double getEnemyBulletSpeedY() 
    {
        return enemyBulletSpeedY;
    }

    public boolean isAlive() 
    {
        return Alive;
    }

    //Setters
    public void setEnemyBulletPosX(double enemyBulletPosX) 
    {
        this.enemyBulletPosX = enemyBulletPosX;
    }

    public void setEnemyBulletPosY(double enemyBulletPosY) 
    {
        this.enemyBulletPosY = enemyBulletPosY;
    }

    public void setEnemyBulletSpeedY(double enemyBulletSpeedY) 
    {
        this.enemyBulletSpeedY = enemyBulletSpeedY;
    }

    public void setAlive(boolean Alive) 
    {
        this.Alive = Alive;
    }
    
    public void update()
    {
        Alive = true;
        enemyBulletPosY = enemyBulletPosY + enemyBulletSpeedY;
    }

   
    
}
