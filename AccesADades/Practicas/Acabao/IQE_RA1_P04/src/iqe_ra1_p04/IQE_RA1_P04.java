/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra1_p04;
// IMPORTS NECESSARIS
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author AluCiclesGS1
 */
public class IQE_RA1_P04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
    }
    
    //FUNCIO A COPIAR, FORA DEL MAIN
public static Document obrirFitxerXML(String fitxerXML) throws Exception {
        File fxml = new File(fitxerXML);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = (Document) dBuilder.parse(fxml);
        doc.getDocumentElement().normalize();
        return doc;
    }

    //Referent a la P3.3 escriure jugador
private static void inscriureNouJugador() throws IOException, Exception {

        Document doc = obrirFitxerXML("./animals.xml");
        Scanner entrada = new Scanner(System.in);
        Node elementRoot = doc.getDocumentElement();

        Element jugador = doc.createElement("jugador");//<jugador></jugador>

        Element nom = doc.createElement("Nom");//<nom></nom>
        System.out.println("Entra el nom del jugador:");
        String nomIn = entrada.nextLine();
        nom.setTextContent(nomIn);//<nom>Xavier</nom>

        Element partida = doc.createElement("partida");//<partida></partida>
        Element durada = doc.createElement("durada");//<durada></durada>
        durada.setTextContent("1:22");//<durada>1:22</durada>

        jugador.appendChild(nom);//<jugador><nom>Xavier</nom></jugador>
        partida.appendChild(durada); //<partida><durada>1:22</durada></partida>

        jugador.appendChild(nom);

        jugador.appendChild(partida); //<jugador><nom>Xavier</nom><partida><durada>1:22</durada></partida></jugador>
        elementRoot.appendChild(jugador);

        guardarXML(doc, "./animals.xml");

    }

private static void guardarXML(Document doc, String ruta) throws TransformerConfigurationException, TransformerException {
        Transformer tFormer = TransformerFactory.newInstance().newTransformer();
        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
        Source source = new DOMSource(doc);
        Result result = new StreamResult(new File(ruta));
        tFormer.transform(source, result);
    }
}
