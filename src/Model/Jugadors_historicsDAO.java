package Model;

import Vista.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Jugadors_historicsDAO implements DAO<Jugadors_historics>{
    public static Scanner scan = new Scanner(System.in);

    /**
     * Creem un jugador historic.
     * @param jugHis Totes les dades que hem de guardar del jugador.
     * @return Retorna true conforma s'ha realitzat el CREATE.
     * @throws Exception Per si peta en algun punt de la consulta.
     */
    @Override
    public boolean create(Jugadors_historics jugHis) throws Exception {

        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO jugadors_historics (jugador_id, nom, cognom, dorsal, posicio, minutsTotals, puntsTotals, totalTirsAnotats, totalTirsTirats, totalTriplesAnotats, totalTriplesTirats, totalLliuresAnotats, totalLliuresTirats, totalRebotsOfensius, totalRebotsDefensius, totalAssistencies, totalRobades, totalBloqueigs)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, jugHis.getJugador_Id());
            statement.setString(2, jugHis.getNom());
            statement.setString(3, jugHis.getCognom());
            statement.setString(4, jugHis.getDorsal());
            statement.setString(5, jugHis.getPosicio());
            statement.setFloat(6, jugHis.getMinutsTotals());
            statement.setInt(7, jugHis.getPuntsTotals());
            statement.setInt(8, jugHis.getTotalTirsAnotats());
            statement.setInt(9, jugHis.getTotalTirsTirats());
            statement.setInt(10, jugHis.getTotalTriplesAnotats());
            statement.setInt(11, jugHis.getTotalTriplesTirats());
            statement.setInt(12, jugHis.getTotalLliuresAnotats());
            statement.setInt(13, jugHis.getTotalLliuresTirars());
            statement.setInt(14, jugHis.getTotalRebotsOfensius());
            statement.setInt(15, jugHis.getTotalRebotsDefensius());
            statement.setInt(16, jugHis.getTotalAssistencies());
            statement.setInt(17, jugHis.getTotalRobades());
            statement.setInt(18, jugHis.getTotalBloqueigs());

            int rs  = statement.executeUpdate();

            if (rs == 1) {
                Vista.mostrarJugadorHistoric(jugHis);
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
    public boolean delete(Long id_JugadorHistoric) {
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

    /**
     * Funció per obtenir totes les dades necessaries per guardar-ho a la taula Jugadors_Historics.
     * @param idJugadorHistoric El id del jugador que volem obtenir la dada.
     * @return Retorna un registre de Jugadors_historics amb totes les dades.
     * @throws SQLException Per si peta en algun moment.
     */
    public Jugadors_historics obtenirInformacio (Long idJugadorHistoric) throws SQLException {
        Jugadors_historics jh = null;

        Connection connection = Connexio.conectarBD();

        // UTILITZEM UN INNER JOIN PER AJUNTAR DOS TAULES.
        PreparedStatement statement = connection.prepareStatement("SELECT j.jugador_id, j.nom, j.cognom, j.dorsal, j.posicio, SUM(ej.minuts_jugats) AS mj, SUM(ej.punts) AS p, SUM(ej.tirs_anotats) AS ta, SUM(ej.tirs_tirats) AS tt, SUM(ej.tirs_triples_anotats) AS tta, SUM(ej.tirs_triples_tirats) AS ttt, SUM(ej.tirs_lliures_anotats) AS tla, SUM(ej.tirs_lliures_tirats) AS tlt, SUM(ej.rebots_ofensius) AS ro, SUM(ej.rebots_defensius) AS rd, SUM(ej.assistencies) AS a, SUM(ej.robades) AS r, SUM(bloqueigs) b" +
                " FROM jugadors j" +
                " INNER JOIN estadistiques_jugadors ej ON j.jugador_id = ej.jugador_id" +
                " WHERE j.jugador_id = ?" +
                " GROUP BY jugador_id;");
        statement.setLong(1, idJugadorHistoric);
        ResultSet resultSet = statement.executeQuery();


        if (resultSet.next()) {
            jh = new Jugadors_historics(idJugadorHistoric.intValue(), "", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            jh.setNom(resultSet.getString("nom"));
            jh.setCognom(resultSet.getString("cognom"));
            jh.setDorsal(resultSet.getString("dorsal"));
            jh.setPosicio(resultSet.getString("posicio"));
            jh.setMinutsTotals(resultSet.getFloat("mj"));
            jh.setPuntsTotals(resultSet.getInt("p"));
            jh.setTotalTirsAnotats(resultSet.getInt("ta"));
            jh.setTotalTirsTirats(resultSet.getInt("tt"));
            jh.setTotalTriplesAnotats(resultSet.getInt("tta"));
            jh.setTotalTriplesTirats(resultSet.getInt("ttt"));
            jh.setTotalLliuresAnotats(resultSet.getInt("tla"));
            jh.setTotalLliuresTirars(resultSet.getInt("tlt"));
            jh.setTotalRebotsOfensius(resultSet.getInt("ro"));
            jh.setTotalRebotsDefensius(resultSet.getInt("rd"));
            jh.setTotalAssistencies(resultSet.getInt("a"));
            jh.setTotalRobades(resultSet.getInt("r"));
            jh.setTotalBloqueigs(resultSet.getInt("b"));
        }

        return jh;
    }

    /**
     * Funció per passar un jugador amb les seves dades a una taula de Jugadors_Historics.
     * @throws Exception Per si peta en alguna de les funcións cridades.
     */
    public void exercici8() throws Exception {
        Jugadors_historics jugHis;
        JugadoresDAO jug = new JugadoresDAO();
        String nomJugHis;
        Long idJugHis;

        System.out.print("Quin jugador vols que vagi a la taula Jugadors Historics(Kevin Durant): ");
        nomJugHis = scan.nextLine().trim();

        idJugHis = jug.trovarJugadorId(nomJugHis);

        jugHis = obtenirInformacio(idJugHis);
        create(jugHis);

        // AQUÍ ELIMINEM EL REGISTRE DE JUGADORS
        // jug.delete(idJugHis);  ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡MIRAR QUE S'HA DE FER!!!!!!!!!!!!!!

    }

}
