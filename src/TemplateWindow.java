


import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;


/**
 * StartupWindowTemp.java
 * Provides code for a startup window
 *
 * @author Todd Elvers
 */
public class TemplateWindow extends javax.swing.JDialog {
    
    private ImageIcon icon1 = new ImageIcon("TitleSlide.png");
    private ImageIcon icon2 = new ImageIcon("BulletedSlide.png");
    private ImageIcon icon3 = new ImageIcon("DrawingSlide.png");
    private ButtonGroup group;
    // Variables declaration - do not modify
    private javax.swing.JButton addTemplateButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JRadioButton slideOption1;
    private javax.swing.JRadioButton slideOption2;
    private javax.swing.JRadioButton slideOption3;
    private javax.swing.JPanel templatePanel;



    /** Creates new form StartupWindowTemp */
    public TemplateWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        

       
    }

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadButton = new javax.swing.JButton();
        templatePanel = new javax.swing.JPanel();
        slideOption1 = new javax.swing.JRadioButton();
        slideOption2 = new javax.swing.JRadioButton();
        slideOption3 = new javax.swing.JRadioButton();
        addTemplateButton = new javax.swing.JButton();
        group = new ButtonGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MiniPoint Slide Templates");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        loadButton.setLabel("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        templatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Slide Templates", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        
        
        
        slideOption1.setText("Title Slide");
        slideOption1.setToolTipText("Title slide for beginning a presentation");
        slideOption1.setIcon(icon1); // NOI18N
        slideOption1.setIconTextGap(20);

        slideOption2.setText("Bulleted List");
        slideOption2.setToolTipText("Bulleted text for presentation lists");
        slideOption2.setIcon(icon2); // NOI18N
        slideOption2.setIconTextGap(20);

        slideOption3.setText("Drawing Slide");
        slideOption3.setToolTipText("Slide for drawn shape and freehand objects");
        slideOption3.setIcon(icon3); // NOI18N
        slideOption3.setIconTextGap(20);
        
        
        group.add(slideOption1);
        group.add(slideOption2);
        group.add(slideOption3);

        javax.swing.GroupLayout templatePanelLayout = new javax.swing.GroupLayout(templatePanel);
        templatePanel.setLayout(templatePanelLayout);
        templatePanelLayout.setHorizontalGroup(
            templatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, templatePanelLayout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(templatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slideOption1)
                    .addComponent(slideOption3)
                    .addComponent(slideOption2))
                .addGap(147, 147, 147))
        );
        templatePanelLayout.setVerticalGroup(
            templatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, templatePanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(slideOption1)
                .addGap(36, 36, 36)
                .addComponent(slideOption2)
                .addGap(36, 36, 36)
                .addComponent(slideOption3)
                .addGap(18, 18, 18))
        );

        addTemplateButton.setLabel("Add Template");
        addTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTemplateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(templatePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(addTemplateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(templatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTemplateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
      
    }                                          

private void addTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
// TODO add your handling code here:
}                                                 


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TemplateWindow dialog = new TemplateWindow(new javax.swing.JFrame(), true);
                
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
   
    // End of variables declaration
}
