package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.NequiDao;
import model.NequiVo;

public class Nequi extends HttpServlet{
    NequiVo U=new NequiVo();
    NequiDao D=new NequiDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");
        switch(a){       
     
            case "dashboard":
            req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
            System.out.println("daviplata completa");
            break;
            case "Nrecargar":
            recargar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Nretirar":
            retirar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Nconsultar":
            consultar(req,resp);
            System.out.println("daviplata completa");
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "recarga":
            recarga(req,resp);
            break;
            case "retiro":
            retiro(req,resp);
            break;
        }
    }


    private void consultar(HttpServletRequest req, HttpServletResponse resp) {
       try {
            List nequi=D.listar(0);
            req.setAttribute("nequis", nequi);
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }


    private void retirar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nretirar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void recargar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nrecargar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void recarga(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("saldo")!=null){
            U.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga"))); 
        }
        U.setSaldo(U.getSaldo() + U.getValorRecarga());
        try {
            D.recargar(U);
            System.out.println("modificado correctamente");
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en  la modificacion"+e.getMessage().toString());
        }
    }
        private void retiro(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("saldo")!=null){
            U.setValorRetiro(Integer.parseInt(req.getParameter("valorRetiro"))); 
        }
        U.setSaldo(U.getSaldo() - U.getValorRetiro());
        try {
            D.retirar(U);
            System.out.println("modificado correctamente");
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en  la modificacion"+e.getMessage().toString());
        }
    }
}