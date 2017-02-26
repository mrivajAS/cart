/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author entrar
 */
@Stateless
public class State2 implements State2Local {
    
    @Override
    public String getString() {
        return "Estoy en State2; ";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
