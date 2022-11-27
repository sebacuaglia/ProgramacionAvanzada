/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sebac
 */
@Entity
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int codigo;
    
    @ManyToOne(targetEntity = Auto.class,  fetch = FetchType.LAZY)
    private Auto auto;
    
    @ManyToOne(targetEntity = Venta.class,  fetch = FetchType.LAZY)
    private Venta venta;
    
    private int precioAuto;
    
    private int porcImpuesto;
    
    private double montoImpuesto;
    
    private int cantidad;

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

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getPrecioAuto() {
        return precioAuto;
    }

    public void setPrecioAuto(int precioAuto) {
        this.precioAuto = precioAuto;
    }

    public int getPorcImpuesto() {
        return porcImpuesto;
    }

    public void setPorcImpuesto(int porcImpuesto) {
        this.porcImpuesto = porcImpuesto;
    }

    public double getMontoImpuesto() {
        return montoImpuesto;
    }

    public void setMontoImpuesto(double montoImpuesto) {
        this.montoImpuesto = montoImpuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public DetalleVenta() {
    }

    public DetalleVenta(long id, int codigo, Auto auto, Venta venta, int precioAuto, int porcImpuesto, double montoImpuesto, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.auto = auto;
        this.venta = venta;
        this.precioAuto = precioAuto;
        this.porcImpuesto = porcImpuesto;
        this.montoImpuesto = montoImpuesto;
        this.cantidad = cantidad;
    }

    
    
    
    
    public String getCodigoS() {
        return this.getCodigo() + "";
    }
    
}
