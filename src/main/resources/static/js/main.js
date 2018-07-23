$(document).ready(function () {
    // Открытие экрана в полный вид
    $('.card').click(function () {
        var parent = $(this).parent();
        $(parent).addClass("item-full-view d-flex justify-content-between w-100 m-2 bg-light rounded");
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

    // Счетчик товаров в корзине
    $('.add_item').click(function () {
        var item_count = $('#item_count').text();
        item_count++;
        $('#item_count').text(item_count);
        $('#item_count').removeClass('d-none');

        var itemId = $(this).attr("value");

        $.post("client/add/" + itemId);
    });

    $('#busket_button').click(function(){
        $.get( "client/busket", function(response) {
            $("#busket").html(response);
        });
    });

    // Удаление товара из корзины
    $("#busket_body").on("click", ".delete_item", function () {
        var item_count = $('#item_count').text();
        item_count--;
        if (item_count === 0) {
            $('#item_count').addClass('d-none');
        }
        $('#item_count').text(item_count);
        $(this).parents(".item-full-view").remove();
    });

    $("body").on('DOMSubtreeModified', "#busket_body", function () {
        var sum = 0;
        $("#busket_body").find(".price").each(function () {
            sum += Number($(this).text());
        });
        $("#sum").text(sum);
        // Случайный размер скидки
        $("#discount").text(DISCOUNT);

        $("#sum-discount").text($("#discount").text() * sum / 100);

        $("#sum-to-pay").text($("#sum").text() - $("#sum-discount").text());
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