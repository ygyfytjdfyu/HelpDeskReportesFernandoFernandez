package controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.ReporteDao;
import modelo.ReportePDF;
import vista.InterfazPrincipal;

public class ReporteController implements ActionListener {

    private InterfazPrincipal vista;
    private ReporteDao reporteDao;
    private JComboBox<String> cmbEstado;
    private JComboBox<String> cmbCategoria;
    private JButton btnIncidencias;
    private JButton btnTecnicos;
    private JButton btnCategorias;

    public ReporteController(InterfazPrincipal vista,
            JComboBox<String> cmbEstado,
            JComboBox<String> cmbCategoria,
            JButton btnIncidencias,
            JButton btnTecnicos,
            JButton btnCategorias) {
        this.vista = vista;
        this.cmbEstado = cmbEstado;
        this.cmbCategoria = cmbCategoria;
        this.btnIncidencias = btnIncidencias;
        this.btnTecnicos = btnTecnicos;
        this.btnCategorias = btnCategorias;
        reporteDao = new ReporteDao();

        cargarFiltros();

        btnIncidencias.addActionListener(this);
        btnTecnicos.addActionListener(this);
        btnCategorias.addActionListener(this);
    }

    // LLENAR LOS COMBOS DE FILTRO
    public void cargarFiltros() {
        cmbEstado.removeAllItems();
        cmbEstado.addItem("Todos");
        cmbEstado.addItem("Pendiente");
        cmbEstado.addItem("Asignada");
        cmbEstado.addItem("En Proceso");
        cmbEstado.addItem("Resuelta");

        cmbCategoria.removeAllItems();
        cmbCategoria.addItem("Todas");
        cmbCategoria.addItem("Hardware");
        cmbCategoria.addItem("Software Hospitalario");
        cmbCategoria.addItem("Red");
        cmbCategoria.addItem("Impresoras");
        cmbCategoria.addItem("Correo Institucional");
        cmbCategoria.addItem("Base de Datos");
        cmbCategoria.addItem("Equipos Biomédicos");
        cmbCategoria.addItem("Sistema HIS");
    }

    // EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIncidencias) {
            generarIncidencias();
        } else if (e.getSource() == btnTecnicos) {
            generarTecnicos();
        } else if (e.getSource() == btnCategorias) {
            generarCategorias();
        }
    }

    // REPORTE INCIDENCIAS
    private void generarIncidencias() {
        String estado = cmbEstado.getSelectedItem().toString();
        String categoria = cmbCategoria.getSelectedItem().toString();
        List<String[]> datos = reporteDao.reporteIncidencias(estado, categoria);

        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No existen incidencias "
                    + "para los filtros seleccionados.");
            return;
        }
        String archivo = ReportePDF.generarIncidencias(datos, estado, categoria);
        abrirPDF(archivo);
    }

    // REPORTE TÉCNICOS
    private void generarTecnicos() {
        List<String[]> datos = reporteDao.reportePorTecnico();
        String archivo = ReportePDF.generarPorTecnico(datos);
        abrirPDF(archivo);
    }

    // REPORTE CATEGORÍAS
    private void generarCategorias() {
        List<String[]> datos = reporteDao.reportePorCategoria();
        String archivo = ReportePDF.generarPorCategoria(datos);
        abrirPDF(archivo);
    }

    // ABRIR PDF
    private void abrirPDF(String archivo) {
        if (archivo == null) {
            JOptionPane.showMessageDialog(vista, "No se pudo generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File pdf = new File(archivo);
            Desktop.getDesktop().open(pdf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "El reporte fue generado en:\n" + archivo);
        }
    }
}
