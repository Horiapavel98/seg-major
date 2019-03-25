package seg.major.model;

import seg.major.model.database.AppointmentDAO;
import seg.major.model.database.ContactDAO;
import seg.major.model.database.PatientDAO;
import seg.major.model.util.DateReverser;
import seg.major.structure.Appointment;
import seg.major.structure.Contact;
import seg.major.structure.Patient;
import seg.major.structure.PatientEntry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotificationListModel {

    public List<PatientEntry> getCarriedOverAppointmentEntries() {

        List<PatientEntry> toReturn = new ArrayList<PatientEntry>();

        for (Patient patient : PatientDAO.getAll()) {
            for (Appointment appointment : AppointmentDAO.getAll()) {
                if (appointment.getPatientID() == patient.getID() && isCarriedOver(appointment)) {
                    toReturn.add(new PatientEntry(patient.getID(), appointment.getID(), patient.getForename(),
                            patient.getSurname(), patient.getHospitalNumber(), patient.getLocalClinic(),
                            DateReverser.reverseDateFormat(appointment.getDueDate()), patient.getDiagnosis(),
                            DateReverser.reverseDateFormat(patient.getLastTimeNotified())));
                }
            }
        }

        return toReturn;
    }

    private boolean isCarriedOver(Appointment app) {
        return (app.getStatus() == 0) && (app.getDueDate().compareTo(LocalDate.now()) < 0);
    }

    public void updateData() {

    }

    public static Patient getPatientByID(int toGet) {
        return PatientDAO.get(toGet);
    }

    public static List<Contact> getAllContacts() {
        return ContactDAO.getAll();
    }

    public static List<Contact> getContactsByPatientID(int toGet) {
        return ContactDAO.getByPatientId(toGet);
    }
}
