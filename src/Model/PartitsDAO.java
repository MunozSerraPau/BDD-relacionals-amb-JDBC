package Model;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PartitsDAO implements DAO<Partits> {
    public static Scanner scan = new Scanner(System.in);

    @Override
    public boolean create(Partits partits) {
        return false;
    }

    @Override
    public Partits read(Long id) {
        return null;
    }

    @Override
    public boolean update(Partits partits) {
        return false;
    }

    @Override
    public boolean delete(Long id_partit) {
        return false;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Partits> all() throws SQLException {
        String nomEquip;
        Long idEquip;
        EquipsDAO eDAO = new EquipsDAO();
        List<Partits> llistaPartits = new ArrayList<>();

        System.out.print("Nom del equip (Los Angeles Lakers): ");
        nomEquip = scan.nextLine().trim();

        Connection connection = Connexio.conectarBD();
        idEquip = eDAO.trovarEquipId(nomEquip);

        PreparedStatement statement = connection.prepareStatement("SELECT (SELECT SUM(punts) FROM estadistiques_jugadors WHERE equip_id = p.equip_id AND partit_id = p.partit_id) AS 'punts', CONCAT(e.ciutat, ' ', e.nom) AS 'nomEquip' " +
                " FROM partits p " +
                " INNER JOIN equips e ON p.equip_id = e.equip_id " +
                "WHERE p.partit_id IN (SELECT partit_id FROM partits WHERE equip_id = ?) " +
                "ORDER BY p.partit_id;");
        statement.setLong(1, idEquip);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Partits game = new Partits(0, "");
            game.setEquipId(resultSet.getInt("punts"));
            game.setDataPartit(resultSet.getString("nomEquip"));
            llistaPartits.add(game);
        }

        return llistaPartits;
    }
}
