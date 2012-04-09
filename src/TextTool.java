
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.font.GlyphVector;


/**
 * Draws text on the canvas.
 *
 * The user selects the starting point with the mouse and then types in the
 * desired text.  Currently, the font is not selectable.  A new text box will
 * begin when the user clicks on a different canvas location.  Changing the
 * current tool, in effect, also stops current text entry.
 */
public class TextTool extends Tool {

  /* Class member variables */
  protected DrawingCanvas canvas;
  protected Point startingPosition;
  protected StringBuffer text;
  protected Font font; 
  protected Graphics iBGraphics;
  protected GlyphVector vect;
  protected FontMetrics fm;  //ITER 4
  protected boolean started = false; // ITER 4

  /****< Constructor >*********************************************************/
  public TextTool(DrawingCanvas c) {
    if( c != null ){
      canvas = c;
      font = new Font("Serif", Font.BOLD, 24);
      iBGraphics = canvas.getImageBufferGraphics(); // ITER 4
    }
    else
      throw new IllegalArgumentException();
  }

  /****< Event Handler Methods >***********************************************/
  /* (non-Javadoc)
   *
   * Returns focus to the drawing canvas and stores the starting location for
   * the text display.
   * @see tools.Tool#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e)  {
    
      if (started == true){ // ITER 4
        Rectangle dims = new Rectangle( startingPosition.x, 
                                        startingPosition.y, 
                                        (int)fm.getStringBounds(text.toString(), iBGraphics).getWidth(), 
                                        (int)fm.getStringBounds(text.toString(), iBGraphics).getHeight());
        if(dims.contains(e.getPoint()) == false && text.length()!= 0){
            //fm = iBGraphics.getFontMetrics(font); //Removed/Changed ITER 4
            drawText();
        }
        
    } // ITER 4
    //ITER 4
    else {
        canvas.requestFocus();
        startingPosition = e.getPoint();
        iBGraphics = canvas.getImageBufferGraphics();
        iBGraphics.setFont(font);
        text = new StringBuffer();
        started = true; // ITER 4
    }
    // ITER 4
  }
  
  /* (non-Javadoc)
   *
   * Adds a character to the string buffer
   *
   * @see tools.Tool#keyPressed(java.awt.event.KeyEvent)
   */
  public void keyPressed(KeyEvent e)  {
    if(e.getKeyChar() == e.VK_ENTER){
        //canvas.transferFocusBackward();
        if(text.length()!= 0){ // ITER 4
            fm = iBGraphics.getFontMetrics(font); //Removed/Changed ITER 4
            drawText();
        } // ITER 4
    }
    else if(e.getKeyChar() == e.VK_BACK_SPACE && text.length()!= 0){
        fm = iBGraphics.getFontMetrics(font);
        canvas.clearImageBuffer();
        text.deleteCharAt(text.length() - 1);
        iBGraphics.drawString(text.toString(), startingPosition.x, //Removed/Changed ITER 4
        startingPosition.y + fm.getHeight() - 11);
        canvas.repaint();
    }
    else if(started == true){
        fm = iBGraphics.getFontMetrics(font);
        char nextChar = e.getKeyChar();
        text.append(nextChar);
        iBGraphics.drawString(text.toString(), startingPosition.x, //Removed/Changed ITER 4
        startingPosition.y + fm.getHeight() - 11); // Changed/Removed ITER 4
        canvas.repaint();
    }
  }
  
  public void drawText(){

      ShapeClass textShape = new ShapeClass(  startingPosition.x, 
                                                    startingPosition.y, 
                                                    (int)fm.getStringBounds(text.toString(), iBGraphics).getWidth(), 
                                                    (int)fm.getStringBounds(text.toString(), iBGraphics).getHeight(), 
                                                    canvas.getPenColor(), 
                                                    canvas.getFillColor(), 
                                                    new Textangle(  text.toString(), 
                                                                    startingPosition.x, 
                                                                    startingPosition.y, 
                                                                    (int)fm.getStringBounds(text.toString(), iBGraphics).getWidth(), 
                                                                    (int)fm.getStringBounds(text.toString(), iBGraphics).getHeight()
                                                    ), 
                                                    true); // ITER 4
      textShape.setText(text.toString());
      canvas.addShape(textShape);
      started = false;
  }
  
}// end public class TextTool extends Tool
