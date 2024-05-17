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
    public List<Jugadres> all() {
        return null;
    }

    public static void exercici1 () throws Exception {
        String nomEquip;
        int idEquip;
        List<Jugadres> players = new ArrayList<>();

        System.out.print("Escriu el nom del equip: ");
        nomEquip = scan.nextLine().trim();
        idEquip = EquipsDAO.trovarEquipId(nomEquip);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM jugadors WHERE equip_id = ?");
        statement.setInt(1, idEquip);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Jugadres player = new Jugadres("");
            player.setNom(resultSet.getString("nom"));
            System.out.println(resultSet.getString(("nom")));
            players.add(player);
        }

        Vista.mostrarJugadors(players);

    }

}
