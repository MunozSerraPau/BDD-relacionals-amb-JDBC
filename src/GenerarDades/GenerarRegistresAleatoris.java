package GenerarDades;

import Model.Connexio;

import java.sql.*;

public class GenerarRegistresAleatoris  {
    public static void generarTot() throws SQLException {
        generarEquips();
        generarJugadors();
        generarPartits();
        generarEstadistiques();
        generarJugHistorics();
    }
    public static void generarEquips() throws SQLException {

        System.out.println("Creant registres de equips... ");

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("CREATE TABLE equips ("
                + "equip_id int unsigned NOT NULL AUTO_INCREMENT, "
                + "ciutat varchar(50) NOT NULL, "
                + "nom varchar(50) NOT NULL, "
                + "acronim char(3) NOT NULL, "
                + "divisio varchar(50) NOT NULL, "
                + "guanyades tinyint unsigned NOT NULL DEFAULT '0', "
                + "perdudes tinyint unsigned NOT NULL DEFAULT '0', "
                + "PRIMARY KEY (equip_id) )" );
        statement.executeUpdate();
        statement.close();

        String[] equipAleatori = {
                "Bulls", "Lakers", "Celtics", "Warriors",
                "Spurs", "Knicks", "Heat", "Rockets",
                "Nets", "Mavericks", "Clippers", "Suns",
                "76ers", "Bucks", "Raptors", "Jazz",
                "Nuggets", "Pacers", "Thunder", "Trail Blazers",
                "Pelicans", "Timberwolves", "Kings", "Wizards",
                "Pistons", "Hornets", "Magic", "Grizzlies",
                "Hawks", "Cavaliers" };

        String[] ciutatAleatoria = {
                "Chicago", "Los Angeles", "Boston", "San Francisco",
                "San Antonio", "New York", "Miami", "Houston",
                "Brooklyn", "Dallas", "Los Angeles", "Phoenix",
                "Philadelphia", "Milwaukee", "Toronto", "Salt Lake City",
                "Denver", "Indianapolis", "Oklahoma City", "Portland",
                "New Orleans", "Minneapolis", "Sacramento", "Washington D.C.",
                "Detroit", "Charlotte", "Orlando", "Memphis",
                "Atlanta", "Cleveland" };

        String[] divisioAleatoria = { "Southeast", "Atlantic", "Central", "Southwest", "Northwest", "Pacific" };

        int equip_id;
        String ciutat;
        String nom;
        String acronim;
        String divisio;
        int guanyades;
        int perdudes;
        int numAleatori;

        for (int i = 0; i < 30; ++i){

            equip_id = i;
            ciutat = ciutatAleatoria[i];
            nom = equipAleatori[i];
            acronim = ciutat.substring(0,3).toUpperCase();
            numAleatori = (int) (Math.random() * 6);
            divisio = divisioAleatoria[numAleatori];
            guanyades = (int) (Math.random() * 100 + 1);
            perdudes = (int) (Math.random() * 100 + 1);


            try {
                statement = connection.prepareStatement("INSERT INTO equips (equip_id, ciutat, nom, acronim, divisio, guanyades, perdudes)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?)" );

                statement.setInt(1, equip_id);
                statement.setString(2, ciutat);
                statement.setString(3, nom);
                statement.setString(4, acronim);
                statement.setString(5, divisio);
                statement.setInt(6, guanyades);
                statement.setInt(7, perdudes);

                statement.executeUpdate();
            } catch (Exception ex) {
                System.out.println("EROR");
            }

        }
    }
    public static void generarJugadors() throws SQLException {

        System.out.println("Creant registres de Jugadors...");

        Connection connection = Connexio.conectarBD();

        String[] nomsAleatoris = {
                "Maria", "Juan", "Ana", "Pedro", "Laura", "Carlos", "Sofia", "Javier", "Lucia", "David",
                "Carmen", "Miguel", "Elena", "Jose", "Isabel", "Manuel", "Marta", "Raul", "Sara", "Luis",
                "Cristina", "Antonio", "Paula", "Francisco", "Andrea", "Alejandro", "Patricia", "Sergio", "Claudia", "Fernando",
                "Alicia", "Adrian", "Nuria", "Daniel", "Lorena", "Jorge", "Eva", "Alberto", "Julia", "Ricardo",
                "Marina", "Roberto", "Rosa", "Vicente", "Alba", "Joaquin", "Teresa", "Angel", "Monica", "Ruben",
                "Oriol", "Nuria", "Pau", "Laia", "Marc", "Anna", "Pol", "Marta", "Arnau", "Julia",
                "Nil", "Aina", "Roger", "Clara", "Jan", "Marina", "Eric", "Carla", "Joan", "Mireia",
                "Bruna", "Adria", "Laura", "Gerard", "Emma", "David", "Paula", "Alex", "Helena", "Marti",
                "Roc", "Silvia", "Hugo", "Gemma", "Aleix", "Ivet", "Quim", "Rita", "Ferran", "Elisabet",
                "Guillem", "Berta", "Raul", "Lluisa", "Toni", "Teresa", "Victor", "Rosa", "Jordi", "Blanca"
        };
        String[] cognomsAleatoris = {
                "Ferrer", "Serra", "Pujol", "Font", "Vila", "Roca", "Soler", "Balcells", "Torras", "Fabregas",
                "Puig", "Mas", "Bosch", "Valls", "Castells", "Martorell", "Ros", "Segura", "Viladomat", "Mir",
                "Canals", "Pons", "Casas", "Gomis", "Grau", "Sanz", "Bonet", "Ribas", "Bordas", "Costa",
                "Morera", "Domenech", "Llobet", "Pla", "Espinosa", "Noguera", "Alegre", "Bau", "Blanch", "Calvet",
                "Coll", "Esteve", "Figueras", "Forn", "Fuster", "Guardia", "Lluch", "Mateu", "Oliva", "Rovira",
                "Garcia", "Martinez", "Lopez", "Sanchez", "Gonzalez", "Rodriguez", "Fernandez", "Perez", "Martin", "Gomez",
                "Ruiz", "Hernandez", "Diaz", "Moreno", "Alvarez", "Jimenez", "Romero", "Navarro", "Torres", "Dominguez",
                "Vazquez", "Ramos", "Gil", "Ramirez", "Serrano", "Blanco", "Molina", "Morales", "Susrez", "Ortega",
                "Delgado", "Castro", "Ortiz", "Rubio", "Marin", "Sanz", "Iglesias", "Nunez", "Garrido", "Cruz",
                "Calvo", "Mendez", "Pastor", "Moya", "Rojas", "Santos", "Guerrero", "Cano", "Vega", "Campos"
        };

        String[] posicioAleatoria = {"Center", "Center-Forward", "Forward", "Forward-Center", "Forward-Guard", "Guard", "Guard-Forward"};

        int jugador_id;
        String nom;
        String cognom;
        String data_naixement;
        float alcada;
        float pes;
        int dorsal;
        String posicio;
        int equip_id;

        PreparedStatement statement = connection.prepareStatement("CREATE TABLE jugadors ("
            + "jugador_id int unsigned NOT NULL AUTO_INCREMENT, "
            + "nom varchar(150) NOT NULL, "
            + "cognom varchar(150) NOT NULL, "
            + "data_naixement date DEFAULT NULL, "
            + "alcada decimal(5,2) unsigned DEFAULT NULL, "
            + "pes decimal(5,2) unsigned DEFAULT NULL, "
            + "dorsal char(2) NOT NULL, "
            + "posicio varchar(25) NOT NULL, "
            + "equip_id int unsigned NOT NULL, "
            + "PRIMARY KEY (jugador_id), "
            + "KEY fk_jugadors_equips (equip_id) )" );
        statement.executeUpdate();
        statement.close();

        for (int i = 0; i < 100; ++i) {

            int any;
            int mes;
            int dia;
            int numAleatori;

            jugador_id = i;
            nom = nomsAleatoris[i];
            cognom = cognomsAleatoris[i];
            any = (int) (Math.random() * (2020 - 1985 + 1)) + 1985;
            mes = (int) (Math.random() * 12 + 1);
            dia = (int) (Math.random() * 31 + 1);

            data_naixement = any + "-" + mes + "-" + dia;

            alcada = (float) (Math.random() * 235);
            pes = (float) (Math.random() * 150 + 1);
            dorsal = (int) (Math.random() * 99 + 1);
            numAleatori = (int) (Math.random() * 7);
            posicio = posicioAleatoria[numAleatori];
            equip_id = (int) (Math.random() * 29 + 1);


            PreparedStatement statement2;
            try {
                statement2 = connection.prepareStatement("INSERT INTO jugadors (jugador_id, nom, cognom, data_naixement, alcada, pes, dorsal, posicio, equip_id)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" );
                statement2.setInt(1, jugador_id);
                statement2.setString(2, nom);
                statement2.setString(3, cognom);
                statement2.setString(4, data_naixement);
                statement2.setFloat(5, alcada);
                statement2.setFloat(6, pes);
                statement2.setInt(7, dorsal);
                statement2.setString(8, posicio);
                statement2.setInt(9, equip_id);

                statement2.executeUpdate();
            } catch (Exception e) {
                System.out.println("ERROR no s'ha pogut crear.");
            }

        }

    }
    public static void generarPartits() throws SQLException {

        System.out.println("Creant registres de Partits... ");

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement( "CREATE TABLE partits ("
                + "partit_id int unsigned NOT NULL AUTO_INCREMENT, "
                + "equip_id int unsigned NOT NULL, "
                + "data_partit date NOT NULL, "
                + "matx VARCHAR(30) NOT NULL, "
                + "resultat char(1) NOT NULL, "
                + "PRIMARY KEY (partit_id, equip_id), "
                + "KEY fk_partits_equips (equip_id) )" );
        statement.executeUpdate();
        statement.close();

        String[] acronimAleatori = {
                "Chi", "Los", "Bos", "San",
                "San", "New", "Mia", "Hou",
                "Bro", "Dal", "Los", "Pho",
                "Phi", "Mil", "Tor", "Sal",
                "Den", "Ind", "Okl", "Por",
                "New", "Min", "Sac", "Was",
                "Det", "Cha", "Orl", "Mem",
                "Atl", "Cle" };

        String[] tipusPartit = { "VS.","@" };
        String[] winLos = { "W","L" };

        int partit_id;
        int equip_id;
        Date data_partit;
        String matx;
        String resultat;

        for (int i = 0; i < 100; ++i){

            int any;
            int mes;
            int dia;
            int acronim1;
            int acronim2;
            int tipus;
            int resultatAleatori;

            partit_id = i;
            equip_id = (int) (Math.random() * 30 + 1);

            any = (int) (Math.random() * (2025 - 1985 + 1)) + 1985;
            mes = (int) (Math.random() * 12 + 1);
            dia = (int) (Math.random() * 31 + 1);

            data_partit = Date.valueOf(any + "-" + mes + "-" + dia);

            acronim1 = (int) (Math.random() * 30);
            acronim2 = (int) (Math.random() * 30);
            tipus = (int) (Math.random() * 2);

            matx = acronimAleatori[acronim1] + " " +  tipusPartit[tipus] + " "+ acronimAleatori[acronim2];

            resultatAleatori = (int) (Math.random() * 2);
            resultat = winLos[resultatAleatori];

            try {
                statement = connection.prepareStatement("INSERT INTO partits (partit_id, equip_id, data_partit, matx, resultat)" +
                        " VALUES (?, ?, ?, ?, ?)" );

                statement.setInt(1, partit_id);
                statement.setInt(2, equip_id);
                statement.setDate(3, (data_partit));
                statement.setString(4, matx);
                statement.setString(5, resultat);

                statement.executeUpdate();
                statement.close();
            } catch (Exception ex) {
                System.out.println("ERROR");
            }

        }
    }
    public static void generarEstadistiques() throws SQLException {
        System.out.println("Creant registres de estadístiques de Jugadors...");

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("CREATE TABLE estadistiques_jugadors ("
                + "jugador_id int unsigned NOT NULL AUTO_INCREMENT, "
                + "equip_id int unsigned NOT NULL, "
                + "partit_id int unsigned NOT NULL, "
                + "minuts_jugats decimal(5,3) unsigned NOT NULL, "
                + "punts tinyint unsigned NOT NULL, "
                + "tirs_anotats tinyint unsigned NOT NULL, "
                + "tirs_tirats tinyint unsigned NOT NULL, "
                + "tirs_triples_anotats tinyint unsigned NOT NULL, "
                + "tirs_triples_tirats tinyint unsigned NOT NULL, "
                + "tirs_lliures_anotats tinyint unsigned NOT NULL, "
                + "tirs_lliures_tirats tinyint unsigned NOT NULL, "
                + "rebots_ofensius tinyint unsigned NOT NULL, "
                + "rebots_defensius tinyint unsigned NOT NULL, "
                + "assistencies tinyint unsigned NOT NULL, "
                + "robades tinyint unsigned NOT NULL, "
                + "bloqueigs tinyint unsigned NOT NULL, "
                + "PRIMARY KEY (jugador_id, equip_id, partit_id), "
                + "KEY fk_estadistiques_jugadors_partits (partit_id, equip_id) ) ");

        statement.executeUpdate();
        statement.close();

        int jugador_id;
        int partit_id;
        float minuts_jugats;
        int punts;
        int tirs_anotats;
        int tirs_tirats;
        int tirs_triples_anotats;
        int tirs_triples_tirats;
        int tirs_lliures_anotats;
        int tirs_lliures_tirats;
        int rebots_ofensius;
        int rebots_defensius;
        int assistencies;
        int robades;
        int bloqueigs;


        for (int i = 0; i < 100; ++i) {

            jugador_id = (int) (Math.random() * 99 + 1);
            partit_id = (int) (Math.random() * 99 + 1);
            minuts_jugats = (float) (Math.random() * 48 + 1);
            punts = (int) ((Math.random() * 73 + 1));

            tirs_tirats = (int) (Math.random() * 50 + 1);
            tirs_anotats = (int) (Math.random() * tirs_tirats + 1);

            tirs_triples_tirats = (int) (Math.random() * 30 + 1);
            tirs_triples_anotats = (int) (Math.random() * tirs_triples_tirats + 1);

            tirs_lliures_tirats = (int) (Math.random() * 40 + 1);
            tirs_lliures_anotats = (int) (Math.random() * tirs_lliures_tirats + 1);

            rebots_ofensius = (int) (Math.random() * 15 + 1);
            rebots_defensius = (int) (Math.random() * 15 + 1);
            assistencies = (int) (Math.random() * 15 + 1);
            robades = (int) (Math.random() * 10 + 1);
            bloqueigs = (int) (Math.random() * 10 + 1);

            try {
                statement = connection.prepareStatement( "INSERT INTO estadistiques_jugadors (jugador_id, partit_id, minuts_jugats, punts, tirs_anotats, tirs_tirats, tirs_triples_anotats, tirs_triples_tirats, tirs_lliures_anotats, tirs_lliures_tirats, rebots_ofensius, rebots_defensius, assistencies, robades, bloqueigs)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" );

                statement.setInt(1, jugador_id);
                statement.setInt(2, partit_id);
                statement.setFloat(3, minuts_jugats);
                statement.setInt(4, punts);
                statement.setInt(5, tirs_anotats);
                statement.setInt(6, tirs_tirats);
                statement.setInt(7, tirs_triples_anotats);
                statement.setInt(8, tirs_triples_tirats);
                statement.setInt(9, tirs_lliures_anotats);
                statement.setInt(10, tirs_lliures_tirats);
                statement.setInt(11, rebots_ofensius);
                statement.setInt(12, rebots_defensius);
                statement.setInt(13, assistencies);
                statement.setInt(14, robades);
                statement.setInt(15, bloqueigs);

                statement.executeUpdate();

            } catch (Exception ex) {
                System.out.println("ERROR a les estadistiques!");
            }
        }
    }
    public static void generarJugHistorics() throws SQLException {
        System.out.println("Creant taula Jugadors Històrics...");

        Connection connection = Connexio.conectarBD();

        PreparedStatement statement = connection.prepareStatement("CREATE TABLE jugadors_historics ("
                + "jugador_id int unsigned NOT NULL, "
                + "nom varchar(150) NOT NULL, "
                + "cognom varchar(150) NOT NULL, "
                + "dorsal char(2) NOT NULL, "
                + "posicio varchar(25) NOT NULL, "
                + "minutsTotals float unsigned NOT NULL, "
                + "puntsTotals int unsigned NOT NULL, "
                + "totalTirsAnotats int unsigned NOT NULL, "
                + "totalTirsTirats int unsigned NOT NULL, "
                + "totalTriplesAnotats int unsigned NOT NULL, "
                + "totalTriplesTirats int unsigned NOT NULL, "
                + "totalLliuresAnotats int unsigned NOT NULL, "
                + "totalLliuresTirats int unsigned NOT NULL, "
                + "totalRebotsOfensius int unsigned NOT NULL, "
                + "totalRebotsDefensius int unsigned NOT NULL, "
                + "totalAssistencies int unsigned NOT NULL, "
                + "totalRobades int unsigned NOT NULL, "
                + "totalBloqueigs int unsigned NOT NULL, "
                + "PRIMARY KEY (jugador_id)"
                + ") ENGINE=InnoDB;");

        statement.executeUpdate();
        statement.close();
    }

}
