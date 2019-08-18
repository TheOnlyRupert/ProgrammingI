/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-03-02

    Assignment: Roll the Die
    Output random number between 1 and 6
 */
package RollDie;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] __args) {
        do {
            int choice = JOptionPane.showConfirmDialog(null, "You rolled a " + dieNumber() +
                    "\nRoll again?", "RollDie", JOptionPane.YES_NO_OPTION);
            if (choice != 0) {
                break;
            }
        } while (true);

        weightedAverages();
    }

    private static int dieNumber() {
        return (int) (Math.random() * 6 + 1);
    }

    /**
     * Used to verify all numbers (1-6) are truly distributed random
     */
    private static void weightedAverages() {
        int[] numberTracker = new int[6];
        final int counter = 1000000000;

        for (int i = 0; i < counter; i++) {
            switch (dieNumber()) {
                case 1:
                    numberTracker[0] = numberTracker[0] + 1;
                    break;
                case 2:
                    numberTracker[1] = numberTracker[1] + 1;
                    break;
                case 3:
                    numberTracker[2] = numberTracker[2] + 1;
                    break;
                case 4:
                    numberTracker[3] = numberTracker[3] + 1;
                    break;
                case 5:
                    numberTracker[4] = numberTracker[4] + 1;
                    break;
                case 6:
                    numberTracker[5] = numberTracker[5] + 1;
                    break;
                default:
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("#.#");

        JOptionPane.showMessageDialog(null, "Overview of 1 million numbers:\n1 occurred: " +
                numberTracker[0] + " times  " + df.format((double) numberTracker[0] / (counter / 100)) +
                "%\n2 occurred: " + numberTracker[1] + " times  " + df.format((double) numberTracker[1] / (counter / 100)) +
                "%\n3 occurred: " + numberTracker[2] + " times  " + df.format((double) numberTracker[2] / (counter / 100)) +
                "%\n4 occurred: " + numberTracker[3] + " times  " + df.format((double) numberTracker[3] / (counter / 100)) +
                "%\n5 occurred: " + numberTracker[4] + " times  " + df.format((double) numberTracker[4] / (counter / 100)) +
                "%\n6 occurred: " + numberTracker[5] + " times  " + df.format((double) numberTracker[5] / (counter / 100)) + "%");
    }
}