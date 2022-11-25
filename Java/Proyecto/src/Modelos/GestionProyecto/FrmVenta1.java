package Modelos.GestionProyecto;

import Vistas.FrmGenerica;
import javax.swing.*;

public class FrmVenta1 extends FrmGenerica {

    private GestorVistaVenta gestorVistaVenta;
    private GestorVistaCliente gestorVistaCliente;
    private GestorVistaPersonal gestorVistaPersonal;
    private GestorVistaAuto gestorVistaAuto;
    private int YES_NO_OPTION;

    public GestorVistaAuto getGestorVistaAuto() {
        return gestorVistaAuto;
    }

    public void setGestorVistaAuto(GestorVistaAuto gestorVistaAuto) {
        this.gestorVistaAuto = gestorVistaAuto;
    }

    public GestorVistaVenta getGestorVistaVenta() {
        return gestorVistaVenta;
    }

    public void setGestorVistaVenta(GestorVistaVenta gestorVistaVenta) {
        this.gestorVistaVenta = gestorVistaVenta;
    }

    public GestorVistaCliente getGestorVistaCliente() {
        return gestorVistaCliente;
    }

    public void setGestorVistaCliente(GestorVistaCliente gestorVistaCliente) {
        this.gestorVistaCliente = gestorVistaCliente;
    }

    public GestorVistaPersonal getGestorVistaPersonal() {
        return gestorVistaPersonal;
    }

    public void setGestorVistaPersonal(GestorVistaPersonal gestorVistaPersonal) {
        this.gestorVistaPersonal = gestorVistaPersonal;
    }

    public JTable getTblDatosAutos() {
        return tblDatosAutos;
    }

    public void setTblDatosAutos(JTable tblDatos) {
        this.tblDatosAutos = tblDatos;
    }

    public JTextField getTxtBusquedaDenominacion() {
        return txtBusquedaNombre;
    }

    public void setTxtBusquedaDenominacion(JTextField txtBusquedaDenominacion) {
        this.txtBusquedaNombre = txtBusquedaDenominacion;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JComboBox<String> getCmbMarca() {
        return cmbCliente;
    }

    public void setCmbMarca(JComboBox<String> cmbMarca) {
        this.cmbCliente = cmbMarca;
    }

    public JComboBox<String> getCmbModelo() {
        return cmbPersonal;
    }

    public void setCmbModelo(JComboBox<String> cmbModelo) {
        this.cmbPersonal = cmbModelo;
    }

    public JTextField getTxtPais() {
        return txtMarca;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtMarca = txtPais;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtPrecio() {
        return txtSubtotal;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtSubtotal = txtPrecio;
    }

    public JButton getBtnBuscar1() {
        return btnBuscarAutosVenta;
    }

    public void setBtnBuscar1(JButton btnBuscar1) {
        this.btnBuscarAutosVenta = btnBuscar1;
    }

    public JTable getTblDatosDetalleVenta() {
        return tblDatosDetalleVenta;
    }

    public void setTblDatosDetalleVenta(JTable tblDatosDetalleVenta) {
        this.tblDatosDetalleVenta = tblDatosDetalleVenta;
    }
    public JTextField getTxtImpuestos() {
        return txtImpuestos;
    }

    public void setTxtImpuestos(JTextField txtImpuestos) {
        this.txtImpuestos = txtImpuestos;
    }

    public JTextField getTxtSubtotal() {
        return txtSubtotal;
    }

    public void setTxtSubtotal(JTextField txtSubtotal) {
        this.txtSubtotal = txtSubtotal;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    public JTable getTblVentas() {
        return tblVentas;
    }

    public void setTblVentas(JTable tblVentas) {
        this.tblVentas = tblVentas;
    }

// Constructores del formulario 
    public FrmVenta1(GestorVistaVenta gestorVista) {
        try {
            initComponents();
        } catch (Exception e) {

        }
        this.setGestorVistaVenta(gestorVista);
        this.onViewOpened();
    }

    public FrmVenta1(GestorVistaVenta gestorVistaVenta, GestorVistaCliente gestorVistaCliente,
            GestorVistaPersonal gestorVistaPersonal, GestorVistaAuto gestorVistaAuto) {
        try {
            initComponents();
        } catch (Exception e) {

        }
        this.setGestorVistaVenta(gestorVistaVenta);
        this.setGestorVistaCliente(gestorVistaCliente);
        this.setGestorVistaPersonal(gestorVistaPersonal);
        this.setGestorVistaAuto(gestorVistaAuto);
        
        this.onViewOpened();
    }

    public FrmVenta1() {
        initComponents();
        this.onViewOpened();

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

    public void viewNuevoEditarBotones() {
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

    private void viewDenominacionVisible(Boolean tipo) {
        txtMarca.setVisible(!tipo);
        cmbCliente.setVisible(tipo);
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
        this.getGestorVistaVenta().initializeTablaBusqueda(this.getTblDatosAutos());
        this.getGestorVistaVenta().initializeTabladetalle(this.getTblDatosDetalleVenta());
        this.getGestorVistaVenta().initializeTablaventa(this.getTblVentas());
        this.isExtra();

    }

    @Override
    public void cargarCombos() {
        this.gestorVistaVenta.setModelCliente(cmbCliente);
        this.gestorVistaVenta.setModelPersonal(cmbPersonal);
        cmbCliente.setSelectedItem("");
        cmbPersonal.setSelectedItem("");
        tblDatosDetalleVenta.enable();
        

    }

    @Override
    public void viewCamposEnabled(Boolean tipo) {
        txtCodigo.setEnabled(false);
        cmbCliente.setEnabled(tipo);
        btnAgregarCliente.setEnabled(tipo);
        txtMarca.setEnabled(false);
        cmbPersonal.setEnabled(tipo);
        txtModelo.setEnabled(false);
        txtSubtotal.setEnabled(tipo);
        tblDatosDetalleVenta.setEnabled(true);

    }

    

    private void viewBasic() {
        this.viewNuevoEditarBotones();
        this.viewCamposEnabled(true);
    }

    @Override
    public void viewNuevoEnter() {
        this.viewBasic();
        this.viewNueva();
    }

    @Override
    public void viewEditarEnter() {
        this.viewBasic();

        cmbCliente.grabFocus();
        this.getGestorVistaAuto().setModoEditar();
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

    private void viewNueva() {
        this.clearView();
        this.getGestorVistaAuto().newModel();
        //txtNombre.grabFocus();
        cmbCliente.grabFocus();
    }

    @Override
    public void clearView() {
        txtCodigo.setText("");
        txtMarca.setText("");
        cmbCliente.setSelectedItem(null);
        cmbPersonal.setSelectedItem(null);
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtImpuestos.setText("");
    }

    @Override
    public void grabFocus() {
        cmbCliente.grabFocus();
    }

    @Override
    public void cancelarView() {
        this.getGestorVistaAuto().cancelarView();
        this.onViewOpened();
        this.clearView();
    }

    @Override
    public void deleteView() {
        this.getGestorVistaAuto().deleteView();
    }

    @Override
    public void saveView() {
        this.getGestorVistaAuto().saveView();
    }

    @Override
    public void setView() {
        this.getGestorVistaAuto().getView();
    }

    public void extraView() {
        //btnBuscar.setEnabled(false);
        this.viewNuevoEnter();
    }

    private void isExtra() {
        if (this.getGestorVistaVenta().isExtra()) {
            this.extraView();
        }
    }

    //llenado de tablas autos a la venta
    public void setBusqueda() {
        this.getGestorVistaVenta().initializeTablaBusqueda(this.getTblDatosAutos());
        this.getGestorVistaVenta().setBusqueda();
    }

    //llenado de tablas ventas realizadas
    public void setBusquedaVentas() {
        this.getGestorVistaVenta().initializeTablaventa(this.getTblVentas());
        this.getGestorVistaVenta().setBusqueda();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        txtMarca = new javax.swing.JTextField();
        cmbPersonal = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        cmbModelo1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbModelo2 = new javax.swing.JComboBox<>();
        txtModelo1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtImpuestos = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatosDetalleVenta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminarDetalleVenta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatosAutos = new javax.swing.JTable();
        btnBuscarAutosVenta = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarAutoDetalle = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnBuscarVentas = new javax.swing.JButton();
        btnImprimir2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Venta");
        setToolTipText("Venta");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("Codigo");
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

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEliminar.setMaximumSize(new java.awt.Dimension(46, 19));
        btnEliminar.setMinimumSize(new java.awt.Dimension(46, 19));
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

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbClienteMouseClicked(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });
        cmbCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbClientePropertyChange(evt);
            }
        });
        jPanel1.add(cmbCliente);
        cmbCliente.setBounds(20, 90, 230, 30);

        txtMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(187, 187, 198));
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(20, 90, 230, 30);

        cmbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(cmbPersonal);
        cmbPersonal.setBounds(350, 90, 230, 30);

        txtModelo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(187, 187, 198));
        txtModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtModelo);
        txtModelo.setBounds(350, 90, 230, 30);

        txtSubtotal.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(187, 187, 198));
        txtSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtSubtotal);
        txtSubtotal.setBounds(130, 280, 180, 20);

        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCliente);
        btnAgregarCliente.setBounds(250, 90, 80, 30);

        cmbModelo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbModelo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModelo1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbModelo1);
        cmbModelo1.setBounds(350, 90, 230, 30);

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel10.setText("Vendedor");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(350, 70, 120, 19);

        cmbModelo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbModelo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModelo2ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbModelo2);
        cmbModelo2.setBounds(350, 90, 230, 30);

        txtModelo1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtModelo1.setForeground(new java.awt.Color(187, 187, 198));
        txtModelo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtModelo1);
        txtModelo1.setBounds(350, 90, 230, 30);

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel11.setText("Impuestos");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 310, 120, 19);

        txtImpuestos.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtImpuestos.setForeground(new java.awt.Color(187, 187, 198));
        txtImpuestos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtImpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestosActionPerformed(evt);
            }
        });
        jPanel1.add(txtImpuestos);
        txtImpuestos.setBounds(130, 310, 180, 20);

        txtTotal.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(187, 187, 198));
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtTotal);
        txtTotal.setBounds(400, 300, 180, 30);

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel12.setText("Total a pagar");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(400, 280, 120, 20);

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel13.setText("monto");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 280, 120, 19);

        tblDatosDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatosDetalleVenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDatosDetalleVenta.setCellSelectionEnabled(true);
        tblDatosDetalleVenta.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblDatosDetalleVentaComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tblDatosDetalleVentaComponentRemoved(evt);
            }
        });
        tblDatosDetalleVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosDetalleVentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDatosDetalleVenta);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 150, 560, 110);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel5.setText("Cliente");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 70, 120, 19);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel6.setText("Detalle de venta");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 130, 120, 19);

        btnEliminarDetalleVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarDetalleVenta.setText("Eliminar");
        btnEliminarDetalleVenta.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEliminarDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleVentaActionPerformed(evt);
            }
        });
        btnEliminarDetalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarDetalleVentaKeyPressed(evt);
            }
        });
        jPanel1.add(btnEliminarDetalleVenta);
        btnEliminarDetalleVenta.setBounds(590, 180, 75, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(380, 0, 700, 430);

        jPanel4.setLayout(null);

        tblDatosAutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatosAutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDatosAutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosAutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatosAutos);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 90, 340, 280);

        btnBuscarAutosVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarAutosVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscarAutosVenta.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscarAutosVenta.setBorderPainted(false);
        btnBuscarAutosVenta.setContentAreaFilled(false);
        btnBuscarAutosVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutosVentaActionPerformed(evt);
            }
        });
        btnBuscarAutosVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarAutosVentaKeyPressed(evt);
            }
        });
        jPanel4.add(btnBuscarAutosVenta);
        btnBuscarAutosVenta.setBounds(260, 50, 80, 30);

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
        jLabel4.setText("Autos en Venta");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 20, 190, 20);

        btnAgregarAutoDetalle.setText("Agregar");
        btnAgregarAutoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutoDetalleActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregarAutoDetalle);
        btnAgregarAutoDetalle.setBounds(130, 380, 80, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 380, 430);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.setLayout(null);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblVentas);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(20, 50, 930, 210);

        btnBuscarVentas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscarVentas.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscarVentas.setBorderPainted(false);
        btnBuscarVentas.setContentAreaFilled(false);
        btnBuscarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentasActionPerformed(evt);
            }
        });
        btnBuscarVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarVentasKeyPressed(evt);
            }
        });
        jPanel5.add(btnBuscarVentas);
        btnBuscarVentas.setBounds(980, 110, 80, 30);

        btnImprimir2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        btnImprimir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrinterChica.png"))); // NOI18N
        btnImprimir2.setText("Imprir");
        btnImprimir2.setToolTipText("Impreme el documento");
        btnImprimir2.setBorderPainted(false);
        btnImprimir2.setContentAreaFilled(false);
        btnImprimir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir2ActionPerformed(evt);
            }
        });
        jPanel5.add(btnImprimir2);
        btnImprimir2.setBounds(960, 170, 110, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Venta Realizadas");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(470, 20, 190, 20);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 430, 1080, 280);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 1092, 746);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == 10) {
            if (this.gestorVistaVenta.getModelXCodigo(txtCodigo.getText())) {
                this.viewActualizar();
            } else {
                JOptionPane.showMessageDialog(null, "Código no existe");
            }
        }
}//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

}//GEN-LAST:event_txtCodigoKeyTyped

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        this.viewBuscarCodigoEnter();
}//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void btnBuscarCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarCodigoKeyPressed
        if (evt.getKeyCode() == 10) {
            this.viewBuscarCodigoEnter();
        }
}//GEN-LAST:event_btnBuscarCodigoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        if (evt.getKeyCode() == 10)
            this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
        if (evt.getKeyCode() == 10)
            this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode() == 10)
            this.saveView();
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado", "Advertencia", YES_NO_OPTION) == 0)
            this.deleteView();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if (evt.getKeyCode() == 10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado", "Advertencia", YES_NO_OPTION) == 0) {
                this.deleteView();
            }
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVistaVenta().isNuevo() || this.getGestorVistaVenta().isOnlyRead()) {
            this.dispose();
        } else {
            n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?", "Advertencia", YES_NO_OPTION);
        }
        if (n == 1) {
            this.cancelarView();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        if (evt.getKeyCode() == 10) {
            int n = 0;
            if (this.getGestorVistaAuto().isNuevo()) {
                this.dispose();
            } else {
                n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?", "Advertencia", YES_NO_OPTION);
            }
            if (n == 1) {
                this.cancelarView();
                this.dispose();
            }
        }

    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados", "Advertencia", YES_NO_OPTION) == 0)
            this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == 10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados", "Advertencia", YES_NO_OPTION) == 0) {
                this.cancelarView();
            }
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnBuscarAutosVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutosVentaActionPerformed
        this.clearView();
        this.setBusqueda();
        this.viewCamposEnabled(false);
//        botonesComandoView.viewAllDisabled();
//        botonesComandoView.viewOpenedBotones();
    }//GEN-LAST:event_btnBuscarAutosVentaActionPerformed

    private void btnBuscarAutosVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarAutosVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarAutosVentaKeyPressed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void tblDatosAutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosAutosMouseClicked
        this.getGestorVistaAuto().setDatos();
    }//GEN-LAST:event_tblDatosAutosMouseClicked

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPersonalActionPerformed

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbClienteMouseClicked

    }//GEN-LAST:event_cmbClienteMouseClicked

    private void cmbClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbClientePropertyChange

    }//GEN-LAST:event_cmbClientePropertyChange

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        this.getGestorVistaVenta().openFormularioCliente((DefaultComboBoxModel) cmbCliente.getModel());
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void cmbModelo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModelo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModelo1ActionPerformed

    private void cmbModelo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModelo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModelo2ActionPerformed

    private void tblDatosDetalleVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosDetalleVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosDetalleVentaMouseClicked

    private void btnEliminarDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleVentaActionPerformed
        this.getGestorVistaVenta().EliminarDetalle(this.getTblDatosDetalleVenta());
    }//GEN-LAST:event_btnEliminarDetalleVentaActionPerformed

    private void btnEliminarDetalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarDetalleVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDetalleVentaKeyPressed

    private void txtImpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpuestosActionPerformed

    private void btnAgregarAutoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutoDetalleActionPerformed
        int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a Vender"));
        this.getGestorVistaVenta().agregarDetalle(this.getTblDatosAutos(), numero);
    }//GEN-LAST:event_btnAgregarAutoDetalleActionPerformed

    private void tblDatosDetalleVentaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblDatosDetalleVentaComponentAdded
       
    }//GEN-LAST:event_tblDatosDetalleVentaComponentAdded

    private void tblDatosDetalleVentaComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblDatosDetalleVentaComponentRemoved
        
    }//GEN-LAST:event_tblDatosDetalleVentaComponentRemoved

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVentasMouseClicked

    private void btnBuscarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentasActionPerformed
        this.clearView();
        this.setBusqueda();
        this.viewCamposEnabled(false);
    }//GEN-LAST:event_btnBuscarVentasActionPerformed

    private void btnBuscarVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarVentasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarVentasKeyPressed

    private void btnImprimir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAutoDetalle;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscarAutosVenta;
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarVentas;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEliminarDetalleVenta;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnImprimir2;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbModelo1;
    private javax.swing.JComboBox<String> cmbModelo2;
    private javax.swing.JComboBox<String> cmbPersonal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDatosAutos;
    private javax.swing.JTable tblDatosDetalleVenta;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtImpuestos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtModelo1;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
