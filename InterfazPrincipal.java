package vista;

import controlador.SettingsController;
import controlador.UsuarioController;
import java.awt.Image;
import javax.swing.ImageIcon;
import controlador.ReporteController;

/**
 * Ventana principal del sistema (JFrame Form).
 * Se muestra despues de un login correcto.
 *
 * Diseño en NetBeans (pestaña Design):
 *   - panelLogo (arriba-izquierda, blanco) con lblLogo
 *   - panelHeader (arriba, azul marino) con lblTitulo + lblFoto + btnSalir
 *   - panelSidebar (izquierda, azul marino) con 7 botones
 *   - tabPrincipal (JTabbedPane) con 7 pestañas
 */
public class InterfazPrincipal extends javax.swing.JFrame {

 public InterfazPrincipal() {
        initComponents();
        setSize(1208,680);
        setResizable(false);
        setTitle("Panel de Administracion");
        setLocationRelativeTo(null);
        this.repaint();
        
        new SettingsController(this);
         new UsuarioController(this);
         new ReporteController(this, cmbEstado, cmbCategoria, btnIncidencias, btnTecnicos, btnCategorias);
        
        
         // --- Escalar el logo para que se vea completo ---
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/logo.png"));
    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
        200, 100, Image.SCALE_SMOOTH
    );
    jLabel1.setIcon(new ImageIcon(imagenEscalada));

   

        
} 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Menu = new javax.swing.JPanel();
        panelIncidencias = new javax.swing.JPanel();
        IbIIncidencias = new javax.swing.JLabel();
        panelUsuarios = new javax.swing.JPanel();
        IblUsuarios = new javax.swing.JLabel();
        panelTecnicos = new javax.swing.JPanel();
        IbITecnicos = new javax.swing.JLabel();
        panelCategorias = new javax.swing.JPanel();
        IbICategorias = new javax.swing.JLabel();
        panelEspcialidades = new javax.swing.JPanel();
        IbIEspecialidades = new javax.swing.JLabel();
        panelReportes = new javax.swing.JPanel();
        IbIReportes = new javax.swing.JLabel();
        panelAsistenteAI = new javax.swing.JPanel();
        IbIReportes1 = new javax.swing.JLabel();
        panelLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cabecera = new javax.swing.JPanel();
        IbITitulo = new javax.swing.JLabel();
        btnLoginOut = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_register_customer = new javax.swing.JButton();
        btn_update_customer = new javax.swing.JButton();
        btn_delete_customer = new javax.swing.JButton();
        btn_cancel_customer = new javax.swing.JButton();
        txt_customer_id = new javax.swing.JTextField();
        txt_customer_fullname = new javax.swing.JTextField();
        txt_customer_address = new javax.swing.JTextField();
        txt_customer_telephone = new javax.swing.JTextField();
        cbxUsuarioCargo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_customer_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxUsuarioArea = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_search_customers = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTituloReportes = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnIncidencias = new javax.swing.JButton();
        btnTecnicos = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Administrativo Help Desk");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(36, 140, 106));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIncidencias.setBackground(new java.awt.Color(15, 23, 24));

        IbIIncidencias.setBackground(new java.awt.Color(255, 255, 255));
        IbIIncidencias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbIIncidencias.setForeground(new java.awt.Color(255, 255, 255));
        IbIIncidencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incidencias.png"))); // NOI18N
        IbIIncidencias.setText("   Incidencias");

        javax.swing.GroupLayout panelIncidenciasLayout = new javax.swing.GroupLayout(panelIncidencias);
        panelIncidencias.setLayout(panelIncidenciasLayout);
        panelIncidenciasLayout.setHorizontalGroup(
            panelIncidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIncidenciasLayout.createSequentialGroup()
                .addComponent(IbIIncidencias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        panelIncidenciasLayout.setVerticalGroup(
            panelIncidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IbIIncidencias, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        Menu.add(panelIncidencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 35));

        panelUsuarios.setBackground(new java.awt.Color(15, 23, 24));

        IblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IblUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        IblUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuarios.png"))); // NOI18N
        IblUsuarios.setText("   Usuarios");

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(IblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IblUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        Menu.add(panelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 35));

        panelTecnicos.setBackground(new java.awt.Color(15, 23, 24));

        IbITecnicos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbITecnicos.setForeground(new java.awt.Color(255, 255, 255));
        IbITecnicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tecnicos.png"))); // NOI18N
        IbITecnicos.setText("   Tecnicos");

        javax.swing.GroupLayout panelTecnicosLayout = new javax.swing.GroupLayout(panelTecnicos);
        panelTecnicos.setLayout(panelTecnicosLayout);
        panelTecnicosLayout.setHorizontalGroup(
            panelTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTecnicosLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(IbITecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTecnicosLayout.setVerticalGroup(
            panelTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IbITecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        Menu.add(panelTecnicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 35));

        panelCategorias.setBackground(new java.awt.Color(15, 23, 24));

        IbICategorias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbICategorias.setForeground(new java.awt.Color(255, 255, 255));
        IbICategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Categorias.png"))); // NOI18N
        IbICategorias.setText("   Categorias");

        javax.swing.GroupLayout panelCategoriasLayout = new javax.swing.GroupLayout(panelCategorias);
        panelCategorias.setLayout(panelCategoriasLayout);
        panelCategoriasLayout.setHorizontalGroup(
            panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(IbICategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCategoriasLayout.setVerticalGroup(
            panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriasLayout.createSequentialGroup()
                .addComponent(IbICategorias)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        Menu.add(panelCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 35));

        panelEspcialidades.setBackground(new java.awt.Color(15, 23, 24));

        IbIEspecialidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbIEspecialidades.setForeground(new java.awt.Color(255, 255, 255));
        IbIEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Especialidades.png"))); // NOI18N
        IbIEspecialidades.setText("   Especialidades");

        javax.swing.GroupLayout panelEspcialidadesLayout = new javax.swing.GroupLayout(panelEspcialidades);
        panelEspcialidades.setLayout(panelEspcialidadesLayout);
        panelEspcialidadesLayout.setHorizontalGroup(
            panelEspcialidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEspcialidadesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(IbIEspecialidades, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEspcialidadesLayout.setVerticalGroup(
            panelEspcialidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEspcialidadesLayout.createSequentialGroup()
                .addComponent(IbIEspecialidades)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        Menu.add(panelEspcialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 35));

        panelReportes.setBackground(new java.awt.Color(15, 23, 24));

        IbIReportes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbIReportes.setForeground(new java.awt.Color(255, 255, 255));
        IbIReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes.png"))); // NOI18N
        IbIReportes.setText("   Reportes");

        javax.swing.GroupLayout panelReportesLayout = new javax.swing.GroupLayout(panelReportes);
        panelReportes.setLayout(panelReportesLayout);
        panelReportesLayout.setHorizontalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(IbIReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelReportesLayout.setVerticalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IbIReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        Menu.add(panelReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 35));

        panelAsistenteAI.setBackground(new java.awt.Color(15, 23, 24));

        IbIReportes1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IbIReportes1.setForeground(new java.awt.Color(255, 255, 255));
        IbIReportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ai.png"))); // NOI18N
        IbIReportes1.setText("  Asistente IA");

        javax.swing.GroupLayout panelAsistenteAILayout = new javax.swing.GroupLayout(panelAsistenteAI);
        panelAsistenteAI.setLayout(panelAsistenteAILayout);
        panelAsistenteAILayout.setHorizontalGroup(
            panelAsistenteAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsistenteAILayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(IbIReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelAsistenteAILayout.setVerticalGroup(
            panelAsistenteAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IbIReportes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        Menu.add(panelAsistenteAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 35));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 580));

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        panelLogo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 100));

        getContentPane().add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 200));

        Cabecera.setBackground(new java.awt.Color(102, 204, 0));
        Cabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IbITitulo.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        IbITitulo.setForeground(new java.awt.Color(255, 255, 255));
        IbITitulo.setText("Asistente Helpdesk");
        Cabecera.add(IbITitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 390, 100));

        btnLoginOut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLoginOut.setText("Salir");
        btnLoginOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginOutActionPerformed(evt);
            }
        });
        Cabecera.add(btnLoginOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 35, -1, 30));

        getContentPane().add(Cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1010, 100));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Incidencias", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Identificacion:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Telefono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cargo:");

        btn_register_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_customer.setText("Registar");
        btn_register_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_customerActionPerformed(evt);
            }
        });

        btn_update_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_customer.setText("Modificar");
        btn_update_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_customerActionPerformed(evt);
            }
        });

        btn_delete_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_customer.setText("Eliminar");

        btn_cancel_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_customer.setText("Cancelar");
        btn_cancel_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_customerActionPerformed(evt);
            }
        });

        txt_customer_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customer_idActionPerformed(evt);
            }
        });

        txt_customer_fullname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt_customer_address.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt_customer_telephone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cbxUsuarioCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfermera", "Medico", "Bioquimica", "Farmaceutico", "Recepcionista", "Tecnico" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Correo:");

        txt_customer_email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Area:");

        cbxUsuarioArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emergencias", "Consuta Externa", "Laboratorio", "Farmacia", "Admision ", "Radiologia" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxUsuarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUsuarioArea, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_update_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_register_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxUsuarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btn_update_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbxUsuarioArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_cancel_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))))))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 920, 282));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Buscar:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        txt_search_customers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txt_search_customers, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, 30));

        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombres", "Apellidos", "Correo", "Telefono ", "Cargo ", "Area"
            }
        ));
        jScrollPane2.setViewportView(customer_table);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1010, 180));

        jTabbedPane1.addTab("Usuarios", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tecnicos", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Categorias", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Especialidades", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 153));

        lblTituloReportes.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTituloReportes.setText("REPORTES DEL SISTEMA HELPDESK");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEstado.setText("ESTADO: ");

        cmbEstado.setBackground(new java.awt.Color(51, 204, 0));
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCategoria.setText("CATEGORIA:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));

        btnIncidencias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIncidencias.setText("Reporte de Incidencias");

        btnTecnicos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTecnicos.setText("Incidencias por Técnico");

        btnCategorias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCategorias.setText("Incidencias por Categoría");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnIncidencias))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEstado))))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(lblCategoria))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnTecnicos)
                                .addGap(63, 63, 63)
                                .addComponent(btnCategorias))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblTituloReportes)))
                .addGap(290, 309, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTituloReportes)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblEstado))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncidencias)
                    .addComponent(btnTecnicos)
                    .addComponent(btnCategorias))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Asistente IA", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 1010, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginOutActionPerformed
         int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
    if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnLoginOutActionPerformed

    private void txt_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customer_idActionPerformed

    private void btn_register_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_register_customerActionPerformed

    private void btn_update_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_update_customerActionPerformed

    private void btn_cancel_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancel_customerActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cabecera;
    public javax.swing.JLabel IbICategorias;
    public javax.swing.JLabel IbIEspecialidades;
    public javax.swing.JLabel IbIIncidencias;
    public javax.swing.JLabel IbIReportes;
    public javax.swing.JLabel IbIReportes1;
    public javax.swing.JLabel IbITecnicos;
    private javax.swing.JLabel IbITitulo;
    public javax.swing.JLabel IblUsuarios;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnIncidencias;
    public javax.swing.JButton btnLoginOut;
    private javax.swing.JButton btnTecnicos;
    public javax.swing.JButton btn_cancel_customer;
    public javax.swing.JButton btn_delete_customer;
    public javax.swing.JButton btn_register_customer;
    public javax.swing.JButton btn_update_customer;
    public javax.swing.JComboBox<String> cbxUsuarioArea;
    public javax.swing.JComboBox<String> cbxUsuarioCargo;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstado;
    public javax.swing.JTable customer_table;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblTituloReportes;
    public javax.swing.JPanel panelAsistenteAI;
    public javax.swing.JPanel panelCategorias;
    public javax.swing.JPanel panelEspcialidades;
    public javax.swing.JPanel panelIncidencias;
    private javax.swing.JPanel panelLogo;
    public javax.swing.JPanel panelReportes;
    public javax.swing.JPanel panelTecnicos;
    public javax.swing.JPanel panelUsuarios;
    public javax.swing.JTextField txt_customer_address;
    public javax.swing.JTextField txt_customer_email;
    public javax.swing.JTextField txt_customer_fullname;
    public javax.swing.JTextField txt_customer_id;
    public javax.swing.JTextField txt_customer_telephone;
    public javax.swing.JTextField txt_search_customers;
    // End of variables declaration//GEN-END:variables

   
}
