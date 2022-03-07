import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Task3B{
    static Scanner input = new Scanner(System.in);
    static Booth booth = new Booth(null, null, null, null, null, null);
    static VaccinationCenter  center = new VaccinationCenter();
    public static int vStock = 10;
    static File userData = new File("User data.txt");
    public static Patient arrayBooth[] = {new Patient(),new Patient(),new Patient(),new Patient(),new Patient(),new Patient()};
    /*array of patient objects here */
    public static void main(String[] args) throws IOException{
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
                booth.VVB(arrayBooth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("veb")||(userInput.equals("101"))) { 
                booth.VEB(arrayBooth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("apb")||(userInput.equals("102"))) { 
                booth.APB(arrayBooth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();          
            }else if (userInput.equalsIgnoreCase("rpb")||(userInput.equals("103"))) { 
                booth.RPB(arrayBooth); 
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("vps")||(userInput.equals("104"))) { 
                booth.VPS(arrayBooth);
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("spd")||(userInput.equals("105"))) { 
                booth.SPD(arrayBooth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("lpd")||(userInput.equals("106"))) { 
                booth.LPD(arrayBooth);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("vrv")||(userInput.equals("107"))) { 
                center.VRV(vStock);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("If you wish to continue operations enter a code If not 999 or EXT to exit ");
                userInput = input.nextLine();
            }else if (userInput.equalsIgnoreCase("avs")||(userInput.equals("108"))) { 
                center.AVS(vStock);
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