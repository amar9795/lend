import java.time.LocalDate;

public class EMI {double emiAmount;
    LocalDate emiDueDate;
    double principalComponent;
    enum StatsOfEmi{Paid,Due};
    static StatsOfEmi statsofEmi;
    double intrestComponent;
    double penalty;
    Customer cust=new Customer("Abc", LocalDate.parse("1995-12-11"),"sadcdadwe","ajsgajkhk",45000, "asdf", 121212);
    public EMI(double emiAmount, LocalDate emiDueDate, double principalComponent, double intrestComponent, double penalty) {
        this.emiAmount = emiAmount;
        this.emiDueDate = emiDueDate;
        this.principalComponent = principalComponent;
        this.intrestComponent = intrestComponent;
        this.penalty = penalty;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public LocalDate getEmiDueDate() {
        return emiDueDate;
    }

    public void setEmiDueDate(LocalDate emiDueDate) {
        this.emiDueDate = emiDueDate;
    }

    public double getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(double principalComponent) {
        this.principalComponent = principalComponent;
    }

    public static StatsOfEmi getStatsofEmi() {
        return statsofEmi;
    }

    public static void setStatsofEmi(StatsOfEmi statsofEmi) {
        EMI.statsofEmi = statsofEmi;
    }

    public double getIntrestComponent() {
        return intrestComponent;
    }

    public void setIntrestComponent(double intrestComponent) {
        this.intrestComponent = intrestComponent;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }


    @Override
    public String toString() {
        return "EMI{" +
                "emiAmount=" + emiAmount +
                ", emiDueDate=" + emiDueDate +
                ", principalComponent=" + principalComponent +
                ", intrestComponent=" + intrestComponent +
                ", penalty=" + penalty +
                '}';
    }
}
