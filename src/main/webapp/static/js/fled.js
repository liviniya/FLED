/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {   

    $("#spinner_white_start, #spinner_white_end, #spinner_black_start, #spinner_black_end, #spinner_edge_end").spinner({
        min: 0,
        max: 255
    });
    
    var black_start_global = $('#spinner_black_start').spinner("value");
    var black_end_global = $('#spinner_black_end').spinner("value");
    var white_start_global = $('#spinner_white_start').spinner("value");
    var white_end_global = $('#spinner_white_end').spinner("value");
    var edge_end_global = $('#spinner_edge_end').spinner("value");
    
    $("#spinner_white_start, #spinner_white_end, #spinner_black_start, #spinner_black_end").on("spinchange", function (event, ui) {
        black_start = $('#spinner_black_start').spinner("value");
        black_end = $('#spinner_black_end').spinner("value");
        white_start = $('#spinner_white_start').spinner("value");
        white_end = $('#spinner_white_end').spinner("value");
        if (check_pixel_value(black_start) && check_pixel_value(black_end)
                && check_pixel_value(white_start) && check_pixel_value(white_end)
                && (black_start < black_end) && (white_start < white_end)) {
            black_start_global = black_start;
            black_end_global = black_end;
            white_start_global = white_start;
            white_end_global = white_end;
            redraw_black_white_mf(black_start_global, black_end_global, white_start_global, white_end_global);
            $.ajax({
                url: 'change_black_white_mf',
                type: 'POST',
                data: {
                    'black_start': black_start_global,
                    'black_end': black_end_global,
                    'white_start': white_start_global,
                    'white_end': white_end_global
                },
                success: function (data) {
                    redraw_fuzzy_output_image();
                },
                error: function (xhr, status, error) {
                    alert('xhr = ' + xhr + ', status = ' + status + ', error = ' + error);
                }
            });
        } else {
            $('#spinner_black_start').spinner("value", black_start_global);
            $('#spinner_black_end').spinner("value", black_end_global);
            $('#spinner_white_start').spinner("value", white_start_global);
            $('#spinner_white_end').spinner("value", white_end_global);
        }
    });
    
    $('#spinner_edge_end').on("spinchange", function (event, ui) {
        edge_end = $('#spinner_edge_end').spinner("value");
        if (check_pixel_value(edge_end)) {
            edge_end_global = edge_end;
            redraw_edge_mf(edge_end_global);
            $.ajax({
                url: 'change_edge_mf',
                type: 'POST',
                data: {
                    'edge_end': edge_end_global
                },
                success: function (data) {
                    redraw_fuzzy_output_image();
                },
                error: function (xhr, status, error) {
                    alert('xhr = ' + xhr + ', status = ' + status + ', error = ' + error);
                }
            });
        } else {
            $('#spinner_edge_end').spinner("value", edge_end_global);
        }
    });
    
    $('#upload_image_link').click(function () {
        var formData = new FormData();
        formData.append('file', $('#file')[0].files[0]);

        $.ajax({
            url: 'upload',
            type: 'POST',
            data: formData,
            enctype: 'multipart/form-data',
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                $('#see_comparison').removeClass('disabled');
                redraw_fuzzy_output_image();                
            },
            error: function (xhr, status, error) {
                alert('xhr = ' + xhr + ', status = ' + status + ', error = ' + error);
            }            
        });        
    });    
    
    $('#remove_image_link, #change_image_link').click(function () {
        $("#fuzzy_output").attr("src", "images/background.jpg");
        $('#see_comparison').addClass('disabled');
    });
    
    redraw_black_white_mf(black_start_global, black_end_global, white_start_global, white_end_global);
    redraw_edge_mf(edge_end_global);
    
    function redraw_fuzzy_output_image() {
        if ($("#see_comparison").hasClass('disabled')) {
            $("#fuzzy_output").attr("src", "images/background.jpg");
        } else {
            $("#fuzzy_output").attr("src", "fuzzy_output?" + Math.floor(Math.random() * 1000));
        }
    }
    
    function check_pixel_value(pixel) {
        if (pixel === null || pixel < 0 || pixel > 255) {
            return false;
        }
        return true;
    }
    
    function redraw_black_white_mf(black_start, black_end, white_start, white_end) {
        var data_black_white_mf = {
            "xScale": "linear",
            "yScale": "linear",
            "xMin": 0,
            "xMax": 255,
            "yMin": 0,
            "yMax": 1.1,
            "type": "line-dotted",
            "main": [
                {
                    "className": ".black_mf",
                    "data": [
                        {
                            "x": 0,
                            "y": 1
                        },
                        {
                            "x": black_start,
                            "y": 1
                        },
                        {
                            "x": black_end,
                            "y": 0
                        },
                        {
                            "x": 255,
                            "y": 0
                        }
                    ]
                }
            ],
            "comp": [
                {
                    "className": ".white_mf",
                    "type": "line-dotted",
                    "data": [
                        {
                            "x": 0,
                            "y": 0
                        },
                        {
                            "x": white_start,
                            "y": 0
                        },
                        {
                            "x": white_end,
                            "y": 1
                        },
                        {
                            "x": 255,
                            "y": 1
                        }
                    ]
                }
            ]
        };
        var black_white_mf = new xChart('bar', data_black_white_mf, '#black_white_mf');
    }
    
    function redraw_edge_mf(edge_end) {
        var data_edge_mf = {
            "xScale": "linear",
            "yScale": "linear",
            "xMin": 0,
            "xMax": 255,
            "yMin": 0,
            "yMax": 1.1,
            "type": "line-dotted",
            "main": [
                {
                    "className": ".black_mf",
                    "data": [
                        {
                            "x": 0,
                            "y": 1
                        },
                        {
                            "x": edge_end,
                            "y": 0
                        },
                        {
                            "x": 255,
                            "y": 0
                        }
                    ]
                }
            ]
        };
        var edge_mf = new xChart('bar', data_edge_mf, '#edge_mf');
    }

});

    
