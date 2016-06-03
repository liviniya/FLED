<%-- 
    Document   : index
    Created on : May 10, 2016, 3:11:16 PM
    Author     : Oksana_Moroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring 4 Web MVC via Annotations</title>        
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/css/jasny-bootstrap.css">
        
        <link rel="stylesheet" type="text/css" href="css/site.css" />
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/js/jasny-bootstrap.js"></script>        
        
        <script src="js/fled.js"></script>
    </head>
    <body>  

        <div class="container-fluid">            
            <div class="row">
                <div class="col-sm-3">
                    <h5>Select an image to process:</h5>
                    <div class="fileinput fileinput-new input-group" data-provides="fileinput">
                        <div class="form-control" data-trigger="fileinput"><i class="glyphicon glyphicon-file fileinput-exists"></i> <span class="fileinput-filename"></span></div>
                        <span class="input-group-addon btn btn-default btn-file"><span class="fileinput-new">Select file</span><span class="fileinput-exists">Change</span><input type="file" name="file" id="file"></span>
                        <a href="#" id="remove_image_link" class="input-group-addon btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                        <a href="#" id="upload_image_link" class="input-group-addon btn btn-default fileinput-exists" >Upload</a>
                    </div>
                    <img id="input_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 300px">
                </div>
                <div class="col-sm-9">
                    <h5>Select appropriate characteristics and click the button:</h5>
                    <button id="calculate_button" type="button" class="btn btn-default btn-lg btn-block btn-huge">Calculate</button>
                </div>
            </div>
            <div class="row">
                <h5>Results of program</h5>
                <div class="col-sm-3">
                    Fuzzy output:
                    <img id="output_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 300px">
                </div>
                <div class="col-sm-3">
                    Sobel operator output:
                    <img id="sobel_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 300px">
                </div>
            </div>
        </div>

    </body>
</html>
