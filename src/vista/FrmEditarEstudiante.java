package vista;

import controlador.ControladorCRUDEstudiantes;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class FrmEditarEstudiante extends javax.swing.JFrame {
        ControladorCRUDEstudiantes objControladorCRUDEst;

        public FrmEditarEstudiante(ControladorCRUDEstudiantes objCtrlCRUDEst) {
                initComponents();
                this.objControladorCRUDEst = objCtrlCRUDEst;
                this.des_habilitaComponentes(false);
        }

        // Habiliar y deshabilitar los componentes
        private void des_habilitaComponentes(boolean valor) {
                this.txtNombre.setEnabled(valor);
                this.txtApellidos.setEnabled(valor);
                this.cboSemestre.setEnabled(valor);
                this.rdbtnGrupoA.setEnabled(valor);
                this.rdbtnGrupoB.setEnabled(valor);
                this.rdbtnGrupoC.setEnabled(valor);
                this.cboCarrera.setEnabled(valor);
                this.btnEditar.setEnabled(valor);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboSemestre = new javax.swing.JComboBox<>();
        rdbtnGrupoA = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbtnGrupoB = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rdbtnGrupoC = new javax.swing.JRadioButton();
        txtNumControl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cboCarrera = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Registro");

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        rdbtnGrupoA.setSelected(true);
        rdbtnGrupoA.setText("A");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tecnológico del Valle de Oaxaca");

        jLabel7.setText("Grupo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Editar Estudiante");

        rdbtnGrupoB.setText("B");

        jLabel1.setText("Num Control");

        rdbtnGrupoC.setText("C");

        txtNumControl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumControlKeyPressed(evt);
            }
        });

        jLabel8.setText("Carrera");

        jLabel4.setText("Nombre");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar48px.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
            }
        });

        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ing. Informática", "Ing. en TIC", "Ing. en Ciencia de Datos", "Ing. en Gestión Empresarial", "Ing. Forestal", "Ing. en Agronomía", "Lic. en Biología" }));

        jLabel5.setText("Apellidos");

        jLabel6.setText("Semestre");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar232px.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbtnGrupoA)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbtnGrupoB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbtnGrupoC))
                                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnEditar)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnBuscar)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbtnGrupoA)
                        .addComponent(rdbtnGrupoB)
                        .addComponent(rdbtnGrupoC))
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_btnEditarKeyPressed
                // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                        this.editar();
        }// GEN-LAST:event_btnEditarKeyPressed

        private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_btnBuscarKeyPressed
                // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                        this.buscar();
        }// GEN-LAST:event_btnBuscarKeyPressed

        private void txtNumControlKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtNumControlKeyPressed
                // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                        this.buscar();
        }// GEN-LAST:event_txtNumControlKeyPressed

        private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnBuscarMouseClicked
                // TODO add your handling code here:
                this.buscar();
        }// GEN-LAST:event_btnBuscarMouseClicked

        private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnEditarMouseClicked
                // TODO add your handling code here:
                this.editar();
        }// GEN-LAST:event_btnEditarMouseClicked

        private void buscar() {
                String numControl = this.txtNumControl.getText();
                String registro[] = this.objControladorCRUDEst.buscarRegistro(numControl);
                if (registro != null) {
                        this.txtNombre.setText(registro[1]);
                        this.txtApellidos.setText(registro[2]);

                        // Establecer el semestre en el combobox
                        this.cboSemestre.setSelectedItem(registro[3]);

                        // Establecer el grupo en los radio buttons
                        char grupo = registro[4].charAt(0);
                        if (grupo == 'A')
                                this.rdbtnGrupoA.setSelected(true);
                        else if (grupo == 'B')
                                this.rdbtnGrupoB.setSelected(true);
                        else
                                this.rdbtnGrupoC.setSelected(true);

                        // Establecer la carrera en el combobox
                        this.cboCarrera.setSelectedItem(registro[5]);

                        // Habilitar los componentes para edición
                        this.des_habilitaComponentes(true);
                } else {
                        JOptionPane.showMessageDialog(this, "El registro no existe");
                }
        }

        private void editar1() {
                /*
                 * int respuesta =
                 * JOptionPane.showConfirmDialog(this,"Estas seguro de eliminar el registro");
                 * if(respuesta==0){
                 * String numControl = this.txtNumControl.getText();
                 * this.objControladorCRUDEst.eliminarRegistro(numControl);
                 * JOptionPane.showMessageDialog(this.objControladorCRUDEst.
                 * objVistaCRUDEst,"Registro Eliminado");
                 * this.btnEliminar.setEnabled(false);
                 * this.txtNumControl.setText("");
                 * this.txtNumControl.requestFocus();
                 * }
                 */
        }

        private void editar() {
                String numControl = this.txtNumControl.getText();
                String nombre = this.txtNombre.getText();
                String apellidos = this.txtApellidos.getText();
                int semestre = Integer.parseInt(this.cboSemestre.getSelectedItem().toString());
                char grupo;
                if (this.rdbtnGrupoA.isSelected())
                        grupo = 'A';
                else if (this.rdbtnGrupoB.isSelected())
                        grupo = 'B';
                else
                        grupo = 'C';
                String carrera = this.cboCarrera.getSelectedItem().toString();

                // Actualizar el registro
                this.objControladorCRUDEst.guardarRegistro(numControl, nombre, apellidos, semestre, grupo, carrera);
                JOptionPane.showMessageDialog(this, "Registro actualizado con éxito");
                this.objControladorCRUDEst.objVistaCRUDEst.actualizarTabla();
                // Limpiar y deshabilitar campos
                this.txtNumControl.setText("");
                this.txtNombre.setText("");
                this.txtApellidos.setText("");
                this.des_habilitaComponentes(false);
                this.txtNumControl.requestFocus();
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rdbtnGrupoA;
    private javax.swing.JRadioButton rdbtnGrupoB;
    private javax.swing.JRadioButton rdbtnGrupoC;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumControl;
    // End of variables declaration//GEN-END:variables
}