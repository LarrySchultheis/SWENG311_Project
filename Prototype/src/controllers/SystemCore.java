package controllers;

import models.Appointment;
import models.FollowUp;
import models.Patient;

import java.util.ArrayList;

public class SystemCore extends Controller {
    private ArrayList<Patient> patients;

    public SystemCore ()
    {
        patients = new ArrayList<>();
    }

    public Patient registerNewPatient ()
    {
        Patient P = null;
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
