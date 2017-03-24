<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${getName}</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link href="resources/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.css">
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
                    <li class="active"><a href="home?species=All">Animals</a></li>
                    <li><a href="cages">Cages</a></li>
                    <li><a href="propagate">Propagate</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="col-md-7 col-xs-12">
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle pull-left" style="margin-right: 6px; min-width: 80px;" type="button" data-toggle="dropdown"><i class="fa fa-filter"></i> ${param['species']}
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="?species=All">All Species</a></li>
                                    <li><a href="humans">Human</a></li>
                                    <li><a href="?species=Parrot">Parrot</a></li>
                                    <li><a href="?species=Pinguin">Pinguin</a></li>
                                    <li><a href="?species=AfricanElephant">African Elephant</a></li>
                                    <li><a href="?species=AsianElephant">Asian Elephant</a></li>
                                    <li><a href="?species=GrayMouse">Gray Mouse</a></li>
                                    <li><a href="?species=WhiteMouse">White Mouse</a></li>
                                    <li><a href="?species=Snake">Snake</a></li>
                                    <li><a href="?species=Crocodile">Crocodile</a></li>
                                </ul>
                            </div>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#addAnimal"><i class="fa fa-plus"></i> Add Animal</button>
                            <button class="btn btn-primary"  data-toggle="modal" data-target="#options"><i class="fa fa-cogs"></i> Options</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <table class="table table-bordered noselect" id="table">
                    <tr class="theader">
                        <th>Species</th>
                        <th>Name</th>
                        <th>Body Covering</th>
                        <th>Color</th>
                        <th>Weight</th>
                        <th>Gender</th>
                    </tr>
                    <c:forEach items="${table}" var="listItem">
                        <tr>
                            <td>${listItem.getClass().getSimpleName()}</td>
                            <td>${listItem.getName()}</td>
                            <td>${listItem.getBodyCovering()}</td>
                            <td width="10px"><div class="foo" style="background-color: ${listItem.getColor()}"></div></td>
                            <td>${listItem.getWeight()}</td>
                            <td>${listItem.getGender().getClass().getSimpleName()}</td>
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${empty table}">
                    <h5 style="text-align: center">No animals</h5>
                </c:if>
            </div>

            <!--Modals-->

            <div id="options" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Zoo Options</h4>
                        </div>
                        <div class="modal-body">
                            <form action="change" method="post">
                                <div class="form-group">
                                    <label for="newName">Name:</label>
                                    <input type="text" maxlength="55" class="form-control" id="newName" name="newName" value="${getName}">
                                </div>
                                <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Save</button>
                                <button type="button" class="btn btn-default pull-right" data-dismiss="modal"><i class="fa fa-check"></i> Close</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div id="addAnimal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Add Animal</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form" action="add" role="form">
                                <div class="form-group">
                                    <input type="text" required="true" class="form-control" id="name" name="name" placeholder="Name...">
                                </div>
                                <div class="form-group">
                                    <input type="text" required="false" class="form-control" id="lastName" name="lastName" placeholder="Last Name...">
                                </div>
                                <div class="form-group">
                                    <input type="float" required="true" min="0" class="form-control" id="weight" name="weight" placeholder="Weight...">
                                </div>
                                <div class="form-group">
                                    <input type="color" class="form-control" id="color" name="color" value="#00a4a4" />
                                </div>
                                <div class="form-group">
                                    <select id="bodycovering" name="bodycovering" placeholder="Bodycovering...." class="form-control">
                                        <option value="Skin">Skin</option>
                                        <option value="Hair">Hair</option>
                                        <option value="Fur">Fur</option>
                                        <option value="Scales">Scales</option>
                                        <option value="Feather">Feather</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select id="gender" name="gender" class="form-control">
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <select id="species" name="species" class="form-control">
                                        <option value="Human">Human</option>
                                        <option value="Pinguin">Pinguin</option>
                                        <option value="Parrot">Parrot</option>
                                        <option value="AfricanElephant">African Elephant</option>
                                        <option value="AsianElephant">Asian Elephant</option>
                                        <option value="GrayMouse">Gray Mouse</option>
                                        <option value="WhiteMouse">White Mouse</option>
                                        <option value="Crocodile">Crocodile</option>
                                        <option value="Snake">Snake</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary"><i class="fa fa-plus"></i> Create</button>
                                <button type="button" class="btn btn-default pull-right" data-dismiss="modal"><i class="fa fa-check"></i> Close</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="resources/javascript.js"></script>

</html>
