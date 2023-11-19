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

@WebServlet(name = "OfficeManagementServlet", value = "/office-management")
public class OfficeManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        List<Office> allOffice = officeRepository.findAll();
        String searchFor = request.getParameter("cit-o-con");
        boolean isCityOrCountry = searchFor != null;
        String cityOrCountry = isCityOrCountry ? searchFor : "Classic Model";
        boolean noEmployee = false;

        try {
            if (isCityOrCountry) {
                allOffice = officeRepository.findByCityOrCountry(searchFor);
            }
            request.setAttribute("allOffice", allOffice);

            String officeCode = request.getParameter("about-oc");
            if (officeCode != null) {
                request.setAttribute("selectedOffice", officeRepository.find(officeCode));
            }

        } catch (Exception e) {
            noEmployee = true;
        } finally {
            request.setAttribute("noOfEmployees", noEmployee ? 0 : officeRepository.getNumberOfEmployees(allOffice));
            request.setAttribute("filteredOffice", cityOrCountry);
            getServletContext().getRequestDispatcher("/office-management.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
