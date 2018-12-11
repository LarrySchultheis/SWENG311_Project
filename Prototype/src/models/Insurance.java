package models;

import utility.hospitalSystemUtility;

public class Insurance extends Model {

    private String companyName;
    private String planName;
    private String agentName;
    private int ID;

    public Insurance ()
    {
        companyName = "";
        planName = "";
        agentName = "";
        ID = 0;
    }

    public Insurance (String companyName, String planName, String agentName, int ID)
    {
        this.companyName = companyName;
        this.planName = planName;
        this.agentName = agentName;
        this.ID = ID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPlanName() {
        return planName;
    }

    public String getAgentName() {
        return agentName;
    }

    public int getID() {
        return ID;
    }

    public void setCompanyName(String companyName) {
        companyName = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), companyName);
        this.companyName = companyName;
    }

    public void setPlanName(String planName) {
        planName = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), planName);
        this.planName = planName;
    }

    public void setAgentName(String agentName) {
        agentName = hospitalSystemUtility.checkStringSetter(hospitalSystemUtility.getRegexletters(), agentName);
        this.agentName = agentName;
    }

    //omitted ID set because it should not be changed once entered
    /*
    public void setID(int ID) {
        this.ID = ID;
    }
    */

    @Override
    public String getInfo() {
        String s = "";

        s += "\nInsuranceID: " + this.ID;
        s += "\nInsurance Company Name: " + this.companyName;
        s += "\nPlan name: " + this.planName;
        s += "\nAgent Name: " + this.agentName;
        s += "\n";
        return s;
    }
}
