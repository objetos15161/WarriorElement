import greenfoot.*;

/**
 * Clase padre Enemigo que contiene los movimientos del enemigo
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class Enemigo extends Actor
{
    private String archivo;/* Nombre de la imagen*/
    private GreenfootImage img ;/* Cuadro de la Imagen */
    private GreenfootImage sprite;/* Imagen de jugador */
    private int[] tamX;/* Tamaño del cuerpo caminando en X*/
    private int[] tamY;/* Tamaño del cuerpo caminando en Y*/
    private int[] attkX;/* Tamaño del cuerpo atacando en X*/
    private int[] attkY;/* Tamaño del cuerpo atacando en Y*/
    private int[] killX;/* Tamaño del cuerpo muriendo en X*/
    private int[] killY;/* Tamaño del cuerpo muriendo en Y*/
    private int posX=0 , posY=0 ;/* Cuadro en el que se encuentra la imagen*/
    private int cont=0 , speed = 9 ;/*Velociudad en la que se muestra hace cambio de sprite*/
    private int numSpr=8;//, numSpr2=9;/*Es en la imagen que se encuentra el sprite sheet*/
    private int cont2=1 ;//, speed2 = 7 ;/*Velocidad en la que se muestra el cambio de sprite para el ataque*/
    private int cont3=0;/*Contador para hacer automatico de un ataque*/
    private int cont4=0;/*Contador de muerte de enemigo*/
    private String elemento; /* Cadena que contiene el nombre del elemento de la imagen */
    private String ataque;/* Cadena que contiene el nombre de la accion "atacar" de la imagen */
    private String morir;/* Cadena que contiene el nombre del "morir "de la imagen */
    
    private String cadena="";
    /**
     * Constructor de enemigo donde se asigna el nombre
     * del archivo principal, el archivo que necesita para  caminar,
     * atacar, y morir.
     * @param arch nombre del archivo completo del enemigo.
     * @param enem nombre del enemigo que se va a convocar.
     * @param attk cadena con el tipo de ataque que hara el enemigo.
     * @param m cadena con el tipo de muerte del enemigo.
     */
    public Enemigo(String arch,String enem,String attk, String m)
    {
        this.archivo=arch;
        this.elemento=enem;
        this.ataque=attk;
        this.morir=m;
    }
    
    /**
     * Metodo que al momento de ser llamado.
     * el enemigo empieza a caminar y va cambiando cada imagen.
     * respecto al numero de imagenes se tengan guardadas en el arreglo.
     * 
     * @param tamX[] Arreglo de tamanio de las imagenes en X.
     * @param tamY[] Arreglo de tamanio de las imagenes en Y.
     * @param numImg int, con el numero de imagenes.
     */
    public void spriteCaminar(int tamX[],int tamY[],int numImg)
    {
        img = new GreenfootImage(archivo);
       
        GreenfootImage sprite = new GreenfootImage(tamX[cont],tamY[cont]);
        cadena=Integer.toString(cont);
        archivo=elemento+cadena+".png";
        if(cont2>=speed)
        {
            if(cont<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont++;
            }
                else
                cont=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
        move(-1);
            //cont++; 
    }
    
    /**
     * Metodo que al momento de ser llamado
     * el enemigo empieza la animacion de atacar y va cambiando cada imagen
     * respecto al numero de imagenes se tengan guardadas en el arreglo
     * @param attkX[] arreglo con el tamanio de imagenes por cada enemigo en X.
     * @param attkY[] arreglo con el tamanio de imagenes por cada enemigo en Y.
     * @param numImg int, con el numero de imagenes.
     */
    public void spriteAtacar(int attkX[],int attkY[],int numImg)
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(attkX[cont3],attkY[cont3]);
        cadena=Integer.toString(cont3);
        archivo=ataque+cadena+".png";
                if(cont2>=speed)
        {
            if(cont3<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont3++;
            }
                else
                cont3=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
            //cont++; 
    }
    /**
     * Metodo que al momento de ser llamado
     * el enemigo empieza la animacion de morir y va cambiando cada imagen
     * respecto al numero de imagenes se tengan guardadas en el arreglo
     * @param killX[] arreglo con el tamanio de imagenes por cada enemigo en X.
     * @param killY[] arreglo con el tamanio de imagenes por cada enemigo en Y.
     * @param numImg int, con el numero de imagenes.
     */
    public void spriteMorir(int killX[],int killY[],int numImg)
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(killX[cont4],killY[cont4]);
        cadena=Integer.toString(cont4);
        archivo=morir+cadena+".png";
        if(cont2>=speed)
        {
            if(cont4<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont4++;
            }
                else
                
                cont4=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
            //cont++; 
    }
    
    /**
     * Metodo que revisa los limites donde se encuentra el enemigo,
     * al llegar al borde de la pantalla del lado izquierdo, reinicia
     * y comienza a caminar de nuevo de lado derecho.
     * @param y toma la coordenada Y que se asigne para que no pase por el limite.
     */
    public void checkLimit(int y)
    {
     int x=getX();
     if(x<=50)
     {
         setLocation(750,y);
     }
    }
    /**
     * Metodo que reinicia el contador de cada enemigo distinto,
     * correspondiente a la imagen.
     * @param cont reinicia el contador a 0 para el enemigo Jefe.
     */
    public void reiniciaContador()
    {
        cont=0;
    }
}
