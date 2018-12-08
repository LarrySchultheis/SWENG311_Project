package controllers;

import models.Appointment;
import models.FollowUp;
import models.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemCore extends Controller {
    private ArrayList<Patient> patients;

    public SystemCore ()
    {
        patients = new ArrayList<>();
    }

    //I moved this out here so I could use regex stuff.  It's ugly, but functional
    Scanner sc = new Scanner(System.in);
    Patient P;
    String name, gender, doc, nurse, illness, meds, companyName, planName, agentName, initialTime, initialDate;
    int insID, patID;
    boolean info;   //Booleans start as false and start as false in the voids


    //method registerNewPatient
    //registers a new patient with user entered data
    //returns: the Patient created
    public Patient registerNewPatient ()
    {
        System.out.println("Please enter some information about the patient: ");

        System.out.println("Patient name:");
        CheckName();

        System.out.println("Patient ID");       //This does not have a failsafe yet, only way to with Regex is with Strings
        patID = sc.nextInt();

        sc.nextLine();

        System.out.println("Gender: ");
        CheckGender();

        System.out.println("Date (mm/dd/yyyy): ");
        CheckDate();

        System.out.println("Time (hh:mm): ");
        CheckTime();

        System.out.println("Assigned doctor: ");
        DoctorChecker();

        System.out.println("Assigned nurse: ");
        CheckNurse();

        System.out.println("Type of illness: ");
        CheckIllness();

        System.out.println("Medication prescribed:");
        CheckPrescription();

        System.out.println("The following pertain to patient insurance");
        System.out.println("Company name: ");
        CheckCompany();

        System.out.println("Name of plan: ");
        CheckInsurance();

        System.out.println("Agent name:");
        CheckAgent();

        System.out.println("Insurance ID: ");//This does not have a failsafe yet, only way to with Regex is with Strings
        insID = sc.nextInt();

        //create new patient
        P = new Patient(name, gender, initialDate, initialTime, doc, nurse, illness, meds, patID, companyName, planName, agentName, insID);

        //call addPatient function to add to patients array list
        addPatient(P);
        return P;
    }

    //I minimized the ugly regex stuff.  This catches without catch
    void CheckName(){
        info = false;

        while (!info) {
            name = sc.nextLine();
            info = name.matches("[A-Z a-z'\\-]+");  //Allows letters
        }
    }
    void CheckGender(){ //This is ugly, but it works
        while (true){
            gender = sc.nextLine();
            if (gender.equals("male") || gender.equals("Male") || gender.equals("female") || gender.equals("Female")){
                break;
            }
            System.out.println("Check your spelling and enter 'Male' or 'Female': ");
        }
    }
    void CheckDate(){
        info = false;

        while (!info) {
            initialDate = sc.nextLine();
            info = initialDate.matches("\\d{2}/\\d{2}/\\d{4}");  //This doesn't check if date is legitimate
        }
    }
    void CheckTime(){
        info = false;

        while (!info) {
            initialTime = sc.nextLine();
            info = initialTime.matches("\\d{2}:\\d{2}");  //This doesn't check if time is legitimate
        }
    }
    void DoctorChecker(){   //I don't know why I gave this a different name
        info = false;

        while (!info) {
            doc = sc.nextLine();
            info = doc.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckNurse(){
        info = false;

        while (!info) {
            nurse = sc.nextLine();
            info = nurse.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckIllness(){
        info = false;

        while (!info) {
            illness = sc.nextLine();
            info = illness.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckPrescription(){
        info = false;

        while (!info) {
            meds = sc.nextLine();
            info = meds.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckCompany(){
        info = false;

        while (!info) {
            companyName = sc.nextLine();
            info = companyName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckInsurance(){
        info = false;

        while (!info) {
            planName = sc.nextLine();
            info = planName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }
    void CheckAgent(){
        info = false;

        while (!info) {
            agentName = sc.nextLine();
            info = agentName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }
    }


    //method scheduleAppointment
    //functionality: schedules a new appointment
    //arguments: patient who is associated with the appointment
    //returns: the appointment created -- it should be stored in the arrayList of appointments in the Patient object
    //Needs implemented
    public Appointment scheduleAppointment (Patient P)
    {
        Appointment A = null;
        return A;
    }

    //method scheduleFollowUp
    //functionality: schedules a new follow up
    //arguments: patient who is associated with the follow up
    //returns: the follow up created -- it should be stored in the arrayList of follow ups in the Patient object
    //Needs implemented -- should be very similar to scheduleAppointment
    public FollowUp scheduleFollowUp (Patient P)
    {
        FollowUp F = null;
        return F;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    //adds patient to array list in this class
    public void addPatient (Patient P)
    {
        patients.add(P);
    }


    //method pullDetails
    //functionality: pulls details associated with ALL patients in patients in this arrayList
    //args: none
    //returns: String holding all patient's details in system
    //almost finished -- just needs to go through all patient attributes
    public String pullDetails ()
    {
        String s = "";
        for (Patient P : patients)
        {
            s += P.getInfo();

        }
        return s;
    }
}
