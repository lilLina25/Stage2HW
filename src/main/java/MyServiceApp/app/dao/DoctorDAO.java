package MyServiceApp.app.dao;

import MyServiceApp.app.connection.DBConnection;
import MyServiceApp.app.sample.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<Doctor>();
        String query = "SELECT * FROM doctors";
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            while (res.next()) {
                Doctor doctor = new Doctor(res.getInt("id"), res.getString("name"), res.getInt("clinic_id"));
                doctors.add(doctor);
            }
        }
        return doctors;
    }
    public void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors(id, name, clinic_id) VALUES (?,?,?)";
        try (Connection connect = DBConnection.getConnection();
             PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setInt(1, doctor.getId());
            pst.setString(2, doctor.getName());
            pst.setInt(3, doctor.getClinic_id());
            pst.executeUpdate();
        }
    }
    public Doctor getDoctorById(int doctorId) throws SQLException {
        String query = "SELECT * FROM doctors WHERE id = ?";
        Doctor doctor = null;
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            if (res.next()) {
                doctor = new Doctor(res.getInt("id"), res.getString("name"), res.getInt("clinic_id"));
            }
        }
        return doctor;
    }
    public void updateDoctor(Doctor doctor) throws SQLException{
        String query = "UPDATE doctors SET name = ? WHERE id = ?";
        try(Connection connect = DBConnection.getConnection();
            PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,doctor.getId());
            pst.setString(2, doctor.getName());
            pst.setInt(3,doctor.getClinic_id());
            pst.executeUpdate();
        }
    }
    public void deleteDoctor(int doctorId) throws SQLException{
        String query = "DELETE FROM doctors WHERE id =?";
        try(Connection connect = DBConnection.getConnection();
            PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,doctorId);
            pst.executeUpdate();
        }
    }
}
