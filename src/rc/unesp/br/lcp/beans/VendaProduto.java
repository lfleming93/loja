/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.beans;

/**
 *
 * @author lfleming
 */
public class VendaProduto {
    private int quantidade;
    private Produto produto;
    private float valor;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getValor() {
        if (valor == 0.0) {
            valor = produto.getValor() * quantidade;
        }
        
        return valor;
    }
       
}
