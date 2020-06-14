
import com.mycompany.practicasistemacentralizadodos.Producto;
import com.mycompany.practicasistemacentralizadodos.sesion.ProductoJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danny
 */
public class Test {

    public static void main(String[] args) {
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SUPERMERCADO");
            
        //LA CLASE CONTROLADORA RECIBE DE PARAMETROS UNA CADENA DE CONEXION
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto();
        
        p.setNombre("MANTEQUILLA");
        p.setPrecio(BigDecimal.valueOf(10.35)); 
        
        try{
            pjc.create(p);
            //pjc.edit(p);
        }catch (Exception ex){
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
       
        
        
        
        
        
        
    }
    
}
