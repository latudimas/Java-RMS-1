<%@ page language="java" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="rms" uri="/WEB-INF/tags/link.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>RMS</title>
    <meta name="description" content="Index">
    <meta name="author" content="Mitrais">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <rms:link type="stylesheet" href="css/styles.css?v=1.0"/>

    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
    <![endif]-->
</head>

<body>
<div class="demo-layout-transparent mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--transparent">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">RMS User List</span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation -->
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="users">Users</a>
                <a class="mdl-navigation__link" href="/rms-servlet-web/create">Add New</a>
                <a class="mdl-navigation__link" href="/rms-servlet-web">Home</a>
                <a class="mdl-navigation__link" href="">Link</a>
            </nav>
        </div>
    </header>
    <div class="mdl-layout mdl-js-layout box-center">
        <main class="mdl-layout__content">
            <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">User Name</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td class="mdl-data-table__cell--non-numeric"><c:out value="${user.userName}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/edit" method="get">
                                <input type="hidden" value="${user.id}" name="id">
                                <button type="submit" class="btn btn-warning">Update</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/delete" method="post">
                                <input type="hidden" value="${user.id}" name="id">
                                <button type="submit" class="btn btn-warning">Delete</button>
                            </form>

                                <%--                        <a href="/rms-servlet-web/edit?id=<c:out value="${user.id}"/>">Edit </a> &nbsp;&nbsp;&nbsp;&nbsp;--%>
                                <%--                        <a href="/rms-servlet-web/delete?id=<c:out value="${user.id}"/>">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</div>
<script src="js/scripts.js"></script>
</body>
</html>
