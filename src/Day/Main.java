/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-04-27

    Assignment: Day of Week
    Strict rules on this, classes and constructors must be used.
 */
package Day;

import javax.swing.*;

public class Main {
    public static void main(String[] __args) {
        Day day = new Day();
        do {
            int input = JOptionPane.showConfirmDialog(null, "Current weekday: " + day.getDay() +
                    "\nYes to add one day\nNo to subtract one day", "DayOfWeek", JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 0) {
                day.getNextDay();
            } else if (input == 1) {
                day.getPrevDay();
            } else {
                break;
            }
        } while (true);

        do {
            String input = JOptionPane.showInputDialog(null, "Current weekday: " + day.getDay() +
                    "\nEnter amount of days (+/-)");
            if (input == null) {
                return;
            } else if (input.equals("")) {
                input = "0";
            }

            try {
                day.getCustomDay(Integer.parseInt(input));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast \"" + input + "\" to int");
            }
        } while (true);
    }
}