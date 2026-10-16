package vista;

import controlador.LoginController;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

public class InterfazLogin extends javax.swing.JFrame {

    private final LoginController loginController = new LoginController();


    public InterfazLogin() {
        initComponents();
        setResizable(false);
        setTitle("Ingresar al Sistema");
        setLocationRelativeTo(null);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_pasword = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_userName = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_enter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_pasword.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_pasword.setForeground(new java.awt.Color(255, 255, 255));
        txt_pasword.setText("INICIAR SESION");
        jPanel3.add(txt_pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pasword");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        txt_userName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 210, 35));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel3.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 210, 35));

        btn_enter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_enter.setText("INGRESAR");
        btn_enter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });
        jPanel3.add(btn_enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 210, 35));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 420));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 0, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userNameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
        String usuario = txt_userName.getText().trim();
    String password = new String(txt_password.getPassword());

    if (usuario.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debes ingresar usuario y contraseña.");
        return;
    }

    boolean valido = loginController.autenticar(usuario, password);

    if (valido) {
        JOptionPane.showMessageDialog(this, "Bienvenido, " + LoginController.getTecnicoActivo().getNombreCompleto());
        this.dispose();
        new vista.InterfazPrincipal().setVisible(true);   // <-- AGREGA ESTA LÍNEA
    } else {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
    }
    }//GEN-LAST:event_btn_enterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPasswordField txt_password;
    private javax.swing.JLabel txt_pasword;
    public javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
