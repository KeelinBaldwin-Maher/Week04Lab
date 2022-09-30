<%-- 
    Document   : viewnote
    Created on : Sep 28, 2022, 11:15:40 AM
    Author     : ety
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        
        <form method="post"  action="note">
            <b>Title: </b> <span>${note.noteTitle} </span>
            <br>
           
            <p>
                <b>Contents:</b> 
                <br>
                ${note.noteContents}
            </p>
            
             <a href="note?edit">Edit</a>
        </form>
        
    </body>
</html>
