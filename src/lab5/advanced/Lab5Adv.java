package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator iCalc = new NewIntCalculator(10);
        int resI = (Integer) iCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("5.5.2 Int: " + resI);

        DoubleCalculator dCalc = new DoubleCalculator(10.0);
        double resD = (Double) dCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("5.5.2 Double: " + resD);
    }
}