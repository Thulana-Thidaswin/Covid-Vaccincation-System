import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static int code = 0;
    public static int vStock = 10;
    static Scanner input = new Scanner(System.in);
    static String[] booth = { "Null", "Null", "Null", "Null", "Null", "Null" };
    static File userData = new File("User data.txt");

    /* VVB() is used to check all the booths and see if anyone is inside
    @param boothNumber is used to properly output the booth number as in java the arrays start at 0*/

    public static void VVB() {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            System.out.println("Booth number " + boothNumber + " occupied by " + booth[counter]);
            boothNumber++;
        }
    }
    /* VEB() is used to output if a booth is empty or not ALL the booths are initalized to "null" so equals used to determine */
    public static void VEB() {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            if (booth[counter].equals("Null")){
                System.out.println("Booth Number " + boothNumber + " is Empty");
            } else {
                System.out.println("Booth Number " + boothNumber + " is Occupied");
            }
            boothNumber++;
        }
    }
    /* APB() is used to add a patient into the booth First it outputs all the booth content for the users Convience*/ 
    public static void APB() {
        int boothNumber = 1;
        int editBooth = 0;
        int temp = 0;
        String userInputName = " ";
        System.out.print("The Empty booths are ");
        Boolean valid = false;
        for (int counter = 0; counter < 6; counter++) {
            if (booth[counter].equals("Null")) {
                System.out.print(boothNumber + ", ");
            }
            boothNumber++;
        }
        /* Valid is used until the user has entered a vlaid booth number */
        while (valid.equals(false)) {
            try {
                System.out.println("To which booth would you like to enter a Name?");
                editBooth = Integer.parseInt(input.nextLine());
                temp = editBooth - 1;
                if (booth[temp].equals("Null")) {
                    valid = true;
                } else {
                    System.out.println("Uh-oh the booth you are trying to edit already contains a name");
                    valid = false;
                }
                /* Name is taken into a variable and then input into the array WHILE a stock is removed */
                System.out.println("What is the patient name?");
                userInputName = input.nextLine();
                booth[temp] = userInputName;
                vStock = vStock - 1;
                if (vStock < 20) {
                    System.out.println("VACCINATIONS ARE ALMOST OUT OF STOCK RE-ORDER THEM NOW");
                }
                VVB();

            } catch (Exception e) {
                System.out.println("Please enter a valid number! ");
            }    
        }

    }
    /* RPB is used to remove a booth First user is asked to enter the booth number to empty and then it is initalized to NULL */
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
        /* Valiadtion checks */
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
        booth[temp] = "Null";
        VVB();
    }

    /* Used to check Stock level once it is called */
    public static void VRV() {
        System.out.println("The remaining vaccination stock level is " + vStock);
    }
    /* AVS is used to add stock levels by any user level */
    public static void AVS() {
        int toAdd = 0;
        Boolean valid = false;
        System.out.println("How many vaccinations will you like to add to stock level? ");
        while (valid.equals(false)) {
            try {
                toAdd = Integer.parseInt(input.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
            }
        }
        vStock = vStock + toAdd;
        System.out.println("Vaccinations in stock " + vStock);
    }
    /* THis is used to sort the array so that the Names are in alphabetical order 
    it first takes the Lower case of the booth content and compares to the next booth item in two FOr loops until the whole array 
    array is bubble sorted*/
    public static void VPS(String[] arrayBooth2) {
        String booth[] = {arrayBooth2[0],arrayBooth2[1],arrayBooth2[2],arrayBooth2[3],arrayBooth2[4],arrayBooth2[5]};

        String temp;
        for (int count = 0; count < 6 - 1; count++) {
            for (int count2 = count + 1; count2 < 6; count2++) {
                if (booth[count].toLowerCase().compareTo(booth[count2].toLowerCase()) > 0) {
                    temp = booth[count];
                    booth[count] = booth[count2];
                    booth[count2] = temp;
                }
            }
        }
        /*This just outputs the booth content in the order */
        for (int counter = 0; counter < 6; counter++) {
            System.out.print(booth[counter] + ", ");
        }
    }
    /*Extra fucntion i made to make all the content to NULL */
    public static void INI(String[] booth) {
        for (int count = 0; count < 7 - 1; count++) {
            booth[count] ="Null";
        }
    }

    /* Used to write the content into File */
    public static void SPD() throws IOException {
        FileWriter writeFunc = new FileWriter("User data.txt");
        String temp = " ";
        for (int counter = 0; counter < 6; counter++) {
            temp = booth[counter];
            writeFunc.write(temp + "\n");
        }
        writeFunc.close();
        System.out.println("Wrote it sucessfully :p");
    }

    /*Reads the value of NEXT LINE into a variable and sends it to the booth */
    public static void LPD() throws FileNotFoundException {
        Scanner readFile = new Scanner(userData);
        int counter = 0;
        String temp = " ";
        while (readFile.hasNextLine()) {
            temp = readFile.nextLine();
            booth[counter] = temp;
            counter++;
        }
        readFile.close();
        System.out.println("Files Sucessfully loaded");
        System.out.println("------------------------------------------------------------------------------------");
        VVB();
    }

    

/*Calling of the main program THis will genrate a small Menu and when a user inputs the specific CODE it will 
call that specifc functions to do accordingly. */
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
            if (userInput.equalsIgnoreCase("vvb")||(userInput.equals("100"))) {
                VVB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("veb")||(userInput.equals("101"))) { 
                VEB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("apb")||(userInput.equals("102"))) { 
                APB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("rpb")||(userInput.equals("103"))) { 
                RPB();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("vps")||(userInput.equals("104"))) { 
                VPS(booth);
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("spd")||(userInput.equals("105"))) { 
                SPD();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("lpd")||(userInput.equals("106"))) { 
                LPD();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("vrv")||(userInput.equals("107"))) { 
                VRV();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("avs")||(userInput.equals("108"))) { 
                AVS();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("ini")||(userInput.equals("169"))) { 
                INI(booth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();                             
            }else if (userInput.equalsIgnoreCase("ext")||(userInput.equals("999"))) { 
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Thank you for using Thulana's Covid Vaccination AI ");
                valid = true;       
            } else {
                System.out.println("The code you entered does not match the codes available Please renter");
                System.out.println("Please RE-ENTER the code ");
                userInput = input.nextLine();
            }
        }
    }
}