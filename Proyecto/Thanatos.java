import greenfoot.*;
import java.awt.Color;

/**
 * Clase Thanatos (Jefe 1) que contiene las vidas y las condiciones de movimiento
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class Thanatos extends Enemigo
{
    private int[] tamX = new int[8];
    private int[] tamY = new int[8];
    private int[] attkX = new int[7];
    private int[] attkY = new int[7];
    private int[] killX = new int[5];
    private int[] killY = new int[5];
    
    private ElementWorld w;
    private VidaBoss vida;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    
    /**
     * Constructor de Thanatos que inicializa sus tamaños de imagen y asigna sus vidas.
     */
    public Thanatos()
    {
        super("Enemigo/JefeCaminar0.png","Enemigo/JefeCaminar","Enemigo/JefeAtacar","Enemigo/JefeMorir");
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
        if(isTouching(Warrior.class)&& yW>425 && yW<475)
        {
          spriteAtacar(attkX,attkY,6);
          if(color == Color.BLACK)
          {
            w.disminuyeVida(1);
          }
          else
          {
            w.disminuyeVida(3);  
          }
        }
        else
         {
          spriteCaminar(tamX,tamY,7);
          checkLimit(450);
         }        
       }
       else
       {
        setLocation(x+50,450);       
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
          w.abrePortal();
         }
        } 
        spriteMorir(killX,killY,4);              
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
        tamX[0]=70;         tamY[0]=121;
        tamX[1]=63;         tamY[1]=116;
        tamX[2]=71;         tamY[2]=112;
        tamX[3]=67;         tamY[3]=111;
        tamX[4]=62;         tamY[4]=110;
        tamX[5]=64;         tamY[5]=112;
        tamX[6]=74;         tamY[6]=119;
        tamX[7]=66;         tamY[7]=119;

        attkX[0]=74; 
        attkX[1]=68;
        attkX[2]=66;
        attkX[3]=179;
        attkX[4]=177;
        attkX[5]=169;
        attkX[6]=153;
        

        attkY[0]=127;
        attkY[1]=128;
        attkY[2]=128;
        attkY[3]=144;
        attkY[4]=143;
        attkY[5]=124;
        attkY[6]=124;
        
        killX[0]=112;
        killX[1]=116;
        killX[2]=108;
        killX[3]=119;
        killX[4]=119;
        
        
        killY[0]=123;
        killY[1]=120;
        killY[2]=101;
        killY[3]=89;
        killY[4]=69;
    }
}
