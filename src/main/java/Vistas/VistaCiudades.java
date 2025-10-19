/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import com.mycompany.prueba2menu.main;
import javax.swing.DefaultComboBoxModel;
import Modelo.Pais;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaCiudades extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaCiudades.class.getName());
    
    private int filaSeleccionada = -1;
    
    private void actualizarTabla() {
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("Nombre");
    modeloTabla.addColumn("Distrito");
    modeloTabla.addColumn("Población");
    modeloTabla.addColumn("País");
    
    for (Modelo.Ciudad c : com.mycompany.prueba2menu.main.listaCiudades) {
        modeloTabla.addRow(new Object[]{
            c.getNombre(),
            c.getDistrito(),
            c.getPoblacion(),
            c.getPais().getNombre() 
        });
    }
        tblCiudades.setModel(modeloTabla);
}
    
    private void cargarPaises() {
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        modelo.addElement(" Selecciona un país");    
    
    for (Pais p : com.mycompany.prueba2menu.main.listaPaises) {
        modelo.addElement(p);
    }
    cmbPais.setModel(modelo);
}
    public VistaCiudades() {
        initComponents();
        cargarPaises();
        actualizarTabla();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        cmbPais = new javax.swing.JComboBox<>();
        txtNombreCiudad = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        txtPoblacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiudades = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaisActionPerformed(evt);
            }
        });

        txtNombreCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCiudadActionPerformed(evt);
            }
        });

        txtPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActionPerformed(evt);
            }
        });

        tblCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Distrito", "Poblacion"
            }
        ));
        jScrollPane1.setViewportView(tblCiudades);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jLabel1.setText("Nombre");

        jLabel2.setText("Distrito");

        jLabel3.setText("Población");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDistrito)
                            .addComponent(txtPoblacion)
                            .addComponent(txtNombreCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnAgregar)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        main.vistaMenuAdmin.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    String nombre = txtNombreCiudad.getText().trim();
    String distrito = txtDistrito.getText().trim();
    Pais paisSeleccionado = (Pais)cmbPais.getSelectedItem();
    Object itemSeleccionado = cmbPais.getSelectedItem();
    
    if (nombre.isEmpty() || distrito.isEmpty() || txtPoblacion.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Debe completar todos los campos de texto.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
   if (itemSeleccionado == null || itemSeleccionado.toString().contains("Seleccione un País")) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un País de la lista.", "Error de Relación", JOptionPane.ERROR_MESSAGE);
        return;
    }
    try {
        int poblacion = Integer.parseInt(txtPoblacion.getText().trim());
        paisSeleccionado = (Modelo.Pais) itemSeleccionado;
        Modelo.Ciudad nuevaCiudad = new Modelo.Ciudad(
                nombre,
                distrito,
                poblacion,
                paisSeleccionado);
                com.mycompany.prueba2menu.main.listaCiudades.add(nuevaCiudad);
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "Ciudad agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } 
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La población debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCiudadActionPerformed

    private void cmbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VistaCiudades().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCiudades;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtNombreCiudad;
    private javax.swing.JTextField txtPoblacion;
    // End of variables declaration//GEN-END:variables
}
