/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas.GestionProyecto;

import Modelos.GestionProyecto.GestorModelo;
import Modelos.GestionProyecto.GestorTipoProyecto;
import Modelos.GestionProyecto.Modelo;
import Modelos.GestionProyecto.TipoProyecto;
import Vistas.GestorVista;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author sebac
 */
public class GestorVistaModelo extends GestorVista {
    private FrmModelo form;  
    private GestorModelo gestor;                  
 
 //Definicion de getter y setter de variables, objetos y gestores 
    
    public Modelo getModel() {
        return this.getGestor().getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Modelo) cmb.getSelectedItem());
    }

    private void setModel(Modelo model) {
        this.getGestor().setModel(model);
    }

    public GestorModelo getGestor() {
        if (gestor == null) {
           synchronized (GestorModelo.class) {
                gestor = new GestorModelo();
           }
        }
        return gestor;
    }

    public void setGestor(GestorModelo gestor) {
        this.gestor = gestor;
    }

    public FrmModelo getForm() {
        return form;
    }

    public void setForm(FrmModelo form) {
        this.form = form;
    }
  
    @Override
    public void newModel() {
        this.getGestor().newModel();
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
            this.getModel().setNombre(this.getForm().getTxtModelo().getText()); 
            return 0;
        }
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
        if (this.isEmpty(this.getForm().getTxtModelo())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar el modelo del vehiculo");
            this.getForm().getTxtModelo().grabFocus();
            return false;
        } 
        
        return true;
    }

    

    public void setModelProyecto(JComboBox cmb) {
        cmb.setModel(getGestor().getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmModelo(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
        public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
         this.setEscritorio(pantalla);
        this.setModelCombo(model);
         this.setOpcABM(2);
        this.setForm(new FrmModelo(this));
        this.setTitulo(this.getForm().getTitle());
         this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);// Se tiene que duplicar la sentencia NO BORRAR!!!!  
    }
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(String.valueOf(this.getModel().getId()));
        this.getForm().getTxtModelo().setText(this.getModel().getNombre());
    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) {
            this.getForm().getTxtCodigo().setText(String.valueOf(this.getModel().getId()));
        }
    
        if (this.getOpcABM()==2) {
            this.getModelCombo().addElement(this.getModel());
            this.getModelCombo().setSelectedItem(this.getModel());
   this.getForm().dispose(); 
        }
    } 

 public void imprimir() {

        this.abrirListado(GestorVistaTipoProyecto.pathReportes+"ListadoTipoDominio.jasper");
        this.agregarParametroListado("titulo", "tipo Proyecto");
        this.agregarDatosListado(this.gestor.listar());
        this.imprimirListado();
    }
}
