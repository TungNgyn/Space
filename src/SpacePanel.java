import javax.swing.*;
import java.awt.*;

public class SpacePanel extends JPanel{
    Image spaceImg, sonneImg, rocketImg, erdeImg, erdMondImg, merkurImg, venusImg,
            marsImg, jupiterImg, saturnImg, uranusImg, neptunImg, plutoImg;

    public SpacePanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(spaceImg,0,0,1600,900,this);
        g.drawImage(sonneImg,((1600-432)/2),
                ((900-482)/2),432,432,this);

        g.drawImage(rocketImg, Space.xDelta,Space.yDelta,48,48,this);

        g.drawImage(merkurImg, 500,500,8,8,this);
        g.drawImage(venusImg, 400,500,19,19,this);
        g.drawImage(erdeImg, (int)Space.xDirErde,(int)Space.yDirErde,20,20,this);
        g.drawImage(erdMondImg, 450,230,5,5,this);
        g.drawImage(marsImg, 200,500,11,11,this);
        g.drawImage(jupiterImg, 100,500,43,43,this);
        g.drawImage(saturnImg, 200,500,36,36,this);
        g.drawImage(uranusImg, 700,400,15,15,this);
        g.drawImage(neptunImg, 700,300,15,15,this);
        g.drawImage(plutoImg, 700,200,1,1,this);

    }

}
