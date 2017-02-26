/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;

/**
 *
 * @author entrar
 */
@Singleton
@LocalBean
public class NewSessionBean {
    int nproductos=0;
    
    @Schedule(second="*/3", minute="*", hour="*")
    public void addProduct() {
        nproductos++;
    }
    
    public int getProduct() {
        return nproductos;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
