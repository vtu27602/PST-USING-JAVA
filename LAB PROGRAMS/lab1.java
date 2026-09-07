import java.util.Scanner;

public class SalaryTransformationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Salary Transformation System =====");

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        double travelAllowance = basicSalary * 0.05;

        double grossSalary = basicSalary + hra + da + travelAllowance;

        double pf = basicSalary * 0.12;
        double tax = grossSalary * 0.05;

        double totalDeductions = pf + tax;
        double netSalary = grossSalary - totalDeductions;

        System.out.println("\n===== Salary Details =====");
        System.out.println("Employee Name      : " + name);
        System.out.printf("Basic Salary       : %.2f%n", basicSalary);
        System.out.printf("HRA                : %.2f%n", hra);
        System.out.printf("DA                 : %.2f%n", da);
        System.out.printf("Travel Allowance   : %.2f%n", travelAllowance);
        System.out.printf("Gross Salary       : %.2f%n", grossSalary);
        System.out.printf("PF                 : %.2f%n", pf);
        System.out.printf("Tax                : %.2f%n", tax);
        System.out.printf("Total Deductions   : %.2f%n", totalDeductions);
        System.out.printf("Net Salary         : %.2f%n", netSalary);

        scanner.close();
    }
}


OUTPUT :
===== Salary Transformation System =====
Enter employee name: ravi
Enter basic salary: 50000

===== Salary Details =====
Employee Name      : ravu
Basic Salary       : 50000.00
HRA                : 10000.00
DA                 : 5000.00
Travel Allowance   : 2500.00
Gross Salary       : 67500.00
PF                 : 6000.00
Tax                : 3375.00
Total Deductions   : 9375.00
Net Salary         : 58125.00
