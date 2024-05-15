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
        String sentenciaSQL, nomEquip;
        System.out.print("Escriu el nom d'un equip: ");
        nomEquip = scan.nextLine();
        sentenciaSQL = "SELECT nom FROM jugadors WHERE equip_id = (SELECT id FROM equips WHERE nom = '"+ nomEquip +"' )";



        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadors WHERE equip_id=?");
            ps.setString(1, "1610612741");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nom"));
            }
            System.out.println("PAUMUNOZ\n\n\n\n\n\n\n\n\n");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sentenciaSQL);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
