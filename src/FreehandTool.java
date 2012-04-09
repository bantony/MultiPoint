import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.*;     // For stack
import java.lang.Math;
import java.lang.Double;

/**
 *
 * @author Matt Lorch
 */


 /* Draws a Freehand shape on the DrawingCanvas.
 *
 * A Freehand shape can consist of many different points and simply follows the
 * user's mouse.  As the user moves the mouse, line segments are drawn to
 * screen.
 */
public class FreehandTool extends Tool {

  /* Class member variables */
  protected DrawingCanvas canvas;
  protected Point curMousePoint;        // Current point for preview drawing freehand
  protected Point nextMousePoint;       // Next point for preview drawing freehand
  protected Stack<Point> dragPoints;     // Stack for storing all the points during a continuous drag
  protected int x1,y1,x2,y2;      // Kept for making the correct pixel map size   
  protected Path2D.Double freehandObject;
  // Event Function for storing points (drag/click)
    
  // Event Function for end point (depress)
    
  // Function for making pixelmap (private) funciton should also create object and clear all attributes
    
  // divide and concour function for addressing pixel map

  /****< Constructor >*********************************************************/
  public FreehandTool(DrawingCanvas c) {
    if( c != null )
      canvas = c;
    else
      throw new IllegalArgumentException();
    
    dragPoints = new Stack<Point>(); // Initialize stack
    freehandObject = new Path2D.Double();
    
  }

  /****< Draw Method >*********************************************************/
  protected void drawLineSegment(Point p1, Point p2) {
      
    // Set canvas to current pen color when 
    canvas.setPenColor(canvas.getPenColor());
    

    canvas.getImageBufferGraphics().drawLine(p1.x,p1.y, p2.x, p2.y);
    /* redraw only the small rectangle  */
    /* containing the new line segment  */
    int x0 = Math.min(p1.x, p2.x);
    int y0 = Math.min(p1.y, p2.y);
    int dx = Math.abs(p2.x - p1.x)+ 1;
    int dy = Math.abs(p2.y - p1.y) + 1;
    canvas.repaint(x0, y0, dx, dy);
  }

  /****< Event Handlers >******************************************************/
  /* (non-Javadoc)
   *
   * Establish starting point for next drawing.
   *
   * @see tools.Tool#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e)  {
    // Keep inital point
    // remove old points and add new mouse click point
    dragPoints.removeAllElements();
    dragPoints.add(new Point( e.getPoint()));
    // Reset freehand Object to avoid redrawing old lines
    freehandObject.reset();
    curMousePoint = e.getPoint();
    
     // Store as maxs for x1,y1(top left) and height(x2),width(y2)(Bottom right)
    // Upper Left most point 
    x1 = (int)(curMousePoint.getX());
    y1 = (int)(curMousePoint.getY());
    
    // Lower Right most point
    x2 = (int)(curMousePoint.getX());
    y2 = (int)(curMousePoint.getY());
  }

  /* (non-Javadoc)
   *
   * Draws the next line segment on the canvas.
   *
   * @see tools.Tool#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent e)  {
    // Push new point on stack each time the cursor moves
    dragPoints.add(new Point( e.getPoint()));
    
    // For drawing preview directly on canvas
    nextMousePoint = e.getPoint();
    drawLineSegment(curMousePoint,nextMousePoint);
    curMousePoint = nextMousePoint;
    
    // Update boundries on free hand shape
    updateMaxMin(nextMousePoint);
  }
  
  public void mouseReleased(MouseEvent e) 
  {
      // Push last point on stack
      dragPoints.add(new Point( e.getPoint()));
      
      // For drawing preview directly on canvas
      nextMousePoint = e.getPoint();
      drawLineSegment(curMousePoint,nextMousePoint);
        

      // Try drawing two new points
      try{
        // Create a point instance to store popped points from stack
        Point a = (Point)(dragPoints.pop());    // Starting point
        
        // Set start location as top point
        freehandObject.moveTo(a.getX(), a.getY());
        
        // pop through point list and connect each point to path
        while(!dragPoints.isEmpty())
        {
            a = (Point)(dragPoints.pop());      // pop next point to draw
            
            freehandObject.lineTo(a.getX(), a.getY());  // make line to point
            freehandObject.moveTo(a.getX(), a.getY());  // set point as end point
            
        }
        // Create new shape.
        ShapeClass freehand = new ShapeClass(   x1,
                                                y1,
                                                Math.abs(x2-x1),
                                                Math.abs(y2-y1),
                                                canvas.getPenColor(),
                                                canvas.getFillColor(), 
                                                new Path2D.Double(freehandObject),
                                                false);
        
        // set to freehand
        freehand.setFreehand(true);
        // Add ShapeClass to object stack in canvas
        canvas.addShape(freehand);

      }catch(Exception ex)
      {
          System.out.println("Anger Insued"+ex.toString());
      };
  }

  /*
   * Function checks if new point added to dragPoints is new
   * maxima or minima and updates x1,y1, x2,y2 accordingly.
   */
  private void updateMaxMin(Point pt)
  {
      //Check left most bounds
      if(pt.getX() < x1)
          x1 = (int)(pt.getX());
      //Check right most bounds
      if(pt.getX() > x2)
          x2 = (int)(pt.getX());
      //Check upper most ( Y decreases going up)
      if(pt.getY() < y1)
          y1 = (int)(pt.getY());
      if(pt.getY() > y2)
          y2 = (int)(pt.getY());
  }
}// end public class FreehandTool extends Tool
