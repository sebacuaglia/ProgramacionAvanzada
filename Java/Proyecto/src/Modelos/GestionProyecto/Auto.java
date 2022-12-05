/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sebac
 */
@Entity
@SequenceGenerator(
	name="auto_seq",
	sequenceName="auto_id_seq",
	allocationSize=1,
        initialValue = 301
)
public class Auto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "auto_id_seq")
    private long id;

    private int codigo;

    @ManyToOne(targetEntity = Modelo.class,  fetch = FetchType.LAZY)
    private Modelo modelo;
    
    private String color;
    
    private String precio;
    
    private String costo;
    
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

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    

    public Auto() {
    }

    public Auto(long id, int codigo, Modelo modelo, String color, String precio, boolean habilitado) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.habilitado = habilitado;
    }

    public Auto(long id, int codigo, Modelo modelo, String color, String precio, String costo, boolean habilitado) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.costo = costo;
        this.habilitado = habilitado;
    }

    public Auto(long id, Modelo modelo, String color, String precio, String costo, boolean habilitado) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.costo = costo;
        this.habilitado = habilitado;
    }
    
    

    @Override
    public String toString() {
        return modelo.getMarca().getNombre() + " " + modelo.getNombre();
    }
    
    public String getCodigoS() {
        return this.getCodigo() + "";
    }
}
