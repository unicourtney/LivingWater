
$(document).ready(function () {
    $('#example').DataTable();
});

$().ready(function () {

    $('#clicker').click(function () {
        $('input').each(function () {
            $(this).removeAttr('disabled');
        });
        $('select').each(function () {
            $(this).removeAttr('disabled');
        });
    });

    $('#hide').click(function () {
        $('input').each(function () {
            $(this).prop('disabled', true);
        });
        $('select').each(function () {
            $(this).prop('disabled', true);
        });
    });
});

$(document).ready(function () {
    $("#hide").click(function () {
        $(".btn-success").hide();
        $(".toHideBtn").hide();
    });
    $(".showBtn").click(function () {
        $(".btn-success").show();
        $(".toHideBtn").show();
    });
});
