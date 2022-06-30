<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Genero</title>
  <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
</head>
  <body>
    <center>
    <div class="nu-b">
        <h1 class="h">Lista de Generos</h1>

        <a class="n-g" type="button" href="genero?accion=abrirForm">
        <i></i>Agregar Genero</a>
          <table border="1">
 
              <tr>
                <th class="t-e">Id</th> <br>
                <th class="t-e">Genero</th> <br> 
                <th class="t-e" colspan="2">Estado</th> <br> 
                <th class="t-e">Ediatar</th>       
                <th class="t-e">Eliminar</th>
              </tr>
        
            <c:forEach var="genero" items="${generos}">         
        
              <tr>
                <td>${genero.getidGenero()}</td>
                <td>${genero.getnombreGenero()}</td>

     	          <c:if test="${genero.getestadoGenero() == true}">
                  <td class="ac"><span >Genero Activo</span></td> 
                </c:if>

                <c:if test="${genero.getestadoGenero() == false}">
                  <td class="in"><span>Genero Inactivo</span></td> 
                </c:if>

                <td class="n-t">
                <c:if test="${genero.getestadoGenero() == true}">
                  <a genero="button" href="genero?accion=cambiarEstado&idg=${genero.getidGenero()}&&estado=${genero.getestadoGenero()}"> Inactivar</a>
                </c:if>

                <c:if test="${genero.getestadoGenero() == false}">
                  <a genero="button" href="genero?accion=cambiarEstado&idg=${genero.getidGenero()}&&estado=${genero.getestadoGenero()}"> Activar</a>
                </c:if> 
                </td>
        
        
                <td class="n-t">
                  <a genero="button" name="accion" href="genero?accion=editar&IDgenero=${genero.getidGenero()}">Editar</a>
                </th>
                <th class="n-t">
	                <a class="1" href="" onclick="borrar (event,'${genero.getidGenero()}','genero')" >Borrar</a>
	    
	              </td>
              </tr>
        
          </c:forEach>    


        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="../js/main.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="assents/js/eliminar.js"></script>
  </center>
</body>
</html>
