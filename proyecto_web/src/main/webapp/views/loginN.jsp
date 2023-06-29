<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Vista2.css"/>
    <link rel="stylesheet" href="assets/img"/>
    <title>vista 2</title>
</head>
<body style="background-image:url(assets/img/aaaaa.png);">

        <section class="form-login">
        <form class="form" action="usuario" method="post">
        <h5>BIenvenido a nequi</h5>
        <input class="controls" type="text" name="usu_nombre" id="usu_nombre" placeholder="ingresa tu usuario">
        <input class="controls" type="text" name="usu_contrasena" id="usu_contrasena" placeholder="ingrese su contraseña">
        <input class="buttons" type="submit" name="accion" value="iniciar">
    </form> 
        <a href="usuario?accion=home"><input class="buttons" type="submit" name="" value="volver"></a>
        <p><a href="usuario?accion=abrirFormu">Registrate aqui</a> <br> <br> <br><a href="nequi?accion=cuenta">¿Olvidaste tu contraseña?</a></p>
        
    </section>
</body>
</html>