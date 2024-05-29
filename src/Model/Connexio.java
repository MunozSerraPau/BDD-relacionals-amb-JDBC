package Model;

import java.sql.*;

public class Connexio {

    /**
     * Funció per poder connectar-nos amb uan url, un usuari i la contrasenya.
     * @return Retorna la connexió amb la base de dades.
     */
    public static Connection conectarBD() {
        String url = "jdbc:mysql://192.168.14.8:3306/NBA";
        // String url = "jdbc:mysql://192.168.14.13:3306/NBA";
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

    /**
     * Funció per poder-nos desconnectar de la base de dades.
     * @param con La connexion amb la base de dades.
     */
    public static void desconectarBD(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
