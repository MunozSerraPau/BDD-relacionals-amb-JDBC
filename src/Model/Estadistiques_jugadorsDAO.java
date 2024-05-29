package Model;


import Vista.Vista;
import jdk.jshell.ImportSnippet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Estadistiques_jugadorsDAO implements DAO<Estadistiques_jugadors> {

    public static Scanner scan = new Scanner(System.in);
    @Override
    public boolean create(Estadistiques_jugadors estadistiquesJugadors) {
        return false;
    }

    @Override
    public Estadistiques_jugadors read(Long id_jugador) {
        return null;
    }

    /**
     * Funció per actualitzar les estadístiques d'un jugador en un partit concret.
     * @param estadistiquesJugadors Li passem les estadístiques amb els canvis.
     * @return Retornem true conforme s'ha realitzat la funció.
     * @throws SQLException Tira exception per si en algun moment peta amb el UPDATE.
     */
    @Override
    public boolean update(Estadistiques_jugadors estadistiquesJugadors) throws SQLException {
        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "UPDATE estadistiques_jugadors" +
                " SET jugador_id = ?, equip_id = ?, partit_id = ?, minuts_jugats = ?, punts = ?, tirs_anotats = ?, tirs_tirats = ?, tirs_triples_anotats = ?, tirs_triples_tirats = ?, tirs_lliures_anotats = ?, tirs_lliures_tirats = ?, rebots_ofensius = ?, rebots_defensius = ?, assistencies = ?, robades = ?, bloqueigs = ?" +
                " WHERE jugador_id = ? and partit_id = ? ");
        statement.setInt(1, estadistiquesJugadors.getJugadorId());
        statement.setInt(2, estadistiquesJugadors.getEquipId());
        statement.setInt(3, estadistiquesJugadors.getPartitId());
        statement.setFloat(4, estadistiquesJugadors.getMinutsJugats());
        statement.setFloat(5, estadistiquesJugadors.getPunts());
        statement.setInt(6, estadistiquesJugadors.getTirsAnotats());
        statement.setInt(7, estadistiquesJugadors.getTirsTirats());
        statement.setInt(8, estadistiquesJugadors.getTirsTriplesAnotats());
        statement.setInt(9, estadistiquesJugadors.getTirsTriplesTirats());
        statement.setInt(10, estadistiquesJugadors.getTirsLliuresAnotats());
        statement.setInt(11, estadistiquesJugadors.getTirsLliuresTirats());
        statement.setInt(12, estadistiquesJugadors.getRebotsOfensius());
        statement.setInt(13, estadistiquesJugadors.getRebotsDefensius());
        statement.setFloat(14, estadistiquesJugadors.getAssistencies());
        statement.setFloat(15, estadistiquesJugadors.getRobades());
        statement.setFloat(16, estadistiquesJugadors.getBloqueigs());
        statement.setLong(17, estadistiquesJugadors.getJugadorId());
        statement.setLong(18, estadistiquesJugadors.getPartitId());


        int rs  = statement.executeUpdate();
        if (rs == 1) {
            System.out.println("S'ha actualitzat correctament.");
        } else {
            System.out.println("NO s'ha actualitzat.");
        }

        return true;
    }

    @Override
    public boolean delete(Long id_estadistiquesPartit) {
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
     * Llista les estadístiques d'un jugador.
     * @return Retorna una llista amb les estadístiques del jugador.
     * @throws Exception Per si en algun moment peta amb el select
     */
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

        // En aquest cas calculem la mitjana d'un jugador de les seves estadístiques.

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

    /**
     * El que fa és llegir un arxiu extern amb dades per actualitzar un o diferents registres, primer llegim l'arxiu
     * creem una array, ja que està separat per comes i posterior li assignem les dades que hem obtingut del fitxer al
     * registre segons la id del jugador i la id del partit.
     */
    public void exercici6() {
        String rutaArxiu = "src/registres.txt";
        String line;
        int rs = 0;

        try {
            // Estableix la connexió a la base de dades
            Connection connection = Connexio.conectarBD();

            // Prepara la consulta d'actualització
            PreparedStatement statement = connection.prepareStatement( "UPDATE estadistiques_jugadors SET"
                    + " minuts_jugats = ?, punts = ?, tirs_anotats = ?, tirs_tirats = ?, tirs_triples_anotats = ?, tirs_triples_tirats = ?, tirs_lliures_anotats = ?, tirs_lliures_tirats = ?, rebots_ofensius = ?, rebots_defensius = ?, assistencies = ?, robades = ?, bloqueigs = ?"
                    + " WHERE jugador_id = ? and partit_id = ? ");

            // Llegir les dades del fitxer
            BufferedReader llegir = new BufferedReader(new FileReader(rutaArxiu));

            // Agafem tota la línia, i que es repeteixi fins que la line sigui null (que no trobi res)
            while ((line = llegir.readLine())!= null) {

                // CREEM LA ARRAY PER LES ","
                String[] registre = line.split(",");
                // ARA DEPENEN DEL QUE LI TOQUI OBTENIR LI ASSIGNEM UN PARAMETER DE L'ARRAY.
                statement.setFloat(1, Float.parseFloat(registre[3]));       // minuts_jugats
                statement.setInt(2, Integer.parseInt(registre[4]));         // punts
                statement.setInt(3, Integer.parseInt(registre[5]));         // tirs_anotats
                statement.setInt(4, Integer.parseInt(registre[6]));         // tirs_tirats
                statement.setInt(5, Integer.parseInt(registre[7]));         // tirs_triples_anotats
                statement.setInt(6, Integer.parseInt(registre[8]));         // tirs_triples_tirats
                statement.setInt(7, Integer.parseInt(registre[9]));         // tirs_lliures_anotats
                statement.setInt(8, Integer.parseInt(registre[10]));        // tirs_lliures_tirats
                statement.setInt(9, Integer.parseInt(registre[11]));        // rebots_ofensius
                statement.setInt(10, Integer.parseInt(registre[12]));       // rebots_defensius
                statement.setInt(11, Integer.parseInt(registre[13]));       // assistencies
                statement.setInt(12, Integer.parseInt(registre[14]));       // robades
                statement.setInt(13, Integer.parseInt(registre[15]));       // bloqueigs
                statement.setInt(14, Integer.parseInt(registre[0]));        // jugador_id
                statement.setInt(15, Integer.parseInt(registre[2]));        //partit_id

                // I AQUÍ EXECUTEM LA COMANDA
                statement.executeUpdate();

                rs++;
            }

            if (rs >= 1) {
                System.out.println("S'ha actualitzat un total de " + rs + " registres.");
            } else {
                System.out.println("No s'han actualitzat cap registre.");
            }

        } catch (SQLException e) {
            System.out.println("Error actualitzant el registre: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error llegint el fitxer: " + e.getMessage());
        }

    }

    /**
     * Funció per modificar algun valor de les estadístiques d'un partit d'un jugador concret, ens dona un menu i podem
     * modificar una dada concreta.
     * @throws SQLException Per si peta en algun moment al cridar funcions de SQL
     */
    public void exercici7() throws SQLException {
        Estadistiques_jugadorsDAO ejDAO = new Estadistiques_jugadorsDAO();
        JugadoresDAO j = new JugadoresDAO();
        Estadistiques_jugadors ej;
        String nomJug;
        Long idJug, idPar;
        int opcio, i;
        float f;



        System.out.print("Nom del jugador que volem modificar(Chris Paul): ");
        nomJug = scan.nextLine().trim();
        idJug = j.trovarJugadorId(nomJug);

        System.out.print("Id del partit que volem modificar(22300005, 22300051, 22300060, 22300062, 22300087, 22300096): ");
        idPar = scan.nextLong();

        ej = ejDAO.obtenirEstadistiques(idJug, idPar);

        Vista.mostrarEstadistiquesActual(ej);

        // MENU PER PODER EDITAR UN CAP CONCRET
        do {
            Vista.menuEstadistiques();
            System.out.print("Escull una opció (0 per acabar de editar): ");
            opcio = scan.nextInt();
            scan.nextLine();

            switch (opcio) {
                case 0:
                    System.out.println("FINAL.");
                    break;

                case 1:
                    System.out.print("Minuts jugats: ");
                    f = scan.nextFloat();
                    scan.nextLine();
                    ej.setMinutsJugats(f);
                    break;

                case 2:
                    System.out.print("Punts: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setPunts(i);
                    break;

                case 3:
                    System.out.print("Tirs Anotats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsAnotats(i);
                    break;

                case 4:
                    System.out.print("Tirs Tirats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsTirats(i);
                    break;

                case 5:
                    System.out.print("Tirs Triples Anotats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsTriplesAnotats(i);
                    break;

                case 6:
                    System.out.print("Tirs Triples Tirats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsTriplesTirats(i);
                    break;

                case 7:
                    System.out.print("Tirs Lliures Anotats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsLliuresAnotats(i);
                    break;

                case 8:
                    System.out.print("Tirs Lliures Tirats: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setTirsLliuresTirats(i);
                    break;

                case 9:
                    System.out.println("Rebots Ofensius: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setRebotsOfensius(i);
                    break;

                case 10:
                    System.out.print("Rebots Defensius: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setRebotsDefensius(i);
                    break;

                case 11:
                    System.out.print("Assistencies: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setAssistencies(i);
                    break;

                case 12:
                    System.out.print("Robades: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setRobades(i);
                    break;

                case 13:
                    System.out.println("Bloqueigs: ");
                    i = scan.nextInt();
                    scan.nextLine();
                    ej.setBloqueigs(i);
                    break;
                default:
                    System.out.println("Ha de ser un numero entre el 0 i el 13.");
            }
        } while (opcio != 0);

        // UN COP JA LI HEM PASSAT LES ACTUALITZACIONS DE DADES CRIDEM LA FUNCIÓ QUE FA EL UPDATE AMB LES NOVES DADES
        ejDAO.update(ej);
        Vista.mostrarEstadistiquesActual(ej);

    }

    /**
     * Obtenir les estadístiques d'un partit i jugador concret.
     * @param idJugador El id del jugador que volem obtenir.
     * @param idPartit El id del partit que volem obtenir.
     * @return Passem un registre amb les estadístiques del jugador.
     * @throws SQLException Per si peta en algun moment.
     */
    public Estadistiques_jugadors obtenirEstadistiques(Long idJugador, Long idPartit) throws SQLException {
        Estadistiques_jugadors ej = new Estadistiques_jugadors(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM estadistiques_jugadors WHERE jugador_id = ? AND partit_id = ? ");
        statement.setLong(1, idJugador);
        statement.setLong(2, idPartit);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            ej.setJugadorId(resultSet.getInt("jugador_id"));
            ej.setEquipId(resultSet.getInt("equip_id"));
            ej.setPartitId(resultSet.getInt("partit_id"));
            ej.setMinutsJugats(resultSet.getFloat("minuts_jugats"));
            ej.setPunts(resultSet.getInt("punts"));
            ej.setTirsAnotats(resultSet.getInt("tirs_anotats"));
            ej.setTirsTirats(resultSet.getInt("tirs_tirats"));
            ej.setTirsTriplesAnotats(resultSet.getInt("tirs_triples_anotats"));
            ej.setTirsTriplesTirats(resultSet.getInt("tirs_triples_tirats"));
            ej.setTirsLliuresAnotats(resultSet.getInt("tirs_lliures_anotats"));
            ej.setTirsLliuresTirats(resultSet.getInt("tirs_lliures_anotats"));
            ej.setRebotsOfensius(resultSet.getInt("rebots_ofensius"));
            ej.setRebotsDefensius(resultSet.getInt("rebots_defensius"));
            ej.setAssistencies(resultSet.getInt("assistencies"));
            ej.setRobades(resultSet.getLong("robades"));
            ej.setBloqueigs(resultSet.getLong("bloqueigs"));
        } else {
            System.out.println("ERROR no s'ha trobar la estadístiques del Jugadors!");
        }

        return ej;
    }

}
