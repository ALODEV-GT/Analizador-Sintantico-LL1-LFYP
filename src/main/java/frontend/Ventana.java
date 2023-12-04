package frontend;

import AnalizadorSintactico.automataDePila.AutomataDePila;
import Funcionalidad.PilaDeshacer;
import analizadorLexico.AutomataFinitoDeterminista;
import analizadorLexico.Buscador;
import analizadorLexico.Archivo;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Ventana extends javax.swing.JFrame {

    private AutomataFinitoDeterminista afd = null;
    private File archivoActual = null;
    private Document documento = null;
    private final PilaDeshacer cambiosDeshacer = new PilaDeshacer();
    private boolean modificado = false;

    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Deshabilitar las areas que no son editables
        this.taPila.setEditable(false);
        this.taErrores.setEditable(false);

        //Desactivar boton "Ver tokens"
        this.btnVerTokens.setEnabled(false);

        //Agregar listener de cambios en el documento
        ListenerCambiosCodigoFuente evento = new ListenerCambiosCodigoFuente();
        this.documento = taCodigoFuente.getDocument();
        documento.addDocumentListener(evento);

        //Estado inicial de la pila
        cambiosDeshacer.agregarCambio(taCodigoFuente.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnVerTokens = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnAnalisisSintactico = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCodigoFuente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taPila = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taErrores = new javax.swing.JTextArea();
        tfPalabraClave = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiAbrir = new javax.swing.JMenu();
        jmiNuevo = new javax.swing.JMenuItem();
        jmiGuardar = new javax.swing.JMenuItem();
        jmiGuardarComo = new javax.swing.JMenuItem();
        jmiDeshacer = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 650));
        setResizable(false);

        pnlBackground.setMaximumSize(new java.awt.Dimension(1050, 650));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1050, 650));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ANALIZADOR LEXICO Y SINTACTICO");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnVerTokens.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
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

        btnAnalisisSintactico.setText("SINTACTICO");
        btnAnalisisSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisSintacticoActionPerformed(evt);
            }
        });

        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });

        btnPegar.setText("Pegar");
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarActionPerformed(evt);
            }
        });

        btnDeshacer.setText("Deshacer");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(btnCopiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnVerTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalisisSintactico)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalisisSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        taCodigoFuente.setColumns(20);
        taCodigoFuente.setRows(5);
        jScrollPane1.setViewportView(taCodigoFuente);

        taPila.setColumns(20);
        taPila.setRows(5);
        jScrollPane2.setViewportView(taPila);

        taErrores.setColumns(20);
        taErrores.setRows(5);
        jScrollPane3.setViewportView(taErrores);

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
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
                .addGap(0, 495, Short.MAX_VALUE))
        );

        jmiAbrir.setText("Archivo");

        jmiNuevo.setText("Abrir");
        jmiNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoActionPerformed(evt);
            }
        });
        jmiAbrir.add(jmiNuevo);

        jmiGuardar.setText("Nuevo");
        jmiGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardarActionPerformed(evt);
            }
        });
        jmiAbrir.add(jmiGuardar);

        jmiGuardarComo.setText("Guardar");
        jmiGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardarComoActionPerformed(evt);
            }
        });
        jmiAbrir.add(jmiGuardarComo);

        jmiDeshacer.setText("Guardar como");
        jmiDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeshacerActionPerformed(evt);
            }
        });
        jmiAbrir.add(jmiDeshacer);

        jMenuItem7.setText("Acerca de");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmiAbrir.add(jMenuItem7);

        jMenuBar1.add(jmiAbrir);

        setJMenuBar(jMenuBar1);

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

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        btnVerTokens.setEnabled(false);
        AutomataFinitoDeterminista afd = new AutomataFinitoDeterminista(taCodigoFuente);
        afd.analizar();
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

    private void btnAnalisisSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisSintacticoActionPerformed
        AutomataDePila adp = new AutomataDePila(afd.obtenerTokens());
        taPila.setText("");
        adp.analizar(taPila);
        adp.mostrarErrores(taErrores);
    }//GEN-LAST:event_btnAnalisisSintacticoActionPerformed

    private void jmiNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);

        if (modificado) {
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                OpcionesDoc ventanaOpciones = new OpcionesDoc(this, true, false);
                ventanaOpciones.setVisible(true);
                File archivo = fileChosser.getSelectedFile();
                this.archivoActual = archivo;
                this.cambiarTituloVentana(archivo.getName());
                Archivo cargarArchivo = new Archivo(archivo);
                cargarArchivo.mostrarLineas(taCodigoFuente);
                cambiosDeshacer.vaciarPila();
                cambiosDeshacer.agregarCambio(taCodigoFuente.getText());
            }
        } else {
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChosser.getSelectedFile();
                this.archivoActual = archivo;
                this.cambiarTituloVentana(archivo.getName());
                Archivo cargarArchivo = new Archivo(archivo);
                cargarArchivo.mostrarLineas(taCodigoFuente);
                cambiosDeshacer.vaciarPila();
                cambiosDeshacer.agregarCambio(taCodigoFuente.getText());
            }
        }

    }//GEN-LAST:event_jmiNuevoActionPerformed

    private void jmiDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeshacerActionPerformed
        this.guardarComo(null);
    }//GEN-LAST:event_jmiDeshacerActionPerformed

    private void jmiGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardarComoActionPerformed
        this.guardar(null);
    }//GEN-LAST:event_jmiGuardarComoActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JOptionPane.showMessageDialog(this, "Autor: ALODEV", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        this.taCodigoFuente.copy();
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void btnPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarActionPerformed
        this.taCodigoFuente.paste();
    }//GEN-LAST:event_btnPegarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try {
            this.taCodigoFuente.setText(cambiosDeshacer.obtenerCima());
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            btnDeshacer.setEnabled(false);
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void jmiGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardarActionPerformed
        if (modificado) {
            OpcionesDoc ventanaOpciones = new OpcionesDoc(this, true, true);
            ventanaOpciones.setVisible(true);
        } else {
            this.reiniciarDoc();
            reiniciarDoc();
        }

    }//GEN-LAST:event_jmiGuardarActionPerformed

    public void guardarComo(OpcionesDoc opciones) {
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showDialog(null, "Guardar como");

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            this.archivoActual = archivo;
            this.cambiarTituloVentana(archivo.getName());
            String documento = taCodigoFuente.getText();
            boolean guardado = new Archivo().guardarArchivo(archivo, documento);
            if (guardado) {
                JOptionPane.showMessageDialog(null, "Archivo guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
            }
            modificado = false;
            if (opciones != null) {
                reiniciarDoc();
                opciones.dispose();
            }
        }
    }

    public void guardar(OpcionesDoc opciones) {
        if (opciones != null) {
            opciones.dispose();
        }

        if (archivoActual == null) {
            this.guardarComo(opciones);
        } else {
            String contenido = taCodigoFuente.getText();
            boolean guardado = new Archivo().guardarArchivo(archivoActual, contenido);
            if (guardado) {
                JOptionPane.showMessageDialog(null, "Cambios guardados");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
            }
            if (opciones != null) {
                reiniciarDoc();
            }
            modificado = false;
        }
    }

    public void reiniciarDoc() {
        this.taCodigoFuente.setText("");
        this.setTitle("");
        this.archivoActual = null;
        modificado = false;
    }

    private void cambiarTituloVentana(String nombreArchivo) {
        this.setTitle(nombreArchivo);
    }

    private class ListenerCambiosCodigoFuente implements DocumentListener {

        ListenerCambiosCodigoFuente() {

        }

        Temporizador temporizador = new Temporizador();

        @Override
        public void insertUpdate(DocumentEvent de) {
            modificado = true;
            if (!temporizador.isAlive()) {
                temporizador = new Temporizador();
                temporizador.start();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            modificado = true;
            if (!temporizador.isAlive()) {
                temporizador = new Temporizador();
                temporizador.start();
            }
        }

        @Override
        public void changedUpdate(DocumentEvent de) {

        }

    }

    private class Temporizador extends Thread {

        @Override
        public void run() {

            for (int i = 2; i > 0; i--) {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println("Ocurrio un error con el hilo Temporizador");
                }
            }

            cambiosDeshacer.agregarCambio(taCodigoFuente.getText());
            btnDeshacer.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisisSintactico;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnVerTokens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu jmiAbrir;
    private javax.swing.JMenuItem jmiDeshacer;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JMenuItem jmiGuardarComo;
    private javax.swing.JMenuItem jmiNuevo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextArea taCodigoFuente;
    private javax.swing.JTextArea taErrores;
    private javax.swing.JTextArea taPila;
    private javax.swing.JTextField tfPalabraClave;
    // End of variables declaration//GEN-END:variables
}
