package models;

import utility.hospitalSystemUtility;

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

    public void setDate(String date) {
        date = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexdate(), date);
        this.date = date;

    }

    public void setTime(String time) {
        time = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegextime(), time);
        this.time = time;
    }

    public void setReason(String reason) {
        reason = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexLetNumSpace(), reason);
        this.reason = reason;
    }

    public void setTreatmentPrescribed(String treatmentPrescribed) {
        treatmentPrescribed = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexLetNumSpace(), treatmentPrescribed);
        this.treatmentPrescribed = treatmentPrescribed;
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
