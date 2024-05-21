package Model;

import java.sql.*;

public class Connexio {
    public static Connection conectarBD() {
        String url = "jdbc:mysql://192.168.14.8:3306/NBA";
        String user = "perepi";
        String contra = "pastanaga";

        Connection connexio = null;

        try {
            connexio = DriverManager.getConnection(url, user, contra);
        } catch (SQLException e) {
            System.out.println("No s'ha pogut connectar a la Base de Dades.");

        }

        return connexio;
    }
    public static void desconectarBD(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
