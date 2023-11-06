<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Product List</h2>
    <hr>
    <div class="row mb-3">
        <div class="col-1 font-weight-bold">#</div>
        <div class="col-3 font-weight-bold">Product Code</div>
        <div class="col-4 font-weight-bold">Product Name</div>
        <div class="col-1 font-weight-bold">Product Scale</div>
        <div class="col-2 font-weight-bold text-right">Price</div>
    </div>
    <c:forEach items="${products}" var="p" varStatus="vs">
        <div class="row mb-2">
            <div class="col-1">${vs.count + (page-1)*pageSize}</div>
            <div class="col-3">${p.productCode}</div>
            <div class="col-4">${p.productName}</div>
            <div class="col-1">${p.productScale}</div>
            <div class="col-2 text-right">${p.price}</div>
        </div>
    </c:forEach>
    <hr>
    <div class="d-flex justify-content-center">
        <div class="btn-group" role="group" aria-label="Pagination">
            <c:forEach begin="1" end="${itemCount/pageSize + (itemCount%pageSize>0?1 :0)}" varStatus="vs">
                <c:choose>
                    <c:when test="${vs.count==page}">
                        <button type="button" class="btn btn-danger">${vs.count}</button>
                    </c:when>
                    <c:otherwise>
                        <a href="product-list?pageSize=${pageSize}&page=${vs.count}"
                           class="btn btn-secondary">${vs.count}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
