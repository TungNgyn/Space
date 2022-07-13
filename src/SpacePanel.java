import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class SpacePanel extends JPanel{
    Image spaceImg, sonneImg, rocketImg, erdeImg, erdMondImg, merkurImg, venusImg,
            marsImg, jupiterImg, saturnImg, uranusImg, neptunImg, plutoImg;
    int sonnenZentrum = 6950;

    AffineTransform at = new AffineTransform();

    public SpacePanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(6,18,33));
        Graphics2D g2 = (Graphics2D) g;

        int x = (int) (this.getWidth() - (Space.spaceFrame.getWidth() * .2)) / 2;
        int y = (int) (this.getHeight() - (Space.spaceFrame.getHeight() * .2)) / 2;


        at.translate(x,y);
        at.scale(0.1, 0.1);

        if (MouseInput.init) {
            g2.setTransform(at);
            MouseInput.init = false;
            MouseInput.coordTransform = g2.getTransform();
        } else {
            g2.setTransform(MouseInput.coordTransform);
        }

//        double bildZoom = 1;
//        bildZoom += Space.zoomFaktor*10;
//        double spaceWidth = 1600+(bildZoom);
//        double spaceHeight = 900+(bildZoom);
        g2.drawImage(spaceImg, 0,0,1600,900,this);
        g2.drawImage(sonneImg, (int) ((Space.spaceFrame.getWidth()-sonnenZentrum/2)),
                (int) ((Space.spaceFrame.getHeight()-(sonnenZentrum+30)/2)),
                (int) (sonnenZentrum),(int) (sonnenZentrum),this);

        g2.drawImage(rocketImg, Space.xDelta,Space.yDelta,48,48,this);

        g2.drawImage(merkurImg, (int)Space.xDirMerkur,(int)Space.yDirMerkur,(int) (24),(int) (24),this);
        g2.drawImage(venusImg, (int)Space.xDirVenus,(int)Space.yDirVenus,(int) (60),(int) (60),this);
        g2.drawImage(erdeImg, (int)Space.xDirErde,(int)Space.yDirErde,(int) (63),(int) (63),this);
        g2.drawImage(erdMondImg, 450,230,(int) (17),(int) (17),this);
        g2.drawImage(marsImg, (int)Space.xDirMars,(int)Space.yDirMars,(int) (34),(int) (34),this);
        g2.drawImage(jupiterImg, (int)Space.xDirJupiter,(int)Space.yDirJupiter,(int) (699),(int) (699),this);
        g2.drawImage(saturnImg, (int)Space.xDirSaturn,(int)Space.yDirSaturn,(int) (1020),(int) (1020),this);
        g2.drawImage(uranusImg, (int)Space.xDirUranus,(int)Space.yDirUranus,(int) (254),(int) (254),this);
        g2.drawImage(neptunImg, (int)Space.xDirNeptun,(int)Space.yDirNeptun,(int) (246),(int) (246),this);
        g2.drawImage(plutoImg, (int)Space.xDirPluto,(int)Space.yDirPluto,(int) (12),(int) (12),this);

    }

}
