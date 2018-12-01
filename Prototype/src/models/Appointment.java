package models;

public class Appointment extends Model{
    private String date;
    private String time;
    private String reason;
    private String treatmentPrescribed;

    public Appointment ()
    {
        date = "";
        time = "";
        reason = "";
        treatmentPrescribed = "";
    }

    public Appointment (String date, String time, String reason, String treatmentPrescribed)
    {
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

        return s;
    }
}
