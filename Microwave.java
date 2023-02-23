import java.util.Scanner;
/**
* This program calculates amount of Energy released when mass is converted to
* energy.
*
* @author  Alex De Meo
* @version 1.0
* @since   2023/02/08
*/

public final class Microwave {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private Microwave() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    */

    public static void main(String[] args) {
        // Constants that are used throughout the program.
        final int subTime = 60;
        final int soupTime = 105;
        final int pizzaTime = 45;
        final int secPerMin = 60;
        boolean valid = false;
        final String pizzaStr = "pizza";
        final String subStr = "sub";
        final String soupStr = "soup";
        final int max = 3;
        final int min = 0;

        // Creating the scanner.
        final Scanner scanner = new Scanner(System.in);

        // Getting the inputs (item name and #ofitems).
        System.out.print("Enter the item you are reheating: ");
        final String item = scanner.nextLine().toLowerCase();
        System.out.print("Enter the number of items you have: ");
        final String strItems = scanner.nextLine();
        try {
            final double numItems = Double.parseDouble(strItems);
            // Ensuring a correct number of items was entered
            if (numItems > min && numItems <= max) {
                double timeUnf = 0.0;
                // trimming and comparing the inputted item to ensure its valid
                // Doing the math to calculate the time
                if (item.trim().equals(soupStr)) {
                    timeUnf = soupTime * (((numItems - 1) / 2) + 1);
                    valid = true;
                } else if (item.trim().equals(subStr)) {
                    timeUnf = subTime * (((numItems - 1) / 2) + 1);
                    valid = true;
                } else if (item.trim().equals(pizzaStr)) {
                    timeUnf = pizzaTime * (((numItems - 1) / 2) + 1);
                    valid = true;
                } else {
                    System.out.println(item + " is not an option");
                }
                // This is where the output is put together, the sections of
                // the timestamp must be broken into mins and seconds to and
                // then formatted into the timestamp
                if (valid) {
                    final int mins = (int) timeUnf / secPerMin;
                    final int secs = (int) timeUnf % secPerMin;
                    // Adding a 0 in front of the seconds if there is only
                    // 1 digit
                    final String outputStr1 = "You need to put ";
                    final String outputStr2 = " on the microwave timer";
                    if (String.valueOf(secs).length() == 1) {
                        System.out.println(
                            outputStr1 + mins + ":0" + secs + outputStr2);
                    } else {
                        System.out.println(
                            outputStr1 + mins + ":" + secs + outputStr2);
                    }
                }
            } else {
                System.out.println("That is not an option!");
            }
        } catch (NumberFormatException error) {
            System.out.println("That input is invalid");
        }
    }
}
