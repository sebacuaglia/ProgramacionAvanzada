/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sebac
 */
public class GestorVistaVenta extends GestorVista {

    private FrmVenta1 form;
    private Venta model;
    private DetalleVenta modelDetalle;
    private GestorVistaAuto gestorAuto = new GestorVistaAuto();
    private GestorVistaCliente gestorCliente = new GestorVistaCliente();
    private GestorVistaPersonal gestorPersonal = new GestorVistaPersonal();

    public FrmVenta1 getForm() {
        return form;
    }

    public void setForm(FrmVenta1 form) {
        this.form = form;
    }

    public Venta getModel() {
        return model;
    }

    public void setModel(Venta model) {
        this.model = model;
    }

    public GestorVistaAuto getGestorAuto() {
        return gestorAuto;
    }

    public void setGestorAuto(GestorVistaAuto gestorAuto) {
        this.gestorAuto = gestorAuto;
    }

    public GestorVistaCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(GestorVistaCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public GestorVistaPersonal getGestorPersonal() {
        return gestorPersonal;
    }

    public void setGestorPersonal(GestorVistaPersonal gestorPersonal) {
        this.gestorPersonal = gestorPersonal;
    }
    
    public DetalleVenta getModelDetalle() {
        return modelDetalle;
    }

    public void setModelDetalle(DetalleVenta modelDetalle) {
        this.modelDetalle = modelDetalle;
    }

     public void getViewDetalle() {
         
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getcmbCliente().setSelectedItem(this.getModel().getCliente());
        this.getForm().getCmbPersonal().setSelectedItem(this.getModel().getPersonal());
      
    }
      public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getcmbCliente().setSelectedItem(this.getModel().getCliente());
        this.getForm().getCmbPersonal().setSelectedItem(this.getModel().getPersonal());
      
    }
  public void setDatos() {
        if (this.getOpcABM() == 1) {
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?", "Modificar Producto", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblVentas())) {
                    this.setModel((Venta) this.getItemTablaSelected(this.getForm().getTblVentas()));
                    //this.getForm().clearView();
                    this.getForm().viewActualizar2();
                    this.setBusquedaDetalle(this.getModel());  
                }
            }
        } else {
            if (this.isItemTablaSelected(this.getForm().getTblVentas())) {
                this.setModel((Venta) this.getItemTablaSelected(this.getForm().getTblVentas()));
                //this.getForm().clearView();
                this.getForm().viewActualizar2();
                this.setBusquedaDetalle(this.getModel());    
            }
        }
    }
  
    @Override
    public void newModel() {
        this.setModel(new Venta());
        this.setModoNuevo();
    }

    public void setModelCliente(JComboBox cmb) {
        cmb.setModel(getComboModelCliente());
    }

    public void setModelPersonal(JComboBox cmb) {
        cmb.setModel(getComboModelPersonal());
    }

    public DefaultComboBoxModel getComboModelCliente() {
        return this.getGestorCliente().getComboModelCliente();
    }

    public DefaultComboBoxModel getComboModelPersonal() {
        return this.getGestorPersonal().getComboModelPersonal();
    }

    @Override
    public void saveView() {
        int err;
        err = this.setModel();
        if (err == 0) {
            this.saveModel(this.getOpcABM());
            for (int i = 0; i < this.getForm().getTblDatosDetalleVenta().getRowCount(); i++) {
                this.setModelDetalle(new DetalleVenta());
                DefaultTableModel model = (DefaultTableModel) this.getForm().getTblDatosDetalleVenta().getModel();
                err = this.setModelDetalle(model,i);
                if (err == 0) {
                    this.guardarObjeto(this.getModelDetalle());
                }

            }
            {

            }

            this.actualizarView();
        }
    }
    
    public void guardarObjeto() {
        this.newCodigo();
        this.guardarObjeto(this.getModel());

        // para cada detalle guardar
    }

    //String[] titulo = {"", "Cód.", "Marca", "Modelo", "Precio", "cantidad", "impuesto"};
    public int setModelDetalle(DefaultTableModel model, int i) {
        this.getModelDetalle().setAuto((Auto) model.getValueAt(i, 0));
        this.getModelDetalle().setPrecioAuto(Integer.parseInt((String) model.getValueAt(i, 4)) );
        this.getModelDetalle().setCantidad((int) model.getValueAt(i, 5));
        this.getModelDetalle().setPorcImpuesto((int) model.getValueAt(i, 6) );
        this.getModelDetalle().setVenta(this.getModel());
        return 0;

    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM() == 0) {
            this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
//            this..setItems(this.getForm().getTbl());
        }
        if (this.getOpcABM() == 2) {
            this.getModelCombo().addElement(this.getModel());
            this.getModelCombo().setSelectedItem(this.getModel());
            this.getForm().dispose();
        }

    }

    @Override
      public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setCliente((Cliente) this.getForm().getcmbCliente().getSelectedItem());
            this.getModel().setPersonal((Personal) this.getForm().getCmbPersonal().getSelectedItem());
            this.getModel().setFecha(new Date(System.currentTimeMillis()));
            this.getModel().setCodigo(this.getUltimoCodigo()+1);
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getcmbCliente())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca.");
            this.getForm().getcmbCliente().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getCmbPersonal())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el modelo.");
            this.getForm().getCmbPersonal().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtPrecio()) /*&& this.getForm().getTxtPrecio().getText().matches("[0-9]+")*/ ) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el precio de venta.");
            this.getForm().getTxtPrecio().grabFocus();
            return false;
        }

        return true;
    }

    public void saveModel(int opcABM) {
        switch (opcABM) {
            case 0:
                this.guardarObjeto();
                break;

            case 1:
                this.actualizarObjeto();
                break;

            case 2:
                this.eliminar();
                break;

        }
    }

    private void newCodigo() {
        this.getModel().setCodigo(this.getUltimoCodigo() + 1);
    }

    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    public void eliminar() {
        //solo deshabilitamos
       this.actualizarObjeto(this.getModel());

        //eliminar objeto
        //this.eliminarObjeto(this.getModel());
    }

    @Override
    public void deleteView() {

        this.eliminar();
        this.getForm().viewEliminar();
    }

    public int getUltimoCodigo() {
        try {
            Venta auxModel = (Venta) this.listarUltimo(Venta.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmVenta1(this, gestorCliente, gestorPersonal, gestorAuto));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmVenta1(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }

    void openFormularioCliente(DefaultComboBoxModel model) {
        GestorVistaCliente gestorVistaCliente = new GestorVistaCliente();
        gestorVistaCliente.openFormulario(model, this.getEscritorio());

    }

    void openFormularioPersonal(DefaultComboBoxModel model) {
        GestorVistaPersonal gestorVistaPersonal = new GestorVistaPersonal();
        gestorVistaPersonal.openFormulario(model, this.getEscritorio());
    }

    void openFormularioModelo(DefaultComboBoxModel model, JComboBox<String> marca) {
        GestorVistaModelo gestorVistaModelo = new GestorVistaModelo();
        gestorVistaModelo.openFormulario(model, this.getEscritorio(), (Marca) marca.getSelectedItem());
    }

    public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo = {"", "Cód.", "Marca", "Modelo", "Precio",};
        String[] ancho = {"0", "43", "100", "100", "100"};
        this.newModelTable(tbl, titulo, ancho);
    }
    
    public void initializeTabladetalle(JTable tbl) {
        String[] titulo = {"", "Cód.", "Marca", "Modelo", "Precio", "cantidad", "impuesto"};
        String[] ancho = {"0", "43", "100", "100", "100", "100", "100"};
        this.newModelTable(tbl, titulo, ancho);
    }
     public void initializeTablaventa(JTable tbl) {
        String[] titulo = {"", "Id.", "codigo", "fecha", "cliente", "personal"};
        String[] ancho = {"0", "43", "100", "100", "100", "100"};
        this.newModelTable(tbl, titulo, ancho);
    }

    

    

    private int getOrdenamiento() {
        int ord = 0;

        return ord;
    }

    

    public DefaultComboBoxModel getComboModelAuto() {
        DefaultComboBoxModel auxModel = new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Auto auxTipo : this.listarAutos()) {
            auxModel.addElement(auxTipo);
        }
        return auxModel;
    }

    public List<Auto> listarAutos() {
        return this.listarClase(Auto.class, "modelo");
    }
    
    
    public void setBusqueda() {
        Boolean error = false;
        this.initializeTablaBusqueda(this.getForm().getTblDatosAutos());

        if (!error) {

            this.getForm().getTblDatosAutos().setModel(this.getGestorAuto().listarDatos((DefaultTableModel) this.getForm().getTblDatosAutos().getModel(), this.getOrdenamiento(), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la búsqueda", "Validación de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public void setBusquedaVenta() {
        Boolean error = false;
        this.initializeTablaventa(this.getForm().getTblVentas());

        if (!error) {

            this.getForm().getTblVentas().setModel(this.listarDatos((DefaultTableModel) this.getForm().getTblVentas().getModel(), this.getOrdenamiento(), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la búsqueda", "Validación de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }
     
     public void setBusquedaDetalle(Venta venta) {
        Boolean error = false;
        this.initializeTabladetalle(this.getForm().getTblDatosDetalleVenta());

        if (!error) {

            this.getForm().getTblDatosDetalleVenta().setModel(
                    this.listarDatosDetalle((DefaultTableModel) this.getForm().getTblDatosDetalleVenta().getModel(), this.getOrdenamiento(), "",venta));
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la búsqueda", "Validación de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) {
        
        List<Venta> list = this.listar(text, ordenamiento);
        Venta auxModel;
        
        Iterator it2 = (Iterator) list.iterator();
        while (it2.hasNext()) {
            auxModel = (Venta) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getCodigo(),auxModel.getFecha(),auxModel.getCliente(),auxModel.getPersonal()};
            auxModelTabla.addRow(fila);
        }
        return auxModelTabla;
    }
    
    public DefaultTableModel listarDatosDetalle(DefaultTableModel auxModelTabla, int ordenamiento, String text, Venta venta) {
        
        List<DetalleVenta> list = this.listarDetalle(text, ordenamiento, venta);
        DetalleVenta auxModel;
        // {"", "Cód.", "Marca", "Modelo", "Precio", "cantidad", "impuesto"};
        Iterator it2 = (Iterator) list.iterator();
        while (it2.hasNext()) {
            auxModel = (DetalleVenta) it2.next();
            Object[] fila = {auxModel,auxModel.getCodigo(),
                auxModel.getAuto().getModelo().getMarca().getNombre(),
                auxModel.getAuto().getModelo().getNombre(),
                auxModel.getPrecioAuto(),
                auxModel.getCantidad(),
                auxModel.getPorcImpuesto()
            };
            auxModelTabla.addRow(fila);
        }
        return auxModelTabla;
    }

    public List<Venta> listar(String text, int ord) {
        Criteria crit = getSession().createCriteria(Venta.class);
        crit.add(Restrictions.isNotNull("codigo"));
        return crit.list();
    }
    
    public List<DetalleVenta> listarDetalle(String text, int ord, Venta venta) {
        Criteria crit = getSession().createCriteria(DetalleVenta.class);
        crit.add(Restrictions.eq("venta",venta));
        return crit.list();
    }
    
    public void agregarDetalle(JTable datosAuto, int cantidad){
        DefaultTableModel auxModelTabla = (DefaultTableModel) this.getForm().getTblDatosDetalleVenta().getModel();
        Auto auxModel = (Auto) this.getItemTablaSelected(datosAuto);
        
        Object[] fila = {auxModel,
                auxModel.getCodigo(), 
                auxModel.getModelo().getMarca().getNombre(),
                auxModel.getModelo().getNombre(),
                auxModel.getPrecio(),
                cantidad,
                auxModel.getModelo().getMarca().getPais().getPorcImpuesto()};
        
        auxModelTabla.addRow(fila);
        
        this.getForm().getTblDatosDetalleVenta().setModel(auxModelTabla);
        this.getForm().getTblDatosDetalleVenta().setEditingColumn(6);
        this.ejecutarCalculos();
    }
    
    public void EliminarDetalle(JTable datosDetalle){
       DefaultTableModel model = (DefaultTableModel) datosDetalle.getModel();
       model.removeRow(datosDetalle.getSelectedRow());
       this.ejecutarCalculos();
    }
    
    public Object getItemTablaSelected(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        return model.getValueAt(tbl.getSelectedRow(), 0);
    }
    
        public void ejecutarCalculos() {
        DefaultTableModel auxModelTabla = (DefaultTableModel) this.getForm().getTblDatosDetalleVenta().getModel();
        JTable tabla = this.getForm().getTblDatosDetalleVenta();
        double subtotal = 0, impuesto = 0, total = 0;
        for (int i = 0; i < auxModelTabla.getRowCount(); i++) {
            Auto auxModel = (Auto) auxModelTabla.getValueAt(i, 0);

            subtotal += this.subtotal(Integer.parseInt(auxModel.getPrecio()), Integer.parseInt((String) auxModelTabla.getValueAt(i, 5).toString()));
            impuesto += this.calcularImpuesto(Double.parseDouble(auxModel.getPrecio()), Integer.parseInt((String) auxModelTabla.getValueAt(i, 5).toString()), auxModel.getModelo().getMarca().getPais().getPorcImpuesto());
            total = subtotal + impuesto;

        }

        this.getForm().getTxtSubtotal().setText(subtotal + "");
        this.getForm().getTxtImpuestos().setText(impuesto + "");
        this.getForm().getTxtTotal().setText(total + "");

    }

    public Double subtotal(int monto, int cantidad){
        return Double.valueOf(monto*cantidad);
    }
    
    public Double calcularImpuesto(double monto, int cantidad, int impuesto){
        return Double.valueOf((monto/100 * impuesto) * cantidad); 
    }
    
}