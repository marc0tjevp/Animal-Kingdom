$(document).ready(function () {

    $('tr').not('.theader').on('click', function () {
        $(this).toggleClass('highlight').siblings().removeClass('highlight');
    });

    $('#propBtn').on('click', function (event) {
        event.preventDefault();
        var formData = {
            "selection1": $('#selection1 tr.highlight').data('uuid'),
            "selection2": $('#selection2 tr.highlight').data('uuid')
        };
        $.ajax({
            url: "prop",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData), //Stringified Json Object
            async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false, //This will force requested pages not to be cached by the browser          
            processData: false, //To avoid making query String instead of JSON
            success: function (json) {
                if (!json.error)
                    location.reload(true);
            }
        });
    });

    $('#maryBtn').on('click', function (event) {
        event.preventDefault();
        var formData = {
            "selection1m": $('#selection1 tr.highlight').data('uuid'),
            "selection2m": $('#selection2 tr.highlight').data('uuid')
        }
        $.ajax({
            url: "mary",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData), //Stringified Json Object
            async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false, //This will force requested pages not to be cached by the browser          
            processData: false, //To avoid making query String instead of JSON
            success: function (json) {
                if (!json.error)
                    location.reload(true);
            }});
    });

    $('#makeloveBtn').on('click', function (event) {
        event.preventDefault();
        var formData = {
            "selection1ml": $('#selection1 tr.highlight').data('uuid'),
            "selection2ml": $('#selection2 tr.highlight').data('uuid')
        };
        $.ajax({
            url: "makelove",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData), //Stringified Json Object
            async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false, //This will force requested pages not to be cached by the browser          
            processData: false, //To avoid making query String instead of JSON
            success: function (json) {
                if (!json.error)
                    location.reload(true);
            }});

        $("#preferredHex").spectrum({
            preferredFormat: "hex",
            showInput: true,
            showPalette: true,
            palette: [["red", "rgba(0, 255, 0, .5)", "rgb(0, 0, 255)"]]
        });
    });
});