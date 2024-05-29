package Vista;

import Model.*;

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.List;

public class Vista {

    /**
     * Mostra el menu d'opcións dels diferents exerciser.
     */
    public static void mostrarMenuOpcions() {
        System.out.println("MENÚ DE EXERCICIS");
        System.out.println("---------------------------------");
        System.out.println("1.- Llistar tots els jugadors d'un equip");
        System.out.println("2.- Calcular la mitjana de punts, rebots, assistències, ... d'un jugador");
        System.out.println("3.- Llistar tots els partits jugats per un equip amb el seu resultat.");
        System.out.println("4.- Inserir un nou jugador a un equip.");
        System.out.println("5.- Traspassar un judador a un altra equip");
        System.out.println("6.- Actualitzar les dades de jugadors o equips després d'un partit.");
        System.out.println("7.- Modificar les estadístiques d’un jugador");
        System.out.println("8.- Retirar (Eliminar) un jugador.");
        System.out.println("9.- Canviar nom franquícia d’un equip");
        System.out.println("O - Sortir del programa");
        System.out.println("---------------------------------");
        System.out.print("Quina opció vols (escriu només el numero)? ");
    }

    /**
     * Mostra una llista de jugadors
     * @param llistaJugadors La llista de jugadors que volem mostrar.
     */
    public static void mostrarJugadors(List<Jugadres> llistaJugadors) {
        for (Jugadres j : llistaJugadors) {
            System.out.println("Jugador: " + j.getNom() + " " + j.getCognom());
        }
        llistaJugadors.clear();
    }

    /**
     * Mostra una llista de partits
     * @param llistaPartits La llista dels partits que volem mostrar
     */
    public static void mostrarPartits(List<Partits> llistaPartits) {
        int contador = 1;
        for (int i = 0; i < llistaPartits.size(); i++) {
            if (i % 2 == 0) {
                System.out.println("Partit " + contador + ":");
                System.out.println(llistaPartits.get(i).getDataPartit() + ": " + llistaPartits.get(i).getEquipId());
                ++contador;
            } else {
                System.out.println(llistaPartits.get(i).getDataPartit() + ": " + llistaPartits.get(i).getEquipId() + "\n");
            }
        }
    }

    /**
     * Mostrem una llista d'estadístiques.
     * @param llistaEstadistiques La llista amb les estadístiques.
     */
    public static void mostrarEstadisticas(List<Estadistiques_jugadors> llistaEstadistiques) {
        for (Estadistiques_jugadors e : llistaEstadistiques) {
            System.out.println("Estadístiques / Partit: \n" +
                    "\tPunts: " + e.getPunts() + "\n" +
                    "\tAssistencies: " + e.getAssistencies() + "\n" +
                    "\tRobades: " + e.getRobades() + "\n" +
                    "\tBloqueigs: " + e.getBloqueigs());
        }
        llistaEstadistiques.clear();
    }

    /**
     * Missatge conforme hem trobat el jugador
     */
    public static void missatgeJugadorTrobat() {
        System.out.println("\nHi ha un jugador amb aquest nom, ja existeix aquest jugador!");
        System.out.println("Vols que canvi al equip que has introduït? (Si | No)\n");
    }

    /**
     * Missatge conforme no hem trobat el jugador.
     */
    public static void missatgeJugadorNoTrobat() {
        System.out.println("\nNo s'ha trobat cap jugador amb aquest nom!");
        System.out.println("Ara crearem el jugador, amb el nom que has introduït i al equip que has seleccionat.\n");
    }

    /**
     * Mostra algunes dades del nou jugador que hem afegit.
     * @param jugador Les dades del jugador que hem creat
     * @param i El numero de jugadors creats
     */
    public static void mostrarJugadorNou(Jugadres jugador, int i) {

        System.out.println("\nS'han crear un total de " + i + " jugadors. Aquí les seves dades.");
        System.out.println("Nom: " + jugador.getNom() + " " + jugador.getCognom() +
                "\nAlçada: " + jugador.getAlcada() +
                "\nPes: " + jugador.getPes() +
                "\nDorsal: " + jugador.getDorsal() +
                "\nPosició: " + jugador.getPosicio());
    }

    /**
     * Mostrem algunes dades d'un jugador un cop actualitzat.
     * @param jugador El jugador amb les dades actualitzades.
     */
    public static void mostrarJugadorActualitzat(Jugadres jugador) {

        System.out.println("\nS'ha actualitzat un jugador. Aquí les seves dades.");
        System.out.println("Nom: " + jugador.getNom() + " " + jugador.getCognom() +
                "\nAlçada: " + jugador.getAlcada() +
                "\nPes: " + jugador.getPes() +
                "\nDorsal: " + jugador.getDorsal() +
                "\nPosició: " + jugador.getPosicio() +
                "\nEquipId: " + jugador.getEquipId());
    }

    /**
     * Mostrem el registre dle jugador Historic que hem afegit.
     * @param jugHisto Les dades del jugador historic que mostrarem.
     */
    public static void mostrarJugadorHistoric(Jugadors_historics jugHisto) {
        System.out.println("\nS'ha actualitzat un jugador. Aquí les seves dades.");
        System.out.println("Nom: " + jugHisto.getNom() + " " + jugHisto.getCognom() +
                "\nDorsal: " + jugHisto.getDorsal() +
                "\nPosició: " + jugHisto.getPosicio() +
                "\nPunts Totals anotats: " + jugHisto.getPuntsTotals() +
                "\nMinuts Totals jugats: " + jugHisto.getMinutsTotals() +
                "\nAssistències Totals : " + jugHisto.getTotalAssistencies() +
                "\nRobades Totals: " + jugHisto.getTotalRobades() +
                "\nTotal de Triples Anotats: " + jugHisto.getTotalTriplesAnotats());
    }

    /**
     * Mostrem les estadístiques d'un jugador
     * @param ej Les estadístiques del jugador.
     */
    public static void mostrarEstadistiquesActual(Estadistiques_jugadors ej) {
        System.out.println("\nDades del jugador:");
        System.out.println("Jugador ID: " + ej.getJugadorId());
        System.out.println("Equip ID: " + ej.getEquipId());
        System.out.println("Partit ID: " + ej.getPartitId());
        System.out.println("Minuts jugats: " + ej.getMinutsJugats());
        System.out.println("Punts: " + ej.getPunts());
        System.out.println("Tirs anotats: " + ej.getTirsAnotats());
        System.out.println("Tirs tirats: " + ej.getTirsTirats());
        System.out.println("Tirs triples anotats: " + ej.getTirsTriplesAnotats());
        System.out.println("Tirs triples tirats: " + ej.getTirsTriplesTirats());
        System.out.println("Tirs lliures anotats: " + ej.getTirsLliuresAnotats());
        System.out.println("Tirs lliures tirats: " + ej.getTirsLliuresTirats());
        System.out.println("Rebots ofensius: " + ej.getRebotsOfensius());
        System.out.println("Rebots defensius: " + ej.getRebotsDefensius());
        System.out.println("Assistencies: " + ej.getAssistencies());
        System.out.println("Robades: " + ej.getRobades());
        System.out.println("Bloqueigs: " + ej.getBloqueigs() + "\n");
    }

    /**
     * Mostrem el menu per canviar estadístiques.
     */
    public static void menuEstadistiques() {
        System.out.println("Selecciona una opció:");
        System.out.println("1. Estableix minutsJugats");
        System.out.println("2. Estableix punts");
        System.out.println("3. Estableix tirsAnotats");
        System.out.println("4. Estableix tirsTirats");
        System.out.println("5. Estableix tirsTriplesAnotats");
        System.out.println("6. Estableix tirsTriplesTirats");
        System.out.println("7. Estableix tirsLliuresAnotats");
        System.out.println("8. Estableix tirsLliuresTirats");
        System.out.println("9. Estableix rebotsOfensius");
        System.out.println("10. Estableix rebotsDefensius");
        System.out.println("11. Estableix assistencies");
        System.out.println("12. Estableix robades");
        System.out.println("13. Estableix bloqueigs");
        System.out.println("0. Acabar");
    }

}