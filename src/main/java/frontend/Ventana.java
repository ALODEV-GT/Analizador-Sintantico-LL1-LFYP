package frontend;

import analizador.AutomataFinitoDeterminista;
import analizador.Buscador;
import analizador.Archivo;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    FileOutputStream salida;
    private AutomataFinitoDeterminista afd = null;

    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.taTransiciones.setEditable(false);
        this.taErrores.setEditable(false);
        this.btnVerTokens.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnVerTokens = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnGuardarArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCodigoFuente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTransiciones = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taErrores = new javax.swing.JTextArea();
        bntCargarDatos = new javax.swing.JButton();
        tfPalabraClave = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1050, 650));
        setMinimumSize(new java.awt.Dimension(1050, 650));
        setResizable(false);

        pnlBackground.setMaximumSize(new java.awt.Dimension(1050, 650));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1050, 650));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANALIZADOR LEXICO");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnVerTokens.setText("VER TOKENS");
        btnVerTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTokensActionPerformed(evt);
            }
        });

        btnAnalizar.setText("ANALIZAR");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnGuardarArchivo.setText("GUARDAR ARCHIVO");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnVerTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarArchivo)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnVerTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        taCodigoFuente.setColumns(20);
        taCodigoFuente.setRows(5);
        jScrollPane1.setViewportView(taCodigoFuente);

        taTransiciones.setColumns(20);
        taTransiciones.setRows(5);
        jScrollPane2.setViewportView(taTransiciones);

        taErrores.setColumns(20);
        taErrores.setRows(5);
        jScrollPane3.setViewportView(taErrores);

        bntCargarDatos.setText("CARGAR ARCHIVO");
        bntCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCargarDatosActionPerformed(evt);
            }
        });

        tfPalabraClave.setMaximumSize(new java.awt.Dimension(35, 200));
        tfPalabraClave.setMinimumSize(new java.awt.Dimension(35, 200));
        tfPalabraClave.setPreferredSize(new java.awt.Dimension(35, 200));

        btnBuscar.setText("BUSCAR");
        btnBuscar.setMaximumSize(new java.awt.Dimension(128, 35));
        btnBuscar.setMinimumSize(new java.awt.Dimension(128, 35));
        btnBuscar.setPreferredSize(new java.awt.Dimension(128, 35));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(bntCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(tfPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntCargarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCargarDatosActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            Archivo cargarArchivo = new Archivo(archivo);
            cargarArchivo.mostrarLineas(taCodigoFuente);
        }
    }//GEN-LAST:event_bntCargarDatosActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        btnVerTokens.setEnabled(false);
        AutomataFinitoDeterminista afd = new AutomataFinitoDeterminista(taCodigoFuente);
        afd.analizar(taTransiciones);
        afd.mostrarErrores(taErrores);
        this.afd = afd;
        if (taErrores.getText().isBlank() && !taCodigoFuente.getText().isBlank()) {
            btnVerTokens.setEnabled(true);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnVerTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTokensActionPerformed
        VentanaToken vt = new VentanaToken(this, true, afd);
        vt.setVisible(true);
    }//GEN-LAST:event_btnVerTokensActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String palabraClave = tfPalabraClave.getText();

        if (!palabraClave.isBlank() && !taCodigoFuente.getText().isBlank()) {
            Buscador buscar = new Buscador(taCodigoFuente, palabraClave);
            try {
                buscar.buscarCoincidencias();
            } catch (IndexOutOfBoundsException ex) {
                //nada por hacer
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showDialog(null, "Guardar");

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            String documento = taCodigoFuente.getText();
            boolean guardado = new Archivo().guardarArchivo(archivo, documento);
            if (guardado) {
                JOptionPane.showMessageDialog(null, "Archivo guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
            }
        }
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCargarDatos;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnVerTokens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextArea taCodigoFuente;
    private javax.swing.JTextArea taErrores;
    private javax.swing.JTextArea taTransiciones;
    private javax.swing.JTextField tfPalabraClave;
    // End of variables declaration//GEN-END:variables
}
