package Vistas.GestionProyecto;
import Modelos.GestionProyecto.*;
import javax.swing.*;
import Vistas.GestorVista;
import javax.swing.table.DefaultTableModel;

public class GestorVistaProyecto  extends GestorVista {
    FrmProyecto form;  
    GestorProyecto gestor= new GestorProyecto();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Proyecto getModel() {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Proyecto) cmb.getSelectedItem());
    }

    private void setModel(Proyecto model) {
        this.getGestor().setModel(model);
    }

    public GestorProyecto getGestor() {
        return gestor;
    }

    public void setGestor(GestorProyecto gestor) {
        this.gestor = gestor;
    }

    public FrmProyecto getForm() {
        return form;
    }

    public void setForm(FrmProyecto form) {
        this.form = form;
    }
  
     public void initializeTabla(JTable tbl) {
        String[] titulo={"","Deuda"};
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

    void openFormularioTipo(DefaultComboBoxModel model) {
         GestorVistaTipoProyecto gestorVistaTipoGasto =new GestorVistaTipoProyecto();
        gestorVistaTipoGasto.openFormulario(model,this.getEscritorio());
    }
}
