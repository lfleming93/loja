/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import rc.unesp.br.lcp.beans.Usuario;
import rc.unesp.br.lcp.database.UsuarioEntity;

/**
 *
 * @author lfleming
 */
public class EditarCliente extends javax.swing.JInternalFrame {
  List<Usuario> usuarios = new ArrayList<>();

  /**
   * Creates new form EditarCliente
   */
  public EditarCliente() {
    initComponents();
    
    UsuarioEntity ue = new UsuarioEntity();
    usuarios = ue.buscarTodosClientes();
    
    for (Usuario u : usuarios) {
      jComboBox1.addItem(u.getNome());
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jComboBox1 = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();

    setClosable(true);

    jButton1.setText("Editar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(37, 37, 37)
        .addComponent(jButton1)
        .addContainerGap(52, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(52, 52, 52)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1))
        .addContainerGap(58, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Usuario u = usuarios.get(jComboBox1.getSelectedIndex());
    cadastroCliente cc = new cadastroCliente(u);
    Dimension desktopSize = getParent().getSize();
    Dimension jInternalFrameSize = cc.getSize();
    cc.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
    cc.setVisible(true);
    getParent().add(cc);
    cc.toFront();
    this.doDefaultCloseAction();
  }//GEN-LAST:event_jButton1ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JComboBox jComboBox1;
  // End of variables declaration//GEN-END:variables
}