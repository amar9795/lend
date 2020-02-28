public class Personalloan extends Unsecuredloan { String qualification;
    double workExperience;
    double Salary;

    public Personalloan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String qualification, double workExperience, double Salary, Customer customer) {
        super(tenure, repaymentFrequency, loanType, loanAmount, roi);
        this.qualification = qualification;
        this.workExperience = workExperience;
        this.Salary=Salary;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Personalloan{" +
                "qualification='" + qualification + '\'' +
                ", workExperience='" + workExperience + '\'' +
                '}';
    }
}
