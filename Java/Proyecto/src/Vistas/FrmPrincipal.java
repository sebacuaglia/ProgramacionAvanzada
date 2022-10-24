package Vistas;
import javax.swing.JDesktopPane;

public class FrmPrincipal extends  javax.swing.JFrame {
    public GestorVistaPrincipal gestorVista;
 
    
    public FrmPrincipal() {
        initComponents();
    }

    public FrmPrincipal(GestorVistaPrincipal aThis) {
        initComponents();
        gestorVista=aThis;
    }


    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jmenu = new javax.swing.JMenuBar();
        mnConfiguracion = new javax.swing.JMenu();
        mnuProyecto = new javax.swing.JMenuItem();
        mnuTipoProyecto = new javax.swing.JMenuItem();
        mnuMarca = new javax.swing.JMenuItem();
        mnuModelo = new javax.swing.JMenuItem();
        mnuAuto = new javax.swing.JMenuItem();
        mnuVenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo");

        jmenu.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        mnConfiguracion.setText("Configuración");
        mnConfiguracion.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        mnuProyecto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuProyecto.setText("Cliente");
        mnuProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProyectoActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuProyecto);

        mnuTipoProyecto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuTipoProyecto.setText("Personal");
        mnuTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTipoProyectoActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuTipoProyecto);

        mnuMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuMarca.setText("Marca");
        mnuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcaActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuMarca);

        mnuModelo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuModelo.setText("Modelo");
        mnuModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModeloActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuModelo);

        mnuAuto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuAuto.setText("Auto");
        mnuAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAutoActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuAuto);

        mnuVenta.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mnuVenta.setText("Venta");
        mnuVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentaActionPerformed(evt);
            }
        });
        mnConfiguracion.add(mnuVenta);

        jmenu.add(mnConfiguracion);

        setJMenuBar(jmenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1393, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProyectoActionPerformed
        this.gestorVista.abrirCliente(getEscritorio());
    }//GEN-LAST:event_mnuProyectoActionPerformed

    private void mnuTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTipoProyectoActionPerformed
        this.gestorVista.abrirPersonal(getEscritorio());
    }//GEN-LAST:event_mnuTipoProyectoActionPerformed

    private void mnuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcaActionPerformed
        this.gestorVista.abrirMarca(getEscritorio());
    }//GEN-LAST:event_mnuMarcaActionPerformed

    private void mnuModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModeloActionPerformed
        this.gestorVista.abrirModelo(getEscritorio());
    }//GEN-LAST:event_mnuModeloActionPerformed

    private void mnuAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAutoActionPerformed
        this.gestorVista.abrirAuto(getEscritorio());
    }//GEN-LAST:event_mnuAutoActionPerformed

    private void mnuVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentaActionPerformed
        this.gestorVista.abrirVenta(getEscritorio());
    }//GEN-LAST:event_mnuVentaActionPerformed

public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JMenu mnConfiguracion;
    private javax.swing.JMenuItem mnuAuto;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenuItem mnuModelo;
    private javax.swing.JMenuItem mnuProyecto;
    private javax.swing.JMenuItem mnuTipoProyecto;
    private javax.swing.JMenuItem mnuVenta;
    // End of variables declaration//GEN-END:variables

}
