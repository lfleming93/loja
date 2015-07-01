/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.beans;

import java.util.List;
import rc.unesp.br.lcp.database.UsuarioEntity;

/**
 *
 * @author lfleming
 */
public class Venda implements Entidade {
    private int id;
    private Usuario cliente;
    private List<VendaProduto> produtos;
    private float valor;
    
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

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
    
    
    public int getClienteId() {
        int id = 0;
        if (cliente != null) {
            id = cliente.getId();
        }
        return id;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    
    public void setCliente(int id) {
        UsuarioEntity ue = new UsuarioEntity();
        this.cliente = ue.buscarPorId(id);
    }

    public List<VendaProduto> getProdutos() {
        return produtos;
    }

    public void setProduto(VendaProduto produto) {
        this.produtos.add(produto);
    }
    
    
    
}
