/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.jdesktop.swingx.JXComboBox;

/**
 *
 * @author sebac
 */
public class GestorVistaVentaPorVendedor extends GestorVista {

    private FrmVentasPorVendedor form;
    private Venta model;
    private TableRowSorter sorter;
    private GestorVistaPersonal gestorVistaPersonal = new GestorVistaPersonal();

    public FrmVentasPorVendedor getForm() {
        return form;
    }

    public void setForm(FrmVentasPorVendedor form) {
        this.form = form;
    }

    public Venta getModel() {
        return model;
    }

    public void setModel(Venta model) {
        this.model = model;
    }

    public GestorVistaPersonal getGestorVistaPersonal() {
        return gestorVistaPersonal;
    }

    public void setGestorVistaPersonal(GestorVistaPersonal gestorVistaPersonal) {
        this.gestorVistaPersonal = gestorVistaPersonal;
    }

    public void setModelPersonal(JComboBox cmb) {
        cmb.setModel(getComboModelPersonal());
    }

    public DefaultComboBoxModel getComboModelPersonal() {
        return this.getGestorVistaPersonal().getComboModelPersonal();
    }

    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmVentasPorVendedor(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        
    }

    public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo = {"Fecha", "Auto", "monto"};
        String[] ancho = {"140", "140", "140"};
        this.newModelTable(tbl, titulo, ancho);
    }

    private int getOrdenamiento() {
        int ord = 0;

        return ord;
    }

    public void setBusqueda() {
        Boolean error = false;
        this.initializeTablaBusqueda(this.getForm().getTblDatos());

        if (!error) {
            this.listarDatos((DefaultTableModel) this.getForm().getTblDatos().getModel(), this.getOrdenamiento(), "");
            //this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel) this.getForm().getTblDatos().getModel(), this.getOrdenamiento(), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la b?squeda", "Validaci?n de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) {
        //TreeSet<Marca> lista= new TreeSet();

        isDatosValidos();

        Date desde = this.getForm().getTxtFechaDesde().getDate();
        Date hasta = this.getForm().getTxtFechaHasta().getDate();
        List<Object[]> list = this.listar(text, ordenamiento, desde, hasta, (Personal) this.getForm().getCmbPersonal().getSelectedItem());
        Object[] auxModel;

        Iterator it2 = (Iterator) list.iterator();

        while (it2.hasNext()) {
            auxModel = (Object[]) it2.next();

            Object[] fila = {auxModel[0], auxModel[1], auxModel[2]};
            auxModelTabla.addRow(fila);
        }
        /*HashMap<Auto, HashMap<String, Integer>> valoresInforme = new HashMap<Auto, HashMap<String, Integer>>();
        while (it2.hasNext() && valoresInforme.size()<=10) {
            auxModel = (Venta) it2.next();
            DetalleVenta auxModelDetalle;
            Iterator itDetalle = (Iterator) listarDetalleVenta("venta", auxModel.getId()).iterator();
            while (itDetalle.hasNext()) {
                auxModelDetalle = (DetalleVenta) itDetalle.next();

                if (valoresInforme.containsKey(auxModelDetalle.getAuto())) {
                    HashMap<String, Integer> valores = valoresInforme.get(auxModelDetalle.getAuto());
                    int cantidad = auxModelDetalle.getCantidad();
                    int montoTotal = auxModelDetalle.getPrecioAuto() * cantidad;
                    valores.put("cantidad", cantidad + valores.get("cantidad"));
                    valores.put("monto", montoTotal + valores.get("monto"));

                    valoresInforme.put(auxModelDetalle.getAuto(), valores);
                } else {
                    int cantidad = auxModelDetalle.getCantidad();
                    int montoTotal = auxModelDetalle.getPrecioAuto() * cantidad;
                    HashMap<String, Integer> valores = new HashMap<String, Integer>();
                    valores.put("cantidad", cantidad);
                    valores.put("monto", montoTotal);
                    valoresInforme.put(auxModelDetalle.getAuto(), valores);
                }

            }
        }

        for (Map.Entry<Auto, HashMap<String, Integer>> entry : valoresInforme.entrySet()) {
            Auto key = entry.getKey();
            HashMap<String, Integer> val = entry.getValue();
            String nombre = key.getModelo().getMarca().getNombre() + " " + key.getModelo().getNombre();
            Object[] fila = {nombre, val.get("monto"), val.get("cantidad")};
            auxModelTabla.addRow(fila);
        }
         */
        //ordenamiento
        JTable table = this.getForm().getTblDatos();
        table.setModel(auxModelTabla);

        //return auxModelTabla;
    }

    //lista las ventas realizadas entre 2 fechas
    public List<Object[]> listar(String text, int ord, Date desde, Date hasta, Personal personal) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");

        List<Object[]> lista = getSession().createNativeQuery(
                "       select v.fecha,ma.nombre||' '||mo.nombre as nombre,(d.precioauto*((100+d.porcImpuesto)/100)) as precio from detalleVenta d \n"
                + "           inner join venta v on v.id=d.venta_id\n"
                + "           inner join auto a on a.id=d.auto_id\n"
                + "           inner join modelo mo on mo.id=a.modelo_id\n"
                + "           inner join marca ma on ma.id=mo.marca_id\n"
                + "               where v.fecha between '" + DateFor.format(desde) + "' and '" + DateFor.format(hasta) + "' "
                + "                   and v.personal_id = " + personal.getId()
                + "           order by v.fecha desc\n"
                + "           limit 10 ").getResultList();

        return lista;

        /*Criteria crit = getSession().createCriteria(DetalleVenta.class);
        crit.add(Restrictions.between("venta.fecha", desde, hasta));
        crit.setProjection(Projections.projectionList()
                .add(Projections.sum("cantidad").as("cantidad"))
                .add(Projections.sum("precioAuto").as("monto"))
                .add(Projections.sum(text))
        );
        return crit.list();*/
    }

    //lista las ventas realizadas entre 2 fechas
    /*public List<DetalleVenta> listarDetalleVenta(String text, long ventaId) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Venta> criteriaVenta = cb.createQuery(Venta.class);
        Root<Aprobacion_solicitud> member = criteria.from(Aprobacion_solicitud.class);
        criteria.select(member);
        criteria.multiselect(member.get("idaprobsum"), cb.sum(c.get("cantidad")));
        return em.createQuery(criteria).getSingleResult();
 }
    
    
        Criteria crit = getSession().createCriteria(DetalleVenta.class);
        crit.add(Restrictions.eq("venta.id", ventaId));
        return crit.list();
    }*/
    @Override
    public boolean isDatosValidos() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        
        if (this.getForm().getTxtFechaDesde().getDate()==null) {
            JOptionPane.showMessageDialog(null, "Falta ingresar fecha desde.");
            this.getForm().getTxtFechaDesde().grabFocus();
            return false;
        }
        if (this.getForm().getTxtFechaHasta().getDate()==null) {
            JOptionPane.showMessageDialog(null, "Falta ingresar fecha hasta.");
            this.getForm().getTxtFechaHasta().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtFechaHasta())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar fecha hasta.");
            this.getForm().getTxtFechaHasta().grabFocus();
            return false;
        }

        return true;
    }

}
