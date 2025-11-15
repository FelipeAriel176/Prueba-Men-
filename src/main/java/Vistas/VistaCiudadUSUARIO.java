/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import DAO.CiudadDAO; 
import DAO.PaisDAO; 
import Modelo.Ciudad;
import Modelo.Pais;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;/**
 *
 * @author FELIP
 */
public class VistaCiudadUSUARIO extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaCiudadUSUARIO.class.getName());

    private final CiudadDAO ciudadDAO = new CiudadDAO();
    private final PaisDAO paisDAO = new PaisDAO();
    
    public VistaCiudadUSUARIO() {
        initComponents();
        cargarPaises(); 
        actualizarTabla();
        this.setLocationRelativeTo(null);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiudades = new javax.swing.JTable();
        cmbPais = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
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
        jScrollPane1.setViewportView(tblCiudades);

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaisActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("Ciudades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbPais, 0, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTabla(ArrayList<Modelo.Ciudad> listarCiudades) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
       
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Distrito");
        modeloTabla.addColumn("Población");
        modeloTabla.addColumn("País");
        
        for (Modelo.Ciudad c : listarCiudades) {
            modeloTabla.addRow(new Object[]{
                c.getNombre(),
                c.getDistrito(),
                c.getPoblacion(),
                c.getPais().getNombre()
                    });
        }
        tblCiudades.setModel(modeloTabla); 
    }
    
    private void actualizarTabla() {
        ArrayList<Modelo.Ciudad> listarCiudades = ciudadDAO.listarCiudades();
        actualizarTabla(listarCiudades);
    }
    
    private void cargarPaises() {
        DefaultComboBoxModel<Object> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Mostrar todo");

    ArrayList<Pais> listaPaises = paisDAO.listarPaises();
    
        for (Pais p : listaPaises) {
                modelo.addElement(p); 
                }
        cmbPais.setModel(modelo);
    }    
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    VistaMenúUSUARIO vistaMenuU = new VistaMenúUSUARIO();
    this.setVisible(false);
    vistaMenuU.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaisActionPerformed
        Object itemSeleccionado = cmbPais.getSelectedItem();
        
        if (itemSeleccionado == null || itemSeleccionado.toString().contains("Mostrar todas las ciudades")) {
                actualizarTabla();
                return;
                }        

        if (itemSeleccionado instanceof Pais) {
                Pais paisSeleccionado = (Pais) itemSeleccionado;
                int codigoPais = paisSeleccionado.getCodigo();
            
                ArrayList<Ciudad> resultadosFiltrados = ciudadDAO.listarCiudades(codigoPais); 
                actualizarTabla(resultadosFiltrados);
                } 
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
        java.awt.EventQueue.invokeLater(() -> new VistaCiudadUSUARIO().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCiudades;
    // End of variables declaration//GEN-END:variables
}
