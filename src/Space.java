import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Space implements Runnable{
    static SpacePanel spacePanel;
    static JFrame spaceFrame;

    private MouseInput mouseInput;
    static int xDelta = 150;
    static int yDelta = 150;

    static double xDirErde;
    static double yDirErde;
    double zaehler = 0;

    public Space() {
        spacePanel = new SpacePanel();
        mouseInput = new MouseInput(spacePanel);
        spacePanel.addMouseListener(mouseInput);
        spacePanel.addMouseMotionListener(mouseInput);
        setImg();
        setFrame();

        new Thread(this).start();
        erdeOrbit();
    }
    public void erdeOrbit() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                xDirErde = (310 * (Math.cos(zaehler))+(spaceFrame.getWidth()/2));
                yDirErde = (309 * (Math.sin(zaehler))+(spaceFrame.getHeight()/2));
                spacePanel.repaint();
                zaehler = zaehler+0.0001;
            }
        },0,10);
    }
    public void setFrame() {
        spaceFrame = new JFrame("Weltraum");
        spaceFrame.add(spacePanel);
        spaceFrame.setPreferredSize(new Dimension(1600,900));
        spaceFrame.setResizable(false);
        spaceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
            letzteZeit = jetztZeit;
            //endregion

        }
    }
}
