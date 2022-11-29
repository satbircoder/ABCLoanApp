package createloans;

import java.io.*;
import myloan.*;
import java.util.*;

/**
 * This Create Loan class used an Arraylist to store loan class objects
 *
 * @author satbir
 */
public class CreateLoans {

    /**
     * The main method will be used to implement the operations that is required
     * by application. this method ask the user to enter the current prime
     * interest rate, loan term last name of the customer, and loan amount as
     * well After creating loan applications through objects of loan class the
     * application will be save the data into binary file.
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Loan> loanApp = new ArrayList<>();
        Loan interestPrime = new Loan();
        System.out.println(LoanConstants.COMPANY_NAME);
        System.out.println("Welcome to Loan Application Portal");
        System.out.println("Maximum Loan Limit is: $250000 request above this limit will be automatically set to maximum allowed");
        System.out.println("Allowed Loan Periods are 1, 3, 5 Years: Outside Period will be changed to 1 Year");
        int maxLoanApplication = 0;
        do {
            System.out.println("Enter the Current Prime Interest Rate:");
            try {
                Scanner sc = new Scanner(System.in);
                double primeRate = sc.nextDouble();
                System.out.println("Enter the Last Name");
                String lastName = sc.next();
                System.out.println("Enter the Loan Amount:");
                double amountRequest = sc.nextDouble();
                System.out.println("Enter the Loan Term");
                int term = sc.nextInt();
                System.out.println("Select the type of loan");
                System.out.println("""
                           Press 1 for Personal Loan Application: 
                           Press 2 for Business Loan Application:""");
                int loanType = sc.nextInt();
                if (loanType > 0 && loanType <= 2) {
                    switch (loanType) {
                        case 1 -> {
                            interestPrime.setInterestRate(primeRate);
                            PersonalLoan perInterest = new PersonalLoan();
                            Loan pInterest = new Loan();
                            pInterest.setInterestRate(perInterest.getpersonalInterestRate());
                            Loan loan1 = new Loan(lastName, amountRequest, term);
                            loanApp.add(loan1);
                        }
                        case 2 -> {
                            interestPrime.setInterestRate(primeRate);
                            BusinessLoan busInterest = new BusinessLoan();
                            Loan bInterest = new Loan();
                            bInterest.setInterestRate(busInterest.getBusinessInterestRate());
                            Loan loan2 = new Loan(lastName, amountRequest, term);
                            loanApp.add(loan2);
                        }
                    }
                } else {
                    System.out.println("Please Try Again not an option");
                }
                maxLoanApplication++;
            } catch (Exception e) {
                System.out.println("Something Went Wrong Please Try ");
            }
        } while (maxLoanApplication != 5);

        for (Loan l : loanApp) {
            System.out.println(l.toString());
        }
        try {
            System.out.println("File Writting is in progress");
            try ( FileOutputStream fileWrite = new FileOutputStream("loans.bin")) {
                ObjectOutputStream objectOut = new ObjectOutputStream(fileWrite);
                for (Loan write : loanApp) {
                    objectOut.writeObject(write.toString());
                }
                System.out.println("File Has been saved successfully");
            }
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

}
