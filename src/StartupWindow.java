/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */
import java.awt.Color;
import java.net.InetAddress;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * StartupWindow.java
 * Provides code for a startup window
 *
 * @author Todd Elvers
 */
public class StartupWindow extends javax.swing.JDialog {
    
    private javax.swing.JLabel iconLabel;
    public static javax.swing.JCheckBox clientBox;
    private javax.swing.JPanel jConfig;
    public static javax.swing.JTextField ipText;
    private javax.swing.JLabel jIPL;
    private javax.swing.JLabel jPL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField port;
    public static javax.swing.JCheckBox serverBox;
    public static javax.swing.JCheckBox offlineBox;
    private javax.swing.JButton jStart;
    public static javax.swing.JTextField userName;
    private javax.swing.JLabel jUNL;



    /** Creates new form StartupWindow */
    public StartupWindow() {
        super();
        initComponents();
        userName.setEnabled(false);
        jStart.setEnabled(false);
        jUNL.setEnabled(false);
        ipText.setEnabled(false);
        port.setEnabled(false);
        jIPL.setEnabled(false);
        jPL.setEnabled(false);
        jConfig.setEnabled(false);
        ipText.setText("xxx.xxx.xxx.xxx");
       
    }

    void initServerOptions() {
        userName.setForeground(Color.black);
        port.setEnabled(true);
        jPL.setEnabled(true);
        ipText.setEnabled(false);
        jIPL.setEnabled(false);
        jConfig.setEnabled(true);
        serverBox.setSelected(true);
        clientBox.setSelected(false);
        offlineBox.setSelected(false);
        if (userName.getText().equals("Admin")) {
            userName.setText("");
        }
        userName.setText("Admin");
        userName.setEnabled(true);
        if (!userName.getText().isEmpty()) {
            jStart.setEnabled(true);
        }
        jUNL.setEnabled(true);
        jStart.setEnabled(true);
    }
    
    void undoServerOptions() {
        port.setEnabled(false);
        jPL.setEnabled(false);
        ipText.setEnabled(false);
        jIPL.setEnabled(false);
        userName.setForeground(Color.darkGray);
        if (!clientBox.isSelected()) {
            jConfig.setEnabled(false);
        }
        ipText.setText("xxx.xxx.xxx.xxx");
        serverBox.setSelected(false);
        if (userName.getText().equals("")) {
            userName.setForeground(Color.darkGray);
            userName.setText("Admin");
        }
        jStart.setEnabled(false);
        userName.setEnabled(false);
        jUNL.setEnabled(false);
    }
    
    void initClientOptions() {
        jConfig.setEnabled(true);
        clientBox.setSelected(true);
        serverBox.setSelected(false);
        offlineBox.setSelected(false);
        ipText.setEnabled(true);
        jIPL.setEnabled(true);
        port.setEnabled(true);
        jPL.setEnabled(true);
        userName.setForeground(Color.black);
        if (userName.getText().equals("Admin")) {
            userName.setText("Guest");
        } else if (userName.getText().equals("")) {
            userName.setText("Guest");
        }
        userName.setEnabled(true);
        jUNL.setEnabled(true);
        jStart.setEnabled(true);
    }
   
    void undoClientOptions() {
        ipText.setEnabled(false);
        jIPL.setEnabled(false);
        port.setEnabled(false);
        jPL.setEnabled(false);
        if (!serverBox.isSelected()) {
            jConfig.setEnabled(false);
        }
        clientBox.setSelected(false);
        userName.setForeground(Color.darkGray);
        if (userName.getText().equals("")) {
            userName.setText("Guest");
        }
        if (userName.getText().isEmpty()) {
            jStart.setEnabled(false);
        }
        userName.setEnabled(false);
        jUNL.setEnabled(false);
    }

    void initOfflineOptions() {
        jConfig.setEnabled(false);
        offlineBox.setSelected(true);
        clientBox.setSelected(false);
        serverBox.setSelected(false);
        ipText.setEnabled(false);
        jIPL.setEnabled(true);
        port.setEnabled(false);
        jPL.setEnabled(true);
        userName.setEnabled(false);
        jUNL.setEnabled(true);
        jStart.setEnabled(true);
    }
    
     void undoOfflineOptions() {
        ipText.setEnabled(false);
        jIPL.setEnabled(false);
        port.setEnabled(false);
        jPL.setEnabled(false);
        if (!serverBox.isSelected()) {
            jConfig.setEnabled(false);
        }
        offlineBox.setSelected(false);
        userName.setForeground(Color.darkGray);
        if (userName.getText().equals("")) {
            userName.setText("Guest");
        }
        if (userName.getText().isEmpty()) {
            jStart.setEnabled(false);
        }
        userName.setEnabled(false);
        jUNL.setEnabled(false);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jStart = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        serverBox = new javax.swing.JCheckBox();
        clientBox = new javax.swing.JCheckBox();
        offlineBox = new javax.swing.JCheckBox();
        jConfig = new javax.swing.JPanel();
        jUNL = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        ipText = new javax.swing.JTextField();
        jIPL = new javax.swing.JLabel();
        jPL = new javax.swing.JLabel();
        URL url = ClassLoader.getSystemResource("logo.png");
        ImageIcon icon = new ImageIcon(url);
        iconLabel = new javax.swing.JLabel(icon);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MultiPoint");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jStart.setText("Start");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection Options"));

        serverBox.setFont(new java.awt.Font("Serif", 0, 18));
        serverBox.setText("Server");
        serverBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serverBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverActionPerformed(evt);
            }
        });

        clientBox.setFont(new java.awt.Font("Serif", 0, 18));
        clientBox.setText("Client");
        clientBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        clientBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientActionPerformed(evt);
            }
        });

        offlineBox.setFont(new java.awt.Font("Serif", 0, 18));
        offlineBox.setText("Work Offline");
        offlineBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offlineBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serverBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clientBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(offlineBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(offlineBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jConfig.setBorder(javax.swing.BorderFactory.createTitledBorder("Configure"));

        jUNL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUNL.setText("Username:");

        userName.setForeground(new java.awt.Color(102, 102, 102));
        userName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jUNMouseReleased(evt);
            }
        });

        ipText.setForeground(new java.awt.Color(102, 102, 102));
        ipText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jIPMouseReleased(evt);
            }
        });
        ipText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jIPFocusGained(evt);
            }
        });

        jIPL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jIPL.setText("IP Address:");

        jPL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPL.setText("Port:");

        javax.swing.GroupLayout jConfigLayout = new javax.swing.GroupLayout(jConfig);
        jConfig.setLayout(jConfigLayout);
        jConfigLayout.setHorizontalGroup(
            jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfigLayout.createSequentialGroup()
                        .addComponent(jUNL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipText, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(148, 148, 148))
                    .addGroup(jConfigLayout.createSequentialGroup()
                        .addComponent(jPL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(391, Short.MAX_VALUE))))
        );
        jConfigLayout.setVerticalGroup(
            jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUNL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        iconLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        iconLabel.setMaximumSize(new java.awt.Dimension(119, 66));
        iconLabel.setMinimumSize(new java.awt.Dimension(119, 66));
        iconLabel.setPreferredSize(new java.awt.Dimension(119, 66));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(380, Short.MAX_VALUE)
                        .addComponent(jStart, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jStart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void serverActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // If the action performed is selecting the serverBox checkbox
        if (serverBox.isSelected()) {
            initServerOptions();
        } 
        // If the action performed is de-selecting the serverBox checkbox
        else if (!serverBox.isSelected()) {
            undoServerOptions();
        }
    }        
    
    private void offlineActionPerformed(java.awt.event.ActionEvent evt){
        if (offlineBox.isSelected()) {
            initOfflineOptions();
        } 
        else if (!offlineBox.isSelected()) {
            undoOfflineOptions();
        }
    }
   

    private void clientActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (clientBox.isSelected()) {
            initClientOptions();
        } else if (!clientBox.isSelected()) {
            undoClientOptions();
        }
    }                                       

    private void jUNMouseReleased(java.awt.event.MouseEvent evt) {                                  
        if (userName.getText().equals("Admin") || userName.getText().equals("Guest")) {
            userName.setForeground(Color.black);
            userName.setText("");
        }
    }                                 

    private void jIPMouseReleased(java.awt.event.MouseEvent evt) {                                  
        if (ipText.getText().equals("xxx.xxx.xxx.xxx")) {
            ipText.setForeground(Color.black);
            ipText.setText("");
        }
    }                                 

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //Test input before allowing user to proceed
        InetAddress IP = null;
        int port = -1;
        try {
            if (clientBox.isSelected()) {
                //Test IP
                IP = InetAddress.getByName(ipText.getText());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Could not parse given IP.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
        }
        
        if(clientBox.isSelected() && IP == null){
            return;
        }
        
        if (offlineBox.isSelected() == false) {
            try {
                port = Integer.parseInt(this.port.getText());
                if (port < 65535 && port > 1000) {
                    //Do nothing
                } else {
                    JOptionPane.showMessageDialog(this, "Port number must be above 1000 and below 65535.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid characters in \"Port\" field", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
            }

            if (port == -1) {
                return;
            }

            //Test Port
            //Test UN
            if (userName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "User must specify a username.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        //If no test throws an exception, close JDialog window
        this.setVisible(false);
    }                                      

    private void jIPFocusGained(java.awt.event.FocusEvent evt) {                                
        ipText.setText("");
        ipText.setForeground(Color.black);
    }                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                StartupWindow dialog = new StartupWindow();
                
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

}
