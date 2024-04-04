/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelos.GestionProyecto;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author sebac
 */
public class GestorVistaVentaIT {
    
    public GestorVistaVentaIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getForm method, of class GestorVistaVenta.
     */

    @Test
    public void testSubtotal() {
        System.out.println("subtotal");
        int monto = 5000;
        int cantidad = 2;
        GestorVistaVenta instance = new GestorVistaVenta();
        Double expResult = 10000.0;
        Double result = instance.subtotal(monto, cantidad);
        Assert.assertEquals(expResult, result);
       
    }

    /**
     * Test of calcularImpuesto method, of class GestorVistaVenta.
     */
    @Test
    public void testCalcularImpuesto() {
        System.out.println("calcularImpuesto");
        int monto = 5000;
        int cantidad = 2;
        int impuesto = 10;
        GestorVistaVenta instance = new GestorVistaVenta();
        double expResult = 1000.0;
        double result = instance.calcularImpuesto(monto, cantidad, impuesto);
        Assert.assertEquals(expResult, result, 0.2);
        
    }
    
}
