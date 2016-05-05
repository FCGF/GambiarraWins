package br.org.catolicasc.vendas.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cyber
 */
public final class JdbcUtil {

    private static final Logger LOGGER = LogManager.getLogger(JdbcUtil.class);

    private JdbcUtil() {
        super();
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar conexão.", ex);
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar objeto statement.", ex);
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar ResultSet.", ex);
            }
        }
    }

}
