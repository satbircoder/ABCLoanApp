package myloan;

import java.text.NumberFormat;
import java.io.Serializable;

/**
 * This loan class implements the Loan constants public interface for
 * appropriate fields
 *
 * @author satbir
 */
public class Loan implements LoanConstants, Serializable {

    /**
     * Property for loan number
     */
    private int loanNumber;// loan number property

    /**
     * Property for Customer Last Name
     */
    private String custLastName;// customer last name property

    /**
     * Property for loan Amount
     */
    private double loanAmount;// Loan Anount property

    /**
     * Property for loan interest rate
     */
    private static double interestRate;// interest rate property

    /**
     * Property for loan period
     */
    private int loanTerm;// loan term property

    /**
     * Property for loan applications created previously
     */
    private static int noOfLoansCreated = 0;// saving loan number for auto increment

    /**
     * Property for monthly interest rate
     */
    private double monthlyInterestRate;

    /**
     * Property for monthly due amount
     */
    private double monthlyPayment;

    /**
     * Property for total amount payable after loan period completion
     */
    private double totalPayment;

    /**
     * Default constructor used in business and personal loan class for setting
     * interest rate
     */
    public Loan() {
    }

    /**
     * Constructor for getting values from the object created in Create Loan
     * Class
     *
     * @param acustLastName taking values from object created and setting last
     * name accordingly
     * @param aLoanAmount taking values from object created and setting loan
     * amount accordingly
     * @param aLoanTerm taking values from object created and setting loan term
     * accordingly
     */
    public Loan(String acustLastName, double aLoanAmount, int aLoanTerm) {//constructor for setting values for properties
        noOfLoansCreated += 1;
        loanNumber = loanNumber + noOfLoansCreated;
        custLastName = acustLastName;
        setLoanAmount(aLoanAmount);
        setLoanTerm(aLoanTerm);
        monthlyInterestRate = interestRate / 1200;//calculating the monthly interest rate
        monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, loanTerm * 12));// monthly payment
        totalPayment = monthlyPayment * loanTerm * 12;//Total payment till loan term 
    }

    /**
     * Getter for accessing loan amount
     *
     * @return the loan amount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Setter for loan amount
     *
     * @param loanAmount take the loan amount passed and set accordingly
     */
    public void setLoanAmount(double loanAmount) {// dealing with loan amaount
        if (loanAmount <= LoanConstants.LOAN_AMOUNT) {
            this.loanAmount = loanAmount;
        } else {
            this.loanAmount = LoanConstants.LOAN_AMOUNT;
        }
    }

    /**
     * getter for accessing the interest rate
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * setter for interest rate of the loan
     *
     * @param interestRate take the interest rate passed and set as per
     * application requirement
     */
    public void setInterestRate(double interestRate) {// setting interest rate
        Loan.interestRate = interestRate;
    }

    /**
     * getter for loan term
     *
     * @return the ineger value of loan term
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * setter for loan term
     *
     * @param loanTerm Get the value passed from objects and perform accordingly
     */
    public void setLoanTerm(int loanTerm) {// Dealing with loan term
        if (loanTerm == LoanConstants.SHORT_TERM || loanTerm == LoanConstants.MEDIUM_TERM || loanTerm == LoanConstants.LONG_TERM) {
            this.loanTerm = loanTerm;
        } else {
            this.loanTerm = LoanConstants.SHORT_TERM;
        }

    }

    /**
     * override toString method to display the values in the fields
     *
     * @return the appropriate fields value of loan class
     */
    @Override
    public String toString() {// override tostring method to display
        return "Customer Last Name: " + custLastName + "\nLoan Number: " + loanNumber
                + "\nLoan Term: " + this.getLoanTerm() + " years" + "\nLoan Amount: " + this.getLoanAmount()
                + "\nMonthly Payment will be: " + NumberFormat.getInstance().format(monthlyPayment * 100 / 100.0)
                + "\nThe Total Payment will be: $" + NumberFormat.getInstance().format(totalPayment * 100 / 100.0) + "\n";
    }
}
