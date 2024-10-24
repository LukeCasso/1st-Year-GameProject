/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

/**
 *
 * @author David Murtagh
 */
public class Score {
    
    private String name;
    private int score;

    //Constructor
    public Score(String name, int score) 
    {
        this.name = name;
        this.score = score;
    }

    //Getters
    public String getName() 
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    //Setters
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setScore(int score) 
    {
        this.score = score;
    }
    
    @Override
    public String toString()
    { 
        return "Name: " + name + ", Score: " + score + '}';
    }
}
