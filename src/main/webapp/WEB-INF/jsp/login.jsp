<%@ page contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Авторизация</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center border-bottom p-2 w-50 m-auto border-success">Авторизация</h1>
    <form class="text-center m-auto w-50" action="login" method="post">
        <div class="form-group m-4">
            <input type="text" class="form-control text-center" value="${user.login}" id="login" placeholder="Логин" name="login" autocomplete="off" required>
            <div class="warn login text-danger"><span></span></div>
        </div>
        <div class="form-group m-4">
            <input type="password" class="form-control text-center" id="pass" value = "" placeholder="Enter password" name="pass" autocomplete="off" required>
            <div class="warn pass text-danger"><span>Неверный логин или пароль</span></div>
        </div>
        <button id="enter" type="submit" class="btn btn-primary">Вход</button>
    </form>
    <div class="text-center">
        <a href="registration" class="btn btn-success m-4" role="button">Зарегистрироваться</a>
    </div>
</div>
</body>
</html>