public interface Maker {
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi,String builderName, double propertyValue, int propertySize,Customer customer);
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi,String vehicleCategory, String vehicleModelNo, String manufacturer, double assetvalue,Customer customer);
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String qualification, double workExperience,double Salary,Customer customer);
    public String trackLoanStatus(int id);
    public void getAllActiveLoanDetails();
    public void getLoanDetails(int id);
}
