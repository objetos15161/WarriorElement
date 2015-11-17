import greenfoot.*;

/**
 * Write a description of class Warrior here.
 * 
 * @author Negrete Montalvo Raul Omar, Hervert Morales Leonardo Iván  
 * @version 10-Nov-15
 */
public class Warrior extends Actor
{
    private int posY=0; /*Imagen Actual en el sprite sheet cuando camina*/
    private int tamX=54,tamY=99; /*Altura y Anchura del personaje*/
    private int posX=0,posX2; /*Imagen Actual en el sprite sheet cuando ataca*/
    private int attkX=75,attkY=82; /*Altura y Anchura del cuadro del personaje*/

    private int numSpr=9,sprAt=8,cont=0,cont2=0,cont3,speed=8,speed2=9;
    private int vista=0;
    private int direccion=0;
    private GreenfootImage img;
    private GreenfootImage sprite;
    private String elemento="ArmorWater";
    private String archivo = "Armadura/ArmorFireRight.png";
    /**
     * Constructor de clase Warrior, Jugador que se mueve en el mun
     * 
     * 
     */
    public Warrior()
    {

        img = new GreenfootImage(archivo);
        sprite = new GreenfootImage(tamX,tamY);
        sprite.drawImage(img,0,0);
        setImage(sprite);
        posX2=attkX*sprAt;
    }

    /**
     * 
     */
    public void spriteNormal()
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(tamX,tamY);
        //si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
        revisaVista(elemento);
        if(cont>=speed)//si contador supera speed se cambia la imagen de la animacion
        {

            if(posY > -(tamY*(numSpr-1)))
                posY -= tamY;
            else
                posY = 0;
            sprite.drawImage(img,0,posY);
            setImage(sprite);
            cont=0;
        }
        cont++;
    }

    /**
     * 
     */
    public void spriteAtaque()
    {
        for(cont3=0;cont3<=160;cont3++)
        {
            img = new GreenfootImage(archivo);
            GreenfootImage sprite = new GreenfootImage(attkX,attkY);
            revisaVista(elemento);
            if(direccion==0)

            {
                if(cont2>=speed2)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
                {
                    if(posX > -(attkX*(sprAt-1)))
                        posX = posX - attkX;
                    else
                        posX = 0;

                    sprite.drawImage(img,posX,0);
                    setImage(sprite);
                    cont2=0;
                }
            }
            else
            if(cont2>=speed2)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {

                if(posX2 >= (attkX*(sprAt-1)))
                    posX2 -= attkX;
                else
                    posX2 = attkX*sprAt;

                sprite.drawImage(img,posX,0);
                setImage(sprite);
                cont2=0;
            }
            cont2++;
        }
    }

    /**
     * 
     */
    public void act() 
    {
        int y=getY();
        int x=getX();
        if(y<360)
        {
            setLocation(x,360); 
        }
        if(y>510)
        {
            setLocation(x,510);
        }
        move();
    }    

    /**
     * 
     */
    public void move()
    {
        int positionX,positionY;
        positionX=getX();
        positionY=getY(); 
        if(Greenfoot.isKeyDown("Right"))
        {
            direccion=0;
            vista=0;
            spriteNormal();
            setLocation(positionX+1,positionY);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            direccion=1;
            vista=1;
            spriteNormal();
            setLocation(positionX-1,positionY);

        }
        if(Greenfoot.isKeyDown("Up"))
        {
            vista=3;
            spriteNormal();
            setLocation(positionX,positionY-1);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            vista=2;
            spriteNormal();            
            setLocation(positionX,positionY+1);
        }
        if(Greenfoot.isKeyDown("Space"))
        {
            cont=0;
            vista=4;
            spriteAtaque();
            setLocation(positionX,positionY);
        }
    }

    /**
     * 
     */
    public void revisaVista(String elemento)
    {
        if(elemento=="NoArmor")
        {
            attkX=75;
            attkY=82;
        }
        if(elemento=="ArmorEarth")
        {
            attkX=68;
            attkY=95;
        }
        if(elemento=="ArmorFire")
        {
            attkX=75;
            attkY=95;
        }
        if(elemento=="ArmorWater")
        {
            attkX=78;
            attkY=113;
        }
        if(elemento=="ArmorWind")
        {
            attkX=65;
            attkY=111;
        }
        if(vista==0)
        {
            archivo = "Armadura/"+elemento+"Right.png";
        }
        if(vista==1)
        {
            archivo = "Armadura/"+elemento+"Left.png"; 
        }
        if(vista==2)
        {
            archivo = "Armadura/"+elemento+"Front.png";            
        }
        if(vista==3)
        {
            archivo = "Armadura/"+elemento+"Back.png";            
        }
        if(direccion==0 && vista==4)
        {

            archivo = "Armadura/"+elemento+"AttackRight.png";

        }
        if(direccion==1 && vista==4)
        {
            archivo = "Armadura/"+elemento+"AttackLeft.png";            
        }
    }
}
