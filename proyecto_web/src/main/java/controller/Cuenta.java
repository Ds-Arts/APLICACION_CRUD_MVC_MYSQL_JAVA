package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cuenta extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "home":
                home(req,resp);
            break;
            case "abrirFormu":
                abrirForm(req,resp);
            break;
            case "daviplata":
                daviplata(req,resp);
                System.out.println("modificacion completa");
            break;
            case "nequi":
                nequi(req,resp);
                System.out.println("modificacion completa");
            break;
            case "nosotros":
                nosotros(req,resp);
            break;
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
 
    
    private void home(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("Registrar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void daviplata(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/loginD.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void nequi(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/loginN.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    private void nosotros(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nosotros.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
}
