package myloan;

/**
 * This Personal loan class extends the Loan class for interest rate setting
 * accordingly
 *
 * @author satbir
 */
public class PersonalLoan extends Loan {

    /**
     * property of personal loan interest rate
     */
    private double personalInterestRate = 2;

    /**
     * Loan Class object for accessing interest rate
     */
    Loan pInterest = new Loan();

    /**
     * Personal loan constructor for increasing interest rate for personal loan
     * application
     */
    public PersonalLoan()// constructor to set the interest rate according to personal loan
    {
        personalInterestRate = pInterest.getInterestRate() + personalInterestRate;

    }

    /**
     * Personal interest rate getter
     *
     * @return the personal interest rate
     */
    public double getpersonalInterestRate() {
        return personalInterestRate;
    }

}
