package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL_MYSQL = "jdbc:mysql://localhost/crm";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection conectar() {
        System.out.println("Conectando no banco...");
        try {
          Class.forName(DRIVER_CLASS);
          return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch(ClassNotFoundException | SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "conectar no banco. Erro: " + s.getMessage());
        }
        return null;
    }
}
