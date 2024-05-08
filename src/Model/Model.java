package Model;

import javax.xml.stream.events.StartDocument;
import java.sql.*;
import java.util.Scanner;

public class Model {
    public static Scanner scan = new Scanner(System.in);
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

    public static void exercici1(Connection con) {
        System.out.print("Escriu el nom d'un equip: ");
        String n = scan.nextLine();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM equipos");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
