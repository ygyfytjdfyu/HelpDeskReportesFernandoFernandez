package controlador;

import vista.InterfazPrincipal;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SettingsController implements MouseListener {

    private InterfazPrincipal vista;

    private final Color COLOR_HOVER = new Color(34, 197, 94);   // verde
    private final Color COLOR_DEFAULT = new Color(15, 23, 24);  // tu color real de panel

    public SettingsController(InterfazPrincipal vista) {
        this.vista = vista;

        vista.IbIIncidencias.addMouseListener(this);
        vista.IblUsuarios.addMouseListener(this);
        vista.IbITecnicos.addMouseListener(this);
        vista.IbICategorias.addMouseListener(this);
        vista.IbIEspecialidades.addMouseListener(this);
        vista.IbIReportes.addMouseListener(this);
        vista.IbIReportes1.addMouseListener(this);        // Asistente IA
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == vista.IbIIncidencias) {
            vista.panelIncidencias.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IblUsuarios) {
            vista.panelUsuarios.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IbITecnicos) {
            vista.panelTecnicos.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IbICategorias) {
            vista.panelCategorias.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IbIEspecialidades) {
            vista.panelEspcialidades.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IbIReportes) {
            vista.panelReportes.setBackground(COLOR_HOVER);
        } else if (e.getSource() == vista.IbIReportes1) {
            vista.panelAsistenteAI.setBackground(COLOR_HOVER);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == vista.IbIIncidencias) {
            vista.panelIncidencias.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IblUsuarios) {
            vista.panelUsuarios.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IbITecnicos) {
            vista.panelTecnicos.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IbICategorias) {
            vista.panelCategorias.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IbIEspecialidades) {
            vista.panelEspcialidades.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IbIReportes) {
            vista.panelReportes.setBackground(COLOR_DEFAULT);
        } else if (e.getSource() == vista.IbIReportes1) {
            vista.panelAsistenteAI.setBackground(COLOR_DEFAULT);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
    if (e.getSource() == vista.IbIIncidencias) {
        vista.jTabbedPane1.setSelectedIndex(0);
    } else if (e.getSource() == vista.IblUsuarios) {
        vista.jTabbedPane1.setSelectedIndex(1);
    } else if (e.getSource() == vista.IbITecnicos) {
        vista.jTabbedPane1.setSelectedIndex(2);
    } else if (e.getSource() == vista.IbICategorias) {
        vista.jTabbedPane1.setSelectedIndex(3);
    } else if (e.getSource() == vista.IbIEspecialidades) {
        vista.jTabbedPane1.setSelectedIndex(4);
    } else if (e.getSource() == vista.IbIReportes) {
        vista.jTabbedPane1.setSelectedIndex(5);
    } else if (e.getSource() == vista.IbIReportes1) {
        vista.jTabbedPane1.setSelectedIndex(6);
    }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}