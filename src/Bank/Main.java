/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-03-14

    Assignment: Bank
    Input: AccountNumber and AccountType (Savings or Checking), CurrentBalance
    Compute: Interest after 1 year - Checking: .05 APR, Savings: .04 APR
    Output: AccountNumber, AccountType, and new CurrentBalance
 */
package Bank;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] __args) {
        int accountNumber, accountType, interestTime;
        double accountBalance, interestChecking = 0.03, interestSavings = 0.10;

        /* Account number logic */
        do {
            try {
                accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter account number"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast input to integer");
            }
        } while (true);

        /* Account type logic: 0 = checking, 1 = savings */
        accountType = JOptionPane.showConfirmDialog(null, "Yes: Checking\nNo: Savings",
                "Account type", JOptionPane.YES_NO_CANCEL_OPTION);
        if (accountType == 2) return;

        /* Initial account balance logic */
        do {
            try {
                accountBalance = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter initial account balance"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast input to integer");
            }
        } while (true);

        /* Number of years logic */
        do {
            try {
                interestTime = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter amount of months to collect interest"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot cast input to integer");
            }
        } while (true);

        /*Interest calculations */
        if (accountType == 0) {
            accountBalance = accountBalance * Math.pow(1 + (interestChecking / interestTime), interestChecking * interestTime);
        } else {
            accountBalance = accountBalance * Math.pow(1 + (interestSavings / interestTime), interestSavings * interestTime);
        }

        /* Output */
        String accountText;
        DecimalFormat df = new DecimalFormat("0.00");
        switch (accountType) {
            case 0:
                accountText = " (Checking)";
                break;
            default:
                accountText = " (Savings)";
                break;
        }
        JOptionPane.showMessageDialog(null, "Account: " + accountNumber + accountText +
                "\nNew balance: $" + df.format(accountBalance));
    }
}