/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-04-06

    Assignment: Battery
    Set charge of battery and drain charge
 */
package Battery;

import javax.swing.*;

public class Main {
    public static void main(String[] __args) {
        double charge;
        do {
            String input = JOptionPane.showInputDialog(null, "Enter battery charge");
            if (input == null) {
                return;
            }

            try {
                charge = Double.parseDouble(input);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast \"" + input + "\" to a double");
            }
        } while (true);

        do {
            String input = JOptionPane.showInputDialog(null, "Current Charge: " + charge +
                    " A\nEnter amount of charge to drain");
            if (input == null) {
                return;
            }

            try {
                if (Double.parseDouble(input) < 0) {
                    JOptionPane.showMessageDialog(null, "This is not a re-chargeable battery");
                } else {
                    charge = charge - Double.parseDouble(input);
                }

                if (charge <= 0) {
                    charge = 0;
                    JOptionPane.showMessageDialog(null, "Current Charge: " + charge +
                            " A\nYou have drained the battery");
                    return;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast \"" + input + "\" to a double");
            }
        } while (true);
    }
}