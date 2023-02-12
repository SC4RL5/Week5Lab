<%-- 
    Document   : login
    Created on : 12-Feb-2023, 1:52:18 PM
    Author     : Swift
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="get">
           Username: <input type="text" name="username">
           Password: <input type="text" name="password">
           <input type="submit" value="Log in">
        </form>
    </body>
</html>
