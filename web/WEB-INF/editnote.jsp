<%-- 
    Document   : editnote
    Created on : Sep 28, 2022, 11:20:18 AM
    Author     : ety
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form method="post" action="note">
            Title: <input type="text" name="noteTitle" value="${note.noteTitle}">
            <br><br>
            <div>
            <span style="float: left">Contents: </span>
            <textarea name="noteContents" row="500" cols="50">${note.noteContents}</textarea>
            </div>
            <input type="submit" value="Save">
                     
        </form>
        
    </body>
</html>
