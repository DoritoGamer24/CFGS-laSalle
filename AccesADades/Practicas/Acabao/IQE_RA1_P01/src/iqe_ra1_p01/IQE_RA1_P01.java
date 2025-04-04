/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra1_p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Random;

/**
 *
 * @author AluCiclesGS1
 */
public class IQE_RA1_P01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opcio = 0;
        Scanner teclado = new Scanner(System.in); //Creem objecte de escáner o lectura
        while (opcio != 9) {
            menu();
            System.out.println("  --Escull opció: ");
            opcio = teclado.nextInt(); //cridem metode nextInt per llegar el numero i guardar a opcio.
            Seleccio(opcio); //Executem exercici escollit.
        }
    }

    private static void menu() {
        System.out.println("|===============================|");
        System.out.println("|************ MENÚ *************|");
        System.out.println("|===============================|");
        System.out.println("|    1.- Comprova fitxers       |");
        System.out.println("|-------------------------------|");
        System.out.println("|     2.- Llista d'arxius       |");
        System.out.println("|-------------------------------|");
        System.out.println("|     3.- Crear arxiu TXT       |");
        System.out.println("|-------------------------------|");
        System.out.println("|    4.- Mostrar contingut      |");
        System.out.println("|-------------------------------|");
        System.out.println("|  5.- Crear directori i arxiu  |");
        System.out.println("|-------------------------------|");
        System.out.println("|   6.- Proves de comentaris    |");
        System.out.println("|===============================|");
        System.out.println("|          7.- Sortir           |");
        System.out.println("|===============================|");
    }

    private static void Seleccio(int opcio) throws IOException {
        switch (opcio) {

            case 1:
                exercici1();
                break;
            case 2:
                exercici2();
                break;
            case 3:
                exercici3();
                break;
            case 4:
                exercici4();
                break;
            case 5:
                exercici5();
                break;
            case 6:
                exercici6();
                break;
            default:
                break;

        }
    }

    private static void exercici1() {
        System.out.println("El fitxer nop.txt existeix??");
        File f1 = new File("./prova/nop.txt");
        if (f1.exists()) {
            System.out.println("El fitxer existeix!! ☺");

            System.out.println("");
            System.out.println("Es un directori o un arxiu?");
            if (f1.isDirectory()) {
                System.out.println("Es un directori!! ☺");
            } else {
                System.out.println("Es un arxiu!! ☺");
            }
        } else {
            System.out.println("El fitxer no existeix... :C");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("El fitxer notepad.exe existeix??");
        File f2 = new File("C:\\Windows\\notepad.exe");
        if (f2.exists()) {
            System.out.println("El fitxer existeix!! ☺");

            System.out.println("");
            System.out.println("Es un directori o un arxiu?");
            if (f2.isDirectory()) {
                System.out.println("Es un directori!! ☺");
            } else {
                System.out.println("Es un arxiu!! ☺");
            }
        } else {
            System.out.println("El fitxer no existeix... :C");
        }
    }

    private static void exercici2() {
        File carpeta = new File("C:\\Windows\\");
        String[] llista = carpeta.list();
        for (String nom : llista) {
            System.out.println(nom);
        }
    }

    private static void exercici3() throws IOException {
        FileWriter arxiu = new FileWriter("./arxiu1.txt");
        arxiu.write("Aquest és un primer escrit al meu arxiu");
        arxiu.close();
        System.out.println("S'ha creat correctament ☺");

        Scanner teclado = new Scanner(System.in);

        FileWriter arxiu2 = new FileWriter("./arxiu2.txt");
        System.out.println("Escriu un text: ");
        arxiu2.write(teclado.next());
        arxiu2.close();
        System.out.println("S'ha creat correctament ☺");
    }

    private static void exercici4() throws FileNotFoundException, IOException {
        System.out.println("L'arxiu conte el text: ");
        FileReader arxiu = new FileReader("./arxiu1.txt");

        BufferedReader buf = new BufferedReader(arxiu);
        String linia = buf.readLine();

        while (linia != null) {
            System.out.println(linia);
            linia = buf.readLine();
        }

        System.out.println("L'arxiu2 conte el text: ");
        FileReader arxiu2 = new FileReader("./EnglishStory.pdf");   //Esta incriptao entoncesp arece que lo ha escrito un fumao
        
        BufferedReader buff = new BufferedReader(arxiu2);
        String linias = buff.readLine();

        while (linias != null) {
            System.out.println(linias);
            linias = buff.readLine();
        }
    }

    private static void exercici5() throws IOException {
        File directori = new File("./"+textAleatori());
        if (!directori.exists()) {
          directori.mkdir();  
        }
        else {
            System.out.println("El directori ja existeix.");
        }
        
        String nomArchivo = textAleatori() + ".txt";
        File archivo = new File(directori, nomArchivo);
        if (!archivo.exists()) {
          archivo.createNewFile();  
        }
        else {
            System.out.println("El arxiu ja existeix.");
        }
    }
    
    public static String textAleatori() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    
    private static void exercici6() {
        Scanner sc = new Scanner(System.in);    //Comentari 1
        System.out.println("Entra l'adreça d'un fitxer: ");     //Comentari 2
        String adrecaFitxer = sc.next();    //Comentari 3
        File f = new File(adrecaFitxer);    //Comentari 4
        if(f.isFile()){     //Comentari 5
            System.out.println("Nom: "+ f.getName());   //Comentari 6
            System.out.println( "Path: "+ f.getPath());     //Comentari 7
            System.out.println( "Longitud: "+ f.length()+" bytes");     //Comentari 8
        } else {    //Comentari 9
            System.out.println("El fitxer no existeix\n");      //Comentari 10
        }       //Comentari 11
    }   //Comentari 12
}
