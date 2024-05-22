package Vista;

import Model.Estadistiques_jugadors;
import Model.Estadistiques_jugadorsDAO;
import Model.Jugadres;

import java.util.ArrayList;
import java.util.List;

public class Vista {
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
    public static void mostrarJugadors(List<Jugadres> llistaJugadors) {
        for (Jugadres j : llistaJugadors) {
            System.out.println("Jugador: " + j.getNom() + " " + j.getCognom());
        }
        llistaJugadors.clear();
    }
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
    public static void missatgeJugadorTrobat() {
        System.out.println("Hi ha un jugador amb aquest nom, ja existeix aquest jugador!");
        System.out.println("Vols que canvi al equip que has introduït? (S = Si | N = No)");
    }
    public static void missatgeJugadorNoTrobat() {
        System.out.println("No s'ha trobat cap jugador amb aquest nom!");
        System.out.println("Ara crearem el jugador, amb el nom que has introduït i al equip que has seleccionat.");
    }
    public static void mostrarJugador(Jugadres jugadr) {
        System.out.println("Nom: " + jugadr.getNom() + " " + jugadr.getCognom() +
                "\nAlçada: " + jugadr.getAlcada() +
                "\nPes: " + jugadr.getPes() +
                "\nDorsal: " + jugadr.getDorsal() +
                "\nPosició: " + jugadr.getPosicio());
    }


}