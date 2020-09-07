
public class Main {

    public static void main(String[] args)
    {

        Circle crcl = new Circle(10);
        double crclPer = crcl.Perimeter();
        double crclSqr = crcl.Square();
        System.out.println(" Длина окружности равна " + crclPer );
        System.out.println(" Площадь круга равна " + crclSqr );

        Triangle tr = new Triangle(2,3,4);
        double trPer = tr.Perimeter();
        double trSqr = tr.Square();
        System.out.println(" Периметр треугольника равен " + trPer );
        System.out.println(" Площадь треугольника равна " + trSqr );

        Square sq = new Square(2);
        double sqPer = sq.Perimeter();
        double sqSqr = sq.Square();
        System.out.println(" Периметр квадрата равен " + sqPer );
        System.out.println(" Площадь квадрата равна " + sqSqr );

        Rect rct = new Rect(2, 3);
        double rctPer = rct.Perimeter();
        double rctSqr = rct.Square();
        System.out.println(" Периметр прямоугольника равен " + rctPer );
        System.out.println(" Площадь прямоугольника равна " + rctSqr );

    }
}

abstract class Figure
{
    private int anglesCount;

    public int getAnglesCount() {
        return anglesCount;
    }

    public void setAnglesCount(int anglesCount) {
        this.anglesCount = anglesCount;
    }

    public abstract double Square();
    public abstract double Perimeter();

}

class Circle extends Figure
{
    public Circle(double rad)
    {
        setAnglesCount(0);
        setR(rad);
    }

    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double Perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double Square() {
        return Math.PI * r * r;
    }
}

class Triangle extends Figure
{

    private double a;
    private double b;
    private double c;

    public Triangle(double s1, double s2, double s3)
    {
        setAnglesCount(3);
        setA(s1);
        setB(s2);
        setC(s3);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    private boolean IsTriangleCorrect()
    {
        if ((a + b >= c) &&  (a + c >= b) && (b + c >= a))
            return  true;
        return false;

    }

    @Override
    public double Perimeter() {
        return (a + b + c);
    }

    @Override
    public double Square() {
        double p2 = Perimeter()/2;
        if (IsTriangleCorrect())
            return Math.sqrt(p2 * (p2 - a) * (p2 - b) * (p2 - c)) ;
        return 0;
    }
}

class Square extends Figure
{
    private double a;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Square(double s)
    {
        setAnglesCount(4);
        setA(s);
    }

    @Override
    public double Perimeter() {
        return (4 * a);
    }

    @Override
    public double Square() {
        return a * a;
    }
}

class Rect extends Figure{

    private double a;
    private double b;

    public Rect(double s1, double s2)
    {
        setAnglesCount(4);
        setA(s1);
        setB(s2);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }



    @Override
    public double Perimeter() {
        return (2 * (a + b));
    }

    @Override
    public double Square() {
        return a * b;
    }

}