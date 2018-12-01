package models;

import java.util.ArrayList;

public class Patient extends Model{
    private String gender;
    private String dateOfInitialVisit;
    private String doctor;
    private String nurse;
    private String illness;
    private String medication;
    private String insuranceDetails;
    private ArrayList<Appointment> appointments;
    private ArrayList<FollowUp> followUps;

    public Patient ()
    {
        gender = "";
        dateOfInitialVisit = "";
        doctor = "";
        nurse = "";
        illness = "";
        medication = "";
        insuranceDetails = "";
        appointments = new ArrayList<>();
        followUps = new ArrayList<>();
    }

    public Patient (String gender, String dateOfInitialVisit, String doctor, String nurse, String illness, String medication, String insuranceDetails)
    {
        this.gender = gender;
        this.dateOfInitialVisit = dateOfInitialVisit;
        this.doctor = doctor;
        this.nurse = nurse;
        this.illness = illness;
        this.medication = medication;
        this.insuranceDetails = insuranceDetails;
        appointments = new ArrayList<>();
        followUps = new ArrayList<>();
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfInitialVisit() {
        return dateOfInitialVisit;
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

    public String getInsuranceDetails() {
        return insuranceDetails;
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

    public boolean setGender(String gender) {
        this.gender = gender;

        boolean valid = false;
        return valid;
    }

    public boolean setDateOfInitialVisit(String dateOfInitialVisit) {
        this.dateOfInitialVisit = dateOfInitialVisit;

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

    public boolean setInsuranceDetails(String insuranceDetails) {
        this.insuranceDetails = insuranceDetails;

        boolean valid = false;
        return valid;
    }

    @Override
    public String getInfo() {
        String s = "";

        return s;
    }
}
