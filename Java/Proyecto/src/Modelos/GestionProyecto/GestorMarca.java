/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import Modelos.GestionProyecto.Marca;
import Util.UtilJtable;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sebac
 */
public class GestorMarca extends  GestorHibernate{
    private Marca model;
    private GestorModelo gestorModelo = new GestorModelo();
    
    public Marca  getModel() {
        return model;
    }

    public void setModel(Marca  motivoCuota) {
        this.model = motivoCuota;
    }

    public GestorModelo getGestorModelo() {
        return gestorModelo;
    }

    public void setGestorModelo(GestorModelo gestorModelo) {
        this.gestorModelo = gestorModelo;
    }
    
    // Getter y Setter Objeto principal
    /*public String getCodigo() {
        return String.valueOf(this.getModel().getCodigo());
    }
   
    public String getDenominacion() {
        return this.getModel().getDenominacion();
    }

    public void setDenominacion(String denominacion) {
        this.getModel().setDenominacion(denominacion);
    }

    public int getEstado() {
        return this.getModel().getEstado();
    }

    public void setEstado(int estado) {
        this.getModel().setEstado(estado);
    }*/
     
    public Modelo getModelo() {
        return this.getModel().getListModelo();
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.getModel().setTipoProyecto(tipoProyecto);
    }
  
    public void setDetalle(JTable tbl) {
        this.setDetalle(UtilJtable.convertToSet(tbl));
    }

    public Set<ItemProyecto> getDetalle() {
        return this.getModel().getItems();
    }

    public void setDetalle(Set<ItemProyecto> detalle) {
        this.getModel().setItems(detalle);
    }
    
   ///////////////////////////////////////////////////////////////
       
    // Altas, bajas y modificaciones 
    public void newModel() {
         this.setModel(new Proyecto());// 
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
    public List <Proyecto> listar(){   
        return this.listarClase(Proyecto.class,"codigo",0);
    }
        
    public List <Proyecto> listar(TipoProyecto tipo){   
          Criteria crit = getSession().createCriteria(Proyecto.class)
               .add (Restrictions.eq("tipoProyecto",tipo))  
              .add (Restrictions.eq("estado",0));
        return crit.list();
    }
    
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Proyecto auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }  
    
    public DefaultComboBoxModel getComboModel(TipoProyecto tipo) {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Proyecto auxTipo : this.listar()) {
 
              
                auxModel.addElement(auxTipo); 
    
        }
         return auxModel;
    }
    
     public int getUltimoCodigo(){
          try {
           Proyecto auxModel= (Proyecto) this.listarUltimo(Proyecto.class).get(0);
           return auxModel.getCodigo();
        }
        catch(Exception e){
           return 0;
        }

    }

    public Proyecto buscarCodigo(String codigo) {
        return this.buscarCodigo(Integer.valueOf(codigo));
    }
   
    public Proyecto buscarCodigo(int codigo) {
       Proyecto  auxModel=null;
       try {
          auxModel= (Proyecto) this.listarClaseCodigo(Proyecto.class, codigo).get(0);
          return auxModel;}
       catch(Exception e){
          return auxModel;
       }
    }

    public DefaultComboBoxModel getComboModelTipoProyecto() {
       return this.getGestorTipoProyecto().getComboModel();
    }


}
