/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-04-17

    Assignment: Books
    If number from Books.txt is less than 53.4 or greater than 55.4, make it an "error book".
    Get percentage of total books to error books. Using file Scanner class is required.
 */
package Books;

import javax.swing.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] __args) {
        final String filename = "resources/books.txt";
        int[] counters = new int[2];

        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNextLine()) {
                Double line = file.nextDouble();
                counters[0]++;

                if (line < 53.4 || line > 55.4) {
                    System.out.println("Rejected: " + line + "  at line: " + counters[0]);
                    counters[1]++;
                }
            }

            double percentage = ((double) counters[1] / (double) counters[0]) * 100;
            if (counters[0] == 0) {
                percentage = 0;
            }

            DecimalFormat df = new DecimalFormat("#.##");

            JOptionPane.showMessageDialog(null, "Total Books: " + counters[0] +
                            "\nAmount Rejected: " + counters[1] + "\nPercent Rejected: " + df.format(percentage) + "%",
                    "End Report", JOptionPane.INFORMATION_MESSAGE);

            file.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot locate" + filename);
        }
    }
}