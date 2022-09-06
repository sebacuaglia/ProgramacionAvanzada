/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author sebac
 */
@Entity
public class Marca {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private String nombre; 
    
    /*@OneToOne
    private Pais pais;
    
    @OneToMany
    private List<Modelo> listModelo;
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Modelo> getListModelo() {
        return listModelo;
    }

    public void setListModelo(List<Modelo> listModelo) {
        this.listModelo = listModelo;
    }

    public Marca() {
    }

    public Marca(long id, String nombre, Pais pais, List<Modelo> listModelo) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.listModelo = listModelo;
    }
*/
    
    public Marca() {
    }

    public Marca(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
