package Model;

import java.sql.*;

public class Model {
    public static Connection conectarBD(String url, String user, String contra) {
        Connection connexio = null;

        try {
            connexio = DriverManager.getConnection(url, user, contra);

            System.out.println("Connexió establerta");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
