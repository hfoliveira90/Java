package factory;

import java.sql.Connection; //conexao SQL para Java
import java.sql.DriverManager; //driver de conexao SQL para Java
import java.sql.SQLException; //classe para tratamento de exceções
/**
 *
 * @author Administrator
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Projeto", "root", "1234");
        }
        catch (SQLException execao){
            throw new RuntimeException(execao);
        }
    }
}
