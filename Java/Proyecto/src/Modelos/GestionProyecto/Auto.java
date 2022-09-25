/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sebac
 */
@Entity
public class Auto {
    
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;

    private int codigo;

    @ManyToOne(targetEntity = Modelo.class,  fetch = FetchType.LAZY)
    private Modelo modelo;
    
    private String color;
    
    private String precio;
    
    private String matricula;
    
    private String anio;
    
    private boolean usado;
    
    //modela si esta disponible en la agencia
    private boolean habilitado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Auto() {
    }

    public Auto(long id, int codigo, Modelo modelo, String color, String precio, String matricula, String anio, boolean usado, boolean habilitado) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.matricula = matricula;
        this.anio = anio;
        this.usado = usado;
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return modelo.getMarca().getNombre() + " " + modelo.getNombre() + " - Año: " + anio ;
    }
    
    public String getCodigoS() {
        return this.getCodigo() + "";
    }
}
