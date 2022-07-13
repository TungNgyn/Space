import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {
    private SpacePanel spacePanel;
    static boolean init = true;
     Point dragStartScreen;
     Point dragEndScreen;
     int zoomLevel = 0;
     int minZoomLevel = -50;
     int maxZoomLevel = 10;
     double zoomMultiplicationFactor = 1.1;
     static AffineTransform coordTransform = new AffineTransform();


    public MouseInput(SpacePanel spacePanel) {
        this.spacePanel = spacePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragStartScreen = e.getPoint();
        dragEndScreen = null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        pan(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        if (e.getWheelRotation() < 0) {
//            Space.zoomFaktor *= 1.1;
//            spacePanel.repaint();
//        }
//
//        if (e.getWheelRotation() > 0) {
//            Space.zoomFaktor /= 1.1;
//            spacePanel.repaint();
//        }
            zoom(e);
    }
    private void zoom(MouseWheelEvent e) {
        try {
            int wheelRotation = e.getWheelRotation();
            Point p = e.getPoint();
            if (wheelRotation > 0) {
                if (zoomLevel < maxZoomLevel) {
                    zoomLevel++;
                    Point2D p1 = transformPoint(p);
                    coordTransform.scale(1 / zoomMultiplicationFactor, 1 / zoomMultiplicationFactor);
                    Point2D p2 = transformPoint(p);
                    coordTransform.translate(p2.getX() - p1.getX(), p2.getY() - p1.getY());
                    spacePanel.repaint();
                }
            } else {
                if (zoomLevel > minZoomLevel) {
                    zoomLevel--;
                    Point2D p1 = transformPoint(p);
                    coordTransform.scale(zoomMultiplicationFactor, zoomMultiplicationFactor);
                    Point2D p2 = transformPoint(p);
                    coordTransform.translate(p2.getX() - p1.getX(), p2.getY() - p1.getY());
                    spacePanel.repaint();
                }
            }
        } catch (NoninvertibleTransformException ex) {
            ex.printStackTrace();
        }
    }
    private void pan(MouseEvent e) {
        try {
            dragEndScreen = e.getPoint();
            Point2D.Float dragStart = transformPoint(dragStartScreen);
            Point2D.Float dragEnd = transformPoint(dragEndScreen);
            double dx = dragEnd.getX() - dragStart.getX();
            double dy = dragEnd.getY() - dragStart.getY();
            coordTransform.translate(dx, dy);
            dragStartScreen = dragEndScreen;
            dragEndScreen = null;
            spacePanel.repaint();
        } catch (NoninvertibleTransformException ex) {
            ex.printStackTrace();
        }
    }
    private Point2D.Float transformPoint(Point p1) throws NoninvertibleTransformException {
        AffineTransform inverse = coordTransform.createInverse();
        Point2D.Float p2 = new Point2D.Float();
        inverse.transform(p1, p2);
        return p2;
    }
}
