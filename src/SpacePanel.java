import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class SpacePanel extends JPanel{
    Image spaceImg, sonneImg, rocketImg, erdeImg, erdMondImg, merkurImg, venusImg,
            marsImg, jupiterImg, saturnImg, uranusImg, neptunImg, plutoImg;
    double sonneDm = 1392700*0.0008;
    double merkurDm = 4879*0.0008;
    double venusDm = 12104*0.0008;
    double erdeDm = 12742*10;
    double marsDm = 6779*0.0008;
    double jupiterDm = 139820*0.0008;
    double saturnDm = 266460*0.0008;
    double uranusDm = 50724*0.0008;
    double neptunDm = 49244*0.0008;
    double plutoDm = 2376*0.0008;

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
        at.scale(1, 1);

        if (MouseInput.init) {
            g2.setTransform(at);
            MouseInput.init = false;
            MouseInput.coordTransform = g2.getTransform();
        } else {
            g2.setTransform(MouseInput.coordTransform);
        }

        g2.drawImage(sonneImg, 0,0, (int) (sonneDm),(int) (sonneDm),this);

        g2.drawImage(rocketImg, Space.xDelta,Space.yDelta,48,48,this);

        g2.drawImage(merkurImg, (int)Space.xDirMerkur,(int)Space.yDirMerkur,(int) (merkurDm),(int) (merkurDm),this);
        g2.drawImage(venusImg, (int)Space.xDirVenus,(int)Space.yDirVenus,(int) (venusDm),(int) (venusDm),this);
        g2.drawImage(erdeImg, (int)Space.xDirErde,(int)Space.yDirErde,(int) (erdeDm),(int) (erdeDm),this);
        g2.drawImage(erdMondImg, 450,230,(int) (17),(int) (17),this);
        g2.drawImage(marsImg, (int)Space.xDirMars,(int)Space.yDirMars,(int) (marsDm),(int) (marsDm),this);
        g2.drawImage(jupiterImg, (int)Space.xDirJupiter,(int)Space.yDirJupiter,(int) (jupiterDm),(int) (jupiterDm),this);
        g2.drawImage(saturnImg, (int)Space.xDirSaturn,(int)Space.yDirSaturn,(int) (saturnDm),(int) (saturnDm),this);
        g2.drawImage(uranusImg, (int)Space.xDirUranus,(int)Space.yDirUranus,(int) (uranusDm),(int) (uranusDm),this);
        g2.drawImage(neptunImg, (int)Space.xDirNeptun,(int)Space.yDirNeptun,(int) (neptunDm),(int) (neptunDm),this);
        g2.drawImage(plutoImg, (int)Space.xDirPluto,(int)Space.yDirPluto,(int) (plutoDm),(int) (plutoDm),this);

    }

}
