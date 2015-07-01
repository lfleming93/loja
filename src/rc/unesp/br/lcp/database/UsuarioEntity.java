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
import rc.unesp.br.lcp.beans.Usuario;

/**
 *
 * @author lfleming
 */
public class UsuarioEntity extends IEntity<Usuario> {
    
    public static String tableName = "usuarios";
    
    public Usuario buscarPorCpf(String cpf) {
        
        String select = "select * from usuarios where cpf='" + cpf + "'";
        
        return buscar(select);
        
    }
        
    @Override
    protected Usuario converterResultSet(ResultSet rs) {
        try {
            Usuario u = new Usuario();
            
            u.setId(rs.getInt("id"));
            
            if (rs.getString("nome") != null) {
                u.setNome(rs.getString("nome"));
            }
            if (rs.getString("email") != null) {
                u.setEmail(rs.getString("email"));
            }
            if (rs.getString("endereco") != null) {
                u.setEndereço(rs.getString("endereco"));
            }
            if (rs.getString("telefone") != null) {
                u.setTelefone(rs.getString("telefone"));
            }
            if (rs.getString("celular") != null) {
                u.setCelular(rs.getString("celular"));
            }
            if (rs.getString("cpf") != null) {
                u.setCpf(rs.getString("cpf"));
            }
            
            u.setTipo(rs.getInt("tipo"));
            
            if (rs.getString("senha") != null) {
                u.setSenha(rs.getString("senha")); 
            }

            return u;
        }
        catch(SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        
        return null;
        
    }
    
    @Override
    protected String converterEntidade(Usuario u) {
        String select = String.format(
            "(nome, email, endereco, cpf, telefone, celular, tipo, senha)" +
            " values ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s')",
            u.getNome(), u.getEmail(), u.getEndereço(), u.getCpf(),
            u.getTelefone(), u.getCelular(), u.getTipo(), u.getSenha()
        );
        
        return select;
    }
    
    @Override
    protected String converterEntidadeUpdate(Usuario u) {
        String select = String.format(
            "nome='%s' " +
            "email='%s' " +
            "endereco='%s' " +
            "cpf='%s' " +
            "telefone='%s' " +
            "celular='%s' " +
            "tipo=%d " +
            "senha='%s' ",
            u.getNome(),
            u.getEmail(),
            u.getEndereço(),
            u.getCpf(),
            u.getTelefone(),
            u.getCelular(),
            u.getTipo(),
            u.getSenha()
        );
                
        
        return select;
    }
    
}
