package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estadistiques_jugadorsDAO implements DAO<Estadistiques_jugadors> {

    public static Scanner scan = new Scanner(System.in);
    @Override
    public boolean create(Estadistiques_jugadors estadistiquesJugadors) {
        return false;
    }

    @Override
    public Estadistiques_jugadors read(Long id_estadistiques) {
        return null;
    }

    @Override
    public boolean update(Estadistiques_jugadors estadistiquesJugadors) {
        return false;
    }

    @Override
    public boolean delete(Estadistiques_jugadors estadistiquesJugadors) {
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
    public List<Estadistiques_jugadors> all() throws Exception {
        String nomJug;
        Long idJugador;
        List<Estadistiques_jugadors> estadisticaJugador = new ArrayList<>();
        JugadoresDAO j = new JugadoresDAO();

        System.out.print("Escriu el nom del jugador:(LeBron James) ");
        nomJug = scan.nextLine().trim();
        idJugador = j.trovarJugadorId(nomJug);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT SUM(punts) / COUNT(jugador_id) AS p, SUM(assistencies) / COUNT(jugador_id) AS a, SUM(robades) / COUNT(jugador_id) AS r, SUM(bloqueigs) / COUNT(jugador_id) AS b " +
                "FROM estadistiques_jugadors " +
                "WHERE jugador_id = ?;");
        statement.setLong(1, idJugador);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Estadistiques_jugadors estadistiquesJugadors = new Estadistiques_jugadors(0, 0, 0, 0);
            estadistiquesJugadors.setPunts(resultSet.getFloat("p"));
            estadistiquesJugadors.setAssistencies(resultSet.getFloat("a"));
            estadistiquesJugadors.setRobades(resultSet.getFloat("r"));
            estadistiquesJugadors.setBloqueigs(resultSet.getFloat("b"));
            estadisticaJugador.add(estadistiquesJugadors);
        }

        return estadisticaJugador;
    }   // ECERCICI 2

}
