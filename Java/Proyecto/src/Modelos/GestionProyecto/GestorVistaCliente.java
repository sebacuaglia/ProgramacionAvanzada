/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.text.NumberFormat;
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
import javax.swing.*;

/**
 *
 * @author sebac
 */
public class GestorVistaCliente extends GestorVista {

    private FrmCliente form;
    private Cliente model;

    public FrmCliente getForm() {
        return form;
    }

    public void setForm(FrmCliente form) {
        this.form = form;
    }

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }

    @Override
    public void newModel() {
        this.setModel(new Cliente());
        this.setModoNuevo();
    }

    @Override
    public void saveView() {
        int err;

        err = this.setModel();
        System.out.print(err);
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
            this.getModel().setApellido(this.getForm().getTxtApellido().getText());
            this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
            this.getModel().setEmail(this.getForm().getTxtEmail().getText());
            this.getModel().setRazon(this.getForm().getTxtRazon().getText());
            this.getModel().setFechaNacimiento(this.getForm().getTxtFechaNacimiento().getDate());
            this.getModel().setDni(this.getForm().getTxtDni().getText());
            this.getModel().setTelefono(this.getForm().getTxtTelefono().getText());
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtNombre())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el nombre del cliente.");
            this.getForm().getTxtNombre().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtApellido())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el apellido del cliente.");
            this.getForm().getTxtApellido().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtTelefono())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el telefono del cliente.");
            this.getForm().getTxtTelefono().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtDni())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el DNI del cliente.");
            this.getForm().getTxtDni().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getTxtDireccion())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la direccion del cliente.");
            this.getForm().getTxtDireccion().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtEmail())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Email del cliente.");
            this.getForm().getTxtEmail().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtRazon())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la razon social del cliente.");
            this.getForm().getTxtRazon().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtFechaNacimiento())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la razon social del cliente.");
            this.getForm().getTxtFechaNacimiento().grabFocus();
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
                /*this.eliminar();
                break;
                 */
                this.guardarObjeto();
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
        this.setForm(new FrmCliente(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmCliente(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }

    public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo = {"", "Cód.", "Nombre", "Apellido"};
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
        //TreeSet<Marca> lista= new TreeSet();
        List<Cliente> list = this.listar(text, ordenamiento);
        Cliente auxModel;
        /*Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Marca) it.next(); 
            lista.add(auxModel);
         }*/

        Iterator it2 = (Iterator) list.iterator();
        while (it2.hasNext()) {
            auxModel = (Cliente) it2.next();
            Object[] fila = {auxModel, auxModel.getCodigo(), auxModel.getNombre(), auxModel.getApellido()};
            auxModelTabla.addRow(fila);
        }
        return auxModelTabla;
    }

    public List<Cliente> listar(String text, int ord) {
        Criteria crit = getSession().createCriteria(Cliente.class);
        crit.add(Restrictions.ilike("nombre", '%' + text.toUpperCase() + '%'));
        return crit.list();
    }

    public void setDatos() {
        if (this.getOpcABM() == 1) {
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?", "Modificar Producto", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                    this.setModel((Cliente) this.getItemTablaSelected(this.getForm().getTblDatos()));
                    this.getForm().clearView();
                    this.getForm().viewActualizar();
                }
            }
        } else {
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Cliente) this.getItemTablaSelected(this.getForm().getTblDatos()));
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
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getTxtApellido().setText(this.getModel().getApellido());
        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());
        this.getForm().getTxtTelefono().setText(this.getModel().getTelefono() + "");
        this.getForm().getTxtDni().setText(formatoNumero.format(Integer.parseInt(this.getModel().getDni())));
        this.getForm().getTxtRazon().setText(this.getModel().getRazon());
        this.getForm().getTxtFechaNacimiento().setDate(this.getModel().getFechaNacimiento());
        this.getForm().getTxtEmail().setText(this.getModel().getEmail());
    }

    public DefaultComboBoxModel getComboModelCliente() {
        DefaultComboBoxModel auxModel = new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Cliente auxTipo : this.listarClientes()) {
            auxModel.addElement(auxTipo);
        }
        return auxModel;
    }

    public List<Cliente> listarClientes() {
        return this.listarClase(Cliente.class, "nombre");
    }

}
