package Modelos.GestionProyecto;
import Vistas.FrmGenerica;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

public class FrmTop10VentasModelo extends FrmGenerica {
    private GestorVistaTop10VentasModelo gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaTop10VentasModelo getGestorVista() {
        return gestorVista;
    }
    
    public void setGestorVista(GestorVistaTop10VentasModelo gestorVista) {
        this.gestorVista = gestorVista;
    }

    // Definicion de getter y setter de los componentes visuales del formulario
    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

    public JDateChooser getTxtFechaDesde() {
        return txtFechaDesde;
    }

    public void setTxtFechaDesde(JDateChooser txtFechaDesde) {
        this.txtFechaDesde = txtFechaDesde;
    }

    public JDateChooser getTxtFechaHasta() {
        return txtFechaHasta;
    }

    public void setTxtFechaHasta(JDateChooser txtFechaHasta) {
        this.txtFechaHasta = txtFechaHasta;
    }


    
    

// Constructores del formulario 
    public FrmTop10VentasModelo(GestorVistaTop10VentasModelo gestorVista) {
        try{
            initComponents();
        }
        catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmTop10VentasModelo() {
        initComponents();
    }
    
    @Override
    public void onViewOpened() {
        
        this.getGestorVista().initializeTablaBusqueda(tblDatos);
        

    }
    
    @Override
    public void viewCamposEnabled(Boolean tipo) {
        tblDatos.setEnabled(tipo);
    }
    
      
    
    //llenado de tablas
    public void setBusqueda() {
        this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
        this.getGestorVista().setBusqueda();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        txtFechaHasta = new com.toedter.calendar.JDateChooser();
        txtFechaDesde = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Top 10 Ventas por Modelo");
        setToolTipText("Top 10 Ventas por Modelo");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel4.setLayout(null);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatos);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(50, 90, 770, 280);

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar1.setToolTipText("Buscar Tipo Servicio por denominaci�n");
        btnBuscar1.setBorderPainted(false);
        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        btnBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscar1KeyPressed(evt);
            }
        });
        jPanel4.add(btnBuscar1);
        btnBuscar1.setBounds(470, 30, 50, 40);

        jLabel5.setText("Desde");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(130, 20, 40, 16);

        jLabel6.setText("Hasta");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(340, 20, 50, 16);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        jPanel3.add(btnSalir);
        btnSalir.setBounds(10, 10, 75, 21);

        jPanel4.add(jPanel3);
        jPanel3.setBounds(760, 380, 100, 40);
        jPanel4.add(txtFechaHasta);
        txtFechaHasta.setBounds(260, 40, 200, 22);
        jPanel4.add(txtFechaDesde);
        txtFechaDesde.setBounds(50, 40, 200, 22);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 880, 430);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 890, 464);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        this.setBusqueda();
        this.viewCamposEnabled(false);
//        botonesComandoView.viewAllDisabled();
//        botonesComandoView.viewOpenedBotones();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1KeyPressed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
             
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVista().isNuevo() || this.getGestorVista().isOnlyRead())
        this.dispose();
        else
        n=JOptionPane.showConfirmDialog(null, "�Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
        if  (n == 1 ){
            this.cancelarView();
            this.dispose();}
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        if(evt.getKeyCode()==10) {
            int n = 0;
            if (this.getGestorVista().isNuevo())
            this.dispose();
            else
            n=JOptionPane.showConfirmDialog(null, "�Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
            if  (n == 1 ){
                this.cancelarView();
                this.dispose();}
        }
    }//GEN-LAST:event_btnSalirKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private com.toedter.calendar.JDateChooser txtFechaDesde;
    private com.toedter.calendar.JDateChooser txtFechaHasta;
    // End of variables declaration//GEN-END:variables

}
