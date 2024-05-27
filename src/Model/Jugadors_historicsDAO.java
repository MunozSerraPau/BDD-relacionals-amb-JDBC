package Model;

import Vista.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Jugadors_historicsDAO implements DAO<Jugadors_historics>{
    @Override
    public boolean create(Jugadors_historics jugadoHistoric) throws Exception {

        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO jugadors_historics (jugador_id, nom, cognom, dorsal, posicio, minuts_totals, punts_totals, total_tirs_anotats, total_tirs_tirats, total_triples_anotats, total_triples_tirats, total_lliures_anotats, total_lliures_tirats, total_rebots_ofensius, total_rebots_defensius, total_assistencies, total_robades, total_bloqueigs) " +
                    "SELECT j.jugador_id, j.nom, j.cognom, j.dorsal, j.posicio, ej.* " +
                    "FROM jugadors j " +
                    "INNER JOIN estadistiques_jugadors ej ON j.jugador_id = ej.jugador_id WHERE j.jugador_id = ? ");
            statement.setInt(1, jugadoHistoric.getJugadorId());

            int rs  = statement.executeUpdate();
            if (rs == 1) {
                Vista.mostrarJugadorNou(jugadoHistoric, rs);
            } else {
                System.out.println("ERROR!");
            }


        } catch (Exception e) {
            System.out.println(e.getClass() + " ES AL INSERT");
        }

        return false;
    }

    @Override
    public Jugadors_historics read(Long id) throws Exception {
        return null;
    }

    @Override
    public boolean update(Jugadors_historics obj) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Jugadors_historics obj) {
        return false;
    }

    @Override
    public boolean exists(int id) throws Exception {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Jugadors_historics> all() throws Exception {
        return List.of();
    }

}
