import greenfoot.*;
import java.util.LinkedList;
/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class ElementWorld extends SWorld
{
    private Boton jugar, ayuda, creditos, regresar,inventario,armAgua,armFuego,armTierra,armViento,vidaBoss;
    private Cursor cursor;
    private LinkedList <GreenfootImage> imagenes;
    private MouseInfo info;
    private Warrior war= new Warrior(1);
    private int numNivel=0;
    private SimpleTimer time = new SimpleTimer();

    private Hada    h = new Hada();
    private Dragon  d = new Dragon();
    private Arania  a = new Arania();
    private Golem   g = new Golem();
    private Soldado s = new Soldado();
    private Thanatos boss1 = new Thanatos();
    private Titan    boss2 = new Titan();
    private GraveLord boss3 = new GraveLord();
    private int contEnem=1;

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
        //ESTADO DEL GUERRERO
        imagenes.add(new GreenfootImage("0barraVida.png"));      //8
        imagenes.add(new GreenfootImage("0agua.png"));          //9
        imagenes.add(new GreenfootImage("0tierra.png"));        //10
        imagenes.add(new GreenfootImage("0viento.png"));        //11
        imagenes.add(new GreenfootImage("0fuego.png"));         //12
        imagenes.add(new GreenfootImage("barraVidaJefe.png"));  //13

        jugar = new Boton(getImagen(3));
        ayuda = new Boton(getImagen(4));
        creditos = new Boton(getImagen(5));
        regresar = new Boton(getImagen(6));
        cursor = new Cursor(getImagen(7));
        inventario = new Boton(getImagen(8));
        vidaBoss = new Boton(getImagen(13));

        armAgua = new Boton(getImagen(9));
        armTierra = new Boton(getImagen(10));
        armViento = new Boton(getImagen(11));
        armFuego = new Boton(getImagen(12));

        menu();

    }

    public void nivel1()
    {
        numNivel=1;
        addMainActor(war, 30,450,250,300);
        addObject(inventario,170,60  ,false);
        addObject(armAgua,110,70,false);
        addObject(armTierra,145,70,false);
        addObject(armViento,180,70,false);
        addObject(armFuego,215,70,false);

        addObject(h,750,450,false);

        GreenfootImage bg = new GreenfootImage("Bosque.png");
        setScrollingBackground(bg); 
        
    }

    public void disminuyeVidaEnemigo(int tipo)
    {
        if(numNivel==1)
        {
          boss1.disminuyeVida(tipo);
        } 
        
        if(numNivel==2)
        {
          boss2.disminuyeVida(tipo);
        }
    }

    public void nivel2()
    {
        removeObjects(getObjects(Vida.class));
        removeObjects(getObjects(Portal.class));
        removeObject(war);
        war=new Warrior(2);
        numNivel=2;

        addMainActor(war, 30,525,250,300);

        addObject(g,750,525,false);
        GreenfootImage bg = new GreenfootImage("Montaña.png");
        setScrollingBackground(bg);

    }
    public void nivel3()
    {
        removeObjects(getObjects(Vida.class));
        removeObject(war);
        war=new Warrior(3);

        int i;
        int x=1250;

        addMainActor(war, 30,450,250,300);

        numNivel=3;
        removeObjects(getObjects(Meteoro.class));
        GreenfootImage bg = new GreenfootImage("Castillo.png");
        setScrollingBackground(bg);              

        addObject(new Suelo()  , 250, 561);
        addObject(new Suelo()  , 950, 561);
        addObject(new Suelo()  , 1550,280);
        addObject(new Suelo()  , 2270,280);
        addObject(new Suelo()  , 2870,561);
        addObject(new Suelo()  , 3470,561);

        addObject(new PlataformaH() , 600, 530);
        addObject(new PlataformaH() , 1960,250);
        addObject(new PlataformaH() , 3150,530);

        for(i=0;i<14;i++)
        {
            addObject(new Pico(),x,585);
            x=x+100;
        }

        addObject(new Pico(),550,585);
        addObject(new Pico(),650,585);
        addObject(new Pico(),3170,585);         

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
        seleccionaArmadura();

        if(numNivel==2)
        {

            if(time.millisElapsed()>20000)
            {
                createNewMeteoro();             
                time.mark();
            }

        }

        if(numNivel==3)
        {

            if(time.millisElapsed()>10000)
            {
                createNewPlataformas();
                createNewEstacas();
                time.mark();
            }            

        }

        if(numNivel==1)
        {
            if(numNivel>0 && war.getY()<450)
            {
                setPaintOrder(Hada.class);
                setPaintOrder(Dragon.class);
                setPaintOrder(Thanatos.class);
            }
            else
                setPaintOrder(Warrior.class);
        }

        if(numNivel==1)
        {
            if(numNivel>0 && war.getY()<525)
            {
                setPaintOrder(Golem.class);
                setPaintOrder(Arania.class);
                setPaintOrder(Titan.class);
            }
            else
                setPaintOrder(Warrior.class);
        }


    }

    public void checkEnemigos()
    {
        h=new Hada();
        d=new Dragon();
        a=new Arania();
        g=new Golem();
        s=new Soldado();

        //contEnem=12; //pruebasBoss

        if(numNivel==1)
        {
            if(contEnem==1)
            {
                addObject(d,1240,450);
                contEnem=2;
            }
            else 
            {
                if(contEnem==2)
                {
                    addObject(h,1860,450); 
                    contEnem=3;
                }
                else
                {
                    if(contEnem==3)
                    {
                        addObject(d,2480,450); 
                        contEnem=4;
                    }
                    else
                    {
                        if(contEnem==4)
                        {
                            addObject(h,3100,450);
                            contEnem=5;
                        }
                        else
                        {
                            if(contEnem==5)
                            {
                                addObject(d,3700,450);  
                                contEnem=6;
                            }
                            else
                            {
                                if(contEnem==6)
                                {
                                    addObject(boss1,750,450,false);
                                    contEnem=7;
                                }
                            }
                        }
                    }

                }
            }
                   
        }
        else
            {
                if(numNivel==2)
                {
                    if(contEnem==7)
                    {
                        addObject(a,1240,525);
                        contEnem=8;
                    }
                    else 
                    {
                        if(contEnem==8)
                        {
                            addObject(g,1860,525); 
                            contEnem=9;
                        }
                        else
                        {
                            if(contEnem==9)
                            {
                                addObject(a,2480,525); 
                                contEnem=10;
                            }
                            else
                            {
                                if(contEnem==10)
                                {
                                    addObject(g,3100,525);
                                    contEnem=11;
                                }
                                else
                                {
                                    if(contEnem==11)
                                    {
                                        addObject(a,3700,525);  
                                        contEnem=12;
                                    }
                                    else
                                    {
                                        if(contEnem==12)
                                        {
                                            addObject(boss2,750,525,false);
                                            contEnem=13;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
                else
                {
                    if(numNivel==3)
                    {
                        if(contEnem==13)
                        {
                            addObject(s,1240,450);
                            contEnem=14;
                        }
                        else 
                        {
                            if(contEnem==14)
                            {
                                addObject(s,1860,450); 
                                contEnem=15;
                            }
                            else
                            {
                                if(contEnem==15)
                                {
                                    addObject(s,2480,450); 
                                    contEnem=16;
                                }
                                else
                                {
                                    if(contEnem==16)
                                    {
                                        addObject(s,3100,450);
                                        contEnem=17;
                                    }
                                    else
                                    {
                                        if(contEnem==17)
                                        {
                                            addObject(s,3700,450);  
                                            contEnem=18;
                                        }
                                        else
                                        {
                                            if(contEnem==18)
                                            {
                                                addObject(boss2,750,450,false);

                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
    }

    private void createNewMeteoro()
    {
        Meteoro meteoro1, meteoro2, meteoro3;

        meteoro1 = new Meteoro();
        meteoro2 = new Meteoro();
        meteoro3 = new Meteoro();

        addObject(meteoro1 , 400, 10,false);
        addObject(meteoro2 , 600, 10,false);
        addObject(meteoro3 , 800, 10,false);
    }

    private void createNewPlataformas()
    {
        PlataformaVD plataforma3;
        PlataformaVU plataforma2;

        plataforma3 = new PlataformaVD();
        plataforma2 = new PlataformaVU();        

        addObject(plataforma2 , 1250, 540);
        addObject(plataforma3 , 2570, 20);

    }

    private void createNewEstacas()
    {
        int i;
        int e1=800;
        int e2=1400;
        int e3=2100;
        int e4=3320;

        for(i=0;i<2;i++)
        {
            addObject(new Estaca(),e1,0);
            e1=e1+300;
        }

        for(i=0;i<4;i++)
        {
            addObject(new Estaca(),e2,0);
            e2=e2+100;
        }

        for(i=0;i<4;i++)
        {
            addObject(new Estaca(),e3,0);
            e3=e3+100;
        }

        for(i=0;i<2;i++)
        {
            addObject(new Estaca(),e4,0);
            e4=e4+300;
        }
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
     * 
     */
    public void seleccionaArmadura()
    {
        if(Greenfoot.mouseClicked(armAgua)) 
        {
            war.armaduraAgua();
        }

        if(Greenfoot.mouseClicked(armTierra)) 
        {
            war.armaduraTierra();
        }

        if(Greenfoot.mouseClicked(armViento)) 
        {
            war.armaduraViento();
        }

        if(Greenfoot.mouseClicked(armFuego)) 
        {
            war.armaduraFuego();
        }
    }

    public void disminuyeVida(int tipo)
    {
        war.checkTouch(tipo);
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

    public void estadoBoss()
    {
        addObject(vidaBoss,640,65,false);
    }

    public void removeEstado()
    {
        removeObject(vidaBoss);
    }

    public void abrePortal()
    {
        if(numNivel==1)
        {
            addObject(new Portal(),3600,330);
        }

        if(numNivel==2)
        {
            addObject(new Portal(),3600,440);
        }
    }

    public Hada dimeHada()
    {
        return (h);
    }

    public Dragon dimeDragon()
    {
        return (d);
    }

    public Golem dimeGolem()
    {
        return (g);
    }

    public Arania dimeArania()
    {
        return (a);
    }

    public int coordenadasWarrior()
    {
        int coordY=war.getY();
        return(coordY);
    }
}
