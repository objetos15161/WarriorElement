import greenfoot.*;
import java.awt.Color;
/**
 * Clase GraveLord(Jefe 3) que contiene las vidas y las condiciones de movimiento
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class GraveLord extends Enemigo
{
    private int[] tamX = new int[6];
    private int[] tamY = new int[6];
    private int[] attkX = new int[6];
    private int[] attkY = new int[6];
    private int[] killX = new int[6];
    private int[] killY = new int[6];
    
    private ElementWorld w;
    private VidaBoss vida;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
     /**
     * Constructor de GraveLord que inicializa sus tamaños de imagen y asigna sus vidas.
     */
    public GraveLord()
    {
        super("Enemigo/MuertoCaminar0.png","Enemigo/MuertoCaminar","Enemigo/MuertoAtacar","Enemigo/MuertoMorir");
        inicializaTam();
        
        vida=new VidaBoss();

    }
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
        
        w = (ElementWorld) world;
        w.estadoBoss();
        w.addObject(vida,606,43,false); 

    }
    /**
     * metodo Act() donde revisa si esta tocando al guerrero y
     * si esta tocando al guerrero disminuye su vida correspondiendo
     * a la armadura que lleva puesta. 
     */
    public void act() 
    {
       Color color=vida.dimeElemento();
       int v=vida.dimeVida();
       int yW=w.coordenadasWarrior();
       int x=getX();
       if(v>=12)
        {
        if(isTouching(Warrior.class))
        {
          spriteAtacar(attkX,attkY,6);
          if(color == Color.BLACK)
          {
            w.disminuyeVida(0);
          }
                 
        }
        else
         {
          spriteCaminar(tamX,tamY,6);
          checkLimit(450);
         }        
        
       }
       else
       {
        setLocation(x+50,525);
        
        if(t==1)
        {
         t=2;
         reiniciaContador();
         time.mark();
        }
         else
        {
            
         if(t==2 && time.millisElapsed()>400)
         {          
          w.removeObject(this);
          w.removeEstado();
          w.createWin();
         }
        } 
        
        spriteMorir(killX,killY,6);
                       
      }
    }
    
    /**
     * Disminuye la vida de Arania en 1 cada vez que es golpeada.
     * Depende de que tipo de elemento lo golpe.
     */
    public void disminuyeVida(int tipo)
    {
        vida.disminuyeVida(tipo);
    }
    /**
     * Inicializacion de los tamaños de los arreglos.
     */
       public void inicializaTam()
    {
        tamX[0]=138;         tamY[0]=200;
        tamX[1]=151;         tamY[1]=208;
        tamX[2]=158;         tamY[2]=208;
        tamX[3]=139;         tamY[3]=212;
        tamX[4]=123;         tamY[4]=181;
        tamX[5]=128;         tamY[5]=188;

        attkX[0]=139;        attkY[0]=200;
        attkX[1]=151;        attkY[1]=208;
        attkX[2]=157;        attkY[2]=210;
        attkX[3]=144;        attkY[3]=201;
        attkX[4]=154;        attkY[4]=188;
        attkX[5]=128;        attkY[5]=184;

        killX[0]=151;        killY[0]=208;
        killX[1]=158;        killY[1]=209;
        killX[2]=153;        killY[2]=214;
        killX[3]=107;        killY[3]=186;
        killX[4]=77;         killY[4]=191;
        killX[5]=80;         killY[5]=206;

    }   
}
