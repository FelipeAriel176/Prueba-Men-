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
    
    for (Modelo.Ciudad c : com.mycompany.prueba2menu.main.listaCiudades) {
        modeloTabla.addRow(new Object[]{
            c.getNombre(),
            c.getDistrito(),
            c.getPoblacion()
        });
    }
        tblCiudades.setModel(modeloTabla);
}
    
    private void NuevoCampo() {
    txtNombreCiudad.setText("");
    txtDistrito.setText("");
    txtPoblacion.setText("");
    cmbPais.setSelectedIndex(0); 
    filaSeleccionada = -1;
    tblCiudades.clearSelection();
}
    
    private void cargarPaises() {
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        modelo.addElement("Selecciona un pais");    
    
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
        btnCrear = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblDistrito = new javax.swing.JLabel();
        lblPoblacion = new javax.swing.JLabel();

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Distrito", "Poblacion", "Pais"
            }
        ));
        tblCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCiudadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCiudades);

        btnCrear.setText("Agregar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblDistrito.setText("Distrito");

        lblPoblacion.setText("Poblacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDistrito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnCrear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
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
                            .addComponent(btnNuevo)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCrear)
                        .addGap(55, 55, 55))))
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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
    String nombre = txtNombreCiudad.getText().trim();
    String distrito = txtDistrito.getText().trim();
    String poblacionTexto = txtPoblacion.getText().trim();
    Object itemSeleccionado = cmbPais.getSelectedItem();
        
     if (nombre.isEmpty() || distrito.isEmpty() || poblacionTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
  if (itemSeleccionado == null || itemSeleccionado.toString().contains("Seleccione un país")) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un país.", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }
  
    try {
       int poblacion = Integer.parseInt(poblacionTexto);

        if (poblacion <= 0) {
            JOptionPane.showMessageDialog(this, "La población debe ser un número mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Modelo.Pais paisSeleccionado = (Modelo.Pais) itemSeleccionado;
        Modelo.Ciudad nuevaCiudad = new Modelo.Ciudad(
                nombre,
                distrito,
                poblacion,
                paisSeleccionado 
        );
        com.mycompany.prueba2menu.main.listaCiudades.add(nuevaCiudad);
        actualizarTabla();
        NuevoCampo();
        JOptionPane.showMessageDialog(this, "Ciudad agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);       
}       catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La población debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtNombreCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCiudadActionPerformed

    private void cmbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaisActionPerformed

    private void tblCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCiudadesMouseClicked
    filaSeleccionada = tblCiudades.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        Modelo.Ciudad ciudadSeleccionada = com.mycompany.prueba2menu.main.listaCiudades.get(filaSeleccionada);
        txtNombreCiudad.setText(ciudadSeleccionada.getNombre());
        txtDistrito.setText(ciudadSeleccionada.getDistrito());
        txtPoblacion.setText(String.valueOf(ciudadSeleccionada.getPoblacion()));
        cmbPais.setSelectedItem(ciudadSeleccionada.getPais());
}
    }//GEN-LAST:event_tblCiudadesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una ciudad", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

try {
        Modelo.Ciudad ciudadEditar = com.mycompany.prueba2menu.main.listaCiudades.get(filaSeleccionada);
        
        int nuevaPoblacion = Integer.parseInt(txtPoblacion.getText().trim());
        Modelo.Pais nuevoPais = (Modelo.Pais) cmbPais.getSelectedItem();
        
        if (nuevaPoblacion <= 0) {
            JOptionPane.showMessageDialog(this, "La población debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ciudadEditar.setNombre(txtNombreCiudad.getText().trim());
        ciudadEditar.setDistrito(txtDistrito.getText().trim());
        ciudadEditar.setPoblacion(nuevaPoblacion);
        ciudadEditar.setPais(nuevoPais);
        
        actualizarTabla();
        NuevoCampo();
        JOptionPane.showMessageDialog(this, "Ciudad modificada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La población debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una ciudad.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        com.mycompany.prueba2menu.main.listaCiudades.remove(filaSeleccionada);
        actualizarTabla();
        NuevoCampo();
        JOptionPane.showMessageDialog(this, "Ciudad eliminada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    NuevoCampo();
    }//GEN-LAST:event_btnNuevoActionPerformed

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
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPoblacion;
    private javax.swing.JTable tblCiudades;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtNombreCiudad;
    private javax.swing.JTextField txtPoblacion;
    // End of variables declaration//GEN-END:variables
}
