/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.principal;

import com.company.entidades.Productos;
import com.company.session.ProductosJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danny
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Formulario f = new Formulario();
        f.setVisible(true);
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");

        ProductosJpaController pjc = new ProductosJpaController(emf);

        Productos p = new Productos();

        p.setCodigoProducto(2);
        p.setNombreProducto("JUE");
        Double precio = 500.5;
        BigDecimal bdl = BigDecimal.valueOf(precio);
        p.setDetalleProducto("Programa");
        p.setPrecioProducto(bdl);

        try {
            pjc.create(p);

        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }*/
    }
}
