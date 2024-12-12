/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra1_p03;
// IMPORTS NECESSARIS
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
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
public class IQE_RA1_P03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        int opcio = 0;
        Scanner teclado = new Scanner(System.in); //Creem objecte de escáner o lectura
        while (opcio < 4) {
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
        System.out.println("|      1.- Mostrar dades Clash Royale       |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|     2.- Trobar jugador amb més copes      |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|   3.- Trobar temperatura més alta/baixa   |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|          4.- Inserir nou jugador          |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|                5.- Sortir                 |");
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
    
    //exercici 2
    public static void exercici1() throws Exception {
        Document doc = obrirFitxerXML("./clash.xml");       //Busca l'arxiu
        NodeList jugs = doc.getElementsByTagName("Jugador");        //Troba l'element jugador com a llistat
        for (int i = 0; i < jugs.getLength(); i++) {    
            Element jug = (Element) jugs.item(i);   //Es crea per buscar els elements de cada un dels jugadors
            System.out.println(jug.getElementsByTagName("Nom").item(0).getTextContent());   //Retorna el nom del jugador
            System.out.println("    Nivell : " + jug.getElementsByTagName("Nivell").item(0).getTextContent());  //Retorna el seu nivell
            System.out.println("    Copes : " + jug.getElementsByTagName("Copes").item(0).getTextContent());    //Retorna les copes
            System.out.println("    Or : " + jug.getElementsByTagName("Oro").item(0).getTextContent());     //Retorna quant d'or te el jugador
            System.out.println("    Gemes : " + jug.getElementsByTagName("Gemes").item(0).getTextContent());    //Retorna les gemes que te 
            System.out.println("    Estrelles : " + jug.getElementsByTagName("Estrelles").item(0).getTextContent() + "\n");    //Retorna les seves estrelles
            NodeList partides = jug.getElementsByTagName("Partida");       //Es crea una nova llista per a les partides
            for (int y = 0; y < partides.getLength(); y++) {
                Element partida = (Element) partides.item(y);   //Es crea per buscar els elements de cada un de les partides
                System.out.println("Partida " + (y + 1));   //Text per mostrar quina partida es la jugada
                System.out.println("    Data : " + partida.getElementsByTagName("Data").item(0).getTextContent());  //Mostra la data de quan s'ha jugat
                System.out.println("    Resultat : " + partida.getElementsByTagName("Resultat").item(0).getTextContent());  //Mostra el resultat de la partida
                System.out.println("    Temps: " + partida.getElementsByTagName("Durada").item(0).getTextContent());    //Mostra quant ha durat la partida
                System.out.println("    Tipus de partida : " + partida.getElementsByTagName("Tipus").item(0).getTextContent() + "\n");  //Mostra el tipus de partida jugada
            }
            System.out.println("\n" + "\n");    //Deixa una separacio entre jugador i jugador
        }
    }

    //exercici 3
    private static void exercici2() throws Exception {
        Document doc = obrirFitxerXML("./clash.xml");   //Busca l'arxiu
        int CopesMax = 0;   //Es dona valor a la variable de copes maximes
        NodeList listJugs = doc.getElementsByTagName("Jugador");        //Troba l'element jugador com a llistat
        Element maxCopJug = null;     //S'indica que el jugador amb mes copes es null (s'indicara mes tard)
        for (int i = 0; i < listJugs.getLength(); i++) {
            Element jug = (Element) listJugs.item(i);   //Es crea per buscar els elements de cada un dels jugadors
            int Copes = Integer.parseInt(jug.getElementsByTagName("Copes").item(0).getTextContent());   //S'indica una variable int com a copes per poder comparar
            if (Copes > CopesMax) {     //Es compara si Copes es major a la quantitat anterior ment guardat
                CopesMax = Copes;       //Si es major guarda aquest nou numero de copes com el nou CopesMax
                maxCopJug = jug;        //Guarda també quin es el jugador que té més copes
            }
        }
        System.out.println("El jugador amb més copes es " + maxCopJug.getElementsByTagName("Nom").item(0).getTextContent());   //Retorna el nom del jugador
        System.out.println("Té " + maxCopJug.getElementsByTagName("Copes").item(0).getTextContent() + " Copes");    //Retorna les copes
    }
    
    //exercici4
    private static void exercici3() throws Exception {
        for (int i = 0; i < 3; i++) {
            Document doc = obrirFitxerXML("./meteo" + (2015 + i) + ".xml");   //Busca l'arxiu
            double TempMax = 0;     //S'indica una temperatura maxima baixa per a poder guardar numeros alts despres
            double TempMin = 100;       //Al contrari en aquest es posa temperatura molt alta
            NodeList listTemp = doc.getElementsByTagName("element");        //Troba l'element element com a llistat
            Element maxTempsCal = null;     //Variables per guardar on es troba la temperatura mes alta del any
            Element maxTempsFred = null;    //Variables per guardar on es troba la temperatura mes baixa del any
            
            for (int y = 0; y < listTemp.getLength(); y++) {
                Element TempsList = (Element) listTemp.item(i);     //Es crea per buscar els elements de cada un de les diferents temperatures
                if (TempsList.getElementsByTagName("tmax").getLength() > 0) {   //Detecta si el NULL
                    double TMax = NumberFormat.getInstance().parse(TempsList.getElementsByTagName("tmax").item(0).getTextContent()).doubleValue();  //Busca la temperatura maxima
                    if (TMax > TempMax) {     
                        TempMax = TMax;       //La guarda en TempMax per comparar
                        maxTempsCal = TempsList;    //Guarda quin de la llista es el de la temperatura mes alta
                    }
                }
                if (TempsList.getElementsByTagName("tmin").getLength() > 0) {   //Detecta si el NULL
                    double TMin = NumberFormat.getInstance().parse(TempsList.getElementsByTagName("tmin").item(0).getTextContent()).doubleValue();  //Busca la temperatura minima
                    if (TMin < TempMin) {     
                        TempMin = TMin;       //La guarda en TempMin per comparar
                        maxTempsFred = TempsList;   //Guarda quin de la llista es el de la temperatura mes baixa
                    }
                }
            }
            System.out.println("./meteo" + (2015 + i) + ".xml");    //Mostra quin XML es
            System.out.println("Tmax |" + maxTempsCal.getElementsByTagName("fecha").item(0).getTextContent() + " " + maxTempsCal.getElementsByTagName("horatmax").item(0).getTextContent() + "| = " +  maxTempsCal.getElementsByTagName("tmax").item(0).getTextContent() + "C");    //La temperatura maxima
            System.out.println("Tmin |" + maxTempsFred.getElementsByTagName("fecha").item(0).getTextContent() + " " + maxTempsFred.getElementsByTagName("horatmin").item(0).getTextContent() + "| = " +  maxTempsFred.getElementsByTagName("tmin").item(0).getTextContent() + "C");     //La temperatura minima
        }
    }
    
    private static void exercici4() throws Exception {
        int continuar;
        Document doc = obrirFitxerXML("./clash.xml");
        Scanner entrada = new Scanner(System.in);
        Node elementRoot = doc.getDocumentElement();

        Element jugador = doc.createElement("Jugador");//<jugador></jugador>

        Element nom = doc.createElement("Nom");//<Nom></Nom>
        System.out.println("Entra el nom del jugador: ");
        String nomIn = entrada.nextLine();
        nom.setTextContent(nomIn);//<Nom>Xavier</Nom>
        
        Element lvl = doc.createElement("Nivell");//<Nivell></Nivell>
        System.out.println("Entra el nivell del jugador: ");
        String lvlIn = entrada.nextLine();
        lvl.setTextContent(lvlIn);//<Nivell>Text inserit</Nivell>
        
        Element copes = doc.createElement("Copes");//<Copes></Copes>
        System.out.println("Entra les copes del jugador: ");
        String copesIn = entrada.nextLine();
        copes.setTextContent(copesIn);//<Copes>Text inserit</Copes>
        
        Element oro = doc.createElement("Oro");//<Oro></Oro>
        System.out.println("Entra el oro del jugador: ");
        String oroIn = entrada.nextLine();
        oro.setTextContent(oroIn);//<Oro>Text inserit</Oro>
        
        Element gems = doc.createElement("Gemes");//<Gemes></Gemes>
        System.out.println("Entra les gemes del jugador: ");
        String gemsIn = entrada.nextLine();
        gems.setTextContent(gemsIn);//<Gemes>Text inserit</Gemes>
        
        Element star = doc.createElement("Estrelles");//<Estrelles></Estrelles>
        System.out.println("Entra les estrelles del jugador: ");
        String starIn = entrada.nextLine();
        star.setTextContent(starIn);//<Estrelles>Text inserit</Estrelles>
        
        Element partides = doc.createElement("Partides");//<Partides></Partides>
        System.out.println("Quantes partides es vol inserir? ");
        continuar = entrada.nextInt();
        entrada.nextLine();     //Neteja el buffer d'entrades per poder inserir text en el seguent
        while (continuar > 0) { 
            Element partida = doc.createElement("Partida");//<Partida></Partida>
            
            
            Element data = doc.createElement("Data");//<Data></Data>
            System.out.println("Entra la data de la partida (DD-MM-YYYY): ");
            String dataIn = entrada.nextLine();
            data.setTextContent(dataIn);//<Data>Text inserit</Data>
            
            Element resul = doc.createElement("Resultat");//<Resultat></Resultat>
            System.out.println("Entra el resultat de la partida (1-1, 1-2, 3-0,...): ");
            String resulIn = entrada.nextLine();
            resul.setTextContent(resulIn);//<Resultat>Text inserit</Resultat>
            
            Element dura = doc.createElement("Durada");//<Durada></Durada>
            System.out.println("Entra la durada de la partida (Max: 5:00): ");
            String duraIn = entrada.nextLine();
            dura.setTextContent(duraIn);//<Durada>Text inserit</Durada>
            
            Element tipo = doc.createElement("Resultat");//<Tipus></Tipus>
            System.out.println("Entra el tipus de partida (Torneig, Lliga o Amistós): ");
            String tipoIn = entrada.nextLine();
            tipo.setTextContent(tipoIn);//<Tipus>Text inserit</Tipus>
            
            System.out.println("");
            System.out.println("");
            
            partida.appendChild(data); //<partida><Data>Text inserit</Data></partida>
            partida.appendChild(resul); //<partida><Resultat>Text inserit</Resultat></partida>
            partida.appendChild(dura); //<partida><Durada>Text inserit</Durada></partida>
            partida.appendChild(tipo); //<partida><Tipus>Text inserit</Tipus></partida>
            partides.appendChild(partida);
            
            continuar--;
        }

        jugador.appendChild(nom);//<jugador><Nom>Text inserit</Nom></jugador>
        jugador.appendChild(lvl);//<jugador><Nivell>Text inserit</Nivell></jugador>
        jugador.appendChild(copes);//<jugador><Copes>Text inserit</Copes></jugador>
        jugador.appendChild(oro);//<jugador><Oro>Text inserit</Oro></jugador>
        jugador.appendChild(gems);//<jugador><Gemes>Text inserit</Gemes></jugador>
        jugador.appendChild(star);//<jugador><Estrelles>Text inserit</Estrelles></jugador>
        jugador.appendChild(partides);//<jugador><Partides>Text inserit</Partides></jugador>
        
        elementRoot.appendChild(jugador);

        guardarXML(doc, "./clash.xml");

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

