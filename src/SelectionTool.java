import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.*;     // For stack
import java.lang.Math;
import java.lang.Double;


/**
 *
 * @author Matt Lorch
 */
public class SelectionTool extends Tool {
    
    // Class member variables
    protected DrawingCanvas canvas;
    protected Point         curMousePoint;        // Current point for preview drawing freehand
    protected Point         nextMousePoint;
    protected ShapeClass    curSelectedShape;
    private   boolean       modify;
    private   boolean       move;
    private   int           scale;      // 1---2
                                        // | 0 |
                                        // 3---4
    // Constructor
    public SelectionTool(DrawingCanvas c){
        if ( c != null )
            canvas = c;
        else 
            throw new IllegalArgumentException();
        curSelectedShape = null;
        modify = false;
        move = false;
            
    }
    
    // MouseClick event will hand for selection for now
    // drag and release will handle with move and resize
    public void mouseClicked(MouseEvent e)
    {
        // Get new shape
        curSelectedShape = canvas.getShape((Point)e.getPoint());
        
        // set new shape. 
        canvas.setSelectedShape(curSelectedShape);
        
        // Tru to select/deselect object. Catch null
        try{
            if(curSelectedShape.isSelected)
                modify = true;
            else
                modify = false;
        }
        catch(Exception ex){
            // set modify and move flags to false
            modify = false; 
            move = false;
        }
    }
    
    public void mousePressed(MouseEvent e)
    {
        // Store point for first click
        curMousePoint = e.getPoint();
        
        // store where we clicked on bounds
        scale = canvas.scaleRectContains(curMousePoint);
        
        // Check for mouse point is out of shape bounds 
        if( (curSelectedShape != canvas.getShape(curMousePoint)) && (scale == 0))
        {
            // Set modify to false for mouseDragged
            modify = false;
            move = false;
           
            // deselecte the selected shape in canvas
            canvas.setSelectedShape(null);
            curSelectedShape = null;
        }
        else
        {
            // Set 
            move = ( canvas.scaleRectContains(curMousePoint) == 0);
        }
        
    }
    
    public void mouseDragged(MouseEvent e)
    {
        nextMousePoint = e.getPoint();
        
        if(modify)
        {

            // Make new Affine Transform which translates from last mouse drag
            AffineTransform transform = new AffineTransform();

            // Figure out which way the mouse should translate to 
            double tx = nextMousePoint.x - curMousePoint.x;
            double ty = nextMousePoint.y - curMousePoint.y;
       

            
            // set translation of where the object moves
            if(move)
            {
                // Movement for freehand shape (uses affine transforms
                if(curSelectedShape.getFreehand())
                {
                    // Move for freehand
                    transform.translate(tx, ty);
                    Path2D.Double newshape = new Path2D.Double( (Path2D.Double) (curSelectedShape.getShape()) );

                    // Update the selected object in canvas. 
                    ShapeClass bob = new ShapeClass( 
                                                    nextMousePoint.x,
                                                    nextMousePoint.y,
                                                    curSelectedShape.getHeight(),
                                                    curSelectedShape.getWidth(),
                                                    curSelectedShape.getLineColor(),
                                                    curSelectedShape.getFillColor(),
                                                    newshape.createTransformedShape(transform),
                                                    false);
                    bob.setFreehand(true);
                    curSelectedShape = canvas.updateSelectedShape(bob);
                }
                
                // Move for text
                else if(curSelectedShape.hasText)
                {
                    
                    int modifiedX = curSelectedShape.getX() + (int)tx;
                    int modifiedY = curSelectedShape.getY() + (int)ty;
                    int modifiedWidth = curSelectedShape.getWidth() + (int)tx;
                    int modifiedHeight = curSelectedShape.getHeight() + (int)ty;
                    
                    curSelectedShape.modifyShape(   curSelectedShape.getX() + (int)tx,
                                                    curSelectedShape.getY() + (int)ty, 
                                                    curSelectedShape.getWidth() , 
                                                    curSelectedShape.getHeight(),
                                                    true);
                }
                
                
                // for everything else
                else
                {
                    int modifiedX = curSelectedShape.getX() + (int)tx;
                    int modifiedY = curSelectedShape.getY() + (int)ty;
                    int modifiedWidth = curSelectedShape.getWidth() + (int)tx;
                    int modifiedHeight = curSelectedShape.getHeight() + (int)ty;
                    // set modifications 
                    curSelectedShape.modifyShape(   modifiedX,
                                                    modifiedY, 
                                                    modifiedWidth, 
                                                    modifiedHeight,
                                                    false);
//                    // Clear image buffer and repaint
//                    canvas.clearImageBuffer();
//                    canvas.repaint();
//                    
//                    // update selected Shape before modifications are made!
//                    curSelectedShape = canvas.getSelectedShape();
                }
                
            }   // End for move
            
            // Scale for non freehand and text objects
            else
            {
                if(curSelectedShape.getFreehand())
                {
                    // Transform for scale (kinda jank)
                    switch (scale){
                        case 1:
                            if((nextMousePoint.x < curMousePoint.x)||(nextMousePoint.y < curMousePoint.y))
                            {
                                tx = 1.01;
                                ty = 1.01;
                            }
                            else
                            {
                                tx = 0.99;
                                ty = 0.99;
                            }
                            break;
                        case 2:
                            if((nextMousePoint.x > curMousePoint.x)||(nextMousePoint.y < curMousePoint.y))
                            {
                                tx = 1.01;
                                ty = 1.01;
                            }
                            else
                            {
                                tx = 0.99;
                                ty = 0.99;
                            }
                            break;
                        case 3:
                            if((nextMousePoint.x < curMousePoint.x)||(nextMousePoint.y > curMousePoint.y))
                            {
                                tx = 1.01;
                                ty = 1.01;
                            }
                            else
                            {
                                tx = 0.99;
                                ty = 0.99;
                            }
                            break;
                        case 4:
                            if((nextMousePoint.x > curMousePoint.x)||(nextMousePoint.y > curMousePoint.y))
                            {
                                tx = 1.01;
                                ty = 1.01;
                            }
                            else
                            {
                                tx = 0.99;
                                ty = 0.99;
                            }
                            break;

                        // Catch random errors
                        default:
                            tx = 1;
                            ty = 1;
                            break;
                    }
                    transform.scale(tx, ty);
                    Path2D.Double newshape = new Path2D.Double( (Path2D.Double) (curSelectedShape.getShape()) );

                    // Update the selected object in canvas. 
                    ShapeClass bob = new ShapeClass(nextMousePoint.x,
                                                    nextMousePoint.y,
                                                    curSelectedShape.getHeight(),
                                                    curSelectedShape.getWidth(),
                                                    curSelectedShape.getLineColor(),
                                                    curSelectedShape.getFillColor(),
                                                    newshape.createTransformedShape(transform),
                                                    false);
                    bob.setFreehand(true);
                    curSelectedShape = canvas.updateSelectedShape(bob);
                    
                }// end if for freehand shape
                else if(!curSelectedShape.hasText)
                {
                    int modifiedX = curSelectedShape.getX();
                    int modifiedY = curSelectedShape.getY();
                    int modifiedWidth = curSelectedShape.getWidth();
                    int modifiedHeight = curSelectedShape.getHeight();
                    
                    boolean X1LessthanX2 = isAlessthanB(modifiedX,modifiedWidth);
                    boolean Y1LessthanY2 = isAlessthanB(modifiedY,modifiedHeight);
                    
                    switch (scale){
                            // Dragging from upper left corner
                            case 1:
                                // P1
                                //    \
                                //      P2
                                if(X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                // P2
                                //    \
                                //      P1
                                else if(!X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                //    P1
                                //   /
                                // P2
                                else if(!X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                
                                //    P2
                                //   /
                                // P1
                                else if(X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                               
                                break;
                            
                            // Dragging from Upper right corner
                            case 2:
                                if(X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                
                                else if(X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                break;
                            
                            // dragging from lower left corner
                            case 3:
                                if(X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                else if(X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                break;
                              
                            // dragging from lower rigth corner
                            case 4:
                                if(X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                
                                else if(!X1LessthanX2 && Y1LessthanY2)
                                {
                                    modifiedX = modifiedX + (int)tx;
                                    modifiedHeight = modifiedHeight + (int)ty;
                                }
                                
                                else if(X1LessthanX2 && !Y1LessthanY2)
                                {
                                    modifiedWidth = modifiedWidth + (int)tx;
                                    modifiedY = modifiedY + (int)ty;
                                }
                                break;
                                
                            default:
                                break;
                                
                    }
                    // set modifications 
                    curSelectedShape.modifyShape(   modifiedX,
                                                    modifiedY, 
                                                    modifiedWidth, 
                                                    modifiedHeight,
                                                    false);
//                    // Clear image buffer and repaint
//                    canvas.clearImageBuffer();
//                    canvas.repaint();
//                    
//                    // update selected Shape before modifications are made!
//                    curSelectedShape = canvas.getSelectedShape();
                }
            }// end for Scale options
            // Clear image buffer and repaint
            canvas.clearImageBuffer();
            canvas.repaint();

            // update selected Shape before modifications are made!
            curSelectedShape = canvas.getSelectedShape();
        }
        
        // Store nextMousePoint
        curMousePoint = nextMousePoint;
    
    }
    
    /*
     * Conditional statment for checking if a < b
     */
    public boolean isAlessthanB(int a, int b)
    {
        return (a < b) ? true : false;
    }
    
}
