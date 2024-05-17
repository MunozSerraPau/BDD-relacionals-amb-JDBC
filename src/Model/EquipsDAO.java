package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EquipsDAO implements DAO<Equips> {
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
    public boolean exists(Equips equips) {
        return false;
    }

    @Override
    public boolean delete(Equips equips) {
        return false;
    }

    @Override
    public boolean update(Equips equips) {
        return false;
    }

    @Override
    public boolean read(int id_equip) {

        return false;
    }

    public static int trovarEquipId (String n) {
        int equipId = 0;

        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("SELECT equip_id, CONCAT(ciutat,' ',nom) AS nomComplet " +
                    "FROM equips " +
                    "HAVING nomComplet like ?;");
            statement.setString(1, n);

            ResultSet resultatId = statement.executeQuery();

            if(resultatId.next()) {
                equipId = resultatId.getInt("equip_id");
            } else {
                System.out.println("No s'ha trobat cap equip amb aquest nom!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return equipId;
    }
}
