/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author sebac
 */
@Entity
public class Pais {

    @Id
    @Column(columnDefinition = "SERIAL")
    private long id;

    private String codigopais;

    private String nombrepais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(String codigopais) {
        this.codigopais = codigopais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @Override
    public String toString() {
        return nombrepais;
    }

    public Pais() {
    }

    public Pais(long id, String codigopais, String nombrepais) {
        this.id = id;
        this.codigopais = codigopais;
        this.nombrepais = nombrepais;
    }
}
