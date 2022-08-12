<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truon
  Date: 8/12/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Video</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width: 700px; margin: auto;" >
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/home"/>">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Manager
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="<c:url value="/video"/>">Video</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/book-tape"/>">Book on tape</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/furniture"/>">Furniture</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Rent manager</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/rent"/>">Rent</a>
                </li>
            </ul>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
            <strong>${message}</strong>
        </div>
    </c:if>
</nav>
<div class="" style="width: 700px; margin: auto;">
    <form action="<c:url value="/rent/video"/>" class="child" method="post" >
        <div >
            <label>Choice video</label>
            <select class="form-select" aria-label="Default select example" name="id">
                <option selected>Select your video choice</option>
                <c:forEach items="${videoList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            <label>Choice number of rental days  </label>
            <input type="number" style="width: 100px;margin: auto" value="0" name="numberDate">
            <input type="submit" value="Register" style="float: right" class="btn btn-info">
        </div>
    </form>
        <br>
        <br>
        <br>
    <form action="" class="child" method="post">
        <div>
            <label>Choice Book on tape</label>
            <select class="form-select" aria-label="Default select example" name="id">
                <option selected>Open this select menu</option>
                <c:forEach items="${bookList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            <label>Choice number of rental days  </label>
            <input type="number" style="width: 100px;margin: auto" value="0" name="numberDate">
            <input type="submit" value="Register" style="float: right" class="btn btn-info">
        </div>
    </form>
    <br>
    <br>
    <br>
    <form action="" class="child" method="post">
        <div >
            <label>Choice Furniture</label>
            <select class="form-select" aria-label="Default select example">
                <option selected>Open this select menu</option>
                <c:forEach items="${furnitureList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            <label>Choice number of rental days  </label>
            <input type="number" style="width: 100px;margin: auto" value="0" name="numberDate">
            <input type="submit" value="Register" style="float: right" class="btn btn-info">
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>