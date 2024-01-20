import java.util.Scanner;
import java.lang.Math;

public final class NeudesicProject {

    private static double calculator(double p, double r, int length) {
        int numberOfPayments = length*12;
        double monthlyInterestRate = (r/100)/12;
        double monthlyMortgagePayment = p * (monthlyInterestRate * Math.pow((1+monthlyInterestRate),numberOfPayments))/(Math.pow((1 + monthlyInterestRate),numberOfPayments) - 1);

        return monthlyMortgagePayment;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        double mortgagePayment, principleLoanAmount, annualInterestRate;
        int loanLength;

        System.out.println("Input a value for the principle loan amount: ");
        principleLoanAmount = scanner.nextInt();
        System.out.println("Input a percentage for the annual interest rate: ");
        annualInterestRate = scanner.nextDouble();
        System.out.println("Input a value for the loan period in years: ");
        loanLength = scanner.nextInt();

        mortgagePayment = calculator(principleLoanAmount,annualInterestRate, loanLength);

        System.out.println("The monthly payment is: " + df.format(mortgagePayment));
        System.out.println("The number of monthly payments is: " + loanLength * 12);
        System.out.println("The total interest is: " + df.format(mortgagePayment * (loanLength * 12)  - principleLoanAmount));
        System.out.println("The total payment is: " + df.format(mortgagePayment * (loanLength * 12)));

        scanner.close();
    }
}