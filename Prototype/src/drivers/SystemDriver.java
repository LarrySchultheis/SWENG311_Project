package drivers;

import controllers.SystemCore;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemDriver {
    private static Scanner keyIn = new Scanner (System.in);

    public static void main(String[] args) {
        //initialize system core
        SystemCore sysCore = init();
        int choice;


        while (true) {

            //call handle menu and set return to choice
            choice = handleMenu();

            switch (choice) {
                case 1:
                    sysCore.registerNewPatient();
                    break;

                case 2:
                    sysCore.scheduleAppointment();
                    break;

                case 3:
                    sysCore.scheduleFollowUp();
                    break;

                case 4:
                    System.out.println(sysCore.pullAllPatientDetails());
                    break;

                case 5:
                    System.out.println(sysCore.pullSpecificDetails());
                    break;

                case 6:
                    saveState(sysCore);
                    break;

                default:
                    System.out.println("This should never happen but this is the default case");
                    break;
            }
            if (choice == 6)
                break;
        }
        System.exit(0);

    }

    private static int handleMenu ()
    {
        int choice;

        while (true) {
            System.out.println("MENU");
            System.out.println("_____________________________________");
            System.out.println("\t1.) Register a new patient");
            System.out.println("\t2.) Schedule an appointment");
            System.out.println("\t3.) Schedule a follow up date");
            System.out.println("\t4.) Display all patient details");
            System.out.println("\t5.) Display specific details");
            System.out.println("\t6.) Save and exit");

            while (true) {

                try {
                    choice = keyIn.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Error, invalid input.");
                    keyIn.nextLine();
                }
            }

            if (choice >= 1 && choice <= 6)
                break;

            else {
                System.out.println("Please choose a valid option 1 - 6");
            }
        }
        return choice;
    }

    //method: init
    //functionality: initializes the current working object by either loading a previous state
    //                  or creating a new one
    //args: none
    //returns: current working system core
    //needs to be tested
    private static SystemCore init ()
    {
        SystemCore sysCore = null;
        int loadState;
        System.out.println("################################################");
        System.out.println("#  Welcome to the Hospital Management System.  #");
        System.out.println("# ____________________________________________ #");
        System.out.println("#   By: Larry Schultheis and Dan Farquhar      #");
        System.out.println("################################################");

        while (true) {

            while (true) {
                System.out.println("\nWould you like to load a previous System state?");
                System.out.println("\t1.) Yes, there is a previous system state that exists\n\t2.) No, I would like to create a new System");
                try {
                    loadState = keyIn.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    // e.printStackTrace();
                    System.out.println("Invalid input, please enter 1 or 2");
                    keyIn.nextLine();
                }
            }

            if (loadState == 1) {
                //load previous system instance
                sysCore = loadState();
                break;
            }

            else if (loadState == 2) {
                //create new system instance
                sysCore = new SystemCore();
                break;
            }

            else {
                System.out.println("Error, invalid menu selection.");
            }
        }
        return sysCore;
    }

    //method: loadState
    //functionality: loads a previous system object
    //args: none
    //returns: loaded system core
    private static SystemCore loadState ()
    {
        SystemCore sysCore = null;
        Scanner keyin = new Scanner(System.in);
        String fileName;

        System.out.println("Enter the name of the file that holds the system object: ");
        fileName = keyin.nextLine();

        ObjectInputStream objIn;
        try
        {
            objIn = new ObjectInputStream(new FileInputStream(fileName));
            sysCore = (SystemCore) objIn.readObject();
            System.out.println("Object load successful!");
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error: Object load unsuccessful. A new object will be created.");
            sysCore = new SystemCore();
        }

        return sysCore;
    }

    //method: saveState
    //functionality: saves the current system object for reuse
    //args: SystemCore to save
    //returns: none
    //also needs testing
    private static void saveState (SystemCore S)
    {
        Scanner keyin = new Scanner(System.in);
        String filename;

        System.out.println("Enter the name of the file to save the system state to: ");
        filename = keyin.nextLine();

        ObjectOutputStream objOut;

        try
        {
            objOut = new ObjectOutputStream(new FileOutputStream(filename));
            objOut.writeObject(S);
            System.out.println("Object saved successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error, object write unsuccessful");
        }

        System.exit(0);
    }
}
