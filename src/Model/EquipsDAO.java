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
    public boolean exists(int id) {
        return false;
    }

    @Override
    public boolean delete(Equips equips) {
        return false;
    }

    @Override
    public boolean update(Equips equips) {

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "UPDATE jugadors " +
                "SET jugador_id = ?, nom = ?, cognom = ?, data_naixement = ?, alcada = ?, pes = ?, dorsal = ?, posicio = ?, equip_id = ? " +
                "WHERE jugador_id = ? ");
        statement.setLong(1, equips.getJugadorId());
        statement.setString(2, equips.getNom());
        statement.setString(3, equips.getCognom());
        statement.setString(4, equips.getDataNaixement());
        statement.setFloat(5, equips.getAlcada());
        statement.setFloat(6, equips.getPes());
        statement.setString(7, equips.getDorsal());
        statement.setString(8, equips.getPosicio());
        statement.setLong(9, equips.getEquipId());
        statement.setLong(10, equips.getJugadorId());
        int rs  = statement.executeUpdate();
        if (rs == 1) {
            System.out.println("S'ha actualitzat correctament.");
        } else {
            System.out.println("NO s'ha actualitzat.");
        }

        return false;
    }

    @Override
    public Equips read(Long id_equip) {

        return null;
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
}
