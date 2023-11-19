package sit.int202.classic_models.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classic_models.model.Office;
import sit.int202.classic_models.repository.OfficeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfficeInsertServlet", value = "/add-office")
public class OfficeInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/add-office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        List<Office> allOffices = officeRepository.findAll();
        String lastOfficeCode = allOffices.get(allOffices.size() - 1).getOfficeCode();
        String officeCode = String.valueOf(Integer.parseInt(lastOfficeCode) + 1),
                city = request.getParameter("city"),
                phone = request.getParameter("phone"),
                addressLine1 = request.getParameter("addressLine1"),
                addressLine2 = request.getParameter("addressLine2"),
                state = request.getParameter("state"),
                country = request.getParameter("country"),
                postalCode = request.getParameter("postalCode"),
                territory = request.getParameter("territory");
        Office newOffice = new Office(officeCode, addressLine1, addressLine2, city, state, country, postalCode, phone, territory);
        officeRepository.insert(newOffice);
        getServletContext().getRequestDispatcher("/office-management").forward(request, response);
    }
}