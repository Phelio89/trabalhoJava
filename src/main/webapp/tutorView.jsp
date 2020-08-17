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
    <form class="border border-light p-5" action="http://localhost:8080/vetplace/tutores?opcao=editSave&clinica=${clinica}" method="post">

        <p class="h4 mb-4 text-center">Editar Cadastro de ${tutor.nome}</p>

        <input type="hidden" id="id" name="id" value="${tutor.id}">

        <label for="nome">Nome</label>
        <input type="text" id="nome" name="nome" class="form-control mb-4" placeholder="Nome" value="${tutor.nome}">

        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" class="form-control mb-4" placeholder="fulano@gmail.com" value="${tutor.email}">

        <label for="celular">Celular</label>
        <input type="text" id="celular" name="celular" class="form-control mb-4" placeholder="(00)00000-0000" value="${tutor.celular}">

        <label for="cpf">CPF</label>
        <input type="text" id="cpf" name="cpf" class="form-control mb-4" placeholder="000.000.00-00" value="${tutor.cpf}">

        <label for="cep">CEP</label>
        <input type="text" id="cep" name="cep" class="form-control mb-4" placeholder="00000-000" value="${tutor.cep}">

        <label for="bairro">Bairro</label>
        <input type="text" id="bairro" name="bairro" class="form-control mb-4" placeholder="Bairro" value="${tutor.bairro}">

        <label for="cidade">Cidade</label>
        <input type="text" id="cidade" name="cidade" class="form-control mb-4" placeholder="Cidade" value="${tutor.cidade}">

        <label for="estado">Estado</label>
        <input type="text" id="estado" name="estado" class="form-control mb-4" placeholder="Estado" value="${tutor.estado}">

        <label for="logradouro">Logradouro</label>
        <input type="text" id="logradouro" name="logradouro" class="form-control mb-4" placeholder="Logradouro" value="${tutor.logradouro}">

        <label for="numero">Número</label>
        <input type="text" id="numero" name="numero" class="form-control mb-4" placeholder="000" value="${tutor.numero}">

        <button class="btn btn-info btn-block my-4" type="submit">Salvar Edição</button>
    </form>

    <p class="h4 mb-4 text-center">Pets</p>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Paciente</th>
            <th>Espécie</th>
            <th>Raça</th>
            <th>sexo</th>
            <th>Editar</th>
            <th>Excluir</th>
            <th>Marcar Consulta</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${pets}">
            <tr>
                <td>${p.nome}</td>
                <td>${p.especie}</td>
                <td>${p.raca}</td>
                <td>${p.sexo}</td>
                <td><a href="http://localhost:8080/vetplace/pacientes?opcao=edit&clinica=${clinica}&id=${p.id}">Editar</a></td>
                <td><a href="http://localhost:8080/vetplace/pacientes?opcao=delete&clinica=${clinica}&id=${p.id}">Excluir</a></td>
                <td><a href="http://localhost:8080/vetplace/consultas?opcao=novo&clinica=${clinica}&id=${p.id}">Consulta</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="http://localhost:8080/vetplace/pacientes?opcao=novo&clinica=${clinica}&id=${tutor.id}"><button class="btn btn-info btn-block my-4">Cadastrar Novo Pet</button></a>
</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>