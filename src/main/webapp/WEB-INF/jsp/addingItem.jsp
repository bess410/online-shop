<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Без этой хрени jstl отображается в виде текста-->
<%@ page isELIgnored="false"%>
<div class="popup_window w-50">
    <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
            <h1 class="text-center w-100 ml-1_1">Добавление товара</h1>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body d-flex justify-content-start flex-wrap" id="basket_body">
            <form class="text-center m-auto w-75" action="admin/createItem" method="post">
                <div class="form-group m-4">
                    <input class="w-100" type="text" list="categories" name="categoryName" placeholder="Выберите категорию" required/>
                    <datalist id="categories">
                        <c:forEach var="category" items="${categories}">
                            <option>${category.name}</option>
                        </c:forEach>
                    </datalist>
                </div>
                <div class="form-group m-4">
                    <div class="input-group">
                        <span class="input-group-btn">
                            <span class="btn btn-default btn-file">
                                Выберите картинку
                                <input type="file" id="imgInp" class="w-100" required>
                            </span>
                        </span>
                        <input name="imageUrl" id="imageUrl" type="text" class="form-control w-100" readonly>
                    </div>
                    <img id="img-upload"/>
                </div>
                <div class="form-group m-4">
                   <input class="w-100" type="text" maxlength="20" id="name" name="name" placeholder="Введите название" required/>
                </div>
                <div class="form-group m-4">
                   <textarea class="w-100" id="description" name="description" placeholder="Введите описание товара" required></textarea>
                </div>
                <div class="form-group m-4">
                    <input class="w-100" type="number" id="price" name="price" placeholder="Введите цену" required/>
                </div>
                <div class="form-group m-4">
                    <input class="w-100" type="number" id="amount" name="amount" placeholder="Введите количество товара" required/>
                </div>
                <button type="submit" class="btn btn-primary m-auto">Добавить товар</button>
            </form>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer p-4 justify-content-around d-flex justify-content-start">
        </div>
    </div>
</div>