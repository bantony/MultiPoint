


import java.awt.Color;
import java.net.InetAddress;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * StartupWindowTemp.java
 * Provides code for a startup window
 *
 * @author Todd Elvers
 */
public class StartupWindowTemp extends javax.swing.JDialog {



    /** Creates new form StartupWindowTemp */
    public StartupWindowTemp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jUN.setEnabled(false);
        jStart.setEnabled(false);
        jUNL.setEnabled(false);
        jIP.setEnabled(false);
        jPort.setEnabled(false);
        jIPL.setEnabled(false);
        jPL.setEnabled(false);
        jConfig.setEnabled(false);
        jIP.setText("xxx.xxx.xxx.xxx");
       
    }

    void initServerOptions() {
        jUN.setForeground(Color.black);
        jPort.setEnabled(true);
        jPL.setEnabled(true);
        jIP.setEnabled(false);
        jIPL.setEnabled(false);
        jConfig.setEnabled(true);
        jServer.setSelected(true);
        jClient.setSelected(false);
        if (jUN.getText().equals("Admin")) {
            jUN.setText("");
        }
        jUN.setText("Admin");
        jUN.setEnabled(true);
        if (!jUN.getText().isEmpty()) {
            jStart.setEnabled(true);
        }
        jUNL.setEnabled(true);
        jStart.setEnabled(true);
    }
    
    void undoServerOptions() {
        jPort.setEnabled(false);
        jPL.setEnabled(false);
        jIP.setEnabled(false);
        jIPL.setEnabled(false);
        jUN.setForeground(Color.darkGray);
        if (!jClient.isSelected()) {
            jConfig.setEnabled(false);
        }
        jIP.setText("xxx.xxx.xxx.xxx");
        jServer.setSelected(false);
        if (jUN.getText().equals("")) {
            jUN.setForeground(Color.darkGray);
            jUN.setText("Admin");
        }
        jStart.setEnabled(false);
        jUN.setEnabled(false);
        jUNL.setEnabled(false);
    }
    
    void initClientOptions() {
        jConfig.setEnabled(true);
        jClient.setSelected(true);
        jServer.setSelected(false);
        jIP.setEnabled(true);
        jIPL.setEnabled(true);
        jPort.setEnabled(true);
        jPL.setEnabled(true);
        jUN.setForeground(Color.black);
        if (jUN.getText().equals("Admin")) {
            jUN.setText("Guest");
        } else if (jUN.getText().equals("")) {
            jUN.setText("Guest");
        }
        jUN.setEnabled(true);
        jUNL.setEnabled(true);
        jStart.setEnabled(true);
    }

    void undoClientOptions() {
        jIP.setEnabled(false);
        jIPL.setEnabled(false);
        jPort.setEnabled(false);
        jPL.setEnabled(false);
        if (!jServer.isSelected()) {
            jConfig.setEnabled(false);
        }
        jClient.setSelected(false);
        jUN.setForeground(Color.darkGray);
        if (jUN.getText().equals("")) {
            jUN.setText("Guest");
        }
        if (jUN.getText().isEmpty()) {
            jStart.setEnabled(false);
        }
        jUN.setEnabled(false);
        jUNL.setEnabled(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jStart = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jServer = new javax.swing.JCheckBox();
        jClient = new javax.swing.JCheckBox();
        jServer1 = new javax.swing.JCheckBox();
        jConfig = new javax.swing.JPanel();
        jUNL = new javax.swing.JLabel();
        jUN = new javax.swing.JTextField();
        jPort = new javax.swing.JTextField();
        jIP = new javax.swing.JTextField();
        jIPL = new javax.swing.JLabel();
        jPL = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("jChat");
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

        jServer.setFont(new java.awt.Font("Serif", 0, 18));
        jServer.setText("Server");
        jServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jServerActionPerformed(evt);
            }
        });

        jClient.setFont(new java.awt.Font("Serif", 0, 18));
        jClient.setText("Client");
        jClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClient.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientActionPerformed(evt);
            }
        });

        jServer1.setFont(new java.awt.Font("Serif", 0, 18));
        jServer1.setText("Work Offline");
        jServer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jServer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jServer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jServer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jClient, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jServer1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jServer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jClient, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jConfig.setBorder(javax.swing.BorderFactory.createTitledBorder("Configure"));

        jUNL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUNL.setText("Username:");

        jUN.setForeground(new java.awt.Color(102, 102, 102));
        jUN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jUNMouseReleased(evt);
            }
        });

        jIP.setForeground(new java.awt.Color(102, 102, 102));
        jIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jIPMouseReleased(evt);
            }
        });
        jIP.addFocusListener(new java.awt.event.FocusAdapter() {
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
                        .addComponent(jUN, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIP, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(148, 148, 148))
                    .addGroup(jConfigLayout.createSequentialGroup()
                        .addComponent(jPL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPort, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(391, Short.MAX_VALUE))))
        );
        jConfigLayout.setVerticalGroup(
            jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jUN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUNL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPort, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void jServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jServerActionPerformed
        // If the action performed is selecting the jServer checkbox
        if (jServer.isSelected()) {
            initServerOptions();
        } 
        // If the action performed is de-selecting the jServer checkbox
        else if (!jServer.isSelected()) {
            undoServerOptions();
        }
    }//GEN-LAST:event_jServerActionPerformed

    private void jClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientActionPerformed
        if (jClient.isSelected()) {
            initClientOptions();
        } else if (!jClient.isSelected()) {
            undoClientOptions();
        }
    }//GEN-LAST:event_jClientActionPerformed

    private void jUNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUNMouseReleased
        if (jUN.getText().equals("Admin") || jUN.getText().equals("Guest")) {
            jUN.setForeground(Color.black);
            jUN.setText("");
        }
    }//GEN-LAST:event_jUNMouseReleased

    private void jIPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIPMouseReleased
        if (jIP.getText().equals("xxx.xxx.xxx.xxx")) {
            jIP.setForeground(Color.black);
            jIP.setText("");
        }
    }//GEN-LAST:event_jIPMouseReleased

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        //Test input before allowing user to proceed
        InetAddress IP = null;
        int port = -1;
        try {
            if (jClient.isSelected()) {
                //Test IP
                IP = InetAddress.getByName(jIP.getText());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Could not parse given IP.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
        }
        
        if(jClient.isSelected() && IP == null){
            return;
        }
        
        try {
            port = Integer.parseInt(jPort.getText());
            if (port < 65535 && port > 1000) {
                //Do nothing
            } else {
                JOptionPane.showMessageDialog(this, "Port number must be above 1000 and below 65535.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid characters in \"Port\" field", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
        }
        
        if(port == -1){
            return;
        }
        
        //Test Port
        //Test UN
        if (jUN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User must specify a username.", "jChat - Invaild Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //If no test throws an exception, close JDialog window
        this.setVisible(false);
    }//GEN-LAST:event_jStartActionPerformed

    private void jIPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jIPFocusGained
        jIP.setText("");
        jIP.setForeground(Color.black);
    }//GEN-LAST:event_jIPFocusGained

private void jServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jServer1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jServer1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                StartupWindowTemp dialog = new StartupWindowTemp(new javax.swing.JFrame(), true);
                
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private URL url = ClassLoader.getSystemResource("logo.png");
    private ImageIcon icon = new ImageIcon(url);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    public static javax.swing.JCheckBox jClient;
    private javax.swing.JPanel jConfig;
    public static javax.swing.JTextField jIP;
    private javax.swing.JLabel jIPL;
    private javax.swing.JLabel jPL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jPort;
    public static javax.swing.JCheckBox jServer;
    public static javax.swing.JCheckBox jServer1;
    private javax.swing.JButton jStart;
    public static javax.swing.JTextField jUN;
    private javax.swing.JLabel jUNL;
    // End of variables declaration//GEN-END:variables
}
