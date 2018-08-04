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
        <div class="modal-body d-flex justify-content-start flex-wrap" id="basket_body">
            <c:forEach var="basketItem" items="${currentUser.basket}">
                <div class="item-full-view d-flex justify-content-between w-100 m-2 bg-light rounded">
                    <div class="card w-12_5">
                        <img class="card-img-top" src="${basketItem.imageUrl}" alt="item image">
                        <div class="card-body  overflow-hidden h-5">
                            <h4 class="text-center">${basketItem.name}</h4>
                        </div>
                    </div>
                    <div class="justify-content-around align-content-center w-75 mh-9 overflow-hidden align-self-center d-flex">
                        <div class="w-50 align-self-center overflow-hidden m-2">${basketItem.description}</div>
                        <div class="align-self-center m-2">${basketItem.amount} шт.</div>
                        <div class="align-self-center font-weight-bold m-2"><span class="price">${basketItem.price}</span> руб.</div>
                        <button type="button" value="${basketItem.id}" class="btn bg-primary align-self-center delete_item m-2">Удалить</button>
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