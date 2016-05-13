<%-- 
    Document   : result
    Created on : May 13, 2016, 1:58:42 PM
    Author     : Oksana_Moroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>inputPath: ${inputPath}</h2>
        <h2>outputPath: ${outputPath}</h2>
        <img src="D:\images\input.jpg" width="200" height="200"> <br>
        <img src="${outputPath}">
    </body>
</html>
