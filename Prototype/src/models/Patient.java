package models;

import java.io.Serializable;
import java.util.ArrayList;
            //I added initialDate/Time to these things
public class Patient extends Model {
    private String name;
    private String gender;
    private String doctor;
    private String nurse;
    private String illness;
    private String medication;
    private String initialDate, initialTime;
    private int patientID;
    private ArrayList<Appointment> appointments;
    private ArrayList<FollowUp> followUps;
    private Insurance insurance;

    public Patient ()
    {
        name = "";
        gender = "";
        doctor = "";
        nurse = "";
        illness = "";
        medication = "";
        initialDate = "";
        initialTime = "";
        patientID = 0;
        appointments = new ArrayList<>();
        followUps = new ArrayList<>();
        insurance = new Insurance();
    }

    public Patient (String name, String gender, String doctor, String nurse, String illness, String initialDate, String initialTime,
                    String medication, int patientID, String companyName, String planName, String agentName, int insID)
    {
        this.name = name;
        this.gender = gender;
        this.doctor = doctor;
        this.nurse = nurse;
        this.illness = illness;
        this.medication = medication;
        this.patientID = patientID;
        this.initialDate = initialDate;
        this.initialTime = initialTime;
        appointments = new ArrayList<>();
        followUps = new ArrayList<>();
        insurance = new Insurance(companyName, planName, agentName, insID);
    }

    public String getInitialDate() {
        return initialDate;
    }

    public String getInitialTime() {
        return initialTime;
    }

    public String getGender() {
        return gender;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getNurse() {
        return nurse;
    }

    public String getIllness() {
        return illness;
    }

    public String getMedication() {
        return medication;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public String getName() {
        return name;
    }

    public int getPatientID() {
        return patientID;
    }

    public ArrayList<FollowUp> getFollowUps() {
        return followUps;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment (Appointment A)
    {
        appointments.add(A);
    }

    public void addFollowUp (FollowUp F)
    {
        followUps.add(F);
    }

    public boolean setInitialTime(String initialTime) {
        this.initialTime = initialTime;

        boolean valid = false;
        return valid;
    }

    public boolean setInitialDate(String initialDate) {
        this.initialDate = initialDate;

        boolean valid = false;
        return valid;
    }

    public boolean setGender(String gender) {
        this.gender = gender;

        boolean valid = false;
        return valid;
    }

    public boolean setDoctor(String doctor) {
        this.doctor = doctor;

        boolean valid = false;
        return valid;
    }

    public boolean setNurse(String nurse) {
        this.nurse = nurse;

        boolean valid = false;
        return valid;
    }

    public boolean setIllness(String illness) {
        this.illness = illness;

        boolean valid = false;
        return valid;
    }

    public boolean setMedication(String medication) {
        this.medication = medication;

        boolean valid = false;
        return valid;
    }

    public boolean setInsurance (Insurance I)
    {
        this.insurance = I;

        boolean valid = false;
        return valid;
    }

    public boolean setName(String name) {
        this.name = name;

        boolean valid = false;
        return valid;
    }

    public boolean setPatientID(int patientID) {
        this.patientID = patientID;

        boolean valid = false;
        return valid;
    }

    @Override
    public String getInfo() {
        String s = "";
        s += "\nPatient ID: " + patientID;
        s += "\nName: " + name;
        s += "\nGender: " + gender;
        s += "\nDate of Registry: " + initialDate;
        s += "\nTime of Registry: " + initialTime;
        s += "\nDoctor: " + doctor;
        s += "\nNurse: " + nurse;
        s += "\nIllness " + illness;
        s += "\nMedication " + medication;

        s += "\n\nInsurance Details: " + insurance.getInfo();
        s += "\n";

        s += "\nAppointment Info:";
        for (Appointment A : appointments)
        {
            s += A.getInfo();
        }

        return s;
    }
}
