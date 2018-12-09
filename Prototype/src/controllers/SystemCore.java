package controllers;

import models.Appointment;
import models.FollowUp;
import models.Patient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemCore extends Controller {
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> allAppointments;
    private ArrayList<FollowUp> allFollowUps;

    private final String regexletters = "[A-Z a-z'\\-]+";
    private final String regexdate = "\\d{2}/\\d{2}/\\d{4}";
    private final String regextime = "\\d{2}:\\d{2}";

    public SystemCore ()
    {
        patients = new ArrayList<>();
        allAppointments = new ArrayList<>();
        allFollowUps = new ArrayList<>();
    }


    //method registerNewPatient
    //registers a new patient with user entered data
    //returns: the Patient created -- could be void
    public void registerNewPatient ()
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
        initialDate = checkInput(regexdate);

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
    }

    //method checkID
    //functionality: full ID checking for both patient and insurance IDs -- checks for input mismatch and IDs already
    //                  in system
    //args: flag -- 1 for patient ID, 2 for Insurance ID
    //returns: valid ID for either insurance or patient

    private int checkID (int flag)
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
                                System.out.println("Error, insurance ID already in system, please enter a new one");
                                alreadyInSystem = true;
                            }

                            else
                            {
                                //good to go
                                alreadyInSystem = false;
                            }
                        }

                        else if (flag == 3)
                        {
                            if (p.getAppointments().isEmpty())
                            {
                                //same as patients, if empty nothing more to check
                                alreadyInSystem = false;
                                break;
                            }

                            else { //else check for duplicates
                                for (Appointment a : p.getAppointments()) {
                                    if (a.getAppointmentID() == ID) {
                                        System.out.println("Error, appointment ID already in system, please enter a new one");
                                        alreadyInSystem = true;
                                    } else {
                                        alreadyInSystem = false;
                                    }
                                }
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
    private int checkInputMismatch ()
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

    private String CheckGender(){ //This is ugly, but it works
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
    private String checkInput (String regex)
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

            }
        }

        return inputStr;
    }


    //method scheduleAppointment
    //functionality: schedules a new appointment
    //arguments: patient who is associated with the appointment
    //returns: the appointment created -- it should be stored in the arrayList of appointments in the Patient object
    //could be void
    //Needs implemented
    public void scheduleAppointment ()
    {
        Patient P;
        String date;
        String time;
        String reason;
        String treatmentPrescribed;
        int patindex = -1, apptID;

        System.out.println("Please enter some information regarding the appointment");
        System.out.println("Enter the ID of the patient who visited: ");
        patindex = searchForPatient();
        if (patindex == -1)
        {
            return;
        }

        System.out.println("Enter the appointment ID: ");
        apptID = checkID(3);

        System.out.println("Enter the date of this visit: ");
        date = checkInput(regexdate);

        System.out.println("Enter the time of the visit: ");
        time = checkInput(regextime);

        System.out.println("Enter the reason for this visit: ");
        reason = checkInput(regexletters);

        System.out.println("What prescription was the patient recommended: ");
        treatmentPrescribed = checkInput(regexletters);

        Appointment A = new Appointment(apptID, date, time, reason, treatmentPrescribed);
        allAppointments.add(A);

        patients.get(patindex).addAppointment(A);
        System.out.println("Appointment has been added to " + patients.get(patindex).getName() + "'s records");

    }

    //method scheduleFollowUp
    //functionality: schedules a new follow up
    //arguments: patient who is associated with the follow up
    //returns: the follow up created -- it should be stored in the arrayList of follow ups in the Patient object
    //could be void
    //Needs implemented -- should be very similar to scheduleAppointment
    public void scheduleFollowUp ()
    {

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

    //method searchForPatient
    //functionality: searches for a patient in the system
    //args:  none
    //returns: index of patient in array list
    int searchForPatient ()
    {
        int index = -1;
        int ID = checkInputMismatch();

        while (true)
        {
            if (patients.isEmpty())
            {
                System.out.println("No patients have been found in system, patients must be registered before an" +
                        " this action can be completed. Returning to main menu");
                return index;
            }

            else {
                for (Patient p : patients) {
                    if (p.getPatientID() == ID)
                        index = patients.indexOf(p);
                }

                if (index == -1) {
                    System.out.println("Error, patient with ID: " + ID + " was not found in system, try again");
                } else {
                    System.out.println("Patient found in system.");
                    break;
                }
            }
        }
        return index;
    }


    //method pullAllPatientDetails
    //functionality: pulls details associated with ALL patients in this arrayList
    //args: none
    //returns: String holding all patient's details in system
    public String pullAllPatientDetails ()
    {
        String s = "_____________________________________________";
        for (Patient P : patients)
        {
            s += P.getInfo();

        }
        return s;
    }


    //method: pullSpecificDetils
    //functionality: pulls specific details e.g. patients, appointments, etc.
    //args: none
    //returns String holding the requested details
    public String pullSpecificDetails ()
    {
        String s = "";

        while (true) {
            System.out.println("What details would you like to pull: ");
            System.out.println("\t1.) All details on specific Patients");
            System.out.println("\t2.) Appointment details on a patient");
            System.out.println("\t3.) Follow Up details on a patient");
            System.out.println("\t4.) Insurance details on a patient");
            int choice = checkInputMismatch();

            System.out.println("Enter the patient ID to view requested details: ");
            int patIndex = searchForPatient();
            if (patIndex == -1)
            {
                return "no patients in system";
            }

            if (choice == 1)
            {
                s += patients.get(patIndex).getInfo();
                break;
            }

            else if (choice == 2)
            {
                for (Appointment a : patients.get(patIndex).getAppointments())
                {
                    s += a.getInfo();
                }
                break;
            }

            else if (choice == 3)
            {
                for (FollowUp f : patients.get(patIndex).getFollowUps())
                {
                    s += f.getInfo();
                }
                break;
            }

            else if (choice == 4)
            {
                s += patients.get(patIndex).getInsurance().getInfo();
                break;
            }

            else
                System.out.println("Error, invalid menu choice");

        }

        return s;
    }

}
