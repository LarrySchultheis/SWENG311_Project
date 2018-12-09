package models;

import java.io.Serializable;

public class Appointment extends Model {
    private int appointmentID;
    private String date;
    private String time;
    private String reason;
    private String treatmentPrescribed;

    public Appointment ()
    {
        appointmentID = 0;
        date = "";
        time = "";
        reason = "";
        treatmentPrescribed = "";
    }

    public Appointment (int appointmentID, String date, String time, String reason, String treatmentPrescribed)
    {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.treatmentPrescribed = treatmentPrescribed;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getTreatmentPrescribed() {
        return treatmentPrescribed;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public boolean setDate(String date) {
        this.date = date;

        boolean valid = false;
        return valid;
    }

    public boolean setTime(String time) {
        this.time = time;

        boolean valid = false;
        return valid;
    }

    public boolean setReason(String reason) {
        this.reason = reason;

        boolean valid = false;
        return valid;
    }

    public boolean setTreatmentPrescribed(String treatmentPrescribed) {
        this.treatmentPrescribed = treatmentPrescribed;

        boolean valid = false;
        return valid;
    }

    public String getInfo ()
    {
        String s = "";
        s += "\nAppointment Date: " + this.date;
        s += "\nAppointment Time: " + this.time;
        s += "\nAppointment Reason: " + this.reason;
        s += "\nTreatment Prescribed: " + this.treatmentPrescribed;
        s += "\n";
        return s;
    }
}
