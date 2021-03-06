package br.org.catolicasc.cadastro.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author flavio.kannenberg
 */
public final class ConnectionManager {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.197.8.203:3306/db_igor_fachini?useSSL=false";
    private static final String USER = "igor_fachini";
    private static final String PASSWORD = "abc123";
    private static Connection conn = null;
    private static final ConnectionManager CONNECTION_MANAGER;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionManager.class);

    static {
        CONNECTION_MANAGER = new ConnectionManager();
    }

    public static ConnectionManager getInstance() {
        return CONNECTION_MANAGER;
    }

    private ConnectionManager() {
    }

    public Connection getConnection() throws Exception {
        LOGGER.info("Execute getConnection."); 
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName(JDBC_DRIVER).newInstance();
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                conn.setAutoCommit(true);
                
                LOGGER.info("--> Connected success. Data Base Schema: " + conn.getCatalog());
                
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                LOGGER.error("Não consegui conectar em: " + URL, ex);
                throw ex;
            }
        }

        return conn;
    }
}
