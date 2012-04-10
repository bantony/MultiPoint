
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Josh
 */
public class MultiPoint extends JApplet {

    protected DrawingCanvas canvas;
    protected ToolList toolList;
    protected ToolBarView toolBar;
    protected MenuBarView menuBar;
    
    private static AppCloser closer;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JPanel canvasPanel;
    public javax.swing.JButton clearButton; //ITER 4
    public javax.swing.JComboBox fillColorComboBox;
    public javax.swing.JComboBox lineColorComboBox;
    private boolean isApplet = false;
    private javax.swing.JLabel fillColorLabel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel lineColorLabel;
    // start new
    private javax.swing.JLabel goldLabel;
    private javax.swing.JLabel greyLabel;
    public StartupWindow sw;
    public static boolean closeApplication = false;
    private javax.swing.JButton requestButton;
    private java.awt.ScrollPane slidePanel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userList;
    private javax.swing.JButton addSlideButton;
    private javax.swing.JButton deleteSlideButton;
    private javax.swing.JComboBox fontComboBox;
    private javax.swing.JLabel fontLabel;
    private javax.swing.JLabel slideLabel;
    // end new
    /** Constructor for class ObjectDraw (when invoked as application)*/
    public MultiPoint(boolean isApplet) {
        this.isApplet = isApplet;
        
        sw = new StartupWindow();
        
        sw.setLocationRelativeTo(this);
        sw.setVisible(true);
        
        if(closeApplication == true){
            System.exit(1);
        }
        
        if (!isApplet) {
            initGUI();
        }
    }
    
    /** Constructor for class ObjectDraw (when invoked as applet)*/
    public MultiPoint(){
        this(true);
    }

    private void initGUI() {
        canvas = createDrawingCanvas();
        toolList = createToolList();
        toolBar = createToolBarView(toolList);
        menuBar = createMenuBarView(toolList, canvas);
        canvasPanel = new javax.swing.JPanel();
        fillColorComboBox = new javax.swing.JComboBox();
        fillColorLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        iconPanel = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        lineColorComboBox = new javax.swing.JComboBox();
        lineColorLabel = new javax.swing.JLabel();
        closer = new AppCloser();
        
        // start new
        slideLabel = new javax.swing.JLabel();
        fontComboBox = new javax.swing.JComboBox();
        fontLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userList = new javax.swing.JPanel();
        requestButton = new javax.swing.JButton();
        slidePanel = new java.awt.ScrollPane();
        addSlideButton = new javax.swing.JButton();
        deleteSlideButton = new javax.swing.JButton();
        // end new

        this.setBackground(Color.white);
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        canvasPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        canvasPanel.setLayout(new BorderLayout());
        canvasPanel.add(canvas, BorderLayout.CENTER);

        toolBar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tools", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        fillColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No Fill", "Black", "Red", "Blue", "Yellow", "Green", "Orange", "Purple"})); // ITER 4
        fillColorComboBox.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // ITER 4
                if (canvas.getSelectedShape() == null) {
                    if ("Black".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.black);
                    } else if ("Red".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.red);
                    } else if ("Blue".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.blue);
                    } else if ("Yellow".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.yellow);
                    } else if ("Green".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.green);
                    } else if ("Orange".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.orange);
                    } else if ("Purple".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.setFillColor(Color.magenta);
                    } else {
                        canvas.setFillColor(null);
                    }
                }
                else{
                    if ("Black".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.black);
                        canvas.setFillColor(Color.black);
                    } else if ("Red".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.red);
                        canvas.setFillColor(Color.red);
                    } else if ("Blue".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.blue);
                        canvas.setFillColor(Color.blue);
                    } else if ("Yellow".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.yellow);
                        canvas.setFillColor(Color.yellow);
                    } else if ("Green".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.green);
                        canvas.setFillColor(Color.green);
                    } else if ("Orange".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.orange);
                        canvas.setFillColor(Color.orange);
                    } else if ("Purple".equals(fillColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setFillColor(Color.magenta);
                        canvas.setFillColor(Color.magenta);
                    } else {
                        canvas.getSelectedShape().setFillColor(null);
                        canvas.setFillColor(null);
                    }
                    canvas.clearImageBuffer();
                }
                // ITER 4
            }
        });
        lineColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Black", "Red", "Blue", "Yellow", "Green", "Orange", "Purple"}));
        lineColorComboBox.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (canvas.getSelectedShape() == null) {
                    if ("Black".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.black);
                    } else if ("Red".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.red);
                    } else if ("Blue".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.blue);
                    } else if ("Yellow".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.yellow);
                    } else if ("Green".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.green);
                    } else if ("Orange".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.setPenColor(Color.orange);
                    } else {
                        canvas.setPenColor(Color.magenta);
                    }
                }
                else{
                    if ("Black".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.black);
                       
                        canvas.setPenColor(Color.black);
                    } else if ("Red".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.red);
                      
                        canvas.setPenColor(Color.red);
                    } else if ("Blue".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.blue);
                       
                        canvas.setPenColor(Color.blue);
                    } else if ("Yellow".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.yellow);
                        
                        canvas.setPenColor(Color.yellow);
                    } else if ("Green".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.green);
                        
                        canvas.setPenColor(Color.green);
                    } else if ("Orange".equals(lineColorComboBox.getSelectedItem())) {
                        canvas.getSelectedShape().setLineColor(Color.orange);
                        
                        canvas.setPenColor(Color.orange);
                    } else {
                        canvas.getSelectedShape().setLineColor(Color.magenta);
                        
                        canvas.setPenColor(Color.magenta);
                    }
                    canvas.clearImageBuffer();
                }
            }
        });

        lineColorLabel.setText("Line Color:");

        fillColorLabel.setText("Fill Color:");

        clearButton.setText("Clear Slide");
        clearButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // ITER 4
                if (clearButton.getText().equals("Clear Slide")){
                    canvas.clearCanvas();
                }
                else{
                    canvas.objectStack.remove(canvas.getSelectedShape());
                    canvas.setSelectedShape(null);
                }
                
                // ITER 4
            }
        });
        
        // start new
        
        fontComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiny", "Small", "Medium", "Large", "Extra Large" }));
        fontComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        fontLabel.setText("Font Size:");

        slideLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        slideLabel.setText("Slide List:");
        
        
        userLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        userLabel.setText("Users Connected:");

        userList.setBackground(new java.awt.Color(255, 255, 255));
        userList.setLayout(new java.awt.GridLayout(5, 1, 3, 3));

        requestButton.setText("Request Ownership");
        requestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        slidePanel.setBackground(new java.awt.Color(255, 255, 255));

        addSlideButton.setText("Add Slide");
        addSlideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        deleteSlideButton.setText("Delete Slide");
        deleteSlideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        goldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goldLabel.setIcon(getImageIcon("UserGold.png")); 

        greyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        greyLabel.setIcon(getImageIcon("UserGrey.png")); 
        
        // end new

        try {
            iconLabel = new javax.swing.JLabel(getImageIcon("logo.png"));
        } catch (Exception ex) {
            Logger.getLogger(MultiPoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        iconPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        iconPanel.setPreferredSize(new java.awt.Dimension(119, 75));
        setJMenuBar(menuBar);
        layoutGUI();

    }

    private void layoutGUI(){
        
        
          
        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        // start new
        
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(requestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userList, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(userLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deleteSlideButton, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(addSlideButton, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(slidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slideLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(canvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toolBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillColorComboBox, 0, 119, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lineColorLabel)
                        .addGap(84, 84, 84))
                    .addComponent(lineColorComboBox, 0, 119, Short.MAX_VALUE)
                    .addComponent(fillColorLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontComboBox, 0, 119, Short.MAX_VALUE)
                    .addComponent(fontLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(requestButton)
                        .addGap(66, 66, 66)
                        .addComponent(slideLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(addSlideButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteSlideButton)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineColorLabel)
                        .addGap(1, 1, 1)
                        .addComponent(lineColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillColorLabel)
                        .addGap(1, 1, 1)
                        .addComponent(fillColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontLabel)
                        .addGap(1, 1, 1)
                        .addComponent(fontComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addGap(15, 15, 15))))
        );

        
        // end new
      
    }

    protected DrawingCanvas createDrawingCanvas() {
        return new DrawingCanvas(this); // ITER 4
    }

    protected ToolBarView createToolBarView(ToolList toolList) {
        return new ToolBarView(toolList);
    }

    protected MenuBarView createMenuBarView(ToolList toolList, DrawingCanvas c) {
        return new MenuBarView(toolList, c, this);
    }

    protected ImageIcon getImageIcon(String fileName) {
        URL url;
        if (isApplet) {
            try {
                url = new URL(getCodeBase(), fileName);
            } catch (MalformedURLException e) {
                return null;
            }
            return new ImageIcon(url);
        }// end executed as applet
        else {
            url = ClassLoader.getSystemResource(fileName);
            if(url == null)
                return null;
            return new ImageIcon(url);
        }
    }
    
    private JLabel createGoldIcon(){
        JLabel label = new JLabel(goldLabel.getIcon());
        return label;
    }

    private JLabel createGreyIcon(){
        JLabel label = new JLabel(greyLabel.getIcon());
        return label;
    }

    protected ToolList createToolList() {
        ToolList actions = new ToolList();

        actions.add(
                new ToolController("Freehand", 
                getImageIcon("FreeHandTool.png"),
                "Freehand drawing tool",
                canvas,
                new FreehandTool(canvas)));

        //ADD NEW TOOLS HERE

        actions.add(
                new ToolController("Selection", 
                getImageIcon("SelectionTool.png"),
                "Object Selection tool",
                canvas,
                new SelectionTool(canvas)
                )
                );
        
        actions.add(
  		new ToolController("Line",
  		getImageIcon("LineTool.png"),
  		"Line drawing tool",
  		canvas,
  		new TwoEndShapeTool(canvas, new LineShape())));
        
        actions.add(
  		new ToolController("Rectangle",
  		getImageIcon("RectangleTool.png"),
  		"Rectangle drawing tool",
  		canvas,
  		new TwoEndShapeTool(canvas, new RectangleShape())));
        
        actions.add(
  	        new ToolController("Oval",
  	        getImageIcon("OvalTool.png"),
  		"Oval drawing tool",
  		canvas,
  		new TwoEndShapeTool(canvas, new OvalShape())));
        
        actions.add(
  	        new ToolController("Circle",
  	        getImageIcon("CircleTool.png"),
  		"Circle drawing tool",
  		canvas,
  		new TwoEndShapeTool(canvas, new CircleShape())));
        
        actions.add(
  	        new ToolController("Triangle",
  	        getImageIcon("TriangleTool.png"),
  		"Triangle drawing tool",
  		canvas,
  		new TwoEndShapeTool(canvas, new TriangleShape())));
        
        actions.add(new ToolController("Text",
  		getImageIcon("TextTool.png"),
  		"Text drawing tool",
                canvas,
  		canvas.textTool)
  		);

        
        return actions;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                MultiPoint od = new MultiPoint(false);
                frame.setTitle("MultiPoint"); // ITER 4
                frame.getContentPane().setLayout(new BorderLayout());
                frame.getContentPane().add(od, BorderLayout.CENTER);
                frame.addWindowListener(closer);
                frame.pack();
                od.setVisible(true);
                frame.setVisible(true);
                frame.setResizable(false);
                od.canvas.clearCanvas();
            }
        });
    }
    
    static class AppCloser extends WindowAdapter  {
    public void windowClosing(WindowEvent e) {
       System.exit(0);
    }
  }// end static class AppCloser extends WindowAdapter
}