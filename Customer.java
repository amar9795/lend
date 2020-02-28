import java.time.LocalDate;

public class Customer { static int Id=0;
    private int customerId;
    private String customerName;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String emailAddress;
    private double monthlyIncome;
    private String profession;
    private double totalMonthlyExpense;
    private String designation;
    private String companyName;

    public Customer(String customerName, LocalDate dateOfBirth, String contactNumber, String emailAddress, double monthlyIncome, String profession, double totalMonthlyExpense)
    {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.monthlyIncome = monthlyIncome;
        this.profession = profession;
        this.totalMonthlyExpense = totalMonthlyExpense;

        Id++;
        this.customerId=Id;


    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getTotalMonthlyExpense() {
        return totalMonthlyExpense;
    }

    public void setTotalMonthlyExpense(double totalMonthlyExpense) {
        this.totalMonthlyExpense = totalMonthlyExpense;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

class Dbr
{
    public double Cal(double mExc, double mSal) {
        double dbr = mExc / mSal;
        return dbr;

    }
}
class Maxemi
{
    public double EMI(double sal,double dbr)
    {
        double EMI=(sal-(sal*dbr))*0.5;
        return EMI;
    }
}
