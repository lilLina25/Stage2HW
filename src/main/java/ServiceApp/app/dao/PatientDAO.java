package ServiceApp.app.dao;

import ServiceApp.app.connection.DBConnection;
import ServiceApp.app.sample.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<Patient>();
        String query = "SELECT * FROM patients";
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            while (res.next()) {
                Patient patient = new Patient(res.getInt("id"), res.getString("name"));
                patients.add(patient);
            }
        }
        return patients;
    }
    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients(id, name) VALUES (?,?)";
        try (Connection connect = DBConnection.getConnection();
             PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setInt(1, patient.getId());
            pst.setString(2, patient.getName());
            pst.executeUpdate();
        }
    }
    public Patient getPatientById(int patientId) throws SQLException {
        String query = "SELECT * FROM patients WHERE id = ?";
        Patient patient = null;
        try (Connection connect = DBConnection.getConnection();
             Statement st = connect.createStatement();
             ResultSet res = st.executeQuery(query)) {
            if (res.next()) {
                patient = new Patient(res.getInt("id"), res.getString("name"));
            }
        }
        return patient;
    }
    public void updatePatient(Patient patient) throws SQLException{
        String query = "UPDATE patients SET name = ? WHERE id = ?";
        try(Connection connect = DBConnection.getConnection();
            PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,patient.getId());
            pst.setString(2, patient.getName());
            pst.executeUpdate();
        }
    }
    public void deletePatient(int patientId) throws SQLException{
        String query = "DELETE FROM patients WHERE id =?";
        try(Connection connect = DBConnection.getConnection();
            PreparedStatement pst = connect.prepareStatement(query)){
            pst.setInt(1,patientId);
            pst.executeUpdate();
        }
    }
}
