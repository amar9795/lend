import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Loan { private static int  id = 0;
    private int tenure;
    private int  repaymentFrequency;
    private int  loanId;
    private int perDayPenalty;
    private  String loanType;
    private LocalDate disbursalDate;
    private LocalDate dateOfBirth;
    private LocalDate date;
    private Customer customer;
    private double loanAmount;
    private double emiPerMonth;
    private double maxEligibleLoanAmount;
    private double roi;
    private double interestComponent;
    private double  principalComponent;
    private double  outstandingPrincipal;
    private double penalty;
    enum Status { PENDING, APPROVED, REJECTED, CLOSED }



    Status s;
    ArrayList<EMI> emi=new ArrayList<>();


    public Loan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi) {
        this.tenure = tenure;
        this.repaymentFrequency = repaymentFrequency;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.roi = roi;
        id++;
        this.loanId = id;

    }

    public ArrayList<EMI> getemi(){
        return emi;
    }

    public void setEmi(ArrayList<EMI> emi) {
        this.emi = emi;
    }

    public Customer getCustomer(){
        return customer;
    }

    public  Status getS() {
        return s;
    }

    public void setS(Status s) {
        this.s = s;
    }

    public  int getLoanId() {
        return loanId;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDisbursalDate() {
        return disbursalDate;
    }

    public void setDisbursalDate(LocalDate disbursalDate) {
        this.disbursalDate = disbursalDate;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public int getRepaymentFrequency() {
        return repaymentFrequency;
    }

    public void setRepaymentFrequency(int repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
    }

    public  String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPerDayPenalty() {
        return perDayPenalty;
    }

    public void setPerDayPenalty(int perDayPenalty) {
        this.perDayPenalty = perDayPenalty;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getEmiPerMonth() {
        return emiPerMonth;
    }

    public void setEmiPerMonth(double emiPerMonth) {
        this.emiPerMonth = emiPerMonth;
    }

    public double getRoi() {
        return roi;
    }

    public double getOutstanding() {
        return outstandingPrincipal;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }
    public void calculateEmi()
    {
        roi = roi/(12*100);
        tenure = tenure * repaymentFrequency;
        emiPerMonth = (getLoanAmount()*roi*Math.pow(1+roi,tenure))/(Math.pow(1+roi,tenure)-1);
        System.out.println("EMI IS " + emiPerMonth);
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }
    public void generateRepaymentSchedule() {
        double Opn = loanAmount, intrestCompoennt = 0, principalComponent = 0;
        for (int i = 1; i <= tenure; i++) {
            System.out.println(i);
            System.out.println("Outstanding Principal " + Opn);
            intrestCompoennt = Opn * (roi) * (1 / repaymentFrequency);
            principalComponent = emiPerMonth - intrestCompoennt;
            Opn = Opn - principalComponent;
            System.out.println("intrest Component " + intrestCompoennt);
            System.out.println("principal Component " + principalComponent);

            EMI emi = new EMI(emiPerMonth, this.disbursalDate.plusMonths(i), loanAmount, interestComponent, penalty);
        }
    }

    public double latePayment(){
        int days = (int) ChronoUnit.DAYS.between(disbursalDate, date);
        penalty =  days * perDayPenalty;
        return penalty;
    }
    public void showLatePayment()
    {
        System.out.println(penalty);
    }
    @Override
    public String toString() {
        return "Loan{" +
                "tenure=" + tenure +
                ", repaymentFrequency=" + repaymentFrequency +
                ", loanType='" + loanType + '\'' +
                ", customer=" + customer +
                ", loanAmount=" + loanAmount +
                ", roi=" + roi +
                ", emi=" + emi +
                '}';
    }

}
