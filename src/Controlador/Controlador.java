package Controlador;

import Model.*;
import Vista.*;

import java.sql.Connection;
import java.util.Scanner;

public class Controlador {
    public static Scanner scan = new Scanner(System.in);
    public static void Exercicis() {
        String opcioMneu;
        Connection connexio = Connexio.conectarBD("jdbc:mysql://10.94.255.110:3306/NBA", "perepi", "pastanaga");

        do {
            Vista.mostrarMenuOpcions();
            opcioMneu = scan.nextLine();
            switch (opcioMneu) {

                case "1":
                    System.out.println("Exercici 1:");
                    Connexio.exercici1(connexio);
                    break;

                case "2":
                    System.out.println("Exercici 2:");
                    break;
                    
                case "3":
                    System.out.println("Exercici 3:");
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
                    Connexio.desconectarBD(connexio);
                    break;

                default:
                    System.out.println("Ha de ser un numero entre el 0 i el 10!");
            }


        } while (!opcioMneu.equals("0"));

    }
}