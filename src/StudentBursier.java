import java.util.Objects;

public class StudentBursier extends Student {
    private double cuantumBursa;

    public StudentBursier(String matricol, String prenume, String nume, String grupa, double nota, double cuantumBursa) {
        super(matricol, prenume, nume, grupa);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + " | Bursă: " + cuantumBursa + " RON";
    }
}