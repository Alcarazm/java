<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
  <title>Editar Disquera</title>
</head>
<body> 
  <center>
    <div class="nu-c">

        <h1 class="nu-t">Editar Disquera</h1>

        <c:forEach var="disquera" items="${modificardisquera}">

        <form method="post" action="disquera?accion=modificarDisquera&IDD=${disquera.getidDisquera()}">

        <div>
          <label> Nit de la Disquera: </label> <br>
          <input type="number" name="nitdisquera" id="nitdisquera" value="${disquera.getnitDisquera()}">
        </div>

        <div>
          <label> Nombre de la Disquera: </label> <br>
          <input type="text" name="nombredisquera" id="nombredisquera" value="${disquera.getnombreDisquera()}">
        </div>

        <div>
          <label> Telefono de la Disquera: </label> <br>
          <input type="number" name="telefonodisquera" id="telefonodisquera" value="${disquera.gettelefonoDisquera()}">
        </div>

        <div>
          <label> Dirección de la Disquera: </label> <br>
          <input type="text" name="direcciondisquera" id="direcciondisquera" value="${disquera.getdireccionDisquera()}">
        </div>

        <div>
          <label> Estado de la Disquera: </label> <br>
          <input type="checkbox" name="estadodisquera" id="estadodisquera" <c:out value="${disquera.getestadoDisquera()==true ? 'checked':'unchecked'}" default="" />        
          <label for="estadodisquera">${disquera.getestadoDisquera()==false ? 'Marca para activar':'Marca para desactivar'}</label>
        </div>
        <br>

        <div>           
          <button type="submit" name="accion" value="modificarDisquera&IDD=${disquera.getidDisquera()}"> Guardar </button>
        </div>

        </form>
        </c:forEach>
  </div>
</center>
</body>
</html>