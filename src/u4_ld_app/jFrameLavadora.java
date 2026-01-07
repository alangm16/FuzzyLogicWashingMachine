/*:-----------------------------------------------------------------------------
 *:                       INSTITUTO TECNOLOGICO DE LA LAGUNA
 *:                     INGENIERIA EN SISTEMAS COMPUTACIONALES
 *:                            INTELIGENCIA ARTIFICIAL           
 *: 
 *:                  SEMESTRE: ENE-JUN/2024     HORA: 11:00 - 12:00 HRS
 *:                                   
 *:               
 *:              jFrame donde se realiza la manipulación de los datos.
 *                 
 *:                           
 *: Archivo       : LogicaDifusa.java
 *:
 *: Autor         : Alan Yahir J. Gómez Mireles       
 *:
 *: Fecha         : 01 / Mayo / 2024
 *:
 *: Compilador    : Java JDK 8.2
 *:
 *: Descripción   : jFrame para realizar la manipulación de los datos 
 *:                 y generar los resultados.
 *: 
 *:-----------------------------------------------------------------------------*/

package u4_ld_app;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class jFrameLavadora extends javax.swing.JFrame {
    
    // -------------------------------------------------------------------------
    
    // Método para poner un icono en el frame
    @Override
    public Image getIconImage ( ) 
    {
       Image retValue = Toolkit.getDefaultToolkit ( )
               .getImage ( ClassLoader.getSystemResource ( "imagenes/ld.png" ) );

       return retValue;
    }
    
    // -------------------------------------------------------------------------

    public jFrameLavadora ( ) {
        initComponents ( );
        
        // Cargar Icono al frame
        setIconImage ( getIconImage ( ) );

        // Iniciar valores de jSlider
        jSliderTipoTela.setValue ( 0 );
        jSliderSuciedadRopa.setValue ( 0 );
        jSliderPesoRopa.setValue ( 0 );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTiempoLavado = new javax.swing.ButtonGroup();
        buttonGroupTemperatura = new javax.swing.ButtonGroup();
        buttonGroupTiempoSecado = new javax.swing.ButtonGroup();
        buttonGroupRPM = new javax.swing.ButtonGroup();
        buttonGroupCalidadLavado = new javax.swing.ButtonGroup();
        jSliderTipoTela = new javax.swing.JSlider();
        jSliderSuciedadRopa = new javax.swing.JSlider();
        jSliderPesoRopa = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButTLMC = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButTLC = new javax.swing.JRadioButton();
        jRadioButTLM = new javax.swing.JRadioButton();
        jRadioButTLL = new javax.swing.JRadioButton();
        jRadioButTLML = new javax.swing.JRadioButton();
        jRadioButTempFria = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButTempTibia = new javax.swing.JRadioButton();
        jRadioButTempCaliente = new javax.swing.JRadioButton();
        jRadioButTSMC = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jRadioButTSC = new javax.swing.JRadioButton();
        jRadioButTSM = new javax.swing.JRadioButton();
        jRadioButTSL = new javax.swing.JRadioButton();
        jRadioButTSML = new javax.swing.JRadioButton();
        jRadioButRPMB = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jRadioButRPMM = new javax.swing.JRadioButton();
        jRadioButRPMA = new javax.swing.JRadioButton();
        jRadioButCLB = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jRadioButCLM = new javax.swing.JRadioButton();
        jRadioButCLA = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jButAccion = new javax.swing.JButton();
        jSpinTipoTela = new javax.swing.JSpinner();
        jSpinSuciedadRopa = new javax.swing.JSpinner();
        jSpinPesoRopa = new javax.swing.JSpinner();
        jTextTL = new javax.swing.JTextField();
        jTextTemperatura = new javax.swing.JTextField();
        jTextTS = new javax.swing.JTextField();
        jTextRPM = new javax.swing.JTextField();
        jTextCL = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("U4 - LogicaDifusa - Lavadora");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSliderTipoTela.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderTipoTela.setValue(0);
        jSliderTipoTela.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderTipoTelaStateChanged(evt);
            }
        });
        getContentPane().add(jSliderTipoTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 35, 120));

        jSliderSuciedadRopa.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderSuciedadRopa.setValue(0);
        jSliderSuciedadRopa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSuciedadRopaStateChanged(evt);
            }
        });
        getContentPane().add(jSliderSuciedadRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 35, 120));

        jSliderPesoRopa.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderPesoRopa.setValue(0);
        jSliderPesoRopa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPesoRopaStateChanged(evt);
            }
        });
        getContentPane().add(jSliderPesoRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 35, 120));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Control de Lógica Difusa para una Lavadora");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entradas");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 270, -1));

        jLabel3.setText("Tipo de Tela");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel4.setText("Nivel de Suciedad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel5.setText("Peso de la Ropa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        buttonGroupTiempoLavado.add(jRadioButTLMC);
        jRadioButTLMC.setText("Muy Corto");
        getContentPane().add(jRadioButTLMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel6.setText("Tiempo de Lavado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        buttonGroupTiempoLavado.add(jRadioButTLC);
        jRadioButTLC.setText("Corto");
        getContentPane().add(jRadioButTLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        buttonGroupTiempoLavado.add(jRadioButTLM);
        jRadioButTLM.setText("Medio");
        getContentPane().add(jRadioButTLM, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        buttonGroupTiempoLavado.add(jRadioButTLL);
        jRadioButTLL.setText("Largo");
        getContentPane().add(jRadioButTLL, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        buttonGroupTiempoLavado.add(jRadioButTLML);
        jRadioButTLML.setText("Muy Largo");
        getContentPane().add(jRadioButTLML, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        buttonGroupTemperatura.add(jRadioButTempFria);
        jRadioButTempFria.setText("Fria");
        getContentPane().add(jRadioButTempFria, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel7.setText("Temperatura");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        buttonGroupTemperatura.add(jRadioButTempTibia);
        jRadioButTempTibia.setText("Tibia");
        getContentPane().add(jRadioButTempTibia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        buttonGroupTemperatura.add(jRadioButTempCaliente);
        jRadioButTempCaliente.setText("Caliente");
        getContentPane().add(jRadioButTempCaliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        buttonGroupTiempoSecado.add(jRadioButTSMC);
        jRadioButTSMC.setText("Muy Corto");
        getContentPane().add(jRadioButTSMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jLabel8.setText("Tiempo de Secado");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        buttonGroupTiempoSecado.add(jRadioButTSC);
        jRadioButTSC.setText("Corto");
        jRadioButTSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButTSCActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButTSC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        buttonGroupTiempoSecado.add(jRadioButTSM);
        jRadioButTSM.setText("Medio");
        getContentPane().add(jRadioButTSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        buttonGroupTiempoSecado.add(jRadioButTSL);
        jRadioButTSL.setText("Largo");
        getContentPane().add(jRadioButTSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        buttonGroupTiempoSecado.add(jRadioButTSML);
        jRadioButTSML.setText("Muy Largo");
        getContentPane().add(jRadioButTSML, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        buttonGroupRPM.add(jRadioButRPMB);
        jRadioButRPMB.setText("Baja");
        getContentPane().add(jRadioButRPMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        jLabel9.setText("RPM");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        buttonGroupRPM.add(jRadioButRPMM);
        jRadioButRPMM.setText("Media");
        getContentPane().add(jRadioButRPMM, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        buttonGroupRPM.add(jRadioButRPMA);
        jRadioButRPMA.setText("Alta");
        getContentPane().add(jRadioButRPMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        buttonGroupCalidadLavado.add(jRadioButCLB);
        jRadioButCLB.setText("Baja");
        getContentPane().add(jRadioButCLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        jLabel10.setText("Calidad de Lavado");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        buttonGroupCalidadLavado.add(jRadioButCLM);
        jRadioButCLM.setText("Media");
        jRadioButCLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButCLMActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButCLM, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, -1, -1));

        buttonGroupCalidadLavado.add(jRadioButCLA);
        jRadioButCLA.setText("Alta");
        getContentPane().add(jRadioButCLA, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        jLabel11.setBackground(new java.awt.Color(102, 255, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Salidas");
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 25, 490, -1));

        jButAccion.setText("Iniciar");
        jButAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAccionActionPerformed(evt);
            }
        });
        getContentPane().add(jButAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 100, -1));

        jSpinTipoTela.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinTipoTelaStateChanged(evt);
            }
        });
        getContentPane().add(jSpinTipoTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 60, 30));

        jSpinSuciedadRopa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinSuciedadRopaStateChanged(evt);
            }
        });
        getContentPane().add(jSpinSuciedadRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 60, 30));

        jSpinPesoRopa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinPesoRopaStateChanged(evt);
            }
        });
        getContentPane().add(jSpinPesoRopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 60, 30));

        jTextTL.setEditable(false);
        getContentPane().add(jTextTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 75, -1));

        jTextTemperatura.setEditable(false);
        getContentPane().add(jTextTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 75, -1));

        jTextTS.setEditable(false);
        getContentPane().add(jTextTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 75, -1));

        jTextRPM.setEditable(false);
        getContentPane().add(jTextRPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 75, -1));

        jTextCL.setEditable(false);
        getContentPane().add(jTextCL, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 75, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 750, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAccionActionPerformed
        // Botón para realizar el cálculo de los valores y evaluar el sistema.
        
        try {
            
            // Variables donde guardamos los valores de las entradas registradas
            double tipoTela = ( int ) jSpinTipoTela.getValue ( );
            double suciedadRopa = ( int ) jSpinSuciedadRopa.getValue ( );
            double pesoRopa = ( int ) jSpinPesoRopa.getValue ( );
            
            // Se evalua el sistema con el método evaluar de la clase LogicaDifusa
            LavadoraFuzzyController controller = new LavadoraFuzzyController();
            double[] output = controller.calculateOutput(tipoTela, suciedadRopa, pesoRopa);
            // Se muestran los resultados en sus correspondientes jText
            
            DecimalFormat df = new DecimalFormat("#.##");
            this.jTextTL.setText ( df.format(output[0]) + " min" );
            this.jTextTemperatura.setText ( df.format(output[1]) + " °C" );
            this.jTextTS.setText ( df.format(output[2]) + " min" );
            this.jTextRPM.setText ( df.format(output[3]) + " rpm" );
            this.jTextCL.setText ( df.format(output[4]) + " Nivel" );
            
            if ( output[0] < 10 ) {
                jRadioButTLMC.setSelected(true);
                jRadioButTSMC.setSelected(true);
            } else if (output[0] > 5 & output[0] < 25) {
                jRadioButTLC.setSelected(true);
                jRadioButTSC.setSelected(true);
            } else if (output[0] > 20 & output[0] < 40) {
                jRadioButTLM.setSelected(true);
                jRadioButTSM.setSelected(true);
            } else if (output[0] > 35 & output[0] < 55) {
                jRadioButTLL.setSelected(true);
                jRadioButTSL.setSelected(true);
            } else if (output[0] > 50 & output[0] < 60) {
                jRadioButTLML.setSelected(true);
                jRadioButTSML.setSelected(true);
            }
            
            if ( output[1] < 30 ) {
                jRadioButTempFria.setSelected(true);
            } else if ( output[1] > 25 & output[1] < 50) {
                jRadioButTempTibia.setSelected(true);
            } else if ( output[1] > 45 & output[1] < 60) {
                jRadioButTempCaliente.setSelected(true);
            }
            
            if ( output[3] < 600 ) {
                jRadioButRPMB.setSelected(true);
            } else if ( output[3] > 400 & output[3] < 1200) {
                jRadioButRPMM.setSelected(true);
            } else if ( output[3] > 1000 & output[3] < 1600) {
                jRadioButRPMA.setSelected(true);
            }
            
            if ( output[4] < 50 ) {
                jRadioButCLB.setSelected(true);
            } else if ( output[4] > 10 & output[4] < 90) {
                jRadioButCLM.setSelected(true);
            } else if ( output[4] > 50 & output[4] < 100) {
                jRadioButCLA.setSelected(true);
            }
            
        } catch ( NumberFormatException e ) {
            JOptionPane.showMessageDialog ( this, "Alguna entrada no es correcta" );
        } 
        
    }//GEN-LAST:event_jButAccionActionPerformed

    private void jRadioButTSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButTSCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButTSCActionPerformed

    private void jRadioButCLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButCLMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButCLMActionPerformed

    private void jSpinTipoTelaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinTipoTelaStateChanged
        // Ligar valores de el jSpin con el jSlider
        int value = ( Integer ) ( ( JSpinner ) evt.getSource ( ) ) . getValue ( );
        jSliderTipoTela.setValue ( value );
    }//GEN-LAST:event_jSpinTipoTelaStateChanged

    private void jSliderTipoTelaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderTipoTelaStateChanged
        // Ligar valores de el jSplider con el jSpin
        int value = ( Integer ) ( ( JSlider ) evt.getSource ( ) ) . getValue ( );
        jSpinTipoTela.setValue( value );
    }//GEN-LAST:event_jSliderTipoTelaStateChanged

    private void jSpinSuciedadRopaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinSuciedadRopaStateChanged
        // Ligar valores de el jSpin con el jSlider
        int value = ( Integer ) ( ( JSpinner ) evt.getSource ( ) ) . getValue ( );
        jSliderSuciedadRopa.setValue ( value );
    }//GEN-LAST:event_jSpinSuciedadRopaStateChanged

    private void jSliderSuciedadRopaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSuciedadRopaStateChanged
        // Ligar valores de el jSplider con el jSpin
        int value = ( Integer ) ( ( JSlider ) evt.getSource ( ) ) . getValue ( );
        jSpinSuciedadRopa.setValue ( value );
    }//GEN-LAST:event_jSliderSuciedadRopaStateChanged

    private void jSpinPesoRopaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinPesoRopaStateChanged
        // Ligar valores de el jSpin con el jSlider
        int value = ( Integer ) ( ( JSpinner ) evt.getSource ( ) ) . getValue ( );
        jSliderPesoRopa.setValue ( value );
    }//GEN-LAST:event_jSpinPesoRopaStateChanged

    private void jSliderPesoRopaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPesoRopaStateChanged
        // Ligar valores de el jSplider con el jSpin
        int value = ( Integer ) ( ( JSlider ) evt.getSource ( ) ) . getValue ( );
        jSpinPesoRopa.setValue ( value );
    }//GEN-LAST:event_jSliderPesoRopaStateChanged

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrameLavadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameLavadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameLavadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameLavadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameLavadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCalidadLavado;
    private javax.swing.ButtonGroup buttonGroupRPM;
    private javax.swing.ButtonGroup buttonGroupTemperatura;
    private javax.swing.ButtonGroup buttonGroupTiempoLavado;
    private javax.swing.ButtonGroup buttonGroupTiempoSecado;
    private javax.swing.JButton jButAccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButCLA;
    private javax.swing.JRadioButton jRadioButCLB;
    private javax.swing.JRadioButton jRadioButCLM;
    private javax.swing.JRadioButton jRadioButRPMA;
    private javax.swing.JRadioButton jRadioButRPMB;
    private javax.swing.JRadioButton jRadioButRPMM;
    private javax.swing.JRadioButton jRadioButTLC;
    private javax.swing.JRadioButton jRadioButTLL;
    private javax.swing.JRadioButton jRadioButTLM;
    private javax.swing.JRadioButton jRadioButTLMC;
    private javax.swing.JRadioButton jRadioButTLML;
    private javax.swing.JRadioButton jRadioButTSC;
    private javax.swing.JRadioButton jRadioButTSL;
    private javax.swing.JRadioButton jRadioButTSM;
    private javax.swing.JRadioButton jRadioButTSMC;
    private javax.swing.JRadioButton jRadioButTSML;
    private javax.swing.JRadioButton jRadioButTempCaliente;
    private javax.swing.JRadioButton jRadioButTempFria;
    private javax.swing.JRadioButton jRadioButTempTibia;
    private javax.swing.JSlider jSliderPesoRopa;
    private javax.swing.JSlider jSliderSuciedadRopa;
    private javax.swing.JSlider jSliderTipoTela;
    private javax.swing.JSpinner jSpinPesoRopa;
    private javax.swing.JSpinner jSpinSuciedadRopa;
    private javax.swing.JSpinner jSpinTipoTela;
    private javax.swing.JTextField jTextCL;
    private javax.swing.JTextField jTextRPM;
    private javax.swing.JTextField jTextTL;
    private javax.swing.JTextField jTextTS;
    private javax.swing.JTextField jTextTemperatura;
    // End of variables declaration//GEN-END:variables
}
