$(document).ready(function () {
    $("#enter").click(function () {
        var login = $("#login").val();
        var pass = $("#pass").val();

        var isValidate = true;

        if (login === "") {
            $(".warn.login span").text("Поле Логин не должно быть пустым");
            $(".warn.login span").show();
            isValidate = false;
        } else {
            $("#login").val(login);
            $(".warn.login span").hide();
        }

        if (pass === "") {
            $(".warn.pass span").text("Поле Пароль не должно быть пустым");
            $(".warn.pass span").show();
            isValidate = false;
        } else {
            $(".warn.pass span").hide();
        }

        return isValidate;
    });
});