import java.util.Scanner;

public class VaccinationCenter {
    static Scanner input = new Scanner(System.in);

    void VRV(int vStock) {
        System.out.println("The remaining vaccination stock level is " + vStock);
    }

    void AVS(int vStock) {
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

}