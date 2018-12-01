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

        P = new Patient(name, gender, doc, nurse, illness, meds, patID, companyName, planName, agentName, insID);
        addPatient(P);
        return P;
    }

    public Appointment scheduleAppointment ()
    {
        Appointment A = null;
        return A;
    }

    public FollowUp scheduleFollowUp ()
    {
        FollowUp F = null;
        return F;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient (Patient P)
    {
        patients.add(P);
    }


    public String pullDetails ()
    {
        String s = "";

        return s;
    }

}
