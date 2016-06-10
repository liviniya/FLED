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
                $("#input_image").attr("src", "input_image?" + Math.floor(Math.random() * 1000));
            },
            error: function (xhr, status, error) {
                alert('xhr = ' + xhr + ', status = ' + status + ', error = ' + error);
            }            
        });        
    });
    
    $('#remove_image_link').click(function () {
        $("#input_image").attr("src", "images/background.jpg");
    });
    
    $('#calculate_button').click(function () {
        $("#output_image").attr("src", "output_image?" + Math.floor(Math.random() * 1000));
        $("#sobel_image").attr("src", "sobel_image?" + Math.floor(Math.random() * 1000));
    });
    
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
                        "x": 43,
                        "y": 1
                    },
                    {
                        "x": 117,
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
                        "x": 87,
                        "y": 0
                    },
                    {
                        "x": 205,
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
                        "x": 10,
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

});

    
