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
                    <h5>Select an image to process:</h5>
                    <div class="fileinput fileinput-new input-group" data-provides="fileinput">
                        <div class="form-control" data-trigger="fileinput"><i class="glyphicon glyphicon-file fileinput-exists"></i> <span class="fileinput-filename"></span></div>
                        <span id="change_image_link" class="input-group-addon btn btn-default btn-file"><span class="fileinput-new">Select file</span>
                            <span class="fileinput-exists">Change</span>
                            <input type="file" name="file" id="file">
                        </span>
                        <a href="#" id="remove_image_link" class="input-group-addon btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                        <a href="#" id="upload_image_link" class="input-group-addon btn btn-default fileinput-exists" >Upload</a>
                    </div>
                    <img id="input_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 600px">
                </div>
                <div class="col-sm-8">
                    <h5>Select appropriate characteristics and click the button:</h5>
                    <div class="row">
                        <div class="col-sm-12">                            
                            <div class="row" align="center">
                                White:
                                <input id="spinner_white_start" value="87">
                                <input id="spinner_white_end" value="205">
                            </div>                            
                            <div class="row" align="center">
                                Black:
                                <input id="spinner_black_start" value="43">
                                <input id="spinner_black_end" value="117">
                            </div>                            
                            <div class="row" align="center">
                                Edge:
                                <input id="spinner_edge_end" value="10">
                            </div>                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <figure style="width: 500px; height: 400px;" id="black_white_mf"></figure>
                        </div>

                        <div class="col-sm-6">
                            <figure style="width: 500px; height: 400px;" id="edge_mf"></figure>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <button id="calculate_button" type="button" class="btn btn-default btn-lg btn-block btn-huge" disabled="disabled">Calculate</button>
                        </div>    
                    </div>

                </div>
            </div>
            <!--            <div class="row">
                            <h5>Results of program</h5>
                            <div class="col-sm-4">
                                Fuzzy output:
                                <img id="output_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 500px">
                            </div>
                            <div class="col-sm-4">
                                Sobel operator output:
                                <img id="sobel_image" class="img-responsive" src="images/background.jpg" alt="Input image" style="max-height: 500px">
                            </div>
                        </div>-->
        </div>        
    </body>
</html>
