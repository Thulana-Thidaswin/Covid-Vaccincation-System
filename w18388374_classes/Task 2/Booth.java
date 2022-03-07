import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Booth {
    static Scanner input = new Scanner(System.in);
    File userData = new File("User data.txt");
    String name="Null";
    static int vStock=20;
    static String boothnumber;

    public Booth(String name) {
        this.name = name;
      }
   
    public Booth() {
    }
    /* All the functions set to be in the Booth from the task 1 and is called in the main program */
    void VVB(Booth[] arrayBooth) {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            System.out.println("Booth number " + boothNumber + " occupied by " + arrayBooth[counter].name);
            boothNumber++;
        }
    }
    void VEB(Booth[] arrayBooth) {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            if ((arrayBooth[counter].name).equals("Null")){
                System.out.println("Booth Number " + boothNumber + " is Empty");
            } else {
                System.out.println("Booth Number " + boothNumber + " is Occupied");
            }
            boothNumber++;
        }
    }
    void APB(Booth[] arrayBooth) {
        int boothNumber = 1;
        int editBooth = 0;
        int temp = 0;
        String userInputName = " ";
        System.out.print("The Empty booths are ");
        Boolean valid = false;
        for (int counter = 0; counter < 6; counter++) {
            if ((arrayBooth[counter].name).equals("Null")) {
                System.out.print(boothNumber + ", ");
            }
            boothNumber++;
        }
        while (valid.equals(false)) {
            try {
                System.out.println("To which booth would you like to enter a Name?");
                editBooth = Integer.parseInt(input.nextLine());
                temp = editBooth - 1;
                if (arrayBooth[temp].name.equals("Null")) {
                    valid = true;
                } else {
                    System.out.println("Uh-oh the booth you are trying to edit already contains a name");
                    valid = false;
                }
                System.out.println("What is the patient name?");
                userInputName = input.nextLine();
                arrayBooth[temp].name = userInputName;
                vStock = vStock - 1;
                if (vStock < 20) {
                    System.out.println("VACCINATIONS ARE ALMOST OUT OF STOCK RE-ORDER THEM NOW");
                }
                VVB(arrayBooth);

            } catch (Exception e) {
                System.out.println("Please enter a valid number! ");
            }    
        }

    }
    void RPB(Booth[] arrayBooth) {
        int boothNumber = 1;
        int editBooth = 0;
        int temp = 0;
        System.out.print("The Ocupied booths are ");
        Boolean valid = false;
        for (int counter = 0; counter < 6; counter++) {
            if (arrayBooth[counter].name != "Null") {
                System.out.print(boothNumber + ", ");
            }
            boothNumber++;
        }
        while (valid.equals(false)) {
            try {
                System.out.println("Which booth would you like to clear?");
                editBooth = Integer.parseInt(input.nextLine());
                temp = editBooth - 1;
                if (arrayBooth[temp].name != "Null") {
                    valid = true;
                } else {
                    System.out.println("Uh-oh the booth you are trying to remove is empty");
                    valid = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid Booth number! ");
            }
        }
        arrayBooth[temp].name = "Null";
        VVB(arrayBooth);
    }
    
    void VPS(Booth[] arrayBooth2) {
        String temp;
        Booth arrayBooth[] = {arrayBooth2[0],arrayBooth2[1],arrayBooth2[2],arrayBooth2[3],arrayBooth2[4],arrayBooth2[5]};

        /*Have two for loops, first is count and second loop is count2, total iterations is n^2 or 36.
        First we take booth from array booth at index count, we take the name member vraible , convert it to lowercase and compare 
        it to the lower case of name member varibale of booth at index count2. IF the LHS name > RHS name,we swap the two using temp if not we 
        continue  */
        for (int count = 0; count < 6 - 1; count++) {
            for (int count2 = count + 1; count2 < 6; count2++) {
                if ((arrayBooth[count].name).toLowerCase().compareTo((arrayBooth[count2].name).toLowerCase()) > 0) {
                    temp = arrayBooth[count].name;
                    arrayBooth[count].name = arrayBooth[count2].name;
                    arrayBooth[count2].name = temp;
                }
            }
        }
        for (int counter = 0; counter < 6; counter++) {
            System.out.print(arrayBooth[counter].name + ", ");
        }
    }
    void SPD(Booth[] arrayBooth) throws IOException {
        FileWriter writeFunc = new FileWriter("User data.txt");
        String temp = " ";
        for (int counter = 0; counter < 6; counter++) {
            temp = arrayBooth[counter].name;
            writeFunc.write(temp + "\n");
        }
        writeFunc.close();
        System.out.println("Wrote it sucessfully :p");
    }

     void LPD(Booth[] arrayBooth) throws FileNotFoundException {
        Scanner readFile = new Scanner(userData);
        int counter = 0;
        String temp = " ";
        while (readFile.hasNextLine()) {
            temp = readFile.nextLine();
            arrayBooth[counter].name = temp;
            counter++;
        }
        readFile.close();
        System.out.println("Files Sucessfully loaded");
        System.out.println("------------------------------------------------------------------------------------");
        VVB(arrayBooth);
    }
}    
