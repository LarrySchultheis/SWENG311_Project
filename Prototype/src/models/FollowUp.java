package models;

import utility.hospitalSystemUtility;

public class FollowUp extends Appointment{
    private String followUpReason;
    private String additionalTreatment;

    public FollowUp ()
    {
        followUpReason = "";
        additionalTreatment = "";
    }

    public FollowUp (String followUpReason, String additionalTreatment)
    {
        this.followUpReason = followUpReason;
        this.additionalTreatment = additionalTreatment;
    }

    public FollowUp (String followUpReason, String additionalTreatment, int apptID,
                     String date, String time, String reason, String treatmentPrescribed)
    {
        super (apptID, date, time, reason, treatmentPrescribed);
        this.followUpReason = followUpReason;
        this.additionalTreatment = additionalTreatment;
    }

    public String getFollowUpReason() {
        return followUpReason;
    }

    public String getAdditionalTreatment() {
        return additionalTreatment;
    }

//    @Override
//    public String getDate() {
//        return super.getDate();
//    }
//
//    @Override
//    public String getReason() {
//        return super.getReason();
//    }
//
//    @Override
//    public String getTime() {
//        return super.getTime();
//    }
//
//    @Override
//    public String getTreatmentPrescribed() {
//        return super.getTreatmentPrescribed();
//    }

    public void setFollowUpReason(String followUpReason) {
        followUpReason = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexLetNumSpace(), followUpReason);
        this.followUpReason = followUpReason;
    }

    public void setAdditionalTreatment(String additionalTreatment) {
        additionalTreatment = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexLetNumSpace(), additionalTreatment);
        this.additionalTreatment = additionalTreatment;
    }

//    @Override
//    public boolean setDate(String date) {
//        return super.setDate(date);
//    }
//
//    @Override
//    public boolean setTime(String time) {
//        return super.setTime(time);
//    }
//
//    @Override
//    public boolean setReason(String reason) {
//        return super.setReason(reason);
//    }
//
//    @Override
//    public boolean setTreatmentPrescribed(String treatmentPrescribed) {
//        return super.setTreatmentPrescribed(treatmentPrescribed);
//    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        s += "Follow Up Reason: " + this.followUpReason;
        s += "Additional Treatment Prescribed: " + this.additionalTreatment;
        return s;
    }
}
