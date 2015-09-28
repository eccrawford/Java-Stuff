//This program performs transformations on two dimensional arrays such as
//rotating them CCW and CW, and flipping horizontally and vertically
 
public class ArrayTransformations {
    // This method flips an array horizontally
    // precondition: a two dimensional array has been passed
    // postcondition: the array has been flipped horizontally
    public static void horizontalFlip(int matrix[][]) { 
      for (int row = 0; row < matrix.length; row ++) {
          for (int column = 0; column < (matrix[0].length / 2); column++) { 
              // divides by 2 to ensure that the array doesn't flip back again, aka no change
              int tempArray = matrix[row][column]; // temporarily holds the array
              matrix[row][column] = matrix[row][matrix[0].length - column - 1]; // flips the array
              matrix[row][matrix[0].length - column - 1] = tempArray;
          }
      }
    }
    
    // This method flips an array vertically
    // precondition: a two dimensional array has been passed
    // postcondition: the array has been flipped vertically
    public static void verticalFlip(int matrix[][]) { 
        for (int row = 0; row < (matrix.length / 2); row++) {
            // divides by 2 to ensure the array doesn't flip back again
            int[] tempArray = matrix[row]; //temporarily holds the array
            matrix[row] = matrix[matrix.length - row - 1]; // flips the array
            matrix[matrix.length - row - 1] = tempArray;
        }
    }
    
    // This method rotates an array 90 degrees clockwise
    // precondition: a two dimensional array has been passed
    // postcondition: the array has been rotated 90 degrees CW
    public static int[][] rotateRight(int matrix[][]) { 
        verticalFlip(matrix); // flips the matrix so that it will rotate properly
        int[][] newArray = new int[matrix[0].length][matrix.length];
        // the columns become the new rows, and the rows become the new columns
        for (int row = 0; row < matrix[0].length; row++) {
            for (int column = matrix.length-1; column >= 0; column--) {
                newArray[row][column] = matrix[column][row];
            }
        }
        return newArray;
    }
    
    // This method rotates an array 90 degrees counterclockwise
    // precondition: a two dimensional array has been passed
    // postcondition: the array has been rotated 90 degrees CCW
    public static int[][] rotateLeft(int matrix[][]) {
        horizontalFlip(matrix); // flips the matrix so it will rotate properly
        int[][] newArray = new int[matrix[0].length][matrix.length];
        // the last column becomes the first row
        for (int row = matrix[0].length - 1; row >= 0; row--) {
            for (int column = 0; column < matrix.length; column++) {
                newArray[row][column] = matrix[column][row];
            }
        }
        return newArray;
    }
}