<%-- 
    Document   : result
    Created on : May 13, 2016, 1:58:42 PM
    Author     : Oksana_Moroz
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>      
    </head>
    <body>  
        <table>
            <tr>
                <th colspan="3"><h1>Result of fuzzy logic based edge detection</h1></th>
            </tr>
            <tr>
                <th>Input image</th>
                <th>Fuzzy output image</th>
                <th>Sobel output image</th>
            </tr>
            <tr>
                <td><img src="input_image" width="100%"></td>
                <td><img src="output_image" width="100%"></td>
                <td><img src="sobel_image" width="100%"></td>
            </tr>
            <tr>
                <th colspan="3"><a href="index">Come to back</a></th>
            </tr>
        </table>       
    </body>
</html>
