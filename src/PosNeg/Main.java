/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-02-08

    Assignment: Positive or Negative
    Anything >= 0 is positive, < 0 is negative.
    I'm classifying 0 as a positive number and only going to use integer numbers.
 */
package PosNeg;

import javax.swing.*;

public class Main {
    public static void main(String[] __args) {
        do {
            String input = JOptionPane.showInputDialog("Enter a number");
            try {
                if (input == null || input.equals("")) {
                    input = "0";
                }

                double number = Double.parseDouble(input);
                if (number >= 0) {
                    JOptionPane.showMessageDialog(null, "\"" + number + "\" is a positive number");
                } else {
                    JOptionPane.showMessageDialog(null, "\"" + number + "\" is a negative number");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\"" + input +
                        "\" cannot be casted to a double", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }
}