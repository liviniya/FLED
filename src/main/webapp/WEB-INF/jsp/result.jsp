<%-- 
    Document   : result
    Created on : 11.06.2016, 12:34:25
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuzzy logic based edge detection</title>        

        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap.js"></script> 
        <script src="js/jasny-bootstrap.js"></script> 
        <script src="js/d3.js" charset="utf-8"></script>
        <script src="js/xcharts.js"></script>        

        <script src="js/fled.js"></script>

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/jasny-bootstrap.css">
        <link rel="stylesheet" href="css/xcharts.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/spinner.css">

        <link rel="stylesheet" type="text/css" href="css/site.css" />
    </head>
    <body>  
        <div class="container-fluid">            
            <div class="row">
                <div class="col-sm-4">
                    <h5>Input grayscale image:</h5>                    
                    <img id="input_image_result" class="img-responsive" src="grayscale_output" alt="Input grayscale image" style="max-height: 800px">
                </div>
                <div class="col-sm-4">
                    <h5>Fuzzy output image:</h5>                    
                    <img id="fuzzy_result" class="img-responsive" src="fuzzy_output" alt="Fuzzy output image" style="max-height: 800px">
                </div>
                <div class="col-sm-4">
                    <h5>Sobel operator output image:</h5>                    
                    <img id="sobel_result" class="img-responsive" src="sobel_output" alt="Sobel operator output image" style="max-height: 800px">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <a type="button" class="btn btn-default btn-lg btn-block btn-huge" href="index">Come to back</a>
                </div> 
            </div>
        </div>        
    </body>
</html>
