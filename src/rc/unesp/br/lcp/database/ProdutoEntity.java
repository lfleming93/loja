/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import rc.unesp.br.lcp.beans.Produto;

/**
 *
 * @author lfleming
 */
public class ProdutoEntity extends IEntity<Produto> {
    
    public static String tableName = "produtos";

        
    @Override
    protected Produto converterResultSet(ResultSet rs) {
        try {
            Produto p = new Produto();
            
            p.setId(rs.getInt("id"));
            
            if (rs.getString("nome") != null) {
                p.setNome(rs.getString("nome"));
            }
            if (rs.getString("categoria") != null) {
                p.setCategoria(rs.getString("categoria"));
            }
            if (rs.getString("codigo") != null) {
                p.setCodigo(rs.getString("codigo"));
            }
            
            p.setQuantidade(rs.getInt("quantidade"));
            
            p.setValor(rs.getDouble("valor")); 
            

            return p;
        }
        catch(SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        
        return null;
        
    }
    
    @Override
    protected String converterEntidade(Produto p) {
        String select = String.format(
            "(nome, categoria, codigo, quantidade, valor)" +
            " values ('%s', '%s', '%s', %d, %f)",
            p.getNome(), p.getCategoria(), p.getCodigo(), p.getQuantidade(),
            p.getValor()
        );
        
        return select;
    }
    
    @Override
    protected String converterEntidadeUpdate(Produto p) {
        String select = String.format(
            "nome='%s' " +
            "categoria='%s' " +
            "codigo='%s' " +
            "quantidade=%d " +
            "valor=%f ",
            p.getNome(),
            p.getCategoria(),
            p.getCodigo(),
            p.getQuantidade(),
            p.getValor()
        );
                
        
        return select;
    }
    
    
}
