import exceptions.InvalidCarNumberException;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Actions {
    ParkingSpace ps = new ParkingSpace();

    public void seeAvailableParkingSpots(){
        System.out.println("Available parking spots: " + (10-ps.parkingSpace.size()));
    }

    public void addNewCarToParkingPlace(String carNumber){
        if(ps.parkingSpace.contains(carNumber.toUpperCase())){
            System.out.println("The car is already in the parking lot");
        } else if(carNumber.equals("")){ //se verifica daca s-au introdus date
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("Please enter a car number");
        }else if(carNumber.toLowerCase().charAt(0) == 'b' ) {       //daca numarul nu incepe cu 'B', lungimea stringului variaza intre 6,7 caractere
            if (carNumber.length() < 6 || carNumber.length() > 7) {
                //Runtime.getRuntime().exec(ps.windowsClearConsole);
                System.out.println("Enter a valid car number between 7 or 8 characters");
            }else if(ps.parkingSpace.size() < 10){
                LocalTime initialTime = LocalTime.now();
                ps.parkingSpace.add(carNumber.toUpperCase());
                ps.timeForCars.add(initialTime);
            } else {
                //Runtime.getRuntime().exec(ps.windowsClearConsole);
                System.out.println("The parking is full");
            }
        }else if (carNumber.length() < 7 || carNumber.length() > 8 ){
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("Enter a valid car number between 6 or 7 characters");
        } else if(ps.parkingSpace.size() < 10){
            LocalTime initialTime = LocalTime.now();
            ps.parkingSpace.add(carNumber.toUpperCase());
            ps.timeForCars.add(initialTime);
        } else {
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("The parking is full");
        }

    }

    public void seeParkedCars(){
        if(ps.parkingSpace.isEmpty()){
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("The parking lot is empty");
        }else{
            System.out.println("Car parked:");
            for(String s : ps.parkingSpace){
                System.out.println(ps.parkingSpace.indexOf(s) + 1 + " - " + s);
            }
        }
    }

    public void checkTimeForCar(String carNumber){
        if(ps.parkingSpace.contains(carNumber.toUpperCase())){
            int indexOfCar = ps.parkingSpace.indexOf(carNumber.toUpperCase());
            LocalTime timeForCar = ps.timeForCars.get(indexOfCar);
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("Time spent in the parking spot is: " + ChronoUnit.MINUTES.between(timeForCar, LocalTime.now()) + " hours and " + ChronoUnit.SECONDS.between(timeForCar, LocalTime.now()) + " minutes");
        }else{
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("There is no car with that number in the parking lot");
        }
    }

    public void getCarOut(String carNumber){
        if(ps.parkingSpace.contains(carNumber.toUpperCase())){
            int indexOfCar = ps.parkingSpace.indexOf(carNumber.toUpperCase());
            LocalTime timeForCar = ps.timeForCars.get(indexOfCar);
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            parkingTicket(timeForCar, LocalTime.now());
            System.out.println("Time spent in the parking spot is: " + ChronoUnit.MINUTES.between(timeForCar, LocalTime.now()) + " hours and " + ChronoUnit.SECONDS.between(timeForCar, LocalTime.now()) + " minutes");
            ps.parkingSpace.remove(indexOfCar);
        }else{
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("There is no car with that number in the parking lot");
        }
    }

    public void parkingTicket(LocalTime time1, LocalTime time2){
        if (ChronoUnit.MINUTES.between(time1, time2) < 1){
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("You have to pay: 10 lei");
        } else if (ChronoUnit.MINUTES.between(time1, time2) > 1){
            //Runtime.getRuntime().exec(ps.windowsClearConsole);
            System.out.println("You have to pay: " + (10 + 5*(ChronoUnit.MINUTES.between(time1, time2))));
        }
    }


}

