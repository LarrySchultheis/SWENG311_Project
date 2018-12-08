package models;

public class FollowUp extends Appointment{
    private String followUpReason;
    private String additionalTreatment;

    public FollowUp ()
    {
        followUpReason = "";
        additionalTreatment = "";
    }

    public FollowUp (String followUpReason, String additionalTreatment, String newReason)
    {
        this.followUpReason = followUpReason;
        this.additionalTreatment = additionalTreatment;
    }

    public FollowUp (String followUpReason, String additionalTreatment, String newReason,
                     String date, String time, String reason, String treatmentPrescribed)
    {
        super (date, time, reason, treatmentPrescribed);
        this.followUpReason = followUpReason;
        this.additionalTreatment = additionalTreatment;
    }

    public String getFollowUpReason() {
        return followUpReason;
    }

    public String getAdditionalTreatment() {
        return additionalTreatment;
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public String getReason() {
        return super.getReason();
    }

    @Override
    public String getTime() {
        return super.getTime();
    }

    @Override
    public String getTreatmentPrescribed() {
        return super.getTreatmentPrescribed();
    }

    public boolean setFollowUpReason(String followUpReason) {
        this.followUpReason = followUpReason;

        boolean valid = false;
        return valid;
    }

    public boolean setAdditionalTreatment(String additionalTreatment) {
        this.additionalTreatment = additionalTreatment;

        boolean valid = false;
        return valid;
    }

    @Override
    public boolean setDate(String date) {
        return super.setDate(date);
    }

    @Override
    public boolean setTime(String time) {
        return super.setTime(time);
    }

    @Override
    public boolean setReason(String reason) {
        return super.setReason(reason);
    }

    @Override
    public boolean setTreatmentPrescribed(String treatmentPrescribed) {
        return super.setTreatmentPrescribed(treatmentPrescribed);
    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        s += "Follow Up Reason: " + this.followUpReason;
        s += "Additional Treatment Prescribed: " + this.additionalTreatment;
        return s;
    }
}
