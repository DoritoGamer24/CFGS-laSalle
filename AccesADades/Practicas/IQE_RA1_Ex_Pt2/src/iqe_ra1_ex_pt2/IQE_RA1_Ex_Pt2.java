/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra1_ex_pt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author AluCiclesGS1
 */
public class IQE_RA1_Ex_Pt2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int opcio = 0;
        Scanner teclado = new Scanner(System.in); //Creem objecte de escáner o lectura
        while (opcio < 5) {
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
        System.out.println("|    1.- Trobar jugador amb menys nivell    |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|          2.- Crear nou jugador            |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|   3.- Introduir Usuari/Contrasenya/Mail   |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|        4.- Veure mail dels usuaris        |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|               5.- Sortir                  |");
        System.out.println("|===========================================|");
    }
    
    private static void Seleccio(int opcio) throws IOException, Exception {
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
            default:
                break;

        }
    }

    private static void exercici1() throws Exception {
        Document doc = obrirFitxerXML("./Jugadors.xml");   //Busca l'arxiu
        int NivellMin = 100;   //Es dona valor a la variable de nivell minim
        NodeList listJugs = doc.getElementsByTagName("jugador");        //Troba l'element jugador com a llistat
        Element MinNivJug = null;     //S'indica que el jugador amb menys nivell es null (s'indicara mes tard)
        for (int i = 0; i < listJugs.getLength(); i++) {
            Element jug = (Element) listJugs.item(i);   //Es crea per buscar els elements de cada un dels jugadors
            int Nivell = Integer.parseInt(jug.getElementsByTagName("nivell").item(0).getTextContent());   //S'indica una variable int com a Nivell i es formata per poder comparar
            if (Nivell < NivellMin) {     //Es compara si Nivell es menor a la quantitat anteriorment guardat
                NivellMin = Nivell;       //Si es menor guarda aquest nou numero de nivell com el nou NivellMin
                MinNivJug = jug;        //Guarda també quin es el jugador que té menys nivell
            }
        }
        System.out.println("El jugador amb menys nivell es:");
        System.out.println("Nom: " + MinNivJug.getElementsByTagName("nom").item(0).getTextContent());   //Retorna el nom del jugador
        System.out.println("Nivell: " + MinNivJug.getElementsByTagName("nivell").item(0).getTextContent());    //Retorna el nivell que es
        System.out.println("Vida: " + MinNivJug.getElementsByTagName("vida").item(0).getTextContent());    //Retorna la vida que te
        System.out.println("Or: " + MinNivJug.getElementsByTagName("or").item(0).getTextContent());    //Retorna quant or te
        System.out.println("Atac: " + MinNivJug.getElementsByTagName("atac").item(0).getTextContent());    //Retorna el seu atac
        System.out.println("Defensa: " + MinNivJug.getElementsByTagName("defensa").item(0).getTextContent());    //Retorna la seva defensa
        System.out.println("Magia: " + MinNivJug.getElementsByTagName("magia").item(0).getTextContent());    //Retorna la seva magia
        System.out.println("");
        System.out.println("Inventari:");
        NodeList partides = doc.getElementsByTagName("inventari");       //Es crea una nova llista per al inventari
        for (int y = 0; y < partides.getLength(); y++) {
            System.out.println("");
            System.out.println("Nom: " + MinNivJug.getElementsByTagName("nomObj").item(y).getTextContent());    //Retorna el nom
            System.out.println("Tipus: " + MinNivJug.getElementsByTagName("tipusObj").item(y).getTextContent());    //Retorna el tipus
            System.out.println("Nivell: " + MinNivJug.getElementsByTagName("nivellObj").item(y).getTextContent());    //Retorna el nivell
        }
    }
    
        private static void exercici2() throws Exception {
        int continuar;
        Document doc = obrirFitxerXML("./Jugadors.xml");    //S'obre el fitxer XML
        Scanner entrada = new Scanner(System.in);
        Node elementRoot = doc.getDocumentElement();

        Element jugador = doc.createElement("jugador");//<jugador></jugador>

        Element nom = doc.createElement("nom");//<nom></nom>
        System.out.println("Entra el nom del jugador: ");   //Es preguntara per cadascun dels elements que formen el jugador
        String nomIn = entrada.nextLine();
        nom.setTextContent(nomIn);//<nom>Pepito</nom>
        
        Element oro = doc.createElement("or");//<or></or>
        System.out.println("Entra la quantitat d'or del jugador: ");
        String oroIn = entrada.nextLine();
        oro.setTextContent(oroIn);//<or>Text inserit</or>
        
        Element level = doc.createElement("nivell");//<nivell></nivell>
        System.out.println("Entra el nivell del jugador: ");
        String levelIn = entrada.nextLine();
        level.setTextContent(levelIn);//<nivell>Text inserit</nivell>
        
        Element life = doc.createElement("vida");//<vida></vida>
        System.out.println("Entra la vida del jugador: ");
        String lifeIn = entrada.nextLine();
        life.setTextContent(lifeIn);//<vida>Text inserit</vida>
        
        Element atk = doc.createElement("atac");//<atac></atac>
        System.out.println("Entra l'atac del jugador: ");
        String atkIn = entrada.nextLine();
        atk.setTextContent(atkIn);//<atac>Text inserit</atac>
        
        Element defensa = doc.createElement("defensa");//<defensa></defensa>
        System.out.println("Entra la defensa del jugador: ");
        String defensaIn = entrada.nextLine();
        defensa.setTextContent(defensaIn);//<defensa>Text inserit</defensa>
        
        Element magic = doc.createElement("magia");//<magia></magia>
        System.out.println("Entra la quantitat de magia del jugador: ");
        String magicIn = entrada.nextLine();
        magic.setTextContent(magicIn);//<magia>Text inserit</magia>
        
        Element inv = doc.createElement("inventari");//<inventari></inventari>
        System.out.println("Quants objectes es vol inserir? ");     //Demana quants objectes el voldra inserir en l'inventari
        continuar = entrada.nextInt();
        entrada.nextLine();     //Neteja el buffer d'entrades per poder inserir text en el seguent
        while (continuar > 0) { 
            Element object = doc.createElement("objecte");//<objecte></objecte>
            
            
            Element name = doc.createElement("nomObj");//<nomObj></nomObj>
            System.out.println("Entra el nom del objecte: ");
            String nameIn = entrada.nextLine();
            name.setTextContent(nameIn);//<nomObj>Text inserit</nomObj>
            
            Element tipo = doc.createElement("tipusObj");//<tipusObj></tipusObj>
            System.out.println("Entra el tipus (espasa, armadura, ...): ");
            String tipoIn = entrada.nextLine();
            tipo.setTextContent(tipoIn);//<tipusObj>Text inserit</tipusObj>
            
            Element nivObj = doc.createElement("nivellObj");//<nivellObj></nivellObj>
            System.out.println("Entra el nivell d'aquest objecte: ");
            String nivObjIn = entrada.nextLine();
            nivObj.setTextContent(nivObjIn);//<nivellObj>Text inserit</nivellObj>
            
            System.out.println("");
            System.out.println("");
            
            object.appendChild(name); //<objecte><nomObj>Text inserit</nomObj></objecte>
            object.appendChild(tipo); //<objecte><tipusObj>Text inserit</tipusObj></objecte>
            object.appendChild(nivObj); //<objecte><nivellObj>Text inserit</nivellObj></objecte>
            inv.appendChild(object);    //<objecte><nomObj>Text inserit</nomObj><tipusObj>Text inserit</tipusObj><nivellObj>Text inserit</nivellObj></objecte>
            
            continuar--;
        }

        jugador.appendChild(nom);//<jugador><Nom>Text inserit</Nom></jugador>
        jugador.appendChild(oro);//<jugador><or>Text inserit</or></jugador>
        jugador.appendChild(level);//<jugador><nivell>Text inserit</nivell></jugador>
        jugador.appendChild(life);//<jugador><vida>Text inserit</vida></jugador>
        jugador.appendChild(atk);//<jugador><atac>Text inserit</atac></jugador>
        jugador.appendChild(defensa);//<jugador><defensa>Text inserit</defensa></jugador>
        jugador.appendChild(magic);//<jugador><magia>Text inserit</magia></jugador>
        jugador.appendChild(inv);//<jugador><inventari>Text inserit</inventari></jugador>
        
        elementRoot.appendChild(jugador);   //Es tenca jugador

        guardarXML(doc, "./Jugadors.xml");  //Es guarda tot en l'arxiu Jugadors.xml
        
        System.out.println("Jugador creat...");
    }
    
    private static void exercici3() throws IOException {
        FileWriter cuentas = new FileWriter("./cuentas.txt",true);  //Es crea l'arxiu cuentas.txt
        Scanner entrada = new Scanner(System.in);   //Es crea l'escaner per poder inserir text
        String textUsu;     //|
        String textCont;    //| Es crean les variables per guardar el text
        String textMail;    //|
        int contador = 1;   //Comptador per saber quants usuaris portes inserits
        System.out.println("Inrodueix un ENTER (espai en blanc) per finalitzar");
        System.out.println("Introdueix nom d'usuari " + contador);  
        textUsu = entrada.nextLine();   //Es pregunta per el nom del primer usuari
        
        while (!"".equals(textUsu)) {
            cuentas.write(textUsu + ":");   //Es formata com es vol guardar la informacio
            System.out.println("Introdueix contrasenya d'usuari " + contador);
            textCont = entrada.nextLine();      //Es pregunta per la contrasenya del usuari
            cuentas.write(textCont + ":");      //Es formata com es vol guardar la informacio
            System.out.println("Introdueix email del usuari " + contador);
            textMail = entrada.nextLine();      //Es pregunta per el mail del usuari
            cuentas.write(textMail + "\n");     //Es formata com es vol guardar la informacio
            contador += 1;      //es suma 1 al comptador per saber que has acabat un usuari
            System.out.println("Introdueix nom d'usuari " + contador);
            textUsu = entrada.nextLine();   //Es pregunta per el seguent usuari que es vol crear
        }
        cuentas.close();    //Es tenca l'arxiu cuentas.txt
    }
    
    private static void exercici4() throws FileNotFoundException, IOException {
        FileReader cuentas = new FileReader ("./cuentas.txt");  //S'obre el fitxer cuentas.txt
        BufferedReader buf = new BufferedReader(cuentas);   //Es crea un buffer per lleigir el fitxer
        String linia;
        System.out.println("Llistat de correus dels usuaris:");
        System.out.println("");
        
        while ((linia = buf.readLine()) != null) {  //Es busca fins a terminar el fitxer
            System.out.println(linia.split(":")[2]);    //Mostrara el que es troba despres del segon ":"
        }
    }
    
    public static Document obrirFitxerXML(String fitxerXML) throws Exception {
        File fxml = new File(fitxerXML);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = (Document) dBuilder.parse(fxml);
        doc.getDocumentElement().normalize();
        return doc;
    }
    
    private static void guardarXML(Document doc, String ruta) throws TransformerConfigurationException, TransformerException {
        Transformer tFormer = TransformerFactory.newInstance().newTransformer();
        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
        Source source = new DOMSource(doc);
        Result result = new StreamResult(new File(ruta));
        tFormer.transform(source, result);
    }
}
 