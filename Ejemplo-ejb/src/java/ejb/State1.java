/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author entrar
 */
@Stateless
@LocalBean
public class State1 {
    @EJB
    State2Local miBean;
    String miString;
            
    @PostConstruct
    public void init()
    {
        miString="Inicio; ";
    }
    public String getString()
    {
        miString +="Estoy en el State1 Bean; " + miBean.getString();
        return miString;
    }
    public String getString2()
    {
        return miBean.getString() + "Estoy en el Stateless Bean 1 en getString2 ";
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
