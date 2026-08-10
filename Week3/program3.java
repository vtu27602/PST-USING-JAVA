import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        int day = 31;
        int month = 8;
        int year = 2019;

        LocalDate date = LocalDate.of(year, month, day);

        String result = date.getDayOfWeek().toString();

        result = result.charAt(0) + result.substring(1).toLowerCase();

        System.out.println(result);
    }
}


Input: day = 15, month = 8, year = 1993
Output: "Sunday"


