<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .office-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            border-radius: 5px;
            background-color: #f8f9fa;
        }

        .selected-office {
            background-color: #ffc107;
        }

        .employee-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            border-radius: 20px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <div class="row bg-primary text-white p-2">
        <h2>Classic Model Offices</h2>
    </div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-lg-3 col-md-4 col-sm-6 office-card ${office.officeCode == selectedOffice.officeCode ? 'selected-office' : ''}">
                <div>
                    <a href="office-list?officeCode=${office.officeCode}">
                            ${office.city}, ${office.country}
                    </a>
                </div>
                <div> ${office.phone}</div>
            </div>
        </c:forEach>
    </div>
    <br>
    <div class="row bg-light p-2">
        <h4>Employees</h4>
    </div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-lg-3 col-md-4 col-sm-6 employee-card">
                <div> ${employee.firstName} ${employee.lastName}</div>
                <div> ${employee.jobTitle}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
