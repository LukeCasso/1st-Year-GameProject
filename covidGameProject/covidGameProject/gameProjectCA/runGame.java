/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author James Mitchell
 */
public class runGame {
     public static void main(String[] args) {
        
        
        //Setup Frame and Grpahics object
        JFrame frame= new JFrame("Test");
        
        //Set Details of Frame for graphics
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setResizable(false);
        frame.setBackground(Color.black);
        
        //Create my game and add to the frame
        covidGame myGame = new covidGame();
        frame.getContentPane().add(myGame);
        
        myGame.setupMouse();
        myGame.setupKeyboard();

   }
}
