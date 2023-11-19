package sit.int202.classic_models.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classic_models.model.Office;
import sit.int202.classic_models.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeUpdateServlet", value = "/office-settings/update")
public class OfficeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/office-management");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("oc"),
                city = request.getParameter("city"),
                phone = request.getParameter("phone"),
                addressLine1 = request.getParameter("addressLine1"),
                addressLine2 = request.getParameter("addressLine2"),
                state = request.getParameter("state"),
                country = request.getParameter("country"),
                postalCode = request.getParameter("postalCode"),
                territory = request.getParameter("territory");
        officeRepository.update(new Office(officeCode, addressLine1, addressLine2, city, state, country, postalCode, phone, territory));
        response.sendRedirect("office-management");
    }
}