/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqe_ra2_p01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

/**
 *
 * @author AluCiclesGS1
 */
public class IQE_RA2_P01 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, Exception {
        int opcio = 0;
        Scanner teclado = new Scanner(System.in); //Creem objecte de escáner o lectura
        while (opcio < 7) {
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
        System.out.println("|        1.- Mostrar dades jugadors         |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|        2.- Afeguir un nou jugador         |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|         3.- Modificar un jugador          |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|        4.- Inserir noves partides         |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|             5.- Crear cartes              |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|      6.- Mostrar cartes d'un jugador      |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|                7.- Sortir                 |");
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

    private static void exercici1() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection = null;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  //Conexion a la base

        Statement stmt = connection.createStatement();      //Es crea un statement
        ResultSet jug = stmt.executeQuery("SELECT * FROM jugadors");        //Dins el statement s'executa la query per veure tot els jugadors

        while (jug.next()) {        //Mentres hi hagi jugadors...
            System.out.println("Nom Jugador: " + jug.getString("nom"));     //Mostra la informacio d'aquests

            System.out.println("Nivell Jugador: " + jug.getString("nivell"));

            System.out.println("Copes Jugador: " + jug.getString("copes"));

            System.out.println("Or del Jugador: " + jug.getString("oro"));

            System.out.println("Gemes del Jugador: " + jug.getString("gemes"));

            System.out.println("Estrelles del Jugador: " + jug.getString("estrelles"));
            System.out.println("\n");

            int id = jug.getInt("id");      //Es guarda la id del jugador

            String query = "SELECT * FROM partides WHERE id_jug1 = " + id + " OR id_jug2 = " + id;      //Es crea una query per trobar totes les partides a les que ha jugat
            Statement stmt2 = connection.createStatement();     //Es crea el statement per la query
            ResultSet prt = stmt2.executeQuery(query);      //S'executa la query

            System.out.println("Partides:");

            while (prt.next()) {    //Mentres hi hagin partides
                System.out.println("Resultat Partida: " + prt.getString("resultat"));   //Mostrara el resultat d'aquestes partides
            }
            System.out.println("\n");

        }
        connection.close();     //Es tenca la connexio
    }

    private static void exercici2() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir"); //Conexion a la base

        //static Connection con = connecIDatabase ();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entra el nom del jugador: ");    //Pregunta per l'informacio del nou usuari
        String nom = entrada.nextLine();
        System.out.println("Entra el nivell (1-14): ");
        int nivell = entrada.nextInt();
        System.out.println("Entra les copes: ");
        int copes = entrada.nextInt();
        System.out.println("Entra l'or: ");
        int oro = entrada.nextInt();
        System.out.println("Entra les gemes: ");
        int gemes = entrada.nextInt();
        System.out.println("Entra les estrelles: ");
        int estrelles = entrada.nextInt();
        int id = ultimId() + 1;     //Busca quin es l'ultim id i suma 1
        PreparedStatement insertJug = connection.prepareStatement("INSERT INTO jugadors (id, nom, nivell, copes, oro, gemes, estrelles) VALUES (?, ?, ?, ?, ?, ?, ?) ");  //Es prepara la query

        insertJug.setInt(1, id);   //S'inserta tota la informacio on estan els "?"
        insertJug.setString(2, nom);
        insertJug.setInt(3, nivell);
        insertJug.setInt(4, copes);
        insertJug.setInt(5, oro);
        insertJug.setInt(6, gemes);
        insertJug.setInt(7, estrelles);
        insertJug.executeUpdate();  //S'executa un update de la base de dades

        connection.close();

    }

    private static int ultimId() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection = null;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  //Conexion a la base

        int id = 0;     //Es crea la variable on es guardara la id
        try {
            Statement stmt = connection.createStatement();    //Es crea el statement
            ResultSet rs = stmt.executeQuery("SELECT id FROM jugadors order by id ASC");  //Es crea la query dins el statement
            while (rs.next()) {    //Es va guardant totes les id mentres hi hagi text
                id = rs.getInt("id");  //Es guarda en la variable id cadascuna de les id remplazant la anterior deixant la ultima id com la guardada
            }

        } catch (SQLException ex) {     //Si hi hagues una falla a l'hora de buscar la id
            System.err.print("Excepció de SQL: ");   //Mostrara aquest error
            System.err.println(ex.getMessage());
        }
        connection.close(); //Es tenca la conexio 
        return id;  //I es retorna la ultima id
    }

    private static void exercici3() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     // Es comprova que la llibreria de PostgreSQL estigui disponible
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);  // Si no es troba, mostra un error
        }

        Connection connection = null;
        // Connexió amb la base de dades
        // Conectem amb la base de dades
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  // Estableix la connexió amb la base de dades PostgreSQL

        System.out.println("|===Llistat de jugadors===|");
        mostrarNomJugador();  // Crida a la funció mostrarNomJugador per mostrar els jugadors

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entra l'ID del jugador que es vol editar: ");  // Sol·licita l'ID del jugador a editar
        String id = entrada.nextLine();  // Llegeix l'ID introduït per l'usuari

        Statement stmt = connection.createStatement();      // Crea un objecte Statement per executar consultes SQL
        ResultSet jug = stmt.executeQuery("SELECT * FROM jugadors WHERE id = " + id);  // Executa la consulta SQL per obtenir les dades del jugador amb l'ID especificat

        while (jug.next()) {  // Mentre hi hagi un jugador amb aquest ID...
            System.out.println("Nom anterior: " + jug.getString("nom"));  // Mostra el nom actual del jugador
            System.out.println("Entra el nom del jugador nou: ");  // Sol·licita el nou nom del jugador
            String nom = entrada.nextLine();  // Llegeix el nou nom

            System.out.println("Nivell anterior: " + jug.getString("nivell"));  // Mostra el nivell actual del jugador
            System.out.println("Entra el nivell nou (1-14): ");  // Sol·licita el nou nivell del jugador
            int nivell = entrada.nextInt();  // Llegeix el nou nivell

            System.out.println("Copes anteriors: " + jug.getString("copes"));  // Mostra les copes actuals del jugador
            System.out.println("Entra les copes noves: ");  // Sol·licita les noves copes
            int copes = entrada.nextInt();  // Llegeix el nou número de copes

            System.out.println("Or anterior: " + jug.getString("oro"));  // Mostra l'or actual del jugador
            System.out.println("Entra l'or nou: ");  // Sol·licita el nou or
            int oro = entrada.nextInt();  // Llegeix el nou or

            System.out.println("Gemes anteriors: " + jug.getString("gemes"));  // Mostra les gemes actuals del jugador
            System.out.println("Entra les gemes noves: ");  // Sol·licita les noves gemes
            int gemes = entrada.nextInt();  // Llegeix el nou número de gemes

            System.out.println("Estrelles anteriors: " + jug.getString("estrelles"));  // Mostra les estrelles actuals del jugador
            System.out.println("Entra les estrelles noves: ");  // Sol·licita el nou número d'estrelles
            int estrelles = entrada.nextInt();  // Llegeix el nou número d'estrelles

            // Prepara la consulta SQL per actualitzar les dades del jugador
            PreparedStatement updJug = connection.prepareStatement("UPDATE jugadors SET nom = ?, nivell = ?, copes = ?, oro = ?, gemes = ?, estrelles = ? WHERE id = " + id);  // Estableix la consulta SQL d'actualització

            // Associa els valors als paràmetres de la consulta
            updJug.setString(1, nom);  // Estableix el nou nom
            updJug.setInt(2, nivell);  // Estableix el nou nivell
            updJug.setInt(3, copes);   // Estableix el nou número de copes
            updJug.setInt(4, oro);     // Estableix el nou or
            updJug.setInt(5, gemes);   // Estableix el nou número de gemes
            updJug.setInt(6, estrelles); // Estableix el nou número d'estrelles
            updJug.executeUpdate();    // Executa l'actualització de les dades a la base de dades
        }
        connection.close();  // Tanca la connexió amb la base de dades
    }

    private static void mostrarNomJugador() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");  // Comprova si la llibreria de PostgreSQL està disponible
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);  // Si no es troba, mostra un error
        }

        Connection connection = null;
        // Connexió amb la base de dades
        // Conectem amb la base de dades
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  // Estableix la connexió amb la base de dades PostgreSQL

        Statement stmt = connection.createStatement();  // Crea un objecte Statement per executar consultes SQL
        ResultSet jug = stmt.executeQuery("SELECT * FROM jugadors");  // Executa la consulta SQL per obtenir tots els jugadors
        while (jug.next()) {  // Mentre hi hagi jugadors a la base de dades...
            System.out.println("ID Jugador: " + jug.getInt("id"));  // Mostra l'ID del jugador
            System.out.println("Nom Jugador: " + jug.getString("nom"));  // Mostra el nom del jugador
            System.out.println();  // Imprimeix una línia en blanc per separar els resultats
        }
        System.out.println("|===Llistat de jugadors===|");  // Indica que el llistat de jugadors ha acabat
        connection.close();  // Tanca la connexió amb la base de dades
    }

    private static void exercici4() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     // Es comprova que la llibreria de PostgreSQL estigui disponible
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);  // Si no es troba, mostra un error
        }

        Connection connection;
        // Connexió amb la base de dades
        // Conectem amb la base de dades
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  // Estableix la connexió amb la base de dades PostgreSQL

        System.out.println("|===Llistat de jugadors===|");
        mostrarNomJugador();  // Crida a la funció mostrarNomJugador per mostrar els jugadors

        //static Connection con = connecIDatabase ();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entra l'ID del primer jugador: ");  // Sol·licita l'ID del primer jugador
        int jug1 = entrada.nextInt();  // Llegeix l'ID del primer jugador
        System.out.println("Entra l'ID del segon jugador: ");  // Sol·licita l'ID del segon jugador
        int jug2 = entrada.nextInt();  // Llegeix l'ID del segon jugador
        System.out.println("Entra el resultat de la partida (?-?): ");  // Sol·licita el resultat de la partida
        String limpiarBuffer = entrada.nextLine();  // Llegeix el salt de línia pendent
        String resul = entrada.nextLine();  // Llegeix el resultat de la partida
        System.out.println("Entra el temps que ha durat (?:??): ");  // Sol·licita el temps de la partida
        String temps = entrada.nextLine();  // Llegeix el temps de la partida
        System.out.println("Entra el tipus de partida (amistos, lliga o torneig): ");  // Sol·licita el tipus de partida
        String tipo = entrada.nextLine();  // Llegeix el tipus de partida
        int id = ultimIdPartides() + 1;  // Crida a la funció ultimIdPartides per obtenir l'última ID i suma 1

        // Prepara la consulta SQL per inserir una nova partida a la base de dades
        PreparedStatement insertPar = connection.prepareStatement("INSERT INTO partides (id, id_jug1, id_jug2, resultat, temps, tipus) VALUES (?, ?, ?, ?, ?, ?) ");  // Prepara la consulta d'inserció

        insertPar.setInt(1, id);   // Estableix la ID de la partida
        insertPar.setInt(2, jug1); // Estableix l'ID del primer jugador
        insertPar.setInt(3, jug2); // Estableix l'ID del segon jugador
        insertPar.setString(4, resul);  // Estableix el resultat de la partida
        insertPar.setString(5, temps);  // Estableix el temps de la partida
        insertPar.setString(6, tipo);   // Estableix el tipus de partida
        insertPar.executeUpdate();  // Executa l'actualització de la base de dades amb la nova partida

        connection.close();  // Tanca la connexió amb la base de dades
    }

    private static int ultimIdPartides() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     // Es comprova que la llibreria de PostgreSQL estigui disponible
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);  // Si no es troba, mostra un error
        }

        Connection connection = null;
        // Connexió amb la base de dades
        // Conectem amb la base de dades
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  // Estableix la connexió amb la base de dades PostgreSQL

        int id = 0;  // Es crea la variable on es guardarà la ID
        try {
            Statement stmt = connection.createStatement();  // Es crea l'objecte Statement per executar consultes SQL
            ResultSet rs = stmt.executeQuery("SELECT id FROM partides order by id ASC");  // Es crea la consulta SQL per obtenir totes les ID de les partides
            while (rs.next()) {  // Mentre hi hagi partides...
                id = rs.getInt("id");  // Es guarda cada ID trobada en la variable id
            }

        } catch (SQLException ex) {  // Si hi ha un error en la consulta SQL
            System.err.print("Excepció de SQL: ");  // Mostra l'error a la consola
            System.err.println(ex.getMessage());
        }
        connection.close();  // Tanca la connexió amb la base de dades
        return id;  // Retorna la darrera ID trobada
    }

    private static void exercici5() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir"); //Conexion a la base

        System.out.println("|===Llistat de jugadors===|");
        mostrarNomJugador();  // Crida a la funció mostrarNomJugador per mostrar els jugadors
        
        //static Connection con = connecIDatabase ();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entra l'id del jugador: ");    //Pregunta per l'ID del propietari de la carta
        int idUsr = entrada.nextInt();
        String limp = entrada.nextLine();    //Es nateja l'entrada
        System.out.println("Entra el nom de la carta: ");   //Es pregunta per l'altre informacio...
        String nom = entrada.nextLine();
        System.out.println("Entra el nivell (1-14): ");
        int nivell = entrada.nextInt();
        String limp2 = entrada.nextLine();    //Es nateja l'entrada
        System.out.println("Entra la raresa (normal, especial, epica, legendaria o heroe): ");
        String rare = entrada.nextLine();
        int id = ultimIdCarta() + 1;     //Busca quin es l'ultim id i suma 1
        PreparedStatement insertJug = connection.prepareStatement("INSERT INTO cartes (id, idjug, nom, nivell, raresa) VALUES (?, ?, ?, ?, ?) ");  //Es prepara la query

        insertJug.setInt(1, id);   //S'inserta tota la informacio on estan els "?"
        insertJug.setInt(2, idUsr);
        insertJug.setString(3, nom);
        insertJug.setInt(4, nivell);
        insertJug.setString(5, rare);
        insertJug.executeUpdate();  //S'executa un update de la base de dades

        connection.close();
    }

    private static int ultimIdCarta() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection = null;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  //Conexion a la base

        int id = 0;     //Es crea la variable on es guardara la id
        try {
            Statement stmt = connection.createStatement();    //Es crea el statement
            ResultSet rs = stmt.executeQuery("SELECT id FROM cartes order by id ASC");  //Es crea la query dins el statement
            while (rs.next()) {    //Es va guardant totes les id mentres hi hagi text
                id = rs.getInt("id");  //Es guarda en la variable id cadascuna de les id remplazant la anterior deixant la ultima id com la guardada
            }

        } catch (SQLException ex) {     //Si hi hagues una falla a l'hora de buscar la id
            System.err.print("Excepció de SQL: ");   //Mostrara aquest error
            System.err.println(ex.getMessage());
        }
        connection.close(); //Es tenca la conexio 
        return id;  //I es retorna la ultima id
    }

    private static void exercici6() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");     //Es comproba que la llibreria funcioni
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);        //Si no es aixi mostra un error
        }

        Connection connection = null;
        // Database connect
        // Conectamos con la base de datos
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/clash", "postgres", "accedir");  //Conexion a la base

        System.out.println("|===Llistat de jugadors===|");
        mostrarNomJugador();  // Crida a la funció mostrarNomJugador per mostrar els jugadors
        
        //static Connection con = connecIDatabase ();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entra l'id del jugador: ");    //Pregunta per l'ID del jugador, per veure les seves cartes
        int id = entrada.nextInt();
        
        Statement stmt = connection.createStatement();      //Es crea un statement
        ResultSet card = stmt.executeQuery("SELECT * FROM cartes WHERE idjug = " + id);        //Dins el statement s'executa la query per veure totes les cartes del jugador

        while (card.next()) {        //Mentres hi hagi informacio de la carta...
            System.out.println("Nom de la carta: " + card.getString("nom"));     //Mostra la informacio d'aquesta

            System.out.println("Nivell: " + card.getString("nivell"));

            System.out.println("Raresa: " + card.getString("raresa"));
            System.out.println("\n");
        }
        connection.close();     //Es tenca la connexio
    }
    
    
}
