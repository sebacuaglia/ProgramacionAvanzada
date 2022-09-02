package Vistas.GestionProyecto;
import Modelos.GestionProyecto.GestorTipoProyecto;
import Modelos.GestionProyecto.TipoProyecto;
import javax.swing.*;
import Vistas.GestorVista;

public class GestorVistaTipoProyecto  extends GestorVista {
    private FrmTipoProyecto form;  
    private GestorTipoProyecto gestor;                  
 
 //Definicion de getter y setter de variables, objetos y gestores 
    
    public TipoProyecto getModel() {
        return this.getGestor().getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((TipoProyecto) cmb.getSelectedItem());
    }

    private void setModel(TipoProyecto model) {
        this.getGestor().setModel(model);
    }

    public GestorTipoProyecto getGestor() {
        if (gestor == null) {
           synchronized (GestorTipoProyecto.class) {
                gestor = new GestorTipoProyecto();
           }
        }
        return gestor;
    }

    public void setGestor(GestorTipoProyecto gestor) {
        this.gestor = gestor;
    }

    public FrmTipoProyecto getForm() {
        return form;
    }

    public void setForm(FrmTipoProyecto form) {
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
            this.getModel().setDenominacion(this.getForm().getTxtDenominacion().getText());            
            this.getModel().setObservacion(this.getForm().getTxtObservaciones().getText());            
            
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
        if (this.isEmpty(this.getForm().getTxtDenominacion())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
            this.getForm().getTxtDenominacion().grabFocus();
            return false;
        } 
        
        return true;
    }

    @Override
    public boolean getModelXCodigo(String codigo) {
        TipoProyecto auxModel;
        auxModel=this.getGestor().buscarCodigo(codigo);
        if (auxModel!=null) {
           this.setModel(auxModel);
           return true;  }
        else {
            return false;
        }
    }

    public void setModelProyecto(JComboBox cmb) {
        cmb.setModel(getGestor().getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmTipoProyecto(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
        public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
         this.setEscritorio(pantalla);
        this.setModelCombo(model);
         this.setOpcABM(2);
        this.setForm(new FrmTipoProyecto(this));
        this.setTitulo(this.getForm().getTitle());
         this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);// Se tiene que duplicar la sentencia NO BORRAR!!!!  
    }
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtDenominacion().setText(this.getModel().getDenominacion());
        this.getForm().getTxtObservaciones().setText(this.getModel().getObservacion());
    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) {
            this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
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