package myloan;

/**
 * The Loan Constant is a public interface for loan terms and loan amount and
 * company name
 *
 * @author satbir
 */
public interface LoanConstants {// loan constant to set the loan amount and loan terms

    /**
     * property of short term loan
     */
    int SHORT_TERM = 1;

    /**
     * property of Medium term loan
     */
    int MEDIUM_TERM = 3;

    /**
     * property of Long term loan
     */
    int LONG_TERM = 5;

    /**
     * property of Maximum loan amount
     */
    int LOAN_AMOUNT = 250000;

    /**
     * property of company name
     */
    String COMPANY_NAME = "ABC Loan Pvt Ltd";
}
