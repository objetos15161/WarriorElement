import greenfoot.*;
import java.util.LinkedList;
/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class ElementWorld extends SWorld
{
    private Boton jugar, ayuda, creditos, regresar,inventario;
    private Cursor cursor;
    private LinkedList <GreenfootImage> imagenes;
    private MouseInfo info;

    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public ElementWorld()
    {    
        //super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        super(800,600,1,3720,600);
        
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("00WEMenu1.png"));      //0
        imagenes.add(new GreenfootImage("00WEAyuda.png"));      //1
        imagenes.add(new GreenfootImage("00WECreditos1.png"));  //2
        imagenes.add(new GreenfootImage("00EWBotonJugar.png")); //3
        imagenes.add(new GreenfootImage("00BotonAyuda.png"));   //4
        imagenes.add(new GreenfootImage("00BotonCreditos.png"));//5
        imagenes.add(new GreenfootImage("00BotonRegresar.png"));//6
        imagenes.add(new GreenfootImage("Cursor.png"));         //7
        imagenes.add(new GreenfootImage("HUD.png"));            //8

        jugar = new Boton(getImagen(3));
        ayuda = new Boton(getImagen(4));
        creditos = new Boton(getImagen(5));
        regresar = new Boton(getImagen(6));
        cursor = new Cursor(getImagen(7));
        inventario = new Boton(getImagen(8));
        menu();
        
    }
    
     public void nivel1()
    {
        
        addMainActor(new Warrior(), 30,450,250,300);
        addObject(inventario,95,47  ,false);
        GreenfootImage bg = new GreenfootImage("Bosque.png");
        setScrollingBackground(bg); 
    }

    
    /**
     * Este método muestra la pantalla de Menú. Coloca
     * el fondo de pantalla, agregando los objetos necesarios
     * y fija la velocidad del juego.
     */
    public void menu()
    {
        setBackground(getImagen(0));
        addObject(jugar, 120, 550);
        addObject(ayuda, 409, 550);
        addObject(creditos, 692, 550);
        addObject(cursor, 0, 0);
        Greenfoot.setSpeed(50);

    }

    public void act()
    {            
        super.act();
        seleccionar();
    }

    /**
     * Este método se encarga de controlar la
     * selección de los respectivos botones en cada
     * parte del menú. 
     */
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(creditos)) {

            removeObjects(getObjects(null));
            creditos();
        }
        if(Greenfoot.mouseClicked(regresar)) {

            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(ayuda)) {

            removeObjects(getObjects(null));
            ayuda();
        }
        if(Greenfoot.mouseClicked(jugar)) {

            removeObjects(getObjects(null));
            nivel1();
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
        return imagenes.get(n);
    }

    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto jugar de la clase Boton.
     */
    public Boton getJugar()
    {
        return jugar;
    }

    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto record de la clase Boton.
     */
    public Boton getAyuda()
    {
        return ayuda;
    }

    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto creditos de la clase Boton.
     */
    public Boton getCreditos()
    {
        return creditos;
    }
    
 
    /**
     * Este método se encarga de mostrar la primer pantalla
     * de ayuda. Asigna el fondo de pantalla y agrega un botón.
     */
    public void ayuda()
    {
        setBackground(getImagen(1));
        addObject(cursor, 0, 0);
        addObject(regresar, 714, 565);
    }

    /**
     * Este método se encarga de mostrar la pantalla de
     * créditos. Asigna el fondo de pantalla y agrega un botón.
     */
    public void creditos()
    {
        setBackground(getImagen(2));
        addObject(cursor, 0, 0);
        addObject(regresar, 714, 565);
    }
}
