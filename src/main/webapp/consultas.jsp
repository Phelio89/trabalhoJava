<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 09/05/2020
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="pt-br">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Tutores</title>
</head>
<body>
<div class="header">
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="#">VetPlace</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/vetplace/tutores?opcao=tutores&clinica=${clinica}">Tutores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/vetplace/tutores?opcao=novo&clinica=${clinica}">Cadastro de Tutor</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/vetplace/consultas?opcao=consultas&clinica=${clinica}">Consultas</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Paciente</th>
            <th>Data/Hora</th>
            <th>Espécie</th>
            <th>Raça</th>
            <th>sexo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${consultas}">
            <tr>
                <td>${c.paciente.nome}</td>
                <td>${c.data_hora_inicial}</td>
                <td>${c.paciente.especie}</td>
                <td>${c.paciente.raca}</td>
                <td>${c.paciente.sexo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>