import java.util.Objects;

public class Student {
    private String numărMatricol;
    private String prenume;
    private String nume;
    private String formațieDeStudiu;

    public Student(String numărMatricol, String prenume, String nume, String formațieDeStudiu) {
        this.numărMatricol = numărMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formațieDeStudiu = formațieDeStudiu;
    }

    // Metode necesare pentru cautarea O(1) in HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formațieDeStudiu, student.formațieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formațieDeStudiu);
    }

    @Override
    public String toString() {
        return "Student { Matricol: " + numărMatricol + ", Nume: " + nume + " " + prenume + " }";
    }
}