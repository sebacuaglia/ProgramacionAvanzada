/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import Hibernate.GestorHibernate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author sebac
 */
public class GestorModelo extends GestorHibernate{
    private Modelo modelo;
    
    
    public Modelo getModel() {
        return modelo;
    }

    public void setModel(Modelo model) {
        this.modelo = model;
    }

    // Altas, bajas y modificaciones 
    public void newModel() {
         this.setModel(new Modelo());
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
        this.guardarObjeto(this.getModel());
    } 
   
    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }
  
    public void eliminar() {
        //this.getModel().eliminar();
        this.actualizarObjeto();
    }
    
   // busquedas, iteradores y otras 
    public List <Modelo> listar(){   
        return this.listarClase(Modelo.class,"nombre");
    }
       
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Modelo auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    
    /*
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
    }*/

    
    
    
}
