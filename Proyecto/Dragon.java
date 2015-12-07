import greenfoot.*;

/**
 * Clase Dragon que contiene las vidas y las condiciones de movimiento
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class Dragon extends Enemigo
{
    private int[] tamX = new int[7];/*tamanio del arreglo cuando camina el jugador en X*/
    private int[] tamY = new int[7];/*tamanio del arreglo cuando camina el jugador en Y*/
    private int[] attkX = new int[6];/*tamanio del arreglo cuando ataque el jugador en X*/
    private int[] attkY = new int[6];/*tamanio del arreglo cuando ataque el jugador en Y*/
    private int[] killX = new int[2];/*tamanio del arreglo cuando muere el jugador en X*/
    private int[] killY = new int[2];/*tamanio del arreglo cuando muere el jugador en Y*/
    private int vida=10;
    private ElementWorld w;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
     /**
     * Constructor con los nombres de los archivos del Enemigo Arania.
     */
    public Dragon()
    {
        super("Enemigo/DragonCaminar0.png","Enemigo/DragonCaminar","Enemigo/DragonAtacar","Enemigo/DragonMorir");
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
        int yW=w.coordenadasWarrior();
         if(vida>0)
        {
        if(isTouching(Warrior.class) && yW>425 && yW<475)
        {
          spriteAtacar(attkX,attkY,5);
          w.disminuyeVida(3);
        }
        else
         {
          spriteCaminar(tamX,tamY,6);
          checkLimit(450);
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
     * 
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
        tamX[0]=36; 
        tamX[1]=52; 
        tamX[2]=55; 
        tamX[3]=58; 
        tamX[4]=41;
        tamX[5]=55;
        tamX[6]=58; 
         

        tamY[0]=65;
        tamY[1]=70;
        tamY[2]=62;
        tamY[3]=60;
        tamY[4]=79;
        tamY[5]=59;
        tamY[6]=57;
        
        attkX[0]=43; 
        attkX[1]=47;
        attkX[2]=48;
        attkX[3]=49;
        attkX[4]=69;
        attkX[5]=71;

        attkY[0]=68;
        attkY[1]=82;
        attkY[2]=84;
        attkY[3]=86;
        attkY[4]=46;
        attkY[5]=49;
        
        killX[0]=36;
        killX[1]=43;
        
        killY[0]=65;
        killY[1]=48; 
        
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