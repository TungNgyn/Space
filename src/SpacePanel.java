import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class SpacePanel extends JPanel{
    Image spaceImg, sonneImg, raketeImg, erdeImg, erdMondImg, merkurImg, venusImg,
            marsImg, jupiterImg, saturnImg, uranusImg, neptunImg, plutoImg, kreisImg;
    final double SCALE = 0.0008;

    double sonneDm = 1392700*SCALE;
    double merkurDm = 4879*SCALE;
    double venusDm = 12104*SCALE;
    double erdeDm = 12742*SCALE;
    double erdMondDm = 3474*SCALE;
    double marsDm = 6779*SCALE;
    double jupiterDm = 139820*SCALE;
    double saturnDm = 266460*SCALE;
    double uranusDm = 50724*SCALE;
    double neptunDm = 49244*SCALE;
    double plutoDm = 2376*SCALE;

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
        at.scale(0.2, 0.2);

        if (MouseInput.init) {
            g2.setTransform(at);
            MouseInput.init = false;
            MouseInput.coordTransform = g2.getTransform();
        } else {
            g2.setTransform(MouseInput.coordTransform);
        }

        if (Space.sonneKreis)
            g2.drawImage(kreisImg,-4500,-4500,10000,10000,this);
        g2.drawImage(sonneImg, 0,0, (int) (sonneDm),(int) (sonneDm),this);

        g2.drawImage(raketeImg, Space.xDelta,Space.yDelta,100,100,this);

        if (Space.merkurKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirMerkur-5000),(int)(Space.yDirMerkur-5000),10000,10000,this);
        g2.drawImage(merkurImg, (int)Space.xDirMerkur,(int)Space.yDirMerkur,(int) (merkurDm),(int) (merkurDm),this);

        if (Space.venusKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirVenus-5000),(int)(Space.yDirVenus-5000),10000,10000,this);
        g2.drawImage(venusImg, (int)Space.xDirVenus,(int)Space.yDirVenus,(int) (venusDm),(int) (venusDm),this);

        if (Space.erdeKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirErde-5000),(int)(Space.yDirErde-5000),10000,10000,this);
        g2.drawImage(erdeImg, (int)(Space.xDirErde),(int)(Space.yDirErde),(int) (erdeDm),(int) (erdeDm),this);

        g2.drawImage(erdMondImg, (int)(Space.xDirErdMond),(int)(Space.yDirErdMond),(int)erdMondDm,(int) erdMondDm,this);

        if (Space.marsKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirMars-5000),(int)(Space.yDirMars-5000),10000,10000,this);
        g2.drawImage(marsImg, (int)Space.xDirMars,(int)Space.yDirMars,(int) (marsDm),(int) (marsDm),this);

        if (Space.jupiterKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirJupiter-5000),(int)(Space.yDirJupiter-5000),10000,10000,this);
        g2.drawImage(jupiterImg, (int)Space.xDirJupiter,(int)Space.yDirJupiter,(int) (jupiterDm),(int) (jupiterDm),this);

        if (Space.saturnKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirSaturn-5000),(int)(Space.yDirSaturn-5000),10000,10000,this);
        g2.drawImage(saturnImg, (int)Space.xDirSaturn,(int)Space.yDirSaturn,(int) (saturnDm),(int) (saturnDm),this);

        if (Space.uranusKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirUranus-5000),(int)(Space.yDirUranus-5000),10000,10000,this);
        g2.drawImage(uranusImg, (int)Space.xDirUranus,(int)Space.yDirUranus,(int) (uranusDm),(int) (uranusDm),this);

        if (Space.neptunKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirNeptun-5000),(int)(Space.yDirNeptun-5000),10000,10000,this);
        g2.drawImage(neptunImg, (int)Space.xDirNeptun,(int)Space.yDirNeptun,(int) (neptunDm),(int) (neptunDm),this);

        if (Space.plutoKreis)
            g2.drawImage(kreisImg,(int)(Space.xDirPluto-5000),(int)(Space.yDirPluto-5000),10000,10000,this);
        g2.drawImage(plutoImg, (int)Space.xDirPluto,(int)Space.yDirPluto,(int) (plutoDm),(int) (plutoDm),this);

    }

}
