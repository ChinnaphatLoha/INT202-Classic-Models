<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classic Model | Update Office</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            max-width: 500px;
            margin: 50px auto;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 10px;
        }

        h2 {
            color: #343a40;
            text-align: center;
        }

        label {
            font-weight: bold;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-primary, .btn-danger {
            margin-right: 10px;
        }

        .alert {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="card">
    <h2>Update Office</h2>
    <form action="office-settings" method="post">

        <!-- Hidden field for office code -->
        <input type="hidden" name="oc" value="${selectedOffice.officeCode}">

        <!-- City -->
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" value="${selectedOffice.city}" required>
        </div>

        <!-- Phone -->
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${selectedOffice.phone}" required>
        </div>

        <!-- Address Line 1 -->
        <div class="form-group">
            <label for="addressLine1">Address line 1</label>
            <input type="text" class="form-control" id="addressLine1" name="addressLine1"
                   value="${selectedOffice.addressLine1}" required>
        </div>

        <!-- Address Line 2 -->
        <div class="form-group">
            <label for="addressLine2">Address line 2</label>
            <input type="text" class="form-control" id="addressLine2" name="addressLine2"
                   value="${selectedOffice.addressLine2}">
        </div>

        <!-- State -->
        <div class="form-group">
            <label for="state">State</label>
            <input type="text" class="form-control" id="state" name="state" value="${selectedOffice.state}">
        </div>

        <!-- Country -->
        <div class="form-group">
            <label for="country">Country</label>
            <input type="text" class="form-control" id="country" name="country" value="${selectedOffice.country}"
                   required>
        </div>

        <!-- Postal Code -->
        <div class="form-group">
            <label for="postalCode">Postal code</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode"
                   value="${selectedOffice.postalCode}" required>
        </div>

        <!-- Territory -->
        <div class="form-group">
            <label for="territory">Territory</label>
            <input type="text" class="form-control" id="territory" name="territory" value="${selectedOffice.territory}"
                   required>
        </div>

        <!-- Delete Error Alert -->
        <c:if test="${not empty deleteError}">
            <div class="alert alert-danger" role="alert">
                    ${deleteError}
            </div>
        </c:if>

        <!-- Update and Delete Buttons -->
        <div class="form-group">
            <button type="submit" name="update" value="update" class="btn btn-primary">Update office</button>
            <button type="submit" name="delete" value="delete" class="btn btn-danger">Delete this office</button>
        </div>

    </form>
</div>
</body>
</html>
