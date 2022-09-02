package Modelos.GestionProyecto;
import Hibernate.GestorHibernate;
import java.util.*;
import javax.swing.DefaultComboBoxModel;

public class GestorTipoProyecto extends  GestorHibernate{
    private TipoProyecto  model;

    public TipoProyecto  getModel() {
        return model;
    }

    public void setModel(TipoProyecto  motivoCuota) {
        this.model = motivoCuota;
    }

    // Altas, bajas y modificaciones 
    public void newModel() {
         this.setModel(new TipoProyecto());
    }

  
    private void newCodigo() {
        this.getModel().setCodigo(this.getUltimoCodigo()+1);
    }
     
    public void saveModel(int opcABM) {
        switch (opcABM){
            case 0:
                this.guardarObjeto();
                break;
              
            case 1:
                this.actualizarObjeto();
                break;   
              
            case 2:
                this.guardarObjeto();
                break;
        
        }
    }
    
    public void guardarObjeto(){
        this.newCodigo();
        this.guardarObjeto(this.getModel());
    } 
   
    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }
  
    public void eliminar() {
        this.getModel().eliminar();
        this.actualizarObjeto();
    }
    
   // busquedas, iteradores y otras 
    public List <TipoProyecto> listar(){   
        return this.listarClase(TipoProyecto.class,"codigo",0);
    }
       
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (TipoProyecto auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
     public int getUltimoCodigo(){
          try {
           TipoProyecto auxModel= (TipoProyecto) this.listarUltimo(TipoProyecto.class).get(0);
           return auxModel.getCodigo();
        }
        catch(Exception e){
           return 0;
        }

    }

    public TipoProyecto buscarCodigo(String codigo) {
        return this.buscarCodigo(Integer.valueOf(codigo));
    }
   
    public TipoProyecto buscarCodigo(int codigo) {
       TipoProyecto  auxModel=null;
       try {
          auxModel= (TipoProyecto) this.listarClaseCodigo(TipoProyecto.class, codigo).get(0);
          return auxModel;
       }
       catch(Exception e){
          return auxModel;
       }
    }

    
    
    
}
