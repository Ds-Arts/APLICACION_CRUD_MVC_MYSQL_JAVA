package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaviplataDao;

import model.DaviplataVo;

public class Daviplata extends HttpServlet{
    DaviplataVo U=new DaviplataVo();
    DaviplataDao D=new DaviplataDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");
        switch(a){ 
            case "cuenta":
            cuenta(req,resp);
            System.out.println("daviplata completa");
            break;           
            case "dashboard":
            daviplata(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Drecargar":
            recargar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Dretirar":
            retirar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Dconsultar":
            consultar1(req,resp);
            System.out.println("daviplata completa");
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
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
    private void consultar1(HttpServletRequest req, HttpServletResponse resp) {
       try {
            List daviplata=D.listar(0);
            req.setAttribute("daviplatas", daviplata);
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    private void retirar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Dretirar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void recargar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Drecargar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void daviplata(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/dashboardD.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
        private void cuenta(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cuenta.jsp").forward(req, resp);
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
            D.recargar(U);
            System.out.println("modificado correctamente");
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en  la modificacion"+e.getMessage().toString());
        }
    }
}

