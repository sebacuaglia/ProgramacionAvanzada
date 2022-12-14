package Modelos.GestionProyecto;

import Vistas.FrmGenerica;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class FrmAuto extends FrmGenerica {

    private GestorVistaMarca gestorVistaMarca;
    private GestorVistaModelo gestorVistaModelo;
    private GestorVistaAuto gestorVistaAuto;
    private int YES_NO_OPTION;

    public GestorVistaAuto getGestorVistaAuto() {
        return gestorVistaAuto;
    }

    public void setGestorVistaAuto(GestorVistaAuto gestorVistaAuto) {
        this.gestorVistaAuto = gestorVistaAuto;
    }

    public GestorVistaMarca getGestorVistaMarca() {
        return gestorVistaMarca;
    }

    public void setGestorVistaMarca(GestorVistaMarca gestorVistaMarca) {
        this.gestorVistaMarca = gestorVistaMarca;
    }

    public GestorVistaModelo getGestorVistaModelo() {
        return gestorVistaModelo;
    }

    public void setGestorVistaModelo(GestorVistaModelo gestorVistaModelo) {
        this.gestorVistaModelo = gestorVistaModelo;
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

    public JComboBox<String> getCmbModelo() {
        return cmbModelo;
    }

    public void setCmbModelo(JComboBox<String> cmbModelo) {
        this.cmbModelo = cmbModelo;
    }

    public JTextField getTxtPais() {
        return txtMarca;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtMarca = txtPais;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
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
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextField getTxtCosto() {
        return txtCosto;
    }

    public void setTxtCosto(JTextField txtCosto) {
        this.txtCosto = txtCosto;
    }

// Constructores del formulario 
    public FrmAuto(GestorVistaAuto gestorVista) {
        try {
            initComponents();
        } catch (Exception e) {

        }
        this.setGestorVistaAuto(gestorVista);
        this.onViewOpened();
    }

    public FrmAuto(GestorVistaAuto gestorVistaAuto, GestorVistaMarca gestorVistaMarca, GestorVistaModelo gestorVistaModelo) {
        try {
            initComponents();
        } catch (Exception e) {

        }
        this.setGestorVistaAuto(gestorVistaAuto);
        this.setGestorVistaMarca(gestorVistaMarca);
        this.setGestorVistaModelo(gestorVistaModelo);
        this.onViewOpened();
    }

    public FrmAuto() {
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
        cmbMarca.setVisible(tipo);
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
        this.getGestorVistaAuto().initializeTablaBusqueda(this.getTblDatos());
        this.isExtra();

    }

    @Override
    public void cargarCombos() {
        this.gestorVistaAuto.setModelMarca(cmbMarca);
        cmbMarca.setSelectedItem("");

    }

    @Override
    public void viewCamposEnabled(Boolean tipo) {
        txtCodigo.setEnabled(false);
        cmbMarca.setEnabled(tipo);
        btnAgregarMarca.setEnabled(tipo);
        txtMarca.setEnabled(false);
        btnAgregarModelo.setEnabled(tipo);
        cmbModelo.setEnabled(tipo);
        txtModelo.setEnabled(false);
        txtColor.setEnabled(tipo);
        txtPrecio.setEnabled(tipo);
        txtCosto.setEnabled(tipo);
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

        cmbMarca.grabFocus();
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
        cmbMarca.grabFocus();
    }

    @Override
    public void clearView() {
        txtCodigo.setText("");
        txtMarca.setText("");
        cmbMarca.setSelectedItem(null);
        cmbModelo.setSelectedItem(null);
        txtColor.setText("");
        txtPrecio.setText("");
        txtCosto.setText("");
    }

    @Override
    public void grabFocus() {
        cmbMarca.grabFocus();
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
        if (this.getGestorVistaAuto().isExtra()) {
            this.extraView();
        }
    }

    //llenado de tablas
    public void setBusqueda() {
        this.getGestorVistaAuto().initializeTablaBusqueda(this.getTblDatos());
        this.getGestorVistaAuto().setBusqueda();
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
        txtMarca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbModelo = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnAgregarMarca = new javax.swing.JButton();
        btnAgregarModelo = new javax.swing.JButton();
        txtCosto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Auto");
        setToolTipText("Auto");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripci?n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("C?digo");
        jLabel3.setRequestFocusEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 90, 19);

        txtCodigo.setBackground(new java.awt.Color(204, 255, 204));
        txtCodigo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setToolTipText("Ingrese C?digo");
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

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Marca");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 90, 120, 19);

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
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });
        cmbMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbMarcaMouseClicked(evt);
            }
        });
        cmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcaActionPerformed(evt);
            }
        });
        cmbMarca.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbMarcaPropertyChange(evt);
            }
        });
        jPanel1.add(cmbMarca);
        cmbMarca.setBounds(20, 110, 230, 30);

        txtMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(187, 187, 198));
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(20, 110, 230, 30);

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel7.setText("Modelo");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(350, 90, 120, 19);

        cmbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModeloActionPerformed(evt);
            }
        });
        jPanel1.add(cmbModelo);
        cmbModelo.setBounds(350, 110, 230, 30);

        txtModelo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(187, 187, 198));
        txtModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtModelo);
        txtModelo.setBounds(350, 110, 230, 30);

        txtColor.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtColor.setForeground(new java.awt.Color(187, 187, 198));
        txtColor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtColor);
        txtColor.setBounds(20, 170, 310, 30);

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel8.setText("Color");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 150, 120, 19);

        txtPrecio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(187, 187, 198));
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
        });
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(20, 310, 310, 30);

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel9.setText("Precio venta");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 290, 120, 19);

        btnAgregarMarca.setText("Agregar");
        btnAgregarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarMarca);
        btnAgregarMarca.setBounds(250, 110, 80, 30);

        btnAgregarModelo.setText("Agregar");
        btnAgregarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarModeloActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarModelo);
        btnAgregarModelo.setBounds(580, 110, 80, 30);

        txtCosto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(187, 187, 198));
        txtCosto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
        });
        jPanel1.add(txtCosto);
        txtCosto.setBounds(20, 230, 310, 30);

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel10.setText("Costo");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 210, 120, 19);

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
        btnBuscar1.setToolTipText("Buscar Tipo Servicio por denominaci?n");
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

        txtBusquedaNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtBusquedaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtBusquedaNombre);
        txtBusquedaNombre.setBounds(20, 50, 240, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Lista de Autos disponibles");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 20, 190, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 10, 380, 430);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 1129, 481);
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        this.getGestorVistaAuto().setDatos();
    }//GEN-LAST:event_tblDatosMouseClicked

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')) && !(c == KeyEvent.VK_BACK_SPACE) && !(c == KeyEvent.VK_DELETE)) {
            JOptionPane.showMessageDialog(null, "SOLO SE PUEDEN INGRESAR NUMEROS");
            evt.consume();
            this.getGestorVistaAuto().keyPressedNotNumber();
        }
    }//GEN-LAST:event_txtCostoKeyPressed

    private void btnAgregarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarModeloActionPerformed
        this.getGestorVistaAuto().openFormularioModelo((DefaultComboBoxModel) cmbModelo.getModel(), cmbMarca);
    }//GEN-LAST:event_btnAgregarModeloActionPerformed

    private void btnAgregarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMarcaActionPerformed
        this.getGestorVistaAuto().openFormularioMarca((DefaultComboBoxModel) cmbMarca.getModel());
    }//GEN-LAST:event_btnAgregarMarcaActionPerformed

    private void cmbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModeloActionPerformed

    private void cmbMarcaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbMarcaPropertyChange

    }//GEN-LAST:event_cmbMarcaPropertyChange

    private void cmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMarcaActionPerformed

    private void cmbMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMarcaMouseClicked

    }//GEN-LAST:event_cmbMarcaMouseClicked

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        this.gestorVistaAuto.setModelModelo(cmbModelo);
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == 10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados", "Advertencia", YES_NO_OPTION) == 0) {
                this.cancelarView();
            }
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados", "Advertencia", YES_NO_OPTION) == 0)
            this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        if (evt.getKeyCode() == 10) {
            int n = 0;
            if (this.getGestorVistaAuto().isNuevo()) {
                this.dispose();
            } else {
                n = JOptionPane.showConfirmDialog(null, "?Desea guardar los cambios antes de salir?", "Advertencia", YES_NO_OPTION);
            }
            if (n == 1) {
                this.cancelarView();
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVistaAuto().isNuevo() || this.getGestorVistaAuto().isOnlyRead()) {
            this.dispose();
        } else {
            n = JOptionPane.showConfirmDialog(null, "?Desea guardar los cambios antes de salir?", "Advertencia", YES_NO_OPTION);
        }
        if (n == 1) {
            this.cancelarView();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
        if (evt.getKeyCode() == 10)
            this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if (evt.getKeyCode() == 10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado", "Advertencia", YES_NO_OPTION) == 0) {
                this.deleteView();
            }
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado", "Advertencia", YES_NO_OPTION) == 0)
            this.deleteView();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode() == 10)
            this.saveView();
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        if (evt.getKeyCode() == 10)
            this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == 10) {
            if (this.gestorVistaAuto.getModelXCodigo(txtCodigo.getText())) {
                this.viewActualizar();
            } else {
                JOptionPane.showMessageDialog(null, "C?digo no existe");
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')) && !(c == KeyEvent.VK_BACK_SPACE) && !(c == KeyEvent.VK_DELETE)) {
            JOptionPane.showMessageDialog(null, "SOLO SE PUEDEN INGRESAR NUMEROS");
            evt.consume();
            this.getGestorVistaAuto().keyPressedNotNumber();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMarca;
    private javax.swing.JButton btnAgregarModelo;
    private javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbModelo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
