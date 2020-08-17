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

    <title>Editar Cadastro</title>
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
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/vetplace/consultas?opcao=consultas&clinica=${clinica}">Consultas</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <form class="border border-light p-5" action="http://localhost:8080/vetplace/pacientes?opcao=save&clinica=${clinica}" method="post">

        <p class="h4 mb-4 text-center">Cadastrar Pet</p>

        <input type="hidden" id="id" name="id" value="${id}">

        <label for="nome">nome</label>
        <input type="text" id="nome" name="nome" class="form-control mb-4" >

        <label for="especie">Espécie</label>
        <input type="text" id="especie" name="especie" class="form-control mb-4">

        <label for="raca">Raça</label>
        <input type="text" id="raca" name="raca" class="form-control mb-4" >

        <label for="sexo">Sexo</label>
        <input type="text" id="sexo" name="sexo" class="form-control mb-4">

        <button class="btn btn-info btn-block my-4" type="submit">Salvar</button>
    </form>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>