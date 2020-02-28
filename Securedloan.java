
public abstract class Securedloan extends Loan{
    public Securedloan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi) {
    super(tenure, repaymentFrequency, loanType, loanAmount, roi);
}

    public abstract double calculateLoanToValueRatio();

}
