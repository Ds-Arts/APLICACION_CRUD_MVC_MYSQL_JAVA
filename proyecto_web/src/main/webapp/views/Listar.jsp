<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Listas.css"/>
    <link rel="stylesheet" href="assets/img"/>
    <title>Listar</title>
</head>
<body>
    <h1>Lista de Usuarios en el sistema</h1>
    <a type="button" class="btn btn-primary" href="usuario?accion=abrirFormu">
    <i class="bi bi-plus-circle"></i> 
    Agregar un nuevo usuario
    </a>
    <table class="table table-hover table-bordered">
 
        <tr>
            
            <th>Id</th>
            <th>Nombre</th>
            <th>Contraseña</th>
            <th>Telefono</th>
            <th>Direccion</th>
            <th>Email</th>
            <th><center>Estado</center></th>
            <th colspan="2"><center>Acciones</center></th>
        </tr>


        <c:forEach var="usuario" items="${usuarios}">         
        
        <tr>
        <td><td>${usuario.getIdUsuario()}</td>
        <td>${usuario.getNombre()}</td>
        <td>${usuario.getContrasena()}</td>
        <td>${usuario.getTelefono()}</td>
        <td>${usuario.getDireccion()}</td>
        <td>${usuario.getEmail()}</td>
     	 <c:if test="${usuario.getEstado() == true}">
           <td><span class="badge bg-success active">Usuario Activo</span></td> 
        </c:if>
        <c:if test="${usuario.getEstado() == false}">
            <td><span class="badge bg-danger active">Usuario Inactivo</span></td> 
        </c:if>
        
        <td>
        <c:if test="${usuario.getEstado() == true}">
           <a usuario="button" 
           class="btn btn-danger btn-sm" 
           onclick=""> 
        Inactivar
        </a>
        </c:if>
        <c:if test="${usuario.getEstado() == false}">
            <a usuario="button" 
            class="btn btn-success btn-sm" 
          >
        Activar
        </a>
        </c:if> 
        </td>
        
        
        <td>
        <a usuario="button" 
        class="btn btn-warning" 
        href="usuario?accion=modificarForm">
        <i class="bi bi-pencil"></i>
        Modificar
        </a>

	    <a usuario="button" 
	    class="btn btn-danger" 
	    onclick=""
        href="usuario?accion=eliminarU">
	    <i class="bi bi-trash"></i> 
        Eliminar
	    </a>

	    
	    </td>
        <tr>
        
    </c:forEach>    


    </table>

</body>
</html>