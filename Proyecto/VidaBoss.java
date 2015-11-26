import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class VidaBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VidaBoss extends Actor
{
    
    /** Width of the life */
    private int width = 212;
  
    /** Height of the life */
    private int height = 13;
    
      
    /** color of this life */
    private Color color = Color.BLUE;
    
    /**
     * No argument constructor 
     */
    public VidaBoss()
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
    public VidaBoss(int theWidth, int theHeight, 
                  Color theColor)
    {
        width = theWidth;
        height = theHeight;
        color = theColor;
        updateImage();
    }
    
    
    /**
     * Act - do whatever the VidaBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
     * Cambia el tama?o de barra de vida 
     */
    public void disminuyeVida()
    {
            
            coordenada();
            width=width-10;
            updateImage();
           
           
                     
     }
     
     public void coordenada()
    {
        move(5);
    }
    
    
}
