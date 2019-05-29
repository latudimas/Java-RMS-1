<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimas_RL876
  Date: 5/10/2019
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <title>RMS</title>
    <meta name="description" content="Index">
    <meta name="author" content="Mitrais">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="css/styles.css?v=1.0">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
</head>

<body>
<div class="mdl-layout mdl-js-layout mdl-color--grey-100 box-center">
    <main class="mdl-layout__content">
        <div class="mdl-card mdl-shadow--6dp">
            <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                <h2 class="mdl-card__title-text">Update User Data</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <form action="edit" method="post">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                    <div class="mdl-textfield mdl-js-textfield">
                        Username: <input class="mdl-textfield__input" type="text" id="username" name="username"
                                         value="${user.userName}"/>
                        <label class="mdl-textfield__label" for="username"></label>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield">
                        Password: <input class="mdl-textfield__input" type="password" id="userpass" name="userpass"/>
                        <label class="mdl-textfield__label" for="userpass"></label>
                    </div>
                    <div class="mdl-card__actions">
                        <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
</body>
</html>
