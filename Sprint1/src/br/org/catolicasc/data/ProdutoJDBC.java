/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.data;

import br.org.catolicasc.model.Categoria;
import br.org.catolicasc.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ProdutoJDBC {

    private static final String SQL_TO_FIND_ALL = "SELECT id, categoria_id, "
            + "nome, preco_unitario, quantidade, estoque, descontinuado FROM produto";
    private static final String SQL_TO_FIND_BY_ID = "SELECT id, categoria_id, nome, preco_unitario, quantidade, estoque, descontinuado FROM produto WHERE id = ?";
    private static final String SQL_TO_CREATE = "INSERT INTO produto (categoria_id, nome, preco_unitario, quantidade, estoque, descontinuado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_TO_UPDATE = "UPDATE produto SET categoria_id=?, nome=?, preco_unitario=?, quantidade=?, estoque=?, descontinuado=? WHERE (id=?)";
    private static final String SQL_TO_DELETE = "DELETE FROM produto WHERE (id=?)";
    private static final String SQL_TO_DELETE_ALL = "DELETE FROM produto";
    private static final String SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM produto";

    public List<Produto> findAll() throws ClassNotFoundException, Exception {
        Connection conn = null;
        Statement stmt = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            conn = ConnectionManager.getInstance().getConnection();

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_TO_FIND_ALL);

            while (rs.next()) {
                int id = rs.getInt("id");
                Categoria categoria = new Categoria(rs.getInt("categoria_id"));
                String nome = rs.getString("nome");
                double preco_unitario = rs.getDouble("preco_unitario");
                double quantidade = rs.getDouble("quantidade");
                int estoque = rs.getInt("estoque");
                boolean descontinuado = rs.getBoolean("descontinuado");
                

                Produto produto = new Produto(id, categoria, nome, 
                        preco_unitario, quantidade, estoque, descontinuado);
                produtos.add(produto);

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
        return produtos;
    }
    
    public Produto find(int id) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        Produto produto = null;
        try {           
            conn = ConnectionManager.getInstance().getConnection();
            
            stmt = conn.prepareStatement(SQL_TO_FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int codigo = rs.getInt("id");
                Categoria categoria = new Categoria(rs.getInt("categoria_id"));
                String nome = rs.getString("nome");
                double preco_unitario = rs.getDouble("preco_unitario");
                double quantidade = rs.getDouble("quantidade");
                int estoque = rs.getInt("estoque");
                boolean descontinuado = rs.getBoolean("descontinuado");
                
                produto = new Produto (id, categoria, nome, preco_unitario,
                        quantidade, estoque, descontinuado);
                
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
        return produto;
    }
    
    public Produto create(Produto produto) throws Exception {
        Connection conn = null;   
        PreparedStatement stmt = null;
    
        try {           
            conn = ConnectionManager.getInstance().getConnection();          
            stmt = conn.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setBoolean(2, produto.isDescontinuado());           
            stmt.executeUpdate();          
            ResultSet rs = stmt.getGeneratedKeys();
            
            while (rs.next()) {
                int codigo = rs.getInt(1);
                produto.setId(codigo);                
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
        return produto;
    }

    public void update(Produto produto) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();         
            stmt = conn.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getId());     
            stmt.setInt(3, produto.getCategoria().getId());
            stmt.setDouble(4, produto.getPreco_unitario());
            stmt.setDouble(5, produto.getQuantidade());
            stmt.setInt(6, produto.getEstoque());
            stmt.setBoolean(7, produto.isDescontinuado());
            
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
