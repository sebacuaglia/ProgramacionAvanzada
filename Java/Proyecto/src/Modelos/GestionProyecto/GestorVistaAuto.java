/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sebac
 */
public class GestorVistaAuto extends GestorVista {

    private FrmAuto form;
    private Auto model;
    private GestorVistaMarca gestorMarca = new GestorVistaMarca();
    private GestorVistaModelo gestorModelo = new GestorVistaModelo();

    public FrmAuto getForm() {
        return form;
    }

    public void setForm(FrmAuto form) {
        this.form = form;
    }

    public Auto getModel() {
        return model;
    }

    public void setModel(Auto model) {
        this.model = model;
    }

    public GestorVistaMarca getGestorMarca() {
        return gestorMarca;
    }

    public void setGestorPais(GestorVistaMarca gestorMarca) {
        this.gestorMarca = gestorMarca;
    }

    public GestorVistaModelo getGestorModelo() {
        return gestorModelo;
    }

    public void setGestorModelo(GestorVistaModelo gestorModelo) {
        this.gestorModelo = gestorModelo;
    }

    @Override
    public void newModel() {
        this.setModel(new Auto());
        this.setModoNuevo();
    }

    public void setModelMarca(JComboBox cmb) {
        cmb.setModel(getComboModelMarca());
    }

    public void setModelModelo(JComboBox cmb) {
        cmb.setModel(getComboModelModelo((Marca) this.getForm().getCmbMarca().getModel().getSelectedItem()));
    }

    public DefaultComboBoxModel getComboModelMarca() {
        return this.getGestorMarca().getComboModelMarca();
    }

    public DefaultComboBoxModel getComboModelModelo(Marca marca) {

        return this.getGestorModelo().getComboModelModelo(marca);

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
            this.getModel().setModelo((Modelo) this.getForm().getCmbModelo().getModel().getSelectedItem());
            this.getModel().setColor(this.getForm().getTxtColor().getText());
            this.getModel().setPrecio(this.getForm().getTxtPrecio().getText());
            this.getModel().setCosto(this.getForm().getTxtCosto().getText());
            if (this.getForm().getCheckBoxUsado().isSelected()) {
                this.getModel().setUsado(this.getForm().getCheckBoxUsado().isSelected());
                this.getModel().setMatricula(this.getForm().getTxtMatricula().getText());
                this.getModel().setAnio(this.getForm().getTxtAnio().getText());

                this.getModel().setKilometro(this.getForm().getTxtKilometraje().getText());
            }

            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getCmbMarca())) {
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
        }

        if (this.isEmpty(this.getForm().getTxtPrecio()) /*&& this.getForm().getTxtPrecio().getText().matches("[0-9]+")*/ ) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el precio de venta.");
            this.getForm().getTxtPrecio().grabFocus();
            return false;
        }
        
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
        this.getModel().setHabilitado(true);
        this.guardarObjeto(this.getModel());
    }

    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    public void eliminar() {
        //solo deshabilitamos
        this.getModel().setHabilitado(false);
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
        this.setForm(new FrmAuto(this, gestorMarca, gestorModelo));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmAuto(this, gestorMarca, gestorModelo));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }

    void openFormularioMarca(DefaultComboBoxModel model) {
        GestorVistaMarca gestorVistaMarca = new GestorVistaMarca();
        gestorVistaMarca.openFormulario(model, this.getEscritorio());

    }

    void openFormularioModelo(DefaultComboBoxModel model) {
        GestorVistaModelo gestorVistaModelo = new GestorVistaModelo();
        gestorVistaModelo.openFormulario(model, this.getEscritorio());
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
        //TreeSet<Marca> lista= new TreeSet();
        List<Auto> list = this.listar(text, ordenamiento);
        Auto auxModel;
        /*Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Marca) it.next(); 
            lista.add(auxModel);
         }*/

        Iterator it2 = (Iterator) list.iterator();
        while (it2.hasNext()) {
            auxModel = (Auto) it2.next();
            Object[] fila = {auxModel,
                auxModel.getCodigo(), 
                auxModel.getModelo().getMarca().getNombre(),
                auxModel.getModelo().getNombre(),
                auxModel.getPrecio()};
            auxModelTabla.addRow(fila);
        }
        return auxModelTabla;
    }

    public List<Auto> listar(String text, int ord) {
        Criteria crit = getSession().createCriteria(Auto.class);
        crit.add(Restrictions.eq("habilitado", true));
        return crit.list();
    }

    public void setDatos() {
        if (this.getOpcABM() == 1) {
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?", "Modificar Producto", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                    this.setModel((Auto) this.getItemTablaSelected(this.getForm().getTblDatos()));
                    this.getForm().clearView();
                    this.getForm().viewActualizar();
                }
            }
        } else {
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Auto) this.getItemTablaSelected(this.getForm().getTblDatos()));
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
        //this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        //this.getForm().getCmbPais().setSelectedItem(this.getModel().getPais());
        this.getForm().getCmbMarca().setSelectedItem(this.getModel().getModelo().getMarca());
        this.getForm().getCmbModelo().setSelectedItem(this.getModel().getModelo());

        this.getForm().getTxtColor().setText(this.getModel().getColor());
        this.getForm().getTxtPrecio().setText(this.getModel().getPrecio());
        this.getForm().getTxtCosto().setText(this.getModel().getCosto());

        if (this.getModel().isUsado()) {
            this.getForm().getCheckBoxUsado().setSelected(this.getModel().isUsado());
            this.getForm().getTxtMatricula().setText(this.getModel().getMatricula());
            this.getForm().getTxtAnio().setText(this.getModel().getAnio());
            this.getForm().getTxtKilometraje().setText(this.getModel().getKilometro());
        }

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
    
    public void keyPressedNotNumber(){
        String txt = form.getTxtCosto().getText();
        String txtValida = txt.substring(0,txt.length()-1);
        form.getTxtCosto().setText(txtValida);
    }
    
    
    
    
}
