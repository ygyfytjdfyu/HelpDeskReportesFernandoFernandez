package modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportePDF {

    // REPORTE DE INCIDENCIAS
    public static String generarIncidencias(List<String[]> datos, String estado, String categoria) {
        String archivo = "Reporte_Incidencias.pdf";
        try {
            Document documento = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();
            // FUENTES
            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 8);
            Font encabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8, BaseColor.WHITE);
            // ENCABEZADO
            Paragraph p = new Paragraph("SISTEMA HELPDESK", titulo);
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            p = new Paragraph("REPORTE DE INCIDENCIAS", subtitulo);
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            documento.add(new Paragraph(" "));
            String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            documento.add(new Paragraph("Fecha de generación: " + fecha, normal));
            documento.add(new Paragraph("Estado: " + estado + "     Categoría: " + categoria, normal));
            documento.add(new Paragraph(" "));
            // TABLA
            PdfPTable tabla = new PdfPTable(9);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1.2f, 1.2f, 1.0f, 2.5f, 1.0f, 2.0f, 2.0f, 1.7f, 1.4f});
            agregarEncabezado(tabla, "Ticket", encabezado);
            agregarEncabezado(tabla, "Fecha", encabezado);
            agregarEncabezado(tabla, "Hora", encabezado);
            agregarEncabezado(tabla, "Título", encabezado);
            agregarEncabezado(tabla, "Prioridad", encabezado);
            agregarEncabezado(tabla, "Usuario", encabezado);
            agregarEncabezado(tabla, "Técnico", encabezado);
            agregarEncabezado(tabla, "Categoría", encabezado);
            agregarEncabezado(tabla, "Estado", encabezado);
            // DATOS
            for (String[] fila : datos) {
                for (String dato : fila) {
                    PdfPCell celda = new PdfPCell(new Phrase(dato, normal));
                    celda.setPadding(4);
                    tabla.addCell(celda);
                }
            }
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            Paragraph total = new Paragraph("Total de incidencias: " + datos.size(), subtitulo);
            total.setAlignment(Element.ALIGN_RIGHT);
            documento.add(total);
            documento.add(new Paragraph(" "));
            Paragraph pie = new Paragraph("Sistema HelpDesk", normal);
            pie.setAlignment(Element.ALIGN_CENTER);
            documento.add(pie);
            documento.close();
            return archivo;
        } catch (Exception e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
            return null;
        }
    }

    // ENCABEZADO DE TABLA
    private static void agregarEncabezado(PdfPTable tabla, String texto, Font fuente) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBackgroundColor(new BaseColor(0, 0, 102));
        celda.setPadding(5);
        tabla.addCell(celda);
    }

    // =====================================================
    // REPORTE POR TÉCNICO
    // =====================================================
    public static String generarPorTecnico(List<String[]> datos) {
        return generarResumen(datos, "REPORTE DE INCIDENCIAS POR TÉCNICO", "TÉCNICO");
    }

    // =====================================================
    // REPORTE POR CATEGORÍA
    // =====================================================
    public static String generarPorCategoria(List<String[]> datos) {
        return generarResumen(datos, "REPORTE DE INCIDENCIAS POR CATEGORÍA", "CATEGORÍA");
    }

    // REPORTE RESUMEN
    private static String generarResumen(List<String[]> datos, String tituloReporte, String nombrePrimeraColumna) {
        String archivo = tituloReporte.replace(" ", "_").replace("Ó", "O").replace("É", "E").replace("Í", "I") + ".pdf";
        try {
            Document documento = new Document(PageSize.A4);
            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();
            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font encabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 10);
            Paragraph p = new Paragraph("SISTEMA HELPDESK", titulo);
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            p = new Paragraph(tituloReporte, titulo);
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(80);
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            agregarEncabezado(tabla, nombrePrimeraColumna, encabezado);
            agregarEncabezado(tabla, "TOTAL", encabezado);

            for (String[] fila : datos) {
                tabla.addCell(new Phrase(fila[0], normal));
                tabla.addCell(new Phrase(fila[1], normal));
            }
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            Paragraph pie = new Paragraph("Reporte generado por el Sistema HelpDesk", normal);
            pie.setAlignment(Element.ALIGN_CENTER);
            documento.add(pie);
            documento.close();
            return archivo;
        } catch (Exception e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
            return null;
        }
    }
}
