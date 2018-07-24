$(document).ready(function(){
    $(document).on('change', '.btn-file :file', function() {
        var input = $(this),label = input.val();
        input.trigger('fileselect', [label]);
    });

    $('.btn-file').on('fileselect', function(event, label) {
        var input = $(this).parents('.input-group').find(':text'),
            log = label;

        var pos = log.lastIndexOf("\\");
        log = '\\images' + log.substring(pos);
        if( input.length ) {
            input.val(log);
        }
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#img-upload').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgInp").change(function(){
        readURL(this);
    });

    // Удаление товара из админки
    $('.delete-item').click(function () {
        var pathToDelete = $(this).attr("value");
        window.location.replace("admin/delete/" + pathToDelete);
    });
});