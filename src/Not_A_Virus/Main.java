/*
    Robert Higgins
    2013-07-28

    No assignment
*/
package Not_A_Virus;

import javax.swing.*;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String name;
        int dumbness = 0;
        int rand;
        String dumbnessString;
        boolean keepLooping;
        boolean debugMode = false;
        String[] values = {null, null, null, null, null, null, null, null};
        String hostname = getComputerName();
        values[0] = hostname;

        do {
            name = JOptionPane.showInputDialog(null, "What is your first name?", "Definitely NOT a virus!",
                    JOptionPane.INFORMATION_MESSAGE);

            try {
                name = fixName(name);

                if (name.length() > 2) {
                    keepLooping = false;
                } else {
                    JOptionPane.showMessageDialog(null, "I know that is not your name... Try again!", "f***ing idiot",
                            JOptionPane.ERROR_MESSAGE);
                    keepLooping = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "I know that is not your name... Try again!", "f***ing idiot",
                        JOptionPane.ERROR_MESSAGE);
                keepLooping = true;
            }
        } while (keepLooping);

        // Stores name in values[0]
        values[1] = name;

        do {
            do {
                try {
                    dumbness = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Hello " + name + ", How dumb are you? " +
                                    "Value: 1 - 10", "Welcome " + name + "!", JOptionPane.INFORMATION_MESSAGE));
                    keepLooping = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "That is not a number you f***ing idiot...",
                            "WTF? Read, you f***",
                            JOptionPane.ERROR_MESSAGE);
                    keepLooping = true;
                }
            } while (keepLooping);

            if (dumbness == 10) {
                JOptionPane.showMessageDialog(null, name + " has 10 dumbness points", "Initial dumbness Level",
                        JOptionPane.INFORMATION_MESSAGE);

                keepLooping = false;
            } else if (dumbness < 10 && dumbness > 0) {
                rand = getRandomNumber(20);
                dumbness = dumbness + rand;

                JOptionPane.showMessageDialog(null,
                        "Listen, " + name + ", Who the f*** do you think you are fooling?\n" +
                                "Just for that, I'm adding " + rand + " more dumbness points to your total score.\nYou now have " +
                                dumbness + " dumbness points to start.",
                        "You are so dumb!", JOptionPane.ERROR_MESSAGE);

                keepLooping = false;
            } else {
                JOptionPane.showMessageDialog(null, "(1-10) only, you dumbass", "Ayo!!! Dumbo!!!",
                        JOptionPane.ERROR_MESSAGE);

                keepLooping = true;
            }
        } while (keepLooping);

        // Stores initial dumbness points in values[1]
        dumbnessString = Integer.toString(dumbness);
        values[2] = dumbnessString;

        rand = getRandomNumber(5);
        if (debugMode) {
            System.out.println("randomNumber: " + rand);
        }

        String[] buttons = {"1", "2", "3", "4", "5"};
        do {
            try {
                int buttonInput = JOptionPane.showOptionDialog(null, "Choose a number between 1 - 5",
                        "Guess Right or Die...",
                        JOptionPane.DEFAULT_OPTION, 0, null, buttons,
                        buttons[2]);
                System.out.println("buttonInput: " + buttonInput);

                if ((buttonInput + 1) == rand) {
                    rand = getRandomNumber(10);
                    dumbness = dumbness - rand;

                    JOptionPane.showMessageDialog(null, "Correct! -" + rand + " dumbness points for you!",
                            "Very Good " + name + "!", JOptionPane.INFORMATION_MESSAGE);

                    values[3] = "true";
                } else {
                    rand = getRandomNumber(20000);
                    dumbness = dumbness + rand;

                    JOptionPane.showMessageDialog(null, "WRONG! +" + rand + " dumbness points for you!\n" +
                                    "You now have " + dumbness + " dumbness points.", "F***ING IDIOT!!!!!",
                            JOptionPane.ERROR_MESSAGE);

                    values[3] = "false";
                }

                keepLooping = false;
            } catch (Exception e) {
                keepLooping = true;
            }
        } while (keepLooping);

        JOptionPane.showMessageDialog(null, "Running in-depth virus scan, Please Wait...", "Virus Scan in progress",
                JOptionPane.INFORMATION_MESSAGE);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "WARNING, Virus scan completed on " + hostname +
                "\nWe have found 1 potential infected folder named \"System32\" in: \"C:/Windows/System32\"\n" +
                "Would you like to delete this folder?", "Virus Scan Overview", JOptionPane.YES_NO_OPTION);

        if (dialogResult == 0) {
            rand = getRandomNumber(10);
            dumbness = dumbness - rand;

            JOptionPane.showMessageDialog(null, "\"System32\" Will be deleted after the program exits! -" + rand +
                    " dumbness points", "Virus Scan Overview", JOptionPane.INFORMATION_MESSAGE);

            values[4] = "true";
        } else {
            rand = getRandomNumber(1000000);
            dumbness = dumbness + rand;

            JOptionPane.showMessageDialog(null,
                    "UNBELIEVABLE! YOU ARE JUST GOING TO LEAVE A VIRUS ON YOUR COMPUTER?\n" +
                            "You are a f***ing dumbass!!!!! +" + rand + " dumbness points for you!",
                    "Fatal Error!", JOptionPane.ERROR_MESSAGE);

            values[4] = "false";
        }

        rand = getRandomNumber(50);
        dumbness = dumbness + rand;
        JOptionPane.showMessageDialog(null, name + " has " + dumbness + " dumbness points left over from life",
                "The Game of Life", JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(null, name + " has a total of " + dumbness + " dumbness points!", name +
                "dumbness Points Total", JOptionPane.INFORMATION_MESSAGE);
        dumbnessString = Integer.toString(dumbness);
        values[5] = dumbnessString;


        int dialogResult2 = JOptionPane.showConfirmDialog(null, "Send information to Rupert for analysis?",
                "Send information?", JOptionPane.YES_NO_OPTION);
        if (dialogResult2 == 0) {
            JOptionPane.showMessageDialog(null, "Information Sent!", "Thank Me", JOptionPane.INFORMATION_MESSAGE);
            values[6] = "true";
        } else {
            JOptionPane.showMessageDialog(null, "Too f***ing bad " + name + "! It was sent anyways!", "Thank Me",
                    JOptionPane.INFORMATION_MESSAGE);
            values[6] = "false";
        }

        // Create log file
        setLogFile(values);

        if (dialogResult == 0) {
            JOptionPane.showMessageDialog(null, "Deleting \"System32\"... please wait!", "Deleting Virus!",
                    JOptionPane.INFORMATION_MESSAGE);

            if (!debugMode) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("shutdown -s -t 0");
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Unable to delete System32!",
                            "Fatal Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Debug Mode Activated. Computer Will NOT Restart!");
            }
        }
    }

    private static String fixName(String name) {
        System.out.println("Name Before: " + name);

        name = name.trim();
        name = name.replaceAll("[^a-zA-Z]", "");
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        System.out.println("Name After: " + name);

        return name;
    }

    /*  Creates a log file and sends it to Rupert
     *  values[0] = computer name				values[1] = user's name
     *  values[2] = initial dumbness points		values[3] = guess the number
     *  values[4] = deleted System32			values[5] = ending dumbness points
     *  values[6] = send information?			values[7] = debugMode?
     */
    private static void setLogFile(String[] values) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        System.out.println("Date: " + dateFormat.format(date));
        String fileName = "log_" + dateFormat.format(date) + ".txt";
        String username = System.getProperty("user.name");

        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println("Computer Name: " + values[0]);
            writer.println("Computer Username: " + username);
            writer.println("User's Name: " + values[1]);
            writer.println("Initial Dumbness Points: " + values[2]);
            writer.println("Guessed Correct Number: " + values[3]);
            writer.println("Deleted System32: " + values[4]);
            writer.println("Total Dumbness Point: " + values[5]);
            writer.println("Ending Dumbness Points: " + values[6]);
            writer.println("DebugMode: " + values[7]);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getComputerName() {
        String hostname;

        try {
            InetAddress address;
            address = InetAddress.getLocalHost();
            hostname = address.getHostName();
            return hostname;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Computer_Name_Error";
    }

    public static int getRandomNumber(int number) {
        Random rand = new Random();
        int randNum;

        randNum = rand.nextInt(number) + 1;

        return randNum;
    }
}