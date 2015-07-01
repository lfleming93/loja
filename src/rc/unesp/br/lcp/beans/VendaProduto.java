/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.beans;

import rc.unesp.br.lcp.database.*;

/**
 *
 * @author lfleming
 */
public class VendaProduto implements Entidade {
    private int id;
    private int quantidade;
    private Produto produto;
    private Venda venda;
    private double valor;
    
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

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
    
    public void setProduto(int id) {
        ProdutoEntity pe = new ProdutoEntity();
        this.produto = pe.buscarPorId(id);
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public void setVenda(int id) {
        VendaEntity ve = new VendaEntity();
        this.venda = ve.buscarPorId(id);
    }

    public double getValor() {
        if (valor == 0.0) {
            valor = produto.getValor() * quantidade;
        }
        
        return valor;
    }
    
        
    public int getVendaId() {
        int id = 0;
        if (venda != null) {
            id = venda.getId();
        }
        return id;
    }

        
    public int getProdutoId() {
        int id = 0;
        if (produto != null) {
            id = produto.getId();
        }
        return id;
    }

       
}
