
import java.awt.Color;
import javax.swing.*;


/**
 * Provides a Menu-type view displaying the MiniDraw Tools supplied.  Menus
 * are general hierarchical and display options via text sometimes accompanied
 * by icons.
 *
 *
 * Displays the associated buttons tools within the supplied ToolList.  The
 * ToolList itself contains the various tool controllers that will be associated
 * with this view.
 *
 * For more details, see the documentation of ToolController and ToolList.
 */
@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {
    
  protected DrawingCanvas canvas;
  protected MultiPoint od;

  /**
   * Constructor
   *
   * Registers the tools provided in the actions list for display as menu
   * options. This constructor should not be accessed directly, but rather, the
   * factory method provided by MiniDraw should be used.
   *
   * Only ToolControllers that are enabled, i.e. the tool is not null, are added
   * to the ToolBar.
   *
   * @param actions associated MiniDraw tools
   * @return Initialized MenuBarView
   */
  MenuBarView(ToolList actions, DrawingCanvas c, MultiPoint o) {
    canvas = c;
    od = o;
    JMenu fileMenu = new JMenu("File");
    JMenu toolMenu = new JMenu("Tools");
    JMenu connectMenu = new JMenu("Connections");
    
    ToolListIterator iter = actions.iterator();
    while(iter.hasNext()) {
      Action a = (Action) iter.next();
      if( a.isEnabled() )
        toolMenu.add(a);
    }// end tools remain
    
    JMenuItem clearCanvas = new JMenuItem("Clear Canvas");
    clearCanvas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canvas.clearCanvas();
            }
        });
    
    JMenuItem exit= new JMenuItem("Exit");
    exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
    

    
    
    fileMenu.add(clearCanvas);
    fileMenu.addSeparator();
    fileMenu.add(exit);
    
    add(fileMenu);
    add(toolMenu);
    add(connectMenu);

  }// end __ MenuBarView( ToolList )
}// end public class MenuBarView extends JMenuBar
