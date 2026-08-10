class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int totalDays = 0;

        // Add days for complete years
        for (int y = 1971; y < year; y++) {
            if (isLeap(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Add days for complete months
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];
        }

        totalDays += day - 1;

        int index = (5 + totalDays) % 7;

        return week[index];
    }

    public boolean isLeap(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}



Input: day = 31, month = 8, year = 2019
Output: "Saturday"
