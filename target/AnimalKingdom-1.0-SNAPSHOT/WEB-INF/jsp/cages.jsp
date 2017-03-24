<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${getName}</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <link href="resources/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-test" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand " href="home?species=All">${getName}</a>
            </div>            
            <div class="collapse navbar-collapse" id="navbar-test">
                <ul class="nav navbar-nav">
                    <li><a href="home?species=All">Animals</a></li>
                    <li class="active"><a href="cages">Cages</a></li>
                    <li><a href="propagate">Propagate</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <table class="table table-hover table-bordered noselect" id="table">
                    <tr class="theader">
                        <th>Cagetype</th>
                        <th>Size</th>
                    </tr>
                    <c:forEach items="${getCages}" var="listItem">
                        <tr>
                            <td>${listItem.getCageType()}</td>
                            <td>${listItem.getAnimal().size()} Animals</td>
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${empty getCages}">
                    <h5 style="text-align: center">There aren't any cages</h5>
                </c:if>
            </div>
        </div>
    </body>
</html>
