public class Vehicleloan extends Securedloan{
    String vehicleCategory;
    String vehicleModelNo;
    String manufacturer;
    double assetvalue;

    public Vehicleloan(int tenure, int repaymentFrequency, String loanType, double loanAmount, double roi, String vehicleCategory, String vehicleModelNo, String manufacturer, double assetvalue, Customer customer) {
        super(tenure, repaymentFrequency, loanType, loanAmount, roi);
        this.vehicleCategory = vehicleCategory;
        this.vehicleModelNo = vehicleModelNo;
        this.manufacturer = manufacturer;
        this.assetvalue = assetvalue;
    }



    @Override
    public double calculateLoanToValueRatio() {
        return 0;
    }


    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleModelNo() {
        return vehicleModelNo;
    }

    public void setVehicleModelNo(String vehicleModelNo) {
        this.vehicleModelNo = vehicleModelNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getAssetvalue() {
        return assetvalue;
    }

    public void setAssetvalue(double assetvalue) {
        this.assetvalue = assetvalue;
    }

    @Override
    public String toString() {
        return "Vehicleloan{" +
                "vehicleCategory='" + vehicleCategory + '\'' +
                ", vehicleModelNo='" + vehicleModelNo + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", assetvalue=" + assetvalue +
                '}';
    }
}
