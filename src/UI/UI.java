/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

public class UI {

    private final Scanner input = new Scanner(System.in);

    public int menu(boolean check) {
        if (check) {
            System.out.println("\nBienvenido al menú"
                    + "\n--------------\nEliga una opción:\n"
                    + "\nPresione 1 para registrar un usuario"
                    + "\nPresione 2 para listar los usuarios existentes"
                    + "\nPresione 3 para registrar un material"
                    + "\nPresione 4 para listar los materiales"
                    + "\nPresione 8 para salir");
        } else if (!check) {
            System.out.println("\nOpción inválida. Intente nuevamente.");
        }

        return readInt();

    }

    public int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public String readString() {
        return input.nextLine();
    }

    public void imprimir(String string) {
        System.out.println(string);
    }

    public double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (NumberFormatException ex) {
            return 8;
        }
    }

}
