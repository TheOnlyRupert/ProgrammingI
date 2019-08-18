/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-??-??

    Assignment: Elapsed Time
    Convert time in seconds to hours,min,seconds and display
 */
package TimeConverter;

import javax.swing.*;

public class Main {
    public static void main(String[] __args) {
        do {
            String input = JOptionPane.showInputDialog(null, "Enter time in seconds");
            if (input == null) {
                return;
            }

            try {
                long total = Long.parseLong(input);
                JOptionPane.showMessageDialog(null, convertTotal(total));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Input cannot be converted to a number",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }

    /**
     * Returns a string of the converted seconds into-> "HOURS:MINS:SECS"
     */
    private static String convertTotal(long __input) {
        long[] timeComponents = {0, 0, 0};
        timeComponents[0] = __input / 3600;
        timeComponents[1] = (__input - (timeComponents[0] * 3600)) / 60;
        timeComponents[2] = (__input - timeComponents[0] * 3600) - (timeComponents[1] * 60);

        return timeComponents[0] + "h:" + timeComponents[1] + "m:" + timeComponents[2] + "s";
    }
}
