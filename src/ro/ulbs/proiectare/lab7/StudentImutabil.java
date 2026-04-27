package ro.ulbs.proiectare.lab7;

import java.util.Objects;

public final class StudentImutabil {
    private final String numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final double nota;

    public StudentImutabil(String numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public String getNumarMatricol() { return numarMatricol; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public double getNota() { return nota; }

    // Returneaza un student NOU cu formatia schimbata (nu modifica obiectul curent!)
    public StudentImutabil mutaInFormatie(String nouaFormatie) {
        return new StudentImutabil(numarMatricol, prenume, nume, nouaFormatie, nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentImutabil student = (StudentImutabil) o;
        return Objects.equals(numarMatricol, student.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

    @Override
    public String toString() {
        return "Matricol: " + numarMatricol + " | Nume: " + nume + " " + prenume +
                " | Grupa: " + formatieDeStudiu + " | Nota: " + nota;
    }
}
//
