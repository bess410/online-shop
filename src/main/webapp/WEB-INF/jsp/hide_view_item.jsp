<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

 <div class="card w-12_5 m-2">
     <img class="card-img-top h-10" src="${item.imageUrl}" alt="item image">
     <div class="card-body h-5 overflow-hidden">
         <h4 class="text-center">${item.name}</h4>
     </div>
 </div>
 <div class="d-none justify-content-around align-content-center w-75 mh-9 overflow-hidden align-self-center">
     <div class="w-50 align-self-center overflow-hidden m-2">${item.description}</div>
     <div class="align-self-center m-2 item-amount">${item.amount} шт.</div>
     <div class="align-self-center font-weight-bold m-2"><span class="price">${item.price}</span> руб.</div>
     <button type="button" value="${item.id}" class="btn bg-primary add_item align-self-center m-2">В корзину</button>
 </div>