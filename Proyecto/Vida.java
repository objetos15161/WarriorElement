import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * A paddle is a rectangular object that can be moved via the left
 * and right arrow keys.  
 * 
 * @author Barbara Ericson, Georgia Tech
 * @version 1.0 April 6, 2007
 */
public class Vida extends Actor
{
    /////////////// fields ////////////////////
  
    /** Width of the paddle */
    private int width = 212;
  
    /** Height of the paddle */
    private int height = 13;
    
      
    /** color of this paddle */
    private Color color = Color.RED;
    
  
    
 
    
    ///////////// constructors ///////////////////////////
  
    /**
     * No argument constructor 
     */
    public Vida()
    {
        updateImage();
    }
    
    /**
     * Constructor that takes the width, height, color, and moveAmount
     * @param theWidth the width to use
     * @param theHeight the height to use
     * @param theColor the color to use
     * @param theAmount the number of cells (pixels) to move
     */
    public Vida(int theWidth, int theHeight, 
                  Color theColor)
    {
        width = theWidth;
        height = theHeight;
        color = theColor;
        updateImage();
    }
    
    ///////////////////// Methods ///////////////////////////////

    /**
     * Act - a paddle will move in reaction to a left or right
     * arrow key being pressed
     */
    public void act() 
    { 
         
         //disminuyeVida();
         
    }
    
    /**
     * Method to create and set the image for this paddle.  Invoke
     * this method again when the width, height, or color change.
     */
    public void updateImage()
    {
       
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(color);
        image.fillRect(0,0,width,height);
        setImage(image);
      
    }
    
     /*
     * Cambia el tama?o de Paddle cada minuto
     */
    public void disminuyeVida()
    {
            
            coordenada();
            width=width-10;
            updateImage();
           
           
                     
     }
     
     public void coordenada()
    {
        move(-5);
    }
    
    }
    
   
    

