package Controlador;

import Model.*;

import java.sql.Connection;
import java.util.Scanner;

public class Controlador {
    public static Scanner scan = new Scanner(System.in);
    public static void Exercicis() {
        String opcioMneu;
        Connection connexio = Model.conectarBD("jdbc:mysql://10.94.255.110:3306/NBA", "perepi", "pastanaga");

        do {
            mostrarMenuOpcions();
            opcioMneu = scan.nextLine();
            switch (opcioMneu) {

                case "1":
                    System.out.println("Exercici 1 ():");
                    break;

                case "2":
                    System.out.println("Exercici 2 ():");
                    break;

                case "0":
                    Model.desconectarBD(connexio);
                    break;

                default:
                    System.out.println("Ha de ser un numero entre el 0 i el 10!");
            }


        } while (!opcioMneu.equals("0"));


    }

    private static void mostrarMenuOpcions() {
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

}