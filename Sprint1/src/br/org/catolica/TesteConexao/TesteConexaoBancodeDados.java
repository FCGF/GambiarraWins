package br.org.catolica.TesteConexao;

import br.org.catolicasc.cadastro.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;//comentario

public class TesteConexaoBancodeDados {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.197.8.203:3306/db_rafael_chewinski?useSSL=false";
    private static final String USER = "rafael_chewinski";
    private static final String PASSWORD = "abc123";
    private static final String SQL = "select * from cliente";
    
    public static void main(String[] args) throws ClassNotFoundException {        
        Connection conn = null;   
        Statement stmt = null;
        try {           
            Class.forName(JDBC_DRIVER);           
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                boolean ativo = rs.getBoolean("ativo");
                
                Cliente cliente = new Cliente (id, nome, ativo);
                clientes.add(cliente);
                
                System.out.println("ID: " + id + " -- " + " Nome: " + nome + " -- " + " Ativo: " + ativo);
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
}
