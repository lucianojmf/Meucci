package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class CriaPopulaBD {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            Properties properties = new Properties();
            try {
                InputStream stream = CriaPopulaBD.class.getResourceAsStream("/configuration.properties");
                properties.load(stream);
                String driver = properties.getProperty("jdbc.driver");
                String url = properties.getProperty("jdbc.url");
                String user = properties.getProperty("jdbc.user");
                String password = properties.getProperty("jdbc.password");
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static boolean criaBD()throws SQLException {
        boolean toReturn = false;
        System.out.println("Criando Base de dados");

        Connection con = CriaPopulaBD.getConnection();

        InputStream stream = CriaPopulaBD.class.getResourceAsStream("/create.sql");

        Scanner scanner = new Scanner(stream);

        scanner.useDelimiter("\\;");


        while (scanner.hasNext()) {
            try {
                String q = scanner.next();
                Statement stmt = con.createStatement();
                if (q.length() > 0) {
                    System.out.println(q);
                    stmt.execute(q);
                }
                stmt.close();
                toReturn = true;
            } catch (Exception e) {
                toReturn = false;
                e.printStackTrace();

            }
        }

        con.close();
        return toReturn;
        
    }
    
    private static void populaDadosIniciais() throws SQLException {

        System.out.println("Populando base de dados");

        Connection con = CriaPopulaBD.getConnection();

        InputStream stream = CriaPopulaBD.class.getResourceAsStream("/populate.sql");

        Scanner scanner = new Scanner(stream);

        scanner.useDelimiter("\\;");


        while (scanner.hasNext()) {
            try {
                String q = scanner.next();
                Statement stmt = con.createStatement();
                if (q.length() > 0) {
                    System.out.println(q);
                    stmt.execute(q);
                }
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        con.close();
    }
    

    public static void main(String[] args) throws SQLException {
        criaBD();
        //populaDadosIniciais();
    }
}
