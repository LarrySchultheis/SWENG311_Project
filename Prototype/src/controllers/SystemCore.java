package controllers;

import models.Appointment;
import models.FollowUp;
import models.Patient;

import javax.tools.ForwardingFileObject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemCore extends Controller {
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> allAppointments;
    private ArrayList<FollowUp> allFollowUps;

    public SystemCore ()
    {
        patients = new ArrayList<>();
        allAppointments = new ArrayList<>();
        allFollowUps = new ArrayList<>();
    }

    //I moved this out here so I could use regex stuff.  It's ugly, but functional
    private final String regexletters = "[A-Z a-z'\\-]+";
    private final String regexkdate = "\\d{2}/\\d{2}/\\d{4}";
    private final String regextime = "\\d{2}:\\d{2}";



    //method registerNewPatient
    //registers a new patient with user entered data
    //returns: the Patient created
    public Patient registerNewPatient ()
    {
        String name, gender, doc, nurse, illness,
                meds, companyName, planName,
                agentName, initialTime, initialDate;



        int insID, patID;
       // boolean info = false;   //Booleans start as false and start as false in the voids

        Patient P;

        System.out.println("Please enter some information about the patient: ");

        System.out.println("Patient name:");
        name = checkInput(regexletters);

        System.out.println("Patient ID");       //This does not have a failsafe yet, only way to with Regex is with Strings
        patID = checkID(1);

        System.out.println("Gender: ");
        gender = CheckGender(); //ThErE aRe MoRe ThAn TwO gEnDeRs

        System.out.println("Date (mm/dd/yyyy): ");
        initialDate = checkInput(regexkdate);

        System.out.println("Time (hh:mm): ");
        initialTime = checkInput(regextime);

        System.out.println("Assigned doctor: ");
        doc = checkInput(regexletters);

        System.out.println("Assigned nurse: ");
        nurse = checkInput(regexletters);

        System.out.println("Type of illness: ");
        illness = checkInput(regexletters);

        System.out.println("Medication prescribed:");
        meds = checkInput(regexletters);

        System.out.println("The following pertain to patient insurance");
        System.out.println("Company name: ");
        companyName = checkInput(regexletters);

        System.out.println("Name of plan: ");
        planName = checkInput(regexletters);

        System.out.println("Agent name:");
        agentName = checkInput(regexletters);

        System.out.println("Insurance ID: ");//This does not have a failsafe yet, only way to with Regex is with Strings
        insID = checkID(2);

        //create new patient
        P = new Patient(name, gender, doc, nurse, illness, initialDate, initialTime,
                 meds, patID, companyName, planName, agentName, insID);

        //call addPatient function to add to patients array list
        addPatient(P);
        System.out.println("Patient has been entered into system.");
        return P;
    }

    //method checkID
    //functionality: full ID checking for both patient and insurance IDs -- checks for input mismatch and IDs already
    //                  in system
    //args: flag -- 1 for patient ID, 2 for Insurance ID
    //returns: valid ID for either insurance or patient

    int checkID (int flag)
    {
        boolean alreadyInSystem = true;
        int ID = -1; //signifies error in check

        while (alreadyInSystem) {
            ID = checkInputMismatch();  //check for input mismatch

                if (patients.isEmpty()) //if nothing in arrayList, nothing more to check
                {
                    break;
                }

                else    //else we must check the ID for duplicates
                {
                    for (Patient p : patients)
                    {
                        if (flag == 1) //check patient ID
                        {
                            if (p.getPatientID() == ID)
                            {
                                //already in system
                                System.out.println("Error, patient ID already in system, please enter a new one");
                                alreadyInSystem = true;
                            }

                            else
                            {
                                //good to go
                                alreadyInSystem = false;
                            }
                        }

                        else if (flag == 2) //check insurance ID
                        {
                            if (p.getInsurance().getID() == ID)
                            {
                                //already in system
                                System.out.println("Error, insurance ID already in system, pleas enter a new one");
                                alreadyInSystem = true;
                            }

                            else
                            {
                                //good to go
                                alreadyInSystem = false;
                            }
                        }

                        else {  //should never happen but you know
                            System.out.println("bad flag");
                            alreadyInSystem = false;
                        }
                    }
                }
            }
        return ID;
    }

    //simple utility function to check for input mismatch exception
    int checkInputMismatch ()
    {
        Scanner sc = new Scanner(System.in);
        int num;

            while (true) {
                try {
                    num = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error, please enter only number for the ID");
                    sc.nextLine();
                }
            }

            return num;
    }

    /*
    String CheckName(boolean info){
        info = false;
        String name;

        while (!info) {
            name = sc.nextLine();
            info = name.matches("[A-Z a-z'\\-]+");  //Allows letters
        }

        return name;
    }*/

    String CheckGender(){ //This is ugly, but it works
        String gender;
        Scanner sc = new Scanner(System.in);

        while (true){
            gender = sc.nextLine();
            if (gender.equals("male") || gender.equals("Male") || gender.equals("female") || gender.equals("Female")){
                break;
            }
            System.out.println("Check your spelling and enter 'Male' or 'Female': ");
        }

        return gender;
    }

    /*
    String CheckDate(boolean info){
        info = false;
        String initialDate = "";

        while (!info) {
            initialDate = sc.nextLine();
            info = initialDate.matches("\\d{2}/\\d{2}/\\d{4}");  //This doesn't check if date is legitimate
        }

        return initialDate;
    }

    String CheckTime(boolean info){
        info = false;
        String initialTime = "";

        while (!info) {
            initialTime = sc.nextLine();
            info = initialTime.matches("\\d{2}:\\d{2}");  //This doesn't check if time is legitimate
        }

        return initialTime;
    }

    String DoctorChecker(boolean info){   //I don't know why I gave this a different name
        info = false;
        String doc = "";

        while (!info) {
            doc = sc.nextLine();
            info = doc.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return doc;
    }

    String CheckNurse(boolean info){
        info = false;
        String nurse = "";

        while (!info) {
            nurse = sc.nextLine();
            info = nurse.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return nurse;
    }

    String CheckIllness(boolean info){
        info = false;
        String illness = "";


        while (!info) {
            illness = sc.nextLine();
            info = illness.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return illness;
    }

    String CheckPrescription(boolean info){
        info = false;
        String meds = "";

        while (!info) {
            meds = sc.nextLine();
            info = meds.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return meds;
    }

    String CheckCompany(boolean info){
        info = false;
        String companyName = "";

        while (!info) {
            companyName = sc.nextLine();
            info = companyName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return companyName;
    }

    String CheckInsurance(){
        info = false;

        while (!info) {
            planName = sc.nextLine();
            info = planName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return planName;
    }

    String  CheckAgent(){
        info = false;

        while (!info) {
            agentName = sc.nextLine();
            info = agentName.matches("[A-Z a-z'\\-\\.]+");  //Allows letters
        }

        return agentName;
    }
    */

    //method: checkInput
    //functionality: checks input against valid formats
    //args: the regex string of the valid format to check against
    //returns: valid String
    String checkInput (String regex)
    {
        Scanner sc = new Scanner(System.in);
        String inputStr;

        while (true)
        {
            inputStr = sc.nextLine();
            if (inputStr.matches(regex))
                break;
            else{
                System.out.println("Error, invalid format");
                continue;

            }
        }

        return inputStr;
    }


    //method scheduleAppointment
    //functionality: schedules a new appointment
    //arguments: patient who is associated with the appointment
    //returns: the appointment created -- it should be stored in the arrayList of appointments in the Patient object
    //Needs implemented
    public Appointment scheduleAppointment ()
    {
        Appointment A = null;
        return A;
    }

    //method scheduleFollowUp
    //functionality: schedules a new follow up
    //arguments: patient who is associated with the follow up
    //returns: the follow up created -- it should be stored in the arrayList of follow ups in the Patient object
    //Needs implemented -- should be very similar to scheduleAppointment
    public FollowUp scheduleFollowUp ()
    {
        FollowUp F = null;
        return F;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Appointment> getAllAppointments() {
        return allAppointments;
    }

    public ArrayList<FollowUp> getAllFollowUps() {
        return allFollowUps;
    }

    //adds patient to array list in this class
    private void addPatient (Patient P)
    {
        patients.add(P);
    }

    private void addAppointment (Appointment A)
    {
        allAppointments.add(A);
    }

    private void addFollowUp (FollowUp F)
    {
        allFollowUps.add(F);
    }


    //method pullDetails
    //functionality: pulls details associated with ALL patients in this arrayList
    //args: none
    //returns: String holding all patient's details in system
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
