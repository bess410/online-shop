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
    <link rel="stylesheet" href="/css/admin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/admin.js"></script>
</head>

<body>

    <!--Навигация-->
    <div class="d-flex bg-success p-4 fixed-top">
        <div class="bg-basic p-0 pl-1 pr-2">Администратор ${currentUser.userName}</div>
        <a href="logout" class="btn btn-danger mr-auto ml-3 p-0 px-1" role="button">Выйти</a>
        <button type="button" class="btn bg-warning p-0 px-1 ml-2" data-toggle="modal" data-target="#search">Поиск</button>
        <button id="button_add_item" type="button" class="btn bg-primary p-0 px-1 ml-2" data-toggle="modal" data-target="#addItem">Добавить товар</button>
    </div>
    <!--Категории товаров-->
    <div class="container-fluid p-0 py-1 margin-top">

         <c:forEach var="category" items="${categories}">
            <c:if test="${not empty category.itemList}">
                 <h1 class="text-center sticky-top category-header overflow-hidden bg-danger m-0">${category.name}</h1>
                 <div class="d-flex flex-wrap p-3 bg-info">
                     <c:forEach var="item" items="${category.itemList}">
                        <div>
                            <div class="card m-2 w-12_5">
                                <img class="card-img-top h-10" src="${item.imageUrl}" alt="item image">
                                <div class="card-body">
                                    <h4 class="text-center">${item.name}</h4>
                                </div>
                            </div>
                            <div class="d-none justify-content-around align-content-center w-75 mh-9 overflow-hidden align-self-center">
                                <div class="w-50">${item.description}</div>
                                <div class="align-self-center font-weight-bold"><span class="price">${item.price}</span> руб.</div>
                                <button type="button" value="${category.id}/${item.id}" data-toggle="modal" data-target="#editItem" class="btn bg-primary edit-item align-self-center">Редактировать</button>
                                <button type="button" value="${item.id}" class="btn bg-primary delete-item align-self-center">Удалить</button>
                            </div>
                        </div>
                    </c:forEach>
                    </div>
             </c:if>
        </c:forEach>
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

    <!-- The adding item window-->
    <div class="modal" id="addItem">
    </div>
    <!-- The editing item window-->
    <div class="modal" id="editItem">
    </div>
</body>

</html>