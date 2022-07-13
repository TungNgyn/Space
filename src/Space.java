import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Space implements Runnable{
    static SpacePanel spacePanel;
    static JFrame spaceFrame;
    static JSlider geschwindigkeitsSlider;

    private MouseInput mouseInput;
    static int xDelta = 150;
    static int yDelta = 150;

    static double xDirMerkur, yDirMerkur, xDirVenus, yDirVenus, xDirErde, yDirErde, xDirMars, yDirMars;
    static double xDirJupiter, yDirJupiter, xDirSaturn, yDirSaturn, xDirUranus, yDirUranus, xDirNeptun, yDirNeptun;
    static double xDirPluto, yDirPluto;

//    static double zoomFaktor = 1;
//    static boolean zoom;

    public Space() {
        spacePanel = new SpacePanel();
        mouseInput = new MouseInput(spacePanel);
        spacePanel.addMouseListener(mouseInput);
        spacePanel.addMouseMotionListener(mouseInput);
        spacePanel.addMouseWheelListener(mouseInput);
        geschwindigkeitsSlider = new JSlider(-100,100,1);
        geschwindigkeitsSlider.setPreferredSize(new Dimension(500,10));
//        spacePanel.add(geschwindigkeitsSlider);
        setImg();
        setFrame();

        new Thread(this).start();
        merkurOrbit();
        venusOrbit();
        erdeOrbit();
        marsOrbit();
        jupiterOrbit();
        saturnOrbit();
        uranusOrbit();
        neptunOrbit();
        plutoOrbit();
    }
    public void merkurOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirMerkur = (46+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirMerkur = (69+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/88*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void venusOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirVenus = (107+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirVenus = (108+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/225*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void erdeOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirErde = (147+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirErde = (152+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/365*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void marsOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirMars = (206+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirMars = (249+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/686*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void jupiterOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirJupiter = (740+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirJupiter = (816+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/4332*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void saturnOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirSaturn = (1352+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirSaturn = (1514+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/10759*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void uranusOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirUranus = (2735+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirUranus = (3006+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/30688*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void neptunOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirNeptun = (4460+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirNeptun = (4540+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/60195*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void plutoOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirPluto = (7000+spacePanel.sonnenZentrum) * (Math.cos(zaehler))+(spaceFrame.getWidth()/2);
                yDirPluto = (7376+spacePanel.sonnenZentrum) * (Math.sin(zaehler))+(spaceFrame.getHeight()/2);
                spacePanel.repaint();
//                zaehler = zaehler+1.0/90560*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void setFrame() {
        spaceFrame = new JFrame("Weltraum");
        spaceFrame.add(spacePanel);
        spaceFrame.setPreferredSize(new Dimension(1600,900));
        spaceFrame.setResizable(false);
        spaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spaceFrame.pack();
        spaceFrame.setVisible(true);
        spaceFrame.setLocationRelativeTo(null);
    }
    public void setImg() {
        spacePanel.spaceImg = new ImageIcon("res/Space.png").getImage();
        spacePanel.sonneImg = new ImageIcon(("res/Sonne.png")).getImage();
        spacePanel.rocketImg = new ImageIcon("res/Rocket.png").getImage();
        spacePanel.erdeImg = new ImageIcon("res/Erde.png").getImage();
        spacePanel.erdMondImg = new ImageIcon("res/ErdMond.png").getImage();
        spacePanel.merkurImg = new ImageIcon("res/Merkur.png").getImage();
        spacePanel.venusImg = new ImageIcon("res/Venus.png").getImage();
        spacePanel.marsImg = new ImageIcon("res/Mars.png").getImage();
        spacePanel.jupiterImg = new ImageIcon("res/Jupiter.png").getImage();
        spacePanel.saturnImg = new ImageIcon("res/Saturn.png").getImage();
        spacePanel.neptunImg = new ImageIcon("res/Neptun.png").getImage();
        spacePanel.plutoImg = new ImageIcon("res/Pluto.png").getImage();
    }
    public static void setRocketPos(int x, int y) {
        xDelta = x;
        yDelta = y;
        spacePanel.repaint();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / 120;
        double timePerUpdate = 1000000000.0 / 200;

        long letzteZeit = System.nanoTime();

        int frames = 0;
        int updates = 0;
        int sekunden = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true) {
            long jetztZeit = System.nanoTime();
            //region fps
            deltaU += (jetztZeit - letzteZeit) / timePerUpdate;
            deltaF += (jetztZeit - letzteZeit) / timePerFrame;

            if (deltaU >= 1) {
                updates++;
                deltaU--;
            }
            if (deltaF >= 1) {
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("Sekunden: " + ++sekunden + " | FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
            letzteZeit = jetztZeit;
            //endregion

        }
    }
}
