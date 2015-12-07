import greenfoot.*;
import java.awt.Color;
/**
 * Clase que representa la vida de Boss.
 * @author Barbara Ericson, Georgia Tech
 * @author Omar Negrete, Leonardo Hervert. 
 * @version 06/Dic/2015
 */
public class VidaBoss extends Actor
{
    private SimpleTimer time=new SimpleTimer();
    
    /** Largo de la barra de vida */
    private int width = 212;
  
    /** Ancho de la barra de vida */
    private int height = 13;
    
      
    /** Color de la barra de vida */
    private Color color = Color.BLACK;
    
    private ElementWorld w;
    
    /**
     * No argument constructor 
     */
    public VidaBoss()
    {
        updateImage();
    }
    
    /**
     * Constructor de VidaBoss
     * @param theWidth largo que se usa
     * @param theHeight ancho que se usa
     * @param theColor color que se usa
     * 
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
     * Act de la clase VidaBoss llama a un metodo.
     */
    public void act() 
    {
        checkTime();
    } 
    
    /**
     * Realiza cambios fisicos de la barra de vida.
     */
    public void updateImage()
    {
       
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(color);
        image.fillRect(0,0,width,height);
        setImage(image);
      
    }
    
    /**
     * Cambia el tamano de barra de vida 
     */
    public void disminuyeVida(int tipo)
    {
            if(tipo==2 && color == Color.BLACK)
            {
             coordenada();
             width=width-4;
             updateImage();
            }
            
            if(tipo==4 && color == Color.WHITE)
            {
             coordenada();
             width=width-4;
             updateImage();
            }
            
            if(tipo==1 && color == Color.BLACK)
            {
             coordenada();
             width=width-4;
             updateImage();
            }
            
            if(tipo==3 && color == Color.WHITE)
            {
             coordenada();
             width=width-4;
             updateImage();
            }
            
            if(tipo==0 && color == Color.WHITE)
            {
             coordenada();
             width=width-4;
             updateImage();
            }
            
            if(width <= 12)
            {
                w.removeObject(this);
            }
           
           
                     
     }
     
     public void coordenada()
    {
        move(2);
    }
    
    /**
     * Cambia el color de la barra de vida cada 5 segundos.
     */public void checkTime()
    {
        if(time.millisElapsed()>5000 &&  color == Color.BLACK)
        {
            color=Color.WHITE;
            updateImage();
            time.mark();
        }
        
        if(time.millisElapsed()>5000 &&  color == Color.WHITE)
        {
            color=Color.BLACK;
            updateImage();
            time.mark();
        }
    
    }
    
    /**
     * Devuelve el color actual de la barra.
     * @return retorna el color actual del objeto.
     */
    public Color dimeElemento()
    {
        return color;
    }
    /**
     * Devuelve el largo de la barra de vida.
     * @return regresa el valor actual de width
     */
    public int dimeVida()
    {
        return width;
    }
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
      w = (ElementWorld) world;        
    }
    
    
}
