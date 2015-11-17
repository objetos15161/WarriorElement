import greenfoot.*;
import java.util.LinkedList;
/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor extends Actor
{
    private int tocaJugar;
    private int tocaAyuda;
    private int tocaCreditos;
    private int tocaRegresar;
    private LinkedList <GreenfootImage> botones;
    private ElementWorld warrior;
    private Boton jugar, ayuda, creditos, regresar;

    public Cursor(GreenfootImage ima)
    {
        super();
        this.setImage(ima);
         tocaJugar=0;
         tocaAyuda=0;
         tocaCreditos=0;
         tocaRegresar=0;
         
         botones = new LinkedList();
         botones.add(new GreenfootImage("Cursor.png"));            //0
         botones.add(new GreenfootImage("00EWBotonJugar.png"));    //1
         botones.add(new GreenfootImage("00BotonAyuda.png"));      //2
         botones.add(new GreenfootImage("00BotonCreditos.png"));   //3
         botones.add(new GreenfootImage("00EWBotonJugar2.png"));   //4
         botones.add(new GreenfootImage("00BotonAyuda2.png"));     //5
         botones.add(new GreenfootImage("00BotonCreditos2.png"));  //6

         setImage(getImagen(0));

    }

    /**
     * Act - do whatever the Cursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        jugar = warrior.getJugar();
        ayuda = warrior.getAyuda();
        creditos = warrior.getCreditos();
        
        moverCursor();
        seleccionBoton();
    }
    
    /**
     * Este método mueve el objeto de la clase a la posicion actual
     * del cursor.
     */
    public void moverCursor()
    {
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX() + 7, mouse.getY() + 5);
        }
    }
    
    /**
     * Este método regresa la imágen (tipo GreenfootImage)
     * contenida en una Lista de la posición específicada
     * por el valor asignado en la llamada a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     * @return GreenfootImage - Imágen contenida en la Lista
     * en la posición especificada.
     */
    public GreenfootImage getImagen(int n)
    {
        return botones.get(n);
    }
    
    /**
     * Este método hace el cambio de imagenes de los botones
     * que intersectan con los objetos de esta clase.
     */
    public void seleccionBoton()
    {
        Actor bot = getOneIntersectingObject(Boton.class);
        if(bot != null && getX() < 260 && tocaJugar == 0) {
            
            jugar.setImage(getImagen(4));
            tocaJugar = 1;
        }
        if(bot == null && tocaJugar == 1) {
            jugar.setImage(getImagen(1));
            tocaJugar = 0;
        }
        if(bot != null && getX() > 361 && getX() < 550 && tocaAyuda == 0) {
            
            ayuda.setImage(getImagen(5));
            tocaAyuda = 1;
        }
        if(bot == null && tocaAyuda == 1) {
            ayuda.setImage(getImagen(2));
            tocaAyuda = 0;
        }
        if(bot != null && getX() > 551 && tocaCreditos == 0) {
            
            creditos.setImage(getImagen(6));
            tocaCreditos = 1;
        }
        if(bot == null && tocaCreditos == 1) {
            creditos.setImage(getImagen(3));
            tocaCreditos = 0;
            
        }
       
        
    }
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    public void addedToWorld(World world) 
    {
        warrior = (ElementWorld) world;        
    }
}
    