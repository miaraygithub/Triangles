import java.util.Locale;
import java.util.Scanner; //gotta get those scanner objects!
public class Triangles { //class that has all our stuff
    public static int checkSize() { //function to get row size and make sure it's okay.
        int tSize = 0; //since variables are local we have to have a variable to store the size in here and under main (initalized to 0 for the return function, this will get overriden)
        boolean okay = false; //we'll loop over this until a correct size is entered. false to start the loop
        Scanner sc = new Scanner(System.in); //again scanners are local so we need sc here and under main
        while (!okay) { //we'll only break out of this loop if the number is okay
            System.out.println("Enter size: "); //prompt user for triangle size
            tSize = sc.nextInt(); //stor size in tSize
            if ((tSize <= 50) && (tSize >= 1)) { //check to see if tSize is in range
                break; // if it is, get out of the while so we don't print the error message for a good number
            }
            System.out.println("Size must be between 1-50!"); //if it's not, print error and the loop goes again
        }
        return tSize; //we're out of the loop so we know the number is okay, we just need to return it
    }
    public static void printTriangle(int tSize, String tFill) { //method to draw the triangles. we need the size and fill as inputs
        int row = 1; //we start on row 1 (the minimum number of triangle rows)
        while (row <= tSize) { //this loop will iterate over row until the triangle is the correct size
            int spacesLeft = (tSize - 1); //the bottom of the triangle will have 2*tSize characters, so we want our first row to be half that length, and we're adding a letter at the end of row 1
            while (spacesLeft >= row) { //each row needs less and less spaces so the triangle stays centere (n-1 for 1, n-2 for 2, n-3 for 3, ... n-m (0) for row n
                System.out.print(" "); //add a space to the line
                spacesLeft--; //decrease spaces
            }
            int k = 1; //we're going to iterate over this for printing the right number of objects per row
            while (k <= row) { //row 1 needs 1, row 2 needs 2, etc. we only want to print the number of objects equal to the row number
                System.out.print(tFill + " "); //add a character (and it's space) to the line
                k++; //increase k
            }
            System.out.println(); //finish off the line we've been building
            row++; //move on to the next row
        }
    }
    public static void main(String[] args){ //Setting up our main method
        int tSize; //initializing the size to store in later
        String tFill; //initalizing the fill to store in later
        String again = "y"; //we start out wanting a triangle, we'll iterate until this is "n"
        Scanner sc = new Scanner(System.in); //create new scanner object
        while (again.equals("y")) { //until we dont want another traingle, we're gonna make one
            tSize = checkSize(); //call checksize so we know that tSize is between 1-50
            System.out.println("Enter fill: "); //prompt user for fill
            tFill = String.valueOf(sc.next().charAt(0)); //grab the first character of the next input (as a string to print)
            printTriangle(tSize, tFill); //make the triangle
            System.out.println("Would you like another triangle (Y/N)? "); //see if they want another one
            again = String.valueOf(sc.next().charAt(0)); //store their answer (as a string)
            again = again.toLowerCase(); //in case user puts Y instead of y
        }
    }
}

