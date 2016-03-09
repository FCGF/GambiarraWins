package br.org.catolicasc.data;

import br.org.catolicasc.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteJDBC {
    
    private static final String SQL_TO_FIND_ALL = "SELECT id, nome, ativo FROM cliente";
    private static final String SQL_TO_FIND_BY_ID = "SELECT id, nome, ativo FROM cliente WHERE id = ?";
    private static final String SQL_TO_CREATE = "INSERT INTO cliente (nome, ativo) VALUES (?, ?)";
    private static final String SQL_TO_UPDATE = "UPDATE cliente SET nome=?, ativo=? WHERE (id=?)";
    private static final String SQL_TO_DELETE = "DELETE FROM cliente WHERE (id=?)";
    private static final String SQL_TO_DELETE_ALL = "DELETE FROM cliente";
    private static final String SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM cliente";
    
    public List<Cliente> findAll() throws ClassNotFoundException, Exception{
        Connection conn = null;   
        Statement stmt = null;
        List<Cliente> clientes = new ArrayList<>();
        try {           
            conn = ConnectionManager.getInstance().getConnection();
            
            stmt = conn.createStatement(); 
            
            ResultSet rs = stmt.executeQuery(SQL_TO_FIND_ALL);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                boolean ativo = rs.getBoolean("ativo");
                
                Cliente cliente = new Cliente (id, nome, ativo);
                clientes.add(cliente);
                
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
        return clientes;
    }
    
    public Cliente find(int id) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        Cliente cliente = null;
        try {           
            conn = ConnectionManager.getInstance().getConnection();
            
            stmt = conn.prepareStatement(SQL_TO_FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                boolean ativo = rs.getBoolean("ativo");
                
                cliente = new Cliente (codigo, nome, ativo);
                
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
        return cliente;
    }
    
    public Cliente create(Cliente cliente) throws Exception {
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();          
            stmt = conn.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setBoolean(2, cliente.isAtivo());           
            stmt.executeUpdate();          
            ResultSet rs = stmt.getGeneratedKeys();
            
            while (rs.next()) {
                int codigo = rs.getInt(1);
                cliente.setId(codigo);                
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
        return cliente;
    }
    
    public void update(Cliente cliente) throws Exception{
        Connection conn = null;   
        PreparedStatement stmt = null;
        
        try {           
            conn = ConnectionManager.getInstance().getConnection();         
            stmt = conn.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, cliente.getNome());
            stmt.setBoolean(2, cliente.isAtivo());
            stmt.setInt(3, cliente.getId());
            
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
