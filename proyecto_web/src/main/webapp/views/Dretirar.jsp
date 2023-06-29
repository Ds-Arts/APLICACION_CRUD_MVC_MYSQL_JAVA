<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/vista7.css"/>
    <title>Retirar</title>
</head>
<body style="background-image: url(assets/img/a.jpg)">
    <section class="form-login">
        <h5>Retirar saldo</h5>
        <form action="daviplata" method="post">
            <input class="controls" type="text" name="valorRetiro" id="valorRetiro" placeholder="saldo a Retirar">    
            <input class="buttons" type="submit" name="accion" value="retiro">
        </form>
    </section>
</body>
</html>