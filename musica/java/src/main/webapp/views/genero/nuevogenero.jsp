<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Nuevo Genero</title>
        <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
    </head>
    <body>

        <center>
            <div class="nu-c">
    
            <h1 class="nu-t">Nuevo Genero</h1>
    
            <form method="post" action="genero?accion=addGenero"> 
    
                <label for="nombre1">NOMBRE</label><br>
                <input type="text" id="nombre1" placeholder="ingrese el nombre del genero" name="nombre"><br><br>
    
                <label for="chkestado">ESTADO</label><br>
                <input type="checkbox" name="chkestado" id="chkestado" >
                <label for="chkestado"> Activo</label> <br><br>
    
                <button type="submit" name="accion" value="add">Guardar</button>
            </form>
        </div>
        </center>

</body>
</html>


