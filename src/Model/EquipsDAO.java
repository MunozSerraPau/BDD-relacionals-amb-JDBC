package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EquipsDAO implements DAO<Equips> {
    public static Scanner scan = new Scanner(System.in);

    // CRUD
    @Override
    public boolean create(Equips equips) {

        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Equips> all() {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public boolean delete(Equips equips) {
        return false;
    }

    @Override
    public boolean update(Equips equips) throws SQLException {

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "UPDATE equips " +
                " SET equip_id = ?, nom = ?, acronim = ?, ciutat = ?, divisio = ?, guanyades = ?, perdudes = ? " +
                " WHERE equip_id = ? ");
        statement.setInt(1, equips.getEquip_id());
        statement.setString(2, equips.getNom());
        statement.setString(3, equips.getAcronim());
        statement.setString(4, equips.getCiutat());
        statement.setString(5, equips.getDivisio());
        statement.setFloat(6, equips.getGuanyades());
        statement.setInt(7, equips.getPerdudes());
        statement.setInt(8, equips.getEquip_id());

        int rs  = statement.executeUpdate();
        if (rs == 1) {
            System.out.println("S'ha actualitzat correctament.");
        } else {
            System.out.println("NO s'ha actualitzat.");
        }

        return false;
    }

    @Override
    public Equips read(Long id_equip) throws SQLException {
        Equips e = new Equips(id_equip.intValue(), "", "", "", "", 0, 0);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM equips WHERE equip_id = ?");
        statement.setLong(1, id_equip);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            e.setEquip_id(resultSet.getInt("equip_id"));
            e.setCiutat(resultSet.getString("ciutat"));
            e.setNom(resultSet.getString("nom"));
            e.setAcronim(resultSet.getString("acronim"));
            e.setDivisio(resultSet.getString("divisio"));
            e.setGuanyades(resultSet.getInt("guanyades"));
            e.setPerdudes(resultSet.getInt("perdudes"));
        } else {
            System.out.println("ERROR no s'ha trobar el Jugador READ!");
        }
        return e;
    }

    public Long trovarEquipId (String n) {
        Long equipId = null;

        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("SELECT equip_id, CONCAT(ciutat,' ',nom) AS nomComplet " +
                    "FROM equips " +
                    "HAVING nomComplet like ?;");
            statement.setString(1, n);

            ResultSet resultatId = statement.executeQuery();

            if(resultatId.next()) {
                equipId = resultatId.getLong("equip_id");
            } else {
                System.out.println("No s'ha trobat cap equip amb aquest nom!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return equipId;
    }

    public Equips canviarNom() throws SQLException {
        String s, nomCanvi;
        Long idEquip;
        Equips equip;

        System.out.print("Nom de l'equip (Memphis Grizzlies): ");
        s = scan.nextLine();
        System.out.print("Nom de la nova franquícia (Vancouver): ");
        nomCanvi = scan.nextLine();

        idEquip =  trovarEquipId(s);
        equip = read(idEquip);
        equip.setCiutat(nomCanvi);

        return equip;
    }
}
