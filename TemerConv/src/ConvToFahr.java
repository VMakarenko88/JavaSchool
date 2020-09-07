public class ConvToFahr{
private double val;

public ConvToFahr(double celsVal)
{
this.setVal(celsVal * 1.8 + 32);
}


    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
