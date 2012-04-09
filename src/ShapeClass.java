
import java.awt.Color;  // Needed to store pen lineColor
import java.awt.Shape;  // So we can encapsulate awt.Shape 

/**
 *
 * @author Matt Lorch
 */
public class ShapeClass {
    private int x;              // X coord location on canvas
    private int y;              // y coord location on canvas
    private int width;          // width of shape
    private int height;         // height of shape
    private Color lineColor;        // pen lineColor to draw the shape with
    private Color fillColor;
    public boolean isSelected;  // mode for knowing if shape is selected
    private Shape shape;        // Have instance of shape in shape class
    public boolean hasText;
    private String text;
    
    private boolean isFreehand;
    private TwoEndShape twoEndShape;
    
    /*
     * Constructor
     * xVal (int) - x coordinate location 
     * yVal (int) - y coordinate location
     * h (int) - height of shape
     * w (int) - width of shape
     * c (Color) - pen lineColor of shape to draw
     * s (Shape) - Shape that contains how to draw any shape. 
     */
    // ITER 4
    public  ShapeClass(int xVal, int yVal, int w, int h, Color c, Color f, Shape s, boolean text){
        x = xVal; 
        y = yVal;
        width = w;
        height = h;
        isSelected = true;    
        lineColor = c;
        fillColor = f;
        shape = s;
        hasText = text;
        isFreehand = false;
    }
    
    /*
     * 
     */
    public ShapeClass(int xVal, int yVal, int w, int h, Color c, Color f, TwoEndShape s, boolean text)
    {
        x = xVal; 
        y = yVal;
        width = w;
        height = h;
        isSelected = true;    
        lineColor = c;
        fillColor = f;
        twoEndShape = s;
        hasText = text;
        isFreehand = false;
        shape = s.getShape(xVal, yVal, w, h);
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public void setX(int xVal){
        x = xVal;
    }
    
    public void setY(int yVal){
        y = yVal;
    }
    
    public void setHeight(int h){
        height = h;
    }
    
    public void setWidth(int w){
        width = w;
    }
    
    public void select(){
        isSelected = true;
    }
    
    public void deselect(){
        isSelected = false;
    }
    
    public boolean isSelected()
    {
        return isSelected;
    }
    
    public Color getLineColor(){
        return lineColor;
    }
    
    public void setLineColor (Color c){
        lineColor = c;
    }
    
    public Color getFillColor(){
        return fillColor;
    }
    
    public void setFillColor (Color f){
        fillColor = f;
    }
    
    /*
     * Function: Get function to return Shape object so canvas can draw shape.
     */
    public Shape getShape(){
        return shape;
    }
    
    public void setShape(Shape newShape)
    {
        shape = newShape;
    }
    
    public void setText(String t){
        text = t;
    }
    
    public String getText(){
        return text;
    }
    
    public void setFreehand(boolean freehand){
        isFreehand = freehand;
    }
    
    public boolean getFreehand()
    {
        return isFreehand;
    }
    
    //CHANGE
    /*
     *  Function sends back a new updated TwoEndShape
     */
    public void modifyShape(int modifiedX, int modifiedY, int modifiedWidth, int modifiedHeight, boolean hasText)
    {
        // Update everything 
        setX(modifiedX);
        setY(modifiedY);
        setWidth(modifiedWidth);
        setHeight(modifiedHeight);
        if(!hasText)
            shape =  twoEndShape.getShape(x, y, width, height);
        else
            shape = new Textangle(  text.toString(),
                                    getX(),
                                    getY(),
                                    modifiedWidth,
                                    modifiedHeight );
    }

}
