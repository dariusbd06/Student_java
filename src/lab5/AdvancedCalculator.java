package lab5;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int state) {
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        if (value != 0) this.state /= value;
        return this;
    }

    public AdvancedCalculator power(int p) {
        this.state = (int) Math.pow(this.state, p);
        return this;
    }

    public AdvancedCalculator root(int n) {
        this.state = (int) Math.pow(this.state, 1.0 / n);
        return this;
    }
}