package controlador;

import vista.InterfazPrincipal;
import modelo.Usuario;
import modelo.UsuarioDao;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioController implements ActionListener, MouseListener, KeyListener {

    private InterfazPrincipal vista;
    private UsuarioDao usuarioDao = new UsuarioDao();

    public UsuarioController(InterfazPrincipal vista) {
        this.vista = vista;

        vista.btn_register_customer.addActionListener(this);
        vista.btn_update_customer.addActionListener(this);
        vista.btn_delete_customer.addActionListener(this);
        vista.btn_cancel_customer.addActionListener(this);

        vista.customer_table.addMouseListener(this);
        vista.txt_search_customers.addKeyListener(this);

        mostrarSiguienteId();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_register_customer) {
            registrarUsuario();
        } else if (e.getSource() == vista.btn_update_customer) {
            modificarUsuario();
        } else if (e.getSource() == vista.btn_delete_customer) {
            eliminarUsuario();
        } else if (e.getSource() == vista.btn_cancel_customer) {
            limpiarCampos();
        }
    }

    private void mostrarSiguienteId() {
        int siguiente = usuarioDao.obtenerSiguienteId();
        vista.txt_customer_id.setText(String.valueOf(siguiente));
    }

    private void registrarUsuario() {
        if (!camposValidos()) return;

        try {
            Usuario usuario = construirUsuarioDesdeFormulario();
            boolean exito = usuarioDao.registrar(usuario);

            if (exito) {
                DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();
                modelo.addRow(new Object[]{
                    usuario.getIdUsuario(), usuario.getNombres(), usuario.getApellidos(),
                    usuario.getCorreo(), usuario.getTelefono(), usuario.getCargo(), usuario.getArea()
                });
                JOptionPane.showMessageDialog(vista, "Usuario registrado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo registrar el usuario.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "El teléfono debe ser solo números.");
        }
    }

    private void modificarUsuario() {
        int filaSeleccionada = vista.customer_table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un usuario de la tabla primero.");
            return;
        }
        if (!camposValidos()) return;

        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();
            int id = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());

            Usuario usuario = construirUsuarioDesdeFormulario();
            usuario.setIdUsuario(id);

            boolean exito = usuarioDao.modificar(usuario);

            if (exito) {
                modelo.setValueAt(usuario.getNombres(), filaSeleccionada, 1);
                modelo.setValueAt(usuario.getApellidos(), filaSeleccionada, 2);
                modelo.setValueAt(usuario.getCorreo(), filaSeleccionada, 3);
                modelo.setValueAt(usuario.getTelefono(), filaSeleccionada, 4);
                modelo.setValueAt(usuario.getCargo(), filaSeleccionada, 5);
                modelo.setValueAt(usuario.getArea(), filaSeleccionada, 6);

                JOptionPane.showMessageDialog(vista, "Usuario modificado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo modificar el usuario.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Datos inválidos.");
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = vista.customer_table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un usuario de la tabla primero.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(vista, "¿Seguro que quieres eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();
        int id = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());

        boolean exito = usuarioDao.eliminar(id);

        if (exito) {
            modelo.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(vista, "Usuario eliminado correctamente.");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo eliminar el usuario.");
        }
    }

    private void buscarUsuarios(String texto) {
        DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();
        modelo.setRowCount(0);

        ArrayList<Usuario> lista = usuarioDao.buscar(texto);
        for (Usuario u : lista) {
            modelo.addRow(new Object[]{
                u.getIdUsuario(), u.getNombres(), u.getApellidos(),
                u.getCorreo(), u.getTelefono(), u.getCargo(), u.getArea()
            });
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txt_search_customers) {
            String texto = vista.txt_search_customers.getText();
            DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();
            if (texto.isEmpty()) {
                modelo.setRowCount(0);
            } else {
                buscarUsuarios(texto);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.customer_table) {
            int fila = vista.customer_table.getSelectedRow();
            if (fila == -1) return;

            DefaultTableModel modelo = (DefaultTableModel) vista.customer_table.getModel();

            vista.txt_customer_id.setText(modelo.getValueAt(fila, 0).toString());
            vista.txt_customer_fullname.setText(modelo.getValueAt(fila, 1).toString());
            vista.txt_customer_address.setText(modelo.getValueAt(fila, 2).toString());
            vista.txt_customer_email.setText(modelo.getValueAt(fila, 3).toString());
            vista.txt_customer_telephone.setText(modelo.getValueAt(fila, 4).toString());
            vista.cbxUsuarioCargo.setSelectedItem(modelo.getValueAt(fila, 5).toString());
            vista.cbxUsuarioArea.setSelectedItem(modelo.getValueAt(fila, 6).toString());
        }
    }

    private Usuario construirUsuarioDesdeFormulario() {
        Usuario usuario = new Usuario();
        usuario.setNombres(vista.txt_customer_fullname.getText());
        usuario.setApellidos(vista.txt_customer_address.getText());
        usuario.setCorreo(vista.txt_customer_email.getText());
        usuario.setTelefono(Long.parseLong(vista.txt_customer_telephone.getText()));
        usuario.setCargo(vista.cbxUsuarioCargo.getSelectedItem().toString());
        usuario.setArea(vista.cbxUsuarioArea.getSelectedItem().toString());
        return usuario;
    }

    private boolean camposValidos() {
        if (vista.txt_customer_fullname.getText().isEmpty() ||
            vista.txt_customer_address.getText().isEmpty() ||
            vista.txt_customer_email.getText().isEmpty() ||
            vista.txt_customer_telephone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Completa todos los campos.");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        mostrarSiguienteId();
        vista.txt_customer_fullname.setText("");
        vista.txt_customer_address.setText("");
        vista.txt_customer_email.setText("");
        vista.txt_customer_telephone.setText("");
        vista.cbxUsuarioArea.setSelectedIndex(0);
        vista.cbxUsuarioCargo.setSelectedIndex(0);
        vista.customer_table.clearSelection();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}
}