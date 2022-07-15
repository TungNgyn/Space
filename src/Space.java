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
    static double xDirErdMond, yDirErdMond;

    static double ae = 149597870*0.0008;
    static double aphelMerkur = 0.466*ae;
    static double perihelMerkur = 0.307*ae;
    static double aphelVenus = 0.728*ae;
    static double perihelVenus = 0.718*ae;
    static double aphelErde = 1.017*ae;
    static double perihelErde = 0.983*ae;

    static double apoErdMond = 0.4055*0.00271060008*ae;
    static double periErdMond = 363300*0.0024285105*ae;

    static double aphelMars = 1.666*ae;
    static double perihelMars = 1.381*ae;
    static double aphelJupiter = 5.459*ae;
    static double perihelJupiter = 4.950*ae;
    static double aphelSaturn = 10.124*ae;
    static double perihelSaturn = 9.041*ae;
    static double aphelUranus = 20.078*ae;
    static double perihelUranus = 18.324*ae;
    static double aphelNeptun = 30.385*ae;
    static double perihelNeptun = 29.709*ae;
    static double aphelPluto = 49.304*ae;
    static double perihelPluto = 29.658*ae;

    static boolean sonneKreis = false;
    static boolean merkurKreis = false;
    static boolean venusKreis = false;
    static boolean erdeKreis = false;
    static boolean marsKreis = false;
    static boolean jupiterKreis = false;
    static boolean saturnKreis = false;
    static boolean uranusKreis = false;
    static boolean neptunKreis = false;
    static boolean plutoKreis = false;
    static boolean stop = false;

    static int temp;


    public Space() {
        spacePanel = new SpacePanel();

        spacePanel.setAutoscrolls(true);
        spacePanel.add(new JScrollPane());

        mouseInput = new MouseInput(spacePanel);
        spacePanel.addMouseListener(mouseInput);
        spacePanel.addMouseMotionListener(mouseInput);
        spacePanel.addMouseWheelListener(mouseInput);
        geschwindigkeitsSlider = new JSlider(-5,5,0);
        geschwindigkeitsSlider.setPreferredSize(new Dimension(100,50));
        setImg();
        setFrame();

        new Thread(this).start();
        merkurOrbit();
        venusOrbit();
        erdeOrbit();
        erdMondOrbit();
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
                xDirMerkur = ((perihelMerkur) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirMerkur = ((aphelMerkur) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/88*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void venusOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirVenus = ((perihelVenus) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirVenus = ((aphelVenus) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/225*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void erdeOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirErde = ((perihelErde) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirErde = ((aphelErde) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/365*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void erdMondOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirErdMond = ((perihelErde) * (Math.cos(zaehler)))+(spacePanel.erdeDm/2);
                yDirErdMond = ((aphelErde) * (Math.sin(zaehler)))+(spacePanel.erdeDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/28.3217*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void marsOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirMars = ((perihelMars) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirMars = ((aphelMars) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/686*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void jupiterOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirJupiter = ((perihelJupiter) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirJupiter = ((aphelJupiter) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/4332*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void saturnOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirSaturn = ((perihelSaturn) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirSaturn = ((aphelSaturn) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/10759*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void uranusOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirUranus = ((perihelUranus) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirUranus = ((aphelUranus) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/30688*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void neptunOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirNeptun = ((perihelNeptun) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirNeptun = ((aphelNeptun) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/60195*(geschwindigkeitsSlider.getValue());
            }
        },0,10);
    }
    public void plutoOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double zaehler = 0;
            @Override
            public void run() {
                xDirPluto = ((perihelPluto) * (Math.cos(zaehler)))+(spacePanel.sonneDm/2);
                yDirPluto = ((aphelPluto) * (Math.sin(zaehler)))+(spacePanel.sonneDm/2);
                spacePanel.repaint();
                zaehler = zaehler+1.0/90560*(geschwindigkeitsSlider.getValue());
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
        JFrame adminFrame = new JFrame("Admin");
        JPanel adminPanel = new JPanel();
        JButton stopBtn = new JButton("Stop");
        JButton sonneBtn = new JButton("Sonne");
        JButton merkurBtn = new JButton("Merkur");
        JButton venusBtn = new JButton("Venus");
        JButton erdeBtn = new JButton("Erde");
        JButton marsBtn = new JButton("Mars");
        JButton jupiterBtn = new JButton("Jupiter");
        JButton saturnBtn = new JButton("Saturn");
        JButton uranusBtn = new JButton("Uranus");
        JButton neptunBtn = new JButton("Neptun");
        JButton plutoBtn = new JButton("Pluto");

        adminPanel.add(sonneBtn);
        adminPanel.add(merkurBtn);
        adminPanel.add(venusBtn);
        adminPanel.add(erdeBtn);
        adminPanel.add(marsBtn);
        adminPanel.add(jupiterBtn);
        adminPanel.add(saturnBtn);
        adminPanel.add(uranusBtn);
        adminPanel.add(neptunBtn);
        adminPanel.add(plutoBtn);
        adminPanel.add(stopBtn);
        adminPanel.add(geschwindigkeitsSlider);
        adminFrame.add(adminPanel);
        adminFrame.setPreferredSize(new Dimension(200,250));
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.pack();
        adminFrame.setVisible(true);

        stopBtn.addActionListener(e -> {
            if (!stop) {
                temp = geschwindigkeitsSlider.getValue();
                geschwindigkeitsSlider.setValue(0);
                stop = true;
            } else if (stop) {
                geschwindigkeitsSlider.setValue(temp);
                stop = false;
            }
        });
        sonneBtn.addActionListener(e -> {
            if (!sonneKreis) {
                sonneKreis = true;
            } else {
                sonneKreis = false;
            }
        });
        merkurBtn.addActionListener(e -> {
            if (!merkurKreis) {
                merkurKreis = true;
            } else {
                merkurKreis = false;
            }
        });
        venusBtn.addActionListener(e -> {
            if (!venusKreis) {
                venusKreis = true;
            } else {
                venusKreis = false;
            }
        });
        erdeBtn.addActionListener(e -> {
            if (!erdeKreis) {
                erdeKreis = true;
            } else {
                erdeKreis = false;
            }
        });
        marsBtn.addActionListener(e -> {
            if (!marsKreis) {
                marsKreis = true;
            } else {
                marsKreis = false;
            }
        });
        jupiterBtn.addActionListener(e -> {
            if (!jupiterKreis) {
                jupiterKreis = true;
            } else {
                jupiterKreis = false;
            }
        });
        saturnBtn.addActionListener(e -> {
            if (!saturnKreis) {
                saturnKreis = true;
            } else {
                saturnKreis = false;
            }
        });
        uranusBtn.addActionListener(e -> {
            if (!uranusKreis) {
                uranusKreis = true;
            } else {
                uranusKreis = false;
            }
        });
        neptunBtn.addActionListener(e -> {
            if (!neptunKreis) {
                neptunKreis = true;
            } else {
                neptunKreis = false;
            }
        });
        plutoBtn.addActionListener(e -> {
            if (!plutoKreis) {
                plutoKreis = true;
            } else {
                plutoKreis = false;
            }
        });
    }
    public void setImg() {
        spacePanel.kreisImg = new ImageIcon("res/Kreis.png").getImage();
        spacePanel.spaceImg = new ImageIcon("res/Space.png").getImage();
        spacePanel.sonneImg = new ImageIcon(("res/Sonne.png")).getImage();
        spacePanel.raketeImg = new ImageIcon("res/Rakete.png").getImage();
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
