import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for each day's hours
        int[] hoursWorked = new int[7];
        for (int i = 0; i < 7; i++) {
            hoursWorked[i] = scanner.nextInt();
        }

        // Calculate the weekly salary
        int weeklySalary = calculateSalary(hoursWorked);

        // Print the result
        System.out.println(weeklySalary);

        // Close the scanner
        scanner.close();
    }

    static int calculateSalary(int[] hoursWorked) {
        int baseRate = 100;
        int extraRate1 = 15;
        int extraRate2 = 25;
        int saturdayBonus = 25; // 25% bonus
        int sundayBonus = 50;   // 50% bonus

        int totalHours = 0;
        for (int hours : hoursWorked) {
            totalHours += hours;
        }

        int weeklySalary = totalHours * baseRate;

        for (int i = 0; i < hoursWorked.length; i++) {
            if (hoursWorked[i] > 8) {
                weeklySalary += (hoursWorked[i] - 8) * extraRate1;
            }

            if (i == 5 && hoursWorked[i] > 0) { // Saturday
                weeklySalary += (weeklySalary * saturdayBonus) / 100;
            }

            if (i == 6 && hoursWorked[i] > 0) { // Sunday
                weeklySalary += (weeklySalary * sundayBonus) / 100;
            }
        }

        if (totalHours > 40) {
            weeklySalary += (totalHours - 40) * extraRate2;
        }

        return weeklySalary;
    }
}
