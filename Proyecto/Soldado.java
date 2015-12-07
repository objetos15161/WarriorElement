import greenfoot.*;

/**
 * Clase Soldado que contiene las vidas y las condiciones de movimiento
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class Soldado extends Enemigo
{
    private int[] tamX = new int[8];/*tamanio del arreglo cuando camina el jugador en X*/
    private int[] tamY = new int[8];/*tamanio del arreglo cuando camina el jugador en Y*/
    private int[] attkX = new int[6];/*tamanio del arreglo cuando ataque el jugador en X*/
    private int[] attkY = new int[6];/*tamanio del arreglo cuando ataque el jugador en Y*/
    private int[] killX = new int[8];/*tamanio del arreglo cuando muere el jugador en X*/
    private int[] killY = new int[8];/*tamanio del arreglo cuando muere el jugador en Y*/
    
    private int vida=30;
    private ElementWorld w;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    /**
     * Constructor con los nombres de los archivos del Enemigo Arania.
     */
    public Soldado()
    {
        super("Enemigo/SoldadoCaminar0.png","Enemigo/SoldadoCaminar","Enemigo/SoldadoAtacar","Enemigo/SoldadoMorir");
        inicializaTam();

    }
     /**
     * metodo Act() donde revisa si esta tocando al guerrero y
     * si esta tocando al guerrero disminuye su vida correspondiendo
     * a la armadura que lleva puesta. 
     */
    public void act() 
    {
        int x=getX();
        int y=getY();
        int yW=w.coordenadasWarrior();
        int xW=w.coordenadasWarriorX();
        
       if(vida>0)
        {
        if(isTouching(Warrior.class) && yW>=475 && yW<480)
        {
          spriteAtacar(attkX,attkY,5);
          w.disminuyeVida(0);
        }
        else
         {
          if(x-xW<=300)
          {
           spriteCaminar(tamX,tamY,7);
           if(x<xW-100) 
           {
               if(y==480)
                 setLocation(xW+300,480);
               else
                  setLocation(xW+300,200);
            }
          }
         }        
        
       }
       else
       {

        vida=-1;
        w.checkEnemigos();
        w.removeObject(this);              
      }
    }
     /**
     * Disminuye la vida de Arania en 1 cada vez que es golpeada.
     */
     public void disminuyeVida()
    {
      vida--;
    }
    
    /**
     * Inicializacion de los tamaños de los arreglos.
     */
    public void inicializaTam()
    {        
        tamX[0]=41; 
        tamX[1]=33; 
        tamX[2]=33; 
        tamX[3]=44; 
        tamX[4]=42;
        tamX[5]=33;
        tamX[6]=32; 
        tamX[7]=44; 

        tamY[0]=98;
        tamY[1]=94;
        tamY[2]=86;
        tamY[3]=90;
        tamY[4]=91;
        tamY[5]=88;
        tamY[6]=88;
        tamY[7]=96;
        
        attkX[0]=55; 
        attkX[1]=54;
        attkX[2]=52;
        attkX[3]=123;
        attkX[4]=124;
        attkX[5]=132;
        

        attkY[0]=120;
        attkY[1]=120;
        attkY[2]=121;
        attkY[3]=81;
        attkY[4]=81;
        attkY[5]=81;

        
        killX[0]=51;
        killX[1]=60;

        
        killY[0]=98;
        killY[1]=84;

        
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
