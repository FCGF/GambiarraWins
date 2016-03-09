package br.org.catolicasc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.197.8.203:3306/db_rafael_chewinski?useSSL=false";
    private static final String USER = "rafael_chewinski";
    private static final String PASSWORD = "abc123";
    
    private static Connection conn = null;
    private static ConnectionManager mngr = null;
    static {
        mngr = new ConnectionManager();
    }
    
    private ConnectionManager(){
        super();
    }
    
    public static ConnectionManager getInstance(){
        return mngr;
    }
    
    public Connection getConnection() throws Exception{
        if (conn == null || conn.isClosed()){
            try {           
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }        
        return conn;
    }
    
}

