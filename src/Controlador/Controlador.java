package Controlador;

import Model.*;
import Vista.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    public static Scanner scan = new Scanner(System.in);
    public static void Exercicis() {
        String opcioMneu;

        do {
            Vista.mostrarMenuOpcions();
            opcioMneu = scan.nextLine();
            switch (opcioMneu) {

                case "1":
                    List<Jugadres> players;
                    JugadoresDAO llistaPlayer = new JugadoresDAO();

                    System.out.println("Exercici 1:");
                    try {
                        players = llistaPlayer.all();
                        Vista.mostrarJugadors(players);
                    } catch (Exception e) {
                        System.out.println("ERRO!! " + e.getMessage());
                    }
                    break;


                case "2":
                    List<Estadistiques_jugadors> estadicticaJugador;
                    Estadistiques_jugadorsDAO estadJug = new Estadistiques_jugadorsDAO();

                    System.out.println("Exercici 2:");
                    try {
                        estadicticaJugador = estadJug.all();
                        Vista.mostrarEstadisticas(estadicticaJugador);
                    } catch (Exception e) {
                        System.out.println("ERRO!! " + e.getMessage());
                    }
                    break;
                    
                case "3":
                    //List<Estadistiques_jugadors> estadicticaJugador;
                    //Estadistiques_jugadorsDAO estadJug = new Estadistiques_jugadorsDAO();

                    System.out.println("Exercici 3:");
                    //try {
                    //    estadicticaJugador = estadJug.all();
                    //    Vista.mostrarEstadisticas(estadicticaJugador);
                    //} catch (Exception e) {
                    //    System.out.println("ERRO!! " + e.getMessage());
                    //}

                    break;

                case "4":
                    System.out.println("Exercici 4:");
                    break;
                    
                case "5":
                    System.out.println("Exercici 5:");
                    break;

                case "6":
                    System.out.println("Exercici 6:");
                    break;
                    
                case "7":
                    System.out.println("Exercici 7:");
                    break;

                case "8":
                    System.out.println("Exercici 8:");
                    break;

                case "9":
                    System.out.println("Exercici 9:");
                    break;

                case "0":
                    Connexio.desconectarBD(Connexio.conectarBD());
                    System.out.println("S'ha desconnectar de la Base de Dades.");
                    break;

                default:
                    System.out.println("Ha de ser un numero entre el 0 i el 10!");
            }


        } while (!opcioMneu.equals("0"));

    }
}