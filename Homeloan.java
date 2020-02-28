public class Homeloan extends Securedloan { String builderName;
    double propertyValue;
    int propertySize;

    public Homeloan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String builderName, double propertyValue, int propertySize, Customer customer) {
        super(tenure, repaymentFrequency, loanType, loanAmount, roi);
        this.builderName = builderName;
        this.propertyValue = propertyValue;
        this.propertySize = propertySize;
    }

    @Override
    public double calculateLoanToValueRatio() {
        return 0;
    }



    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public int getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(int propertySize) {
        this.propertySize = propertySize;
    }

    public void  calculateLoanToValueRatio(double loanAmt, int propertyValue ){
        System.out.println(loanAmt/propertyValue);
    }

    @Override
    public String toString() {
        return "Homeloan{" +
                "builderName='" + builderName + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                ", propertySize=" + propertySize +
                '}';
    }
}
