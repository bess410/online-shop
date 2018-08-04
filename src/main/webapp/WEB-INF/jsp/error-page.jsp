<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Без этой хрени jstl отображается в виде текста-->
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Online-shop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
</head>

<body>

    <!--Навигация-->
    <div class="d-flex bg-success p-4 fixed-top">
        <div class="bg-basic p-0 pl-1 pr-2">${currentUser.userName}</div>
        <a href="logout" class="btn btn-danger mr-auto ml-3 p-0 px-1" role="button">Выйти</a>
        <button type="button" class="btn bg-warning p-0 px-1 ml-2" data-toggle="modal" data-target="#search">Поиск</button>
        <button id="basket_button" type="button" class="btn bg-primary p-0 px-1 ml-2" data-toggle="modal" data-target="#basket">Корзина
            <span id="item_count" class="{currentUser.basket.size() == 0 ?  'd-none badge badge-light ml-1': 'badge badge-light ml-1'}">{currentUser.basket.size()}</span>
        </button>
    </div>
    <!--Категории товаров-->
    <div class="container-fluid p-0 py-1 margin-top">
        <div class="d-flex flex-wrap p-3 m-auto w-75">
            <h1>Страница, на которую вы пытаетесь попасть, не существует. Либо произошла ошибка на сервере.<br/>
                 Мы уже решаем данную проблему.</h1>
            <h1>А пока посмотрите видео с этими забавными котиками</h1>
            <div class="m-auto">
                <iframe width="853" height="480" src="https://www.youtube.com/embed/l_yJ0aH1tqE" frameborder="0" allowfullscreen ng-show="showvideo"></iframe>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <span class="text-muted">@student_production</span>
            </div>
        </footer>
    </div>

    <!-- The search window-->
    <div class="modal" id="search">
        <div class="popup_window w-50">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h1 class="text-center w-100 ml-1_1">Поиск</h1>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form action="" method="get">
                    <div class="form-group">
                        <input type="text" class="form-control w-50 m-auto" id="search_text" placeholder="Search" name="search">
                    </div>
                    <div class="text-center">
                        <button id="button_search" class="btn btn-primary m-auto">Найти</button>
                    </div>
                </form>
                <!-- Modal footer -->
                <div id="search_footer" class="d-flex justify-content-start flex-wrap modal-footer">
                </div>
            </div>
        </div>
    </div>

    <!-- The basket window-->
    <div class="modal" id="basket">

    </div>

</body>

</html>