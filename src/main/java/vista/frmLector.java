/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Archivo;
import modelo.MantenimientoControlGeneral;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ronal
 */
public class frmLector extends javax.swing.JFrame {

    private Archivo ar = new Archivo();

    /**
     * Creates new form frmLector
     */
    private frmLector() {
        initComponents();
        setSize(470, 420);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAbrir = new javax.swing.JButton();
        txtAbrir = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmbCaracter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbEstructuraArchivo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 200));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        txtAbrir.setEditable(false);
        getContentPane().add(txtAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 320, 30));

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 440, 260));

        jLabel2.setText("Caracter que separa las columnas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cmbCaracter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ",", ".", "+", "/", " " }));
        getContentPane().add(cmbCaracter, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 60, 20));

        jLabel1.setText("Estructura de Archivo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cmbEstructuraArchivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTROL GENERAL", "HISTORIAL DE MANTENIMIENTO" }));
        getContentPane().add(cmbEstructuraArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed

        List<MantenimientoControlGeneral> lista = new ArrayList<>();
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        //Se asigna una ruta por defecto
        fc.setCurrentDirectory(new java.io.File((new File("").getAbsolutePath() + "/src/main/resources")));
        //TItulo de la venta a lanzar para escoger y navegar
        fc.setDialogTitle("Archivos separados por comas");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*CSV", "csv");
        //Le indicamos el filtro
        fc.setFileFilter(filtro);

        //Si se leccionamos la opcion abrir, procederemos a ejecutar lo siguiente
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

            String path = fc.getSelectedFile().getAbsolutePath();
            //Mostramos el path en consola y el JFrame
            System.out.println("Se selecciono " + path);
            txtAbrir.setText(path);
            try {
                ar.setCargarArchivo(path, cmbCaracter.getSelectedItem().toString(), cmbEstructuraArchivo.getSelectedItem().toString());
                lista = controlador.Archivo.getCargarArchivo();
            } catch (NullPointerException e) {
                System.out.println("Error" + e);
            }
            //imprimimos en el txtArea del JFrame, convertimos la lista Mantenimiento para poderla imprimir
            String texto = "";
            if (cmbEstructuraArchivo.getSelectedItem().toString().equals("CONTROL GENERAL")) {
                for (int i = 0; i < lista.size(); i++) {
                    texto += lista.get(i).getIdMantenimiento() + "\t" + lista.get(i).getHistorico()
                            + "\t" + lista.get(i).getMarca() + "\t" + lista.get(i).getNumeroSerie()
                            + "\t" + lista.get(i).getModelo() + "\t" + lista.get(i).getEncargado()
                            + "\t" + lista.get(i).getOs() + "\t" + lista.get(i).getVersion() + "\t" + lista.get(i).getArquitectura()
                            + "\t" + lista.get(i).isLicencia() + "\t" + lista.get(i).getObservaciones();
                }
            }else{
            System.out.print("Seleccione una estructura");
            }
            txtArea.setText(texto);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JComboBox<String> cmbCaracter;
    private javax.swing.JComboBox<String> cmbEstructuraArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAbrir;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
