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



/**
 *
 * @author AluCiclesGS1
 */
//Indica que esta clase es una entidad JPA y será mapeada a la tabla "jugadors" en la base de datos
@Entity
@Table(name = "jugadors")
public class jugador {

    // Campo que representa el identificador único de cada jugador en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generación automática del id
    protected int id;
    
    // Atributo para almacenar el nombre del jugador, con un máximo de 50 caracteres
    @Basic
    @Column(name = "nom", length = 50, nullable = true) // Columna "nom" en la tabla, puede ser nulo
    protected String nom;
    
    // Atributo que almacena el nivel del jugador
    @Basic
    @Column(name = "nivell", nullable = true) // Columna "nivell", puede ser nula
    protected int nivell;
    
    // Atributo para almacenar la cantidad de copas ganadas por el jugador
    @Basic
    @Column(name = "copes", nullable = true) // Columna "copes", puede ser nula
    protected int copes;
    
    // Atributo para almacenar la cantidad de oro del jugador
    @Basic
    @Column(name = "oro", nullable = true) // Columna "oro", puede ser nula
    protected int oro;
    
    // Atributo para almacenar la cantidad de gemas del jugador
    @Basic
    @Column(name = "gemes", nullable = true) // Columna "gemes", puede ser nula
    protected int gemes;
    
    // Atributo que almacena la cantidad de estrellas del jugador
    @Basic
    @Column(name = "estrelles", nullable = true) // Columna "estrelles", puede ser nula
    protected int estrelles;

    // Constructor con parámetros para inicializar todos los atributos
    public jugador(String nom, int nivell, int copes, int oro, int gemes, int estrelles) {
        this.nom = nom;
        this.nivell = nivell;
        this.copes = copes;
        this.oro = oro;
        this.gemes = gemes;
        this.estrelles = estrelles;
    }

    // Constructor sin parámetros, se puede usar para crear un jugador sin inicializar atributos
    public jugador() {
        
    }

    // Métodos getter para obtener el valor de cada atributo
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNivell() {
        return nivell;
    }

    public int getCopes() {
        return copes;
    }

    public int getOro() {
        return oro;
    }

    public int getGemes() {
        return gemes;
    }

    public int getEstrelles() {
        return estrelles;
    }

    // Métodos setter para modificar el valor de cada atributo
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public void setCopes(int copes) {
        this.copes = copes;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setGemes(int gemes) {
        this.gemes = gemes;
    }

    public void setEstrelles(int estrelles) {
        this.estrelles = estrelles;
    }

    // Método para mostrar los datos del jugador en la consola
    public void mostrarJugador() {
        System.out.println("Id: " + this.id);
        System.out.println("Nom: " + this.nom);
        System.out.println("Nivell: " + this.nivell);
        System.out.println("Copes: " + this.copes);
        System.out.println("Or: " + this.oro);
        System.out.println("Gemes: " + this.gemes);
        System.out.println("Estrelles: " + this.estrelles);
    }

    // Constructor adicional que inicializa un jugador con id y nombre, valores predeterminados para los demás atributos
    public jugador(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.nivell = 1;  // Nivel inicial del jugador
        this.copes = 0;   // Copas iniciales
        this.oro = 0;     // Oro inicial
        this.gemes = 0;   // Gemas iniciales
        this.estrelles = 0; // Estrellas iniciales
    }
 
}

