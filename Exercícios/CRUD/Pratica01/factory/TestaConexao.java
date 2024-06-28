package factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
