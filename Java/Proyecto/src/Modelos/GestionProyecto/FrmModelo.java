package Modelos.GestionProyecto;
import Vistas.FrmGenerica;
import javax.swing.*;

public class FrmModelo extends FrmGenerica {
    private GestorVistaModelo gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaModelo getGestorVista() {
        return gestorVista;
    }
    
    public void setGestorVista(GestorVistaModelo gestorVista) {
        this.gestorVista = gestorVista;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

    public JTextField getTxtBusquedaDenominacion() {
        return txtBusquedaNombre;
    }

    public void setTxtBusquedaDenominacion(JTextField txtBusquedaDenominacion) {
        this.txtBusquedaNombre = txtBusquedaDenominacion;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtDenominacion) {
        this.txtNombre = txtDenominacion;
    }
    
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JComboBox<String> getCmbMarca() {
        return cmbMarca;
    }

    public void setCmbMarca(JComboBox<String> cmbMarca) {
        this.cmbMarca = cmbMarca;
    }
    
    

// Constructores del formulario 
    public FrmModelo(GestorVistaModelo gestorVista) {
        try{
           initComponents();
           }
        catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmModelo() {
        initComponents();
    }
    
      // Metodos que gestionan los botones de la barra comando 
    public void viewOpenedBotones() {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones(){
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
    }
  
    public void viewEliminarBotones() {
        this.viewOpenedBotones();
    }
  
    public void viewGuardarBotones() {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        
        
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnNuevo.grabFocus();
    }

    public void viewBuscarBotones() {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    } 
    
    public void viewBuscar() {
        btnNuevo.setEnabled(true); 
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
     
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    @Override
    public void onViewOpened() {
        this.viewOpenedBotones();
        this.viewOpenedBotones();
        this.viewCamposEnabled(false);
        this.cargarCombos();
        this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
        this.isExtra();
     }
    
    @Override
    public void cargarCombos() {
        this.gestorVista.setModelMarca(cmbMarca);
    }

    @Override
    public void viewCamposEnabled(Boolean tipo) {
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(tipo);
        cmbMarca.setEnabled(tipo);
    }

    private void viewBasic(){
        this.viewNuevoEditarBotones();
        this.viewCamposEnabled(true);
    }

    @Override
    public void viewNuevoEnter( ) {
        this.viewBasic();
        this.viewNueva();
    }

    @Override
    public void viewEditarEnter( ) {
        this.viewBasic();
        txtNombre.grabFocus();
        this.getGestorVista().setModoEditar();
    }

    private void viewBuscarPrincipalEnter() {
        this.viewCamposEnabled(false);
        this.clearView();
        this.viewBuscar();
    }

    private void viewBuscarCodigoEnter() {
        this.viewBuscarPrincipalEnter();
        txtCodigo.setEnabled(true);
        txtCodigo.grabFocus();
    }

    private void viewBuscarComboEnter() {
        this.viewBuscarPrincipalEnter();
        txtCodigo.setEnabled(false);
    }

    @Override
    public void viewGuardar() {
        this.viewGuardarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
    }

    @Override
    public void viewEliminar() {
        this.viewEliminarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
        this.clearView();
    }

    public void viewActualizar() {
        this.setView();
        this.viewCamposEnabled(false);
        this.viewBuscarBotones();
    }

    private void viewNueva(){
        this.clearView();
        this.getGestorVista().newModel();
        txtNombre.grabFocus();
    }

    @Override
    public void clearView() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
    }

    @Override
    public void grabFocus(){
        txtNombre.grabFocus();
    }

   @Override
    public void cancelarView() {
        this.getGestorVista().cancelarView();
        this.onViewOpened();
        this.clearView();
    }

    @Override
    public void deleteView() {
         this.getGestorVista().deleteView();
    }

    @Override
    public void saveView(){
        this.getGestorVista().saveView();
    }

    @Override
    public void setView(){
       this.getGestorVista().getView();
    }  

    public void extraView() {
        btnBuscar.setEnabled(false);
        this.viewNuevoEnter();
    }
 
    private void isExtra() {
        if (this.getGestorVista().isExtra()) {
            this.extraView();
        }
    }
       
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbMarca = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Modelo");
        setToolTipText("Modelo");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jLabel1.setRequestFocusEnabled(false);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 70, 90, 20);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(480, 90, 40, 30);

        txtNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombre);
        txtNombre.setBounds(20, 90, 460, 25);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("Código");
        jLabel3.setRequestFocusEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 90, 19);

        txtCodigo.setBackground(new java.awt.Color(204, 255, 204));
        txtCodigo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setToolTipText("Ingrese Código");
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(20, 40, 90, 25);

        btnBuscarCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnBuscarCodigo.setToolTipText("Buscar Tipo Servicio por código");
        btnBuscarCodigo.setBorderPainted(false);
        btnBuscarCodigo.setContentAreaFilled(false);
        btnBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoActionPerformed(evt);
            }
        });
        btnBuscarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarCodigoKeyPressed(evt);
            }
        });
        jPanel1.add(btnBuscarCodigo);
        btnBuscarCodigo.setBounds(110, 40, 30, 30);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Marca");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 120, 120, 19);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel2.add(btnNuevo);
        btnNuevo.setBounds(10, 10, 75, 23);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(170, 10, 75, 23);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel2.add(btnEliminar);
        btnEliminar.setBounds(250, 10, 75, 23);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEditar.setMaximumSize(new java.awt.Dimension(61, 21));
        btnEditar.setMinimumSize(new java.awt.Dimension(61, 21));
        btnEditar.setPreferredSize(new java.awt.Dimension(61, 21));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
            }
        });
        jPanel2.add(btnEditar);
        btnEditar.setBounds(90, 10, 75, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 380, 340, 40);

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
        btnSalir.setBounds(100, 10, 75, 21);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnCancelar.setMaximumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setMinimumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setPreferredSize(new java.awt.Dimension(61, 21));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(10, 10, 75, 23);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(500, 380, 180, 40);

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jPanel1.add(cmbMarca);
        cmbMarca.setBounds(20, 140, 310, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(390, 10, 740, 440);

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
        jScrollPane2.setBounds(20, 90, 340, 280);

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar1.setToolTipText("Buscar Tipo Servicio por denominación");
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
        btnBuscar1.setBounds(260, 50, 80, 30);

        btnImprimir1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrinterChica.png"))); // NOI18N
        btnImprimir1.setText("Imprir");
        btnImprimir1.setToolTipText("Impreme el documento");
        btnImprimir1.setBorderPainted(false);
        btnImprimir1.setContentAreaFilled(false);
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnImprimir1);
        btnImprimir1.setBounds(250, 380, 110, 40);

        txtBusquedaNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtBusquedaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtBusquedaNombre);
        txtBusquedaNombre.setBounds(20, 50, 240, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Modelos");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 20, 190, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 10, 380, 430);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 1129, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.viewBuscarComboEnter();
}//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if (evt.getKeyCode()==10) {
            this.viewBuscarComboEnter();
        }
}//GEN-LAST:event_btnBuscarKeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode()==10) {
            if (this.gestorVista.getModelXCodigo(txtCodigo.getText())) {
                this.viewActualizar();
            }
            else {
                JOptionPane.showMessageDialog(null,"Código no existe");
            }
        }
}//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

}//GEN-LAST:event_txtCodigoKeyTyped

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        this.viewBuscarCodigoEnter();
}//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void btnBuscarCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarCodigoKeyPressed
        if(evt.getKeyCode()==10) {
            this.viewBuscarCodigoEnter();
        }
}//GEN-LAST:event_btnBuscarCodigoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
       if (evt.getKeyCode()==10)
          this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
        if (evt.getKeyCode()==10)
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode()==10)
        this.saveView();
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
           this.deleteView();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
            this.deleteView();
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVista().isNuevo() || this.getGestorVista().isOnlyRead())
        this.dispose();
        else
        n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
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
            n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
            if  (n == 1 ){
                this.cancelarView();
                this.dispose();}
        }

    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
        this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
            this.cancelarView();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
         this.clearView();
        this.setBusqueda();
        this.viewCamposEnabled(false);
//        botonesComandoView.viewAllDisabled();
//        botonesComandoView.viewOpenedBotones();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1KeyPressed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
             this.getGestorVista().setDatos();
    }//GEN-LAST:event_tblDatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarCodigo;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir1;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
