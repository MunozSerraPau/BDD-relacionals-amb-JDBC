package Controlador;

import Model.*;
import Vista.*;

import java.security.PublicKey;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    public static EquipsDAO equipDAO = new EquipsDAO();
    public static JugadoresDAO jugadorDAO = new JugadoresDAO();
    public static Jugadors_historicsDAO jugadorHistoricDAO = new Jugadors_historicsDAO();
    public static Estadistiques_jugadorsDAO EstadisticaJugador = new Estadistiques_jugadorsDAO();


    public static Scanner scan = new Scanner(System.in);
    public static void Exercicis() {
        String opcioMneu;

        do {
            Vista.mostrarMenuOpcions();
            opcioMneu = scan.nextLine();
            switch (opcioMneu) {

                case "1":
                    List<Jugadres> players;

                    System.out.println("Exercici 1:");
                    try {
                        players = jugadorDAO.all();
                        Vista.mostrarJugadors(players);
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
                    break;


                case "2":
                    List<Estadistiques_jugadors> estadicticaJugador;

                    System.out.println("Exercici 2:");
                    try {
                        estadicticaJugador = EstadisticaJugador.all();
                        Vista.mostrarEstadisticas(estadicticaJugador);
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
                    break;
                    
                case "3":
                    List<Partits> resultatsPartits;
                    PartitsDAO resultatPartitsDAO = new PartitsDAO();

                    System.out.println("Exercici 3:");
                    try {
                        resultatsPartits = resultatPartitsDAO.all();
                        Vista.mostrarPartits(resultatsPartits);
                    } catch (Exception e) {
                        System.out.println("ERRO!! " + e.getMessage());
                    }

                    break;

                case "4":
                    System.out.println("Exercici 4:");

                    try {
                        jugadorDAO.exercici4();
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }

                    break;
                    
                case "5":
                    Jugadres jug;
                    System.out.println("Exercici 5:");
                    try {
                        jug = jugadorDAO.canviDeEquip();
                        if (jug != null) {
                            Vista.mostrarJugadorActualitzat(jug);
                        }
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
                    break;

                case "6":
                    System.out.println("Exercici 6:");

                    try {

                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }

                    break;
                    
                case "7":
                    System.out.println("Exercici 7:");

                    try {
                        EstadisticaJugador.exercici7();
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
                    break;

                case "8":
                    Jugadors_historicsDAO jh;
                    System.out.println("Exercici 8:");
                    try {
                        jugadorHistoricDAO.exercici8();
                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
                    break;

                case "9":
                    Equips equip;
                    System.out.println("Exercici 9:");
                    try {
                        equip = equipDAO.canviarNom();
                        equipDAO.update(equip);

                    } catch (Exception e) {
                        System.out.println("ERRO!! "+ e.getClass() + " | " + e.getMessage());
                    }
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