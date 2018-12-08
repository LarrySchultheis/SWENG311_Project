package models;


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

    public boolean setCompanyName(String companyName) {
        this.companyName = companyName;

        boolean valid = false;
        return valid;
    }

    public boolean setPlanName(String planName) {
        this.planName = planName;

        boolean valid = false;
        return valid;
    }

    public boolean setAgentName(String agentName) {
        this.agentName = agentName;

        boolean valid = false;
        return valid;
    }

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
