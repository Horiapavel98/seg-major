package seg.major.structure;

import java.time.LocalDate;
import java.util.Date;


public class Patient {
    private int id;
    private String forename;
    private String surname;
    private LocalDate dob;
    private String hospitalNumber;
    private String localClinic;

    public static final double DEFAULT_REFRESH_RATE = 1.0;

    public Patient(String forename, String surname, LocalDate dob, String hospitalNumber, String localClinic){
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.hospitalNumber = hospitalNumber;
        this.localClinic = localClinic;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public String getLocalClinic() {
        return localClinic;
    }

    public void setLocalClinic(String localClinic) {
        this.localClinic = localClinic;
    }
}
