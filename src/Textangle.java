
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */

public class Textangle extends Rectangle {  
    protected String label;
    public DrawingCanvas canvas; // ITER 4
    // ITER 4
    public Textangle( String s, int x, int y, int w, int h) {  
        super( x, y, w, h); 
        label = s;  
    }  
   
    public void setLabel( String s ) {  
        label = s;  
    }  
   
    public String getLabel() {  
        return label;  
    }  
   
    public void drawTextangle( Graphics g, boolean fill, Color fillColor, Color textColor ) {  
        g.setColor(fillColor);  
        if( fill ) {  
            g.fillRect(x, y , width, height);  
        }   
        FontMetrics fm = g.getFontMetrics();  
        g.setColor(textColor);  
        g.drawString(label, x, y + fm.getHeight() - 11);  //ITER 4
    }  
}  