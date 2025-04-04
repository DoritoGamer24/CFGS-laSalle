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
//Indica que esta clase es una entidad JPA y será mapeada a la tabla "clans" en la base de datos
@Entity
@Table(name = "clans")
public class clan {
    
    // Campo que representa el identificador único de cada jugador en la base de datos
    @Id
    @GeneratedValue(generator = "genClan") // Generación automática del id
    @GenericGenerator(name = "genClan", strategy = "increment") //Definicion del generador
    protected int idClan;
    
    // Atributo para almacenar el nombre del clan, con un máximo de 50 caracteres
    @Basic
    @Column(name = "nom", length = 50, nullable = true) // Columna "nom" en la tabla, puede ser nulo
    protected String nomC;
    
    // Atributo que almacena el nivel del clan
    @Basic
    @Column(name = "nivell", nullable = true) // Columna "nivell", puede ser nula
    protected int nivellC;
    
    // Atributo que almacena las copas del clan
    @Basic
    @Column(name = "copas", nullable = true) // Columna "copas", puede ser nula
    protected int copasC;
    
    // Atributo para almacenar el admin del clan
    @Basic
    @Column(name = "idAdmin", nullable = true) // Columna "idAdmin", puede ser nula
    protected int idAdmin;
    
    // Atributo para almacenar el tipo de clan que es (Privat/Public)
    @Basic
    @Column(name = "tipusC", nullable = true) // Columna "tipusC", puede ser nula
    protected String clanType;
    

    // Constructor con parámetros para inicializar todos los atributos
    public clan(String nomC, int nivellC, int copasC, int idAdmin, String clanType) {
        this.nomC = nomC;
        this.nivellC = nivellC;
        this.copasC = copasC;
        this.idAdmin = idAdmin;
        this.clanType = clanType;
    }

    // Constructor sin parámetros, se puede usar para crear un clan sin inicializar atributos
    public clan() {
        
    }

    // Métodos getter para obtener el valor de cada atributo
    public int getIdClan() {
        return idClan;
    }

    public String getNomC() {
        return nomC;
    }

    public int getNivellC() {
        return nivellC;
    }
    
    public int getCopasC() {
        return copasC;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getClanType() {
        return clanType;
    }

    // Métodos setter para modificar el valor de cada atributo
    public void setIdClan(int id) {
        this.idClan = id;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public void setNivellC(int nivellC) {
        this.nivellC = nivellC;
    }
    
    public void setCopasC(int copasC) {
        this.copasC = copasC;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setClanType(String clanType) {
        this.clanType = clanType;
    }

    // Método para mostrar los datos del clan en la consola
    public void mostrarClan() {
        System.out.println("Id: " + this.idClan);
        System.out.println("Nom: " + this.nomC);
        System.out.println("Nivell: " + this.nivellC);
        System.out.println("Copas del Clan: " + this.copasC);
        System.out.println("Id del Admin: " + this.idAdmin);
        System.out.println("Tipus de clan: " + this.clanType);
    }

    // Constructor adicional que inicializa un clan con id, nombre y id de admin, valores predeterminados para los demás atributos
    public clan(int id, String nom, int admin) {
        this.idClan = id;
        this.nomC = nom;
        this.nivellC = 1;  // Nivel inicial del clan
        this.copasC = 10;  // Copas iniciales del clan
        this.idAdmin = admin;
        this.clanType = "private";     // Tipus de clan inicial
    }
}
