/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.CartBean;
import ejb.NewSessionBean;
import ejb.State1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author entrar
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    @EJB
    private NewSessionBean newSessionBean;

    @EJB
    State1 miBean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Carrito de la compra </h1>");

            HttpSession session = request.getSession();
    
            CartBean carrito = (CartBean) session.getAttribute("carrito");
            
            if(carrito == null){ 
               carrito=(CartBean)InitialContext.doLookup("java:global/Ejemplo/Ejemplo-ejb/CartBean");
               session.setAttribute("carrito", carrito);  
            } 
            String producto=request.getParameter("producto");
            if(producto!=null){
                carrito.addProduct(producto);
                ArrayList<String> productos=carrito.getProductos(); 
                out.println("<h2>Lista de productos en el carrito:</h2>");
                for(String p: productos) {
                    out.println("<b>"+p+"</b>");
                }
            }  
            
            newSessionBean.addProduct();
            
                    
                    
            out.println("<form action='NewServlet'>");
            out.println("<input type='text' name='producto'/>");
            out.println("<input type='submit' value='Añadir'/>");
            out.println("</form> <br>");
             out.println("Numero de productos en carritos:" + 
            newSessionBean.getProduct()+"<br>");

            out.println("</body>");
            out.println("</html>");
        } catch (NamingException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
