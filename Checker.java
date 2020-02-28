public interface Checker {
    void approveRejectLoan(int id);
    void getAllActiveLoanDetails();
    void getLoanDetails(int id);
    boolean removeLoanAccount(int id);
}
