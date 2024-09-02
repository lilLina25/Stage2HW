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
import java.util.List;

@WebServlet(name = "clinic-servlet", urlPatterns = "/clinic")
public class ClinicServlet extends HttpServlet {
        private ClinicDAO clinicDAO;
        @Override
        public void init() throws ServletException {
            clinicDAO = new ClinicDAO();
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try{
                List<Clinic> clinics = clinicDAO.getAllClinics();
                req.setAttribute("clinic", clinics);
                req.getRequestDispatcher("clinic.jsp").forward(req,resp);
            }catch(SQLException e){
                throw new ServletException(e);
            }
        }
    }