/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

import java.util.ArrayList;

/**
 *
 * @author David Murtagh
 */
public class LeaderBoard {
    
    private String name;
    public  ArrayList<Score> allScores;

    //Constructor
    public LeaderBoard(String name, ArrayList<Score> allScores) 
    {
        this.name = name;
        this.allScores = allScores;
    }

    public LeaderBoard() 
    {
        
    }


    //Getters
    public String getName() 
    {
        return name;
    }

    public ArrayList<Score> getAllScores() 
    {
        return allScores;
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setAllScores(ArrayList<Score> allScores)
    {
        this.allScores = allScores;
    }
    
    public void addScore(Score newScore)
    {
        allScores.add(newScore);
    }
    
    @Override
    public String toString()
    {
        return  name + " Leaderboards" + ": " + allScores;
    }
}
