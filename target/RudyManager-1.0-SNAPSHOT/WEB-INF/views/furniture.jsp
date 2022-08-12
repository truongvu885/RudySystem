<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
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
</nav>
<table class="table" style="width: 700px; margin: auto;" >
    <thead>
    <tr>
        <th colspan="4">List furniture data</th>
        <th colspan="4">
            <form action="<c:url value="/furniture/search"/>">
                <input type="text" name="in_search" class="form-control" placeholder="Search by id" style="display: inline;width: 70%;padding: 0;">
                <input type="submit" value="Search" class="btn btn-info">
            </form>
        </th>
    </tr>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Issue Date</th>
        <th scope="col">Author</th>
        <th scope="col">Mass</th>
        <th scope="col">Material</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="item" >
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.issueDate}</td>
                <td>${item.author}</td>
                <td>${item.mass}</td>
                <td>${item.material}</td>
                <td>${item.price}</td>
            </tr>
        </c:forEach>
    </c:if>
   <c:if test="${not empty furniture}">
       <tr>
           <td>${furniture.id}</td>
           <td>${furniture.name}</td>
           <td>${furniture.issueDate}</td>
           <td>${furniture.author}</td>
           <td>${furniture.mass}</td>
           <td>${furniture.material}</td>
           <td>${furniture.price}</td>
       </tr>
   </c:if>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>