<%@ page contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Регистрация</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="/js/registration.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center border-bottom p-2 w-50 m-auto border-success">Регистрация</h1>
    <form class="text-center m-auto w-50" action="registration" method="post">
        <div class="form-group m-4">
            <input type="text" class="form-control text-center" id="user_name" value = "${user.userName}" placeholder="Имя" name="userName" autocomplete="off" required>
            <div class="warn user_name text-danger"><span></span></div>
        </div>
        <div class="form-group m-4">
            <input type="text" class="form-control text-center" id="surname" value = "${user.surname}" placeholder="Фамилия" name="surname" autocomplete="off" required>
            <div class="warn surname text-danger"><span></span></div>
        </div>
        <div class="form-group m-4">
            <input type="text" class="form-control text-center" id="login" value = "${user.login}" placeholder="Логин" name="login" autocomplete="off" required>
            <div class="warn login text-danger"><span></span></div>
        </div>
        <div class="form-group m-4">
            <input type="password" class="form-control text-center" id="pass" placeholder="Пароль" name="pass" autocomplete="off" required>
            <div class="warn pass text-danger"><span></span></div>
        </div>
        <div class="form-group m-4">
            <input type="password" class="form-control text-center" id="pass2" placeholder="Повторить пароль" name="pass2" autocomplete="off" required>
            <div class="warn pass2 text-danger"><span>${error}</span></div>
        </div>
        <button id="btn_reg" type="submit" class="btn btn-primary">Зарегистрироваться</button>
    </form>
    <div class="text-center">
        <a href="login" class="btn btn-success m-4" role="button">Авторизация</a>
    </div>
</div>
</body>
</html>