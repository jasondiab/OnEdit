package usersystem;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diabj
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        usernameinput = new javax.swing.JTextField();
        usericon = new javax.swing.JLabel();
        passicon = new javax.swing.JLabel();
        loginbutton = new javax.swing.JButton();
        usernamelabel = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        passlabel = new javax.swing.JLabel();
        passinput = new javax.swing.JPasswordField();
        registerbutton = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        usernameinput.setOpaque(false);
        usernameinput.setSelectionColor(new java.awt.Color(255, 199, 28));
        usernameinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameinputActionPerformed(evt);
            }
        });

        usericon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user 2.png"))); // NOI18N
        usericon.setText("jLabel2");

        passicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pass.png"))); // NOI18N
        passicon.setText("jLabel2");

        loginbutton.setBackground(new java.awt.Color(255, 199, 28));
        loginbutton.setFont(new java.awt.Font("Verdana Pro Black", 1, 14)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(46, 50, 60));
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        usernamelabel.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        usernamelabel.setForeground(new java.awt.Color(46, 50, 60));
        usernamelabel.setText("Username");

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hi.png"))); // NOI18N
        logo.setText("jLabel7");

        passlabel.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        passlabel.setForeground(new java.awt.Color(46, 50, 60));
        passlabel.setText("Password");

        passinput.setSelectionColor(new java.awt.Color(255, 199, 28));
        passinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passinputActionPerformed(evt);
            }
        });

        registerbutton.setBackground(new java.awt.Color(46, 50, 60));
        registerbutton.setFont(new java.awt.Font("Verdana Pro Black", 1, 14)); // NOI18N
        registerbutton.setForeground(new java.awt.Color(255, 255, 255));
        registerbutton.setText("Register");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usericon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passicon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(usernamelabel)
                                .addGap(10, 10, 10))
                            .addComponent(usernameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passinput, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passlabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamelabel)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usericon))
                .addGap(18, 18, 18)
                .addComponent(passlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passinput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passicon))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        usernameinput.getAccessibleContext().setAccessibleName("usernameinput");
        usericon.getAccessibleContext().setAccessibleName("usericon");
        passicon.getAccessibleContext().setAccessibleName("passicon");
        loginbutton.getAccessibleContext().setAccessibleName("Login button");
        logo.getAccessibleContext().setAccessibleName("Logo");
        passinput.getAccessibleContext().setAccessibleName("passwordinput");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
        String username= usernameinput.getText();
        String password= String.valueOf(passinput.getPassword());
        if(username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please fill in the required fields","Error",JOptionPane.ERROR_MESSAGE);
        } else{//login process
            userLogin(username,password);
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void usernameinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameinputActionPerformed

    private void passinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passinputActionPerformed

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
        // TODO add your handling code here:
        dispose();
        register r = new register();
        r.setTitle("Register a new user");
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }//GEN-LAST:event_registerbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginbutton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel passicon;
    private javax.swing.JPasswordField passinput;
    private javax.swing.JLabel passlabel;
    private javax.swing.JButton registerbutton;
    private javax.swing.JLabel usericon;
    private javax.swing.JTextField usernameinput;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables

    private void userLogin(String username, String password) {
        Connection dbconn = Connect.connectdb();
        if(dbconn != null){
        try {
            PreparedStatement st = (PreparedStatement)
                    dbconn.prepareStatement("Select * from users WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            if(res.next()){
                //display dashboard or new page after login
                dispose();
                Dashboard d = new Dashboard();
                d.setTitle("Dashboard");
                d.setLocationRelativeTo(null);
                d.setVisible(true);
            } else {
                System.out.println("username " + username);
                System.out.println("password " + password);
                JOptionPane.showMessageDialog(this,"Username/Password combination is invalid","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            System.out.println("Connection not available");
        }
    }
}