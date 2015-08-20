/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.controller;

import rc.unesp.br.lcp.beans.Usuario;
import rc.unesp.br.lcp.database.UsuarioEntity;

/**
 *
 * @author lfleming
 */
public class CadastroClienteController {
  
  public boolean cadastrarCliente(Usuario u) {
    boolean resultado = false;
    if (! u.getNome().isEmpty() && 
        ! u.getEmail().isEmpty() &&
        ! u.getEndereco().isEmpty() &&
        ! u.getCpf().isEmpty() &&
        ! u.getCelular().isEmpty()) {
      
      UsuarioEntity ue = new UsuarioEntity();
      resultado = ue.inserir(u) != null;
    }
    
    return resultado;
  }
  
  public boolean cadastrarAdmin(Usuario u) {
    boolean resultado = false;
    if (! u.getNome().isEmpty() && 
        ! u.getEmail().isEmpty() &&
        ! u.getSenha().isEmpty() &&
        ! u.getCpf().isEmpty()) {
      u.setTipo(1);
      UsuarioEntity ue = new UsuarioEntity();
      resultado = ue.inserir(u) != null;
    }
    
    return resultado;
  }
  
}
