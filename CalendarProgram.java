import java.util.Scanner;
public class CalendarProgram { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
 
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
 
        printCalendar(year, month);
 
        scanner.close();
    }
 
    private static void printCalendar(int year, int month) {
        System.out.println("Calendar for " + getMonthName(month) + " " + year + "\n");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
 
        int firstDayOfMonth = getFirstDayOfMonth(year, month);
        int daysInMonth = getDaysInMonth(year, month);
 
        // Print leading spaces for the first week
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("    ");
        }
 
        // Loop through each day of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
 
            // Move to the next day
            if ((firstDayOfMonth + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
 
        System.out.println("\n");
    }
 
    private static int getFirstDayOfMonth(int year, int month) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1); // Note: month is 0-based in Calendar
        return calendar.get(java.util.Calendar.DAY_OF_WEEK) - 1;
    }
 
    private static int getDaysInMonth(int year, int month) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    }
 
    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
}