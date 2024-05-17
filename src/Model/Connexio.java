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



    public static void exercici1(Connection con) {
        String sentenciaSQL, nomEquip = "G";
        System.out.print("Escriu el nom d'un equip: ");
        //nomEquip = scan.nextLine();
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
