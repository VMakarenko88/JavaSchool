public class ConvToKelvin {
    private double val;
    public ConvToKelvin(double celsVal){
        this.setVal(celsVal + 273.15);
    }
    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}

