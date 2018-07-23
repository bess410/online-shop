<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Без этой хрени jstl отображается в виде текста-->
<%@ page isELIgnored="false"%>

<div class="popup_window w-50">
    <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
            <h1 class="text-center w-100 ml-1_1">Корзина</h1>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body d-flex justify-content-start flex-wrap" id="busket_body">

            <c:forEach var="busketItem" items="${currentUser.busket}">
                <div class="item-full-view d-flex justify-content-between w-100 m-2 bg-light rounded">
                    <div class="card w-12_5">
                        <img class="card-img-top" src="${busketItem.imageUrl}" alt="item image">
                        <div class="card-body">
                            <h4 class="text-center">${busketItem.name}</h4>
                        </div>
                    </div>
                    <div class="justify-content-around align-content-center w-75 mh-9 overflow-hidden align-self-center d-flex">
                        <div class="w-50">${busketItem.description}</div>
                        <div class="align-self-center font-weight-bold"><span class="price">${busketItem.price}</span> руб.</div>
                        <button type="button" value="${busketItem.id}" class="btn bg-primary align-self-center delete_item">Удалить</button>
                    </div>
                </div>
            </c:forEach>

        </div>
        <!-- Modal footer -->
        <div class="modal-footer p-4 justify-content-around d-flex justify-content-start">
            <div class="d-flex flex-column rounded">
                <div>
                    Cумма товаров:
                </div>
                <div>
                    Скидка <span id="discount">${currentUser.getDiscount()}</span>%
                </div>
                <div>
                    Итого:
                </div>
            </div>
            <div class="d-flex flex-column rounded">
                <div>
                    <span id="sum">${currentUser.getSum()}</span> руб.
                </div>
                <div>
                    <span id="sum-discount">${currentUser.getSumDiscount()}</span> руб.
                </div>
                <div>
                    <span id="sum-to-pay">${currentUser.getSumToPay()}</span> руб.
                </div>
            </div>
            <form action="" method="get">
                <div class="text-center">
                    <button id="order_items" class="btn btn-primary m-auto">Оформить</button>
                </div>
            </form>
        </div>
    </div>
</div>