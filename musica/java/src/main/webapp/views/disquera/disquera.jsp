<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>disquera</title>
  <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
</head>
  <body>
    <center>
    <div class="nu-b">
        <h1 class="h">Lista de Disqueras</h1>

        <a class="n-g" type="button" href="disquera?accion=abrirForm">
        <i></i>Agregar Disquera</a>
          <table border="1">
 
              <tr>
                <th class="t-e">Id</th><br>
                <th class="t-e">Nit</th><br> 
                <th class="t-e">Disquera</th><br>
                <th class="t-e">Telefono</th><br> 
                <th class="t-e">Dirección</th> <br> 
                <th class="t-e" colspan="2">Estado</th> <br> 
                <th class="t-e">Ediatar</th>       
                <th class="t-e">Eliminar</th>
              </tr>
        
            <c:forEach var="disquera" items="${disqueras}">         
        
              <tr>
                <td>${disquera.getidDisquera()}</td>
                <td>${disquera.getnitDisquera()}</td>
                <td>${disquera.getnombreDisquera()}</td>
                <td>${disquera.gettelefonoDisquera()}</td>
                <td>${disquera.getdireccionDisquera()}</td>

     	          <c:if test="${disquera.getestadoDisquera() == true}">
                  <td class="ac"><span >Disquera Activa</span></td> 
                </c:if>

                <c:if test="${disquera.getestadoDisquera() == false}">
                  <td class="in"><span>Disquera Inactiva</span></td> 
                </c:if>

                <td class="n-t">
                <c:if test="${disquera.getestadoDisquera() == true}">
                  <a disquera="button" href="disquera?accion=cambiarEstado&idd=${disquera.getidDisquera()}&&estado=${disquera.getestadoDisquera()}"> Inactivar</a>
                </c:if>

                <c:if test="${disquera.getestadoDisquera() == false}">
                  <a disquera="button" href="disquera?accion=cambiarEstado&idd=${disquera.getidDisquera()}&&estado=${disquera.getestadoDisquera()}"> Activar</a>
                </c:if> 
                </td>
        
        
                <td class="n-t">
                  <a disquera="button" name="accion" href="disquera?accion=editar&IDdisquera=${disquera.getidDisquera()}">Editar</a>
                </th>
                <th class="n-t">
	                <a class="1" href="" onclick="borrar (event,'${disquera.getidDisquera()}','disquera')" >Borrar</a>
	    
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
