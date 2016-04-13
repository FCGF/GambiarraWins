package br.org.catolicasc.vendas.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author fkannenberg
 */
public final class ConnectionManager {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.197.8.203:3306/db_guilherme_fagund?useSSL=false";
    private static final String USER = "guilherme_fagund";
    private static final String PASSWORD = "abc123";
    
    private static Connection conn = null;
    private static ConnectionManager mngr;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionManager.class);

    static {
        mngr = new ConnectionManager();
    }

    public static ConnectionManager getInstance() {
        return mngr;
    }

    private ConnectionManager() {
    }

    public Connection getConnection() throws Exception {
        
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName(JDBC_DRIVER).newInstance();
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                conn.setAutoCommit(true);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                LOGGER.error("Não consegui conectar em: " + URL, ex);
                throw ex;
            }
        }

        return conn;
    }
}
