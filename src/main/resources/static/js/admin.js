$(document).ready(function(){
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#img-upload').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

     $('#addItem, #editItem').on('change', '.btn-file :file', function() {
        var input = $(this),label = input.val();
        input.trigger('fileselect', [label]);
     });

    $('#addItem, #editItem').on('fileselect', '.btn-file', function(event, label) {
        var input = $(this).parents('.input-group').find(':text'),
            log = label;

        var pos = log.lastIndexOf("\\");
        log = '\\images' + log.substring(pos);
        if( input.length ) {
            input.val(log);
        }
    });


    $('#addItem, #editItem').on('change', "#imgInp", function() {
        readURL(this);
    });

    // Открытие страницы добавления товара
    $("#button_add_item").click(function(){
        $.get( "admin/add", function(response) {
            $("#addItem").html(response);
        });
    });

    // Удаление товара из админки
    $('.delete-item').click(function () {
        var pathToDelete = $(this).attr("value");
        window.location.replace("admin/delete/" + pathToDelete);
    });

    // Редактирование товара из админки
    $('.edit-item').click(function () {
        var pathToEdit = $(this).attr("value");
        $.get( "admin/edit/" + pathToEdit, function(response) {
            $("#editItem").html(response);
        });
        //window.location.replace("admin/edit/" + pathToEdit);
    });
});