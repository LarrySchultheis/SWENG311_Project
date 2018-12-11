//class holding various static utility functions -- mostly input validation
//all regex operations are held here

package utility;

import models.Patient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hospitalSystemUtility {


    //allows only letters, apostrophes, hyphens, and spaces -- used for names and like Strings
    private static final String regexletters = "[A-Z a-z'\\-]+";

    //allows only tangible date options
    private static final String regexdate = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})";

    //allows only time format
    private static final String regextime = "\\d{2}:\\d{2}";

    //similar to the first, but also allows numbers -- used mostly for reason and treatment attributes as quantities would
    //be relevant to that data
    private static final String regexLetNumSpace = "[A-Za-z'0-9\\- ]+";


    //method: checkInput
    //functionality: checks input against valid formats
    //args: the regex string of the valid format to check against
    //returns: valid String
    public static String checkInput (String regex)
    {
        Scanner sc = new Scanner(System.in);
        String inputStr;

        while (true)
        {
            inputStr = sc.nextLine();
            if (inputStr.matches(regex))
                break;
            else{
                System.out.println("Error, invalid format");

            }
        }

        return inputStr;
    }

    //method: checkStringSetter
    //functionality: checks setter Strings against valid formats
    //args: the regex String and the String passed into the setter function
    //returns: valid String
    public static String checkStringSetter (String regex, String setString)
    {
        Scanner sc = new Scanner(System.in);

        if (setString.matches(regex))
            return setString;

        else {
            while (true) {
                setString = sc.nextLine();
                if (setString.matches(regex))
                {
                    return setString;
                }

                else
                    System.out.println("Error, invalid format.");
            }
        }
    }

    //simple utility function to check for input mismatch exception
    public static int checkInputMismatch ()
    {
        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error, please enter only number for the ID");
                sc.nextLine();
            }
        }

        return num;
    }

    public static String getRegexdate() {
        return regexdate;
    }

    public static String getRegexletters() {
        return regexletters;
    }

    public static String getRegextime() {
        return regextime;
    }

    public static String getRegexLetNumSpace() {
        return regexLetNumSpace;
    }
}
