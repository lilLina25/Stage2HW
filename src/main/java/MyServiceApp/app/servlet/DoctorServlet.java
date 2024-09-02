package MyServiceApp.app.servlet;

import MyServiceApp.app.dao.DoctorDAO;
import MyServiceApp.app.sample.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "doctor-servlet", urlPatterns = "/doctors")
public class DoctorServlet extends HttpServlet {
    private DoctorDAO doctorDAO;
    @Override
    public void init() throws ServletException{
        doctorDAO = new DoctorDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            req.setAttribute("doctor", doctors);
            req.getRequestDispatcher("doctor.jsp").forward(req,resp);
        }catch(SQLException e){
            throw new ServletException(e);
        }
    }
}
