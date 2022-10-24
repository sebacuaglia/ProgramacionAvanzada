/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.util.Date;
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
public class Venta {
    
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;

    private int codigo;

    private Date fecha;
    
    @ManyToOne(targetEntity = Cliente.class,  fetch = FetchType.LAZY)
    private Cliente cliente;
    
    @ManyToOne(targetEntity = Personal.class,  fetch = FetchType.LAZY)
    private Personal personal;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Venta() {
    }

    public Venta(long id, int codigo, Date fecha, Cliente cliente, Personal personal) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.personal = personal;
    }
    
    public String getCodigoS() {
        return this.getCodigo() + "";
    }
    
}
