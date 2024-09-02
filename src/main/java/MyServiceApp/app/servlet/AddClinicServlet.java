package MyServiceApp.app.servlet;

import MyServiceApp.app.dao.ClinicDAO;
import MyServiceApp.app.sample.Clinic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "add-clinic", urlPatterns = "/addClinic")
public class AddClinicServlet extends HttpServlet {
    private ClinicDAO clinicDAO;
    @Override
    public void init() throws ServletException {
        clinicDAO = new ClinicDAO();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Clinic clinic = new Clinic(id,name);
        try{
            clinicDAO.addClinic(clinic);
            req.setAttribute("clinic", clinicDAO.getAllClinics());
            resp.sendRedirect("clinic");
        }catch(SQLException | IOException e){
            throw new RuntimeException(e);
        }
    }
}