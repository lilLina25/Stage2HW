package ServiceApp.app.dao;

import ServiceApp.app.connection.DBConnection;
import ServiceApp.app.sample.Clinic;
import ServiceApp.app.sample.Doctor;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicDAO {
    public List<Clinic> getAllClinics() throws SQLException {
        List<Clinic> clinics = new ArrayList<Clinic>();
        String query = "SELECT * FROM clinics";
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            while (res.next()) {
                Clinic clinic = new Clinic(res.getInt("id"), res.getString("name"));
                clinics.add(clinic);
            }
        }
        return clinics;
    }
    public void addClinic(Clinic clinic) throws SQLException {
        String query = "INSERT INTO clinics(id, name) VALUES (?,?)";
        try (Connection connect = DBConnection.getConnection();
             PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setInt(1, clinic.getId());
            pst.setString(2, clinic.getName());
            pst.executeUpdate();
        }
    }
    public Clinic getClinicById(int clinicId) throws SQLException {
        String query = "SELECT * FROM clinics WHERE id = ?";
        Clinic clinic = null;
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            if (res.next()) {
                clinic = new Clinic(res.getInt("id"), res.getString("name"));
            }
        }
        return clinic;
    }
    public void updateClinic(Clinic clinic) throws SQLException{
        String query = "UPDATE clinics SET name = ? WHERE id = ?";
                try(Connection connect = DBConnection.getConnection();
                PreparedStatement pst = connect.prepareStatement(query)){
                    pst.setInt(1,clinic.getId());
                    pst.setString(2, clinic.getName());
                    pst.executeUpdate();
                }
    }
    public void deleteClinic(int clinicId) throws SQLException{
        String query = "DELETE FROM clinics WHERE id =?";
        try(Connection connect = DBConnection.getConnection();
        PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,clinicId);
            pst.executeUpdate();
        }
    }
    public List<Doctor> getDoctorByClinicId(int clinicId) throws SQLException{
        List<Doctor> doctors = null;
        String query = "SELECT Doctors.id, Doctors.name FROM doctors" +
                "JOIN doctors on doctors.Clinic_ID = clinics.ID"+
                "WHERE clinics_id = ?";
        try(Connection connect = DBConnection.getConnection();
        PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,clinicId);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Clinic clinic = new Clinic(res.getInt("id"), res.getString("name"));
            }
        }
        return doctors;
    }
}
