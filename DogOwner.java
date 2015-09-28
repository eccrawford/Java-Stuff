public class DogOwner {
    private String ownerName;
    private int smallDogs;
    private int largeDogs;
    private String timeOfDay;
   
   // Constructor that takes a new dog owner and validates input
   // precondition: a dog owner's potential information has been passed
   // postcondition: the new dog owner's name has been validate
   public DogOwner(String name, int small, int large, String time) {
        ownerName = name;
        smallDogs = small;
        largeDogs = large;
        timeOfDay = time;
        
        if (smallDogs < 0) {
            System.out.println("You cannot have a negative number of small dogs for " + ownerName);
            smallDogs = 0;
        }
        if (largeDogs < 0) {
            System.out.println("You cannot have a negative number of large dogs for " + ownerName);
            largeDogs = 0;
        }
        if (!timeOfDay.equalsIgnoreCase("morning") && !timeOfDay.equalsIgnoreCase("afternoon") 
            && !timeOfDay.equalsIgnoreCase("evening")) {
                System.out.println("'" + timeOfDay + "'" + 
                " is not a valid time of day, changing to 'morning'");
                timeOfDay = "morning";
        }
                
   }

   // Adds a dog to an owner
   // precondition: a small or large dog needs to be added
   // postcondition: a small or large dog has been added
   public void addDog(boolean dog) {
        if (dog == true) 
            largeDogs++;
        else 
            smallDogs++;
   }

   // Subtracts either a small or large dog from an owner
   // precondition: a small or large dog needs to be subtracted
   // postcondition: a small or large dog has been subtracted
   public void subtractDog(boolean dog) { 
        if (dog == true) {
            if (largeDogs > 0) {
                largeDogs--;
            }
            else { // less than 0 large dogs
                System.out.println("You cannot have a negative amount of large dogs!");
                largeDogs = 0;
            }
        }
        else {
            if (smallDogs > 0) {
                smallDogs--;
            }
            else { // less than 0 small dogs
                System.out.println("You cannot have a negative amount of small dogs!");
                smallDogs = 0;
            }
        }
   }
   
   // Tests for matching dog owners
   // precondition: a dog owner parameter has been passed
   // postcondition: Either a certain dog owner matches the conditions (true) or it does not (false)
   public boolean match(DogOwner name) {
        // total number of dogs cannot be more than 5
        // must have same time of day
        // an owner with small dogs but no large dogs cannot be matched with an owner who has a large dog
        if (this.smallDogs + this.largeDogs + name.smallDogs + name.largeDogs > 5) {
            return false;
        }
        else if (!this.timeOfDay.equals(name.timeOfDay)) {
            return false;
        }
        else if (this.smallDogs > 0 && this.largeDogs == 0 && name.largeDogs >= 1 ||
                 name.smallDogs > 0 && name.largeDogs ==0 && this.largeDogs >= 1) {
            return false;
        }
        return true;
   }
   
   // Prints a list of compatible dog owners
   // precondition: an array of dog owners has been passed
   // postcondition: a list of matching dog owners has been printed 
      public static void printMatches(DogOwner name[]) {
        System.out.println("Dog-walking Matches: ");
        int number = 1;
        for (int i=0; i <= name.length; i++) { // goes through the array of dog owners
            for (int j=i+1; j <= name.length-1; j++) { // goes through remaining dog owners
                if (name[i].match(name[j])) {
                    System.out.println(number + ". " + name[i].toString() + " and " + name[j].toString());
                    number++;
                }
            }    
        }
   }
  
   // Displays the dog owner information in a correct grammatical format
   // precondition: a legal dog owner has been defined
   // postcondition: the dog owner's information has been displayed
   public String toString() {
        if (this.getSmallDogs() == 1 && this.getLargeDogs() == 1) {
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dog" + ", "
            + this.getLargeDogs() + " large dog" + ")";
        }
        else if (this.getSmallDogs() == 1 && this.getLargeDogs() >= 0) {
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dog" + ", "
            + this.getLargeDogs() + " large dogs" + ")";
        }
        else if (this.getLargeDogs() == 1 && this.getSmallDogs() >= 0) {
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dogs" + ", " 
            + this.getLargeDogs() + " large dog" + ")";
        }
        else if (this.getSmallDogs() == 0 && this.getLargeDogs() > 1) {
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dogs" 
            + ", "+ this.getLargeDogs() + " large dogs" + ")";

        }
        else if (this.getSmallDogs() > 1 && this.getLargeDogs() == 0){
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dogs" 
            + ", "+ this.getLargeDogs() + " large dogs" + ")";
        }
        else // 0 small dogs and 0 large dogs
            return this.getOwnerName() + "(" + timeOfDay + ", " + this.getSmallDogs() + " small dogs" 
            + ", "+ this.getLargeDogs() + " large dogs" + ")";
   }
   
   // A series of get methods to assist the toString method
   private String getOwnerName() {
        return ownerName;
   }
    
   private int getSmallDogs() {
        return smallDogs;
   }
    
   private int getLargeDogs() {
        return largeDogs;
   }
    
   private String getDayTime() {
        return timeOfDay;
   }
}