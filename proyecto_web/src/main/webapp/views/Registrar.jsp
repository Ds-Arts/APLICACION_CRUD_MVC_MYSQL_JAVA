<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Registro.css"/>
    <link rel="stylesheet" href="assets/img/a.jpg"/>
    <title>Registro</title>
</head>
<body>

        <h1>Registrate</h1>

        <div class="container">
        <form class="form" action="usuario" method="post">

            
        <div class=".container-inputs">  
            <label for="usu_nombre">USUARIO</label>
                <input type="text" name="usu_nombre" id="usu_nombre" placeholder="ingresa tu usuario" required>

            
            

            
            <label for="usu_contraseña">Contraseña</label>                
                <input type="text" name="usu_contrasena" id="usu_contrasena" placeholder="ingrese su contraseña" required>
            
            

            
            <label for="usu_telefono">Telefono</label>                
                <input type="text" name="usu_telefono" id="usu_telefono" placeholder="ingresa tu telefono" required>
            
           
            
            
            <label for="usu_direccion">Direccion</label>                
                <input type="text" name="usu_direccion" id="usu_direccion" placeholder="ingresa tu direccion" required>
            
            

            
            <label for="usu_email">Email</label>                
                <input type="text" name="usu_email" id="usu_email" placeholder="ingresa tu correo" required>
            
           
            
            
             <label for="usu_estado">Estado</label>                
                
                <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input" placeholder="ingresa tu estado">
            </div>
            

            <div class="button">
                
                <button type="submit" name="accion" value="add">Registrate</button>

            </form> 
                <p>Al registrarte acepta todas nuestros <u>terminos y condiciones</u></p>
                <p>¿ya tienes una cuenta? <a class="link" href="usuario?accion=nequi">Inicia en Nequi</a> o <a class="link" href="usuario?accion=daviplata">Inicia en daviplata</a></p> 
                <p>Volver al<a class="link" href="usuario?accion=home">Inicio</a>o desea <a class="link" href="usuario?accion=listar">ver los usuarios registrados</a></p>
            </div>
           
          
</body>
</html>