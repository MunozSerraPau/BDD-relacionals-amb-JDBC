package Model;

import Vista.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadoresDAO implements DAO<Jugadres> {
    public static Scanner scan = new Scanner(System.in);

    @Override
    public boolean create(Jugadres jugadres) {
        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT nom, cognom FROM jugadors WHERE equip_id = ?");
        statement.setLong(1, idEquip);
        ResultSet resultSet = statement.executeQuery();
        return false;
    }

    @Override
    public boolean read(int id_jugador) {
        return false;
    }

    @Override
    public boolean update(Jugadres jugadres) {
        return false;
    }

    @Override
    public boolean delete(Jugadres jugadres) {
        return false;
    }

    @Override
    public boolean exists(Jugadres jugadres) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Jugadres> all() throws Exception {
        String nomEquip;
        Long idEquip;
        List<Jugadres> players = new ArrayList<>();

        Connection connection = Connexio.conectarBD();

        System.out.print("Escriu el nom del equip: ");
        nomEquip = scan.nextLine().trim();
        idEquip = EquipsDAO.trovarEquipId(nomEquip);

        PreparedStatement statement = connection.prepareStatement("SELECT nom, cognom FROM jugadors WHERE equip_id = ?");
        statement.setLong(1, idEquip);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Jugadres player = new Jugadres("", "");
            player.setNom(resultSet.getString("nom"));
            player.setCognom(resultSet.getString("cognom"));
            players.add(player);
        }

        return players;
    }   // EXERCICI 1

    public static Long trovarJugadorId(String n) {
        Long jugadorID = null;

        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("SELECT jugador_id, CONCAT(nom,' ',cognom) AS nomComplet " +
                    "FROM jugadors " +
                    "HAVING nomComplet like ?;");
            statement.setString(1, n);

            ResultSet resultatId = statement.executeQuery();

            if(resultatId.next()) {
                jugadorID = resultatId.getLong("jugador_id");
            } else {
                System.out.println("No s'ha trobat cap equip amb aquest nom!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jugadorID;
    }

}
