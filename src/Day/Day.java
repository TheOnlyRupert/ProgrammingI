/*
	Robert Higgins
	Professor Kolb
	Programming I
	2013-04-27

    Subclass of assignment: Day of Week
    Class must have: getCurrentDay, getNextDay, getPrevDay, getAddedDays
 */
package Day;

public class Day {
    private String dayString;
    private int day;

    public Day() {
        day = 1;
    }

    public Day(int __dayIn) {
        if (__dayIn >= 1 && __dayIn <= 7) {
            day = __dayIn;
        } else {
            day = 1;
        }
        setDay();
    }

    private void setDay() {
        switch (day) {
            case 1:
                dayString = "Sunday";
                break;
            case 2:
                dayString = "Monday";
                break;
            case 3:
                dayString = "Tuesday";
                break;
            case 4:
                dayString = "Wednesday";
                break;
            case 5:
                dayString = "Thursday";
                break;
            case 6:
                dayString = "Friday";
                break;
            case 7:
                dayString = "Saturday";
                break;
            default:
                dayString = "Invalid";
                break;
        }
    }

    public String getDay() {
        setDay();
        return dayString;
    }

    public String getNextDay() {
        day++;
        if (day > 7) {
            day = 1;
        }
        setDay();
        return dayString;
    }

    public String getPrevDay() {
        day--;
        if (day < 1) {
            day = 7;
        }
        setDay();
        return dayString;
    }

    public String getCustomDay(int __amount) {
        day = day + __amount;
        if (day > 7) {
            day = day % 7;
        } else if (day < 7) {
            System.out.println("old: " + day);
            System.out.println("new: " + day);
        }
        return dayString;
    }
}