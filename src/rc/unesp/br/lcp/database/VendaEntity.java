/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rc.unesp.br.lcp.beans.Venda;
import rc.unesp.br.lcp.beans.VendaProduto;

/**
 *
 * @author lfleming
 */
public class VendaEntity extends IEntity<Venda> {
    public static String tableName = "produtos";

  public VendaEntity() {
    super(tableName);
  }
    
    @Override
    public Venda inserir(Venda v) {
      Venda vendaSalva = super.inserir(v);
      
      VendaProdutoEntity vpEntity = new VendaProdutoEntity();
      for (VendaProduto vp : v.getProdutos()) {
        vendaSalva.setProduto(vpEntity.inserir(vp));
      }
      return vendaSalva;
    }

    @Override
    public int atualizar(Venda v) {
      int result = super.atualizar(v);
      if (result != 0 ) {
        VendaProdutoEntity vpEntity = new VendaProdutoEntity();
        for (VendaProduto vp : v.getProdutos()) {
          vpEntity.atualizar(vp);
        }
      }
      return result;
    }
        
    @Override
    protected Venda converterResultSet(ResultSet rs) {
        try {
            Venda v = new Venda();
            
            v.setId(rs.getInt("id"));
            
            v.setCliente(rs.getInt("cliente_id"));

            return v;
        }
        catch(SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        
        return null;
        
    }
    
    @Override
    protected String converterEntidade(Venda v) {
        String select = String.format(
            "(cliente_id)" +
            " values (%d)",
            v.getClienteId()
        );
        
        return select;
    }
    
    @Override
    protected String converterEntidadeUpdate(Venda v) {
        String select = String.format(
            "cliente_id=%d " +
            v.getClienteId()            
        );
                
        
        return select;
    }
    
}
