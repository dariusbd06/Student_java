import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // --- LABORATOR 2 (Rămâne neschimbat) ---
        Set<Student> setStudenti = new HashSet<>();
        setStudenti.add(new Student("573", "Darius", "Blanaru", "C"));
        setStudenti.add(new Student("100", "Ion", "Ionescu", "TI21/1"));

        Student s1 = new Student("573", "darius", "Blanaru", "C");
        System.out.println("Student prezent: " + setStudenti.contains(s1));
        System.out.println("--------------------------------------------------\n");

        // --- LABORATOR 3 (Exercițiul 3.5.2) ---
        List<Student> listaStudentiFisier = new ArrayList<>();
        try {
            // Citire
            List<String> linii = Files.readAllLines(Paths.get("studenti_in.txt"));
            for (String linie : linii) {
                String[] campuri = linie.split(",");
                if (campuri.length == 4) {
                    listaStudentiFisier.add(new Student(
                            campuri[0].trim(), campuri[1].trim(),
                            campuri[2].trim(), campuri[3].trim()
                    ));
                }
            }

            // Sortare 3.5.2 (după nume)
            Collections.sort(listaStudentiFisier, Comparator.comparing(s -> s.nume));

            List<String> deSalvat352 = new ArrayList<>();
            for (Student s : listaStudentiFisier) {
                deSalvat352.add(s.toString());
            }
            Files.write(Paths.get("studenti_out.txt"), deSalvat352);
            System.out.println("Pas  finalizat (studenti_out.txt)");

            // --- TEMA DE CASĂ 3.5.3 (Sortare dublă) ---
            Collections.sort(listaStudentiFisier, Comparator
                    .comparing(Student::getFormațieDeStudiu)
                    .thenComparing(s -> s.nume));

            List<String> deSalvatTema = new ArrayList<>();
            for (Student s : listaStudentiFisier) {
                deSalvatTema.add(s.toString());
            }
            Files.write(Paths.get("studenti_out_sorted.txt"), deSalvatTema);
            System.out.println("Pas finalizat (studenti_out_sorted.txt)");

        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}