$(document).ready(function () {
	$("#btn_reg").on("click", function () {
		var user_name = $("#user_name").val();
		var surname = $("#surname").val();
		var login = $("#login").val();
		var pass = $("#pass").val();
		var pass2 = $("#pass2").val();
		var isValidate = true;
		if (user_name === "") {
			$(".warn.user_name span").text("Поле Имя не должно быть пустым");
			$(".warn.name span").show();
			isValidate = false;
		} else {
			$("#user_name").val(user_name);
			$(".warn.user_name span").hide();
		}

		if (surname === "") {
			$(".warn.surname span").text("Поле Фамилия не должно быть пустым");
			$(".warn.surname span").show();
			isValidate = false;
		} else {
			$("#surname").val(surname);
			$(".warn.surname span").hide();
		}





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
			$("#pass").val(pass);
			$(".warn.pass span").hide();
		}

		if (pass2 === "") {
			$(".warn.pass2 span").text("Пожалуйста, введите пароль еще раз");
			$(".warn.pass2 span").show();
			isValidate = false;
		} else {
			$("#pass2").val(pass2);
			$(".warn.pass2 span").hide();
		}

		if (pass2 && pass) {
			if (pass2 !== pass) {
				$(".warn.pass2 span").text("Введенный пароль не совпадает");
				$(".warn.pass2 span").show();
				isValidate = false;
			} else {
				$("#pass2").val(pass2);
				$(".warn.pass2 span").hide();
			}
		}
		return isValidate;
	});
});