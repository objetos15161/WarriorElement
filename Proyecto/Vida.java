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
  
    /** Width of the life */
    private int width = 212;
  
    /** Height of the life */
    private int height = 13;
    
      
    /** color of this life */
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
     * 
     * 
     */
    public void act() 
    { 
         
         if(width<10)
         gameOver();
         
    }
    
    public void gameOver()
    {
        createOver();
        Greenfoot.stop();
    }
    
    private void createOver()
    {
        GameOver newOver;
        
        newOver = new GameOver();
        
        ElementWorld world;
        world = (ElementWorld)getWorld();
        
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int x = worldWidth/2;
        int y = worldHeight/2;
        
        world.addObject(newOver, x,y,false);
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
     * Cambia el tama?o de barra de vida 
     */
    public void disminuyeVida()
    {
            
            coordenada();
            width=width-2;
            updateImage();
           
           
                     
     }
     
     public void coordenada()
    {
        move(-1);
    }
    
    }
    
   
    

