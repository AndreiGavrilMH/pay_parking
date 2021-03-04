import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Actions actions = new Actions();
        Integer instruction;
        String carNumber;

        System.out.println("Please enter the instruction \n 1 - See available parking seats \n 2 - Add car to parking space" +
                "\n 3 - See parked cars \n 4 - Exit the parking spot \n 5 - Check time for a car");
        instruction = scanner.nextInt();

        while(instruction != 6) {

            switch (instruction) {
                case 1:
                    actions.seeAvailableParkingSpots();
                    break;
                case 2:
                    System.out.println("Please enter a car number");
                    carNumber = scanner.next();
                    actions.addNewCarToParkingPlace(carNumber);
                    break;
                case 3:
                    actions.seeParkedCars();
                    break;
                case 4:
                    System.out.println("Please enter a car number");
                    carNumber = scanner.next();
                    actions.getCarOut(carNumber);
                    break;
                case 5:
                    System.out.println("Please enter a car number");
                    carNumber = scanner.next();
                    actions.checkTimeForCar(carNumber);
                    break;
            }

            System.out.println("Thank you for using our app \n Would you like to use another instruction?");
            instruction = scanner.nextInt();


        }
    }
}
