<%-- 
    Document   : Carrito
    Created on : 14-feb-2017, 11:00:14
    Author     : entrar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.Carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprando con el carrito</title>
    </head>
    <body>
        <h1>Carrito de la compra</h1>
        <form  action = "Carrito.jsp"> 
            <input type="text" name="producto" value="" />
            <input type="submit" value="Añadir al carrito" />
        </form>
        <%
            Carrito cart=(Carrito) session.getAttribute("carrito");
            if(cart==null)
            {
                cart=(Carrito) InitialContext.doLookup 	
                            ("java:global/Ejemplo/Ejemplo-ejb/Carrito");
                session.setAttribute("carrito", cart);
            }
            String producto=request.getParameter("producto");
            if(producto!=null){
                cart.addProducto(producto);
            }
            ArrayList<String> productos=cart.getProductos();
            for(String p: productos)
                out.println(p+"<br>");
            
        %>
    </body>
</html>
