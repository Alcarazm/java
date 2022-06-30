<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="assents/CSS/estilo.css">
  <title>Editar Genero</title>
</head>
<body> 
  <center>
    <div class="nu-c">

        <h1 class="nu-t">Editar Genero</h1>

        <c:forEach var="genero" items="${modificargenero}">

        <form method="post" action="genero?accion=modificarGenero&IDG=${genero.getidGenero()}">

        <div>
          <label> Nombre del genero: </label> <br>
          <input type="text" name="nombregenero" id="nombregenero" value="${genero.getnombreGenero()}">
        </div>

        <div>
          <label> Estado del genero: </label> <br>
          <input type="checkbox" name="estadogenero" id="estadogenero" <c:out value="${genero.getestadoGenero()==true ? 'checked':'unchecked'}" default="" />        
          <label for="estadogenero">${genero.getestadoGenero()==false ? 'Marca para activar':'Marca para desactivar'}</label>
        </div>
        <br>

        <div>           
          <button type="submit" name="accion" value="modificarGenero&IDG=${genero.getidGenero()}"> Guardar </button>
        </div>

        </form>
        </c:forEach>
  </div>
</center>
</body>
</html>