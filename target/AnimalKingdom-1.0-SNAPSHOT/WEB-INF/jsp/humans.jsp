<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${getName}</title>
        <link href="<c:url value='resources/style.css' />" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
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
                                <button class="btn btn-primary dropdown-toggle pull-left" style="margin-right: 6px; min-width: 80px;" type="button" data-toggle="dropdown"><i class="fa fa-filter"></i> Human
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="home?species=All">All Species</a></li>
                                    <li><a href="humans">Human</a></li>
                                    <li><a href="home?species=Parrot">Parrot</a></li>
                                    <li><a href="home?species=Pinguin">Pinguin</a></li>
                                    <li><a href="home?species=AfricanElephant">African Elephant</a></li>
                                    <li><a href="home?species=AsianElephant">Asian Elephant</a></li>
                                    <li><a href="home?species=GrayMouse">Gray Mouse</a></li>
                                    <li><a href="home?species=WhiteMouse">White Mouse</a></li>
                                    <li><a href="home?species=Snake">Snake</a></li>
                                    <li><a href="home?species=Crocodile">Crocodile</a></li>
                                </ul>
                            </div>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#addAnimal"><i class="fa fa-plus"></i> Add Animal</button>
                            <button class="btn btn-primary"  data-toggle="modal" data-target="#options"><i class="fa fa-cogs"></i> Options</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">

                <table class="table table-bordered noselect" id="selection1">
                    <tr class="theader">
                        <th>Species</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Color</th>
                        <th>Partner</th>
                        <th  style="width: 130px;">Options</th>
                    </tr>
                    <c:forEach items="${tableHuman}" var="listItem">
                        <tr  data-uuid="${listItem.getID()}">
                            <td>${listItem.getClass().getSimpleName()}</td>
                            <td>${listItem.getName()} ${listItem.getLastName()}</td>
                            <td>${listItem.getGender().getClass().getSimpleName()}</td>
                            <td width="10px"><div class="foo" style="background-color: ${listItem.getColor()}"></div></td>
                            <td>${listItem.getPartnerName()} ${listItem.getPartner().getLastName()}</td>
                            <td>
                                <form action="delete">
                                    <button type="button" class="btn btn-sm" data-toggle="modal" data-target="#${listItem.getID()}"> <i class="fa fa-cog"></i></button>
                                    <button type="button" class="btn btn-warning btn-sm " data-toggle="modal" data-target="#${listItem.getID()}2"> <i class="fa fa-pencil"></i></button>
                                    <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                    <button type="submit" class="btn btn-danger btn-sm disabled"><i class="fa fa-trash"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${empty tableHuman}">
                    <h5 style="text-align: center;">No humans found...</h5>
                    <br>
                </c:if>

                <table class="table table-bordered noselect" id="selection2">
                    <tr class="theader">
                        <th>Species</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Color</th>
                        <th>Partner</th>
                        <th style="width: 130px;">Options</th>
                    </tr>
                    <c:forEach items="${tableHuman}" var="listItem">
                        <tr data-uuid="${listItem.getID()}">
                            <td>${listItem.getClass().getSimpleName()}</td>
                            <td>${listItem.getName()} ${listItem.getLastName()}</td>
                            <td>${listItem.getGender().getClass().getSimpleName()}</td>
                            <td width="10px"><div class="foo" style="background-color: ${listItem.getColor()}"></div></td>
                            <td>${listItem.getPartnerName()} ${listItem.getPartner().getLastName()}</td>
                            <td>
                                <form action="delete">
                                    <button type="button" class="btn btn-sm" data-toggle="modal" data-target="#${listItem.getID()}"> <i class="fa fa-cog"></i></button>
                                    <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#${listItem.getID()}2"> <i class="fa fa-pencil"></i></button>
                                    <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                    <button type="submit" class="btn btn-danger btn-sm disabled"><i class="fa fa-trash"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${empty tableHuman}">
                    <h5 style="text-align: center">No humans found...</h5>
                </c:if>

                <a class="btn btn-primary" id="makeloveBtn"><i class="fa fa-bed"></i> Propagate</a>
                <a class="btn btn-primary" id="maryBtn"><i class="fa fa-heart"></i> Mary</a>
            </div>

            <!-- Modals -->

            <c:forEach items="${tableHuman}" var="listItem">
                <div id="${listItem.getID()}" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">${listItem.getName()} ${listItem.getLastName()}</h4>
                            </div>
                            <div class="modal-body">
                                <p><b>Name:</b> ${listItem.getName()}</p>
                                <p><b>Last Name:</b> ${listItem.getLastName()}</p>
                                <p><b>Color:</b> ${listItem.getColor()}</p>
                                <p><b>Weight:</b> ${listItem.getWeight()}</p>
                                <p><b>Gender:</b> ${listItem.getGender().getClass().getSimpleName()}</p>
                                <p><b>Partner:</b> ${listItem.getPartnerName()} ${listItem.getPartner().getLastName()}</p>
                                <p><b>Birthcontrol:</b> ${listItem.isUsesBirthControl()}</p>
                                <p><b>STD:</b> ${listItem.getsexualTransmitedDisease()}</p>
                                <c:if test="${listItem.isFemale()}">
                                    <p><b>Pregnant:</b> ${listItem.isPregnant()}</p>
                                </c:if>
                            </div>
                            <div class="modal-footer">
                                <c:if test="${listItem.isPregnant()}">
                                    <form action="giveBirth">
                                        <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                        <button type="submit" style="margin-right: 5px;" class="btn btn-primary pull-left"><i class="fa fa-child"></i> Give Birth</button>
                                    </form>
                                </c:if>
                                <c:if test ="${listItem.isMarried()}">
                                    <form action="divorce">
                                        <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                        <button type="submit" class="btn btn-primary pull-left" style="margin-right: 5px;">Divorce</button>
                                    </form>
                                </c:if>
                                <c:if test = "${listItem.isFemale() && listItem.getGender().ovThread.isAlive()}">
                                    <form action="thread">
                                        <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                        <button type="submit" class="btn btn-primary pull-left"><i class="fa fa-stop"></i> Stop Thread</button>
                                    </form>
                                </c:if>
                                <c:if test="${listItem.isFemale() && listItem.getGender().ovThread.isAlive() == false}">
                                    <form action="thread">
                                        <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">
                                        <button type="submit" class="btn btn-primary pull-left"><i class="fa fa-play"></i> Start Thread</button>
                                    </form>
                                </c:if>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-check"></i> Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <c:forEach items="${tableHuman}" var="listItem">
                <div id="${listItem.getID()}2" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Edit ${listItem.getName()}</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form" action="edit">

                                    <input type="text" class="hide" id="thisAnimal" name="thisAnimal" value="${listItem.getID()}">

                                    <div class="form-group">
                                        <label for="name">Name:</label>
                                        <input type="text" required="true" class="form-control" id="name" name="name" value="${listItem.getName()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last Name:</label>
                                        <input type="text" required="false" class="form-control" id="lastName" name="lastName" value="${listItem.getLastName()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="bodycovering">Bodycovering:</label>
                                        <select id="bodycovering" name="bodycovering" class="form-control">
                                            <option value="Skin">Skin</option>
                                            <option value="Hair">Hair</option>
                                            <option value="Fur">Fur</option>
                                            <option value="Scales">Scales</option>
                                            <option value="Feather">Feather</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="color">Color:</label>
                                        <br>
                                        <input class="form-control" type="color" name="color" id="color" value="${listItem.getColor()}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="weight">Weight:</label>
                                        <input type="float" required="true" min="0" class="form-control" id="weight" name="weight" value="${listItem.getWeight()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="bcontrol">Birthcontrol:</label>
                                        <select id="bcontrol" name="bcontrol" class="form-control">
                                            <option value="true">True</option>
                                            <option value="false">False</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Save</button>
                                    <button type="button" class="btn btn-default pull-right" data-dismiss="modal"><i class="fa fa-check"></i> Close</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

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
                                    <input type="color"  class="form-control" id="color" name="color" value="#00a4a4" />
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

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="resources/javascript.js"></script>

</html>
