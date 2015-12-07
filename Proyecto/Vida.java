import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 *Clase que representa la Vida de Warrior  
 * 
 * @author Barbara Ericson, Georgia Tech
 * @author Omar Negrete, Leonardo Hervert. 
 * @version 19/Nov/2015
 */
public class Vida extends Actor
{
      
    /** Largo de la barra de vida */
    private int width = 212;
  
    /** Ancho de la barra de vida*/
    private int height = 13;
    
      
    /** Color de la barra de vida */
    private Color color = Color.RED;
    
    private SimpleTimer time = new SimpleTimer();   
         
     /**
     * Constructor de la barra de  Vida de Warrior.
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
     */
    public Vida(int theWidth, int theHeight, 
                  Color theColor)
    {
        width = theWidth;
        height = theHeight;
        color = theColor;
        updateImage();
    }
    
   

    /**
     * Genera un mensaje de GameOver al pasar el limite de vida.
     */
    public void act() 
    { 
         if(width<10)
         {
           gameOver();
         }
    }
    
    /**
     * Llama a otro metodo y detiene el juego.
     */
    public void gameOver()
    {
        createOver();
        Greenfoot.stop();
    }
    
    /**
     * Genera una imagen de GameOver.
     */
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
     * Realiza cambios fisicos de la barra de Vida.
     */
    public void updateImage()
    {
       
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(color);
        image.fillRect(0,0,width,height);
        setImage(image);
      
    }
    
     /**
     * Cambia el tamano de la barra de vida 
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
    
   
    

