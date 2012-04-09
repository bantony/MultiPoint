
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Defines the drawing behavior for drawing an oval.
 */
public class OvalShape extends TwoEndShape {

  /* (non-Javadoc)
   *
   * Defines how to draw the oval bounded by the starting and ending points.
   * The smallest coordinates of the starting and ending positions are used to
   * locate the origin of the oval boundary.  The absolute value of the
   * differences in the x and y coordinates are used for the width and
   * height respectively.
   *
   * @see tools.shapes.TwoEndShape#draw(java.awt.Graphics, int, int, int, int)
   */
  public Shape draw(Graphics g, int x0, int y0, int x1, int y1) {
    int shapeX;
    int shapeY;
    int shapeWidth;
    int shapeHeight;

    // find smallest x coordinate and calculate width
    if (x0 <= x1) {
      shapeX = x0;
      shapeWidth = (x1-x0)+1;
    }
    else {
      shapeX = x1;
      shapeWidth = (x0-x1)+1;
    }

    // find smallest y coordinate and calculate height
    if (y0 <= y1) {
      shapeY = y0;
      shapeHeight = (y1-y0)+1;
    }
    else {
      shapeY = y1;
      shapeHeight = (y0-y1)+1;
    }
    
    Shape shape = new Ellipse2D.Double(shapeX, shapeY, shapeWidth, shapeHeight);
    g.drawOval(shapeX, shapeY, shapeWidth, shapeHeight);
    return shape;
  }

  /* (non-Javadoc)
   *
   * Same algorithm as draw
   *
   * @see tools.shapes.TwoEndShape#drawOutline(java.awt.Graphics, int, int, int, int)
   */
  public void drawOutline(Graphics g, int x0, int y0,
                                        int x1, int y1) {
    int shapeX;
    int shapeY;
    int shapeWidth;
    int shapeHeight;
    if (x0 <= x1) {
    shapeX = x0;
    shapeWidth = (x1-x0)+1;
    }
    else {
      shapeX = x1;
      shapeWidth = (x0 -x1)+1;
    }
    if (y0 <= y1) {
      shapeY = y0;
      shapeHeight = (y1-y0)+1;
    }
    else {
      shapeY = y1;
      shapeHeight = (y0-y1)+1;
    }
    g.drawOval(shapeX, shapeY, shapeWidth, shapeHeight);
  }
  
    // CHANGE
    public Shape getShape(int x0, int y0, int x1, int y1){
        int shapeX;
        int shapeY;
        int shapeWidth;
        int shapeHeight;

        // find smallest x coordinate and calculate width
        if (x0 <= x1) {
        shapeX = x0;
        shapeWidth = (x1-x0)+1;
        }
        else {
        shapeX = x1;
        shapeWidth = (x0-x1)+1;
        }

        // find smallest y coordinate and calculate height
        if (y0 <= y1) {
        shapeY = y0;
        shapeHeight = (y1-y0)+1;
        }
        else {
        shapeY = y1;
        shapeHeight = (y0-y1)+1;
        }

        Shape shape = new Ellipse2D.Double(shapeX, shapeY, shapeWidth, shapeHeight);
        return shape; 
    }
}// end public class OvalShape extends Tool
