$(document).ready(function () {
    // Открытие экрана в полный вид
    $('.container-fluid').on('click', '.card', function(){
        var parent = $(this).parent();
        $(parent).addClass("open-item item-full-view d-flex justify-content-between w-100 m-2 bg-light rounded");

        var str = parent.attr("id");
        str = str.substring(4);
        $.get( "client/full-view-after-adding-item/" + str, function(response) {
            $(".open-item").html(response);
        });

        $(this).removeClass('m-2');
        $(this).siblings().removeClass("d-none");
        $(this).siblings().addClass("d-flex");
        $('.container-fluid .card').not(this).addClass('m-2');
        $('.container-fluid .card').not(this).siblings().removeClass("d-flex");
        $('.container-fluid .card').not(this).siblings().addClass("d-none");
        $('.container-fluid .card').not(this).parent().removeClass();

        // Устанавливаем значение scrollTop для отображения товара по центру
        var half_window = $(window).height() / 2;
        var half_this = $(this).height() / 2;
        var target_top = $(this).offset().top - half_window + half_this;

        $('html').animate({ scrollTop: target_top }, 0);
    });

    // Добавление товаров в корзину
    $('.container-fluid').on('click', '.add_item', function(){
        var item_count = $('#item_count').text();
        var str = $(this).siblings(".item-amount").text();
        var amount = Number(str.substring(0, str.length - 3));
        if(amount !== 0){
            item_count++;
            $('#item_count').text(item_count);
            $('#item_count').removeClass('d-none');
        }

        var itemId = $(this).attr("value");

        $.post("client/add/" + itemId).always(function(){
            $.get( "client/full-view-after-adding-item/" + itemId, function(response) {
                $(".open-item").html(response);
            });
        });
    });

    $('.d-flex').on('click', '#basket_button', function(){
        var parent = $(".open-item");
        parent.children().last().removeClass("d-flex");
        parent.children().last().addClass("d-none");
        parent.children().first().addClass("m-2");
        parent.removeClass();
        $.get( "client/basket", function(response) {
            $("#basket").html(response);
        });
    });

    // Удаление товара из корзины
    $('#basket').on('click', '.delete_item', function(){
        var item_count = $('#item_count').text();
        var str = $(this).siblings(".basket-amount").text();
        var amount = Number(str.substring(0, str.length - 3));
        item_count = item_count - amount;
        if (item_count === 0) {
            $('#item_count').addClass('d-none');
        }
        $('#item_count').text(item_count);

         var basketId = $(this).attr("value");
         var itemId = $(this).attr("value2");
         $.post( "client/delete/" + basketId).always(function(){
            // Получаем обновленное количество товара
            $.get( "client/updateItem?item=" + itemId, function(response) {
                $("#item" + itemId).html(response);
            });
            // Получаем обновленную корзину
            $.get( "client/basket", function(response) {
                $("#basket").html(response);
            });
         });
    });

    $(".item-amount").each(function(index,element){
        var str = element.textContent;
        var amount = Number(str.substring(0, str.length - 3));
        if(amount === 0){
            $(this).siblings(".add_item").prop( "disabled", true );
        }
    });

    // Сброс содержимого поиска
    $("button[data-toggle='modal']").click(function () {
        $("#search_text").val("");
        $("#search_footer").html("");
    });


    // Поиск
    $("#button_search").click(function () {
        var value = $("#search_text").val().toLowerCase();
        var htmls = $('.container-fluid .card').map(function () {
            if (($(this).text().toLowerCase().indexOf(value) > -1) && (value !== "")) {
                return $(this).prop('outerHTML');
            }
        }).get();
        $("#search_footer").html("");
        $("#search_footer").append(htmls);
        return false;
    });

    $("#order_items").click(function () {
        return false;
    });
});