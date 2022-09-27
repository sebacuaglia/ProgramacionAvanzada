/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author sebac
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    
    private long id;

    private String apellido;

    private String nombre;
    
    private String email;
    
    private String dni;
    
    //@Column(columnDefinition = "BigInteger")
    private String telefono;
    
    private String direccion;
    
    private String razon;
    
    private Date fechanacimiento;
    
    private int codigo;
    
 

  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
       public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
       public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
       public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
       public Date getFechaNacimiento() {
        return fechanacimiento;
    }
          
    public void setFechaNacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
       
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
       public String getRazon() {
        return razon;
    }
          
    public void setRazon(String razon) {
        this.razon = razon;
    }
 
    


    public Cliente() {
    }

    public Cliente(long id,String apellido,String nombre,String email,String dni,String telefono,String direccion,Date fechanacimiento,String razon,int codigo) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
        this.razon=razon;
        this.codigo=codigo;
        //this.escliente=escliente;
    }

    @Override
    public String toString() {
        return nombre;
    }

     public String getCodigoS() {
        return this.getCodigo() + "";
    }
}
