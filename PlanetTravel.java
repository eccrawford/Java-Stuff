/* This program calculates and displays the different ages and planets of a person on either 
Mercury, Venus, Jupiter, or Saturn */

import java.util.Scanner;
import java.lang.Math;
public class PlanetTravel {
    // precondition: 
    public static void main(String[] args) {
        String answer = "y"; // makes the program run for the first time
     
        while (answer.equalsIgnoreCase("y") == true) {
        // Declares variables and prompts the user for their name/age/weight/destination
            Scanner input = new Scanner(System.in);
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Age (in Earth years): ");
            int age;
        if (!input.hasNextInt()) { // error checks for the age
            System.out.println("Incorrect age. Program abort.");
            System.exit(1);
            age = 0;
        }
        else
            age = input.nextInt();
            
            System.out.print("Weight (on Earth): ");
            double weight;
        if (!input.hasNextDouble()) { // error checks for the weight
            System.out.println("Incorrect weight. Program abort.");
            System.exit(1);
            weight = 0;
        }
        else
            weight = input.nextDouble();
            
            System.out.print("Destination (Mercury, Venus, Jupiter, Saturn): ");
            String planet = input.next();
        // error checks for an incorrect planet input
        // prompts the user for an acceptable planet
        while (planet.equalsIgnoreCase("mercury") == false && planet.equalsIgnoreCase("venus") == false && 
               planet.equalsIgnoreCase("jupiter") == false && planet.equalsIgnoreCase("saturn") == false) {
            System.out.println("I do not recognise that planet name.  Please try again.");
            System.out.print("Destination (Mercury, Venus, Jupiter, Saturn): " );
            planet = input.next();
        }
        // if an acceptable planet is typed, this carries out calculating the user's age and weight on selected planet
        if (planet.equalsIgnoreCase("mercury") == true || planet.equalsIgnoreCase("venus") == true || 
            planet.equalsIgnoreCase("jupiter") == true || planet.equalsIgnoreCase("saturn") == true) {
            double theWeight = calculateWeight(weight, planet);
            int theAge = calculateAge(age, planet);
            System.out.println("On " + planet + ", " + name + " will be " + theAge + 
                                " years old and will weigh " + theWeight + " kilos");
            System.out.print("Another query? (Y or N): "); // checks if the user wishes to add another entry
            answer = input.next();
        }
        // error checks in case the user does not properly answer yes or no to entering another query
         while (answer.equalsIgnoreCase("n") == false && (answer.equalsIgnoreCase("y") == false)) {
            System.out.println("Please answer with y or n");
            answer = input.next();
        }
      }
      System.out.println("End of Execution"); // executes if the user indicates they do not wish to add another entry
    }
    
    // Determine's the user's inputted weight on a selected planet
    // precondition: an acceptable weight and planet has been passed to the method
    // postcondition: the user's weight on selected planet has been returned
    public static double calculateWeight(double weight, String planet) {
        Scanner input = new Scanner(System.in);
        final double MERCURY_WEIGHT = 0.4;
        final double VENUS_WEIGHT = 0.9;
        final double JUPITER_WEIGHT = 2.5;
        final double SATURN_WEIGHT = 1.1;
        double newWeight = 0.0;
        
        if (planet.equalsIgnoreCase("mercury")) {
            newWeight = weight * MERCURY_WEIGHT;
            newWeight = Math.round(newWeight * 100.0)/100.0;
        }
        else if (planet.equalsIgnoreCase("venus")) {
            newWeight = weight * VENUS_WEIGHT;
            newWeight = Math.round(newWeight * 100.0)/100.0;
        }
        else if (planet.equalsIgnoreCase("jupiter")) {
            newWeight = weight * JUPITER_WEIGHT;
            newWeight = Math.round(newWeight * 100.0)/100.0;
        }
        else if (planet.equalsIgnoreCase("saturn")) {
            newWeight = weight * SATURN_WEIGHT;
            newWeight = Math.round(newWeight * 100.0)/100.0;
        }
        return newWeight;
    }
    
    // Determine's the user's inputted age on a selected planet
    // precondition: an acceptable age and planet has been passed to the method
    // postcondition: the user's weight on a selected planet has been returned
    public static int calculateAge(int age, String planet) {
        final int MERCURY_DAYS = 88;
        final int VENUS_DAYS = 225;
        final int JUPITER_DAYS = 4380;
        final int SATURN_DAYS = 11767;
        final int EARTH_DAYS = 365;
        double ageDays = age * EARTH_DAYS;
        double newAge = 0;
        
        if (planet.equalsIgnoreCase("mercury")) 
            newAge = Math.round(ageDays / MERCURY_DAYS);
        
        if (planet.equalsIgnoreCase("venus")) 
            newAge = Math.round(ageDays / VENUS_DAYS);
        
        if (planet.equalsIgnoreCase("jupiter")) 
            newAge = Math.round(ageDays / JUPITER_DAYS);
        
        if (planet.equalsIgnoreCase("saturn")) 
            newAge = Math.round(ageDays / SATURN_DAYS);
        
        return (int)newAge;
    }
}