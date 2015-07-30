/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.controller;

import rc.unesp.br.lcp.beans.Produto;
import rc.unesp.br.lcp.database.ProdutoEntity;

/**
 *
 * @author lfleming
 */
public class CadastroProdutoController {
  
  public boolean cadastrarProduto(Produto p) {
    boolean resultado = false;
    
    if (! p.getNome().isEmpty() && 
        ! p.getCategoria().isEmpty() &&
        p.getQuantidade() > 0 &&
        p.getValor() > 0 &&
        ! p.getCodigo().isEmpty()) {
      
      ProdutoEntity pe = new ProdutoEntity();
      resultado = pe.inserir(p) != null;
    }
    
    
    return resultado;
  }
  
}
