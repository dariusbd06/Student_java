import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab9Studenti {

    public static void main(String[] args) {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        // a) Studenti cu nota 10
        System.out.println("=== a) Studenti cu nota 10 ===");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(System.out::println);

        // b) Studenti cu nota sub 5
        System.out.println("\n=== b) Studenti cu nota sub 5 ===");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(System.out::println);

        // c) Studenti cu nota < 4 devin nota 4
        System.out.println("\n=== c) Lista cu nota minima 4 ===");
        List<Student> listaCorectata = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4) {
                        s.setNota(4);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        listaCorectata.forEach(System.out::println);

        // d) Suma notelor
        double sumaNote = studentiCuNote.stream()
                .mapToDouble(Student::getNota)
                .sum();
        System.out.println("\n=== d) Suma notelor: " + sumaNote + " ===");

        // e) Media notelor
        double media = sumaNote / studentiCuNote.size();
        System.out.println("=== e) Media notelor: " + media + " ===");
    }
}