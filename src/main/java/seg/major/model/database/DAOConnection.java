package seg.major.model.database;

import java.sql.*;

import seg.major.App;

/**
 * Provides database connection for the application.
 * @author Team Pacane
 * @version 1.0
 */
public class DAOConnection {

    // Credentials
    private static final String URL = App.props.getProperty("db_url");
    private static final String USER = App.props.getProperty("db_user");
    private static final String PASSWORD = App.props.getProperty("db_password");
    private static final String DB_NAME = App.props.getProperty("db_name");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static UserDAO userDAO = new UserDAO();
    private static PatientDAO patientDAO = new PatientDAO();
    private static AppointmentDAO appointmentDAO = new AppointmentDAO();

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public PatientDAO getPatientDAO() {
        return patientDAO;
    }

    public AppointmentDAO getAppointmentDAO() {
        return appointmentDAO;
    }

}
