package models;

import java.util.ArrayList;
import utility.hospitalSystemUtility;

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

    public void setInitialTime(String initialTime) {
        initialTime = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegextime(), initialTime);
        this.initialTime = initialTime;
    }

    public void setInitialDate(String initialDate) {
        initialDate = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexdate(), initialDate);
        this.initialDate = initialDate;
    }

    public void setGender(String gender) {
        gender =  hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), gender);
        this.gender = gender;
    }

    public void setDoctor(String doctor) {
        doctor = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), doctor);
        this.doctor = doctor;

    }

    public void setNurse(String nurse) {
        nurse = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), nurse);
        this.nurse = nurse;
    }

    public void setIllness(String illness) {
        illness = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), illness);
        this.illness = illness;
    }

    public void setMedication(String medication) {
        medication = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), medication);
        this.medication = medication;
    }

    //insurance input handling should be covered in insurance class setters
    public void setInsurance (Insurance I)
    {
        this.insurance = I;
    }

    public void setName(String name) {
        name = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), name);
        this.name = name;
    }

    //Omitted setID because it should not be changed once created
    /*
    public void setPatientID(int patientID) {
        patientID = hospitalSystemUtility.checkInputMismatch();
    }
    */


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
