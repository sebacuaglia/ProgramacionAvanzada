/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas.GestionProyecto;

import Modelos.GestionProyecto.GestorMarca;
import Modelos.GestionProyecto.Marca;
import Vistas.GestorVista;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebac
 */
public class GestorVistaMarca extends GestorVista {
    FrmMarca form;  
    GestorMarca gestor= new GestorMarca();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Marca getModel() {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Marca) cmb.getSelectedItem());
    }

    private void setModel(Marca model) {
        this.getGestor().setModel(model);
    }

    public GestorMarca getGestor() {
        return gestor;
    }

    public void setGestor(GestorMarca gestor) {
        this.gestor = gestor;
    }

    public FrmMarca getForm() {
        return form;
    }

    public void setForm(FrmMarca form) {
        this.form = form;
    }
  
     public void initializeTabla(JTable tbl) {
        String[] titulo={"","Modelo"};
        String[] ancho ={"5","200"};
        this.newModelTable(tbl,titulo,ancho);  
    } 
    
    
    @Override
    public void newModel() {
        this.gestor.newModel();
        this.setModoNuevo();
    } 

    @Override
    public void cancelarView() {
        
    }

    @Override
    public void deleteView() {
        
         this.getGestor().eliminar();
         this.getForm().viewEliminar();
    }
    
    @Override
    public int setModel() { 
        if (this.isDatosValidos()) {
            this.getGestor().setDenominacion(this.getForm().getTxtDenominacion().getText());     
            this.getGestor().setTipoProyecto((TipoProyecto) this.getForm().getCmbTipoProyecto().getSelectedItem());
            this.getGestor().setDetalle(this.getForm().getTbl());
            return 0;}
        else {
            return 1;
        } 
    }
    
    @Override
    public void saveView() {
        int err;
        err= this.setModel();
        if (err ==0){ 
           this.getGestor().saveModel(this.getOpcABM());
           this.actualizarView();
        }
    }
    
    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtDenominacion())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
            this.getForm().getTxtDenominacion().grabFocus();
            return false; 
           } 
    
        if (this.isEmpty(this.getForm().getTbl())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar el item de Proyecto");
            this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
    
    
         if (this.isEmpty(this.getForm().getCmbTipoProyecto())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la tipo de Proyecto");
            this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
        return true;
    }

    @Override
    public boolean getModelXCodigo(String codigo) {
        Proyecto auxModel;
        auxModel=this.gestor.buscarCodigo(codigo);
        if (auxModel!=null) {
           this.setModel(auxModel);
           return true;  }
        else {
            return false;
        }
    }

    public void setModelProyecto(JComboBox cmb) {
        cmb.setModel(gestor.getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmProyecto(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
      
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
        this.getForm().getTxtDenominacion().setText(this.getGestor().getDenominacion());
        this.getForm().getCmbTipoProyecto().setSelectedItem(this.getGestor().getTipoProyecto());
        this.setItems(this.getForm().getTbl());
    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) {
            this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
            this.getGestor().setDetalle(this.getForm().getTbl());
        }
   
    } 

    public void setModelTipoProyecto(JComboBox cmb) {
        cmb.setModel(gestor.getComboModelTipoProyecto());
   }
    
    
    private void setItems(JTable tbl) {
        this.initializeTabla(tbl);
        DefaultTableModel modeloTabla= (DefaultTableModel) tbl.getModel();
        for (ItemProyecto item : this.getGestor().getDetalle()) {
             Object[] fila = {item, item.getDenominacion()}; 
             modeloTabla.addRow(fila);
        }
    }
    
    public void addItem() {
        if (this.isItemValidos()) {
            DefaultTableModel modeloTabla  = (DefaultTableModel) this.getForm().getTbl().getModel(); 
            ItemProyecto item  = new  ItemProyecto(this.getForm().getTxtItemDenominacion().getText());  
          
            Object[] fila = {item, item.getDenominacion() }; 
            modeloTabla.addRow(fila); 
            this.getForm().clearItemView();
        }    
    }

    private boolean isItemValidos() {
        return true;
    }

    public void removeItem() {
       if (this.isItemTablaSelected(this.getForm().getTbl())){
           this.removeItemTabla(this.getForm().getTbl());
        }
    }

   public void imprimir() {

        this.abrirListado(this.pathReportes+"ListadoTipoDominio.jasper");
        this.agregarParametroListado("titulo", "Proyecto");
         this.agregarParametroListado("usuario", "Yo");
        this.agregarDatosListado(this.gestor.listar());
        this.imprimirListado();
    }

    void openFormularioModelo(DefaultComboBoxModel model) {
        GestorVistaModelo gestorVistaModelo =new GestorVistaModelo();
        gestorVistaModelo.openFormulario(model,this.getEscritorio());
    }
    
}
