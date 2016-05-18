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
        <link rel="stylesheet" type="text/css" href="resources/css/site.css" />
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="resources/js/js.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>My First Fuzzy logic based edge detection Page</h1>
            <p>This is some text (just for example)</p> 
        </div>
        <form method="post" enctype="multipart/form-data" action="upload">
            Choose image to process: <input type="file" name="file"> <br>
            <input type="submit" value="Process this image!">
        </form>
    </body>
</html>
