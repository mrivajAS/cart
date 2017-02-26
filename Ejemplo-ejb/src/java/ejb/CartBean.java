/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Remove;

/**
 *
 * @author entrar
 */
@Stateful
@LocalBean
public class CartBean {
    ArrayList<String> productos=new ArrayList();
    
    public void addProduct(String p){
        productos.add(p);
    }
    
    public ArrayList getProductos(){
        return productos;
    }
    
    @Remove
    public void finalizar(){
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
