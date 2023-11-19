package sit.int202.classic_models.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classic_models.model.Office;
import sit.int202.classic_models.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeDeleteServlet", value = "/office-settings/delete")
public class OfficeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/office-management");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("oc");
        try {
            Office deletedOffice = officeRepository.find(officeCode);
            officeRepository.delete(deletedOffice);
            response.sendRedirect("office-management");
        } catch (Exception e) {
            request.setAttribute("deleteError", "Unable to delete office. It may have associated employees.");
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
            getServletContext().getRequestDispatcher("/settings-office.jsp").forward(request, response);
        }
    }
}