/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameProjectCA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James Mitchell
 */
public class covidGame extends JPanel{
    //Fields
    //Enemy arrays
    private virusCommon[] infection = new virusCommon[10];
    private virusElite[] infection2 = new virusElite[5];
    //Player
    private player bloodCell = new player();
    //Vaccine
    private vaccine needle = new vaccine();
    //Player Bullet Object
    private playerBullet bullet1 = new playerBullet();
    //Enemy Bullet Object
    private enemyBullet[] bullet2 = new enemyBullet[10];
    //Player Health Object
    private playerHealth life = new playerHealth();
    //Cursor Object for title screen
    private cursor arrow = new cursor();
    //Player's Name and Score
    private String playerName ="";
    private int playerScore = 0;
    //Array for list scores
    private ArrayList<Score> listScores = new ArrayList<>();
    //
    private int count = 1;
 

    
    //1 - Main Screen etc
    private int gameState = 1;
    //Game Timer
    private Date gameTime;
    long gameTimeSeconds;
    
    
   //Constructor
   public covidGame()
   { 
       //Loops to create enemy types
       for (int i = 0; i < infection2.length; i++) 
       {
          infection2[i] = new virusElite(150, 200 + 65 *i, 0.3, true); 
       }
       for (int i = 0; i < infection.length; i++) 
       {    
          infection[i] = new virusCommon(250, 200 +50*i ,0.1, true);           
       }
       
       for (int i = 0; i < bullet2.length; i++) 
       {
           bullet2[i] = new enemyBullet(260.0 + 50.0*i, 210.0, 0.1, true);          
       }
         
   }
   
   //Method for Mouse Usage
   public void setupMouse()
   {
       addMouseListener(new MouseAdapter()
       {
           public void mousePressed(MouseEvent me)
           {    
               System.out.println("Mouse Check - " + me.getX());
               //Changes from Start Menu to main game when mouse is clicked, timer also starts at this moment               
               //If statements are for cursor at different points on screen
               if(gameState==1 && arrow.getCursorPosY()==480)
               {
                   //Audio for Selecting a menu option
                   selectSound();
                   enterDetails();
                   gameState=2; 
                   gameTime = new Date(System.currentTimeMillis());
                   backgroundMusic();
      
              }
               //Quit Game For Main Menu
              if(gameState==1 && arrow.getCursorPosY()==700)
              {
                  selectSound();
                  gameState=3;
                  System.exit(0);
              }
              //Mouse Click for Score Screen
              else if(gameState==1 && arrow.getCursorPosY()==590)
              {
                  selectSound();
                  gameState=5;
              }
              //Click to close game on game over or victory screen
              else if(gameState==3 || gameState==4)
              {
                   try 
                   {
                       recordScores();
                   } 
                   catch (IOException ex) 
                   {
                       Logger.getLogger(covidGame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  System.exit(0);
              }
              else if(gameState==5)
              {
                  System.exit(0);
              }
              
              //To leave the score screen just click anywhere and it sends you back to Main Menu

           }
       });
   }
   //Method for Keyboard Usage
   public void setupKeyboard()
   {
       requestFocusInWindow();
       this.addKeyListener(new KeyAdapter(){
           
           public void keyPressed(KeyEvent e)
           {
               //Player Movement to the right
               if(e.getKeyCode() == e.VK_RIGHT)
               {
                   //Catch to make sure player doesn't go offscreen
                   if(bloodCell.getPlayerPosX()<900)
                   {
                       bloodCell.setPlayerPosX(bloodCell.getPlayerPosX()+bloodCell.getPlayerSpeedX());
                   }
                   
               }
               //Player Movement to the left
               if(e.getKeyCode() == e.VK_LEFT)
               {
                   //Catch to make sure player doesn't go offscreen
                   if(bloodCell.getPlayerPosX() >20)
                   {
                       bloodCell.setPlayerPosX(bloodCell.getPlayerPosX() - bloodCell.getPlayerSpeedX());
                   }
                   
               }
               
               //Player Movement Up
               if(e.getKeyCode() == e.VK_UP)
               {
                   if(bloodCell.getPlayerPosY() > 800)
                   {
                       bloodCell.setPlayerPosY(bloodCell.getPlayerPosY() - bloodCell.getPlayerSpeedY());
                   }
                   //Movement Up for Cursor on Title Screen
                   if(gameState==1 && arrow.getCursorPosY()>480)
                   {
                       arrow.setCursorPosY(arrow.getCursorPosY() - arrow.getCursorSpeedY());
                       menuSound(); 
                    }
               }
               
               //Player Movement Down, has to be taken away as its on the Y axis.
               if(e.getKeyCode() == e.VK_DOWN)
               {
                   if(bloodCell.getPlayerPosY() < 900)
                   {
                       bloodCell.setPlayerPosY(bloodCell.getPlayerPosY() + bloodCell.getPlayerSpeedY());
                   }
                   
                   //Movement Down on title screen
                   if(gameState==1 && arrow.getCursorPosY()<600)
                   {   
                       menuSound(); 
                       arrow.setCursorPosY(arrow.getCursorPosY() + arrow.getCursorSpeedY());
                   }
               }

               if(e.getKeyCode() == 32 && !bullet1.isAlive())
               { 
                   playerShooting();
                   bullet1.setAlive(true);
                   bullet1.setPlayerBulletPosX(bloodCell.getPlayerPosX()+30);
                   bullet1.setPlayerBulletPosY(850);
                   
               } 

           } 
           
       });
  
   }

   //Graphics Parent Method, draws all Graphics
   public void paintComponent(Graphics g) 
   { 
       //This method runs repeatedly
       super.paintComponent(g);
       
       //Draw Frame elements
       g.setColor(Color.black);
       g.fillRect(0, 0, 1000, 1000);
       
       //Conditions for different Game stages
       if(gameState==1)
       {      
           drawStart(g);
       }
       else if(gameState==2)
       {                
            drawElements(g);  
            update();            
       }
       
       else if(gameState==3)
       {            
            drawVictory(g);
       }
       
       else if(gameState==4)
       {           
           drawDefeat(g); 
       }
       
       else if(gameState==5)
       {           
           try 
           {
               drawScores(g);
           } 
           catch (FileNotFoundException ex) 
           {
               Logger.getLogger(covidGame.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       //Paint the panel
       repaint();
   }
   
   //Main Menu Screen
   public void drawStart(Graphics g)
   {
       
       String titleFilename = "title.png";
       ImageIcon startScreen = new ImageIcon(titleFilename); 
       g.drawImage(startScreen.getImage(), 0, 0, null); 
       String cursorFilename = "cursor.png";
       ImageIcon cursor = new ImageIcon(cursorFilename); 
       g.drawImage(cursor.getImage(), (int)arrow.getCursorPosX() , (int)arrow.getCursorPosY() , null); 
       
   }
   
   //Victory Screen
   public void drawVictory(Graphics g)
   {
       
       String victoryFilename = "victory.png";
       ImageIcon startScreen = new ImageIcon(victoryFilename); 
       g.drawImage(startScreen.getImage(), 0, 0, null);
   }
   
   //Draw Score Screen
   public void drawScores(Graphics g) throws FileNotFoundException
   {

       String scoresFilename = "scores.png";
       ImageIcon scoreScreen = new ImageIcon(scoresFilename);
       g.drawImage(scoreScreen.getImage(), 0, 0, null);
       
       g.setFont(new Font("Calibri", Font.BOLD, 20));
       g.setColor(Color.BLUE); 
       
       File myObj = new File ("Scores.txt");
       Scanner myReader = new Scanner(myObj);  
       
       while(myReader.hasNextLine())
       {  
            count++;
            String data = myReader.nextLine();
            g.drawString(data, 400, 200+40*count);
            
       }
       count = 0;
  
   }
   
   //Draw Defeat Screen
   public void drawDefeat(Graphics g)
   {
       
       String defeatFilename = "defeat.jpg";
       ImageIcon defeatScreen = new ImageIcon(defeatFilename);
       g.drawImage(defeatScreen.getImage(), 0, 0, null);
             
   }
   
   //Movement for enemy and other updates
   public void update()
   {     
       
       //Player Attack
        if(bullet1.isAlive())
        {
            bullet1.update();
            
            //Remove Bullet when it goes offscreen
            if(bullet1.getPlayerBulletPosY() < 0)
            {
                bullet1.setAlive(false);
            }
            
            //Collision Code for Basic Enemy Type
            for (int i = 0; i < infection.length; i++) 
            {
                
                boolean collision = false;
                if(bullet1.getPlayerBulletPosX() > infection[i].getVirusCommonPosX() && bullet1.getPlayerBulletPosX() < infection[i].getVirusCommonPosX() + 50 && bullet1.getPlayerBulletPosY() > infection[i].getVirusCommonPosY() && bullet1.getPlayerBulletPosY() < infection[i].getVirusCommonPosY() + 50)
                {
                    collision = true;
                }
                if(collision)
                {
                    infection[i].setAlive(false);
                    infection[i].setVirusCommonPosX(-50);
                    infection[i].setSpeedCommonX(0);
                    checkVictory();
                    bullet1.setAlive(false);   
                    playerScore = playerScore + 10;
                    //Audio for when enemy is destroyed
                    damageSound();
                   
                }
            }
        
            //Collision Code for Elite Enemy
            for (int i = 0; i < infection2.length; i++) 
            {
                boolean collision = false;
                if(bullet1.getPlayerBulletPosX() > infection2[i].getVirusElitePosX() && bullet1.getPlayerBulletPosX() < infection2[i].getVirusElitePosX() + 50 && bullet1.getPlayerBulletPosY() > infection2[i].getVirusElitePosY() && bullet1.getPlayerBulletPosY() < infection2[i].getVirusElitePosY() + 50)
                {
                    collision = true;
                }           
                if(collision)
                {
                    infection2[i].setAlive(false);
                    infection2[i].setVirusElitePosX(9000);
                    checkVictory();
                    bullet1.setAlive(false);
                    playerScore = playerScore + 20;
                    //Audio for when enemy is destroyed
                    damageSound();    
                }
            }    
        }

        //Enemy movements left to right
       for (int i = 0; i < infection.length; i++) 
       {
            infection[i].update(); 
            bullet2[i].setEnemyBulletPosX(infection[i].getVirusCommonPosX()+30);
       }
       for (int i = 0; i < infection2.length; i++) 
       {
           infection2[i].update();
       }
       
       //Time update
       Date currentTime = new Date(System.currentTimeMillis());
       gameTimeSeconds = (currentTime.getTime() - gameTime.getTime())/1000;
       
       //Resets Enemy Bullets back to their starting position after they go offscreen
       for (int i = 0; i < bullet2.length; i++) 
       {
           //Collision for Enemy Bullets
           if(bullet2[i].Alive)
           {
              boolean collision = false;
              
              //Bullet Collision with Player
              if(bullet2[i].getEnemyBulletPosX() > bloodCell.getPlayerPosX() && bullet2[i].getEnemyBulletPosX() < bloodCell.getPlayerPosX() + 50 && bullet2[i].getEnemyBulletPosY() > bloodCell.getPlayerPosY() && bullet2[i].getEnemyBulletPosY() < bloodCell.getPlayerPosY() + 40)
                {
                    collision = true;
                }
              if(collision)
                {
                    bullet2[i].setAlive(false);
                    checkHit();
                    
                }
          
           }
           if(bullet2[i].getEnemyBulletPosY()>1000)
           {
               bullet2[i].setEnemyBulletPosY(infection[i].getVirusCommonPosY());
           }
                    
       }

   }

    
   //Draw Panel for Game State 2: enemies, player and timer
    public void drawElements(Graphics g)
    {
        //Background Image Gets Drawn First
        String backgroundFilename = "background.jpg";
        ImageIcon background = new ImageIcon(backgroundFilename);
        g.drawImage(background.getImage(), 0, 0, null);
        
        g.setFont(new Font("Calibri", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("Time: " + gameTimeSeconds, 850, 40);
        
        g.setFont(new Font("Calibri", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + playerScore, 40, 40);

        //Basic Enemy Type Image
        String virusBaseFilename = "virusBase.png";
        ImageIcon virusBase = new ImageIcon(virusBaseFilename); 
        for (int i = 0; i < infection.length; i++) 
        {
            if(infection[i].isAlive())
            {
                g.drawImage(virusBase.getImage(), (int)infection[i].getVirusCommonPosX(),(int)infection[i].getVirusCommonPosY() , null); 
            }
            
        }
        //Advanced Enemy Type Image
        String virusAdvancedFilename = "virusAdvanced.png";
        ImageIcon virusAdvanced = new ImageIcon(virusAdvancedFilename); 
        for (int i = 0; i < infection2.length; i++) 
        {
            if(infection2[i].isAlive())
            {
                g.drawImage(virusAdvanced.getImage(), (int)infection2[i].getVirusElitePosX(), (int)infection2[i].getVirusElitePosY(), null);
            }
             
        }
        
        //Drawing the Enemy Bullets
        String enemyBulletFilename = "enemyBullet.png";
        ImageIcon enemyBullet = new ImageIcon(enemyBulletFilename);
        for (int i = 0; i < infection.length; i++) 
        { 

            g.drawImage(enemyBullet.getImage(), (int)bullet2[i].getEnemyBulletPosX(),(int)bullet2[i].getEnemyBulletPosY() , null);                         

            bullet2[i].update();

            if(bullet2[i].getEnemyBulletPosY() > 1000)
            {
                bullet2[i].setAlive(false);
            }
        }

        //Draw for Player Bullets
        String playerBulletFilename = "playerBullet.png";
        ImageIcon playerBullet = new ImageIcon(playerBulletFilename);
        if(bullet1.isAlive())
        {
            g.drawImage(playerBullet.getImage(), (int)bullet1.getPlayerBulletPosX(), (int)bullet1.getPlayerBulletPosY(), null);
        }
 
        //Draw for Player Image
        String playerFilename = "player.png";
        ImageIcon player = new ImageIcon(playerFilename); 
        g.drawImage(player.getImage(), (int)bloodCell.getPlayerPosX() , (int)bloodCell.getPlayerPosY() , null); 
        
        //Draw for Vaccine Amount
        String vaccineFilename = "vaccine.png";
        ImageIcon vaccine = new ImageIcon(vaccineFilename);
        for (int i = 0; i < needle.getVaccineAmount(); i++) 
        {
            g.drawImage(vaccine.getImage(), (int)needle.getVaccinePosX()+50*i, (int)needle.getVaccinePosY(), null);
        }
        
        //Draw for Player Health
        String healthFilename = "life.png";
        ImageIcon heart = new ImageIcon(healthFilename);
        for (int i = 0; i < life.getLifeAmount(); i++) 
        {
            g.drawImage(heart.getImage(), (int)life.getLifePosX()+50*i, (int)life.getLifePosY(), null);
        }

    }

    
    //Background Music Method
    public void backgroundMusic()
    {
        try
        {       
            String fileIn = "battle.wav";
            FileInputStream battleFile;
            battleFile = new FileInputStream(new File(fileIn));

//            AudioStream battleSound = new AudioStream(battleFile);
//            AudioPlayer.player.start(battleSound);

        }
    catch(Exception f)
        {
            System.out.println(f.toString());         
        }
 
    }

    //Player Shooting Method
    public void playerShooting()
    {
        try
        {
            String fileIn = "playerShot.wav";
            FileInputStream bullet1File;
            bullet1File = new FileInputStream(new File(fileIn));

//            AudioStream playerShotSound = new AudioStream(bullet1File);
//            AudioPlayer.player.start(playerShotSound);

        }
        catch(Exception f)
        {
            System.out.println(f.toString());         
        }
    }
    
    //Damage Sound Method
    public void damageSound()
    {
        try
        {
            String fileIn = "damage.wav";
            FileInputStream damageFile;
            damageFile = new FileInputStream(new File(fileIn));

//            AudioStream damageSound = new AudioStream(damageFile);
//            AudioPlayer.player.start(damageSound);

        }
        catch(Exception f)
        {
            System.out.println(f.toString());         
        }
        
    }
    //Menu Navigation Sound
    public void menuSound()
    {
        try
        {
             String fileIn = "menu.wav";
             FileInputStream menuMovementFile;
             menuMovementFile = new FileInputStream(new File(fileIn));

//             AudioStream menuMovementSound = new AudioStream(menuMovementFile);
//             AudioPlayer.player.start(menuMovementSound);
         }
         catch(Exception f)
         {
             System.out.println(f.toString());         
         }
    }
    
    //Menu Select Sound
    public void selectSound()
    {
        try
        {
            String fileIn = "select.wav";
            FileInputStream selectFile;
            selectFile = new FileInputStream(new File(fileIn));
//
//            AudioStream menuSelectSound = new AudioStream(selectFile);
//            AudioPlayer.player.start(menuSelectSound);
        }
        catch(Exception f)
        {
            System.out.println(f.toString());         
        }
    }
    
    public void deathSound()
    {
        System.out.println("Audio played");
        try
        {
            String fileIn = "death.wav";
            FileInputStream deathFile;
            deathFile = new FileInputStream(new File(fileIn));

//            AudioStream deathSound = new AudioStream(deathFile);
//            AudioPlayer.player.start(deathSound);
        }
        catch(Exception f)
        {
            System.out.println(f.toString());         
        }
    }
        
    public void checkHit()
    {
        System.out.println("Player was hit");
        life.lifeAmount = life.lifeAmount -1;
        //When the Player's health reaches zero
        if(life.lifeAmount<1)
        {   
            deathSound();
            gameState=4;
        }
        
    }
    
    //Method to Check if the player has killed all enemies
    public void checkVictory()
    {      
        System.out.println("Checking if Player Won");
        boolean victory = true;
        for (int j = 0; j <infection.length; j++) 
        {
            if(infection[j].isAlive())
            {             
                   victory=false;
                   System.out.println("Player didn't Win");                   
            }       
        } 
        for (int i = 0; i < infection2.length; i++) 
        {
            if(infection2[i].isAlive())
            {             
                   victory=false;
                   System.out.println("Player didn't Win");                   
            }
        }
        if(victory)
        {
                System.out.println("Player Wins");
                gameState = 3; 
        }
    }
    
    //Method for entering player name upon starting the game
    public void enterDetails()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please Enter Your Name: ");
        playerName = keyboard.nextLine();
        
    }
    
    //Method to Record Scores and place them in ArrayList
    public void recordScores() throws IOException
    {
        
        listScores.add(new Score (playerName, playerScore));           
        
        //Create File
        File myObj = new File ("Scores.txt");
        Scanner myReader = new Scanner(myObj); 
      
        
        //LeaderBoard gameLeaderboard = new LeaderBoard("Infection", listScores);
        
        //Writing to File
        FileWriter myWriter = new FileWriter("Scores.txt", true);
        myWriter.write(listScores.toString()+"\n");
        myWriter.close();
        
        //Reading from File
        while(myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            System.out.println(data);
        }

    }
}

