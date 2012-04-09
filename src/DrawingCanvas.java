import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import javax.swing.JComponent;

/**
 * Main view of the MiniDraw program which serves a both a view and a model.
 * The model component is specified below, and the view component displays the
 * image contents of the model.
 *
 * To prevent screen flicker when drawing or resizing, an ImageBuffer is used.
 * All drawing from the associated tools is executed on imageBuffer, which is
 * drawn to screen on updates which are specified by the tools.
 */
@SuppressWarnings("serial")
public class DrawingCanvas extends JComponent {

  /* Class member variables */
  public MultiPoint od; // ITER 4
  private final Color background = Color.WHITE;
  public ArrayList<ShapeClass> objectList;
  private ShapeClass selectedShape; // Keep a reference to selected shape.
  protected DrawingCanvasController DCcontroller;
  protected Image imageBuffer;
//  protected Graphics imageBufferGraphics;
  protected Graphics2D imageBufferGraphics;
  protected int canvasWidth;
  protected int canvasHeight;
  protected Color penColor = Color.black;
  protected Color fillColor = null;
  protected Tool currentTool;
  public TextTool textTool = new TextTool(this); 
  final static float dash1[] = {10.0f};
  final static BasicStroke line = new BasicStroke(2.0f); // ITER 4
  final static BasicStroke dashed =
        new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
  Rectangle ULRect, URRect, DLRect, DRRect; //Small rectangles for when you have a selected tool.
  

  /****< Constructor >*********************************************************/
  /**
   * Creates a default DrawingCanvas with a white background
   */
  public DrawingCanvas(MultiPoint o) { // ITER 4
    od = o; // ITER 4
    setBackground(background);
    DCcontroller = createDrawingCanvasController();
    addDrawingCanvasListener(DCcontroller);
    objectList = new ArrayList<ShapeClass>();   // create a new objectList
    selectedShape = null;
    
  }

  /****< Factory Methods >*****************************************************/

  protected DrawingCanvasController createDrawingCanvasController() {
      return new DrawingCanvasController(this);
  }

  /****< Listener Register Methods >*******************************************/
  protected void addDrawingCanvasListener(DrawingCanvasController listener) {
    if( listener != null ) {
      addMouseListener((MouseListener) listener);
      addMouseMotionListener((MouseMotionListener) listener);
      addKeyListener((KeyListener) listener );
    }
  }

  /****< Drawing Methods >*****************************************************/
  /* (non-Javadoc)
   * @see javax.swing.JComponent#update(java.awt.Graphics)
   */
  public void update(Graphics g){
      // Should go through the object stack and paint a graphic for each things
     paint(g);
  }

  /* (non-Javadoc)
   *
   * Painting the DrawingCanvas is simply displaying the contents of the
   * imageBuffer.
   *
   * @see javax.swing.JComponent#paint(java.awt.Graphics)
   */
  public void paint(Graphics g) {
     // Create iterate to iterate through the objectList in canvas
     Iterator shapeIter = objectList.iterator();
     ShapeClass curShape;   // Create a temperary shape 

     // Iterate through objectList and draw all shapes to imageBuffer
     while(shapeIter.hasNext())
     {
         // Try drawing ShapeClass onto canvas
         try{
            
            curShape = (ShapeClass)shapeIter.next();            // Get instance of new shape
            
            if (curShape.hasText == false){
                imageBufferGraphics.setColor(curShape.getLineColor());  // Set pen color to current shapes color
                imageBufferGraphics.draw(curShape.getShape());      // Draw current shape
                // ITER 4
                if(curShape.getFillColor() != null){
                    imageBufferGraphics.setColor(curShape.getFillColor());
                    imageBufferGraphics.fill(curShape.getShape());
                }
                //ITER 4
            }
            else{
                Textangle textRect = new Textangle(curShape.getText(), curShape.getX(), curShape.getY(), curShape.getWidth(), curShape.getHeight());
                if (curShape.getFillColor() != null){
                    textRect.drawTextangle(imageBufferGraphics, true, curShape.getFillColor(), curShape.getLineColor());
                }
                else{
                    textRect.drawTextangle(imageBufferGraphics, false, curShape.getFillColor(), curShape.getLineColor());
                }
             }
         }
         // Catch and shapes that can not be drawn and print error message
         catch(Exception e){
             System.out.println("Failed to draw stack Reason: "+e.getLocalizedMessage());
         };// end catch
         // If we have a selected shape we need to draw rectangle over
         if(selectedShape != null){
             od.clearButton.setText("Delete Object");
            // ITER 4 REMOVED
            //imageBufferGraphics.setColor(selectedShape.getLineColor());  // Set pen color to current shapes color
            //imageBufferGraphics.draw(selectedShape.getShape());      // Draw current shape
            // ITER 4
            imageBufferGraphics.setColor(Color.gray); 
            imageBufferGraphics.setStroke(dashed);
            
            Rectangle containerRect = selectedShape.getShape().getBounds();
            imageBufferGraphics.draw(containerRect);

             if(selectedShape.hasText == false ){
                imageBufferGraphics.setStroke(new BasicStroke());

                // draw corner rectangles for resizing (6x6)
                imageBufferGraphics.setColor(Color.white);


                // Update the four small rectangles
                ULRect = new Rectangle(containerRect.x - 3,containerRect.y - 3,6,6);
                URRect = new Rectangle(containerRect.x + containerRect.width - 3, containerRect.y - 3, 6, 6);
                DLRect = new Rectangle(containerRect.x - 3, containerRect.y + containerRect.height - 3, 6, 6);    // Bottm Left
                DRRect = new Rectangle(containerRect.x + containerRect.width - 3, containerRect.y + containerRect.height - 3, 6, 6);

                // Draw fills for scale boxes
                imageBufferGraphics.fill(ULRect);   // Top Left Rect
                imageBufferGraphics.fill(URRect);     // Top Right Rect 
                imageBufferGraphics.fill(DLRect);    // Bottm Left
                imageBufferGraphics.fill(DRRect);  // Bottom Right Rectangle

                imageBufferGraphics.setColor(Color.gray); 

                // Draw outlines for scale boxes
                imageBufferGraphics.draw(ULRect);
                imageBufferGraphics.draw(URRect);
                imageBufferGraphics.draw(DLRect);
                imageBufferGraphics.draw(DRRect);
             }
            
            imageBufferGraphics.setStroke(line); // ITER 4
            imageBufferGraphics.setColor(penColor); 
         }
         else{
              od.clearButton.setText("Clear Slide");
         }
     }// end while
    
     g.drawImage(imageBuffer,0, 0, this);
  }


  /**
   * Paints over the drawing canvas in the background color
   */
  public void clearCanvas() {
    // make sure to clear selected shape when deleting objects. 
    selectedShape = null;
    
    // Clear all the objects in the list
    objectList.clear();
    
    // Clear and reset the imageBuffer
    clearImageBuffer();
  }
  
   public void clearImageBuffer() {
        imageBufferGraphics.setColor(background);
	imageBufferGraphics.fillRect(0, 0, canvasWidth, canvasHeight);
        imageBufferGraphics.setColor(penColor);
        repaint();
   }

  /****< Accessor and Update Methods >*****************************************/

  /**
   * Updates the current drawing color
   *
   * @param c new drawing color
   */
  public void setPenColor(Color c) {
    if( c != null ) {
        penColor = c;
        //imageBufferGraphics.setColor(c);
    }
  }
  
  
  public void setFillColor(Color c) {
      // Removed if ITER 4
        fillColor = c;
        //imageBufferGraphics.setColor(c);
   } 

  /**
   * Accessor method for current drawing color
   *
   * @return current drawing color
   */
  public Color getPenColor() {
    return penColor;
  }

  
  public Color getFillColor() {
    return fillColor;
  }
  /**
   * Updates current drawing tool
   *
   * @param t new drawing tool
   */
  public void setCurrentTool(Tool t)  {
    
    currentTool = t;
    if(textTool.started == true && textTool.text.length()!= 0){
        textTool.drawText();
    }
    System.out.println("Current Tool is "+t.toString());
  }
  
  public void clearCurrentTool(){
      currentTool = null;
  }

  /**
   * Accessor method for current drawing tool
   *
   * @return current drawing tool
   */
  public Tool getCurrentTool() {
    return currentTool;
  }

  /**
   * Accessor method for imageBuffer
   *
   * @return current image buffer graphics context
   */
  public Graphics getImageBufferGraphics() {
    return imageBufferGraphics;
  }


  /* (non-Javadoc)
   *
   * Adjusts the size of the DrawingCanvas as well as the imageBuffer to match
   * the new DrawingCanvas size.
   *
   * @see java.awt.Component#setBounds(int, int, int, int)
   */
  public void setBounds(int x, int y, int width, int height) {
    Image newimageBuffer = createImage(width, height);
    imageBufferGraphics = (Graphics2D)newimageBuffer.getGraphics();
    imageBufferGraphics.setStroke(line); // ITER 4
    if (imageBuffer != null) {
      imageBufferGraphics.drawImage(imageBuffer, 0, 0 ,this);
    }
    imageBuffer = newimageBuffer;
    setPenColor(penColor);
    setFillColor(fillColor);
    super.setBounds(x, y, width, height);
    repaint();
    canvasWidth = width;
    canvasHeight = height;
  }
  
  // Function to add a shape to 
  public void addShape(ShapeClass s){
      //Push object into stack
      objectList.add(s);
      
      // Debug use print stack number
      System.out.println("objectStack has "+objectList.size());
      
      // Repaint canvas with new shape added
      repaint();
  }
  
  // Place holder for getShape method from object stack
  public ShapeClass getShape(Point pt)
  {
      ShapeClass s = null;
      // Get new list iterator for object stack
      ListIterator l = objectList.listIterator();
      
      // Iterate through current list to see if a point is selected
      while(l.hasNext())
      {
          // Keep an instance of the shape
          s = (ShapeClass)l.next();
          Rectangle r = s.getShape().getBounds();
          
          if(r.contains(pt.getX(),pt.getY() )){    //See if shape contains point
            return s;   // Return Selected 
          }
      }
          
      // return null shape back if not found
      return null;
  }
  
  /*
   * Function for setting a new selectedShape
   * s - can be null if no shape is selected
   */
  public void setSelectedShape(ShapeClass s)
  {
    // Deselect any previous set shape
    if(selectedShape!= null)
        selectedShape.deselect();
    
   
    selectedShape = s;
    
    // set selectedShape to select if choosen. 
    if(selectedShape!= null)
        selectedShape.select();
    
    clearImageBuffer();
    
    // Removed repaint uneeded ITER 4


  }
  
  // returns selected shape, if no shape is selected, you should receive null
  public ShapeClass getSelectedShape()
  {
      // Can return null if shape is deleted 
      return selectedShape;
  }
  
  // ITER 4
  public void deselect(){
      od.clearButton.setText("Clear Canvas");
  }

  public void select(){
      od.clearButton.setText("Delete Object");
  }
  /*
   * This functon is used for updating a selected object
   * s - transformed shape of the current selected shape.
   */
  public ShapeClass updateSelectedShape(ShapeClass s)
  {
      //Remove the current referenced selected shape from the object stack
      objectList.remove(selectedShape);
      
      // Set the transfomed shape to selected shape
      setSelectedShape(s);
      
      // add the new transformed shape to the object stack
      objectList.add(s);
      
      // return reference of new shape
      return selectedShape;
  }
  
  /* Function used to see if a mouse click has happened in canvas 
   * Return 0 - move function
   *        1 - UL Corner       1-------2
   *        2 - UR Corner       |   0   |
   *        3 - DL Corner       3-------4
   *        4 - DR Corner              
   */
  public int scaleRectContains(Point p)
  {
    // Try to get check rectangles
    try{
        if(ULRect.contains(p))
            return 1;
        if(URRect.contains(p))    
            return 2;
        if(DLRect.contains(p))
            return 3;
        if(DRRect.contains(p))
            return 4;
    }
    catch(Exception ex)
    {
        return 0;
    }
    
    // Move
    return 0;
  }
  
}// end public class DrawingCanvas extends JComponent