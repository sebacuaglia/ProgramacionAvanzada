package Vistas;

import Modelos.GestionProyecto.*;
import javax.swing.JDesktopPane;

public class GestorVistaPrincipal extends GestorVista {

    public FrmPrincipal frmPrincipal;

    public void abrirPrincipal() {
        FrmPrincipal frmPrincipal = new FrmPrincipal(this);
        frmPrincipal.setVisible(true);
    }

    public void abrirProyecto(JDesktopPane escritorio) {
        GestorVistaProyecto gestor = new GestorVistaProyecto();
        gestor.openFormulario(escritorio);
    }

    public void abrirTipoProyecto(JDesktopPane escritorio) {
        GestorVistaTipoProyecto gestor = new GestorVistaTipoProyecto();
        gestor.openFormulario(escritorio);
    }

    public void abrirTipoProyecto2(JDesktopPane escritorio) {
        GestorVistaTipoProyecto2 gestor = new GestorVistaTipoProyecto2();
        gestor.openFormulario(escritorio);
    }

    public void abrirMarca(JDesktopPane escritorio) {
        GestorVistaMarca gestor = new GestorVistaMarca();
        gestor.openFormulario(escritorio);
    }

    public void abrirModelo(JDesktopPane escritorio) {
        GestorVistaModelo gestor = new GestorVistaModelo();
        gestor.openFormulario(escritorio);
    }

    public void abrirAuto(JDesktopPane escritorio) {
        GestorVistaAuto gestor = new GestorVistaAuto();
        gestor.openFormulario(escritorio);
    }

    public void abrirCliente(JDesktopPane escritorio) {
        GestorVistaCliente gestor = new GestorVistaCliente();
        gestor.openFormulario(escritorio);
    }

    public void abrirPersonal(JDesktopPane escritorio) {
        GestorVistaPersonal gestor = new GestorVistaPersonal();
        gestor.openFormulario(escritorio);
    }
    
    public void abrirVenta(JDesktopPane escritorio) {
        GestorVistaVenta gestor = new GestorVistaVenta();
        gestor.openFormulario(escritorio);
    }
    
    public void abrirTop10VentasMarca(JDesktopPane escritorio) {
        GestorVistaTop10VentasMarca gestor = new GestorVistaTop10VentasMarca();
        gestor.openFormulario(escritorio);
    }
    
    public void abrirTop10VentasModelo(JDesktopPane escritorio) {
        GestorVistaTop10VentasModelo gestor = new GestorVistaTop10VentasModelo();
        gestor.openFormulario(escritorio);
    }
    
     public void abrirVentaPorVendedor(JDesktopPane escritorio) {
        GestorVistaVentaPorVendedor gestor = new GestorVistaVentaPorVendedor();
        gestor.openFormulario(escritorio);
    }

}
