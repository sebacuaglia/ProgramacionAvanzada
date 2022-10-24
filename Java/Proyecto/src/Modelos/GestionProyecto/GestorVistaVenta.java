/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
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
            this.actualizarView();
        }
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
            //this.getModel().setNombre(this.getForm().getTxtNombre().getText());
            

            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        /*if (this.isEmpty(this.getForm().getCmbMarca())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca.");
            this.getForm().getCmbMarca().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getCmbModelo())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el modelo.");
            this.getForm().getCmbModelo().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtColor())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar un color.");
            this.getForm().getTxtColor().grabFocus();
            return false;
        }*/

        if (this.isEmpty(this.getForm().getTxtPrecio()) /*&& this.getForm().getTxtPrecio().getText().matches("[0-9]+")*/ ) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el precio de venta.");
            this.getForm().getTxtPrecio().grabFocus();
            return false;
        }
        /*
        if (this.isEmpty(this.getForm().getTxtCosto())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el precio de costo.");
            this.getForm().getTxtCosto().grabFocus();
            return false;
        }


        if (this.getForm().getCheckBoxUsado().isSelected()) {

            if (this.isEmpty(this.getForm().getTxtMatricula())) {
                JOptionPane.showMessageDialog(null, "Falta ingresar la matricula.");
                this.getForm().getTxtMatricula().grabFocus();
                return false;
            }

            if (this.isEmpty(this.getForm().getTxtKilometraje())) {
                JOptionPane.showMessageDialog(null, "Falta ingresar el kilometraje.");
                this.getForm().getTxtKilometraje().grabFocus();
                return false;
            }
            
            if (this.isEmpty(this.getForm().getTxtAnio())) {
                JOptionPane.showMessageDialog(null, "Falta ingresar el año.");
                this.getForm().getTxtAnio().grabFocus();
                return false;
            }
        }*/

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

    public void guardarObjeto() {
        this.newCodigo();
        this.guardarObjeto(this.getModel());
        
        // para cada detalle guardar
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
            Auto auxModel = (Auto) this.listarUltimo(Auto.class).get(0);
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
    
    public void ejecutarCalculos(){
        DefaultTableModel auxModelTabla = (DefaultTableModel) this.getForm().getTblDatosDetalleVenta().getModel();
        JTable tabla = this.getForm().getTblDatosDetalleVenta();
        double subtotal = 0,impuesto = 0,total = 0;
        for (int i = 0; i < auxModelTabla.getRowCount(); i++) {
            Auto auxModel = (Auto) auxModelTabla.getValueAt(i, 0);
        
            subtotal += Double.parseDouble(auxModel.getPrecio()) * Integer.parseInt((String) auxModelTabla.getValueAt(i, 5).toString() );
            impuesto += Double.parseDouble(auxModel.getPrecio())/100 *  auxModel.getModelo().getMarca().getPais().getPorcImpuesto() * Integer.parseInt((String) auxModelTabla.getValueAt(i, 5).toString() );
            total = subtotal + impuesto;
            
        }
        
        this.getForm().getTxtSubtotal().setText(subtotal+"");
        this.getForm().getTxtImpuestos().setText(impuesto+"");
        this.getForm().getTxtTotal().setText(total+"");
 
    }
    
}