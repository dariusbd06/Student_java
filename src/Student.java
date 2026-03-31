import java.util.Objects;

public class Student {
    private String numărMatricol;
    private String prenume;
    public String nume;
    private String formațieDeStudiu;


    private double nota;

    public Student(String numărMatricol, String prenume, String nume, String formațieDeStudiu) {
        this.numărMatricol = numărMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formațieDeStudiu = formațieDeStudiu;
    }

    public String getNumărMatricol() { return numărMatricol; }
    public String getFormațieDeStudiu() { return formațieDeStudiu; }


    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getPrenume() {
        return prenume;
    }

    public double getNota() {
        return nota;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(numărMatricol, student.numărMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numărMatricol);
    }


    @Override
    public String toString() {
        return "Matricol: " + numărMatricol + " | Nume: " + nume + " " + prenume +
                " | Grupa: " + formațieDeStudiu + " | Nota: " + nota;
    }
}