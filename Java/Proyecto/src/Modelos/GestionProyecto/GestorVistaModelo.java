/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sebac
 */
public class GestorVistaModelo extends GestorVista {

    private FrmModelo form;
    private Modelo model;
    private GestorVistaMarca gestorMarca = new GestorVistaMarca();

    public FrmModelo getForm() {
        return form;
    }

    public void setForm(FrmModelo form) {
        this.form = form;
    }

    public Modelo getModel() {
        return model;
    }

    public void setModel(Modelo model) {
        this.model = model;
    }

    public GestorVistaMarca getGestorMarca() {
        return gestorMarca;
    }

    public void setGestorMarca(GestorVistaMarca gestorMarca) {
        this.gestorMarca = gestorMarca;
    }

    @Override
    public void newModel() {
        this.setModel(new Modelo());
        this.setModoNuevo();
    }

    public void setModelMarca(JComboBox cmb) {
        cmb.setModel(getComboModelMarca());
    }

    public DefaultComboBoxModel getComboModelMarca() {
        return this.getGestorMarca().getComboModelMarca();
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
//           this..setItems(this.getForm().getTbl());
        }
        if (this.getOpcABM()==2) {
            this.getModelCombo().addElement(this.getModel());
            this.getModelCombo().setSelectedItem(this.getModel());
            this.getForm().dispose(); 
        }

    }

    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setNombre(this.getForm().getTxtNombre().getText());
            this.getModel().setMarca((Marca) this.getForm().getCmbMarca().getModel().getSelectedItem());

            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtNombre())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el nombre del modelo.");
            this.getForm().getTxtNombre().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getCmbMarca())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca.");
            this.getForm().getCmbMarca().grabFocus();
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

    public void guardarObjeto() {
        this.newCodigo();
        this.guardarObjeto(this.getModel());
    }

    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    public void eliminar() {
        this.eliminarObjeto(this.getModel());
    }

    @Override
    public void deleteView() {

        this.eliminar();
        this.getForm().viewEliminar();
    }

    public int getUltimoCodigo() {
        try {
            Marca auxModel = (Marca) this.listarUltimo(Marca.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

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
        this.setOpcABM(2);
    }
    
    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla, JComboBox<String> marca, Marca marcaSelect) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmModelo(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
        this.getForm().setCmbMarca(marca);
        this.getForm().getCmbMarca().setSelectedItem(marcaSelect);
        
    }

    public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo = {"", "Cód.", "Marca", "Modelo"};
        String[] ancho = {"0", "43", "140", "140"};
        this.newModelTable(tbl, titulo, ancho);
    }

    public void setBusqueda() {
        Boolean error = false;
        this.initializeTablaBusqueda(this.getForm().getTblDatos());

        if (!error) {

            this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel) this.getForm().getTblDatos().getModel(), this.getOrdenamiento(), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la búsqueda", "Validación de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private int getOrdenamiento() {
        int ord = 0;

        return ord;
    }

    public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) {
        //TreeSet<Modelo> lista= new TreeSet();
        List<Modelo> list = this.listar(text, ordenamiento);
        Modelo auxModel;
        /*Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Modelo) it.next(); 
            lista.add(auxModel);
         }*/

        Iterator it2 = (Iterator) list.iterator();
        while (it2.hasNext()) {
            auxModel = (Modelo) it2.next();
            Object[] fila = {auxModel, auxModel.getCodigo(), auxModel.getMarca().getNombre(), auxModel.getNombre()};
            auxModelTabla.addRow(fila);
        }
        return auxModelTabla;
    }

    public List<Modelo> listar(String text, int ord) {
        Criteria crit = getSession().createCriteria(Modelo.class);
        crit.add(Restrictions.ilike("nombre", '%' + text.toUpperCase() + '%'));
        return crit.list();
    }

    public void setDatos() {
        if (this.getOpcABM() == 1) {
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?", "Modificar Producto", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                    this.setModel((Modelo) this.getItemTablaSelected(this.getForm().getTblDatos()));
                    this.getForm().clearView();
                    this.getForm().viewActualizar();
                }
            }
        } else {
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Modelo) this.getItemTablaSelected(this.getForm().getTblDatos()));
                this.getForm().clearView();
                this.getForm().viewActualizar();
            }
        }
    }

    public Object getItemTablaSelected(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        return model.getValueAt(tbl.getSelectedRow(), 0);
    }

    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getCmbMarca().setSelectedItem(this.getModel().getMarca());
    }
    
    public DefaultComboBoxModel getComboModelModelo() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Modelo auxTipo : this.listarModelo()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    public List <Modelo> listarModelo(){   
        return this.listarClase(Modelo.class,"nombre");
    }
    
    public DefaultComboBoxModel getComboModelModelo(Marca marca) {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Modelo auxTipo : this.listarModelo(marca)) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    public List <Modelo> listarModelo(Marca marca){   
        return this.listarClase(Modelo.class,"nombre",marca);
    }
    
    public List<Modelo> listarClase(Class clase,String atributoOrden, Marca marca){
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc(atributoOrden))
                        .add (Restrictions.eq("marca",marca));
        return crit.list();
    }
}
