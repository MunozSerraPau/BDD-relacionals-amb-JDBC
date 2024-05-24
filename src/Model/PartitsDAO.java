package Model;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    public boolean delete(Partits partits) {
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

    @Override
    public List<Partits> all() throws SQLException {
        String nomEquip;
        Long idEquip;
        EquipsDAO eDAO = new EquipsDAO();

        System.out.println("Nom del equip (Los Angeles Lakers):");
        nomEquip = scan.nextLine().trim();

        Connection connection = Connexio.conectarBD();

        idEquip = eDAO.trovarEquipId(nomEquip);

        PreparedStatement statement = connection.prepareStatement("SELECT (SELECT SUM(punts) FROM estadistiques_jugadors WHERE equip_id = p.equip_id AND partit_id = p.partit_id) AS 'Punts', CONCAT(e.ciutat, ' ', e.nom) AS 'Equip', p.partit_id " +
                " FROM partits p " +
                " INNER JOIN equips e ON p.equip_id = e.equip_id " +
                "WHERE p.partit_id IN (SELECT partit_id FROM partits WHERE equip_id = ?) " +
                "ORDER BY p.partit_id;");
        statement.setLong(1, idEquip);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Partits game = new Partits(0, "");

        }

        return null;
    }
}
