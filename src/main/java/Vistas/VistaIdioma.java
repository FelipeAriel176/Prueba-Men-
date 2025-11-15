/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import DAO.IdiomaDAO; 
import DAO.PaisDAO;   
import Modelo.IdiomaPais; 
import Modelo.Pais; 
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author arale
 */
public class VistaIdioma extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaIdioma.class.getName());

    private int filaSeleccionada = -1;
    private final IdiomaDAO idiomaDAO = new IdiomaDAO();
    private final PaisDAO paisDAO = new PaisDAO();
    
    public VistaIdioma() {
        initComponents();
        cargarPaises(); 
        actualizarTabla();
        this.setLocationRelativeTo(null);
    }
    
    private void actualizarTabla() {
    ArrayList<Modelo.IdiomaPais> listaIdiomas = idiomaDAO.listarIdiomas();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("Idioma");
    modeloTabla.addColumn("Oficial");
    modeloTabla.addColumn("Porcentaje Hablantes");
    modeloTabla.addColumn("País");
    
        for (Modelo.IdiomaPais ip : listaIdiomas) {
        modeloTabla.addRow(new Object[]{
            ip.getIdioma(),
            ip.isEsOficial() ? "Si" : "No", 
            ip.getPorcentajeHablantes(),
            ip.getPais().getNombre() 
        });
    }
    tblIdiomas.setModel(modeloTabla);
}
    
    private void cargarPaises() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
    modelo.addElement("Seleccione un pais");
    
    ArrayList<Pais> listaPaises = paisDAO.listarPaises();
    
    for (Modelo.Pais p : listaPaises) {
        modelo.addElement(p);
        }
        cmbPais.setModel(modelo);
    }
 
    private void NuevoCampo() {
        txtIdioma.setText("");
        txtPorcentaje.setText("");
        chkOficial.setSelected(false);
        if (cmbPais.getItemCount() > 0) {
            cmbPais.setSelectedIndex(0);
        }
        filaSeleccionada = -1;
        tblIdiomas.clearSelection();
         }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        txtIdioma = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        cmbPais = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIdiomas = new javax.swing.JTable();
        chkOficial = new javax.swing.JCheckBox();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdiomaActionPerformed(evt);
            }
        });

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaisActionPerformed(evt);
            }
        });

        tblIdiomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Idioma", "Pais", "Porcentaje hablantes", "Oficial"
            }
        ));
        tblIdiomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIdiomasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIdiomas);

        chkOficial.setText("¿Es oficial?");

        btnCrear.setText("Agregar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
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

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel1.setText("Idioma");

        jLabel2.setText("Porcentaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVolver)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(chkOficial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar)
                        .addGap(94, 94, 94)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addGap(341, 341, 341))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addGap(47, 47, 47)
                        .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrear)
                            .addComponent(chkOficial)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    VistaMenúADMIN MenuA = new VistaMenúADMIN();
    this.setVisible(false);
    MenuA.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdiomaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String idioma = txtIdioma.getText().trim();
        String porcentajeTexto = txtPorcentaje.getText().trim();
        Object itemSeleccionado = cmbPais.getSelectedItem();
        
        if (idioma.isEmpty() || porcentajeTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el nombre del idioma y el porcentaje.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        if (itemSeleccionado == null || itemSeleccionado.toString().contains("Seleccione un pais")) {
        JOptionPane.showMessageDialog(this, "Seleccione un pais", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        try {
        double porcentaje = Double.parseDouble(txtPorcentaje.getText().trim());
        if (porcentaje < 0 || porcentaje > 100) {
            JOptionPane.showMessageDialog(this, "El porcentaje debe ser un valor entre 0 y 100.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Modelo.Pais paisSeleccionado = (Modelo.Pais) itemSeleccionado;
        boolean esOficial = chkOficial.isSelected(); 

        Modelo.IdiomaPais nuevoIdioma = new Modelo.IdiomaPais(
                idioma,
                esOficial,
                porcentaje,
                paisSeleccionado 
        );
        
        if (idiomaDAO.agregarIdioma(nuevoIdioma)) {
                actualizarTabla();
                NuevoCampo();
                JOptionPane.showMessageDialog(this, "Idioma agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                JOptionPane.showMessageDialog(this, "El idioma ya existe para este país.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El porcentaje debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tblIdiomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIdiomasMouseClicked
        filaSeleccionada = tblIdiomas.getSelectedRow();   
        if (filaSeleccionada != -1) {
                String idiomaNombre = (String) tblIdiomas.getValueAt(filaSeleccionada, 0);
                String oficialTexto = (String) tblIdiomas.getValueAt(filaSeleccionada, 1);
                String porcentaje = String.valueOf(tblIdiomas.getValueAt(filaSeleccionada, 2));
                String paisCodigo = (String) tblIdiomas.getValueAt(filaSeleccionada, 4);

                txtIdioma.setText(idiomaNombre);
                txtPorcentaje.setText(porcentaje);
                chkOficial.setSelected(oficialTexto.equals("Sí"));
            
                Pais paisSeleccionado = paisDAO.obtenerPaisPorCodigo(paisCodigo);

                if (paisSeleccionado != null) {
                cmbPais.setSelectedItem(paisSeleccionado);
            }
        }
    }//GEN-LAST:event_tblIdiomasMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    NuevoCampo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cmbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaisActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione el idioma.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        String idiomaOriginal = (String) tblIdiomas.getValueAt(filaSeleccionada, 0);
        String paisCodigoOriginal = (String) tblIdiomas.getValueAt(filaSeleccionada, 4);
        
        String idiomaNuevo = txtIdioma.getText().trim();
        String porcentajeTexto = txtPorcentaje.getText().trim();
        Object itemSeleccionado = cmbPais.getSelectedItem();
        
        if (idiomaNuevo.isEmpty() || porcentajeTexto.isEmpty() || itemSeleccionado == null || !(itemSeleccionado instanceof Pais)) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos/seleccione un país.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double porcentaje = Double.parseDouble(porcentajeTexto);
            if (porcentaje < 0 || porcentaje > 100) {
                JOptionPane.showMessageDialog(this, "El porcentaje debe ser un valor entre 0 y 100.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Modelo.Pais paisNuevo = (Modelo.Pais) itemSeleccionado;
            boolean esOficial = chkOficial.isSelected();

            IdiomaPais idiomaAEditarOriginal = new IdiomaPais(idiomaOriginal, false, 0, new Pais(0, "", "", 0)); 
            IdiomaPais idiomaAEditarNuevo = new IdiomaPais(idiomaNuevo, esOficial, porcentaje, paisNuevo);

            if (idiomaDAO.modificarIdioma(idiomaAEditarOriginal, idiomaAEditarNuevo)) {
                actualizarTabla();
                NuevoCampo();
                JOptionPane.showMessageDialog(this, "Idioma modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 JOptionPane.showMessageDialog(this, "El idioma podría ya existir en el nuevo país.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El porcentaje debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }      
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un idioma para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String idiomaAEliminar = (String) tblIdiomas.getValueAt(filaSeleccionada, 0);
        String paisCodigoAEliminar = (String) tblIdiomas.getValueAt(filaSeleccionada, 4);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (idiomaDAO.eliminarIdioma(idiomaAEliminar, paisCodigoAEliminar)) {
                actualizarTabla();
                NuevoCampo();
                JOptionPane.showMessageDialog(this, "Idioma eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el idioma.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }    }//GEN-LAST:event_btnEliminarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new VistaIdioma().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkOficial;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIdiomas;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
