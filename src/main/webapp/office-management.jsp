<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classic Model | Office Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        a {
            text-decoration: none !important;
        }

        body {
            background-color: #f8f9fa;
        }

        .m-clear {
            margin: 0 !important;
        }

        .p-clear {
            padding: 0 !important;
        }

        .b-clear {
            border: none !important;
        }

        .font-125 {
            font-size: 125%;
        }

        .full-font {
            font-size: 100%;
        }

        .font-90 {
            font-size: 90%;
        }

        .l-font-weight {
            font-weight: 300;
        }

        .nm-font-weight {
            font-weight: 400;
        }

        .b-font-weight {
            font-weight: 600;
        }

        .container-100 {
            max-width: 100% !important;
        }

        .light {
            color: #f8f9fa !important;
        }

        .dark {
            color: #343a40 !important;
        }

        .search-form {
            width: 30%;
        }

        .form-control {
            width: 60%;
        }

        .office-card, .employee-card {
            border: 2px solid #343a40;
            padding: 1rem;
            margin: 0.5rem 1rem;
            border-radius: 0.25rem;
            background-color: #f8f9fa;
            transition: background-color 0.3s;
        }

        .location-tag {
            padding: 0.5em 0.75em;
            border-radius: 4rem;
            font-size: 0.75rem;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .location-tag:hover, .selected-location {
            background-color: #343a40 !important;
            color: #f8f9fa;
        }

        .office-card-btn:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="container-100 m-clear p-clear">
    <nav class="navbar navbar-dark bg-dark pt-3 pb-3">
        <div class="container-fluid">
            <a href="#" class="navbar-brand light">Office Management</a>
            <form action="office-management" method="post" class="d-flex justify-content-between search-form">
                <input name="cit-o-con" class="form-control me-2" type="search" placeholder="Search by city or country"
                       aria-label="Search" size="24" value="${filteredOffice}" required>
                <button class="btn btn-outline-light" type="submit">Search</button>
                <a class="btn btn-outline-light" href="office-management">All</a>
            </form>
            <button type="button" class="btn btn-light position-relative">
                Work for <span class="b-font-weight">${filteredOffice}</span>
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-primary light">
                    ${noOfEmployees}
                </span>
            </button>
            <a class="btn btn-outline-light" href="add-office">Add new office</a>
        </div>
    </nav>
</div>
<div class="container mt-4 p-clear">
    <c:if test="${empty allOffice}">
        <div class="alert alert-danger" role="alert">
            No offices found for the ${empty noArg ? "searched" : noArg} location <strong>(${filteredOffice})</strong>.
        </div>
    </c:if>
    <div class="row justify-content-start m-clear">
        <c:forEach items="${allOffice}" var="office">
            <div class="col-lg-3 col-md-4 col-sm-6 office-card">
                <div class="mb-3 d-flex justify-content-between">
                    <div>
                        <span class="badge bg-primary location-tag ${office.officeCode == selectedOffice.officeCode ? 'selected-location' : ''}">
                        <a href="office-management?cit-o-con=${office.city}" class="light">${office.city}</a>
                    </span>
                        <span class="badge bg-primary location-tag ${office.officeCode == selectedOffice.officeCode ? 'selected-location' : ''}">
                        <a href="office-management?cit-o-con=${office.country}" class="light">${office.country}</a>
                    </span>
                    </div>
                    <div>
                        <a href="office-management?about-oc=${office.officeCode}"
                           class="btn font-125 b-clear p-clear office-card-btn">
                            <i class="fa-regular fa-eye"></i>
                        </a>
                        <a href="office-settings?oc=${office.officeCode}"
                           class="btn ml-2 font-125 b-clear p-clear office-card-btn">
                            <i class="fa-regular fa-pen-to-square"></i>
                        </a>
                    </div>
                </div>
                <div>Tel: ${office.phone}</div>
            </div>
        </c:forEach>
    </div>
    <c:if test="${not empty selectedOffice}">
        <div class="row p-2 mt-4 mb-4">
            <h4 class="h3 dark">About Office [${selectedOffice.officeCode}]</h4>
        </div>
        <div class="row">
            <div class="col-md-3">
                <strong>Territory</strong>
                <p>${selectedOffice.territory}</p>
            </div>
            <div class="col-md-3">
                <strong>Country</strong>
                <p>${selectedOffice.country}</p>
            </div>
            <div class="col-md-3">
                <strong>State</strong>
                <p>${selectedOffice.state}</p>
            </div>
            <div class="col-md-3">
                <strong>City</strong>
                <p>${selectedOffice.city}</p>
            </div>
            <div class="col-md-3">
                <strong>Address line 1</strong>
                <p>${selectedOffice.addressLine1}</p>
            </div>
            <div class="col-md-3">
                <strong>Address line 2</strong>
                <p>${selectedOffice.addressLine2}</p>
            </div>
            <div class="col-md-3">
                <strong>Postal code</strong>
                <p>${selectedOffice.postalCode}</p>
            </div>
            <div class="col-md-3">
                <strong>Phone</strong>
                <p>${selectedOffice.phone}</p>
            </div>
        </div>

        <div class="row mt-4 mb-4">
            <h4 class="h3 dark">Employees</h4>
        </div>
        <div class="row">
            <c:forEach items="${selectedOffice.employeeList}" var="employee">
                <div class="col-lg-3 col-md-4 col-sm-6 employee-card">
                    <div><strong>${employee.jobTitle}</strong></div>
                    <div>${employee.firstName} ${employee.lastName}</div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
