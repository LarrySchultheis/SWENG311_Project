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


    //method registerNewPatient
    //registers a new patient with user entered data
    //returns: the Patient created
    public Patient registerNewPatient ()
    {
        Scanner sc = new Scanner(System.in);
        Patient P;
        String name, gender, doc, nurse, illness, meds, companyName, planName, agentName;
        int insID, patID;

        System.out.println("Please enter some information about the patient: ");

        System.out.println("Patient name:");
        name = sc.nextLine();

        System.out.println("Patient ID");
        patID = sc.nextInt();

        sc.nextLine();

        System.out.println("Gender: ");
        gender = sc.nextLine();

        System.out.println("Assigned doctor: ");
        doc = sc.nextLine();

        System.out.println("Assigned nurse: ");
        nurse = sc.nextLine();

        System.out.println("Type of illness: ");
        illness = sc.nextLine();

        System.out.println("Medication prescribed:");
        meds = sc.nextLine();

        System.out.println("The following pertain to patient insurance");
        System.out.println("Company name: ");
        companyName = sc.nextLine();

        System.out.println("Name of plan: ");
        planName = sc.nextLine();

        System.out.println("Agent name:");
        agentName = sc.nextLine();

        System.out.println("Insurance ID: ");
        insID = sc.nextInt();

        //create new patient
        P = new Patient(name, gender, doc, nurse, illness, meds, patID, companyName, planName, agentName, insID);

        //call addPatient function to add to patients array list
        addPatient(P);
        return P;
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
