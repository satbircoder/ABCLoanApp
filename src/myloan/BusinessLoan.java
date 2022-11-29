package myloan;

/**
 * This business loan class extends the loan class for setting interest rate
 * accordingly
 *
 * @author satbir
 */
public class BusinessLoan extends Loan {

    /**
     * property of business loan interest rate
     */
    private double businessInterestRate = 1;

    /**
     * Object of Loan class for accessing interest rate
     */
    Loan bInterest = new Loan();

    /**
     * Business Loan constructor for setting interest rate accordingly
     */
    public BusinessLoan()// Constructor to set the interest rate according to business loan interest rate 
    {
        businessInterestRate = bInterest.getInterestRate() + businessInterestRate;
    }

    /**
     * Business Interest rate getter
     *
     * @return the business interest rate
     */
    public double getBusinessInterestRate() {
        return businessInterestRate;
    }
}
