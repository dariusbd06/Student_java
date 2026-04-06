package lab5;

public class AppLab5 {
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);
        int res1 = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) Rezultat IntCalculator: " + res1);

        AdvancedCalculator adv = new AdvancedCalculator(10);
        int res2 = adv.divide(4).power(2).root(2).result();
        System.out.println("b) Rezultat AdvancedCalculator: " + res2);
    }
}