/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.beans;

import java.util.List;

/**
 *
 * @author lfleming
 */
public class Venda {
    private Usuario cliente;
    private List<VendaProduto> produtos;
    private float valor;

    public float getValor() {
        if (valor == 0.0) {
            for(VendaProduto vp : produtos) {
                valor += vp.getValor();
            }
        }
        return valor;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<VendaProduto> getProdutos() {
        return produtos;
    }

    public void setProduto(VendaProduto produto) {
        this.produtos.add(produto);
    }
    
    
    
}
