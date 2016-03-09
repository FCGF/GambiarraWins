/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.data;

import br.org.catolicasc.model.Categoria;
import br.org.catolicasc.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaJDBC {
    
    private static final String SQL_TO_FIND_ALL = "SELECT id, nome, descricao FROM categoria";
    private static final String SQL_TO_FIND_BY_ID = "SELECT id, nome, descricao FROM categoria WHERE id = ?";
    private static final String SQL_TO_CREATE = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
    private static final String SQL_TO_UPDATE = "UPDATE categoria SET nome=?, descricao=? WHERE (id=?)";
    private static final String SQL_TO_DELETE = "DELETE FROM categoria WHERE (id=?)";
    private static final String SQL_TO_DELETE_ALL = "DELETE FROM categoria";
    private static final String SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM categoria";
    
    public List<Categoria> findAll() throws ClassNotFoundException, Exception{
        Connection conn = null;   
        Statement stmt = null;
        List<Categoria> categorias = new ArrayList<>();
        try {           
            conn = ConnectionManager.getInstance().getConnection();
            
            stmt = conn.createStatement(); 
            
            ResultSet rs = stmt.executeQuery(SQL_TO_FIND_ALL);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                
                Categoria categoria = new Categoria (id, nome, descricao);
                categorias.add(categoria);
                
            }
        } catch (SQLException ex) {           
            ex.printStackTrace();            
        } finally {
             try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
        }
        return categorias;
    }
    
    public Categoria find(int id) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        Categoria categoria = null;
        try {           
            conn = ConnectionManager.getInstance().getConnection();
            
            stmt = conn.prepareStatement(SQL_TO_FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                
                Categoria categorias = new Categoria (id, nome, descricao);
                
            }
        } catch (SQLException ex) {           
            ex.printStackTrace();            
        } finally {
             try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
        }
        return categoria;
    }
    
    public Categoria create(Categoria categoria) throws Exception {
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();          
            stmt = conn.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());           
            stmt.executeUpdate();          
            ResultSet rs = stmt.getGeneratedKeys();
            
            while (rs.next()) {
                int codigo = rs.getInt(1);
                categoria.setId(codigo);                
            }
            
        } catch (SQLException ex) {           
            ex.printStackTrace();            
        } finally {
             try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
        }
        return categoria;
    }
    
    public void update(Categoria categoria) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();         
            stmt = conn.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getId());
            
            int rowCount = stmt.executeUpdate();
            
            if(rowCount == 0) {
                throw new SQLException("Objeto não foi salvo!objeto não encontrado!");
            }
            if (rowCount > 1) {
                throw new SQLException("Mais de um objeto afetado, o comando foi desfeito.");
            }
            
        } catch (SQLException ex) {           
            ex.printStackTrace();            
        } finally {
             try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
        }
    }
    
    public void delete(int id) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();          
            stmt = conn.prepareStatement(SQL_TO_DELETE, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, id);
            
            int rowCount = stmt.executeUpdate();
            
            if(rowCount == 0) {
                throw new SQLException("Objeto não foi salvo!objeto não encontrado!");
            }
            if (rowCount > 1) {
                throw new SQLException("Mais de um objeto afetado, o comando foi desfeito.");
            }
            
        } catch (SQLException ex) {           
            ex.printStackTrace();            
        } finally {
             try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {           
                ex.printStackTrace();
            }
        }
    }
    
    public int countAll(){
        return 0;
    }
}