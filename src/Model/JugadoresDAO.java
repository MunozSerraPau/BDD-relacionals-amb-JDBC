package Model;

import Vista.Vista;

import java.sql.*;
import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadoresDAO implements DAO<Jugadres> {
    public static Scanner scan = new Scanner(System.in);

    /**
     * Funció per crear un jugador amb les dades d'un jugador que li passem
     * @param jugadres El jugador amb les dades.
     * @return Retorna true conforme s'ha creat.
     * @throws Exception Per si pera en algun punt del SQL
     */
    @Override
    public boolean create(Jugadres jugadres) throws Exception {
        try {
            Connection connection = Connexio.conectarBD();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO jugadors (nom, cognom, data_naixement, alcada, pes, dorsal, posicio, equip_id) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, jugadres.getNom());
            statement.setString(2, jugadres.getCognom());
            statement.setString(3, jugadres.getDataNaixement());
            statement.setFloat(4, jugadres.getAlcada());
            statement.setFloat(5, jugadres.getPes());
            statement.setString(6, jugadres.getDorsal());
            statement.setString(7, jugadres.getPosicio());
            statement.setLong(8, jugadres.getEquipId());
            int rs  = statement.executeUpdate();
            if (rs == 1) {
                Vista.mostrarJugadorNou(jugadres, rs);
            } else {
                System.out.println("ERROR!");
            }


        } catch (Exception e) {
            System.out.println(e.getClass() + " ES AL INSERT");
        }

        return true;
    }

    /**
     * Agafa tota l'informació d'un jugador en concret.
     * @param id_jugador La id del jugador que volem obtenir la informació.
     * @return Un jugador amb les dades que hem obtingut
     * @throws SQLException Per si peta en fer la sentència.
     */
    @Override
    public Jugadres read(Long id_jugador) throws SQLException {
        Jugadres j = new Jugadres(id_jugador.intValue(), "", "", "", 0f, 0f, "", "", 0);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM jugadors WHERE jugador_id = ?");
        statement.setLong(1, id_jugador);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            j.setNom(resultSet.getString("nom"));
            j.setCognom(resultSet.getString("cognom"));
            j.setDataNaixement(resultSet.getString("data_naixement"));
            j.setAlcada(resultSet.getFloat("alcada"));
            j.setPes(resultSet.getFloat("pes"));
            j.setDorsal(resultSet.getString("dorsal"));
            j.setPosicio(resultSet.getString("posicio"));
            j.setEquipId(resultSet.getLong("equip_id"));
        } else {
            System.out.println("ERROR no s'ha trobar el Jugador READ!");
        }

        return j;
    }

    /**
     * Actualitza les dades d'un jugador amb unes de noves.
     * @param jugadres El jugador amb les dades noves.
     * @return Retorna true conforme s'ha realitzat l'UPDATE.
     * @throws Exception Per si peta en el SQL.
     */
    @Override
    public boolean update(Jugadres jugadres) throws Exception {

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "UPDATE jugadors " +
                        "SET jugador_id = ?, nom = ?, cognom = ?, data_naixement = ?, alcada = ?, pes = ?, dorsal = ?, posicio = ?, equip_id = ? " +
                        "WHERE jugador_id = ? ");
        statement.setLong(1, jugadres.getJugadorId());
        statement.setString(2, jugadres.getNom());
        statement.setString(3, jugadres.getCognom());
        statement.setString(4, jugadres.getDataNaixement());
        statement.setFloat(5, jugadres.getAlcada());
        statement.setFloat(6, jugadres.getPes());
        statement.setString(7, jugadres.getDorsal());
        statement.setString(8, jugadres.getPosicio());
        statement.setLong(9, jugadres.getEquipId());
        statement.setLong(10, jugadres.getJugadorId());
        int rs  = statement.executeUpdate();
        if (rs == 1) {
            System.out.println("S'ha actualitzat correctament.");
        } else {
            System.out.println("NO s'ha actualitzat.");
        }

        return false;
    }

    /**
     * Elimina un registre d'un jugador.
     * @param id_Jugador La id del jugador que volem eliminar.
     * @return Retorna true conforme s'ha realitzar el delete
     * @throws SQLException Per si peta en fer el DELETE
     */
    @Override
    public boolean delete(Long id_Jugador) throws SQLException {

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("DELET FROM jugadors WHERE jugador_id = ?");
        statement.setLong(1, id_Jugador);
        int resultSet = statement.executeUpdate();

        if (resultSet >= 1) {
            System.out.println("S'ha eliminat correctament!");
        } else {
            System.out.println("No s'ah pogut eliminar.");
        }


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

    /**
     * Crea una llista amb tots els jugadors, d'un equip en concret que li passarem.
     * @return Una llista dels jugadors d'un equip concret.
     * @throws Exception Per si peta en alguna de les funcions de SQL.
     */
    @Override
    public List<Jugadres> all() throws Exception {
        String nomEquip;
        Long idEquip;
        List<Jugadres> players = new ArrayList<>();
        EquipsDAO e = new EquipsDAO();

        System.out.print("Escriu el nom del equip(Los Angeles Lakers): ");
        nomEquip = scan.nextLine().trim();
        idEquip = e.trovarEquipId(nomEquip);

        Connection connection = Connexio.conectarBD();

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

    /**
     * Funció per obtenir l'Id d'un jugador contret amb el seu nom.
     * @param n El nom complet del jugador
     * @return Un Long amb la id del jugador que volem.
     */
    public Long trovarJugadorId(String n) {
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


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jugadorID;
    }

    /**
     * Funció per afegir un jugador i un equip, si no existeix el pots crear o si existeix tens la possibilitat de
     * canviar-lo a l'equip que hem passat.
     * @return Un jugador amb tota la informació nova del jugador tant si el creem com si el canviem d'equip.
     * @throws Exception Per si peta a l'introduir un valor/caracter erroni.
     */
    public Jugadres exercici4() throws Exception {
        String nomJug, nomEquip, nom = "", cognom = "", resposta;
        String[] arrayNom;
        Long idJug, idEquip;
        JugadoresDAO j = new JugadoresDAO();
        Jugadres jugador;
        EquipsDAO e = new EquipsDAO();


        System.out.print("Escriu el nom i cognoms d'un Jugador (LeBron James): ");
        nomJug = scan.nextLine().trim();

        arrayNom = nomJug.split(" ");
        if (arrayNom.length > 2) {
            nom = arrayNom[0] + " " + arrayNom[1];
            cognom = arrayNom[2];
        } else {
            nom = arrayNom[0];
            cognom = arrayNom[1];
        }


        System.out.print("Escriu el nom de l'equip(Los Angeles Lakers): ");
        nomEquip = scan.nextLine().trim();

        idJug = trovarJugadorId(nomJug);
        idEquip = e.trovarEquipId(nomEquip);


        if (idJug == null) {
            Vista.missatgeJugadorNoTrobat();
            jugador = infoJugador(nom, cognom, idEquip);
            create(jugador);

        } else {
            Vista.missatgeJugadorTrobat();
            do {
                resposta = scan.nextLine().toUpperCase().trim();
                if (resposta.equals("SI")) {
                    jugador = j.read(idJug);
                    jugador.setEquipId(idEquip);
                    j.update(jugador);
                } else {
                    System.out.println("OK!");
                }
            } while (!(resposta.equals("SI") || resposta.equals("NO")));

        }


        return null;
    } //EXERCICI 4

    /**
     * Funció per obtenir tots els valors de la taula de Jugadors per crear-lo.
     * @param nom El nom del jugador.
     * @param c El Cognom del jugador.
     * @param id La id del Equip on anirà.
     * @return Un jugador amb totes les dades.
     */
    public Jugadres infoJugador(String nom, String c, long id) {
        String[] posi = {"Center", "Center-Forward", "Forward", "Forward-Center", "Forward-Guard", "Guard", "Guard-Forward"};
        boolean b = false;
        String s;
        float f;
        Jugadres jug = new Jugadres("", "", "", 0f, 0f, "", "", 0);

        jug.setNom(nom);
        jug.setCognom(c);
        jug.setEquipId(id);

        do {
            System.out.print("Escriu la data de naixement (yyyy-mm-dd): ");
            s = scan.nextLine().trim();
            jug.setDataNaixement(s);
        } while (!s.matches("\\d{4}-\\d{1,2}-\\d{1,2}"));

        System.out.print("Alçada del jugador: ");
        f = scan.nextFloat();
        scan.nextLine();
        jug.setAlcada(f);

        System.out.print("Pes del jugador: ");
        f = scan.nextFloat();
        scan.nextLine();
        jug.setPes(f);

        System.out.print("Dorsal del jugador: ");
        s = scan.nextLine();
        jug.setDorsal(s);

        do {
            System.out.println("Posicións = Center, Center-Forward, Forward, Forward-Center, Forward-Guard, Guard, Guard-Forward.");
            System.out.print("Posició del jugador: ");
            s = scan.nextLine();
            jug.setPosicio(s);

            for (int i = 0; i < posi.length; i++) {
                if (s.equals(posi[i])) {
                    b = true;
                    break;
                }
            }

        } while (!b);

        return jug;
    }

    /**
     * Funció per canviar un jugador a un equip diferent.
     * @return Un jugador amb la id del equip actualitzat a un nou que li passarem
     * @throws Exception Per si peta en alguna de les funcións SQL.
     */
    public Jugadres canviDeEquip() throws Exception {
        JugadoresDAO j = new JugadoresDAO();
        EquipsDAO e = new EquipsDAO();
        Jugadres jugador;
        String nomJug, nomEquip;
        Long idJug, idEquip;

        System.out.print("Nom del jugador(Chris Paul): ");
        nomJug = scan.nextLine().trim();
        try {
            idJug = trovarJugadorId(nomJug);
        } catch (Exception f) {
            System.out.println("No s'ha trobat el Jugador!");
            return null;
        }

        System.out.print("Nom del equip on vols que vagi(Philadelphia 76ers): ");
        nomEquip = scan.nextLine().trim();
        try {
            idEquip = e.trovarEquipId(nomEquip);
        } catch (Exception f) {
            System.out.println("No s'ha trobat el Equip!");
            return null;
        }

        jugador = j.read(idJug);
        jugador.setEquipId(idEquip);
        j.update(jugador);

        return jugador;
    }

}
