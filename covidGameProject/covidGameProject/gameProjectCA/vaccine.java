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
public class vaccine {
    
    private double vaccinePosX;
    private double vaccinePosY;
    private int vaccineAmount;

    public vaccine() 
    {
        this.vaccinePosX = 500;
        this.vaccinePosY = 20;
        this.vaccineAmount = 3;
    }

    //Getters
    public double getVaccinePosX() 
    {
        return vaccinePosX;
    }

    public double getVaccinePosY() 
    {
        return vaccinePosY;
    }

    public int getVaccineAmount() 
    {
        return vaccineAmount;
    }

    
    //Setters

    public void setVaccinePosX(double vaccinePosX) 
    {
        this.vaccinePosX = vaccinePosX;
    }

    public void setVaccinePosY(double vaccinePosY) 
    {
        this.vaccinePosY = vaccinePosY;
    }

    public void setVaccineAmount(int vaccineAmount) 
    {
        this.vaccineAmount = vaccineAmount;
    }
    
    
    
}
