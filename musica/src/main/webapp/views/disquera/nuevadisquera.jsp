<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Nueva Disquera</title>
        <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
    </head>
    <body>

        <center>
            <div class="nu-c">
    
            <h1 class="nu-t">Nueva Disquera</h1>
    
            <form method="post" action="disquera?accion=addDisquera"> 
    
                <label for="nit1">NIT</label><br>
                <input type="number" id="nit1" placeholder="ingrese el nit de la disquera" name="nit"><br><br>

                <label for="nombre1">NOMBRE</label><br>
                <input type="text" id="nombre1" placeholder="ingrese el nombre de la disquera" name="nombre"><br><br>

                <label for="telefono1">TELEFONO</label><br>
                <input type="number" id="telefono1" placeholder="ingrese el telefono de la disquera" name="telefono"><br><br>

                <label for="direccion1">DIRECCIÓN</label><br>
                <input type="text" id="direccion1" placeholder="ingrese la direccion de la disquera" name="direccion"><br><br>
    
                <label for="chkestado">ESTADO</label><br>
                <input type="checkbox" name="chkestado" id="chkestado" >
                <label for="chkestado"> Activo</label> <br><br>
    
                <button type="submit" name="accion" value="add">Guardar</button>
            </form>
        </div>
        </center>

</body>
</html>
