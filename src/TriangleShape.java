/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

public class TriangleShape extends TwoEndShape {

    public void drawOutline(Graphics g, int x0, int y0, int x1, int y1) {
        g.drawLine(x0, y0, x1, y0);
        int midX = x0 + (x1 - x0) / 2;
        g.drawLine(x0, y0, midX, y1);
        g.drawLine(x1, y0, midX, y1);
    }

    public Shape draw(Graphics g, int x0, int y0, int x1, int y1) {
        g.drawLine(x0, y0, x1, y0);
        int midX = x0 + (x1 - x0) / 2;
        g.drawLine(x0, y0, midX, y1);
        g.drawLine(x1, y0, midX, y1);

        // TO DO: 
        Point p1 = new Point(x0, y0);
        Point p2 = new Point(midX, y1);
        Point p3 = new Point(x1, y0);
        
        int[] xs = { p1.x, p2.x, p3.x };
	int[] ys = { p1.y, p2.y, p3.y };
        
        Polygon shape = new Polygon(xs, ys, xs.length);
        return shape;
    }
    
    // CHANGE
     public Shape getShape(int x0, int y0, int x1, int y1){
        // TO DO: 
        int midX = x0 + (x1 - x0) / 2;
        Point p1 = new Point(x0, y0);
        Point p2 = new Point(midX, y1);
        Point p3 = new Point(x1, y0);
        
        int[] xs = { p1.x, p2.x, p3.x };
	int[] ys = { p1.y, p2.y, p3.y };
        
        Polygon shape = new Polygon(xs, ys, xs.length);
        return shape; 
     }
}
