
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * A basic line
 *
 * Defines a basic line class that runs from a starting point to and ending
 * point.
 */
public class LineShape extends TwoEndShape {
    

  /**
   *
   * Draws a simple line from the starting to ending point.
   *
   * @see tools.shapes.TwoEndShape#draw(java.awt.Graphics, int, int, int, int)
   */
  public Shape draw(Graphics g, int x0, int y0, int x1, int y1) {
    Shape shape = new Line2D.Double(x0, y0, x1, y1);
    g.drawLine(x0, y0, x1, y1);
    return shape;
  }

  /**
   *
   * Draws the outline of a line from the starting to ending point.
   *
   * @see tools.shapes.TwoEndShape#drawOutline(java.awt.Graphics, int, int, int, int)
   */
  public void drawOutline(Graphics g, int x0, int y0, int x1, int y1) {
    g.drawLine(x0, y0, x1, y1);
  }
  
  /**
   *
   * Draws the outline of a line from the starting to ending point.
   *
   * @see tools.shapes.TwoEndShape#drawOutline(java.awt.Graphics, int, int, int, int)
   */
   // CHANGE
    public Shape getShape(int x0, int y0, int x1, int y1){
        return new Line2D.Double(x0, y0, x1, y1);
    }
}// end public class LineShape extends TwoEndShape
