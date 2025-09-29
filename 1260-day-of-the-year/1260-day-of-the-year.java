class Solution {
    public int dayOfYear(String date) {
        // Parse year, month, day
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // Days in each month
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        // Check leap year
        if (isLeapYear(year)) {
            days[1] = 29; // February becomes 29
        }

        // Sum days of all previous months
        int total = day;
        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}