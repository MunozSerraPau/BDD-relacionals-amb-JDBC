package Model;

import Vista.Vista;

import java.sql.*;
import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadoresDAO implements DAO<Jugadres> {
    public static Scanner scan = new Scanner(System.in);

    @Override
    public boolean create(Jugadres jugadres) throws Exception {
        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO `jugadors` (`nom`, `cognom`, `data_naixement`, `alcada`, `pes`, `dorsal`, `posicio`, `equip_id`) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?),");
        statement.setString(1, jugadres.getNom());
        statement.setString(2, jugadres.getCognom());
        statement.setString(3, jugadres.getDataNaixement());
        statement.setFloat(4, jugadres.getAlcada());
        statement.setFloat(5, jugadres.getPes());
        statement.setString(6, jugadres.getDorsal());
        statement.setString(7, jugadres.getPosicio());
        statement.setLong(8, jugadres.getEquipId());
        ResultSet resultSet = statement.executeQuery();

        return true;
    }

    @Override
    public Jugadres read(Long id_jugador) throws SQLException {
        Jugadres j = new Jugadres(0, "", "", "", 0f, 0f, "", "", 0);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM jugadors WHERE jugador_id = ?");
        statement.setLong(2, id_jugador);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            j.setJugadorId(resultSet.getInt("jugador_id"));
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

    @Override
    public boolean update(Jugadres jugadres) throws Exception {

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "UPDATE jugadors" +
                        "SET jugador_id = ?, nom = ?, cognom = ?, data_naixement = ?, alcada = ?, pes = ?, dorsal = ?, posicio = ?, equip_id = ? " +
                        "WHERE id = 2;");
        statement.setLong(1, jugadres.getJugadorId());
        statement.setString(2, jugadres.getNom());
        statement.setString(3, jugadres.getCognom());
        statement.setString(4, jugadres.getDataNaixement());
        statement.setFloat(5, jugadres.getAlcada());
        statement.setFloat(6, jugadres.getPes());
        statement.setString(7, jugadres.getDorsal());
        statement.setString(8, jugadres.getPosicio());
        statement.setLong(9, jugadres.getEquipId());
        ResultSet resultSet = statement.executeQuery();

        return false;
    }

    @Override
    public boolean delete(Jugadres jugadres) {
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
    public List<Jugadres> all() throws Exception {
        String nomEquip;
        Long idEquip;
        List<Jugadres> players = new ArrayList<>();
        EquipsDAO e = new EquipsDAO();

        Connection connection = Connexio.conectarBD();

        System.out.print("Escriu el nom del equip: ");
        nomEquip = scan.nextLine().trim();
        idEquip = e.trovarEquipId(nomEquip);

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

    public Jugadres exercici4() throws Exception {
        String nomJug, nomEquip, nom = "", cognom = "", resposta;
        String[] arrayNom;
        Long idJug, idEquip;
        JugadoresDAO j = new JugadoresDAO();
        Jugadres jugador;
        EquipsDAO e = new EquipsDAO();


        System.out.print("Escriu el nom i cognoms d'un Jugador (LeBron James): ");
        nomJug = scan.nextLine().trim();

        if (nomJug.matches("\\w+\\s\\w+")){
            arrayNom = nomJug.split(" ");
            if (arrayNom.length > 2) {
                nom = arrayNom[0] + " " + arrayNom[1];
                cognom = arrayNom[2];
            } else {
                nom = arrayNom[0];
                cognom = arrayNom[1];
            }
        }


        System.out.print("Escriu el nom de l'equip: ");
        nomEquip = scan.nextLine().trim();

        idJug = trovarJugadorId(nomJug);
        idEquip = e.trovarEquipId(nomEquip);


        if (idJug == null) {
            Vista.missatgeJugadorNoTrobat();
            j.create(infoJugador(nom, cognom, idEquip));

        } else {
            Vista.missatgeJugadorTrobat();
            do {
                resposta = scan.nextLine().toUpperCase().trim();
                if (resposta.equals("S")) {
                    jugador = j.read(idJug);
                    jugador.setEquipId(idEquip);
                    j.update(jugador);
                } else {
                    System.out.println("OK!");
                }
            } while (resposta.equals("S") || resposta.equals("N"));

        }


        return null;
    } //EXERCICI 4

    public Jugadres infoJugador(String n, String c, long id) {
        String[] posi = {"Center", "Center-Forward", "Forward", "Forward-Center", "Forward-Guard", "Guard", "Guard-Forward"};
        boolean b = false;
        String s;
        float f;
        Jugadres jug = new Jugadres(n, c, "", 0f, 0f, "", "", id);

        do {
            System.out.print("Escriu la data de naixement (yyyy-mm-dd): ");
            n = scan.nextLine().trim();
            jug.setDataNaixement(n);
        } while (!n.matches("\\d{4}-\\d{1,2}-\\d{1,2}"));

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
            n = scan.nextLine();
            jug.setDorsal(n);

            for (int i = 0; i < posi.length; i++) {
                if (n.equals(posi[i])) {
                    b = true;
                    break;
                }
            }

        } while (!b);

        return jug;
    }

}
