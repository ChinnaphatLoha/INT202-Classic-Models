package sit.int202.classic_models.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classic_models.model.Office;
import sit.int202.classic_models.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeSettingsServlets", value = "/office-settings")
public class OfficeSettingsServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("oc");
        Office selectedOffice;
        try {
            selectedOffice = officeRepository.find(officeCode);
        } catch (Exception e) {
            selectedOffice = null;
        }
        if (selectedOffice != null) {
            request.setAttribute("selectedOffice", selectedOffice);
            getServletContext().getRequestDispatcher("/settings-office.jsp").forward(request, response);
        } else {
            request.setAttribute("noOfEmployees", 0);
            request.setAttribute("allOffice", null);
            request.setAttribute("noArg", "updated");
            request.setAttribute("filteredOffice", "oc=" + officeCode);
            getServletContext().getRequestDispatcher("/office-management.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("delete") != null) {
            getServletContext().getRequestDispatcher("/office-settings/delete").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/office-settings/update").forward(request, response);
        }
    }
}