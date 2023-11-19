<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classic Model | Add Office</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .card {
            width: 60% !important;
        }

        .col-form-label {
            font-weight: 600 !important;
            font-size: 1rem !important;
        }
    </style>
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
    <div class="card">
        <div class="card-header">
            <h2 class="mb-0">Add Office</h2>
        </div>
        <div class="card-body">
            <form action="add-office" method="post">

                <!-- City -->
                <div class="form-group row">
                    <label for="city" class="col-sm-3 col-form-label">City</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>
                </div>

                <!-- Phone -->
                <div class="form-group row">
                    <label for="phone" class="col-sm-3 col-form-label">Phone</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="phone" name="phone" required>
                    </div>
                </div>

                <!-- Address Line 1 -->
                <div class="form-group row">
                    <label for="addressLine1" class="col-sm-3 col-form-label">Address line 1</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="addressLine1" name="addressLine1" required>
                    </div>
                </div>

                <!-- Address Line 2 -->
                <div class="form-group row">
                    <label for="addressLine2" class="col-sm-3 col-form-label">Address line 2</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="addressLine2" name="addressLine2">
                    </div>
                </div>

                <!-- State -->
                <div class="form-group row">
                    <label for="state" class="col-sm-3 col-form-label">State</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="state" name="state">
                    </div>
                </div>

                <!-- Country -->
                <div class="form-group row">
                    <label for="country" class="col-sm-3 col-form-label">Country</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="country" name="country" required>
                    </div>
                </div>

                <!-- Postal Code -->
                <div class="form-group row">
                    <label for="postalCode" class="col-sm-3 col-form-label">Postal code</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="postalCode" name="postalCode" required>
                    </div>
                </div>

                <!-- Territory -->
                <div class="form-group row">
                    <label for="territory" class="col-sm-3 col-form-label">Territory</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="territory" name="territory" required>
                    </div>
                </div>

                <!-- Submit Button -->
                <div class="form-group row">
                    <div class="col-sm-9 offset-sm-3">
                        <button type="submit" class="btn btn-primary">Add Office</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
