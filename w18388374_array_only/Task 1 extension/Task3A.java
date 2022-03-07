import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3A {
    public static int code = 0;
    public static int vStock = 10;
    static Scanner input = new Scanner(System.in);
    static String[] booth = { "Null", "Null", "Null", "Null", "Null", "Null" };
    static String[] surname = { "Null", "Null", "Null", "Null", "Null", "Null" };
    
/*Here two arrays are used to contain the First name and the second name and when we have to output
the data from both the arrays are called and displayed */
/*All the variables are set to static because they are used by all the fucntions therefore the golbal varaibles */
    static File userData = new File("User data.txt");

    public static void VVB() {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            System.out
                    .println("Booth number " + boothNumber + " occupied by " + booth[counter] + " " + surname[counter]);
            boothNumber++;
        }
    }
/*in LINE 23 you can see i am using the same counter and display both the content in both the arrays */
    public static void VEB() {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            if (booth[counter].equals("Null")) {
                System.out.println("Booth Number " + boothNumber + " is Empty");
            } else {
                System.out.println("Booth Number " + boothNumber + " is Occupied");
            }
            boothNumber++;
        }
    }

    public static void APB() {
        String userInputName = " ";
        String sName = " ";
        int vNumber = 0;
        String vType = " ";
        Boolean valid2 = false;
        System.out.println("What is the patient First name?");
        userInputName = input.nextLine();
        System.out.println("What is the patients Surname?");
        sName = input.nextLine();
        System.out.println("What is the Vaccination type?");
        System.out.println("Enter 1 for AstraZeneca 2 for Sinopharm and 3 for Pfizer");
        vNumber = input.nextInt();
        /*The program gets all the user data and assigns them to variables and then asks the user to enter the number
        corresponding to the vaccine  */
        while (valid2.equals(false)) {
            if (vNumber == 1) {
                vType = "AstraZeneca";
                valid2 = true;
            } else if (vNumber == 2) {
                vType = "Sinopharm";
                valid2 = true;
            } else if (vNumber == 3) {
                vType = "Pfizer";
                valid2 = true;
            } else {
                System.out.println("Please enter 1 2 or 3 ");
                System.out.println("Enter 1 for AstraZeneca 2 for Sinopharm and 3 for Pfizer");
                vNumber = input.nextInt();
            }
        }
        /*Here the patient is put into a specifc booth according to the type of vaccine he selects using the Vnumber which we
        got in the eariler loop */
        if (vNumber == 1) {
            if (booth[0].equals("Null")) {
                booth[0] = userInputName;
                surname[0] = sName;
                vStock = vStock - 1;
            } else if (booth[1].equals("Null")) {
                booth[1] = userInputName;
                surname[1] = sName;
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for AstraZeneca is Full at the moment");
            }
        } else if (vNumber == 2) {
            if (booth[2].equals("Null")) {
                booth[2] = userInputName;
                surname[2] = sName;
                vStock = vStock - 1;
            } else if (booth[3].equals("Null")) {
                booth[3] = userInputName;
                surname[4] = sName;
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for Sinopharm is Full at the moment");
            }
        } else if (vNumber == 3) {
            if (booth[4].equals("Null")) {
                booth[4] = userInputName;
                surname[4] = sName;
                vStock = vStock - 1;
            } else if (booth[5].equals("Null")) {
                booth[5] = userInputName;
                surname[5] = sName;
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for Pfizer is Full at the moment");
            }

        }
        if (vStock < 20) {
            System.out.println("VACCINATIONS ARE ALMOST OUT OF STOCK RE-ORDER THEM NOW");
        }
        VVB();

    }

    public static void RPB() {
        int boothNumber = 1;
        int editBooth = 0;
        int temp = 0;
        System.out.print("The Ocupied booths are ");
        Boolean valid = false;
        for (int counter = 0; counter < 6; counter++) {
            if (booth[counter] != "Null") {
                System.out.print(boothNumber + ", ");
            }
            boothNumber++;
        }
        /*This loop is used to validate the users input on the booth number */
        while (valid.equals(false)) {
            try {
                System.out.println("Which booth would you like to clear?");
                editBooth = Integer.parseInt(input.nextLine());
                temp = editBooth - 1;
                if (booth[temp] != "Null") {
                    valid = true;
                } else {
                    System.out.println("Uh-oh the booth you are trying to remove is empty");
                    valid = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid Booth number! ");
            }
        }
        /*Both arrays are made to NULL simultaneously */
        booth[temp] = "Null";
        surname[temp] = "Null";
        VVB();
    }

    public static void VRV() {
        System.out.println("The remaining vaccination stock level is " + vStock);
    }

    public static void AVS() {
        int toAdd = 0;
        System.out.println("How many vaccinations will you like to add to stock level? ");
        toAdd = input.nextInt();
        vStock = vStock + toAdd;
        System.out.println("Vaccinations in stock " + vStock);
    }

    public static void VPS(String[] arrayBooth2) {
        String booth[] = {arrayBooth2[0],arrayBooth2[1],arrayBooth2[2],arrayBooth2[3],arrayBooth2[4],arrayBooth2[5]};
        String temp;
        /*Here only the first name is used to sort the array as it is only dependant for a name sort */
        for (int count = 0; count < 6 - 1; count++) {
            for (int count2 = count + 1; count2 < 6; count2++) {
                if (booth[count].toLowerCase().compareTo(booth[count2].toLowerCase()) > 0) {
                    temp = booth[count];
                    booth[count] = booth[count2];
                    booth[count2] = temp;
                }
            }
        }
        /* Printing the sorted array */
        for (int counter = 0; counter < 6; counter++) {
            System.out.print(booth[counter]+" ");
        }
    }
    /*Both the arrays initilaised to NULL  */
    public static void INI(String[] booth) {
        for (int count = 0; count < 7 - 1; count++) {
            booth[count] = "Null";
            surname[count] = "Null";
        }
    }

    public static void SPD() throws IOException {
        FileWriter writeFunc = new FileWriter("User data.txt");
        String temp = " ";
        String temp2 = " ";
        /*Here the content of the array is added to two variables and then written by contatanation both BUT separated by a 
        "-" */
        for (int counter = 0; counter < 6; counter++) {
            temp = booth[counter];
            temp2 = surname[counter];
            writeFunc.write(temp + "-" + temp2 + "\n");
        }
        writeFunc.close();
        System.out.println("Wrote it sucessfully :p");
    }

    public static void LPD() throws FileNotFoundException {
        Scanner readFile = new Scanner(userData);
        int counter = 0;
        String temp = " ";
        /*Here the content of the line is written to a variable and then the "-" is used to sperate both the variables and 
        by using the "Substring ()" the values are put back into the arrays */
        int lineLength = 0;
        int dash = 0;
        while (readFile.hasNextLine()) {
            temp = readFile.nextLine();
            lineLength = temp.length();
            dash = temp.indexOf("-");
            booth[counter] = temp.substring(0, dash);
            surname[counter] = temp.substring(dash + 1, lineLength);
            counter++;
        }
        readFile.close();
        System.out.println("Files Sucessfully loaded");
        System.out.println("------------------------------------------------------------------------------------");
        VVB();
    }

    public static void main(String[] args) throws IOException {
        if (vStock < 20) {
            System.out.println("VACCINATIONS ARE ALMOST OUT OF STOCK RE-ORDER THEM NOW");
        }
        Boolean valid = false;
        String userInput = " ";
        System.out.println("Welcome to Thulana's Covid Vaccination AI");
        System.out.println("               Main Menu");
        System.out.println("100 or VVB: View all Vaccination Booths");
        System.out.println("101 or VEB: View all Empty Booths");
        System.out.println("102 or APB: Add Patient to a Booth");
        System.out.println("103 or RPB: Remove Patient from a Booth");
        System.out.println("104 or VPS: View Patients Sorted in alphabetical order");
        System.out.println("105 or SPD: Store Program Data into file");
        System.out.println("106 or LPD: Load Program Data from file");
        System.out.println("107 or VRV: View Remaining Vaccinations");
        System.out.println("108 or AVS: Add Vaccinations to the Stock");
        System.out.println("999 or EXT: Exit the Program");
        System.out.println("169 or INI: Clear the array to Null");
        System.out.println("Enter what you want to do? ");
        System.out.println("------------------------------------------------------------------------------------");
        userInput = input.nextLine();
        while (valid.equals(false)) {
            if (userInput.equalsIgnoreCase("vvb") || (userInput.equals("100"))) {
                VVB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("veb") || (userInput.equals("101"))) {
                VEB();
                System.out.println( "------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("apb") || (userInput.equals("102"))) {
                APB();
                System.out.println( "------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("rpb") || (userInput.equals("103"))) {
                RPB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("vps") || (userInput.equals("104"))) {
                VPS(booth);
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("spd") || (userInput.equals("105"))) {
                SPD();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("lpd") || (userInput.equals("106"))) {
                LPD();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("vrv") || (userInput.equals("107"))) {
                VRV();
                System.out.println( "------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("avs") || (userInput.equals("108"))) {
                AVS();
                System.out.println( "------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("ini") || (userInput.equals("169"))) {
                INI(booth);
                System.out.println( "------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            } else if (userInput.equalsIgnoreCase("ext") || (userInput.equals("999"))) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Thank you for using Thulana's Covid Vaccination AI ");
                valid = true;
            } else {
                System.out.println("The code you entered does not match the codes available Please renter");
                userInput = input.nextLine();
            }
        }
    }
}