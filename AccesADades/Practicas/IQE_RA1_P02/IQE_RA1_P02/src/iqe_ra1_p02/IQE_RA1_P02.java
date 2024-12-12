/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra1_p02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author AluCiclesGS1
 */
public class IQE_RA1_P02 {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opcio = 0;
        Scanner teclado = new Scanner(System.in); //Creem objecte de escáner o lectura
        while (opcio < 3) {
            menu();
            System.out.println("  --Escull opció: ");
            opcio = teclado.nextInt(); //cridem metode nextInt per llegar el numero i guardar a opcio.
            Seleccio(opcio); //Executem exercici escollit.
        }
    }
    
    private static void menu() {
        System.out.println("|===========================================|");
        System.out.println("|****************** MENÚ *******************|");
        System.out.println("|===========================================|");
        System.out.println("|    1.- Introduccio Usuari/Contrasenya     |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|    2.- Comprovacio Usuari/Contrasenya     |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|               3.- Sortir                  |");
        System.out.println("|===========================================|");
    }
    
    private static void Seleccio(int opcio) throws IOException {
        switch (opcio) {

            case 1:
                exercici1();
                break;
            case 2:
                exercici2();
                break;
            default:
                break;

        }
    }

    private static void exercici1() throws IOException {
        FileWriter cuentas = new FileWriter("./cuentas.txt",true);
        Scanner entrada = new Scanner(System.in);
        String textUsu;
        String textCont = "LOL";
        int contador = 1;
        System.out.println("Inrodueix un ENTER (espai en blanc) per finalitzar");
        System.out.println("Introdueix nom d'usuari " + contador);
        textUsu = entrada.nextLine();
        
        while (!"".equals(textUsu)) {
            cuentas.write(textUsu + ":");
            System.out.println("Introdueix contrasenya d'usuari " + contador);
            textCont = entrada.nextLine();
            cuentas.write(textCont + "\n" + "\n");
            contador += 1;
            System.out.println("Introdueix nom d'usuari " + contador);
            textUsu = entrada.nextLine();
        }
        cuentas.close();
    }

    private static void exercici2() throws FileNotFoundException, IOException {
        FileReader cuentas = new FileReader ("./cuentas.txt");
        BufferedReader buf = new BufferedReader(cuentas);
        String linia;
        Scanner entrada = new Scanner(System.in);
        String Usuario;
        String Contra;
        System.out.println("Inrodueix un ENTER (espai en blanc) per finalitzar");
        System.out.println("Introdueix el nom d'un usuari ");
        Usuario = entrada.nextLine();
        
        while (!"".equals(Usuario) & (linia = buf.readLine()) != null) {
            if (Usuario.equals(linia.split(":")[0]) & linia.contains(Usuario)) {
                System.out.println("Quina es la contrasenya?");
                Contra = entrada.nextLine();
                if (Contra.equals(linia.split(":")[1])) {
                    System.out.println("Ja ha iniciat sessio ☺");
                }
                else {
                    System.out.println("Intenta-ho de nou mes tard");
                }
            }
            else {
                System.out.println("Aquest usuari no es valid");
            }
            System.out.println("Introdueix el nom d'un usuari ");
            Usuario = entrada.nextLine();
        }
    }
}

