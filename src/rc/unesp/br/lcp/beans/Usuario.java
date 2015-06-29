/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.lcp.beans;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfleming
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String endereço;
    private String Telefone;
    private String celular;
    private String cpf;
    private int tipo; // 0 para usuário normal, 1 para admin
    private String senha; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public static Usuario buscaUsuario(String cpf) {
        try {
            DbHelper db = new DbHelper();
            String select = "select * from usuarios where cpf='" + cpf + "'";
            ResultSet rset = db.select(select);


            if(rset.next()) {
               return converteResultSetParaUsuario(rset);
            }
        }
        catch(Exception ex) {            
            ex.printStackTrace();
        }
        return null;
    }
    
    public static List<Usuario> buscaUsuarios() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            DbHelper db = new DbHelper();
            String select = "select * from usuarios";
            ResultSet rset = db.select(select);


            while(rset.next()) {
               users.add(converteResultSetParaUsuario(rset));
            }
        }
        catch(Exception ex) {            
            ex.printStackTrace();
        }
        return users;
        
    }
    
    public static Usuario insereUsuario(Usuario u) {
        String select = String.format("insert into usuarios " + 
            "(nome, email, endereco, cpf, telefone, celular, tipo, senha)" +
            " values ('"+ u.getNome() +"', '"+ u.getEmail() +"', '" + 
            u.getEndereço() +"', '"+ u.getCpf() +"', '"+ u.getTelefone() +
            "', '"+ u.getCelular() +"', "+ u.getTipo() +", '"+ u.getSenha() +"')");
        
        try {
            DbHelper db = new DbHelper();
            u.setId(db.insert(select));
        }
        catch(Exception ex) {            
            ex.printStackTrace();
        }
        
        return u;
    }
    
    private static Usuario converteResultSetParaUsuario(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        u.setNome(rs.getString("nome"));
        u.setEmail(rs.getString("email"));
        u.setEndereço(rs.getString("endereco"));
        u.setTelefone(rs.getString("telefone"));
        u.setCelular(rs.getString("celular"));
        u.setCpf(rs.getString("cpf"));
        u.setTipo(rs.getInt("tipo"));
        u.setSenha(rs.getString("senha")); 
        
        return u;
        
    }
}
