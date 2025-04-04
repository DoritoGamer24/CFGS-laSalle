/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author AluCiclesGS1
 */
//Indica que esta clase es una entidad JPA y será mapeada a la tabla "partides" en la base de datos
@Entity
@Table(name = "partides")
public class partides {
    // Campo que representa el identificador único de cada jugador en la base de datos
    @Id
    @GeneratedValue(generator = "gen") // Generación automática del id
    @GenericGenerator(name = "gen", strategy = "increment") //Definicion del generador
    protected int idPart;
    
    // Atributo que almacena la id del jugador 1
    @Basic
    @Column(name = "idjug1", nullable = true) // Columna "idjug1", puede ser nula
    protected int idjug1;
    
    // Atributo que almacena la id del jugador 2
    @Basic
    @Column(name = "idjug2", nullable = true) // Columna "idjug2", puede ser nula
    protected int idjug2;
    
    // Atributo para almacenar el resultado de la partida, con un máximo de 50 caracteres
    @Basic
    @Column(name = "resultat", length = 50, nullable = true) // Columna "resultat" en la tabla, puede ser nulo
    protected String resultat;
    
    // Atributo para almacenar el resultado de la partida, con un máximo de 50 caracteres
    @Basic
    @Column(name = "temps", length = 50, nullable = true) // Columna "resultat" en la tabla, puede ser nulo
    protected String temps;
    
    // Atributo para almacenar el tipo de partida, con un máximo de 50 caracteres
    @Basic
    @Column(name = "tipus", length = 50, nullable = true) // Columna "tipus" en la tabla, puede ser nulo
    protected String tipus;

    // Constructor con parámetros para inicializar todos los atributos
    public partides(int idjug1, int idjug2, String resultat, String temps, String tipus) {
        this.idjug1 = idjug1;
        this.idjug2 = idjug2;
        this.resultat = resultat;
        this.temps = temps;
        this.tipus = tipus;
    }

    // Constructor sin parámetros, se puede usar para crear una partida sin inicializar atributos
    public partides() {
        
    }

    // Métodos getter para obtener el valor de cada atributo
    public int getId() {
        return idPart;
    }

    public int getIdjug1() {
        return idjug1;
    }

    public int getIdjug2() {
        return idjug2;
    }

    public String getResultat() {
        return resultat;
    }
    
    public String getTemps() {
        return temps;
    }

    public String getTipus() {
        return tipus;
    }

    // Métodos setter para modificar el valor de cada atributo
    public void setId(int id) {
        this.idPart = id;
    }

    public void setIdjug1(int idjug1) {
        this.idjug1 = idjug1;
    }

    public void setIdjug2(int idjug2) {
        this.idjug2 = idjug2;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    public void setTemps(String temps) {
        this.temps = temps;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    // Método para mostrar los datos de la partida en la consola
    public void mostrarPartida() {
        System.out.println("Id: " + this.idPart);
        System.out.println("Id Jugador 1: " + this.idjug1);
        System.out.println("Id Jugador 2: " + this.idjug2);
        System.out.println("Resultat: " + this.resultat);
        System.out.println("Temps: " + this.temps);
        System.out.println("Tipus: " + this.tipus);
    }

    // Constructor adicional que inicializa una partida con id, idjug1 y idjug2, valores predeterminados para los demás atributos
    public partides(int id, int idjug1, int idjug2) {
        this.idPart = id;
        this.idjug1 = idjug1;
        this.idjug2 = idjug2;
        this.resultat = "1-1";      // Resultat inicial
        this.temps = "5:00";        // Temps inicial
        this.tipus = "amistos";     // Tipus inicial
    }
 
}
