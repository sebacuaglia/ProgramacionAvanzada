/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sebac
 */
@Entity
@SequenceGenerator(
	name="modelo_seq",
	sequenceName="modelo_id_seq",
	allocationSize=1,
        initialValue = 301
)
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "modelo_id_seq")
    private long id;

    private int codigo;

    private String nombre;

    @ManyToOne(targetEntity = Marca.class, fetch = FetchType.LAZY)
    private Marca marca;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo(long id, int codigo, String nombre, Marca marca) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Modelo() {
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getCodigoS() {
        return this.getCodigo() + "";
    }

}
