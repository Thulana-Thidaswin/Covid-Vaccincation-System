import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Booth {
    static Scanner input = new Scanner(System.in);
    File userData = new File("User data.txt");
    String name = " ";
    String age = " ";
    String city = " ";
    String nIC = " ";
    String sName = " ";
    String vACC = " ";
    static int vStock = 20;
    static String boothnumber;

    public Booth(String name, String age, String city, String nIC, String sName, String vACC) {
        this.name = name;
        this.sName = sName;
        this.age = age;
        this.city = city;
        this.nIC = nIC;
        this.vACC = vACC;
    }

    public Booth() {

    }

    public Booth(String name2, int counter, Object city2, Object nIC2, Object sName2) {
    }

    void VVB(Patient[] arrayBooth) {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            System.out.println("Booth number " + boothNumber + " occupied by " + arrayBooth[counter].getname() + " "
                    + arrayBooth[counter].getSname());
            boothNumber++;
        }
    }

    void VEB(Patient[] arrayBooth) {
        int boothNumber = 1;
        for (int counter = 0; counter < 6; counter++) {
            if ((arrayBooth[counter].getname()).equals(" ")) {
                System.out.println("Booth Number " + boothNumber + " is Empty");
            } else {
                System.out.println("Booth Number " + boothNumber + " is Occupied");
            }
            boothNumber++;
        }
    }

    /**
     * 
     * @param pWRoom Linked list for pfizer
     * @param sWRoom Linked list for sinopharm
     * @param aWRoom Linked list for AstraZeneca
     */
    void APB(Patient[] arrayBooth, LinkedList<String> pWRoom, LinkedList<String> sWRoom, LinkedList<String> aWRoom) {
        int inputAge =0;
        String userInputName = " ";
        String inputCity = " ";
        String inputNIC = " ";
        String userSName = " ";
        Boolean valid = false;
        Boolean valid2 = false;
        String vType = " ";
        int vNumber = 0;

        System.out.println("What is the patient's Firstname?");
        userInputName = input.nextLine();
        System.out.println("What is the patient Surname?");
        userSName = input.nextLine();
        System.out.println("What is the patient's Age");
        while (valid.equals(false)) {
            try {
                inputAge = Integer.parseInt(input.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
            }
        }
        System.out.println("Enter the patient's City'");
        inputCity = input.nextLine();
        System.out.println("Enter the Patient NIC ");
        inputNIC = input.nextLine();
        System.out.println("What is the Vaccination type?");
        System.out.println("Enter 1 for AstraZeneca 2 for Sinopharm and 3 for Pfizer");
        vNumber = Integer.parseInt(input.nextLine());
        while (valid2.equals(false)) {
            try {
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
                    vNumber = Integer.parseInt(input.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
            }
        }
        /*
         * IF booth number 0 and 1 is not null THEN all the data is added into a linked
         * list in the same way it was written to the file
         */
        if (vNumber == 1) {
            if ((arrayBooth[0].getname()).equals(" ")) {
                arrayBooth[0].setname(userInputName);
                arrayBooth[0].setSname(userSName);
                arrayBooth[0].setage(String.valueOf(inputAge));
                arrayBooth[0].setcity(inputCity);
                arrayBooth[0].setnic(inputNIC);
                arrayBooth[0].setvacc(vType);
                vStock = vStock - 1;
            } else if ((arrayBooth[1].getname()).equals(" ")) {
                arrayBooth[1].setname(userInputName);
                arrayBooth[1].setSname(userSName);
                arrayBooth[1].setage(String.valueOf(inputAge));
                arrayBooth[1].setcity(inputCity);
                arrayBooth[1].setnic(inputNIC);
                arrayBooth[1].setvacc(vType);
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for AstraZeneca is Full at the moment");
                System.out.println("You have been added to the waiting Room");
                aWRoom.add(userInputName + "!" + userSName + "@" + inputAge + "#" + inputCity + "$" + inputNIC + "%");

            }
        } else if (vNumber == 2) {
            if ((arrayBooth[2].getname()).equals(" ")) {
                arrayBooth[2].setname(userInputName);
                arrayBooth[2].setSname(userSName);
                arrayBooth[2].setage(String.valueOf(inputAge));
                arrayBooth[2].setcity(inputCity);
                arrayBooth[2].setnic(inputNIC);
                arrayBooth[2].setvacc(vType);
                vStock = vStock - 1;
            } else if ((arrayBooth[1].getname()).equals(" ")) {
                arrayBooth[3].setname(userInputName);
                arrayBooth[3].setSname(userSName);
                arrayBooth[3].setage(String.valueOf(inputAge));
                arrayBooth[3].setcity(inputCity);
                arrayBooth[3].setnic(inputNIC);
                arrayBooth[3].setvacc(vType);
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for Sinopharm is Full at the moment");
                System.out.println("You have been added to the waiting Room");
                sWRoom.add(userInputName + "!" + userSName + "@" + inputAge + "#" + inputCity + "$" + inputNIC + "%");
            }

        } else if (vNumber == 3) {
            if ((arrayBooth[4].getname()).equals(" ")) {
                arrayBooth[4].setname(userInputName);
                arrayBooth[4].setSname(userSName);
                arrayBooth[4].setage(String.valueOf(inputAge));
                arrayBooth[4].setcity(inputCity);
                arrayBooth[4].setnic(inputNIC);
                arrayBooth[4].setvacc(vType);
                vStock = vStock - 1;
            } else if ((arrayBooth[1].getname()).equals(" ")) {
                arrayBooth[5].setname(userInputName);
                arrayBooth[5].setSname(userSName);
                arrayBooth[5].setage(String.valueOf(inputAge));
                arrayBooth[5].setcity(inputCity);
                arrayBooth[5].setnic(inputNIC);
                arrayBooth[5].setvacc(vType);
                vStock = vStock - 1;
            } else {
                System.out.println("The booths for Phizer is Full at the moment");
                System.out.println("You have been added to the waiting Room");
                pWRoom.add(userInputName + "!" + userSName + "@" + inputAge + "#" + inputCity + "$" + inputNIC + "%");
            }

        }
        VVB(arrayBooth);

    }

    void RPB(Patient[] arrayBooth, LinkedList<String> pWRoom, LinkedList<String> sWRoom, LinkedList<String> aWRoom) {
        int boothNumber = 1;
        int editBooth = 0;
        int temp = 0;
        String waitingTemp = " ";
        int linepos1 = 0;
        int linepos2 = 0;
        System.out.print("The Ocupied booths are ");
        Boolean valid = false;
        for (int counter = 0; counter < 6; counter++) {
            if (!arrayBooth[counter].getname().equals(" ")) {
                System.out.print(boothNumber + ", ");
            }
            boothNumber++;
        }
        while (valid.equals(false)) {
            try {
                System.out.println("Which booth would you like to clear?");
                editBooth = Integer.parseInt(input.nextLine());
                temp = editBooth - 1;
                if (!arrayBooth[temp].getname().equals(" ")) {
                    valid = true;
                } else {
                    System.out.println("Uh-oh the booth you are trying to remove is empty");
                    valid = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid Booth number! ");
            }
        }
        arrayBooth[temp].setname(" ");
        arrayBooth[temp].setSname(" ");
        arrayBooth[temp].setage(" ");
        arrayBooth[temp].setcity(" ");
        arrayBooth[temp].setnic(" ");
        arrayBooth[temp].setVac(" ");

        if (((temp == (0) || (temp == 1)) & (waitingTemp.equals(" ")))) {
            if (!aWRoom.isEmpty()) {
                waitingTemp = aWRoom.getFirst();
                aWRoom.removeFirst();
                linepos2 = waitingTemp.indexOf("!");
                arrayBooth[temp].setname(waitingTemp.substring(0, linepos2));
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("@");
                arrayBooth[temp].setSname(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("#");
                arrayBooth[temp].setage(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("$");
                arrayBooth[temp].setcity(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("%");
                arrayBooth[temp].setnic(waitingTemp.substring(linepos1, linepos2));
            }
        } else if (((temp == (2) || (temp == 3)) & (waitingTemp.equals(" ")))) {
            if (!sWRoom.isEmpty()) {
                waitingTemp = sWRoom.getFirst();
                sWRoom.removeFirst();
                linepos2 = waitingTemp.indexOf("!");
                arrayBooth[temp].setname(waitingTemp.substring(linepos1, linepos2));
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("@");
                arrayBooth[temp].setSname(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("#");
                arrayBooth[temp].setage(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("$");
                arrayBooth[temp].setcity(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("%");
                arrayBooth[temp].setnic(waitingTemp.substring(linepos1, linepos2));
            }
        } else if (((temp == (4) || (temp == 5)) & (waitingTemp.equals(" ")))) {
            if (!pWRoom.isEmpty()) {
                waitingTemp = pWRoom.getFirst();
                pWRoom.removeFirst();
                linepos2 = waitingTemp.indexOf("!");
                arrayBooth[temp].setname(waitingTemp.substring(linepos1, linepos2));
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("@");
                arrayBooth[temp].setSname(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("#");
                arrayBooth[temp].setage(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("$");
                arrayBooth[temp].setcity(waitingTemp.substring(linepos1, linepos2));
                linepos1 = 0;
                linepos1 = linepos2 + 1;
                linepos2 = 0;
                linepos2 = waitingTemp.indexOf("%");
                arrayBooth[temp].setnic(waitingTemp.substring(linepos1, linepos2));
            }
        }
        VVB(arrayBooth);
    }

    void VPS(Patient[] arrayBooth2) {
        Patient arrayBooth[] = {arrayBooth2[0],arrayBooth2[1],arrayBooth2[2],arrayBooth2[3],arrayBooth2[4],arrayBooth2[5]};
        String temp;
        for (int count = 0; count < 6 - 1; count++) {
            for (int count2 = count + 1; count2 < 6; count2++) {
                if ((arrayBooth[count].getname()).toLowerCase()
                        .compareTo((arrayBooth[count2].getname()).toLowerCase()) > 0) {
                    temp = arrayBooth[count].getname();
                    arrayBooth[count].setname(arrayBooth[count2].getname());
                    arrayBooth[count2].setname(temp);
                }
            }
        }
        for (int counter = 0; counter < 6; counter++) {
            System.out.print(arrayBooth[counter].getname() + ", ");
        }
    }

    void SPD(Patient[] arrayBooth) throws IOException {
        FileWriter writeFunc = new FileWriter("User data.txt");
        String temp = " ";
        for (int counter = 0; counter < 6; counter++) {
            temp = ((arrayBooth[counter].getname()) + "!" + (arrayBooth[counter].getSname()) + "@"
                    + (arrayBooth[counter].getage()) + "#" + (arrayBooth[counter].getcity()) + "$"
                    + (arrayBooth[counter].getnic() + "%" + (arrayBooth[counter].getVac()) + "^"));
            writeFunc.write(temp + "\n");
        }
        writeFunc.close();
        System.out.println("Wrote it sucessfully :p");
    }

    void LPD(Patient[] arrayBooth) throws FileNotFoundException {
        Scanner readFile = new Scanner(userData);
        int counter = 0;
        String firstName = " ";
        String secondName = " ";
        String fileAge = " ";
        String fileCity = " ";
        String fileNic = " ";
        String fileVac = " ";
        String temp = " ";
        int linepos1 = 0;
        int linepos2 = 0;
        int lineLength = 0;
        while (readFile.hasNextLine()) {
            temp = readFile.nextLine();
            lineLength = temp.length();
            linepos2 = temp.indexOf("!");
            firstName = temp.substring(0, linepos2);
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("@");
            secondName = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("#");
            fileAge = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("$");
            fileCity = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("%");
            fileNic = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("^");
            fileVac = temp.substring(linepos1, linepos2);
            arrayBooth[counter].setname(firstName);
            arrayBooth[counter].setSname(secondName);
            arrayBooth[counter].setage(fileAge);
            arrayBooth[counter].setcity(fileCity);
            arrayBooth[counter].setnic(fileNic);
            arrayBooth[counter].setVac(fileVac);
            counter++;
        }
        readFile.close();
        System.out.println("Files Sucessfully loaded");
        System.out.println("------------------------------------------------------------------------------------");
        VVB(arrayBooth);
    }
}
