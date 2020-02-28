import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import static java.time.temporal.ChronoUnit.DAYS;

public class Bank implements Maker,Checker {

    static int number = 0;
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Loan> loan = new ArrayList<>();

    static int custID = 0;
    static int loanID = 0;

    public int RegisterCustomer(String customerName, LocalDate dateOfBirth, String contactNumber, String emailAddress, double monthlyIncome, String profession, double totalMonthlyExpense) {
        Customer customer = new Customer(customerName, dateOfBirth, contactNumber, emailAddress, monthlyIncome, profession, totalMonthlyExpense);
        customers.add(customer);
        return customers.get(custID++).getCustomerId();
    }

    public Customer findCustomer(int customerId) {
        Customer cs = null;
        for (int i = 0; i < custID; i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                return cs = customers.get(i);
            } else
                return null;
        }
        return cs;
    }

    @Override
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String builderName, double propertyValue, int propertySize,Customer customer) {
        Loan loans = new Homeloan(tenure, repaymentFrequency, loanType, loanAmount, roi, builderName, propertyValue, propertySize,customer);
        loan.add(loans);
        loan.get(number).setS(Loan.Status.PENDING);
        loan.get(number).getCustomer();
        return loan.get(number++).getLoanId();
    }

    @Override
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String vehicleCategory, String vehicleModelNo, String manufacturer, double assetvalue,Customer customer) {
        Loan loans = new Vehicleloan(tenure, repaymentFrequency, loanType, loanAmount, roi, vehicleCategory, vehicleModelNo, manufacturer, assetvalue,customer);
        loan.add(loans);
        loan.get(number).setS(Loan.Status.PENDING);
        loan.get(number).getCustomer();
        return loan.get(number++).getLoanId();
    }

    @Override
    public int applyLoan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String qualification, double workExperience, double Salary,Customer customer) {
        loan.set(number, new Personalloan(tenure, repaymentFrequency, loanType, loanAmount, roi, qualification, workExperience, Salary,customer));
        loan.get(number).setS(Loan.Status.PENDING);
        loan.get(number).getCustomer();
        return loan.get(number++).getLoanId();
    }


    @Override
    public String trackLoanStatus(int id) {
        for (int i = 0; i <= id; i++) {
            if (loan.get(i).getLoanId() == id)
                return loan.get(i).getS().toString();
        }
        return "null";
    }

    @Override
    public void approveRejectLoan(int id) {
        for (int i = 0; i < number; i++) {
            if (loan.get(i).getLoanId() == id) {
                if (loan.get(i).getLoanType().equalsIgnoreCase("HomeLoan")) {
                    Homeloan hm = (Homeloan) loan.get(i);
                    if (hm.calculateLoanToValueRatio() > 0.8) {
                        loan.get(i).setS(Loan.Status.REJECTED);

                    } else {
                        try {
                            loan.get(i).setS(Loan.Status.APPROVED);
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (loan.get(i).getLoanType().equalsIgnoreCase("VehicleLoan")) {
                    Vehicleloan vl = (Vehicleloan) loan.get(i);
                    if (vl.calculateLoanToValueRatio() > 0.8) {
                        loan.get(i).setS(Loan.Status.REJECTED);

                    } else {
                        try {
                            loan.get(i).setS(Loan.Status.APPROVED);
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (loan.get(i).getLoanType().equalsIgnoreCase("PersonalLoan")) {
                    Personalloan pl = (Personalloan) loan.get(i);
                    if ((pl.getSalary() > 500000) && (pl.getWorkExperience() > 5)) {
                        loan.get(i).setS(Loan.Status.APPROVED);
                    } else {
                        loan.get(i).setS(Loan.Status.REJECTED);
                    }
                }
                System.out.println(loan.get(number));
                System.out.println(loan.get(i).getS().toString());
            }
        }
    }
    public void generateRepaymentSchedule(int ID)
    {
        for(int i=0;i<number;i++){
            if( loan.get(i).getLoanId()==ID){
                for(int j=0;j<loan.get(i).getTenure();j++){
                    loan.get(i).generateRepaymentSchedule();
                }
            }

        }
    }

    public void loanDisbursal(int id) {
        for (int i = 0; i < number; i++) {
            if (loan.get(i).getLoanId() == id) {
                loan.get(i).setDisbursalDate(LocalDate.now());
                loan.get(i).setS(Loan.Status.APPROVED);
                loan.get(i).generateRepaymentSchedule();
            }
        }
    }

    public void calculatePenaulty(int ID) {
        int i = 0;
        for (i = 0; i < loanID; i++) {
            if (loan.get(i).getLoanId() == ID) {
                for (int j = 0; j < loan.get(i).getemi().size(); j++) {
                    if (loan.get(i).getemi().get(j).getStatsofEmi() == EMI.statsofEmi.Due) {
                        System.out.println("********");
                        double penaltyDays = DAYS.between(loan.get(i).getemi().get(j).getEmiDueDate(), LocalDate.now());
                        double penaltyCharges = loan.get(i).getEmiPerMonth() * 0.1 * penaltyDays;
                         loan.get(i).getemi().get(j).setPenalty(penaltyCharges);
                        System.out.println(penaltyCharges);
                    }
                }
            }
        }
    }

    @Override
    public void getAllActiveLoanDetails() {
        for (int i = 0; i < number; i++) {
            if (loan.get(i).getS().equals(Loan.Status.APPROVED)) {
                System.out.println("loan id " + loan.get(i).getLoanId() + " " + loan.get(i).toString() + " " + loan.get(i).getS());
            }
        }
    }

    @Override
    public void getLoanDetails(int id) {
        for (int i = 0; i < number; i++) {
            if (loan.get(i).getLoanId() == id) {
                System.out.println(loan.get(i).toString() + " " + loan.get(i).getS());
            }
        }
    }

    @Override
    public boolean removeLoanAccount(int id) {
        for (int i = 0; i < number; i++) {
            if (loan.get(i).getLoanId() == id && loan.get(i).getS().equals(Loan.Status.CLOSED)) {
                System.out.println("true");
                loan.set(i, loan.get(i + 1));
                number--;
            }
        }
        return false;
    }

    public void endOfDayProcess() {
        int i;
        for (i = 0; i < custID; i++) {
            boolean flag = false;
            int j;
            for (j = 0; j < loan.get(i).getemi().size(); j++) {
                if ((loan.get(i).getemi().get(j).getStatsofEmi()) != EMI.statsofEmi.Due) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                LocalDate maturityDate = loan.get(i).getemi().get(loan.get(i).getemi().size() - 1).getEmiDueDate();
                if (maturityDate == LocalDate.now()) {
                    loan.get(i).setS(Loan.Status.CLOSED);
                }
                for (j = 0; j < loan.get(i).getemi().size(); j++) {
                    if ((LocalDate.now().compareTo(loan.get(i).getemi().get(j).getEmiDueDate()) > 0 && (loan.get(i).getemi().get(j).getStatsofEmi()) == EMI.statsofEmi.Due)) {
                        calculatePenaulty(loan.get(i).getLoanId());
                    }
                }
            }
        }
    }

    public void Logging(){
        final Logger logger=LogManager.getLogger(Banking.class);
        DOMConfigurator.configure("src\\main\\resources\\log4j.xml");
        logger.warn("waring 1");
    }

}
